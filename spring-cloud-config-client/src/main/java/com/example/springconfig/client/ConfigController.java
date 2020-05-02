package com.example.springconfig.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigController {
	  @Value("${welcome.message:Config Server is not working. Please check...}")
	    private String msg;
	 
	    @GetMapping("/msg")
	    public String getMsg() {
	        return this.msg;
	    }
}
