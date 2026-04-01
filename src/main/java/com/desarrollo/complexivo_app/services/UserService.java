package com.desarrollo.complexivo_app.services;

import com.desarrollo.complexivo_app.models.Role;
import com.desarrollo.complexivo_app.models.User;
import com.desarrollo.complexivo_app.repository.RoleRepository;
import com.desarrollo.complexivo_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    public User save(User user){
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        //Buscar el rol USER, si no existe crear rol
        Role userRole = roleRepository.findByName("ROLE_USER")
                .orElseGet(()->{
                    Role newRole = new Role();
                    newRole.setName("ROLE_USER");
                    return roleRepository.save(newRole);
                });
        user.getRoles().add(userRole);
        return this.userRepository.save(user);
    }
}
