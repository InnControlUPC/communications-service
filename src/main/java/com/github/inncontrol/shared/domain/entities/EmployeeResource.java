package com.github.inncontrol.shared.domain.entities;

import java.util.Date;

/**
 * Created by Alex Avila Asto - A.K.A (Ryzeon)
 * Project: inncontrol-backend
 * Date: 6/18/25 @ 11:10
 */
public record EmployeeResource(
        Long employeeId,
        Double salary,
        Date initiationContract,
        Date terminationContract,
        Long profileId
) {
}