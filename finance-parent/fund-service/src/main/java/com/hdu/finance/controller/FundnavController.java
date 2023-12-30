package com.hdu.finance.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hdu.finance.common.domain.common.Result;
import com.hdu.finance.common.domain.common.ResultCodeEnum;
import com.hdu.finance.common.utils.BeanUtils;
import com.hdu.finance.common.domain.po.Fundnav;
import com.hdu.finance.common.domain.vo.FundnavVo;
import com.hdu.finance.common.domain.vo.HistoryNetvalue;
import com.hdu.finance.service.FundService;
import com.hdu.finance.service.FundnavService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.bouncycastle.tsp.TSPUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author vvc
 * @since 2023-10-31
 */
@RestController
@RequestMapping("/api/fundnav")
@Api(tags = "基金收益信息管理")
public class FundnavController {
    @Resource
    private FundnavService fundnavService;
    @Resource
    private FundService fundService;

    @ApiOperation("新增基金收益")
    @PostMapping()
    public Result add(@RequestBody Fundnav fundnav) {
        fundnavService.save(fundnav);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }

    @ApiOperation("获取基金收益信息")
    @GetMapping("/get/{id}")
    public Result getFundnav(@PathVariable Long id) {
        String fundCode = fundService.getById(id).getFundCode();
        BigDecimal oneWeekProfit = fundService.getById(id).getOneWeekProfit();
        //拿出最新的一条数据
        LambdaQueryWrapper<Fundnav> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Fundnav::getFundCode, fundCode)
                .orderByDesc(Fundnav::getCurrDate)
                .last("LIMIT 1");
        Fundnav fundnav = fundnavService.getOne(queryWrapper);
        FundnavVo fundnavVo = BeanUtils.copyBean(fundnav, FundnavVo.class);
        //设置近一周涨跌幅
        fundnavVo.setOneWeekReturn(oneWeekProfit);
        //历史净值列表
        List<HistoryNetvalue> list = fundnavService.lambdaQuery()
                .eq(Fundnav::getFundCode, fundCode)
                .orderByDesc(Fundnav::getCurrDate)
                .select(Fundnav::getCurrDate, Fundnav::getNetvalue, Fundnav::getTotalNetvalue, Fundnav::getPercent)
                .list().stream().map(fundnav1 -> BeanUtils.copyBean(fundnav1, HistoryNetvalue.class))
                .collect(Collectors.toList());
        fundnavVo.setHistoryNetvalueList(list);
        System.out.println(fundnavVo);
        return Result.build(fundnavVo, ResultCodeEnum.SUCCESS);
    }

}
