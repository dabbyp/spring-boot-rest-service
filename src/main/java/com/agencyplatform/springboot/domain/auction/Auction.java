package com.agencyplatform.springboot.domain.auction;

import com.agencyplatform.springboot.domain.RegModTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Auction extends RegModTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auction_id;

    @Column(nullable = false)
    private String compnum;

    @Column(nullable = false)
    private Long agent_id;

    @Column(nullable = false)
    private Long obj_id;

    @Column(nullable = false)
    private Long user_id;

    @Column(nullable = false)
    private String end_d;

    @Column(nullable = false)
    private Long auction_amount;

    @Builder
    public Auction(String compnum, Long agent_id, Long obj_id, Long user_id, String end_d, Long auction_amount) {
        this.compnum = compnum;
        this.agent_id = agent_id;
        this.obj_id = obj_id;
        this.user_id = user_id;
        this.end_d = end_d;
        this.auction_amount = auction_amount;
    }

    public Auction update(String compnum, Long agent_id, Long obj_id, Long user_id, String end_d, Long auction_amount) {
        this.compnum = compnum;
        this.agent_id = agent_id;
        this.obj_id = obj_id;
        this.user_id = user_id;
        this.end_d = end_d;
        this.auction_amount = auction_amount;

        return this;
    }
}
