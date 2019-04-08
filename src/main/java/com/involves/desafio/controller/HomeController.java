package com.involves.desafio.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.involves.desafio.entity.Loja;
import com.involves.desafio.entity.Representante;
import com.involves.desafio.service.LojaService;
import com.involves.desafio.service.RepresentanteService;

@Controller
public class HomeController {
	
	@Autowired
	private RepresentanteService representanteService;
	
	@Autowired
	private LojaService lojaService;
	
	@RequestMapping(value={"/", ""})
	public String h()	{
		return "redirect:/home";
	}
	
	@RequestMapping(value={"/home"})
	public String home(Model model)	{
		
		List<Representante> findAll = representanteService.findAll();
		
		try {
			JSONArray locations = new JSONArray();
			JSONArray labels = new JSONArray();
			for (Representante representante : findAll) {
				JSONObject locationObject = new JSONObject();
				locationObject.put("lng", representante.getLongitude());
				locationObject.put("lat", representante.getLatitude());
				locations.put(locationObject);
				labels.put(representante.getNome());
			}
			model.addAttribute("locations", locations);
			model.addAttribute("labels", labels);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Representante> representantes = representanteService.findAll();
		model.addAttribute("representantes", representantes);
		
		List<Loja> lojas = lojaService.findAll();
		model.addAttribute("lojas", lojas);

		return "/home/home";
	}
	
	@RequestMapping(value={"/atribuir"})
	public String atribuir(Model model)	{
		lojaService.atribuirRepresentantes();
		
		return "redirect:/home";
	}

	
}
