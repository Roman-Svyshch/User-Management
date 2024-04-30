package com.user.managment.api.mapper;

import com.user.managment.api.model.User;
import com.user.managment.api.dto.UserDto;

public class UserMapper {
  public static  UserDto mapToUserDto(User user,UserDto userDto){
      userDto.setAddress(user.getAddress());
      userDto.setFirstName(user.getFirstName());
      userDto.setLastName(user.getLastName());
      userDto.setEmail(user.getEmail());
      userDto.setBirthDate(user.getBirthDate());
      userDto.setPhoneNumber(user.getPhoneNumber());
      return userDto;
  }
    public static  User mapToUser(UserDto userDto,User user){
        user.setAddress(userDto.getAddress());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setBirthDate(userDto.getBirthDate());
        user.setPhoneNumber(userDto.getPhoneNumber());
        return user;
    }

}
