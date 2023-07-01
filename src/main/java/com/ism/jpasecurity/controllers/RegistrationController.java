package com.ism.jpasecurity.controllers;

/**
 * Author  : essejacaues.co
 * Date    : 24/06/2023 02:27
 * Project : JpaSecurity
 */
import com.ism.jpasecurity.dto.UserRegistrationDto;
import com.ism.jpasecurity.entities.User;
import com.ism.jpasecurity.services.RoleService;
import com.ism.jpasecurity.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/register")
@Log4j2
public class RegistrationController {
    private  final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    @GetMapping()
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleService.findAllRoles());
        return "registration";
    }

    @PostMapping()
    public String processRegistration(User user, @RequestParam("role") Long role) {
        log.info("registration user: form " + user);
        user.setEnabled(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.addRole(roleService.findRole(role));
        User userSaved  = this.userService.createUser(user);
        log.info("registration user: saved " + userSaved);
        return "redirect:/login";
    }
}

