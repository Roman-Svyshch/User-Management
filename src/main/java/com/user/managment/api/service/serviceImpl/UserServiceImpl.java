package com.user.managment.api.service.serviceImpl;

import com.user.managment.api.exception.ResourceNotFoundException;
import com.user.managment.api.exception.UserAlreadyExistsException;
import com.user.managment.api.mapper.UserMapper;
import com.user.managment.api.model.User;
import com.user.managment.api.repository.UserRepository;
import com.user.managment.api.service.IUserService;
import com.user.managment.api.dto.UserDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    private final UserRepository userRepository;

    private static final int MINIMUM_AGE = 18;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(UserDto userDto) {
        if (Period.between(userDto.getBirthDate(), LocalDate.now()).getYears() < MINIMUM_AGE) {
            throw new IllegalArgumentException("User must be at least 18 years old");
        }
        User newUser = UserMapper.mapToUser(userDto,new User());
        Optional<User> optionalUser = userRepository.findByPhoneNumber(userDto.getPhoneNumber());
        if (optionalUser.isPresent()){
            throw new UserAlreadyExistsException("Customer already registered with given number " + userDto.getPhoneNumber());
        }
        return userRepository.save(newUser);
    }

    @Override
    public boolean updateUser(UserDto userDto) {
        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            UserMapper.mapToUser(userDto, user);
            userRepository.save(user);
            return true;
        } else {
            throw new ResourceNotFoundException("User", "User Email", userDto.getEmail());
        }
    }





    @Override
    public boolean deleteUserByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(
                ()->  new ResourceNotFoundException("User", "User Id", email)

        );
        userRepository.delete(user);
        return true;
    }

    @Override
    public List<User> searchUsersByBirthDateRange(LocalDate fromDate, LocalDate toDate) {
      if (fromDate.isAfter(toDate)){
          throw new IllegalArgumentException("Start date must be before end date");

      }
        List<User> users = userRepository.findByBirthDateBetween(fromDate, toDate);

        return users;

    }
}
