package com.agencyplatform.springboot.service.dashboard;

import com.agencyplatform.springboot.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DashboardService {
    private final UserRepository userRepository;

    /*
    @Transactional
    public List<DashboardResponseDto> getDashboardInfo(){
        return userRepository.getStatInfo().stream()
                .map(DashboardResponseDto::new)
                .collect(Collectors.toList());
    }

     */
}
