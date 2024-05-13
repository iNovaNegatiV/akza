package de.akza.jk.mappers;

import de.akza.jk.Dtos.GetUserDto;
import de.akza.jk.models.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(GetUserDto dto);

    GetUserDto toDto(User user);

    List<GetUserDto> toDtos(List<User> users);
}
