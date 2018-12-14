/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.ty.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 增删改查Entity
 * @author gxh
 * @version 2018-12-14
 */
public class Tywjidyfj extends DataEntity<Tywjidyfj> {
	
	private static final long serialVersionUID = 1L;
	private String tywId;		// tyw_id
	private String mingc;		// mingc
	private String yhzc;		// yhzc
	private String jqjs;		// jqjs
	private String dlwz;		// dlwz
	private String jd;		// jd
	private String wd;		// wd
	private String lxdh;		// lxdh
	private Integer pxh;		// pxh
	private String iftuij;		// iftuij
	
	public Tywjidyfj() {
		super();
	}

	public Tywjidyfj(String id){
		super(id);
	}

	@Length(min=0, max=50, message="tyw_id长度必须介于 0 和 50 之间")
	public String getTywId() {
		return tywId;
	}

	public void setTywId(String tywId) {
		this.tywId = tywId;
	}
	
	@Length(min=0, max=50, message="mingc长度必须介于 0 和 50 之间")
	public String getMingc() {
		return mingc;
	}

	public void setMingc(String mingc) {
		this.mingc = mingc;
	}
	
	@Length(min=0, max=200, message="yhzc长度必须介于 0 和 200 之间")
	public String getYhzc() {
		return yhzc;
	}

	public void setYhzc(String yhzc) {
		this.yhzc = yhzc;
	}
	
	@Length(min=0, max=1000, message="jqjs长度必须介于 0 和 1000 之间")
	public String getJqjs() {
		return jqjs;
	}

	public void setJqjs(String jqjs) {
		this.jqjs = jqjs;
	}
	
	@Length(min=0, max=50, message="dlwz长度必须介于 0 和 50 之间")
	public String getDlwz() {
		return dlwz;
	}

	public void setDlwz(String dlwz) {
		this.dlwz = dlwz;
	}
	
	public String getJd() {
		return jd;
	}

	public void setJd(String jd) {
		this.jd = jd;
	}
	
	public String getWd() {
		return wd;
	}

	public void setWd(String wd) {
		this.wd = wd;
	}
	
	@Length(min=0, max=20, message="lxdh长度必须介于 0 和 20 之间")
	public String getLxdh() {
		return lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	
	public Integer getPxh() {
		return pxh;
	}

	public void setPxh(Integer pxh) {
		this.pxh = pxh;
	}
	
	@Length(min=0, max=1, message="iftuij长度必须介于 0 和 1 之间")
	public String getIftuij() {
		return iftuij;
	}

	public void setIftuij(String iftuij) {
		this.iftuij = iftuij;
	}
	
}