package me.prosight.controller;


import me.prosight.feign.UserFeignClient;
import me.prosight.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by elton on 2017/2/28.
 *
 */
@RestController
public class FeignController {
    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("feign/{id}")
    public User findByIdFeign(@PathVariable Long id) {
        User user = this.userFeignClient.findByIdFeign(id);
        return user;
    }
}