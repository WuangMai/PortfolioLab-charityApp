<img alt="Logo" src="https://lms.coderslab.pl/img/cl-logo.svg" width="400">


Projekt realizowany w ramach modułu PortfolioLab na kursie Java Developer

Założenia do zaliczenia projektu:
- otrzymuję szablon html z plikami css oraz js
- tworzę bazę danych MySQL
- tworzę wymagane encje
- na stronie głównej zamieniam wybrane statyczne elementy na dynamicznie odczytywane z bazy danych
- twrozę formularz obsługiwany przez Spring MVC
- tworzę skrypt w JS wyświetlający potwierdzenie wprowadzonych danych w formularzu
- zapisuję obiekt do bazy

	Wymagania zostały spełnione używając Spring Boot, Spring Form, Hibernate, Spring Data JPA
	Dodatkowo wdrożyłem Spring Security obsługujące rejestrację z wysyłką maila z linkiem aktywacyjnym konto.
	Możliwość przesłania formularza ograniczyłem tylko do zalogowanych użytkowników.
	Dodałem wysyłanie maila w tle, aby użytkownik nie czekał aż mail faktycznie się wyśle użwając @Async
	Dodałem wysyłanie maila z potwierdzeniem przesłania formularza(również w tle)
	Wprowadziłem walidację haseł tworząc adnotację @ValidPassword
