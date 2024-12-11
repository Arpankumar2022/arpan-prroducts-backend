package com.arpanbags.redisconfig.arpanbagsredisconfig.service;

import com.arpanbags.redisconfig.arpanbagsredisconfig.entity.RedisPerson;
import com.arpanbags.redisconfig.arpanbagsredisconfig.repository.RedisPersonRepository;

import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RedisService {

    private static final String HASH_KEY = "RedisPerson";

    private final RedisPersonRepository redisPersonRepository;

    //@CachePut(value = "redis-person")
    public RedisPerson save(RedisPerson redisPerson) {
        //template.opsForHash().put(HASH_KEY, order.getId(), order);
        return redisPersonRepository.save(redisPerson);
    }


    @Cacheable(value = "redis-person")
    public List<RedisPerson> findAllMethod() {
        //return template.opsForHash().values(HASH_KEY);
        redisPersonRepository.findAll().stream().forEach(obj -> {
            System.out.println(obj);
        });
        return redisPersonRepository.findAll();
    }

    @Cacheable(value = "redis-person", key = "#id")
    public RedisPerson findRedisPersonById(Long id) {
        // return (RedisPerson) template.opsForHash().get(HASH_KEY, id);
        System.out.println("Value");
        return redisPersonRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Not Found", id));
    }

    @CacheEvict(value = "redis-person", key = "#id")
    public String deleteRedisPerson(Long id) {
        //   template.opsForHash().delete(HASH_KEY, id);
        redisPersonRepository.deleteById(id);
        return "RedisPerson deleted successfully!";
    }

}
