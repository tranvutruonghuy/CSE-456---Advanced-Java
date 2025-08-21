package com.example.FinalMockTest.repository;

import com.example.FinalMockTest.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepo extends JpaRepository<Equipment, String> {
    List<Equipment> searchAllByEquipmentNameContainingIgnoreCase(String equipmentName);
}
