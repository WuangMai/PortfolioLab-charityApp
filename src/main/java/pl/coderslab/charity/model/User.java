package pl.coderslab.charity.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity(name = "users")
@Getter @Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true, nullable = false, length = 50)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String password;

    @Transient
    private String passwordConfirm;

    private String role;

    private boolean enabled;

    public User(){
        super();
        this.enabled=false;
    }
}
