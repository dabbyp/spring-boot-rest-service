package com.agencyplatform.springboot.web.index;

import com.agencyplatform.springboot.config.auth.LoginUser;
import com.agencyplatform.springboot.config.auth.dto.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        //model.addAttribute("posts", postsService.findAllDesc());
        if (user != null) {
            model.addAttribute("userEmail", user.getName() + "(" + user.getEmail() + ")" );
            model.addAttribute("userPicture", user.getPicture() );
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
