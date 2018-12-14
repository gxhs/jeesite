/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.ty.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 艺海画库Entity
 * @author wf
 * @version 2018-12-14
 */
public class Tywjingphk extends DataEntity<Tywjingphk> {
	
	private static final long serialVersionUID = 1L;
	private String price;		// 价格
	private String name;		// 名称
	private String introduction;		// 简介
	private String thumb;		// 缩略图
	private String hD;		// 高清图
	
	public Tywjingphk() {
		super();
	}

	public Tywjingphk(String id){
		super(id);
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	@Length(min=0, max=50, message="名称长度必须介于 0 和 50 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=1500, message="简介长度必须介于 0 和 1500 之间")
	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	@Length(min=0, max=100, message="缩略图长度必须介于 0 和 100 之间")
	public String getThumb() {
		return thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}
	
	@Length(min=0, max=100, message="高清图长度必须介于 0 和 100 之间")
	public String getHD() {
		return hD;
	}

	public void setHD(String hD) {
		this.hD = hD;
	}
	
}