package com.example.FinalMockTest.service;

import com.example.FinalMockTest.model.Equipment;
import com.example.FinalMockTest.model.EquipmentType;
import com.example.FinalMockTest.repository.EquipmentTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentTypeService {
    @Autowired
    private EquipmentTypeRepo equipmentTypeRepo;

    public void saveEquipmentType(EquipmentType e){
        equipmentTypeRepo.save(e);
    }

    public List<EquipmentType> getAllEquipmentTypes(){
        return equipmentTypeRepo.findAll();
    }
}
