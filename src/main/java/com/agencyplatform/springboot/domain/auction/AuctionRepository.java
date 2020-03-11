package com.agencyplatform.springboot.domain.auction;

import com.agencyplatform.springboot.domain.user.Partner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuctionRepository extends JpaRepository<Auction,Long> {
    Optional<Partner> findByCompnum(String compnum);

}
