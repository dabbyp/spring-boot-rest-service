package com.agencyplatform.springboot.domain.user;

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
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

//    @After
//    public void cleanup(){
//        userRepository.deleteAll();
//    }

    @Test
    public void user_jpa_test() throws Exception {
        String strIndex = "index";

        userRepository.save(User.builder()
                .password("1234")
                .name("name")
                .email("email")
                .mobile("mobile")
                .picture("picture".getBytes())
                .role(Role.PARTNER)
                .build()
        );

        List<User> userList = userRepository.findAll();

        User user = userList.get(0);

        System.out.println(">>>>>>>>>>>>> createDate=" + user.getReg_date() + ", modDate=" + user.getMod_date());

        LocalDateTime now = LocalDateTime.of(2019,6,4,0,0,0);
        assertThat(user.getReg_date()).isAfter(now);
        assertThat(user.getMod_date()).isAfter(now);

        assertThat(user.getEmail()).isEqualTo("email");
        assertThat(user.getMobile()).isEqualTo("mobile");
    }
}
