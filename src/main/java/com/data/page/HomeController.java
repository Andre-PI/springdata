package com.data.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.data.page.model.Person;
import com.data.page.model.PersonRepo;

@Controller
public class HomeController {

    @Autowired
    PersonRepo repo;
    @RequestMapping("/")
    public String home() {
        System.out.println("index");
        return "index";
    }
    
    @RequestMapping("/sign")
    public String sign(@RequestParam("name") String name, @RequestParam("email") String email) {

        repo.save(new Person(name,email));
        
        return "index";
    }
    @RequestMapping("/lookfor")
    public String call(@RequestParam("name") String name, Model m ) {
        m.addAttribute("gls",repo.findByName(name));
        return "getall";
    }

    @RequestMapping("/getall")
    public String getAll(Model model) {
        model.addAttribute("gls", repo.findAll().toString());
        return "getall";
    }
}
