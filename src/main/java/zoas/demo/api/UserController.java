package zoas.demo.api;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import zoas.demo.domian.User;
import zoas.demo.domian.resultVO;
import zoas.demo.service.UserService;
import zoas.demo.util.StatusCode;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {
    Logger logger ;
    private final UserService userService;
    //Login
    @PostMapping("/signin")
    public resultVO signIn(@RequestBody String email, String Pw){
        User user = userService.signInByEmail(email, Pw);
        if(user == null){
            logger.info("user info not exist");
            return new resultVO(StatusCode.BAD_REQUEST,"이메일 또는 비밀번호 정보가 맞지 않습니다.",null);
        }
        return new resultVO(StatusCode.CREATED,"success Login",userService.signInByToken(user));
    }

    @PostMapping("/signup") // 회원가입
    public resultVO signUp(@RequestBody User user){
      return userService.signUp(user);
    }

    @GetMapping("/emailCheck")
    public resultVO findUserByEmail(@RequestParam("email") String email){

         User emailCheck = userService.findUserByEmail(email);
        if(emailCheck == null){
            return new resultVO(StatusCode.INTERNAL_SERVER_ERROR, "가입된 이메일이 없습니다.", null);
        }else{
            return new resultVO(StatusCode.OK,"이메일 찾기 성공",emailCheck.getEmail());
        }
    }
}
