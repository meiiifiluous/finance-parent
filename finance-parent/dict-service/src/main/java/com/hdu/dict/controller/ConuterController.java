package com.hdu.dict.controller;

import com.hdu.finance.common.annotion.Log;
import com.hdu.finance.common.domain.common.Result;
import com.hdu.finance.common.domain.common.ResultCodeEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/counter")
@Api(tags = "柜台接口")
public class ConuterController {
    @Resource
    private RedisTemplate<String ,String > redisTemplate;
    @ApiOperation("更改柜台状态")
    @Log(title = "关闭柜台")
    @PostMapping
    public Result changeCounterStatus(){
        redisTemplate.opsForValue().set("counter",String.valueOf(0));
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }
}
