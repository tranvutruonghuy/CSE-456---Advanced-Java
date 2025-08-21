package com.example.FinalMockTest.repository;

import com.example.FinalMockTest.model.EquipmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentTypeRepo extends JpaRepository<EquipmentType, Long> {
}
