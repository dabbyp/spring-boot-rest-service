package com.agencyplatform.springboot.domain.membership;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FeeRepository extends JpaRepository<Fee,FeePK> {
}
