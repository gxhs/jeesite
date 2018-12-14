/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.ty.service;

import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.ty.entity.Tywjidyfj;
import com.thinkgem.jeesite.modules.ty.dao.TywjidyfjDao;
import com.thinkgem.jeesite.modules.cms.utils.CmsUtils;


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
		if (tywjidyfj.getJqjs()!=null){
			tywjidyfj.setJqjs(StringEscapeUtils.unescapeHtml4(tywjidyfj.getJqjs()));
		}
		super.save(tywjidyfj);
		CmsUtils.removeCache("tywjidyfj_"+tywjidyfj.getId());
		CmsUtils.removeCache("tywjidyfjList");
	}

	@Transactional(readOnly = false)
	public void delete(Tywjidyfj tywjidyfj) {
		super.delete(tywjidyfj);
	}
	
}