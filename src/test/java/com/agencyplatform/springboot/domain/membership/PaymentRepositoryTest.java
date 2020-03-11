package com.agencyplatform.springboot.domain.membership;

import com.agencyplatform.springboot.domain.user.Partner;
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
public class PaymentRepositoryTest {
    @Autowired
    PaymentRepository paymentRepository;

//    @After
//    public void cleanup(){
//        paymentRepository.deleteAll();
//    }

    @Test
    public void payment_jpa_test() throws Exception {
        paymentRepository.save(Payment.builder()
                .compnum("12345")
                .classify_t("Basic")
                .classify_m("3")
                .term(12)
                .pay_g(1)
                .amount(new Long(1000000L))
                .build()
        );

        List<Payment> payList = paymentRepository.findAll();

        Payment payment = payList.get(0);

        assertThat(payment.getClassify_t()).isEqualTo("Basic");
        assertThat(payment.getClassify_m()).isEqualTo("3");
    }
}
