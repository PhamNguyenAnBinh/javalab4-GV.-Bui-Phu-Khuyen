package com.example.lab04.repository;
import org.springframework.stereotype.Repository;
import com.example.lab04.entity.MonHoc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMonHocRepository  extends JpaRepository <MonHoc, Long> {
}
