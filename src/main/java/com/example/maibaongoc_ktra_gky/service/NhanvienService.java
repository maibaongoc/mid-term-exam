package com.example.maibaongoc_ktra_gky.service;

import com.example.maibaongoc_ktra_gky.entity.nhanvien;
import com.example.maibaongoc_ktra_gky.repository.INhanvienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;
@Service
public class NhanvienService {
    @Autowired
    private INhanvienRepository nhanvienRepository;

    public List<nhanvien> getAllNhanvien(){
        return nhanvienRepository.findAll();

    }

    public nhanvien getNhanvienById(String id){
        Optional<nhanvien> optional = nhanvienRepository.findById(id);
        return optional.orElse(null);
    }

    public void addNhanvien(nhanvien nhanvien){
        nhanvienRepository.save(nhanvien);
    }

    public void updateNhanvien(nhanvien nhanvien){
        nhanvienRepository.save(nhanvien);
    }
    public void deleteNhanvien(String id){
        nhanvienRepository.deleteById(id);
    }
}
