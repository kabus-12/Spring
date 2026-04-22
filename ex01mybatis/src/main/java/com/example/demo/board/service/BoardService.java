package com.example.demo.board.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.PageInfo;

@Mapper
public interface BoardService {
	PageInfo<Object> getList(BoardVO board,int pageNum);
	BoardVO read(int bno);
	int insert(BoardVO board);
	int update(BoardVO board);
	int delete(int bno);
}
