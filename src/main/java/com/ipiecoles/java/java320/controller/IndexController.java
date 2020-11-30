package com.ipiecoles.java.java320.controller;

import com.ipiecoles.java.java320.model.Employe;
import com.ipiecoles.java.java320.repository.EmployeRepository;
import org.hibernate.mapping.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class IndexController {

    @Autowired
    EmployeRepository employeRepository;

    @GetMapping(value="")
    public String accueil(final ModelMap model)
    {
        Long nbEmploye=  employeRepository.count();
        model.put("nbEmploye",nbEmploye);
        return "accueil";
    }


}
