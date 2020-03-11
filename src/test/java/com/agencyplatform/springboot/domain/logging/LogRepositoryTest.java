package com.agencyplatform.springboot.domain.logging;

import com.agencyplatform.springboot.domain.user.Role;
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
public class LogRepositoryTest {
    @Autowired
    LogRepository logRepository;

//    @After
//    public void cleanup(){
//        logRepository.deleteAll();
//    }

    @Test
    public void log_jpa_test() throws Exception {
        logRepository.save(Log.builder()
                .log_dd("11")
                .service_date("20200311")
                .service_time("121222")
                .id(new Long(1))
                .role(Role.USER)
                .service_no(10)
                .build()
        );

        List<Log> logList = logRepository.findAll();

        Log log = logList.get(0);

        assertThat(log.getLog_dd()).isEqualTo("11");
        assertThat(log.getService_date()).isEqualTo("20200311");
    }
}
