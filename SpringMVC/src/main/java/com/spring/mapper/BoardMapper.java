package com.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import com.spring.entity.Board;

@Mapper // Mybatis API
public interface BoardMapper {

	public List<Board> getLists(); // 전체 리스트
	
	public void boardInsert(Board vo);
	
	public Board boardContent(int idx); // 상세보기
	
	public void boardDelete(int idx); // 삭제
	
	public void boardUpdate(Board vo); // 수정
	
	@Update("update myboard set count=count+1 where idx=#{idx}")
	public void boardCount(int idx); // 조회수
}
