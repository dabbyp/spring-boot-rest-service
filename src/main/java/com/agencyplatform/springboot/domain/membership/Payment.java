package com.agencyplatform.springboot.domain.membership;

import com.agencyplatform.springboot.domain.RegTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Payment extends RegTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pay_id;

    @Column(nullable = false)
    private String compnum;

    @Column(nullable = false)
    private String classify_t;

    @Column(nullable = false)
    private String classify_m;

    @Column(nullable = false)
    private int term;

    @Column(nullable = false)
    private int pay_g;

    @Column(nullable = false)
    private Long amount;

    @Builder
    public Payment(String compnum, String classify_t, String classify_m, int term, int pay_g, Long amount) {
        this.compnum = compnum;
        this.classify_t = classify_t;
        this.classify_m = classify_m;
        this.term = term;
        this.pay_g = pay_g;
        this.amount = amount;
    }

    public Payment update(String compnum, String classify_t, String classify_m, int term, int pay_g, Long amount) {
        this.compnum = compnum;
        this.classify_t = classify_t;
        this.classify_m = classify_m;
        this.term = term;
        this.pay_g = pay_g;
        this.amount = amount;

        return this;
    }
}
