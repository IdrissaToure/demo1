package Arabe.Kalanso.demo.Modeles;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "Administrateur")
public class Administrateur {

    @Id
    // Pour mettre le type en auto incremente
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    // Not Null de base de donnée
    @Column(nullable = false)
    private int idAdministrateur;

    //=========================== POUR NOM ===========================

    // Not Null de Spring
    // message : message afficher si le champs de notre Nom est vide
    @NotNull(message = "Champs vide")

    // lenght de notre nom
    // message : message afficher si le champs de notre Nom est vide
    @Size(min = 2, message = "nom court")

    // Not Null de base de donnée
    @Column(nullable = false)
    private String nom;

    //=========================== POUR PRENOM ===========================

    // Not Null de Spring
    // message : message afficher si le champs de notre prenom est vide
    @NotNull(message = "Champs vide")

    // lenght de notre prenom
    // message : message afficher si le champs de notre prenom est vide
    @Size(min = 2,message = "veuillez saisir un noms correcte")

    // Not Null de base donnée
    @Column(nullable = false)
    private String prenom;

    //========================== POUR EMAIL ============================

    // Not Null de Spring
    // message : message afficher
    // message : message afficher si le champs de notre email est vide
    @NotNull(message = "Champs vide")

    // L'Anotation d'Email
    // message : message afficher si le champs de notre email est vide
    @Email(message = "email incorrect")
    // Not Null de base de donnée
    @Column(nullable = false)
    private String email;

    // ==================== Pour le role =====================
    //private String role;

    //======================= POUR MOT DE PASSE ===============================

    // Not Null de Spring
    @NotNull(message = "Champs vide")

    // size : lenght de notre Mot de passe
    // message : message afficher si le champs de notre Mot de passe est vide
    @Size(min = 6, message = "Saisissez un Mot de pass correct")

    // Not Null de base de donnée
    @Column(nullable = false)
    private String motDePasse;

}
