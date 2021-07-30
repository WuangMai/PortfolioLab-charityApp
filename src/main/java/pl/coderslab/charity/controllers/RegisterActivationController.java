package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.model.VerificationToken;
import pl.coderslab.charity.services.IUserService;

import java.util.Calendar;

@Controller
@RequestMapping("/register-activation")
public class RegisterActivationController {
    private final IUserService service;

    public RegisterActivationController(IUserService service) {
        this.service = service;
    }

    @GetMapping
    public String getAction(Model model, @RequestParam("token") String token) {
        VerificationToken verificationToken = service.getVerificationToken(token);
        if (verificationToken == null) {
            model.addAttribute("message", "Zły token");//TODO Dodać obsługę tych wiadomości
            return "redirect:/badUser";
        }

        User user = verificationToken.getUser();
        Calendar cal = Calendar.getInstance();
        if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
            model.addAttribute("message", "Token stracił ważność");//TODO Dodać obsługę tych wiadomości
            return "redirect:/badUser";
        }
        user.setEnabled(true);
        service.saveRegisteredUser(user);
        return "redirect:/login";
    }

}
