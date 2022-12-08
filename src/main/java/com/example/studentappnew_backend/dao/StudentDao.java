package com.example.studentappnew_backend.dao;

import com.example.studentappnew_backend.model.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentDao extends CrudRepository<Student, Integer> {

    @Query(value="SELECT `id`, `admno`, `college`, `name`, `rollno` FROM `student` WHERE `admno`= :admno",nativeQuery = true)
    List<Student> searchStudents(@Param("admno") String admno);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `student` WHERE `id`= :id",nativeQuery = true)
    void deleteStudent(@Param("id") Integer id);

}
