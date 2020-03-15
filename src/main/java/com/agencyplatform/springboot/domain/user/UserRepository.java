package com.agencyplatform.springboot.domain.user;

import com.agencyplatform.springboot.service.dashboard.DashboardResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByName(String name);
    Optional<User> findByEmail(String email);
    Optional<User> findByMobile(String mobile);
    List<User> findAll();
    @Query("SELECT p FROM User p WHERE p.role = ?1 ORDER BY p.id DESC")
    List<User> findByRole(String role);
/*
    ex)
    @Query("SELECT new de.smarterco.example.dto.UserNameDTO(u.id, u.name) FROM User u WHERE u.name = :name")
    List<UserNameDTO> retrieveUsernameAsDTO(@Param("name") String name);

    @Query("select new com.agencyplatform.springboot.service.dashboard.DashboardResponseDto(A.CNT, B.CNT, '0', '0') from " +
            "(select count(ID) as CNT from AG_USER where ROLE='USER') A, " +
            "(select count(ID) as CNT from AG_USER where ROLE='PARTNER') B")
*/
/*
    @Query("select new com.agencyplatform.springboot.service.dashboard.DashboardResponseDto(A.CNT, B.CNT, '0', '0') from " +
        "(select count(ID) as CNT from AG_USER where ROLE='USER') A, " +
        "(select count(ID) as CNT from AG_USER where ROLE='PARTNER') B")
    List<DashboardResponseDto> getStatInfo();
*/
}
