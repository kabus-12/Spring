package com.example.demo.user.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.user.service.RoleVO;
import com.example.demo.user.service.UserVO;


public interface UserService {
	
	UserVO getUser(String loginId);
}
