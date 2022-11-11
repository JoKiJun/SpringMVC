package com.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.entity.Board;
import com.spring.mapper.BoardMapper;

@Controller
public class BoardController {

	@Autowired
	private BoardMapper mapper;
	
	@RequestMapping("/boardList.do")
	public String boardList(Model model) {
		
		List<Board> list = mapper.getLists(); 
		model.addAttribute("list", list);
		return "boardList";
	}
	@GetMapping("/boardForm.do")
	public String boardForm() {
		return "boardForm";
	}
	@PostMapping("/boardInsert.do")
	public String boardInsert(Board vo) { // title,content, writer 파라메터수집(Board)
		mapper.boardInsert(vo); // 등록
		
		return "redirect:/boardList.do";
	}
	@GetMapping("/boardContent.do")
	public String boardContent(@RequestParam("idx") int idx, Model model ) { // ?idx=6
		Board vo = mapper.boardContent(idx);
		model.addAttribute("vo", vo); // #{vo.idx}.. 
		return "boardContent";
	}
	@GetMapping("boardDelete.do/{idx}")
	public String boardDelete(@PathVariable("idx") int idx) { // ?idx=6
		mapper.boardDelete(idx); // 삭제
		return "redirect:/boardList.do";
	}
}
