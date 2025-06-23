package com.example.demo.controllers;

import com.example.demo.domain.HandCrafted;
import com.example.demo.domain.Supplier;
import com.example.demo.domain.Part;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 *
 *
 *
 *
 */
@Controller
public class AddPartController {
    @Autowired
    private ApplicationContext context;

    @GetMapping("/showPartFormForUpdate")
    public String showPartFormForUpdate(@RequestParam("partID") int theId,Model theModel){

        PartService repo=context.getBean(PartServiceImpl.class);
        OutsourcedPartService outsourcedrepo=context.getBean(OutsourcedPartServiceImpl.class);
        InhousePartService inhouserepo=context.getBean(InhousePartServiceImpl.class);

        boolean inhouse=true;
        List<Supplier> suppliers =outsourcedrepo.findAll();
        for(Supplier supplier : suppliers) {
            if(supplier.getId()==theId)inhouse=false;
        }
        String formtype;
        if(inhouse){
            HandCrafted handCrafted =inhouserepo.findById(theId);
            theModel.addAttribute("inhousepart", handCrafted);
            formtype="InhousePartForm";
        }
        else{
            Supplier supplier =outsourcedrepo.findById(theId);
            theModel.addAttribute("outsourcedpart", supplier);
            formtype="OutsourcedPartForm";
        }
        return formtype;
    }

    @GetMapping("/deletepart")
    public String deletePart(@Valid @RequestParam("partID") int theId,  Model theModel){
        PartService repo = context.getBean(PartServiceImpl.class);
        Part part=repo.findById(theId);
        if(part.getProducts().isEmpty()){
            repo.deleteById(theId);
            return "confirmationdeletepart";
        }
        else{
            return "negativeerror";
        }
    }

}
