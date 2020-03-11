package com.agencyplatform.springboot.domain.auction;

import com.agencyplatform.springboot.domain.RegModTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name="AG_LAW_OBJ")
public class Obj extends RegModTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long obj_id;

    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String kind;

    @Column(nullable = false)
    private Long amount;

    @Column(nullable = false)
    private String addr_1;

    @Column(nullable = false)
    private String addr_2;

    @Column(nullable = false)
    private String addr_3;

    @Column(nullable = true)
    private String discount_c;

    @Column(nullable = false)
    private String contract_d;

    @Column(nullable = false)
    private float bond_disc_r;

    @Column(nullable = false)
    private String etc;

    @Builder
    public Obj(Long id, String kind, Long amount, String addr_1, String addr_2, String addr_3,
                      String discount_c, String contract_d, float bond_disc_r, String etc) {
        this.id = id;
        this.kind = kind;
        this.amount = amount;
        this.addr_1 = addr_1;
        this.addr_2 = addr_2;
        this.addr_3 = addr_3;
        this.discount_c = discount_c;
        this.contract_d = contract_d;
        this.bond_disc_r = bond_disc_r;
        this.etc = etc;
    }

    public Obj update(Long id, String kind, Long amount, String addr_1, String addr_2, String addr_3,
                      String discount_c, String contract_d, float bond_disc_r, String etc) {
        this.id = id;
        this.kind = kind;
        this.amount = amount;
        this.addr_1 = addr_1;
        this.addr_2 = addr_2;
        this.addr_3 = addr_3;
        this.discount_c = discount_c;
        this.contract_d = contract_d;
        this.bond_disc_r = bond_disc_r;
        this.etc = etc;

        return this;
    }
}
