package com.shipeng.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.shipeng.bean.Picture;
import com.shipeng.service.PictureService;

@Controller
public class PictureController {

	@Autowired
	private PictureService service;
		
	@RequestMapping("list")
	public String list(Model m) {
		List<Picture> list=service.list();
		m.addAttribute("list", list);
		return "list";
	}
	@RequestMapping("publish")
	public String publish(Picture picture,MultipartFile file) {
		String path="d:/pic/";
		String filename = file.getOriginalFilename();
		String newName = UUID.randomUUID().toString();
		File file2 = new File(path+newName+filename);
		try {
			file.transferTo(file2);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		picture.setMagger(newName+filename);
		int result=service.add(picture);
		if(result>0) {
			return "redirect:list";
		}
		return "redirect:list";
	}
	@ResponseBody
	@RequestMapping("publish1")
	public boolean publish1(Picture picture,MultipartFile file) {
		String path="d:/pic/";
		String filename = file.getOriginalFilename();
		String newName = UUID.randomUUID().toString();
		File file2 = new File(path+newName+filename);
		try {
			file.transferTo(file2);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		picture.setMagger(newName+filename);
		int result=service.add(picture);
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}
}
