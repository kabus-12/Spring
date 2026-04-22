package com.example.demo.board.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.service.BoardService;
import com.example.demo.board.service.BoardVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

	
	private final BoardMapper boardMapper;
	@Override
	public PageInfo<Object> getList(BoardVO board, int pageNum) {
		PageInfo<Object> page = PageHelper.startPage(pageNum,5).doSelectPageInfo(() -> boardMapper.getList(board));
		log.info("TotalCount : {}, CurrentPage : {}, PageSize : {}, TotalPage{}"
				,page.getTotal()
				,page.getPageSize()
				,page.isHasNextPage()
				,page.isHasPreviousPage()
				,page.getPrePage()
				,page.getNextPage()
				,page.getNavigatepageNums());
		System.out.println(page.getList());
		return page;
	}

	@Override
	public BoardVO read(int bno) {
		// TODO Auto-generated method stub
		return boardMapper.read(bno);
	}

	@Override
	public int insert(BoardVO board) {
		// TODO Auto-generated method stub
		return boardMapper.insert(board);
	}

	@Override
	public int update(BoardVO board) {
		// TODO Auto-generated method stub
		return boardMapper.update(board);
	}

	@Override
	public int delete(int bno) {
		// TODO Auto-generated method stub
		return boardMapper.delete(bno);
	}

}
