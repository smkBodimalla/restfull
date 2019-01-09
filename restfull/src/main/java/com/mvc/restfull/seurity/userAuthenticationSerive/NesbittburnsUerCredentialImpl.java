package com.mvc.restfull.seurity.userAuthenticationSerive;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mvc.restfull.seurity.NetBernUser;

public class NesbittburnsUerCredentialImpl implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private NetBernUser user;
	private Collection<SimpleGrantedAuthority> authorities;

	public NetBernUser getUser() {
		return user;
	}

	public void setUser(NetBernUser user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		authorities.add(new SimpleGrantedAuthority(user.getRole().getRoleName()));
		return authorities;
	}

	@Override
	public String getPassword() {

		return user.getPassWord();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		if (user.getLocked() == 1)
			return false;
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub

		return true;
	}

	@Override
	public boolean isEnabled() {

		if (user.getDisable() == 1)
			return false;
		return true;
	}

}
