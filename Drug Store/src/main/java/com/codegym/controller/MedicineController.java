package com.codegym.controller;

import com.codegym.service.medicine.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/medicines")
public class MedicineController {

    @Autowired
    private IMedicineService medicineService;

    @GetMapping
    public ModelAndView listMedicines(){
        ModelAndView modelAndView = new ModelAndView("/medicine/list");
        return modelAndView;
    }
}
