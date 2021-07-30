package pl.coderslab.charity.services;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import pl.coderslab.charity.model.Donation;

import java.security.Principal;

@Component
public class SimpleConfirmationEmail {

    private final EmailService emailService;

    public SimpleConfirmationEmail(EmailService emailService) {
        this.emailService = emailService;
    }

    @Async
    public void sendConfirmationEmail(Principal principal, Donation donation){
        emailService.sendSimpleMessage(principal.getName(),
                "Potwierdzenie odbioru",
                "Dziękujemy za przesłanie formularza!!\n\n" +
                        "Przesyłamy potwierdzenie odbioru worków\n\n" +
                        "Przekazujesz:\n" +
                        "Ilość worków: " + donation.getQuantity() + " zawierających " + donation.getCategories() +
                        "\ndla fundacji \"" + donation.getInstitution().getName() + "\" \n\n" +
                        "Adres odbioru: " + donation.getStreet() + "\n"+
                        donation.getZipCode() + " " + donation.getCity() + "\n"+
                        "Data odbioru: " + donation.getPickUpDate() + " godzina: " + donation.getPickUpTime() +
                        "\nKomentarz do odbioru: " + donation.getPickUpComment()
        );
    }
}
