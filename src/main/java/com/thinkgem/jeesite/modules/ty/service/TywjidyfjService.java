/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.ty.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.ty.entity.Tywjidyfj;
import com.thinkgem.jeesite.modules.ty.dao.TywjidyfjDao;

/**
 * 增删改查Service
 * @author gxh
 * @version 2018-12-14
 */
@Service
@Transactional(readOnly = true)
public class TywjidyfjService extends CrudService<TywjidyfjDao, Tywjidyfj> {

	public Tywjidyfj get(String id) {
		return super.get(id);
	}
	
	public List<Tywjidyfj> findList(Tywjidyfj tywjidyfj) {
		return super.findList(tywjidyfj);
	}
	
	public Page<Tywjidyfj> findPage(Page<Tywjidyfj> page, Tywjidyfj tywjidyfj) {
		return super.findPage(page, tywjidyfj);
	}
	
	@Transactional(readOnly = false)
	public void save(Tywjidyfj tywjidyfj) {
		super.save(tywjidyfj);
	}
	
	@Transactional(readOnly = false)
	public void delete(Tywjidyfj tywjidyfj) {
		super.delete(tywjidyfj);
	}
	
}