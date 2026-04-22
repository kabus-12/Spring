package com.example.demo.board.service;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class BoardVO {

	private Integer bno;
	private String title;
	private String content;
	private String writer;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date regdate;
	private String attach;
	
}
