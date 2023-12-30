package com.hdu.finance.common.aspectj;

import com.hdu.finance.common.annotion.CounterValidation;
import com.hdu.finance.common.exception.BusinessException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Aspect
@Component
public class CounterValidationAspect {
    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Before("@within(com.hdu.finance.common.annotion.CounterValidation)")
    public void validateCounterStatus() {
        String counter = redisTemplate.opsForValue().get("counter");
        if (counter.equals("0")){
            throw new BusinessException("柜台已关闭!",101);
        }
    }
}
