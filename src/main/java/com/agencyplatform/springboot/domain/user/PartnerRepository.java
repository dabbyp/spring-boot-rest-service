package com.agencyplatform.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PartnerRepository extends JpaRepository<Partner,Long> {
    Optional<Partner> findByName(String name);
    Optional<Partner> findByEmail(String email);
    Optional<Partner> findByMobile(String mobile);
}
