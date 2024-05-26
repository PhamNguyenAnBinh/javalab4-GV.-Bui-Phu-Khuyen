package com.example.lab04.repository;
import org.springframework.stereotype.Repository;
import com.example.lab04.entity.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISinhVienRepository extends JpaRepository <SinhVien, Long> {
}
