package com.agencyplatform.springboot.domain.user;

import com.agencyplatform.springboot.domain.RegModTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name="AG_LAW_PARTNER")
public class Partner extends RegModTimeEntity {
    @Id
    @Column(nullable = false)
    private String compnum;

    @Column(nullable = false)
    private Long id;

    @Column(nullable = true)
    private String name;

    @Column(nullable = true)
    private String email;

    @Column(nullable = true)
    private String password;

    @Column(nullable = true)
    private String mobile;

    @Column(nullable = true)
    private String phone;

    @Column(nullable = true)
    private String fax;

    @Column(nullable = true)
    private String addr1_1;

    @Column(nullable = true)
    private String addr1_2;

    @Column(nullable = true)
    private String addr1_3;

    @Column(nullable = true)
    private String addr2_1;

    @Column(nullable = true)
    private String addr2_2;

    @Column(nullable = true)
    private String addr3_1;

    @Column(nullable = true)
    private String addr3_2;

    @Column(nullable = true)
    private String license;

    @Builder
    public Partner(String compnum, Long id, String name, String email, String password, String mobile, String phone, String fax,
                          String addr1_1, String addr1_2, String addr1_3,
                          String addr2_1, String addr2_2, String addr3_1, String addr3_2,
                          String license) {
        this.compnum = compnum;
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.mobile = mobile;
        this.phone = phone;
        this.fax = fax;
        this.addr1_1 = addr1_1;
        this.addr1_2 = addr1_2;
        this.addr1_3 = addr1_3;
        this.addr2_1 = addr2_1;
        this.addr2_2 = addr2_2;
        this.addr3_1 = addr3_1;
        this.addr3_2 = addr3_2;
        this.license = license;
    }

    public Partner update(String compnum, Long id, String name, String email, String password, String mobile, String phone, String fax,
                   String addr1_1, String addr1_2, String addr1_3,
                   String addr2_1, String addr2_2, String addr3_1, String addr3_2,
                   String license, Role role) {
        this.compnum = compnum;
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.mobile = mobile;
        this.phone = phone;
        this.fax = fax;
        this.addr1_1 = addr1_1;
        this.addr1_2 = addr1_2;
        this.addr1_3 = addr1_3;
        this.addr2_1 = addr2_1;
        this.addr2_2 = addr2_2;
        this.addr3_1 = addr3_1;
        this.addr3_2 = addr3_2;
        this.license = license;

        return this;
    }
}
