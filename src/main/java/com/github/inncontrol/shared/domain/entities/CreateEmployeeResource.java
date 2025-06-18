package com.github.inncontrol.shared.domain.entities;

/**
 * Created by Alex Avila Asto - A.K.A (Ryzeon)
 * Project: inncontrol-backend
 * Date: 6/18/25 @ 11:10
 */
public record  CreateEmployeeResource(String firstName,
                                      String lastName,
                                      String phoneNumber,
                                      String email,
                                      Double salary,
                                      ContractInformationResource contractInformationResource
) {
}