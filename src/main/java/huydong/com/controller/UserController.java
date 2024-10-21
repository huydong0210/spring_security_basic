package huydong.com.controller;

import huydong.com.entity.User;
import huydong.com.jwt.JwtProvider;
import huydong.com.rest.LoginRequest;
import huydong.com.security.UserDetailsImpl;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtProvider jwtProvider;

    @PostMapping("/authenticate")
    public ResponseEntity<String> authorize(@RequestBody LoginRequest loginVM) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                loginVM.getUsername(),
                loginVM.getPassword()
        );

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.createToken(authentication);
        return new ResponseEntity<>(jwt, null, HttpStatus.OK);
    }
    @GetMapping("/account")
    public ResponseEntity<User> getAccount(){
        return new ResponseEntity<>(null, null, HttpStatus.OK);
    }

}
