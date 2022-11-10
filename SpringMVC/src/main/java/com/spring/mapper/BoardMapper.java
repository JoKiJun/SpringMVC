package com.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.entity.Board;

@Mapper
public interface BoardMapper {

	public List<Board> getLists(); // 전체 리스트
}
