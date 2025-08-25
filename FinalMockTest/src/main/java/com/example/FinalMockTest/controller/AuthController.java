package com.example.FinalMockTest.controller;


import com.example.FinalMockTest.model.User;
import com.example.FinalMockTest.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {
    @Autowired
    UserService userServ;

    @GetMapping({"/", "/login"})
    public String showLoginPage() {
        return "login"; //login.html
    }

    @PostMapping("/auth")
    public String authUser(@ModelAttribute User user, HttpSession ses, RedirectAttributes redir) {
        User loginUser = userServ.findByUsername(user.getUsername());
        if (loginUser == null) {
            redir.addFlashAttribute("error", "Invalid username or password");
            redir.addFlashAttribute("username", user.getUsername());
            return "redirect:/login";
        }
        if (!loginUser.getPassword().equals(user.getPassword())) {
            redir.addFlashAttribute("error", "Invalid username or password");
            redir.addFlashAttribute("username", user.getUsername());
            return "redirect:/login";
        }

        ses.setAttribute("user", loginUser);
        return "redirect:/equipments";
    }

    @GetMapping("/logout")
    public String logout(HttpSession ses) {
        ses.invalidate();
        return "redirect:/";
    }



}
