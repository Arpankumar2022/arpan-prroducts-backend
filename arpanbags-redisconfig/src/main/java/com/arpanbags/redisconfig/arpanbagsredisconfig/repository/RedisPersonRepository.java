package com.arpanbags.redisconfig.arpanbagsredisconfig.repository;

import com.arpanbags.redisconfig.arpanbagsredisconfig.entity.RedisPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisPersonRepository extends JpaRepository<RedisPerson, Long> {
}
