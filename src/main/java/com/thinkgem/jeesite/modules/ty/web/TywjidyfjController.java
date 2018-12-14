/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.ty.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.ty.entity.Tywjidyfj;
import com.thinkgem.jeesite.modules.ty.service.TywjidyfjService;

/**
 * 增删改查Controller
 * @author gxh
 * @version 2018-12-14
 */
@Controller
@RequestMapping(value = "${adminPath}/ty/tywjidyfj")
public class TywjidyfjController extends BaseController {

	@Autowired
	private TywjidyfjService tywjidyfjService;
	
	@ModelAttribute
	public Tywjidyfj get(@RequestParam(required=false) String id) {
		Tywjidyfj entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tywjidyfjService.get(id);
		}
		if (entity == null){
			entity = new Tywjidyfj();
		}
		return entity;
	}
	
	@RequiresPermissions("ty:tywjidyfj:view")
	@RequestMapping(value = {"list", ""})
	public String list(Tywjidyfj tywjidyfj, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Tywjidyfj> page = tywjidyfjService.findPage(new Page<Tywjidyfj>(request, response), tywjidyfj); 
		model.addAttribute("page", page);
		return "modules/ty/tywjidyfjList";
	}

	@RequiresPermissions("ty:tywjidyfj:view")
	@RequestMapping(value = "form")
	public String form(Tywjidyfj tywjidyfj, Model model) {
		model.addAttribute("tywjidyfj", tywjidyfj);
		return "modules/ty/tywjidyfjForm";
	}

	@RequiresPermissions("ty:tywjidyfj:edit")
	@RequestMapping(value = "save")
	public String save(Tywjidyfj tywjidyfj, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tywjidyfj)){
			return form(tywjidyfj, model);
		}
		tywjidyfjService.save(tywjidyfj);
		addMessage(redirectAttributes, "保存保存成功");
		return "redirect:"+Global.getAdminPath()+"/ty/tywjidyfj/?repage";
	}
	
	@RequiresPermissions("ty:tywjidyfj:edit")
	@RequestMapping(value = "delete")
	public String delete(Tywjidyfj tywjidyfj, RedirectAttributes redirectAttributes) {
		tywjidyfjService.delete(tywjidyfj);
		addMessage(redirectAttributes, "删除保存成功");
		return "redirect:"+Global.getAdminPath()+"/ty/tywjidyfj/?repage";
	}

}