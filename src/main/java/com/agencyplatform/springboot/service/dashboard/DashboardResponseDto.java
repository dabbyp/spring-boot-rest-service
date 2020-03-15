package com.agencyplatform.springboot.service.dashboard;

import lombok.Getter;

@Getter
public class DashboardResponseDto {
    private Long userCount;
    private Long partnerCount;
    private Long userLoginRatio;
    private Long partnerLoginRatio;


    public DashboardResponseDto(Long userCount, Long partnerCount, Long userLoginRatio, Long partnerLoginRatio){
        this.userCount = userCount;
        this.partnerCount = partnerCount;
        this.userLoginRatio = userLoginRatio;
        this.partnerLoginRatio = partnerLoginRatio;
    }

}
