package com.agencyplatform.springboot.domain.logging;

import com.agencyplatform.springboot.domain.RegTimeEntity;
import com.agencyplatform.springboot.domain.user.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name="AG_LAW_LOG")
public class Log extends RegTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long log_id;

    @Column(nullable = false)
    private String log_dd;

    @Column(nullable = false)
    private String service_date;

    @Column(nullable = false)
    private String service_time;

    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private Role role;

    @Column(nullable = false)
    private int service_no;

    @Builder
    public Log(String log_dd, String service_date, String service_time, Long id, Role role, int  service_no) {
        this.log_dd = log_dd;
        this.service_date = service_date;
        this.service_time = service_time;
        this.id = id;
        this.role = role;
        this.service_no = service_no;
    }

    public Log update(String log_dd, String service_date, String service_time, Long id, Role role, int  service_no) {
        this.log_dd = log_dd;
        this.service_date = service_date;
        this.service_time = service_time;
        this.id = id;
        this.role = role;
        this.service_no = service_no;

        return this;
    }
}
