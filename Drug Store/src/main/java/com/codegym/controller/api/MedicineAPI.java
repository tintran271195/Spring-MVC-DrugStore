package com.codegym.controller.api;

import com.codegym.model.Category;
import com.codegym.model.Medicine;
import com.codegym.service.category.ICategoryService;
import com.codegym.service.medicine.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/medicines")
public class MedicineAPI {

    @Autowired
    private IMedicineService medicineService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public ResponseEntity<Iterable<Medicine>> allMedicines() {
        Iterable<Medicine> medicines = medicineService.findAll();
        if (((List) medicines).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(medicines, HttpStatus.OK);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<Medicine> getId(@PathVariable Long id) {
        Optional<Medicine> medicine = medicineService.findById(id);
        if (medicine.isPresent()) {
            return new ResponseEntity<>(medicine.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Medicine> saveMedicine(@RequestBody Medicine medicine) {
        if (medicine.getId() != null) {
            return new ResponseEntity<>(medicineService.save(medicine), HttpStatus.OK);
        }

        Optional<Category> category = categoryService.findById(medicine.getCategory().getId());

        if (category.isPresent()) {
            medicine.setCategory(category.get());
            return new ResponseEntity<>(medicineService.save(medicine), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping()
    public ResponseEntity<Medicine> deleteEntity(@RequestBody Map<String, String> json) {
        Long id = Long.valueOf(json.get("id"));
        Optional<Medicine> medicineOptional = medicineService.findById(id);
        if (!medicineOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        medicineService.remove(id);
        return new ResponseEntity<>(medicineOptional.get(), HttpStatus.NO_CONTENT);
    }
}
