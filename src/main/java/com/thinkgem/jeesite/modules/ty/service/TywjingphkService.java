/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.ty.service;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.ty.dao.TywjingphkDao;
import com.thinkgem.jeesite.modules.ty.entity.Tywjingphk;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 艺海画库Service
 * @author wf
 * @version 2018-12-14
 */
@Service
@Transactional(readOnly = true)
public class TywjingphkService extends CrudService<TywjingphkDao, Tywjingphk> {

	public Tywjingphk get(String id) {
		return super.get(id);
	}
	
	public List<Tywjingphk> findList(Tywjingphk tywjingphk) {
		return super.findList(tywjingphk);
	}
	
	public Page<Tywjingphk> findPage(Page<Tywjingphk> page, Tywjingphk tywjingphk) {
		return super.findPage(page, tywjingphk);
	}
	
	@Transactional(readOnly = false)
	public void save(Tywjingphk tywjingphk) {
		super.save(tywjingphk);
	}
	
	@Transactional(readOnly = false)
	public void delete(Tywjingphk tywjingphk) {
		super.delete(tywjingphk);
	}
	
}