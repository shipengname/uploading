package com.shipeng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shipeng.bean.Picture;
import com.shipeng.dao.PictureDao;
import com.shipeng.service.PictureService;
@Service
public class PictureServiceImpl implements PictureService {

	@Autowired
	private PictureDao adao;
	@Override
	public List<Picture> list() {
		
		return adao.list();
	}
	@Override
	public int add(Picture picture) {
		return adao.add(picture);
	}

}
