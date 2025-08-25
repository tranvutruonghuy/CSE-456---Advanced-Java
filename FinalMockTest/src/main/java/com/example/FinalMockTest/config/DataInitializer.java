package com.example.FinalMockTest.config;


import com.example.FinalMockTest.model.Equipment;
import com.example.FinalMockTest.model.EquipmentType;
import com.example.FinalMockTest.model.User;
import com.example.FinalMockTest.service.EquipmentService;
import com.example.FinalMockTest.service.EquipmentTypeService;
import com.example.FinalMockTest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    EquipmentTypeService equipmentTypeService;

    @Autowired
    UserService userService;

    @Override
    public void run(String... args) throws Exception {
        //Create Equipment type
        EquipmentType cate1 = new EquipmentType("Laptop", "Portable computers used for teaching/research");
        EquipmentType cate2 = new EquipmentType("Projector", "Devices used for classroom presentations");
        EquipmentType cate3 = new EquipmentType("Printer", "Printers for administrative/student use");
        EquipmentType cate4 = new EquipmentType("Microscope", "Lab equipment for biology/medical courses");

        Equipment e1 = new Equipment("EQ00000001", "Dell Latitude 5420", 1500.00, 20);
        Equipment e2 = new Equipment("EQ00000002", "HP ProBook 450 G8", 1350.00, 15);
        Equipment e3 = new Equipment("EQ00000003", "Dell Latitude 5420", 1500.00, 20);
        Equipment e4 = new Equipment("EQ00000004", "Dell Latitude 5420", 1500.00, 20);
        Equipment e5 = new Equipment("EQ00000005", "Dell Latitude 5420", 1500.00, 20);
        Equipment e6 = new Equipment("EQ00000006", "Dell Latitude 5420", 1500.00, 20);

        cate1.addEquipment(e1);
        cate1.addEquipment(e2);

        cate2.addEquipment(e3);
        cate4.addEquipment(e4);

        cate3.addEquipment(e5);
        cate4.addEquipment(e6);

        equipmentTypeService.saveEquipmentType(cate1);
        equipmentTypeService.saveEquipmentType(cate2);
        equipmentTypeService.saveEquipmentType(cate3);
        equipmentTypeService.saveEquipmentType(cate4);

        User u1 = new User("admin", "admin", 1);
        User u2 = new User("staff", "staff", 2);
        User u3 = new User("customer", "customer", 3);

        userService.save(u1);
        userService.save(u2);
        userService.save(u3);
    }
}
