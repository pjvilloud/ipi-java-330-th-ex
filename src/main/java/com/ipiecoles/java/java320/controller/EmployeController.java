package com.ipiecoles.java.java320.controller;

import com.ipiecoles.java.java320.model.Employe;
import com.ipiecoles.java.java320.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/employes")
public class EmployeController {

    @Autowired
    EmployeRepository employeRepository;

    @GetMapping(value="/{id}")
    public String getEmploye(final ModelMap model, @PathVariable(value = "id") Long id)
    {
        Optional<Employe> employeOptional=  employeRepository.findById(id);

        model.put("employe",employeOptional.get());
        return "detail";
    }

    @GetMapping()
    public String searchEmploye(final ModelMap model, @RequestParam("matricule") String matricule)
    {
        System.out.println(matricule);
        Employe employe = employeRepository.findByMatricule(matricule);
        model.put("employe",employe);

        return "detail";
    }
    @GetMapping(params ={"size"})
    public String getAllEmploye(final ModelMap model,
         @RequestParam("page") Integer page,
         @RequestParam("size") Integer size,
         @RequestParam("sortProperty") String sortProperty,
         @RequestParam("sortDirection") String sortDirection)
    {
        System.out.println(sortDirection);
        System.out.println(sortProperty);
        Pageable pageRequest = PageRequest.of(page, size, Sort.Direction.valueOf(sortDirection), sortProperty);
        Iterable<Employe> employeList =  employeRepository.findAll(pageRequest);
        model.put("employeList",employeList);
        model.put("sizeMin",page*size+1);
        model.put("sizeMax",page*size+10);
        model.put("pagePrecedente",page-1);
        model.put("pageSuivante",page+1);
        model.put("NumberPage",page+1);
        return "listeEmployes";
    }

    @GetMapping(value="/new/commercial")
    public String NewCommercial(){
        return "Nouveau_Commercial";
    }

}
