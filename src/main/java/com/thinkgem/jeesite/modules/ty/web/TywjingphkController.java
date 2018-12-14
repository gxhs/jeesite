/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.ty.web;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.ty.entity.Tywjingphk;
import com.thinkgem.jeesite.modules.ty.service.TywjingphkService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 艺海画库Controller
 * @author wf
 * @version 2018-12-14
 */
@Controller
@RequestMapping(value = "${adminPath}/ty/tywjingphk")
public class TywjingphkController extends BaseController {

	@Autowired
	private TywjingphkService tywjingphkService;
	
	@ModelAttribute
	public Tywjingphk get(@RequestParam(required=false) String id) {
		Tywjingphk entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tywjingphkService.get(id);
		}
		if (entity == null){
			entity = new Tywjingphk();
		}
		return entity;
	}
	
	@RequiresPermissions("ty:tywjingphk:view")
	@RequestMapping(value = {"list", ""})
	public String list(Tywjingphk tywjingphk, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Tywjingphk> page = tywjingphkService.findPage(new Page<Tywjingphk>(request, response), tywjingphk); 
		model.addAttribute("page", page);
		return "modules/ty/tywjingphkList";
	}

	@RequiresPermissions("ty:tywjingphk:view")
	@RequestMapping(value = "form")
	public String form(Tywjingphk tywjingphk, Model model) {
		model.addAttribute("tywjingphk", tywjingphk);
		return "modules/ty/tywjingphkForm";
	}

	@RequiresPermissions("ty:tywjingphk:edit")
	@RequestMapping(value = "save")
	public String save(Tywjingphk tywjingphk, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tywjingphk)){
			return form(tywjingphk, model);
		}
		tywjingphkService.save(tywjingphk);
		addMessage(redirectAttributes, "保存艺海画库成功");
		return "redirect:"+Global.getAdminPath()+"/ty/tywjingphk/?repage";
	}
	
	@RequiresPermissions("ty:tywjingphk:edit")
	@RequestMapping(value = "delete")
	public String delete(Tywjingphk tywjingphk, RedirectAttributes redirectAttributes) {
		tywjingphkService.delete(tywjingphk);
		addMessage(redirectAttributes, "删除艺海画库成功");
		return "redirect:"+Global.getAdminPath()+"/ty/tywjingphk/?repage";
	}

}