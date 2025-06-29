package com.attendance.attendance_system.control;

import com.attendance.attendance_system.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private JwtUtil jwtUtil;

    // Dummy Login Endpoint
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, @RequestParam String role) {
        System.out.println(username + password + role + "1st");
        // For demo, hardcoded validation
        if ("admin".equals(username) && "password".equals(password) && role != null) {
            System.out.println(username + password + role);
            return jwtUtil.generateToken(username, role);
        } else {
            return "Invalid Credentials";
        }
    }
    @GetMapping("/user/**")
    public String login_Print(){
        return "I am ironman";
    }
}
