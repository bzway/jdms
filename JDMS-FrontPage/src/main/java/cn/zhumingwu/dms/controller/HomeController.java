package cn.zhumingwu.dms.controller;
import java.awt.List;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.zhumingwu.dms.dao.Member;

@Controller
public class HomeController {

	// @Autowired
	// private UserMapper accountMapper;

	@Value("${spring.profiles.active}")
	private String appName;

	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("home/index");
		mav.addObject("messages", this.appName);
		return mav;
	}
	
	@RequestMapping("/greeting")
	public String greet(Model model) {
		model.addAttribute("messages", this.appName);
		return "home/greet";
	}

	@RequestMapping("/messages")
	public String messageList(HttpSession session) {
		return "home/messages";
	}

	@ModelAttribute("messageList")
	public ArrayList<Member> messages() {

		ArrayList<Member> memberList = new ArrayList<Member>();
		Member member = new Member();
		member.setName("Adm Zhu");
		member.setGender(1);

		memberList.add(member);
		member = new Member();
		member.setName("Jack Chen");
		member.setGender(1);

		memberList.add(member);
		return memberList;
	}
}
