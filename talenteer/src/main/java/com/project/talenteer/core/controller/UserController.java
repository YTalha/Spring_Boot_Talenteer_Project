package com.project.talenteer.core.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.talenteer.core.entity.User;
import com.project.talenteer.core.service.JwtService;
import com.project.talenteer.core.service.UserService;
import com.project.talenteer.core.utilities.result.DataResult;
import com.project.talenteer.core.utilities.result.ErrorDataResult;
import com.project.talenteer.core.utilities.result.SuccessDataResult;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;
	private JwtService jwtService;

    public UserController(UserService userService, JwtService jwtService){
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public ResponseEntity<?> add(@Valid @RequestBody User user){
		return ResponseEntity.ok(this.userService.add(user));
	}
	
	
	@PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password) {
        DataResult<User> result = this.userService.login(email, password);

        if (result.isSuccess()) {
            User user = result.getData();
            String token = jwtService.generateToken(user);
            return ResponseEntity.ok(new SuccessDataResult<>(Map.of("token", "Bearer " + token, "user", user), "Giriş başarılı."));
        } else {
            return ResponseEntity.ok(new ErrorDataResult<>("Giriş başarısız. Kullanıcı adı veya şifre hatalı."));
        }
    }
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		Map<String,String> validationErrors=new HashMap<String, String>();
		for(FieldError fieldError:exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		ErrorDataResult<Object> errors=new ErrorDataResult<Object>(validationErrors,"Doğrulama Hataları");
		return errors;
	}

}
