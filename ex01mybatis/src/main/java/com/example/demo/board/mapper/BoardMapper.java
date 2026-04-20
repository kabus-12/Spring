package com.example.demo.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.board.BoardVO;

@Mapper
public interface BoardMapper {
	int selectAll_COUNT(BoardVO board);
	List<BoardVO> getList(BoardVO board);
	BoardVO read(int bno);
	int insert(BoardVO board);
	int update(BoardVO board);
	int delete(int bno);
}
