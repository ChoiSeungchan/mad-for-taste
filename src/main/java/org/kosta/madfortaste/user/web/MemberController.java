package org.kosta.madfortaste.user.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.kosta.madfortaste.taste.domain.Restaurant;
import org.kosta.madfortaste.taste.service.RestaurantService;
import org.kosta.madfortaste.user.domain.Member;
import org.kosta.madfortaste.user.service.LoginService;
import org.kosta.madfortaste.user.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@Inject
	private RestaurantService restaurantService;
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="member/{viewName1}/{viewName2}")
	public String test(@PathVariable String viewName1, @PathVariable String viewName2) {
		return "user/" + viewName1 + "/" +viewName2;
	}
	
	@RequestMapping(value="memberRegisterForm")
	public String memberRegisterForm(@ModelAttribute Member member, Model model) {
		model.addAttribute("listDo", memberService.selectSi());
		return "user/memberRegisterForm";
	}

	@RequestMapping(value="memberUpdateForm")
	public String updateMemberForm (@ModelAttribute Member member, Model model) {
		model.addAttribute("listDo", memberService.selectSi());
		return "user/memberUpdateForm";
	}
	
	@ResponseBody
	@RequestMapping(value="memberIdCheck.json")
	public Map<String, Object> memberIdCheck(String memberId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Member member = memberService.selectMemberById(memberId);
		if (member==null) {
			map.put("result", "true");
		} else {
			map.put("result", "false");
		}
		return map;
	}
	
	@RequestMapping(value="registerMember", method=RequestMethod.POST)
	public String registerMember(@Valid Member member, BindingResult result,  HttpServletRequest req, Model model) {
		if(result.hasErrors()){
			model.addAttribute("listDo", memberService.selectSi());
			return "user/memberRegisterForm";
		}
		try {
			memberService.insertMember(member, req);
			loginService.login(member.getId(), member.getPassword(), req);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:member/result/member_register_result";
	}
	
	@RequestMapping(value="updateMember", method=RequestMethod.POST)
	public String updateMember(@Valid Member member, BindingResult result, Model model, HttpServletRequest req) {
		if(result.hasErrors()){
			return "user/memberUpdateForm";
		}
		try {
			memberService.updateMember(member, req);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:reLogin";
	}
	
	@RequestMapping(value="deleteMember")
	public String deleteMember(HttpSession session) {
		Member member = (Member) session.getAttribute("member");
		if(member!=null)
		memberService.deleteMember(member.getId());		
		return "redirect:logout";
	}
	
	@RequestMapping(value="upExp")
	public String upExp(HttpSession session) {
		Member member = (Member) session.getAttribute("member");
		if(member!=null)
		memberService.upExp(member.getId(), new Random().nextInt(500));
		return "redirect:reLogin";
	}
	
	@RequestMapping(value="upPoint")
	public String upPoint(HttpSession session) {
		Member member = (Member) session.getAttribute("member");
		if(member!=null)
		memberService.upPoint(member.getId(), new Random().nextInt(500));
		return "redirect:reLogin";
	}
	
	@RequestMapping(value="downPoint")
	public String downPoint(HttpSession session) {
		Member member = (Member) session.getAttribute("member");
		if(member!=null)
		memberService.downPoint(member.getId(), new Random().nextInt(500));
		return "redirect:reLogin";
	}
	
	@ResponseBody
	@RequestMapping(value="dailyCheck")
	public Map<String, Object> dailyCheck (HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		Member member = (Member) session.getAttribute("member");
		if(member!=null) {
			boolean flag = memberService.dailyCheck(member.getId());
			if(flag) {
				int randomExp = new Random().nextInt(100) + 1;
				int randomPoint = new Random().nextInt(100) + 1;
				memberService.upExp(member.getId(), randomExp);
				memberService.upPoint(member.getId(), randomPoint);
				map.put("exp", randomExp);
				map.put("point", randomPoint);
				map.put("result", "success");
			} else {
				map.put("result", "failure");
			}
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="memberRank.json")
	public List<Member> getMemberRank () {
		List<Member> memberList = memberService.selectMemberListOrderByExp(1); 
		return memberList;
	}
	
	@RequestMapping(value="memberAdmin/{pageNo}") 
	public String memberAdmin(@PathVariable int pageNo, Model model) {
		model.addAttribute("container", memberService.selectMemberList(pageNo));
		return "user/admin/memberAdmin";
	}
	
	@ResponseBody
	@RequestMapping(value="memberAdmin/deleteMember.ajax")
	public Map<String, Object> deleteMemberAjax(String memberArray) {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(memberArray);
		String member[] = memberArray.split("/");
		for (String memberId : member) {
			memberService.deleteMember(memberId);
		}
		return map;
	}
	
	@RequestMapping("memberAddressNearByRestaurantService")
	//회원 정보(주소) 가지고 모든 레스토랑 검색하는 서비스
	public String memberAddressNearByRestaurantService(Model model,HttpServletRequest rq){
		Member member=(Member)rq.getSession(false).getAttribute("member");
		Map<String, String> map=new HashMap<String, String>();
		member.setSigungu("  "+member.getSigungu());
		member.setEupmyeondong("  "+member.getEupmyeondong());
		map.put("si", member.getCity());
		map.put("gu", member.getSigungu());
		map.put("dong", member.getEupmyeondong());
		List<Restaurant> list=restaurantService.selectRestaurantNearByAddress(map);
		model.addAttribute("restaurantList", list);
		return "user/result/restaurantService";
	}
}
