package com.agencyplatform.springboot.domain.membership;

import com.agencyplatform.springboot.domain.RegModTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@IdClass(FeePK.class)
@Entity
public class Fee extends RegModTimeEntity {
    @Id
    @Column(name = "CLASSIFY_T")
    private String classify_t;

    @Id
    @Column(name = "CLASSIFY_M")
    private String classify_m;

    @Id
    @Column(name = "TERM")
    private int term;

    @Column(nullable = false)
    private Long fee;

    @Column(nullable = false)
    private int discount_r;

    @Builder
    public Fee(FeePK feePK, Long fee, int discount_r) {
        this.classify_t = feePK.getClassify_t();
        this.classify_m = feePK.getClassify_m();
        this.term = feePK.getTerm();
        this.fee = fee;
        this.discount_r = discount_r;
    }

    public Fee update(FeePK feePK, Long fee, int discount_r) {
        this.classify_t = feePK.getClassify_t();
        this.classify_m = feePK.getClassify_m();
        this.term = feePK.getTerm();
        this.fee = fee;
        this.discount_r = discount_r;

        return this;
    }
}
