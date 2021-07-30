package pl.coderslab.charity.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;
import pl.coderslab.charity.services.SimpleConfirmationEmail;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@Slf4j
@RequestMapping("/form")
public class DonationController {

    private final CategoryRepository categoryRepository;
    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;
    private final SimpleConfirmationEmail simpleConfirmationEmail;


    public DonationController(CategoryRepository categoryRepository, InstitutionRepository institutionRepository, DonationRepository donationRepository, SimpleConfirmationEmail simpleConfirmationEmail) {
        this.categoryRepository = categoryRepository;
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
        this.simpleConfirmationEmail = simpleConfirmationEmail;
    }

    @GetMapping
    public String formAction(Model model) {
        model.addAttribute("donation", new Donation());
        model.addAttribute("categoryList", categoryRepository.findAll());
        model.addAttribute("institutionList", institutionRepository.findAll());
        return "form";
    }

    @PostMapping
    public String postFormAction(@Valid Donation donation, Principal principal) {
        donationRepository.save(donation);
        simpleConfirmationEmail.sendConfirmationEmail(principal, donation);
        return "form-confirmation";
    }

}
