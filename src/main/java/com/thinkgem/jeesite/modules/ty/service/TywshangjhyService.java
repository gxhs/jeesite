/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.ty.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.ty.entity.Tywshangjhy;
import com.thinkgem.jeesite.modules.ty.dao.TywshangjhyDao;

/**
 * 商家信息Service
 * @author gx
 * @version 2018-12-14
 */
@Service
@Transactional(readOnly = true)
public class TywshangjhyService extends CrudService<TywshangjhyDao, Tywshangjhy> {

	public Tywshangjhy get(String id) {
		return super.get(id);
	}
	
	public List<Tywshangjhy> findList(Tywshangjhy tywshangjhy) {
		return super.findList(tywshangjhy);
	}
	
	public Page<Tywshangjhy> findPage(Page<Tywshangjhy> page, Tywshangjhy tywshangjhy) {
		return super.findPage(page, tywshangjhy);
	}
	
	@Transactional(readOnly = false)
	public void save(Tywshangjhy tywshangjhy) {
		super.save(tywshangjhy);
	}
	
	@Transactional(readOnly = false)
	public void delete(Tywshangjhy tywshangjhy) {
		super.delete(tywshangjhy);
	}
	
}