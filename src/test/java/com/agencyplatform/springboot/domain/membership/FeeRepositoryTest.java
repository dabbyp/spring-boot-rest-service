package com.agencyplatform.springboot.domain.membership;

import com.agencyplatform.springboot.domain.user.Partner;
import com.agencyplatform.springboot.domain.user.PartnerRepository;
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
public class FeeRepositoryTest {
    @Autowired
    FeeRepository feeRepository;

    @After
    public void cleanup(){
        feeRepository.deleteAll();
    }

    @Test
    public void fee_jpa_test() throws Exception {

        FeePK pk = new FeePK("Basic","3",12);

        feeRepository.save(Fee.builder()
                .feePK(pk)
                .fee(new Long(1000000L))
                .discount_r(12)
                .build()
        );

        List<Fee> feeList = feeRepository.findAll();

        Fee fee = feeList.get(0);

        assertThat(fee.getClassify_t()).isEqualTo("Basic");
        assertThat(fee.getClassify_m()).isEqualTo("3");
    }
}
