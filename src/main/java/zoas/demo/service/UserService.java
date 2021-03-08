package zoas.demo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import zoas.demo.domian.Token;
import zoas.demo.domian.User;
import zoas.demo.domian.resultVO;
import zoas.demo.repository.TokenRepository;
import zoas.demo.repository.UserRepository;
import zoas.demo.util.RandomToken;
import zoas.demo.util.StatusCode;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {


    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final TokenRepository tokenRepository;
    // 회원가입
    @Transactional
    public resultVO signUp(User user) {
        User findUsers = userRepository.findByEmail(user.getEmail());

        if(findUsers != null) {
            return new resultVO(StatusCode.BAD_REQUEST, "Already User email",null);
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String securityPw = encoder.encode(user.getPassword());
        user.setPassword(securityPw); //비번 암호화
        userRepository.save(user); //저장

        return new resultVO(StatusCode.CREATED, "SignUp Success",user);
    }

    //Login
    @Transactional
    public User signInByEmail(String userEmail, String userPw){ //자체 이메일과 pw 로 로그인하기
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

    @Transactional
    public Token signInByToken(User user){

        Long userId = user.getId();
        logger.info("UserId : "+ userId);

        String token = RandomToken.makeToken().toString();

        Token tokenVO = new Token();
        tokenVO.setTokenValue(token);
        tokenVO.setTokenType("selfZoas");
        tokenVO.setCreatedAt(LocalDateTime.now());

        tokenRepository.save(tokenVO);


         return tokenRepository.findByTokenValue(token);

    }


    @Transactional
    public User findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }



}
