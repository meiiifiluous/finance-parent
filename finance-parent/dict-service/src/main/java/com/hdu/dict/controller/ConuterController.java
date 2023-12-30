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
    private RedisTemplate<String, String> redisTemplate;

    @ApiOperation("关闭柜台")
    @Log(title = "关闭柜台")
    @PostMapping("/closeCounter")
    public Result CloseCounter() {
        String counter = redisTemplate.opsForValue().get("counter");
        if (counter.equals("1")) {
            redisTemplate.opsForValue().set("counter", String.valueOf(0));
            return Result.build(null, ResultCodeEnum.SUCCESS);
        }else return Result.build(null,100,"柜台已关闭");
    }
    @ApiOperation("开启柜台")
    @Log(title = "开启柜台")
    @PostMapping("activateCounter")
    public Result ActivateCounter(){
        String counter = redisTemplate.opsForValue().get("counter");
        if (counter.equals("0")) {
            redisTemplate.opsForValue().set("counter", String.valueOf(1));
            return Result.build(null,200,"开启柜台！");
        }else return Result.build(null,100,"柜台已开启");
    }
}
