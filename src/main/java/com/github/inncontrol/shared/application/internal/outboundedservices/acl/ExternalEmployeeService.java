package com.github.inncontrol.shared.application.internal.outboundedservices.acl;

import com.github.inncontrol.shared.domain.entities.EmployeeResource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by Alex Avila Asto - A.K.A (Ryzeon)
 * Project: inncontrol-backend
 * Date: 6/21/24 @ 08:03
 */
@FeignClient(
        name = "employee-service",
        path = "/api/v1/employees",
        fallback = EmployeeClientFallback.class
)
public interface ExternalEmployeeService {

    @GetMapping
    ResponseEntity<EmployeeResource> getEmployeeByQuery(@RequestParam Map<String, String> queries);
}
