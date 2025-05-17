package com.example.BlogApplicationSpringboot.services.impl;
import com.example.BlogApplicationSpringboot.entities.User;
import com.example.BlogApplicationSpringboot.exceptions.ResourceNotFoundException;
import com.example.BlogApplicationSpringboot.payloads.UserDto;
import com.example.BlogApplicationSpringboot.repositories.UserRepo;
import com.example.BlogApplicationSpringboot.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        User savedUser = userRepo.save(user);
       return  modelMapper.map(savedUser, UserDto.class);
    }
    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", userId));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        User savedUser = this.userRepo.save(user);
        return modelMapper.map(savedUser,UserDto.class);
    }
    @Override
    public UserDto getUserById(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        UserDto mapuserDto = modelMapper.map(user, UserDto.class);
        return mapuserDto;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepo.findAll();
        List<UserDto> collectedUsers = users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
        return collectedUsers;
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        userRepo.delete(user);
    }
}
