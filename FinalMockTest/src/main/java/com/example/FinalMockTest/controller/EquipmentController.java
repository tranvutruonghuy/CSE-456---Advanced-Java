package com.example.FinalMockTest.controller;

import com.example.FinalMockTest.model.Equipment;
import com.example.FinalMockTest.model.EquipmentType;
import com.example.FinalMockTest.model.User;
import com.example.FinalMockTest.service.EquipmentService;
import com.example.FinalMockTest.service.EquipmentTypeService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

@Controller

public class EquipmentController {
    @Autowired
    EquipmentService equipmentServ;

    @Autowired
    EquipmentTypeService equipmentTypeServ;


    @GetMapping("/equipments")
    public String showStudentsPage(HttpSession ses, Model model, RedirectAttributes redir){
        User user = (User) ses.getAttribute("user");
        if(user == null){
            return "redirect:/login";
        }

        List<Equipment> equipments = equipmentServ.getAllEquipments();

        model.addAttribute("equipments", equipments);
        return "equipment-list";
    }

    @GetMapping("/equipments/edit/{id}")
    public String showEditEquipmentPage(Model model, @PathVariable String id, HttpSession ses, RedirectAttributes RedAttr){
        User user = (User) ses.getAttribute("user");
        if(user == null){
            return "redirect:/login";
        }
        if(user.getRole() != 1 && user.getRole() != 2){
            //báo lỗi access denied.
            RedAttr.addFlashAttribute("errRole","Access Denied. You are not allowed to perform this action.");
            return "redirect:/equipments";
        }
        Equipment equipment = equipmentServ.getEquipmentById(id);

        model.addAttribute("equipment", equipment);
        model.addAttribute("equipmentTypes", equipmentTypeServ.getAllEquipmentTypes());
        model.addAttribute("formMode", "edit");

        return "equipment-form";

    }

    @GetMapping("/equipments/add")
    public String addStudent(Model model, HttpSession ses, RedirectAttributes RedAttr) {
        //Không cho gõ link trực tiếp, chưa login > login
        User user = (User) ses.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        //Login rồi > Kiểm tra thêm role không phải là 1 và 2
        if(user.getRole() != 1) {
            //báo lỗi access denied.
            RedAttr.addFlashAttribute("errRole", "Access Denied. You are not allowed to perform this action.");
            return "redirect:/equipments";
        }
        //Lấy toàn bộ major để gửi qua comboBox(select) của form
        //Note: attributeName phải giống với hàm edit
        List<EquipmentType> equipmentTypes = equipmentTypeServ.getAllEquipmentTypes();
        model.addAttribute("equipmentTypes", equipmentTypes);

        //Tạo mới và gửi một sinh viên chưa có thông tin để gửi qua form
        //Note: attributeName phải giống với hàm edit
        model.addAttribute("equipment", new Equipment());

        //Gửi kèm một attribute để báo là thêm student
        model.addAttribute("formMode","add");
        return "equipment-form";
    }

    @PostMapping("/equipments/form")
    public String saveEquipment(@Valid @ModelAttribute("equipment") Equipment e, BindingResult result, Model model, @RequestParam("formMode") String formMode, HttpSession ses, RedirectAttributes RedAttr){
        if(result.hasErrors()){
            model.addAttribute("formMode",formMode);
            model.addAttribute("equipmentTypes", equipmentTypeServ.getAllEquipmentTypes());
            return "equipment-form";
        }
        if(formMode.equals("add")){
            if(equipmentServ.checkExistsById(e.getEquipmentId())){
                model.addAttribute("formMode",formMode);
                model.addAttribute("equipmentTypes", equipmentTypeServ.getAllEquipmentTypes());
                model.addAttribute("duplicateId","Id is already exists");
                return "equipment-form";
            }
        }
        e.setDatetime(LocalDateTime.now());
        equipmentServ.saveEquipment(e);
        return "redirect:/equipments";
    }
    @GetMapping("equipments/delete/{id}")
    public String deleteStudent(@PathVariable("id") String id, HttpSession ses, RedirectAttributes RedAttr) {
        //Không cho gõ link trực tiếp, chưa login > login
        User user = (User) ses.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        //Login rồi > Kiểm tra thêm role không phải là 1 và 2
        if(user.getRole() != 1) {
            //báo lỗi access denied.
            RedAttr.addFlashAttribute("errRole", "Access Denied. You are not allowed to perform this action.");
            return "redirect:/equipments";
        }
        //Gọi service hực hiện xóa sinh viên
        equipmentServ.removeEquipmentById(id);
        //Trả về trang student
        return "redirect:/equipments";
    }
}
