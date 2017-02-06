package me.prosigt.user.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import me.prosigt.user.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by elton on 2017/2/6.
 * 使用@HystrixCommand注解指定当该方法发生异常时调用的方法
 * @return 通过id查询到的用户
 */

@Service
public class RibbonHystrixService {
    @Autowired
    private RestTemplate restTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(RibbonHystrixService.class);

    /**
     * 使用@HystrixCommand注解指定当该方法发生异常时调用的方法
     * @param id id
     * @return 通过id查询到的用户
     */
    @HystrixCommand(fallbackMethod = "fallback")
    public User findById(Long id) {
        return this.restTemplate.getForObject("http://microservice-provider-user/" + id, User.class);
    }

    /**
     * hystrix fallback方法
     * @param id id
     * @return 默认的用户
     */
    public User fallback(Long id) {
        RibbonHystrixService.LOGGER.info("异常发生，进入fallback方法，接收的参数：id = {}", id);
        User user = new User();
        user.setId(-1L);
        user.setUsername("default username");
        user.setAge(0);
        return user;
    }
}