package pl.coderslab.charity.services;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Async
public class SimpleRegistrationToken {

    private final EmailService emailService;

    public SimpleRegistrationToken(EmailService emailService) {
        this.emailService = emailService;
    }

    public void sendToken(String email, String token){
        emailService.sendSimpleMessage(email,
                "Potwierdzenie rejestracji na CharityApp",
                "Aby dokończyć rejestrację kliknij w link poniżej\n\n" +
                        "http://localhost:8080/register-activation?token=" + token +"\n\n" +
                        "Link aktywacyjny będzie ważny przez 60 minut");
    }

}
