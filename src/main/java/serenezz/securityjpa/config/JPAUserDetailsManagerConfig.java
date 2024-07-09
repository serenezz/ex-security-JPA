package serenezz.securityjpa.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import serenezz.securityjpa.repo.UserRepo;

@Service
@RequiredArgsConstructor
public class JPAUserDetailsManagerConfig implements UserDetailsService {

    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findUserByUsername(username)
                .map(UserSecurityConfig::new)
                .orElseThrow(()-> new UsernameNotFoundException("User: " + username + " does not exist"));
    }
}
