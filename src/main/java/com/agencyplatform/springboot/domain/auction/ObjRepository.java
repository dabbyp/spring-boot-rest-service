package com.agencyplatform.springboot.domain.auction;

import com.agencyplatform.springboot.domain.logging.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObjRepository extends JpaRepository<Obj,Long> {
}
