package com.agencyplatform.springboot.domain.user;

import com.agencyplatform.springboot.domain.RegModTimeEntity;
import com.agencyplatform.springboot.service.dashboard.DashboardResponseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name="AG_USER")
public class User extends RegModTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String email;

    @Column(nullable = true)
    private String mobile;

    @Column(nullable = true)
    private String password;

    @Column(nullable = true)
    private String picture;

    @Enumerated(EnumType.STRING) // DB 저장시 Enum 값을 스트링으로 저장 (기본 : int)
    @Column(nullable = true)
    private Role role;

    @Builder
    public User(String name, String email, String mobile, String password, String picture, Role role) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
        this.picture = picture;
        this.role = role;
    }

    public User update(String name, String picture) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
        this.picture = picture;

        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }
}
