package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.model.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query("SELECT DISTINCT COUNT(d) FROM donations d")
    int countAllDonations();

    @Query("SELECT DISTINCT SUM(d.quantity) FROM donations d")
    int sumOfBags();

}
