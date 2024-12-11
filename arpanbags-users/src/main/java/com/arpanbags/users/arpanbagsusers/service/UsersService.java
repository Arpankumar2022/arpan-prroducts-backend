package com.arpanbags.users.arpanbagsusers.service;


import com.arpanbags.users.arpanbagsusers.config.RestClientConfig;
import com.arpanbags.users.arpanbagsusers.dto.ProductsTypeDTO;
import com.arpanbags.users.arpanbagsusers.dto.UsersDTO;
import com.arpanbags.users.arpanbagsusers.dto.UsersDTOWithProductsTypeDTO;
import com.arpanbags.users.arpanbagsusers.entity.Users;
import com.arpanbags.users.arpanbagsusers.mapper.UsersMapper;
import com.arpanbags.users.arpanbagsusers.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final RestClientConfig restClientConfig;

    public static final String PRODUCTS_URI = "/products";

    public List<UsersDTO> getAllUsers() {
        return usersRepository.findAll().stream()
                .map(users -> UsersMapper.INSTANCE.mapUsersToUsersDTO(users))
                .collect(Collectors.toList());
    }

    public UsersDTO getUserById(Long id) {
        Optional<Users> optionalUser = usersRepository.findById(id);
        if (optionalUser.isPresent()) {
            return UsersMapper.INSTANCE.mapUsersToUsersDTO(optionalUser.get());
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }

    public UsersDTO createUser(UsersDTO usersDTO) {
        Users usersObj =   UsersMapper.INSTANCE.mapUsersDTOToUsers(usersDTO);
        usersObj.setUserPassword(passwordEncoder.encode(usersDTO.getUserPassword()));
        Users savedUser = usersRepository.save(usersObj);
        return UsersMapper.INSTANCE.mapUsersToUsersDTO(savedUser);
    }

    public UsersDTO updateUser(UsersDTO usersDTO) {
        Optional<Users> optionalUser = usersRepository.findById(usersDTO.getId());
        if (optionalUser.isPresent()) {
            Users users = optionalUser.get();
            users.setId(usersDTO.getId());
            users.setUserName(usersDTO.getUserName());
            users.setUserPassword(passwordEncoder.encode(usersDTO.getUserPassword()));
            System.out.println("password------>" +passwordEncoder.encode(usersDTO.getUserPassword()));
            users.setAddress(usersDTO.getAddress());
            users.setCity(usersDTO.getCity());
            users.setMobileNo(usersDTO.getMobileNo());
            users.setEmailId(usersDTO.getEmailId());
            Users savedUser = usersRepository.save(users);
            return UsersMapper.INSTANCE.mapUsersToUsersDTO(savedUser);
        } else {
            throw new RuntimeException("User not found with id: " + usersDTO.getId());
        }
    }

    public void deleteUser(Long id) {
        if (!usersRepository.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }
        usersRepository.deleteById(id);
    }

    public UsersDTOWithProductsTypeDTO getUsersWithProductsType(Long id){
        Optional<Users> optionalUser = usersRepository.findById(id);
        UsersDTOWithProductsTypeDTO usersDTOWithProductsTypeDTO = new UsersDTOWithProductsTypeDTO();
        if(optionalUser.isPresent()){
            usersDTOWithProductsTypeDTO.setProductsTypeDTO(getSomeRecordsFromProductsType(id));
            usersDTOWithProductsTypeDTO.setUsersDTO(UsersMapper.
                    INSTANCE.mapUsersToUsersDTO(optionalUser.get()));
        }
        return usersDTOWithProductsTypeDTO;
    }


    public ProductsTypeDTO getSomeRecordsFromProductsType(Long id){

        System.out.println(restClientConfig.restClient().get()
                .uri(PRODUCTS_URI+"/"+id));

        return restClientConfig.restClient().get()
                .uri(PRODUCTS_URI+"/"+id)
               // .header("Authorization",restClientConfig.getCurrentRequestToken())
                .retrieve()
                .body(ProductsTypeDTO.class);
    }
}
