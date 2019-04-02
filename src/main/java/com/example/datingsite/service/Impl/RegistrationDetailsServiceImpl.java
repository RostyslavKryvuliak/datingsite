package com.example.datingsite.service.Impl;

import com.example.datingsite.entity.RegistrationEntity;
import com.example.datingsite.repository.RegistrationRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userDetailsService")
public class RegistrationDetailsServiceImpl implements UserDetailsService {

    private RegistrationRepository registrationRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        RegistrationEntity registrationEntity = registrationRepository.findByEmailIgnoreCase(email)
                .orElseThrow(
                        () -> new UsernameNotFoundException("User with email [" + email + "] not found")
                );

        return User.builder()
                .username(registrationEntity.getEmail())
                .password(registrationEntity.getPassword())
                .username(registrationEntity.getLogin())
                .authorities(getAuthorities(registrationEntity))
                .build();
    }

    private List<SimpleGrantedAuthority> getAuthorities(RegistrationEntity registrationEntity){
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        registrationEntity.getRoles().forEach(r ->
            authorities.add(new SimpleGrantedAuthority("ROLE_" + r.getRole())));
        return authorities;
    }

}



