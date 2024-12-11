package com.arpanbags.users.arpanbagsusers.mapper;

import com.arpanbags.users.arpanbagsusers.dto.UsersDTO;
import com.arpanbags.users.arpanbagsusers.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface UsersMapper {

    UsersMapper INSTANCE = Mappers.getMapper(UsersMapper.class);

    UsersDTO mapUsersToUsersDTO(Users users);

    Users mapUsersDTOToUsers(UsersDTO usersDTO);

}
