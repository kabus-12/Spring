package com.example.demo.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.user.mapper.UserMapper;
import com.example.demo.user.service.UserService;
import com.example.demo.user.service.UserVO;

@Service
public class UserServiceImpl implements UserService, UserDetailsService{
	@Autowired UserMapper userMapper;

	@Override
	public UserVO getUser(String loginId) {
		
		return userMapper.getUser(loginId);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVO vo = userMapper.getUser(username);
		vo.setRole(userMapper.getRole(vo.getId()));
		
		return vo;
	}
	
	
}
