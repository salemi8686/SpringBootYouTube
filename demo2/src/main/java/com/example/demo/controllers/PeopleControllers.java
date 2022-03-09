package com.example.demo.controllers;

import com.example.demo.Dao.PersonDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class PeopleControllers{

    private PersonDao personDao;

    public PeopleControllers(PersonDao personDao){
        this.personDao = personDao;
    }


    @GetMapping()
    public String index(Model model){
        model.addAttribute("people",personDao.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("person",personDao.show(id));
        return "people/show";
    }


}
