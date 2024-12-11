package com.arpanbags.redisconfig.arpanbagsredisconfig.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RedisPerson implements Serializable {
    private static final long serialVersionUID = 214101981905645865L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String redisPersonName;
    private String redisPersonAddress;

    private String redisPersonMobile;

    private Integer redisPersonAge;

}
