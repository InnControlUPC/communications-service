package com.github.inncontrol.communications;

import com.github.inncontrol.shared.application.internal.outboundedservices.acl.ExternalEmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackageClasses = {
        ExternalEmployeeService.class
})
@EnableHystrix
public class CommunicationsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommunicationsServiceApplication.class, args);
    }

}
