package by.sommelierr.controllers;

import by.sommelierr.models.Role;
import by.sommelierr.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RoleController {
    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/role")
    public String role(){
        return "role";
    }

    @PostMapping("/role")
    public String role(@RequestParam Long id, @RequestParam String name){
        roleRepository.save(new Role(id,name));
        return "role";
    }
}
