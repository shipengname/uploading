package com.shipeng.service;

import java.util.List;

import com.shipeng.bean.Picture;

public interface PictureService {

	List<Picture> list();

	int add(Picture picture);

}
