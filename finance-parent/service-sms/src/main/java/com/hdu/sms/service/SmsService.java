package com.hdu.sms.service;

import com.hdu.finance.common.domain.common.Result;

import java.util.Map;

public interface SmsService {
    Result send(String mobile, Map<String,String> param);
}
