package com.java.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.mvc.dao.DemartDaoImpl;
import com.java.mvc.model.Demart;

@Controller
public class HomeController {
	
	@Autowired
	DemartDaoImpl dao;
	
	@RequestMapping(value = "/addDemart")
	public ModelAndView addDemart(HttpServletRequest req) {
		Demart demart = new Demart();
		demart.setName(req.getParameter("name"));
		demart.setProduct(req.getParameter("product"));
		demart.setPrice(Integer.parseInt(req.getParameter("price")));
		dao.addDemart(demart);
		return new ModelAndView("redirect:/");
	}
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		List<Demart> demartlist = dao.showDemart();
		return new ModelAndView("home","demartlist",demartlist);
	}
	
	@RequestMapping(value="/newDemart")
	public ModelAndView addDemart() {
		return new ModelAndView("addDemart");
	}
	
	@RequestMapping(value="/deleteDemart")
	public ModelAndView deleteDemart(HttpServletRequest req) {
		int id=Integer.parseInt(req.getParameter("id"));
		dao.deleteDemart(id);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/editDemart")
	public ModelAndView search(HttpServletRequest req) {
		int id = Integer.parseInt(req.getParameter("id"));
		Demart demart = dao.searchDemart(id);
		return new ModelAndView("demartsearchform","demart",demart);
	}
	
	@RequestMapping(value="/updateDemart")
	public ModelAndView updateDemart(HttpServletRequest req) {
		Demart demart = new Demart();
		demart.setId(Integer.parseInt(req.getParameter("id")));
		demart.setName(req.getParameter("name"));
		demart.setProduct(req.getParameter("product"));
		demart.setPrice(Integer.parseInt(req.getParameter("price")));
		dao.updateDemart(demart);
		return new ModelAndView("redirect:/");
	}
	
}
