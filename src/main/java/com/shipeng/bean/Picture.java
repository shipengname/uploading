package com.shipeng.bean;

public class Picture {
	private Integer id;
	private String magger;
	@Override
	public String toString() {
		return "Picture [id=" + id + ", magger=" + magger + "]";
	}
	public Picture() {
		super();
	}
	public Picture(Integer id, String magger) {
		super();
		this.id = id;
		this.magger = magger;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMagger() {
		return magger;
	}
	public void setMagger(String magger) {
		this.magger = magger;
	}
}
