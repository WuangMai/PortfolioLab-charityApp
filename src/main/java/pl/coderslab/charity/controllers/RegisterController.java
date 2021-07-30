package pl.coderslab.charity.controllers;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repository.UserRepository;
import pl.coderslab.charity.services.IUserService;
import pl.coderslab.charity.services.SimpleRegistrationToken;

import javax.validation.Valid;
import java.util.UUID;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final PasswordEncoder passwordEncoder;
    private final IUserService service;
    private final UserRepository userRepository;
    private final SimpleRegistrationToken registrationToken;

    public RegisterController(UserRepository userRepository, PasswordEncoder passwordEncoder, IUserService service, SimpleRegistrationToken token) {
        this.passwordEncoder = passwordEncoder;
        this.service = service;
        this.userRepository = userRepository;
        this.registrationToken = token;
    }

    @GetMapping
    public String showRegPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping
    public String postRegPage(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "/register";
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setRole("ROLE_USER");
        String token = UUID.randomUUID().toString();
        userRepository.save(user);
        service.createVerificationToken(user, token);
        registrationToken.sendToken(user.getEmail(),token);
        return "register-confirmation";
    }

}
