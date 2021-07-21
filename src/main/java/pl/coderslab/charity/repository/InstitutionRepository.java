package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.model.Institution;

import java.util.LinkedList;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {

     LinkedList<Institution> findAll();

}
