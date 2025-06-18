package com.github.inncontrol.shared.application.internal.outboundedservices.acl;

import com.github.inncontrol.shared.domain.entities.EmployeeResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by Alex Avila Asto - A.K.A (Ryzeon)
 * Project: inncontrol-backend
 * Date: 6/18/25 @ 11:08
 */
@Component
public class EmployeeClientFallback implements ExternalEmployeeService {

    @Override
    public ResponseEntity<EmployeeResource> getEmployeeByQuery(Map<String, String> queries) {
        // Fallback logic when the employee service is unavailable
        // You can return a default response or throw an exception
        return ResponseEntity.status(503).body(new EmployeeResource(
                0L,
                0.0,
                null,
                null,
                0L));
    }
}
