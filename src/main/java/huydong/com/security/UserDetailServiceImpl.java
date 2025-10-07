package huydong.com.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return switch (username) {
            case "user" -> UserDetailsImpl.build(
                    "user",
                    "$2a$10$pbbu0BwZek614oiRKSoitur0j7ZUG1OFcEDUvOZAKwMpBtwlrcoT6", //123465
                    List.of(AuthoritiesConstants.USER));
            case "admin" -> UserDetailsImpl.build(
                    "admin",
                    "$2a$10$pbbu0BwZek614oiRKSoitur0j7ZUG1OFcEDUvOZAKwMpBtwlrcoT6", //123465
                    List.of(AuthoritiesConstants.ADMIN));
            default -> null;
        };


    }
}
