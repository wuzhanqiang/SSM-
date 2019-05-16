package com.demo.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.po.AreaPO;
import com.demo.po.AuthorPO;
import com.demo.po.BigAuthorPO;
import com.demo.service.TestService;

@Controller
public class TestHandler {
	
	@Autowired
	private TestService ts;
	
	@RequestMapping("/alist")
	public ModelAndView getAuthorList() throws Exception{
		List<AuthorPO> list = ts.getAuthorList();
		List<BigAuthorPO> list2 = ts.getAuthorList2();
		ModelAndView mv = new ModelAndView();
		mv.addObject("alist", list);
		mv.addObject("alist2", list2);
		mv.setViewName("/test.jsp");
		return mv;
	}
	
	@RequestMapping("/ainfo")
	public ModelAndView getAreaInfo() throws Exception{
		int areaid = 2;
		AreaPO area = ts.getAreaById(areaid);
		ModelAndView mv = new ModelAndView();
		mv.addObject("area", area);
		mv.setViewName("test2.jsp");
		return mv;
	}
}
