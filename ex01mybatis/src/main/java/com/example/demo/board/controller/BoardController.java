package com.example.demo.board.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.board.service.BoardService;
import com.example.demo.board.service.BoardVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	//전체조회
	@GetMapping("/board/list")
	public String getlist(@ModelAttribute("board") BoardVO vo
			,Model model
			,@RequestParam(required = false,defaultValue="1") int pageNum) {
		
		model.addAttribute("pageInfo",boardService.getList(vo, pageNum));
		return "board/list";
	}
	
	//단건조회
	@GetMapping("/board/info")
	public void info(@RequestParam int bno,Model model) {
		model.addAttribute("board", boardService.read(bno));
	}
	
	//등록페이지로 이동
	@GetMapping("/board/register")
	public void register(@ModelAttribute("board") BoardVO vo,Model model) {
		
	}
	
	//등록
	@PostMapping("/board/register")
	public String registerProc(BoardVO vo , MultipartFile file) throws IllegalStateException, IOException {
		//첨부파일 기능
		file.transferTo(new File("d:/upload",file.getOriginalFilename()));
		vo.setAttach(file.getOriginalFilename());
		
		boardService.insert(vo);
		return "redirect:/board/list";
	}
	
	//수정페이지로 이동
	@GetMapping("/board/update")
	public String update(int bno, Model model) {
		model.addAttribute("board", boardService.read(bno));
		return "board/register";
	}
	
	//수정
	@PostMapping("/board/update")
	public String updateProc(BoardVO vo) {
		boardService.update(vo);
		return "redirect:/board/list";
	}
	
	//삭제
	@GetMapping("/board/delete")
	public String deleteProc(int bno) {
		boardService.delete(bno);
		return "redirect:/board/list";
	}
	
	//다운로드
	@GetMapping("/download/{filename}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String filename) throws MalformedURLException {
		// 파일 경로 설정
		Path filePath = Paths.get("D:/upload").resolve(filename).normalize();

		// 파일을 Resource 로 로드
		Resource resource = new UrlResource(filePath.toUri());
		if (!resource.exists()) {
			return ResponseEntity.notFound().build();
		}

		// Content-Disposition 헤더에 다운로드용 파일명 지정
		String contentDisposition = "attachment; filename=\"" + resource.getFilename() + "\"";

		return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM) // 이진 파일
				.header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition).body(resource);
	}
}
