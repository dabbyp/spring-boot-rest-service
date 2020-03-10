package com.agencyplatform.springboot.domain.user;

import com.agencyplatform.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Partner extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = true)
    private String password;

    @Column(nullable = false)
    private String mobile;

    @Column(nullable = true)
    private String phone;

    @Column(nullable = false)
    private String fax;

    @Column(nullable = false)
    private String addr1_1;

    @Column(nullable = false)
    private String addr1_2;

    @Column(nullable = false)
    private String addr1_3;

    @Column(nullable = false)
    private String addr2_1;

    @Column(nullable = false)
    private String addr2_2;

    @Column(nullable = true)
    private String addr3_1;

    @Column(nullable = true)
    private String addr3_2;

    @Column(nullable = true)
    private byte[] license;

    @Enumerated(EnumType.STRING) // DB 저장시 Enum 값을 스트링으로 저장 (기본 : int)
    @Column(nullable = false)
    private Role role;

    @Builder
    public Partner(String name, String email, String password, String mobile, String phone, String fax,
                   String addr1_1, String addr1_2, String addr1_3,
                   String addr2_1, String addr2_2, String addr3_1, String addr3_2,
                   byte[] license, Role role) {
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
        this.role = role;
    }

    public Partner update(String name, String email, String password, String mobile, String phone, String fax,
                          String addr1_1, String addr1_2, String addr1_3,
                          String addr2_1, String addr2_2, String addr3_1, String addr3_2,
                          byte[] license) {
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

    public String getRoleKey(){
        return this.role.getKey();
    }
}
