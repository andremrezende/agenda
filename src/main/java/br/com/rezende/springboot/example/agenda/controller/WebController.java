package br.com.rezende.springboot.example.agenda.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import br.com.rezende.springboot.example.agenda.model.PersonForm;
import br.com.rezende.springboot.example.agenda.repository.PersonRepository;

@Controller
public class WebController extends WebMvcConfigurerAdapter {

	@Autowired
	private PersonRepository personRepository;

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/results").setViewName("results");
	}

	@GetMapping("/")
	public String showForm(PersonForm personForm) {
		return "index";
	}

	@PostMapping("/")
	public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "index";
		}
		personRepository.save(personForm);
		Iterable<PersonForm> people = personRepository.findAll();
		model.addAttribute("people", people);
		return "results";
	}
}