package com.example.demo.user.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class UserVO implements UserDetails{
	private Integer id;
	private String loginId;
	private String password;
	private String fullName;
	private String deptName;
	
	private List<String> role;
	
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return role.stream().map(a-> new SimpleGrantedAuthority(a)).collect(Collectors.toList());
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return loginId;
	}
	@Override
	public boolean isAccountNonExpired() {	//패스워드 변경
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {  //로그인 실패횟수 lock
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {	//휴먼회원
		// TODO Auto-generated method stub
		return true;
	}
}
