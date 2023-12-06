package Arabe.Kalanso.demo.Modeles;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;


@Data
@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUtilisateur;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false)
    @Email (message = "Email incorrect !")
    private String email;

    @Column(nullable = false)
    private String motDePasse;

}
