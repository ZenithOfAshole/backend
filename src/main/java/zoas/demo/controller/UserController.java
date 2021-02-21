package zoas.demo.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import zoas.demo.domian.User;
import zoas.demo.service.UserService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {
    Logger logger ;
    private final UserService userService;
    //Login
    @PostMapping("/mypage/login")
    public String signIn(@RequestBody String email, String Pw){
        User user = userService.signIn(email, Pw);
        if(user == null){
            logger.info("user info not exist");
            return "mypage/login"; // 로그인 실패시 다시 돌아가게 끔
        }
        return "/home"; // 로그인 완료 후  메인화면으로
    }

    @PostMapping("/signup") // 회원가입
    public String signUp(@RequestBody User user, BindingResult result){
        if(result.hasErrors()){
            return "/signup";
        }
      userService.signUp(user);
        return "redirect:/";
    }

}
