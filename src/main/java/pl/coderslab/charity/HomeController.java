package pl.coderslab.charity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.LinkedList;


@Controller
public class HomeController {

    private final InstitutionRepository institutionRepository;

    public HomeController(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @ModelAttribute
    public LinkedList<Institution> institutions(){
        return institutionRepository.findAll();
    }

    @RequestMapping("/")
    public String homeAction(Model model){
        return "index";
    }
}
