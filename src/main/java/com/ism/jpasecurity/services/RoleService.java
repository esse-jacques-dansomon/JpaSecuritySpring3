package com.ism.jpasecurity.services;


import com.ism.jpasecurity.entities.Role;
import com.ism.jpasecurity.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepo;

    //Find all roles
    public List<Role> findAllRoles(){
        return roleRepo.findAll();
    }

    //Find role by id
    public Role findRole(Long id){
        return roleRepo.findById(id).orElse(null);
    }
}
