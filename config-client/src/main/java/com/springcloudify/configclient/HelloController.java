package com.springcloudify.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Erasme
 * @version v0.1 2018-02-01 10:52
 */
@RestController
public class HelloController {

    @Value("${info.profile}")
    private String hello;

    @RequestMapping("/hello")
    public String from() {
        return "run env in" + this.hello;
    }
}
