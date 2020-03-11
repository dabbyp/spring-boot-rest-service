package com.agencyplatform.springboot.domain.membership;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
    Optional<Payment> findByCompnum(String compnum);
}
