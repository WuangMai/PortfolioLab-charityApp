package pl.coderslab.charity.services;

import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.model.VerificationToken;
import pl.coderslab.charity.repository.UserRepository;
import pl.coderslab.charity.repository.VerificationTokenRepository;

@Service
@Primary
public class UserService implements IUserService{
    private final UserRepository userRepository;
    private final VerificationTokenRepository verificationTokenRepository;

    public UserService(UserRepository userRepository, VerificationTokenRepository verificationTokenRepository) {
        this.userRepository = userRepository;
        this.verificationTokenRepository = verificationTokenRepository;
    }

    @Override
    public User registerNewUserAccount(User user) {
        if(emailExist(user.getEmail())){
            throw new UsernameNotFoundException("There is an account with that email address");
        }

        return userRepository.save(user);
    }

    private boolean emailExist(String email){
        return userRepository.findByEmail(email) != null;
    }

    @Override
    public User getUser(String verificationToken) {
        return verificationTokenRepository.findByToken(verificationToken).getUser();
    }

    @Override
    public void saveRegisteredUser(User user) {
    userRepository.save(user);
    }

    @Override
    public void createVerificationToken(User user, String token) {
        VerificationToken newToken = new VerificationToken(token, user);
        verificationTokenRepository.save(newToken);
    }

    @Override
    public VerificationToken getVerificationToken(String verificationToken) {
        return verificationTokenRepository.findByToken(verificationToken);
    }
}
