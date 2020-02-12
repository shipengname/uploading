package com.shipeng.dao;

import java.util.List;

import com.shipeng.bean.Picture;

public interface PictureDao {

	List<Picture> list();

	int add(Picture picture);

}
