package com.tracking.system.configs.security;

import com.tracking.system.repositories.user.UserRepository;
import com.tracking.system.models.entities.user.AppUser;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Lazy
    private final UserRepository mRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.mRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> optionalAppUser = mRepository.findByUsername(username);

        if (optionalAppUser.isEmpty())
            throw new UsernameNotFoundException(String.format("The username %s doesn't exist", username));

        AppUser user = optionalAppUser.get();
        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority(user.getRole().getRoleName()));

        return new org.springframework.security.core.userdetails.
                User(user.getUsername(), user.getPassword(), authorities);
    }

}