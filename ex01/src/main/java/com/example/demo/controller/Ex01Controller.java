package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.mapper.Ex01Mapper;
import com.example.demo.service.Ex01VO;

@Controller
public class Ex01Controller {
	@Autowired Ex01Mapper ex01Mapper;
	
	
	//전체 조회
	@GetMapping("/list")
	public String getlist(Model model) {
		model.addAttribute("list",ex01Mapper.getList(null));
		
		return "list";
	}
	
	//단건 조회
	@GetMapping("/info")
	public void read(@RequestParam int no , Model model) {
		model.addAttribute("list",ex01Mapper.read(no));
		
	}
	
	//등록페이지 이동
	@GetMapping("/insert")
	public void insert(@ModelAttribute("list")Ex01VO vo,Model model) {
		
	}
	
	//등록
	@PostMapping("/insert")
	public String insertProc(Ex01VO vo) {
		ex01Mapper.insert(vo);
		return "insert";
	}
}
