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
import com.thinkgem.jeesite.modules.ty.entity.Tywshangjhy;
import com.thinkgem.jeesite.modules.ty.service.TywshangjhyService;

/**
 * 商家信息Controller
 * @author gx
 * @version 2018-12-14
 */
@Controller
@RequestMapping(value = "${adminPath}/ty/tywshangjhy")
public class TywshangjhyController extends BaseController {

	@Autowired
	private TywshangjhyService tywshangjhyService;
	
	@ModelAttribute
	public Tywshangjhy get(@RequestParam(required=false) String id) {
		Tywshangjhy entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tywshangjhyService.get(id);
		}
		if (entity == null){
			entity = new Tywshangjhy();
		}
		return entity;
	}
	
	@RequiresPermissions("ty:tywshangjhy:view")
	@RequestMapping(value = {"list", ""})
	public String list(Tywshangjhy tywshangjhy, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Tywshangjhy> page = tywshangjhyService.findPage(new Page<Tywshangjhy>(request, response), tywshangjhy); 
		model.addAttribute("page", page);
		return "modules/ty/tywshangjhyList";
	}

	@RequiresPermissions("ty:tywshangjhy:view")
	@RequestMapping(value = "form")
	public String form(Tywshangjhy tywshangjhy, Model model) {
		model.addAttribute("tywshangjhy", tywshangjhy);
		return "modules/ty/tywshangjhyForm";
	}

	@RequiresPermissions("ty:tywshangjhy:edit")
	@RequestMapping(value = "save")
	public String save(Tywshangjhy tywshangjhy, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tywshangjhy)){
			return form(tywshangjhy, model);
		}
		tywshangjhyService.save(tywshangjhy);
		addMessage(redirectAttributes, "保存商家信息成功");
		return "redirect:"+Global.getAdminPath()+"/ty/tywshangjhy/?repage";
	}
	
	@RequiresPermissions("ty:tywshangjhy:edit")
	@RequestMapping(value = "delete")
	public String delete(Tywshangjhy tywshangjhy, RedirectAttributes redirectAttributes) {
		tywshangjhyService.delete(tywshangjhy);
		addMessage(redirectAttributes, "删除商家信息成功");
		return "redirect:"+Global.getAdminPath()+"/ty/tywshangjhy/?repage";
	}

}