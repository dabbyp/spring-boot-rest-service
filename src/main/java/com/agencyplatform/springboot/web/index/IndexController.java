package com.agencyplatform.springboot.web.index;

import com.agencyplatform.springboot.config.auth.LoginUser;
import com.agencyplatform.springboot.config.auth.dto.SessionUser;
import com.agencyplatform.springboot.service.dashboard.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final DashboardService dashboardService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        if (user != null) {
            model.addAttribute("userEmail", user.getName() + "(" + user.getEmail() + ")" );
            model.addAttribute("userPicture", user.getPicture() );
            model.addAttribute("todayDate", LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE));
            //model.addAttribute("dashboardInfo", dashboardService.getDashboardInfo());
        }
        return "index";
    }

    @GetMapping("/index_stat")
    public String index_stat(Model model, @LoginUser SessionUser user){
        //model.addAttribute("posts", postsService.findAllDesc());
        if (user != null) {
            model.addAttribute("userEmail", user.getName() + "(" + user.getEmail() + ")" );
            model.addAttribute("userPicture", user.getPicture() );
        }
        return "index_stat";
    }

}
