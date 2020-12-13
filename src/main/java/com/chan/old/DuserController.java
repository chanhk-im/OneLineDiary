package com.chan.old;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chan.old.common.DuserService;
import com.chan.old.vo.DuserVO;

@Controller
@RequestMapping(value = "/duser")
public class DuserController {
	
	@Autowired
	DuserService duserService;
	
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String signIn() {
		return "signin";
	}
	
	@RequestMapping(value = "/signinok", method = RequestMethod.POST)
	public String signInOk(DuserVO vo) {
		int checkSignIn = duserService.insertDuser(vo);
		if (checkSignIn == 0) {
			System.out.println("회원 가입 실패...");
		}
		else if (checkSignIn == 2) {
			System.out.println("id가 이미 존재합니다...");
		}
		else {
			System.out.println("회원 가입 성공!!");
		}
		return "redirect:/duser/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(String t, Model model) {
		return "login";
	}
	
	@RequestMapping(value="/loginOK", method=RequestMethod.POST)
	public String loginCheck(HttpSession session, DuserVO vo) {
		String returnURL = "";
		if (session.getAttribute("login") != null) {
			session.removeAttribute("login");
		}
		
		DuserVO loginvo = duserService.getDuser(vo);
		
		if (loginvo != null) { 	// 로그인 성공
			System.out.println("로그인 성공!");
			session.setAttribute("login", loginvo);
			returnURL = "redirect:/diary/list";
		}
		else {					// 로그인 실패
			System.out.println("로그인 실패!");
			returnURL = "redirect:/duser/login";
		}
		return returnURL;
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/duser/login";
	}
}
