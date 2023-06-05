package com.example.maibaongoc_ktra_gky.controller;

import com.example.maibaongoc_ktra_gky.entity.nhanvien;
import com.example.maibaongoc_ktra_gky.service.NhanvienService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import com.example.maibaongoc_ktra_gky.service.PhongbanService;


import java.util.*;
@Controller
@RequestMapping("/nhanvien")
public class NhanvienController {
    @Autowired
    private NhanvienService nhanvienService;

    @Autowired
    private PhongbanService phongbanService;

    @GetMapping
    public String showAllNhanvien(Model model){
        List<nhanvien> nhanviens = nhanvienService.getAllNhanvien();
        model.addAttribute("nhanviens", nhanviens);
        return "nhanvien/index";
    }

    @GetMapping("/add")
    public String addNVForm(Model model){
        model.addAttribute("nhanvien",new nhanvien());

        return "nhanvien/add";
    }

    @PostMapping("/add")
    public String addNV(@Valid nhanvien newNhanvien, Model model){

        nhanvienService.addNhanvien(newNhanvien);
        return "redirect:/nhanvien";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id){

        nhanvienService.deleteNhanvien(id);

        return "redirect:/nhanvien";
    }

    @GetMapping("/edit/{id}")
    public String editNVForm(@PathVariable("id") String id, Model model){
        nhanvien nhanvien = nhanvienService.getNhanvienById(id);
        if(nhanvien != null){
            model.addAttribute("nhanvien", nhanvien);
            model.addAttribute("categories", phongbanService.getAllPhongban());
            return "nhanvien/edit";
        } else {
            return "not-found";
        }
    }
    @PostMapping("/edit")
    public String editNV(@Valid @ModelAttribute("nhanvien") nhanvien updatedNV, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()) {
            model.addAttribute("phongban", phongbanService.getAllPhongban());
            return "nhanvien/edit";
        }
        nhanvienService.updateNhanvien(updatedNV);
        return "redirect:/nhanvien";
    }



}
