package pl.coderslab.charity.services;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.model.VerificationToken;

@Service
public interface IUserService {
    User registerNewUserAccount(User user);

    User getUser(String verificationToken);

    void saveRegisteredUser(User user);

    void createVerificationToken(User user, String token);

    VerificationToken getVerificationToken(String verificationToken);
}
