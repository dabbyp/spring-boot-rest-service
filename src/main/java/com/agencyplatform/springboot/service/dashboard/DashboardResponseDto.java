package com.agencyplatform.springboot.service.dashboard;

import lombok.Getter;

import java.math.BigInteger;

@Getter
public class DashboardResponseDto {
    private BigInteger userCount;
    private BigInteger partnerCount;
    private BigInteger userLoginRatio;
    private BigInteger partnerLoginRatio;

    public DashboardResponseDto(BigInteger userCount, BigInteger partnerCount, BigInteger userLoginRatio, BigInteger partnerLoginRatio){
        this.userCount = userCount;
        this.partnerCount = partnerCount;
        this.userLoginRatio = userLoginRatio;
        this.partnerLoginRatio = partnerLoginRatio;
    }

}
