package com.hdu.finance.service.impl;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdu.finance.common.domain.common.PageDTO;
import com.hdu.finance.common.domain.po.Fund;
import com.hdu.finance.common.domain.query.FundQuery;
import com.hdu.finance.common.domain.vo.FundVo;
import com.hdu.finance.mapper.FundMapper;
import com.hdu.finance.service.FundService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author vvc
 * @since 2023-10-31
 */
@Service
public class FundServiceImpl extends ServiceImpl<FundMapper, Fund> implements FundService {

    @Override
    public PageDTO<FundVo> queryFundPage(FundQuery query) {
        Page<Fund> page = lambdaQuery().like(StrUtil.isNotBlank(query.getChiNameAbbr()), Fund::getChiNameAbbr, query.getChiNameAbbr())
                .eq(StrUtil.isNotBlank(query.getFundCode()), Fund::getFundCode, query.getFundCode())
                .eq(StrUtil.isNotBlank(query.getFundType()), Fund::getFundType, query.getFundType())
                .page(query.toMpPage("one_year_profit", false));
        return PageDTO.of(page, FundVo.class);
    }
}
