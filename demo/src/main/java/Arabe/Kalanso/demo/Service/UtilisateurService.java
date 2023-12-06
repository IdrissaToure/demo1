package Arabe.Kalanso.demo.Service;

import Arabe.Kalanso.demo.Modeles.Administrateur;
import Arabe.Kalanso.demo.Modeles.Utilisateur;
import Arabe.Kalanso.demo.Repository.AdministrateurRepository;
import Arabe.Kalanso.demo.Repository.UtilisateurRepository;
import com.sun.jdi.InternalException;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class UtilisateurService {

   /* @Autowired
    private UtilisateurRepository utilisateurRepository;


    //Methode pour créer un user

    public Utilisateur createUtilisateur(Utilisateur utilisateur, MultipartFile multipartFile) throws Exception {
        if(utilisateurRepository.findByEmail(utilisateur.getEmail()) == null){
            if(multipartFile != null){
                String location = "C:\\xampp\\htdocs\\monprojetfin";
                try{
                    Path rootlocation = Paths.get(location);
                    if(!Files.exists(rootlocation)){
                        Files.createDirectories(rootlocation);
                        Files.copy(multipartFile.getInputStream(),
                                rootlocation.resolve(multipartFile.getOriginalFilename()));
                        utilisateur.setImage("http://localhost/monprojetfin/"
                                +multipartFile.getOriginalFilename());
                    }else{
                        try {
                            String nom = location+"\\"+multipartFile.getOriginalFilename();
                            Path name = Paths.get(nom);
                            if(!Files.exists(name)){
                                Files.copy(multipartFile.getInputStream(),
                                        rootlocation.resolve(multipartFile.getOriginalFilename()));
                                utilisateur.setImage("http://localhost/monprojetfin/"
                                        +multipartFile.getOriginalFilename());
                            }else{
                                Files.delete(name);
                                Files.copy(multipartFile.getInputStream(),rootlocation.resolve(multipartFile.getOriginalFilename()));
                                utilisateur.setImage("http://localhost/monprojetfin/"
                                        +multipartFile.getOriginalFilename());
                            }
                        }catch (Exception e){
                            throw new Exception("Impossible de télécharger l\'image");
                        }
                    }
                } catch (Exception e){
                    throw new Exception(e.getMessage());
                }
            }
            return (Utilisateur) utilisateurRepository.save(utilisateur);
        }else{
            throw new EntityExistsException("Cet compte existe déjà");
        }
    }

    //Méthode de recupperation des users
    public List<Utilisateur> getAllUtisateur(){
        List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
        if(utilisateurs.isEmpty()){
            throw  new InternalException("Aucun utilisateur trouvé");
        }
        return utilisateurs;
    }

    //Méthode de recupperation d'un seul user

    public  Utilisateur getUtilisateurById(long idUtilisateur){
        Utilisateur utilisateur = (Utilisateur) utilisateurRepository.findByIdUtilisateur(idUtilisateur);

        if(utilisateur == null){
            throw new EntityNotFoundException("Cet utilisateur n'existe pas");
        }
        return utilisateur;
    }

    //Methode permettant d'éditer un user

    public Utilisateur updateUtilisateur(Utilisateur utilisateur, long id, MultipartFile multipartFile) throws Throwable {
        Utilisateur user = (Utilisateur) utilisateurRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("utilisateur introuvable avec id :" +id));

        user.setNom(utilisateur.getNom());
        user.setPrenom(utilisateur.getPrenom());
        user.setEmail(utilisateur.getEmail());
        user.setMotDePasse(utilisateur.getMotDePasse());


        if(multipartFile != null){
            String location = "C:\\xampp\\htdocs\\monprojetfin";
            try{
                Path rootlocation = Paths.get(location);
                if(!Files.exists(rootlocation)){
                    Files.createDirectories(rootlocation);
                    Files.copy(multipartFile.getInputStream (),
                            rootlocation.resolve(multipartFile.getOriginalFilename()));
                    user.setImage("http:// 10.175.48.133/monprojetfin/"
                            +multipartFile.getOriginalFilename());
                }else{
                    try {
                        String nom = location+"\\"+multipartFile.getOriginalFilename();
                        Path name = Paths.get(nom);
                        if(!Files.exists(name)){
                            Files.copy(multipartFile.getInputStream(),
                                    rootlocation.resolve(multipartFile.getOriginalFilename()));
                            user.setImage("http:// 10.175.48.133/monprojetfin/"
                                    +multipartFile.getOriginalFilename());
                        }else{
                            Files.delete(name);
                            Files.copy(multipartFile.getInputStream(),rootlocation.resolve(multipartFile.getOriginalFilename()));
                            user.setImage("http:// 10.175.48.133/monprojetfin/"
                                    +multipartFile.getOriginalFilename());
                        }
                    }catch (Exception e){
                        throw new Exception("Impossible de télécharger l\'image");
                    }
                }
            } catch (Exception e){
                throw new Exception(e.getMessage());
            }
        }
        return (Utilisateur) utilisateurRepository.save(utilisateur);
    }

    //Suppression de l'utilisateur

    public String deleteUtilisateur(long id) {
        Utilisateur utilisateur = utilisateurRepository.findByIdUtilisateur(id);

        if (utilisateur == null) {
            throw new EntityNotFoundException("Désolé, l'utilisateur à supprimer n'existe pas");
        } // Assuming that 'delete' is a method to delete the user in your Utilisateur class

        utilisateurRepository.deleteById(id);

        return "Utilisateur supprimé avec succès";
    }
    //connexion d'user
    public Utilisateur connexion(String email, String motDePsse){
        Utilisateur utilisateur = (Utilisateur) utilisateurRepository.findByEmailAndMotDePasse(email, motDePsse);
        if(utilisateur == null){
            throw  new EntityNotFoundException("Ce compte n'existe pas");
        }
        return utilisateur;
    }*/
   @Autowired // Injection de dependance
           UtilisateurRepository utilisateurRepository; // Un variable de type UtilisateurRepository

    // Portee , type de retour , nom de la fonction
    public Utilisateur creerutilisateur(Utilisateur utilisateur){
        if (utilisateurRepository.findByEmail(utilisateur.getEmail()) == null) {
            return utilisateurRepository.save(utilisateur);
        } else {
            throw new DuplicateKeyException("Cet email existe déjà");
        }

    }

    public List<Utilisateur> listUtilisateur() {
        if (!utilisateurRepository.findAll().isEmpty())
            return utilisateurRepository.findAll();
        else
            throw new EntityNotFoundException ("Aucun utilisateur n'a été trouver");
    }

    public Utilisateur modifierUtilisateur(Utilisateur utilisateur) {

        if (utilisateurRepository.findByIdUtilisateur(utilisateur.getIdUtilisateur()) != null){
            return utilisateurRepository.save(utilisateur);
        }
        else {
            throw  new EntityNotFoundException("Cet utilisateur n'existe pas");
        }

    }


    public String supprimeUtilisateur(Utilisateur utilisateur) {

        if (utilisateurRepository.findByIdUtilisateur(utilisateur.getIdUtilisateur()) != null) {
            utilisateurRepository.delete(utilisateur);
            return "Succès";
        } else {
            throw  new EntityNotFoundException("Cet utilisateur n'existe pas");
        }

    }
    public Utilisateur getUtilisateurById(int idUtilisateur){

        Utilisateur utilisateur= utilisateurRepository.findByIdUtilisateur(idUtilisateur);
        if(utilisateur ==null)
            throw new EntityNotFoundException("cet Utilisateur n'existe pas");
        return utilisateur;
    }

    public Utilisateur connectionUtilisateur(String email, String motDePasse) {
        if (utilisateurRepository.findByEmailAndMotDePasse(email, motDePasse) != null) {
            return (Utilisateur) utilisateurRepository.findByEmailAndMotDePasse(email, motDePasse);
        }else {
            throw  new EntityNotFoundException("Cet utilisateur n'existe pas");
        }

    }
}
