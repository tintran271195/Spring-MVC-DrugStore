package com.codegym.service.medicine;

import com.codegym.model.Medicine;
import com.codegym.repository.IMedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MedicineService implements IMedicineService {
    @Autowired
    private IMedicineRepository medicineRepository;

    @Override
    public Iterable<Medicine> findAll() {
        return medicineRepository.findAll();
    }

    @Override
    public Optional<Medicine> findById(Long id) {
        return medicineRepository.findById(id);
    }

    @Override
    public Medicine save(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    @Override
    public void remove(Long id) {
        medicineRepository.deleteById(id);
    }
}
