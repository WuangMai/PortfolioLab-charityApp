package pl.coderslab.charity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.LinkedList;


@Controller
public class HomeController {

    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;

    public HomeController(InstitutionRepository institutionRepository, DonationRepository donationRepository) {
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
    }

    @ModelAttribute
    public LinkedList<Institution> institutions() {
        return institutionRepository.findAll();
    }

    @RequestMapping("/")
    public String homeAction(Model model) {
        model.addAttribute("numOfDonations", donationRepository.countAllDonations());
        model.addAttribute("numOfBags", donationRepository.sumOfBags());
        return "index";
    }
}
