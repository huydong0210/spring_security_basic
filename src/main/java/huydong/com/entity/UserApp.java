package huydong.com.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@Builder
public class UserApp {
    private String username;
    private String authorities;

    public static UserApp fromUserDetails(User userDetails) {
        StringBuilder authorities = new StringBuilder();
        for (GrantedAuthority authority : userDetails.getAuthorities()) {
            authorities.append(authority.getAuthority()).append(" ");
        }
        authorities.deleteCharAt(authorities.length() - 1);
        return UserApp.builder()
                .username(userDetails.getUsername())
                .authorities(authorities.toString())
                .build();

    }
}
