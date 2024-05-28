package tridm.StudentManagement.services;

import java.util.List;

import tridm.StudentManagement.dto.UserDto;
import tridm.StudentManagement.models.User;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}