package pl.coderslab.charity.services;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;

import java.security.Principal;
import java.util.Arrays;

@Component
public class SimpleConfirmationEmail {

    private final EmailService emailService;

    public SimpleConfirmationEmail(EmailService emailService) {
        this.emailService = emailService;
    }

    @Async
    public void sendConfirmationEmail(Principal principal, Donation donation){
        StringBuilder sb = new StringBuilder();
        emailService.sendSimpleMessage(principal.getName(),
                "Potwierdzenie odbioru",
                sb.append("Dziękujemy za przesłanie formularza!!\n\n")
                        .append("Przesyłamy potwierdzenie odbioru worków\n\n")
                        .append("Przekazujesz:\n")
                        .append("Ilość worków: ").append(donation.getQuantity()).append(" zawierających ")
                        .append(Arrays.toString(donation.getCategories().stream().map(Category::getName).toArray()))
                        .append("\ndla fundacji \"")
                        .append(donation.getInstitution().getName()).append("\" \n\n")
                        .append("Adres odbioru: ").append(donation.getStreet()).append("\n")
                        .append(donation.getZipCode()).append(" "). append(donation.getCity()).append("\n")
                        .append("Data odbioru: ").append(donation.getPickUpDate()).append(" godzina: ").append(donation.getPickUpTime())
                        .append("\nKomentarz do odbioru: ").append(donation.getPickUpComment())
                        .toString()
        );
    }
}
