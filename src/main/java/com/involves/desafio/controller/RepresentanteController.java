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

import com.involves.desafio.entity.Representante;
import com.involves.desafio.service.RepresentanteService;

@Controller
@RequestMapping("/representante")
public class RepresentanteController {

	@Autowired
	private RepresentanteService representanteService;
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(Model model) {
		return edit(model, null);
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(Model model, @PathVariable Long id) {

		Representante representante = new Representante();
		
		if (id != null)	representante = representanteService.findById(id).get();

		model.addAttribute("representante", representante);

		return "representante/edit";
	}
	
	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public String home(Model model) {

		return "redirect:/representante/list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<Representante> representantes = representanteService.findAll();
		model.addAttribute("representantes", representantes);
		
		return "representante/list";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Model model,
			@Valid @ModelAttribute("representante") Representante representante, BindingResult result,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) return "/representante/edit";

		representanteService.save(representante);
		model.addAttribute("mensagem", "Representante " + representante.getId()+ " criada/atualizada com sucesso.");

		return "redirect:/representante/list";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Long id,
			RedirectAttributes redirectAttributes) {
		representanteService.deleteLogic(id);

		redirectAttributes.addFlashAttribute("mensagem", "Representante " + id+ " removida com sucesso.");

		return "redirect:/representante/list";
	}
	

}
