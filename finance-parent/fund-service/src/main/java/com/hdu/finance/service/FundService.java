package com.hdu.finance.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hdu.finance.common.domain.common.PageDTO;
import com.hdu.finance.common.domain.po.Fund;
import com.hdu.finance.common.domain.query.FundQuery;
import com.hdu.finance.common.domain.vo.FundVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author vvc
 * @since 2023-10-31
 */
public interface FundService extends IService<Fund> {

    PageDTO<FundVo> queryFundPage(FundQuery query);
}
