package com.greatlearning.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.entity.RegistrationList;
import com.greatlearning.service.RegistrationListService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor

public class RegistrationListController {
	private final RegistrationListService registrationListService;

	@RequestMapping("/records")
	public String listStudentRecords(Model model) {
		model.addAttribute("records", registrationListService.getAllRecords());
		return "records";
	}

	@RequestMapping("/records/addstudentrecord")
	public String createStudentRecordForm(Model model) {
		RegistrationList registrationList = new RegistrationList();
		model.addAttribute("record", registrationList);
		return "create_record";
	}

	@PostMapping("/save")
	public String saveStudentRecord(@Valid @ModelAttribute("record") RegistrationList registrationList,
			BindingResult result) {
		if (result.hasErrors()) {
			return "create_record";
		}
		registrationListService.saveRecord(registrationList);
		return "redirect:/records";
	}

	@RequestMapping("/records/update/{id}")
	public String updateStudentRecordForm(@PathVariable long id, Model model) {
		model.addAttribute("record", registrationListService.getRecordById(id));
		return "update_record";
	}

	@PostMapping("/records/{id}")
	public String updateStudentRecord(@PathVariable long id,
			@Valid @ModelAttribute("record") RegistrationList registrationList, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "update_record";
		}
		registrationListService.updateRecordById(id, registrationList);
		return "redirect:/records";
	}

	@GetMapping("/records/{id}")
	public String deleteStudentRecord(@PathVariable long id) {
		registrationListService.deleteRecordById(id);
		return "redirect:/records";
	}

	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", "You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}

}
