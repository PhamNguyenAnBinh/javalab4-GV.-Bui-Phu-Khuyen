package com.example.lab04.controller;

import com.example.lab04.entity.Lop;
import com.example.lab04.services.LopService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/lop")
public class LopController {

    @Autowired
    private LopService lopService;

    @GetMapping
    public String showAllLop(Model model) {
        List<Lop> dsLop = lopService.getAllLop();
        model.addAttribute("dsLop", dsLop);
        return "lop/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("lop", new Lop());
        return "lop/add";
    }

    @PostMapping("/add")
    public String addLop(@ModelAttribute("lop") Lop lop) {
        lopService.addLop(lop);
        return "redirect:/lop";
    }

    @GetMapping("/delete/{id}")
    public String deleteLop(@PathVariable("id") Long id) {
        lopService.deleteLop(id);
        return "redirect:/lop";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Optional<Lop> lop = Optional.ofNullable(lopService.getLopById(id));
        if (lop.isPresent()) {
            model.addAttribute("lop", lop.get());
            return "lop/edit";
        }
        return "redirect:/lop";
    }

    @PostMapping("/edit")
    public String editLop(@Valid @ModelAttribute("lop") Lop lop, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "lop/edit";
        }
        try {
            lopService.updateLop(lop);
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "lop/edit";
        }
        return "redirect:/lop";
    }
}
