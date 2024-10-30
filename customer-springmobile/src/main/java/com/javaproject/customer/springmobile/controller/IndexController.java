package com.javaproject.customer.springmobile.controller;

import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
    String deviceType = "browser";
    String platform = "browser";
    String viewName = "index";
    
    @GetMapping("/")
    public String greeting(Device device) {

        if (device.isNormal()) {
            deviceType = "browser";
        } else if (device.isMobile()) {
            deviceType = "mobile";
            viewName = "mobile/index";
        } else if (device.isTablet()) {
            deviceType = "tablet";
            viewName = "tablet/index";
        }
        
        platform = device.getDevicePlatform().name();
        
        if (platform.equalsIgnoreCase("UNKNOWN")) {
            platform = "browser";
        }
     	
        return viewName;
    }
}
