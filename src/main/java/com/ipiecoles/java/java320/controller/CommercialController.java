package com.ipiecoles.java.java320.controller;

import com.ipiecoles.java.java320.model.Commercial;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("commercials")
public class CommercialController {

    @PostMapping(value = "/save")
    public String  saveCommercial(final ModelMap model, @RequestBody Commercial commercial){
        System.out.println(commercial.getNom());
        System.out.println(commercial.getPrenom());

        return "detail_Commercial";
    }
}
