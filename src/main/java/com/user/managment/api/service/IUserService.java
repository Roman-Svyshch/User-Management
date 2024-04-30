package com.user.managment.api.service;

import com.user.managment.api.model.User;
import com.user.managment.api.dto.UserDto;

import java.time.LocalDate;
import java.util.List;


public interface IUserService {
    User createUser(UserDto userDto);
    boolean updateUser(UserDto userDto);
    boolean deleteUserByEmail(String email);

    List<User> searchUsersByBirthDateRange(LocalDate fromDate,LocalDate toDate);

}
