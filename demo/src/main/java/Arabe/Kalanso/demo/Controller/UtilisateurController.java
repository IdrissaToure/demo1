package Arabe.Kalanso.demo.Controller;

import Arabe.Kalanso.demo.Modeles.Administrateur;
import Arabe.Kalanso.demo.Modeles.Utilisateur;
import Arabe.Kalanso.demo.Service.AdministrateurService;
import Arabe.Kalanso.demo.Service.UtilisateurService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.DataInput;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/utilisateur")
public class UtilisateurController {

    /*@Autowired
    private UtilisateurService utilisateurService;
    @Autowired
    private AdministrateurService administrateurService;
    public UtilisateurController(UtilisateurService utilisateurService, AdministrateurService adminService) {
        this.utilisateurService = utilisateurService;
        this.administrateurService = administrateurService;
    }

   @PostMapping("/create")
    @Operation(summary = "Création de compte utilisateur")
    public ResponseEntity<Utilisateur> createUtilisateur(@Valid @RequestParam("utilisateur") String adminString,
                                                         @RequestParam(value = "image", required = false) MultipartFile multipartFile) throws Exception {
        Utilisateur utilisateur = new Utilisateur();
        try {
            utilisateur = new JsonMapper().readValue((DataInput) utilisateur, Utilisateur.class);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        Utilisateur saveUser = utilisateurService.createUtilisateur(utilisateur, multipartFile);
        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);

    }

    @PutMapping ("update/{id}")
    @Operation(summary = "Mise à jour d'un utilisateur")
    public ResponseEntity<Utilisateur> updateUser (@RequestParam(value = "idUtilisateur") long idUtilisateur, @Valid @RequestParam("utilisateur") String utilisateurString,
                                                   @RequestParam(value = "image", required = false) MultipartFile multipartFile) throws Throwable {
        Utilisateur utilisateur = new Utilisateur();
        try {
            utilisateur = new JsonMapper().readValue(utilisateurString, Utilisateur.class);
        } catch (JsonProcessingException e) {
            throw new Exception(e.getMessage());
        }

        Utilisateur updateUser = utilisateurService.updateUtilisateur(utilisateur, idUtilisateur, multipartFile);

        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

   @GetMapping("/read/{id}")
    @Operation(summary = "Affichage d'un admin")
   public Utilisateur getUtilisateurResponseEntityById (@PathVariable @Valid long id){
        return utilisateurService.getUtilisateurById(id);
    }

    @GetMapping("/read")
    @Operation(summary = "Affichage d'un admin")
    public List<Utilisateur> getUtilisateu (){
        return utilisateurService.getAllUtisateur();
    }


    //pour connecte selment
   @GetMapping("/login")
    @Operation(summary = "Connexion d'un utilisateur")
    public Object connexion (@RequestParam("email") String email, @RequestParam("mdp") String mdp){
        return utilisateurService.connexion(email, mdp);
    }
    @GetMapping("/tab1")
    public ResponseEntity<String> getTab1Page() {
        // Logique pour récupérer les données de la page d'accueil
        return ResponseEntity.ok("Bienvenue sur la page d'accueil !");
    }

    @DeleteMapping("/delete/{idUser}")
    public String supprimer(@PathVariable long idUser) {
        return utilisateurService.deleteUtilisateur(idUser);
    }*/
    @Autowired
    private UtilisateurService utilisateurService;

    @Operation(summary = "Ajouter un utilisateur")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",description = "Admin inserer avec succès",content = {
                    @Content(mediaType = "application/json",schema = @Schema(implementation = Utilisateur.class))
            }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400",description = "Mauvaise requete", content = @Content),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "409",description = "L'admin exist déjà", content = @Content),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500",description = "Erreur server", content = @Content)
    })
    @PostMapping("/add")
    public Object addUtilisateur(@Valid @RequestBody Utilisateur utilisateur){
        return utilisateurService.creerutilisateur(utilisateur);
    }


    @Operation(summary = "Connexion d'un utilisateur")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",description = "Administrateur connecter",content = {
                    @Content(mediaType = "application/json",schema = @Schema(implementation = Utilisateur.class))
            }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400",description = "Mauvaise requete", content = @Content),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404",description = "Administrateur introuvable", content = @Content),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500",description = "Erreur server", content = @Content)
    })
    @GetMapping("/login")
    public Object connexion(@Parameter(description = "Email de utilisateur") @RequestParam("email") String email,
                            @Parameter(description = "Mot de passe de utilisateur") @RequestParam("motDePasse") String motDePasse) {
        return utilisateurService.connectionUtilisateur(email, motDePasse);
    }


    @Operation(summary = "Renvoie la liste des administrateur")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",description = "List renvoyer",content = {
                    @Content(mediaType = "application/json",schema = @Schema(implementation = Utilisateur.class))
            }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400",description = "Mauvaise requete", content = @Content),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "204",description = "List vide", content = @Content),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500",description = "Erreur server", content = @Content)
    })
    @GetMapping("/list")
    public List<Utilisateur> allUtilisateurs(){
        return utilisateurService.listUtilisateur();
    }


    @Operation(summary = "Modifier un admin")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",description = "Administrateur modifier",content = {
                    @Content(mediaType = "application/json",schema = @Schema(implementation = Utilisateur.class))
            }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400",description = "Mauvaise requete", content = @Content),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404",description = "Administrateur n'existe pas", content = @Content),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500",description = "Erreur server", content = @Content)
    })
    @PutMapping("/modifier")
    public  Object modifierUtilisateur(@Valid @RequestBody Utilisateur utilisateur) {
        return utilisateurService.modifierUtilisateur(utilisateur);
    }

    @GetMapping("/read/{idUtilisateur}")
    @Operation(summary = "Affichage  d'un Administrateur")
    public ResponseEntity<Utilisateur> getUtilisateurById(@Valid @PathVariable int idUtilisateur){
        return new ResponseEntity<>(utilisateurService.getUtilisateurById(idUtilisateur), HttpStatus.OK) ;}
    // @GetMapping("/profile")
    //public ResponseEntity<Administrateur> getAdminProfile( Administrateur administrateur) {
    // Récupérez les informations du profil de l'administrateur actuellement connecté
    // Administrateur admin = administrateurService.connectionAdministrateur(administrateur.getEmail(), administrateur.getMotDePasse());

    // if (admin != null) {
    //  return ResponseEntity.ok(admin);
    // } else {
    // return ResponseEntity.notFound().build();
    //}
    //}


    @Operation(summary = "Supprimer un admin")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",description = "Utilisateur supprimer",content = {
                    @Content(mediaType = "application/json",schema = @Schema(implementation = Utilisateur.class))
            }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400",description = "Mauvaise requete", content = @Content),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404",description = "Utilisateurateur introuvable", content = @Content),
            @ApiResponse(responseCode = "500",description = "Erreur server", content = @Content)
    })
    @DeleteMapping("/supprimer")
    public String supprimer(@Valid @RequestBody Utilisateur utilisateur) {
        return utilisateurService.supprimeUtilisateur(utilisateur);
    }



}