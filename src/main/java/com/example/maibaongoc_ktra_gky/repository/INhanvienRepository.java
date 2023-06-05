package com.example.maibaongoc_ktra_gky.repository;

import com.example.maibaongoc_ktra_gky.entity.nhanvien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INhanvienRepository extends JpaRepository<nhanvien, String> {
}
