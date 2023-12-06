package Arabe.Kalanso.demo.Service;
import Arabe.Kalanso.demo.Modeles.Administrateur;
import Arabe.Kalanso.demo.Repository.AdministrateurRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministrateurService {

    @Autowired
    AdministrateurRepository administrateurRepository;

    public Administrateur creerAdministrateur(Administrateur administrateur){
        if (administrateurRepository.findByEmail(administrateur.getEmail()) == null) {
            return administrateurRepository.save(administrateur);
        } else {
            throw new DuplicateKeyException("Cet email existe déjà");
        }

    }

    public List<Administrateur> listAdministrateurs() {
        if (!administrateurRepository.findAll().isEmpty())
            return administrateurRepository.findAll();
        else
            throw new EntityNotFoundException ("Aucun administrateur n'a été trouver");
    }

    public Administrateur modifierAdministrateur(Administrateur administrateur) {

        if (administrateurRepository.findByIdAdministrateur(administrateur.getIdAdministrateur()) != null){
            return administrateurRepository.save(administrateur);
        }
        else {
            throw  new EntityNotFoundException("Cet administrateur n'existe pas");
        }

    }


    public String supprimeAdministrateur(Administrateur administrateur) {

        if (administrateurRepository.findByIdAdministrateur(administrateur.getIdAdministrateur()) != null) {
            administrateurRepository.delete(administrateur);
            return "Succès";
        } else {
            throw  new EntityNotFoundException("Cet administrateur n'existe pas");
        }

    }
    public Administrateur getAdministrateurById(int idAdministrateur){

        Administrateur administrateur= administrateurRepository.findByIdAdministrateur(idAdministrateur);
        if(administrateur ==null)
            throw new EntityNotFoundException("cet Administrateur n'existe pas");
        return administrateur;
    }

    public Administrateur connectionAdministrateur(String email, String motDePasse) {
        if (administrateurRepository.findByEmailAndMotDePasse(email, motDePasse) != null) {
            return (Administrateur) administrateurRepository.findByEmailAndMotDePasse(email, motDePasse);
        }else {
            throw  new EntityNotFoundException("Cet administrateur n'existe pas");
        }

    }
}
