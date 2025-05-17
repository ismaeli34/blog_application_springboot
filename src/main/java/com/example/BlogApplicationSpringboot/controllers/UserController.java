package com.example.BlogApplicationSpringboot.controllers;
import com.example.BlogApplicationSpringboot.payloads.UserDto;
import com.example.BlogApplicationSpringboot.response.ApiResponse;
import com.example.BlogApplicationSpringboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // POST - Create User
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto createUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }
    // PUT - Update User
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,
                                              @PathVariable("userId") Integer userId){
        UserDto updateUser = this.userService.updateUser(userDto, userId);
        return new ResponseEntity<>(updateUser,HttpStatus.OK);

    }
    //DELETE - Delete User
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer userId){
       this.deleteUser(userId);
       return new ResponseEntity(new ApiResponse("User deleted Successfully",true),HttpStatus.OK);
    }

    // GET - Get Users
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getUsers(){
        List<UserDto> allUsers = this.userService.getAllUsers();
        return new ResponseEntity<>(allUsers,HttpStatus.OK);
    }

    // GET BY ID - Get Users by Id
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable("userId") Integer userId){
        UserDto userById = this.userService.getUserById(userId);
        return new ResponseEntity<>(userById,HttpStatus.OK);
    }


}
