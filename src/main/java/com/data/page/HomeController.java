package com.data.page;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.data.page.model.Person;
import com.data.page.model.PersonRepo;

@RestController
public class HomeController {

    @Autowired
    PersonRepo repo;
    @RequestMapping("/")
    public String home() {
        System.out.println("index");
        return "index";
    }
    
    @PostMapping("/sign")
    public Person sign(@RequestBody Person person) {

        return repo.save(person);
        
    }
    @RequestMapping("/lookfor")
    public List<Person> call(@RequestParam("name") String name) {
        return repo.findByName(name); 
    }

    @RequestMapping("/getall")
    public List<Person> getAll() {
        return repo.findAll();

    }
} 
