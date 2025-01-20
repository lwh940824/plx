package com.whlee.plx.common.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@Builder
public class JwtUserDetails implements UserDetails {

    private String username;
    private String password;
    private String email;

    private Collection<? extends GrantedAuthority> authorities;


    public JwtUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {return this.password;}

    @Override
    public String getUsername() {return this.username;}

    @Override
    public boolean isAccountNonExpired() {return true;}

    @Override
    public boolean isAccountNonLocked() {return true;}

    @Override
    public boolean isCredentialsNonExpired() {return true;}

    @Override
    public boolean isEnabled() {return true;}
}
