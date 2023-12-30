package com.hdu.dict.controller;


import com.hdu.finance.common.annotion.CounterValidation;
import com.hdu.finance.common.annotion.Log;
import com.hdu.finance.common.domain.po.Dict;
import com.hdu.finance.common.domain.vo.DictTypeVo;
import com.hdu.dict.service.DictService;
import com.hdu.finance.common.domain.common.Result;
import com.hdu.finance.common.domain.common.ResultCodeEnum;
import com.hdu.finance.common.enums.BusinessType;
import com.hdu.finance.common.utils.BeanUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
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
 * @since 2023-10-31
 */
@RestController
@RequestMapping("/dict")
@Api(tags = "字典接口")
@CounterValidation
public class DictController {
    @Resource
    private DictService dictService;
    @Log(title = "获取基金类型")
    @ApiOperation("获取基金类型")
    @GetMapping("/fund/type/list")
    public Result getFundType(){
        List<DictTypeVo> list = dictService.lambdaQuery().eq(Dict::getCodeCat, "FP.PRODUCT.TYPE.1")
                .select(Dict::getCodeKey, Dict::getCodeVal)
                .list().stream().map(dict -> BeanUtils.copyBean(dict, DictTypeVo.class))
                .collect(Collectors.toList());
        return Result.build(list, ResultCodeEnum.SUCCESS);
    }
    @Log(title = "获取证件类型")
    @ApiOperation("获取证件类型")
    @GetMapping("/certificate/type/list")
    public Result getCERTIFICATEType(){
        List<DictTypeVo> list = dictService.lambdaQuery()
                .eq(Dict::getCodeCat, "FP.CERTIFICATE.TYPE")
                .select(Dict::getCodeKey, Dict::getCodeVal)
                .list().stream().map(dict -> BeanUtils.copyBean(dict, DictTypeVo.class))
                .collect(Collectors.toList());
        return Result.build(list,ResultCodeEnum.SUCCESS);
    }
}
