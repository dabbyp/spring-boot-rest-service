package com.agencyplatform.springboot.domain.auction;

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
public class AuctionRepositoryTest {
    @Autowired
    AuctionRepository auctionRepository;

//    @After
//    public void cleanup(){
//        auctionRepository.deleteAll();
//    }

    @Test
    public void auction_jpa_test() throws Exception {

        auctionRepository.save(Auction.builder()
                .compnum("12345")
                .agent_id(new Long(1L))
                .obj_id(new Long(1L))
                .user_id(new Long(1L))
                .end_d("20200312")
                .auction_amount(new Long(1000000L))
                .build()
        );

        List<Auction> auctionList = auctionRepository.findAll();

        Auction auction = auctionList.get(0);

        System.out.println(">>>>>>>>>>>>> createDate=" + auction.getReg_date());

        LocalDateTime now = LocalDateTime.of(2019,6,4,0,0,0);
        assertThat(auction.getReg_date()).isAfter(now);

        assertThat(auction.getAuction_amount()).isEqualTo(1000000L);
        assertThat(auction.getCompnum()).isEqualTo("12345");
    }
}
