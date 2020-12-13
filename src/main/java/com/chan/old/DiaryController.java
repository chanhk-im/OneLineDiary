package com.chan.old;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chan.old.vo.DiaryVO;
import com.chan.old.vo.DuserVO;
import com.chan.old.common.DiaryService;

@Controller
@RequestMapping(value = "/diary")
public class DiaryController {
	
	@Autowired
	DiaryService diaryService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String diaryList(Model model) {
		model.addAttribute("list", diaryService.getDiaryList());
		return "list";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addPost() {
		return "addpostform";
	}
	
	@RequestMapping(value = "/addok", method = RequestMethod.POST)
	public String addPostOk(DiaryVO vo) {
		if (diaryService.insertDiary(vo) == 0) {
			System.out.println("데이터 추가 실패 ");
		}
		else {
			System.out.println("데이터 추가 성공!");
		}
		return "redirect:list";
	}
	
	@RequestMapping(value = "/editform/{id}", method = RequestMethod.GET)
	public String editPost(@PathVariable("id") int id, Model model, HttpSession session) {
		DiaryVO diaryVO = diaryService.getDiary(id);
		DuserVO duserVO = (DuserVO)session.getAttribute("login");
		
		if (diaryVO.getWriter().equals(duserVO.getUsername())) {
			model.addAttribute("u", diaryVO);
			return "editform";
		}
		
		model.addAttribute("msg", "작성자가 아니므로 수정할 수 없습니다!");
		model.addAttribute("url", "../list");
		
		return "msgpage";
	}
	
	@RequestMapping(value = "/editok", method = RequestMethod.POST)
	public String editPostOk(DiaryVO vo) {
		if (diaryService.updateDiary(vo) == 0) {
			System.out.println("데이터 수정 실패 ");
		}
		else {
			System.out.println("데이터 수정 성공!");
		}
		return "redirect:list";
	}
	
	@RequestMapping(value = "/deleteok/{id}", method = RequestMethod.GET)
	public String deletePostOk(@PathVariable("id") int id, Model model, HttpSession session) {
		DiaryVO diaryVO = diaryService.getDiary(id);
		DuserVO duserVO = (DuserVO)session.getAttribute("login");
		
		if (diaryVO.getWriter().equals(duserVO.getUsername())) {
			if (diaryService.deleteDiary(id) == 0) {
				System.out.println("데이터 삭제 실패 ");
			}
			else {
				System.out.println("데이터 삭제 성공!");
			}
			return "redirect:../list";
		}
		
		model.addAttribute("msg", "작성자가 아니므로 삭제할 수 없습니다!");
		model.addAttribute("url", "../list");
		
		return "msgpage";
		
	}
}
