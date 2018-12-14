/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.ty.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 商家信息Entity
 * @author gx
 * @version 2018-12-14
 */
public class Tywshangjhy extends DataEntity<Tywshangjhy> {
	
	private static final long serialVersionUID = 1L;
	private String tywId;		// tyw_id
	private String danwmc;		// danwmc
	private String shangjlx;		// shangjlx
	private String wenzjs;		// wenzjs
	private String huiyzc;		// huiyzc
	private String zkfd;		// zkfd
	private String dlwz;		// dlwz
	private String wd;		// wd
	private String jd;		// jd
	private String lianxr;		// lianxr
	private String lxdh;		// lxdh
	private String pxh;		// pxh
	
	public Tywshangjhy() {
		super();
	}

	public Tywshangjhy(String id){
		super(id);
	}

	@Length(min=0, max=50, message="tyw_id长度必须介于 0 和 50 之间")
	public String getTywId() {
		return tywId;
	}

	public void setTywId(String tywId) {
		this.tywId = tywId;
	}
	
	@Length(min=0, max=50, message="danwmc长度必须介于 0 和 50 之间")
	public String getDanwmc() {
		return danwmc;
	}

	public void setDanwmc(String danwmc) {
		this.danwmc = danwmc;
	}
	
	@Length(min=0, max=1, message="shangjlx长度必须介于 0 和 1 之间")
	public String getShangjlx() {
		return shangjlx;
	}

	public void setShangjlx(String shangjlx) {
		this.shangjlx = shangjlx;
	}
	
	@Length(min=0, max=50, message="wenzjs长度必须介于 0 和 50 之间")
	public String getWenzjs() {
		return wenzjs;
	}

	public void setWenzjs(String wenzjs) {
		this.wenzjs = wenzjs;
	}
	
	@Length(min=0, max=200, message="huiyzc长度必须介于 0 和 200 之间")
	public String getHuiyzc() {
		return huiyzc;
	}

	public void setHuiyzc(String huiyzc) {
		this.huiyzc = huiyzc;
	}
	
	public String getZkfd() {
		return zkfd;
	}

	public void setZkfd(String zkfd) {
		this.zkfd = zkfd;
	}
	
	@Length(min=0, max=50, message="dlwz长度必须介于 0 和 50 之间")
	public String getDlwz() {
		return dlwz;
	}

	public void setDlwz(String dlwz) {
		this.dlwz = dlwz;
	}
	
	public String getWd() {
		return wd;
	}

	public void setWd(String wd) {
		this.wd = wd;
	}
	
	public String getJd() {
		return jd;
	}

	public void setJd(String jd) {
		this.jd = jd;
	}
	
	@Length(min=0, max=50, message="lianxr长度必须介于 0 和 50 之间")
	public String getLianxr() {
		return lianxr;
	}

	public void setLianxr(String lianxr) {
		this.lianxr = lianxr;
	}
	
	@Length(min=0, max=20, message="lxdh长度必须介于 0 和 20 之间")
	public String getLxdh() {
		return lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	
	@Length(min=0, max=11, message="pxh长度必须介于 0 和 11 之间")
	public String getPxh() {
		return pxh;
	}

	public void setPxh(String pxh) {
		this.pxh = pxh;
	}
	
}