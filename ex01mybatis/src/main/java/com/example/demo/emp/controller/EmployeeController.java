package com.example.demo.emp.controller;

//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.emp.EmployeeVO;
import com.example.demo.emp.mapper.EmployeeMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import lombok.extern.slf4j.Slf4j;

//@Component + 라우터(컨트롤러 임을 명시)
@Slf4j //인터페이스
@Controller //스테레오타입 어노테이션
public class EmployeeController {
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	
	//메서드 = 커맨드 핸들러, vo = 커맨드객체 => Model 저장하고 뷰페이지 전달
	@GetMapping({"/emp/list","/"})
	public String emplist(@ModelAttribute("emp") EmployeeVO vo,
			Model model,
			@RequestParam(required = false,defaultValue="1") int pageNum) {
		PageInfo<Object> page = PageHelper.startPage(pageNum, 5).doSelectPageInfo(()->employeeMapper.selectAll(vo));
		
		log.info("TotalCount : {}, CurrentPage : {}, PageSize : {}, TotalPage : {}"
				, page.getTotal()
				   , page.getPageNum()
				   , page.getPageSize()
				   , page.isHasNextPage()
				   , page.isHasPreviousPage()
				   , page.getPrePage()
				   , page.getNextPage()
				   , page.getNavigatepageNums());
		System.out.println(page.getList());
		model.addAttribute("pageInfo",page);
		return "emp/list";
	}
	
	@GetMapping("/emp/info") // /emp/info?id=100
	public void info(@RequestParam int id, Model model) {
		model.addAttribute("emp",employeeMapper.selectOne(id));
	}
	
	//등록페이지로 이동
	@GetMapping("/emp/register")
	public void register(@ModelAttribute("emp") EmployeeVO vo , Model model) {
		
	}
	
	//등록처리
	@PostMapping("/emp/register")
	public String registerProc(EmployeeVO vo) {
		employeeMapper.insert(vo);
		return "redirect:/emp/list";
	}
	
	//수정페이지로 이동
	@GetMapping("/emp/update")
	public String update(int id,Model model) {
		//단건 조회
		model.addAttribute("emp",employeeMapper.selectOne(id));
		return "emp/register";
	}
	//수정 처리
	@PostMapping("/emp/update")
	public String updateProc(EmployeeVO vo) {
		employeeMapper.update(vo);
		return "redirect:/emp/list";
	}
	//삭제 처리
	@GetMapping("/emp/delete")
	public String deleteProc(int id) {
		employeeMapper.delete(id);
		return "redirect:/emp/list";
	}
}
