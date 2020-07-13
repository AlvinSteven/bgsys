package com.vuetests.bgsys.config;

import com.vuetests.bgsys.interceptor.LoginInterceptor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.*;

@SpringBootConfiguration
public class MyWebConfigurer implements WebMvcConfigurer {

    @Bean
    public LoginInterceptor getLoginIntercepter() {
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getLoginIntercepter()).addPathPatterns("/**").excludePathPatterns("/login.html");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 切换本地/服务器
//        String resLoc = "file:" + "C:/Users/Alvin/Pictures/img-nuts/";
        String resLoc = "file:" + "C:/Users/Administrator/Pictures/img-nuts/";
        System.out.println("测试 --> addResourceHandlers, resLoc=" + resLoc);
        registry.addResourceHandler("/api/file/**").addResourceLocations(resLoc);
    }
}
