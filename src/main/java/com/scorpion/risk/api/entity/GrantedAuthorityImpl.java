package com.scorpion.risk.api.entity;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created on 2017/9/18.
 */
public class GrantedAuthorityImpl implements GrantedAuthority {

    private String authority;


    public GrantedAuthorityImpl(String authority) {
        this.authority = authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return null;
    }
}
