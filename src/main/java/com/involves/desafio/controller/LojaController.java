package com.involves.desafio.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.involves.desafio.entity.Loja;
import com.involves.desafio.service.LojaService;

@Controller
@RequestMapping("/loja")
public class LojaController {

	@Autowired
	private LojaService lojaService;
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(Model model) {
		return edit(model, null);
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(Model model, @PathVariable Long id) {

		Loja loja = new Loja();
		
		if (id != null)	loja = lojaService.findById(id).get();

		model.addAttribute("loja", loja);

		return "loja/edit";
	}
	
	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public String home(Model model) {

		return "redirect:/loja/list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<Loja> lojas = lojaService.findAll();
		model.addAttribute("lojas", lojas);
		
		return "loja/list";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Model model,
			@Valid @ModelAttribute("loja") Loja loja, BindingResult result,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) return "/loja/edit";

		lojaService.save(loja);
		model.addAttribute("mensagem", "Loja " + loja.getId()+ " criada/atualizada com sucesso.");

		return "redirect:/loja/list";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Long id,
			RedirectAttributes redirectAttributes) {
		lojaService.deleteLogic(id);

		redirectAttributes.addFlashAttribute("mensagem", "Loja " + id+ " removida com sucesso.");

		return "redirect:/loja/list";
	}
	

}
