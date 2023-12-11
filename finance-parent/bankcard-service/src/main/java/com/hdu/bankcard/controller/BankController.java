package com.hdu.bankcard.controller;


import com.hdu.finance.common.domain.vo.BankVo;
import com.hdu.bankcard.service.BankService;
import com.hdu.finance.common.domain.common.Result;
import com.hdu.finance.common.domain.common.ResultCodeEnum;
import com.hdu.finance.common.utils.BeanUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author vvc
 * @since 2023-11-01
 */
@RestController
@RequestMapping("/bank")
@Api(tags = "银行信息管理")
public class BankController {
    @Resource
    private BankService bankService;
    @ApiOperation(value = "银行列表")
    @GetMapping("/list")
    public Result list(){
        List<BankVo> list = bankService.list().stream()
                .map(bank -> BeanUtils.copyBean(bank, BankVo.class))
                .collect(Collectors.toList());
        return Result.build(list, ResultCodeEnum.SUCCESS);
    }
}
