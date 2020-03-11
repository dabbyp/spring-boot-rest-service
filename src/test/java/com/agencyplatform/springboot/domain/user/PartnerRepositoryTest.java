package com.agencyplatform.springboot.domain.user;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PartnerRepositoryTest {
    @Autowired
    PartnerRepository partnerRepository;

//    @After
//    public void cleanup(){
//        partnerRepository.deleteAll();
//    }

    @Test
    public void partner_jpa_test() throws Exception {
        String strIndex = "index";

        partnerRepository.save(Partner.builder()
                .compnum("12345")
                .id(new Long(1L))
                .password("124")
                .name("name")
                .email("email")
                .mobile("mobile")
                .fax("0234526354")
                .addr1_1("서울")
                .addr1_2("강서구")
                .addr1_3("가양동")
                .addr2_1("서울")
                .addr2_2("강서구")
                .build()
        );

        List<Partner> partnerList = partnerRepository.findAll();

        Partner partner = partnerList.get(0);
        assertThat(partner.getEmail()).isEqualTo("email");
        assertThat(partner.getMobile()).isEqualTo("mobile");
    }
}
