package com.example.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;



@Tag(name = "Sample API",description = "샘플 테스트")
@RestController //모든 응답결과 JSON
public class SampleRestController {
	@GetMapping("/api/ex1")
	public SampleVO ex1() {
		return new SampleVO( "홍길동" , 23 );
	}
	
	@GetMapping("/api/ex2")
	public List<SampleVO> ex2() {
		List<SampleVO> list = Arrays.asList(new SampleVO("홍길동",23),
				new SampleVO("김기자",25),
				new SampleVO("나기자",20));
		return list;
	}
	
	//VO (메서드 = 커맨드 핸들러, VO = 커맨드 객체)
	@PostMapping("/api/ex3")
	public SampleVO ex3(SampleVO vo) {
		return vo;
	}
	
	@GetMapping("/api/ex4")
	public Map<String,Object> ex4(Map<String,Object> map) {
		return map;
	}
	
	@GetMapping("/api/ex5")
	public String ex5(String name,
			@RequestParam(required = false,defaultValue = "15") int age) {
		System.out.println(name + " " + age);
		return name;
	}
	
	@GetMapping("/api/ex6/{name}/{age}")
	public String ex6(@PathVariable String name,
					  @PathVariable int age) {
		System.out.println(name+ " " + age);
		return name;
	}
	
	//json string 파라미터 받기
	@GetMapping("/api/ex7")
	public SampleVO ex7(@RequestBody SampleVO vo) {
		System.out.println(vo);
		return vo;
	}
	
	//유효성 체크
	@Tag(name= "사용자 등록")
	@Operation(summary = "사용자 등록", description = "일반 사용자 등록.",
             responses = {
              @ApiResponse(responseCode = "200", description = "등록 성공"),
              @ApiResponse(responseCode = "400", description = "잘못된 요청")
        })
	@PostMapping("/api/ex8")
	public ResponseEntity<?> ex8(@Valid @RequestBody UserVO vo,BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			Map<String, String> errors = new HashMap<>();
	            
	            // 에러 메시지 정리
	            for (FieldError error : bindingResult.getFieldErrors()) {
	                errors.put(error.getField(), error.getDefaultMessage());
	            }
	            // 400 Bad Request와 함께 에러 맵 반환
	            return ResponseEntity.badRequest().body(errors);
		}
		return ResponseEntity.ok("success"); //200코드
	}
	
}
