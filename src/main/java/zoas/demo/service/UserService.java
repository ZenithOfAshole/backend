package zoas.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import zoas.demo.domian.User;
import zoas.demo.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    // 회원가입
    @Transactional
    public void signUp( User user) {
        validateDuplicateEmail(user);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String securityPw = encoder.encode(user.getPassword());
        user.setPassword(securityPw); //비번 암호화
        userRepository.save(user); //저장
    }

    //Login
    @Transactional
    public User signIn(String userEmail, String userPw){
        User user = userRepository.findByEmail(userEmail);
        BCryptPasswordEncoder encoder =  new BCryptPasswordEncoder();
        if(user ==null){
            return null;
        }
        //클라에서 쏘는 pw encode
        String encodepw = encoder.encode(userPw);
        if(user.getPassword().equals(encodepw) == false){   // jpa가 불러온 pw 와 비교
            return null;    // 없다면 null 반환
        }
        return user;
    }


    // 이메일 중복 검사
    private void validateDuplicateEmail(User user){
        //중복회원 조회 후 , 에러시 exception 발생

        User findUsers = userRepository.findByEmail(user.getEmail());
        if(findUsers != null){
            throw new IllegalStateException("Already Exist User Email");
        }
    }

}
