package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReplyRestController {
	
	@Autowired ReplyRepository replyRepository;
	
	//등록
	@PostMapping("/")
	public Reply insert(@RequestBody Reply re) {
		Reply result = replyRepository.save(re);
		
		Reply reply = replyRepository.findById(result.getRno()).get();
		return reply;
	}
	
	@PutMapping("/")
	public Reply update(@RequestBody Reply re) {
		
		Reply result = replyRepository.save(re);
		Reply reply = replyRepository.findById(result.getRno()).get();
		return reply;
	}
	
	@DeleteMapping("/{re}")
	public void delete(@PathVariable Reply re) {
		replyRepository.delete(re);
	}
	
	@GetMapping("/{re}")
	public Reply selectOne(@PathVariable Reply re) {
		Reply select = replyRepository.findById(re.getRno()).get();
		
		return select;
	}
	
	@GetMapping("/")
	public List<Reply> selectAll(@RequestBody Reply re) {
		List<Reply> select = replyRepository.findAll();
		
		return select;
	}
}
