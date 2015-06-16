package org.kosta.madfortaste.taste.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.kosta.madfortaste.taste.domain.TastyPlace;
import org.kosta.madfortaste.taste.service.TastyPlaceService;
import org.kosta.madfortaste.user.domain.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
public class TastyPlaceController {
	@Autowired
	private TastyPlaceService tastyPlaceService;
	
	@RequestMapping("insertTastyPlace")
	public String insertTastyPlace(TastyPlace tastyPlace){
		tastyPlaceService.insertTastyPlace(tastyPlace);
		return "redirect:owner/result/tasty_register_result";
	}
	@RequestMapping("updateTastyPlace")
	public String updateTastyPlace(TastyPlace tastyPlace){
		tastyPlaceService.updateTastyPlace(tastyPlace);
		return "redirect:owner/result/tasty_update_result";
	}
	@RequestMapping("ownerDeleteForm")
	public String ownerDeleteForm(Model model,HttpServletRequest req){
		Owner owner=(Owner)req.getSession(false).getAttribute("owner");
		List<TastyPlace> list=tastyPlaceService.selectTastyPlaceGetAllList(owner.getOwnerId());
		model.addAttribute("list", list);
		return "user/tastyDeleteForm";
	}
	
	@RequestMapping("brNoCheckAjax")
	@ResponseBody
	public List<String> checkDuplicateBrNo(String brNo){
		TastyPlace tastyPlace=null;
		tastyPlace=tastyPlaceService.selectTastyPlaceById(brNo);
		List<String> list=new ArrayList<String>();
		if(tastyPlace!=null)
			list.add("FAIL");
		else
			list.add("SUCCESS");
		return list;
	}
	
	@RequestMapping(value="brNoselectByIdAjax")
	@ResponseBody
	public TastyPlace selectBrNoById(String brNo){
		System.out.println(brNo);
		TastyPlace tastyPlace=tastyPlaceService.selectTastyPlaceById(brNo);
		System.out.println(tastyPlace);
		return tastyPlace;
	}
	
	@RequestMapping("deleteTastyPlace")
	public String deleteTastyPlace(String id){
		tastyPlaceService.deleteTastyPlace(id);
		return "redirect:/";
	}
	
	@RequestMapping("tastyUpdateForm")
	public String tastyUpdateForm(String id,Model model){
		List<TastyPlace> list=tastyPlaceService.selectTastyPlaceGetAllList(id);
		model.addAttribute("list", list);
		return "user/tastyUpdateForm";
	}
}
