package com.atguigu.boot.config;

import com.atguigu.boot.bean.Car;
import com.atguigu.boot.bean.Pet;
import com.atguigu.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration(proxyBeanMethods = true)//声明是配置类
@ConditionalOnMissingBean(name = "tom")
@EnableConfigurationProperties(Car.class)//自动将Car注入ioc容器
public class MyConfig {
   @Bean
    public User user01(){
       User 指尖 = new User("指尖", 22);
       指尖.setPet(tomcatPet());
        return 指尖;
   }
   @Bean("tom")
    public Pet tomcatPet(){
       return  new Pet("tomcat");
   }
}
