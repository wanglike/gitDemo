package com.example.reactivedemo.repository;

import com.example.reactivedemo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by jack on 2018/4/14 0014.
 */
@Repository
public class UserRepository {

    public final ConcurrentMap<Integer, User> userConcurrentMap = new ConcurrentHashMap<>();

    private final AtomicInteger idGenerate = new AtomicInteger();

    /**
     * 添加用户 @link user
     * @param user
     * @return
     */
    public boolean save(User user) {
        user.setId(idGenerate.decrementAndGet());
        return userConcurrentMap.put(user.getId(), user) == null;
    }

}
