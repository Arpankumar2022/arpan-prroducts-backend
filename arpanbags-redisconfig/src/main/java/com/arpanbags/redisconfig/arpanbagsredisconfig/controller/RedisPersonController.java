package com.arpanbags.redisconfig.arpanbagsredisconfig.controller;


import com.arpanbags.redisconfig.arpanbagsredisconfig.entity.RedisPerson;
import com.arpanbags.redisconfig.arpanbagsredisconfig.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RedisPersonController {

    private final RedisService redisService;

    @PostMapping("/save")
    public RedisPerson save(@RequestBody RedisPerson RedisPerson) {
        return redisService.save(RedisPerson);
    }

    @GetMapping("/findAll")
    public List<RedisPerson> findAll() {
        return redisService.findAllMethod();
    }

    @GetMapping("/findById/{id}")
    public RedisPerson findById(@PathVariable Long id) {
        return redisService.findRedisPersonById(id);
    }

    @DeleteMapping("/remove/{id}")
    public String remove(@PathVariable Long id) {
        return redisService.deleteRedisPerson(id);
    }

}
