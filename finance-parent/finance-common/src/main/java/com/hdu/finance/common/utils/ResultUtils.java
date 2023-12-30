package com.hdu.finance.common.utils;

import com.hdu.finance.common.domain.common.Result;

import java.util.HashMap;
import java.util.Map;

public class ResultUtils {
    /**
     * 获取data返回集合
     */
    public Map<String,Object> getData(Result result){
        return (HashMap<String,Object>)result.getData();
    }
}
