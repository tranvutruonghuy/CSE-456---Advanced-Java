package com.example.FinalMockTest.service;

import com.example.FinalMockTest.model.Equipment;
import com.example.FinalMockTest.repository.EquipmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService {
    @Autowired
    EquipmentRepo equipmentRepo;

    public void saveEquipment(Equipment e){
        equipmentRepo.save(e);
    }
    public List<Equipment> getAllEquipments(){
        return equipmentRepo.findAll();
    }

    public Equipment getEquipmentById(String id){
        return equipmentRepo.findById(id).orElseThrow(); //hàm tự sinh
    }

    public void removeEquipmentById(String id){
        equipmentRepo.deleteById(id);
    }

    public List<Equipment> searchEquipmentsByName(String keyword){
        return equipmentRepo.searchAllByEquipmentNameContainingIgnoreCase(keyword);
    }
    //Hàm phục vụ kiểm tra trùng pk
    public Boolean checkExistsById(String id){
        return equipmentRepo.existsById(id); //Hàm tự sinh
    }

//    public List<Equipment> getTop3PerType(){
//        return equipmentRepo.searchTopByEquipmentType
//    }

}
