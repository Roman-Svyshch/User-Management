package com.user.managment.api.testUserServiceImpl;

import com.user.managment.api.exception.ResourceNotFoundException;
import com.user.managment.api.exception.UserAlreadyExistsException;
import com.user.managment.api.mapper.UserMapper;
import com.user.managment.api.model.User;
import com.user.managment.api.repository.UserRepository;
import com.user.managment.api.service.IUserService;
import com.user.managment.api.dto.UserDto;
import com.user.managment.api.service.serviceImpl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;


    @Test
    void testCreateUser_UserAlreadyExistsException() {
        // Arrange
        UserDto userDto = new UserDto();
        userDto.setPhoneNumber("1234567890");
        userDto.setBirthDate(LocalDate.of(2000, 1, 1)); // Set a birth date to calculate age

        User existingUser = new User();
        existingUser.setPhoneNumber(userDto.getPhoneNumber());

        when(userRepository.findByPhoneNumber(userDto.getPhoneNumber())).thenReturn(Optional.of(existingUser));

        assertThrows(UserAlreadyExistsException.class, () -> userService.createUser(userDto));
    }

    @Test
    void testUpdateUser_Successful() {
        // Arrange
        UserDto userDto = new UserDto();
        userDto.setEmail("test@example.com");

        User existingUser = new User();
        existingUser.setEmail("test@example.com");

        when(userRepository.findByEmail(userDto.getEmail())).thenReturn(Optional.of(existingUser));
        when(userRepository.save(any(User.class))).thenAnswer(invocation -> invocation.getArgument(0));

        boolean result = userService.updateUser(userDto);

        assertTrue(result);
    }

    @Test
    void testUpdateUser_ResourceNotFoundException() {
        // Arrange
        UserDto userDto = new UserDto();
        userDto.setEmail("nonexistent@example.com");

        when(userRepository.findByEmail(userDto.getEmail())).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> userService.updateUser(userDto));
    }

    @Test
    void testDeleteUserByEmail_Successful() {

        String email = "test@example.com";

        User existingUser = new User();
        existingUser.setEmail(email);

        when(userRepository.findByEmail(email)).thenReturn(Optional.of(existingUser));

        boolean result = userService.deleteUserByEmail(email);

        verify(userRepository, times(1)).delete(existingUser);
    }

    @Test
    void testDeleteUserByEmail_ResourceNotFoundException() {
        String email = "nonexistent@example.com";

        when(userRepository.findByEmail(email)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> userService.deleteUserByEmail(email));
    }

    @Test
    void testSearchUsersByBirthDateRange_Successful() {
        // Arrange
        LocalDate fromDate = LocalDate.of(2000, 1, 1);
        LocalDate toDate = LocalDate.of(2000, 12, 31);

        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setBirthDate(LocalDate.of(2000, 5, 1));
        users.add(user1);

        User user2 = new User();
        user2.setBirthDate(LocalDate.of(2000, 6, 1));
        users.add(user2);

        when(userRepository.findByBirthDateBetween(fromDate, toDate)).thenReturn(users);

        List<User> foundUsers = userService.searchUsersByBirthDateRange(fromDate, toDate);

        assertEquals(2, foundUsers.size());
        assertTrue(foundUsers.contains(user1));
        assertTrue(foundUsers.contains(user2));
    }

    @Test
    void testSearchUsersByBirthDateRange_InvalidDateRange() {
        // Arrange
        LocalDate fromDate = LocalDate.of(2001, 1, 1); // Invalid date range
        LocalDate toDate = LocalDate.of(2000, 12, 31);

        assertThrows(IllegalArgumentException.class, () -> userService.searchUsersByBirthDateRange(fromDate, toDate));
    }
}
