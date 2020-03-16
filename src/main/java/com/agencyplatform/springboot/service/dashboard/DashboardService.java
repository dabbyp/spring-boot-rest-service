package com.agencyplatform.springboot.service.dashboard;

import lombok.RequiredArgsConstructor;
import org.qlrm.mapper.JpaResultMapper;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;

@RequiredArgsConstructor
@Service
public class DashboardService {
    final String PERSISTENCE_UNIT_NAME = "jpa";
    EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    public DashboardResponseDto getDashboardInfo(){
        EntityManager em = emf.createEntityManager();
        String sql = "select A.CNT as userCount, B.CNT as partnerCount, 0 as userLoginRatio, 0 as partnerLoginRatio from " +
                "(select count(ID) as CNT from AG_USER where ROLE='USER') A, " +
                "(select count(ID) as CNT from AG_USER where ROLE='PARTNER') B";

        Query nativeQuery = em.createNativeQuery(sql);

        JpaResultMapper jpaResultMapper = new JpaResultMapper();
        List<DashboardResponseDto> dashboardResponseDtos = jpaResultMapper.list(nativeQuery, DashboardResponseDto.class);
        em.close();

        return dashboardResponseDtos.get(0);
    }
}
