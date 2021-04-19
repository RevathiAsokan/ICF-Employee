package com.icf.employee.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.icf.employee.model.User;


public class CustomUserDetails extends User implements UserDetails {

	private static final long serialVersionUID = -5925698041839562667L;

	private static final String PREFIX = "ROLE_";

	@SuppressWarnings("unused")
	private String userRoles;

	private Collection<? extends GrantedAuthority> authorities;

	public CustomUserDetails(User user, String userRoles) {
		super(user);
		this.userRoles = userRoles;
		this.authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(userRoles);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String getUsername() {
		return super.getUserName();
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getUserPassword();
	}

	public boolean hasRole(String role) {
		for (GrantedAuthority authority : authorities) {
			if (authority.getAuthority().equals(PREFIX + role)) {
				return true;
			}
		}
		return false;
	}

	public boolean hasAdminRole() {
		return hasRole("ADMIN");
	}

	public List<String> getRoles() {
		List<String> roles = new ArrayList<String>();
		for (GrantedAuthority authority : authorities) {
			roles.add(authority.getAuthority().toString().replaceFirst("^" + PREFIX, ""));
		}

		return roles;
	}

}
