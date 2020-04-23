package com.codegym.controller;

import com.codegym.model.City;
import com.codegym.model.Nal;
import com.codegym.service.CityService;
import com.codegym.service.NalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CityController {

    @Autowired
    private CityService cityService;

    @Autowired
    private NalService nalService;

    @ModelAttribute("nals")
    public Iterable<Nal> provinces(Pageable pageable) {
        return nalService.findAll(pageable);
    }

    @GetMapping("/city/list")
    public String cityList(Model model ){
        Iterable<City> cities = cityService.findAll();
        model.addAttribute("cities",cities);
        return "city/list";
    }

    @GetMapping("/city/create")
    public String showFormCreate(Model model,@ModelAttribute("city") City city){
        model.addAttribute("city",city);
        model.addAttribute("city",new City());
        return "/city/create";
    }

    @PostMapping("/city/create")
    public String saveCity(Model model, @ModelAttribute("city") City city){
        cityService.save(city);
        model.addAttribute("city",city);
        model.addAttribute("message","Create Success!!!");
        return "/city/create";
    }

    @GetMapping("/city/view/{id}")
    public ModelAndView viewProvince(@PathVariable("id") Long id){
        Nal nal = nalService.findById(id);
        if(nal == null){
            return new ModelAndView("/error.404");
        }

        Iterable<City> cities = cityService.findAllByNal(nal);

        ModelAndView modelAndView = new ModelAndView("/nal/view");
        modelAndView.addObject("nal", nal);
        modelAndView.addObject("cities", cities);
        return modelAndView;
    }

    @GetMapping("/city/edit/{id}")
    public String showFormEdit(Model model, @PathVariable Long id) {
        City city = cityService.findById(id);
        if (city != null) {
            model.addAttribute("city", city);
        } else {
            return "/404";
        }
        return "/city/edit";
    }

    @PostMapping("/city/saveEdit")
    public String saveEdit(Model model,@ModelAttribute("city") City city){
        cityService.save(city);
        model.addAttribute("city",city);
        model.addAttribute("message","Edit Success!!!");
        return "/city/edit";
    }

    @GetMapping("/city/delete/{id}")
    public String showFormDelete(Model model,@PathVariable Long id){
        City city = cityService.findById(id);
        if (city != null){
            model.addAttribute("city",city);
            model.addAttribute("message","Delete Success!!!");
        }
        else {
            return "/404";
        }
        return "/city/delete";
    }

    @PostMapping("/city/edit/{id}")
    public String saveDelete(Model model,@PathVariable Long id){
        cityService.remove(id);
        return "/city/delete";
    }
}
