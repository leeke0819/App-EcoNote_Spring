package com.example.demo.service;

import com.example.demo.model.UserEntity;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String UID) throws UsernameNotFoundException {
        Optional<UserEntity> userOptional = userRepository.findById(Long.valueOf(UID));
        if (userOptional.isPresent()) {
            UserEntity user = userOptional.get();
            return createUserDetails(user);
        } else {
            throw new UsernameNotFoundException(UID + "를 Model 에서 찾을 수 없습니다.");
        }
    }

    private UserDetails createUserDetails(UserEntity userEntity) {
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(userEntity.getAuthority().toString());
        return new User(
                String.valueOf(userEntity.getId()),
                userEntity.getPassword(),
                Collections.singleton(grantedAuthority)
        );
    }

}
