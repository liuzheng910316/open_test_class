package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Course;
import com.example.demo.model.Suscribe;
import com.example.demo.service.impl.SuscribeServiceImpl;

@Controller
@RequestMapping(value="/suscribe")
public class SuscribeController {
	@Autowired
	SuscribeServiceImpl suscribeService;
	@RequestMapping(value="/add")
	public void add(@ModelAttribute Suscribe suscribe,
			HttpServletRequest req,HttpServletResponse resp) throws Exception{
		suscribeService.addSuscribe(suscribe);
		resp.getWriter().print("创建成功");
	}
	
	
	@RequestMapping(value="/delete")
	public void delete(int suscribeId,
			HttpServletRequest req,HttpServletResponse resp) throws Exception{
		suscribeService.deleteSuscribe(suscribeId);
		resp.getWriter().print("删除成功");
	}
}
