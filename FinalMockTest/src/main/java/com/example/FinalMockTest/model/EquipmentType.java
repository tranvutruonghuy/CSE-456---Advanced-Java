package com.example.FinalMockTest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tbl_EquipmentType")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EquipmentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long equipmentTypeId;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false, unique = true)
    private String typeName;

    @Column(columnDefinition = "VARCHAR(255)", nullable = true)
    private String description;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "equipmentType")
    private List<Equipment> equipmentList = new ArrayList<>();


    public void removeEquipment(Equipment e){
        equipmentList.remove(e);
        e.setEquipmentType(null);
    }

    public void addEquipment(Equipment e){
        equipmentList.add(e);
        e.setEquipmentType(this);
    }

    public EquipmentType(String typeName, String description){
        this.typeName = typeName;
        this.description = description;
    }
}
