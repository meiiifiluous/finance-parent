package com.hdu.customer.controller;


import cn.hutool.core.util.StrUtil;
import com.alibaba.nacos.shaded.org.checkerframework.dataflow.qual.Pure;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.hdu.finance.common.annotion.CounterValidation;
import com.hdu.finance.common.annotion.Log;
import com.hdu.finance.common.domain.common.PageDTO;
import com.hdu.finance.common.domain.dto.CodeDto;
import com.hdu.finance.common.domain.dto.CustomerDto;
import com.hdu.finance.common.domain.dto.CustomerUpdateDto;
import com.hdu.finance.common.domain.po.Customer;
import com.hdu.finance.common.domain.query.CustomerQuery;
import com.hdu.finance.common.domain.vo.CustomerVo;
import com.hdu.customer.service.CustomerService;
import com.hdu.finance.common.domain.common.Result;
import com.hdu.finance.common.domain.common.ResultCodeEnum;
import com.hdu.finance.common.exception.BusinessException;
import com.hdu.finance.common.utils.BeanUtils;
import io.netty.util.NetUtil;
import io.netty.util.internal.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author vvc
 * @since 2023-11-01
 */
@RestController
@RequestMapping("/customer")
@Api(tags = "用户管理")
@CounterValidation
public class CustomerController {
    @Resource
    private CustomerService customerService;
    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Log(title = "开户")
    @ApiOperation("开户")
    @PostMapping("/add")
    public Result addCustomer(@RequestBody CustomerDto customerDto) {
        String email = customerDto.getEmail();
//        if (StrUtil.isEmpty(email)) {
//            return Result.build(null, 204, "邮箱为空");
//        }
//        Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(.[a-zA-Z0-9_-]+)+$");
//        Matcher emailMatcher = emailPattern.matcher(email);
//        if (!emailMatcher.matches()) {
//            return Result.build(null, 205, "邮箱格式错误");
//        }
        String mobile = customerDto.getMobile();
        if (StrUtil.isEmpty(mobile)) {
            return Result.build(null, 206, "手机号码为空");
        }
        Pattern mobliePattern = Pattern.compile("^(13[0-9]|14[579]|15[0-35-9]|17[013-8]|18[0-9]|19[89])\\d{8}$");
        Matcher mobileMatcher = mobliePattern.matcher(mobile);
        if (!mobileMatcher.matches()) {
            return Result.build(null, 207, "手机格式错误");
        }
        if (StrUtil.isEmpty(customerDto.getIdentityNumber())) {
            return Result.build(null, 208, "证件号码为空");
        }
        String identityTyper = customerDto.getIdentityTyper();
        if (identityTyper.equals("1")) {
            //居民身份证
            Pattern identityPattern = Pattern.compile("^[1-9]\\d{5}(19|20)\\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\\d{3}[Xx\\d]$");
            Matcher identityMatcher = identityPattern.matcher(customerDto.getIdentityNumber());
            if (!identityMatcher.matches()) {
                return Result.build(null, 209, "身份证格式错误");
            }
        }
        if (StrUtil.isEmpty(customerDto.getRealName())) {
            return Result.build(null, 210, "姓名为空！");
        }
        //生成customerId
        String uuid = UUID.randomUUID().toString();
        String customerId = String.valueOf(Math.abs(uuid.substring(0, 6).hashCode()));

        Customer customer = BeanUtils.copyBean(customerDto, Customer.class);
        customer.setCustomerId(customerId);
        customerService.save(customer);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }

    @Log(title = "通过身份证号码查询单个客户信息")
    @ApiOperation("通过身份证号码查询单个客户信息")
    @GetMapping("/getByIdCard")
    public Result get(@RequestParam("identityNumber") String identityNumber) {
        LambdaQueryWrapper<Customer> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Customer::getIdentityNumber, identityNumber);
        Customer customer = customerService.getOne(queryWrapper);
        if (customer == null) {
            return Result.build(null, 212, "客户不存在");
        }
        CustomerVo customerVo = BeanUtils.copyBean(customer, CustomerVo.class);
        return Result.build(customerVo, ResultCodeEnum.SUCCESS);
    }

    @Log(title = "修改客户信息/修改风险评估")
    @ApiOperation("修改客户信息/修改风险评估")
    @PutMapping("/update")
    public Result editCustomer(@RequestBody CustomerUpdateDto customerDto) {
        customerService.updateById(BeanUtils.copyBean(customerDto, Customer.class));
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }

    @Log(title = "注销客户")
    @ApiOperation("注销客户")
    @DeleteMapping("/delete/{id}")
    public Result cancelCustomer(@PathVariable Long id) {
        customerService.removeById(id);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }

    @Log(title = "根据姓名查询用户信息")
    @ApiOperation("根据姓名查询用户信息")
    @GetMapping("/getByName")
    public Result getByName(@RequestParam String realName) {
        if (StrUtil.isNullOrUndefined(realName)) {
            return Result.build(null, 400, "姓名为空！");
        }
        LambdaQueryWrapper<Customer> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Customer::getRealName, realName);
        Customer customer = customerService.getOne(queryWrapper);
        CustomerDto customerDto = BeanUtils.copyBean(customer, CustomerDto.class);
        return Result.build(customerDto, ResultCodeEnum.SUCCESS);
    }

    @Log(title = "校验手机号是否注册")
    @ApiOperation("校验手机号是否注册")
    @GetMapping("/checkMobile/{mobile}")
    public boolean checkMobile(@PathVariable String mobile) {
        return customerService.checkMobile(mobile);
    }

    @Log(title = "校验验证码")
    @ApiOperation("校验验证码")
    @PostMapping("/checkCode")
    public Result checkCode(@RequestBody CodeDto codeDto) {
        String phone = codeDto.getPhone();
        String code = codeDto.getCode();
        if (StringUtil.isNullOrEmpty(phone) || StringUtil.isNullOrEmpty(code)) {
            return Result.build(null, 501, "不能为空！");
        }
        String key = "finance:sms:code:" + phone;
        String RedisCode = redisTemplate.opsForValue().get(key);
        if (RedisCode == null) {
            return Result.build(null, 503, "请点击发送验证码！");
        }
        if (RedisCode.equals(code)) {
            //redisTemplate.delete(key);
            return Result.build(null, ResultCodeEnum.SUCCESS);
        } else {
            return Result.build(null, 502, "验证码错误！！！");
        }
    }

    @ApiOperation("通过身份证号码查询客户所有信息（系统方法）")
    @GetMapping("/get")
    public Customer getCustomerByIdCard(@RequestParam("identityNumber") String identityNumber) {
        LambdaQueryWrapper<Customer> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Customer::getIdentityNumber, identityNumber);
        Customer customer = customerService.getOne(queryWrapper);
        if (customer == null) {
            throw new BusinessException("客户不存在！");
        }
        return customer;
    }

    @GetMapping("/page")
    public Result page(CustomerQuery query) {
        PageDTO<CustomerVo> customerVoPageDTO = customerService.pageCustomerPage(query);
        return Result.build(customerVoPageDTO, ResultCodeEnum.SUCCESS);
    }

    @ApiOperation("根据id获取客户信息")
    @GetMapping("/get/{id}")
    public Result getCustomer(@PathVariable Long id) {
        Customer customer = customerService.getById(id);
        return Result.build(BeanUtils.copyBean(customer,CustomerVo.class), ResultCodeEnum.SUCCESS);
    }
}
