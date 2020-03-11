package com.agencyplatform.springboot.domain.logging;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LogRepository extends JpaRepository<Log,Long> {
}
