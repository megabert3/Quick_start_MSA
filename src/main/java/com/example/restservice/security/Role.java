package com.example.restservice.security;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority {

    private String roleAuthority;

    public Role(String roleAuthority) {
        this.roleAuthority = roleAuthority;
    }

    @Override
    public String getAuthority() {
        return roleAuthority;
    }
}
