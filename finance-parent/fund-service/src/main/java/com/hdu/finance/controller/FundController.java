package com.hdu.finance.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hdu.finance.common.domain.common.PageDTO;
import com.hdu.finance.common.domain.common.Result;
import com.hdu.finance.common.domain.common.ResultCodeEnum;
import com.hdu.finance.common.utils.BeanUtils;
import com.hdu.finance.common.domain.dto.FundFormDto;
import com.hdu.finance.common.domain.dto.FundUpdateDto;
import com.hdu.finance.common.domain.po.Fund;
import com.hdu.finance.common.domain.query.FundQuery;
import com.hdu.finance.common.domain.vo.FundVo;
import com.hdu.finance.service.FundService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author vvc
 * @since 2023-10-31
 */
@RestController
@RequestMapping("/api/fund")
@Api(tags = "基金管理接口")
public class FundController {
    @Resource
    private FundService fundService;

    @ApiOperation("条件分页查询基金列表")
    @GetMapping("/page")
    public Result getFundProductList(FundQuery query) {
        PageDTO<FundVo> fundPage = fundService.queryFundPage(query);
        return Result.build(fundPage, ResultCodeEnum.SUCCESS);
    }

    @ApiOperation("新增基金")
    @PostMapping("/save")
    public Result addFundProduct(@RequestBody FundFormDto fundFormDto) {
        LambdaQueryWrapper<Fund> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Fund::getFundCode, fundFormDto.getFundCode());
        if (fundService.count(queryWrapper) > 0) {
            return Result.build(null, ResultCodeEnum.FUND_CODE_IS_EXISTS);
        }
        boolean result = fundService.save(BeanUtils.copyBean(fundFormDto, Fund.class));
        if (result) {
            return Result.build(null, ResultCodeEnum.SUCCESS);
        } else return Result.build(null, ResultCodeEnum.SAVE_ERROR);
    }

    @ApiOperation("修改基金信息")
    @PutMapping("/update")
    public Result editFundProduct(@RequestBody FundUpdateDto fundUpdateDto) {
        boolean result = fundService.updateById(BeanUtils.copyBean(fundUpdateDto, Fund.class));
        if (result) {
            return Result.build(null, ResultCodeEnum.SUCCESS);
        } else {
            return Result.build(null, 201, "跟新失败");
        }
    }

    @ApiOperation("删除基金")
    @DeleteMapping("/delete/{id}")
    public Result deleteFundProduct(@PathVariable Long id) {
        fundService.removeById(id);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }

    @ApiOperation("获取基金产品的详细信息")
    @GetMapping("/get/{id}")
    public Result getFundProductDetails(@PathVariable Long id) {
        Fund fund = fundService.getById(id);
        if (fund == null) {
            return Result.build(null, ResultCodeEnum.FUND_IS_NOT_EXISTS);
        } else
            return Result.build(BeanUtils.copyBean(fund, FundVo.class), ResultCodeEnum.SUCCESS);
    }
    @ApiOperation("获取所有基金")
    @GetMapping("/list")
    public Result getAllFund(){
        List<Fund> list = fundService.list();
        System.out.println(list);
        return Result.build(BeanUtils.copyList(list,FundVo.class), ResultCodeEnum.SUCCESS);
    }
}
