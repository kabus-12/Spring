package com.example.demo;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.example.demo.user.service.UserVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
//		List<GrantedAuthority> roles = (List<GrantedAuthority>)authentication.getAuthorities();
//		List<String> strRoles = roles.stream().map(a->a.getAuthority()).collect(Collectors.toList());
		//위 주석과 같은것
		UserVO vo = (UserVO) authentication.getPrincipal();
		List<String> strRoles = vo.getRole();
		
		//session : 클라이언트 브라우저 접속정보를 가지는 객체(최근 접속시간,로그인 정보,sessionID -> 브라우저에 쿠기로 저장)
		request.getSession().setAttribute("deptName", vo.getDeptName());;
		
		if(strRoles.contains("ROLE_ADMIN")) {
			response.sendRedirect("/admin");
			
		}
		else {
			response.sendRedirect("/hello");
			
		}
	}

}
