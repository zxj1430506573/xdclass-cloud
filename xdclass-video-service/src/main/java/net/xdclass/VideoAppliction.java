package net.xdclass;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("net.xdclass.dao")
@EnableDiscoveryClient
public class VideoAppliction {
    public static void main(String[] args) {
        SpringApplication.run(VideoAppliction.class,args);
    }
}
