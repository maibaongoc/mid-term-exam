package com.example.maibaongoc_ktra_gky.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@Entity
@Table(name="nhanvien")
public class nhanvien {
    @Id
    @NotBlank(message = "Trường này không được phép bỏ trống")
    @Length(min = 3, max = 3, message = "Phải nhập vào 3 ký tự bao gồm chữ và số")
    @Column(name = "Ma_NV")
    private String id;

    @NotBlank(message = "Trường này không được phép bỏ trống")
    @Length(min = 3, max = 100, message = "Phải nhập tên nhân viên")
    @Column(name = "Ten_NV")
    private String tenNv;

    @Length(min = 0, max = 3, message = "nhập giới tính")
    @Column(name = "Phai")
    private String phai;

    @Length(min = 0, max = 200, message = "nhập nơi sinh")
    @Column(name = "Noi_sinh")
    private String noisinh;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maphong")
    private phongban phongban;





    @Column(name = "Lương")
    private int luong;

    @Override
    public String toString() {
        return "nhanvien{" +
                "id='" + id + '\'' +
                ", tenNv='" + tenNv + '\'' +
                ", phai='" + phai + '\'' +
                ", noisinh='" + noisinh + '\'' +
                ", phongban=" + phongban +
                ", luong=" + luong +
                '}';
    }
}
