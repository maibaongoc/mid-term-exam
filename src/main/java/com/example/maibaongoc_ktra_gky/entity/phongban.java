package com.example.maibaongoc_ktra_gky.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Data
@Entity
@Table(name="phongban")
public class phongban {
    @Id
    @NotBlank(message = "Trường này không được phép bỏ trống")
    @Length(min = 2, max = 2, message = "Phải nhập vào 2 ký tự chữ viết tắt")
    private String maphong;

    @Length(min = 2, max = 30, message = "Phải nhập vào tên phòng")
    private String tenphong;
    @OneToMany(mappedBy = "phongban", fetch = FetchType.LAZY)

    private List<nhanvien> nhanviens;

}
