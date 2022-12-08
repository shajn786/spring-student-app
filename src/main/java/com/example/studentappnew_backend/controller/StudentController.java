package com.example.studentappnew_backend.controller;


import com.example.studentappnew_backend.dao.StudentDao;
import com.example.studentappnew_backend.model.Student;
import org.apache.tomcat.util.net.jsse.JSSEUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class StudentController {

      @Autowired
      private StudentDao dao;
    @CrossOrigin(value = "*")
    @GetMapping("/viewall")
    public List<Student> HomePage()
    {
        return (List<Student>)  dao.findAll();
    }


    @CrossOrigin(value = "*")
   @PostMapping(path ="/add",consumes = "application/json", produces ="application/json")
   public HashMap<String,String> AddStudent(@RequestBody Student s)
   {
       dao.save(s);
       HashMap<String,String> map = new HashMap<>();
       map.put("status","success");
       return map;
   }


    @CrossOrigin(value = "*")
    @PostMapping(path="/search",consumes = "application/json", produces = "application/json")
    public List<Student> SerachStudent(@RequestBody Student s)
    {

        String sadmno = s.getAdmno();
        System.out.println(sadmno);
        return  (List<Student>) dao.searchStudents(s.getAdmno());

    }

    @CrossOrigin(value = "*")
    @PostMapping(path="/delete",consumes = "application/json", produces = "application/json")
    public HashMap<String,String> delete(@RequestBody Student s)
    {
        String pid = String.valueOf(s.getId());
        System.out.println(pid);
        dao.deleteStudent(s.getId());
        HashMap<String,String> map = new HashMap<>();
        map.put("status","success");
        return map;
    }

}
