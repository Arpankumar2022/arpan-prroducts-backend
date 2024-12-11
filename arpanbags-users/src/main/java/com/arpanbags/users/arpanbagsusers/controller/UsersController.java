package com.arpanbags.users.arpanbagsusers.controller;

import com.arpanbags.users.arpanbagsusers.dto.UsersDTO;
import com.arpanbags.users.arpanbagsusers.dto.UsersDTOWithProductsTypeDTO;
import com.arpanbags.users.arpanbagsusers.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;

    @GetMapping
    public ResponseEntity<List<UsersDTO>> getAllUsers() {
        List<UsersDTO> users = usersService.getAllUsers();
        return ResponseEntity.ok(users);
    }


    @GetMapping("/{id}")
    public ResponseEntity<UsersDTO> getUserById(@PathVariable Long id) {
        UsersDTO usersDTO = usersService.getUserById(id);
        return ResponseEntity.ok(usersDTO);
    }

    @GetMapping("/getUsersWithProductsType/{id}")
    public ResponseEntity<UsersDTOWithProductsTypeDTO> getUsersWithProductsType(@PathVariable Long id) {
        UsersDTOWithProductsTypeDTO usersDTOWithProductsTypeDTO = usersService.getUsersWithProductsType(id);
        return ResponseEntity.ok(usersDTOWithProductsTypeDTO);
    }


    @PostMapping
    public ResponseEntity<UsersDTO> createUser(@RequestBody UsersDTO usersDTO) {
        UsersDTO createdUser = usersService.createUser(usersDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PutMapping
    public ResponseEntity<UsersDTO> updateUser(@RequestBody UsersDTO usersDTO) {
        UsersDTO updatedUser = usersService.updateUser(usersDTO);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        usersService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
