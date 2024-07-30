package com.yusuf.rest_api_crud_app.repository;

import com.yusuf.rest_api_crud_app.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
