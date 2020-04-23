package com.codegym.controller;

import com.codegym.model.Nal;
import com.codegym.service.NalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NalController {

    @Autowired
    private NalService nalService;

    @GetMapping("/nal/list")
    public String listNal(Model model, Pageable pageable) {
        Iterable<Nal> nals = nalService.findAll(pageable);
        model.addAttribute("nals", nals);
        return "/nal/list";
    }

    @GetMapping("/nal/create")
    public String showFormCreate(Model model) {
        model.addAttribute("nal", new Nal());
        return "/nal/create";
    }

    @PostMapping("/nal/create")
    public String saveCreate(@ModelAttribute("nal") Nal nal, Model model) {
        nalService.save(nal);
        model.addAttribute("nal", new Nal());
        model.addAttribute("message", "Create Success!!!");
        return "/nal/create";
    }

    @GetMapping("/nal/edit/{id}")
    public String showFormEdit(Model model, @PathVariable Long id) {
        Nal nal = nalService.findById(id);
        if (nal != null) {
            model.addAttribute("nal", nal);
        } else {
            return "/404";
        }
        return "/nal/edit";
    }

    @PostMapping("/nal/saveEdit")
    public String saveEdit(Model model,@ModelAttribute("nal") Nal nal){
        nalService.save(nal);
        model.addAttribute("nal",nal);
        model.addAttribute("message","Edit Success!!!");
        return "/nal/edit";
    }

    @GetMapping("/nal/delete/{id}")
    public String showFormDelete(Model model,@PathVariable Long id){
        Nal nal = nalService.findById(id);
        if (nal != null){
            model.addAttribute("nal",nal);
            model.addAttribute("message","Delete Success!!!");
        }
        else {
            return "/404";
        }
        return "/nal/delete";
    }

    @PostMapping("/nal/delete/{id}")
    public String saveDelete(Model model,@PathVariable Long id){
        nalService.remove(id);
        return "/nal/delete";
    }
}
