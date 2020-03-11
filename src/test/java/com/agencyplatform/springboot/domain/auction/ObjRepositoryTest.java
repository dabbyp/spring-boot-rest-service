package com.agencyplatform.springboot.domain.auction;

import com.agencyplatform.springboot.domain.logging.Log;
import com.agencyplatform.springboot.domain.logging.LogRepository;
import com.agencyplatform.springboot.domain.user.Role;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ObjRepositoryTest {
    @Autowired
    ObjRepository objRepository;

//    @After
//    public void cleanup(){
//        objRepository.deleteAll();
//    }

    @Test
    public void obj_jpa_test() throws Exception {

        objRepository.save(Obj.builder()
                .id(new Long(1L))
                .kind("1234556")
                .amount(new Long(1000000L))
                .addr_1("Seoul")
                .addr_2("West")
                .addr_3("Hometown")
                .discount_c("1")
                .contract_d("20200320")
                .bond_disc_r(0.1f)
                .etc("etc")
                .build()
        );

        List<Obj> objList = objRepository.findAll();

        Obj obj = objList.get(0);

        System.out.println(">>>>>>>>>>>>> createDate=" + obj.getReg_date());

        LocalDateTime now = LocalDateTime.of(2019,6,4,0,0,0);
        assertThat(obj.getReg_date()).isAfter(now);

        assertThat(obj.getAmount()).isEqualTo(1000000L);
        assertThat(obj.getAddr_1()).isEqualTo("Seoul");
    }
}
