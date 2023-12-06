package Arabe.Kalanso.demo.Controller;

import Arabe.Kalanso.demo.Modeles.Administrateur;
import Arabe.Kalanso.demo.Service.AdministrateurService;
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
import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/adminnistrateur")

public class AdministrareurController {



   /* @Autowired
    private  AdministrateurService administrateurService;*/

/*
    @GetMapping("/{id}")
    @Operation(summary = "Permet d'avoir un utilisateur specifique")
    public Administrateur getAdministrateurByIdById(@PathVariable Long id){
        Optional<Administrateur> administrateur = UtilisateurService.getAdministrateurById(id);
        return (Administrateur) administrateur.orElse(null);
    }
    @PutMapping("/modifier/{id}")
    @Operation(summary = "Permet de modifier un utilisateur")
    public Optional<Administrateur> updateAdministrateur(@PathVariable Long id,@RequestBody Administrateur administrateur){
        Optional<Administrateur> administrateur1 = Optional.ofNullable(administrateurService.getAdminById(id);
        return Optional.ofNullable(administrateur1.orElse(null)) ;
    }

    @DeleteMapping("/supprimer/{id}")
    @Operation(summary = "Permet de supprimer un utilisateur")
    public  Boolean test(@PathVariable Long id){
        return administrateurService.deleteAdministrareur(id);
    }

    @GetMapping("liste")
    @Operation(summary = "Permet d'avoir la liste des utilisateurs")
    public Optional<List> getUsers(){
        Optional<List> user = Optional.ofNullable(administrateurService.getAdminById());
        return Optional.ofNullable(user.orElse(null));
    }

    @PostMapping("/ajouter")
    @Operation(summary = "Permet de créer un utilisateur")
    public Administrateur create(@RequestBody Administrateur administrateur){
        return administrateurService.createAdminstrateur(administrateur);
    }
*/

  /*  @PostMapping("/login")
    public ApiResponse login(@RequestParam String email, @RequestParam String password){
        return (ApiResponse) administrateurService.connexion(email, password);
    }*/
  @Autowired
  private AdministrateurService administrateurService;

    @Operation(summary = "Ajouter un administrateur")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",description = "Admin inserer avec succès",content = {
                    @Content(mediaType = "application/json",schema = @Schema(implementation = Administrateur.class))
            }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400",description = "Mauvaise requete", content = @Content),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "409",description = "L'admin exist déjà", content = @Content),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500",description = "Erreur server", content = @Content)
    })
    @PostMapping("/add")
    public Object addAdministrateur(@Valid @RequestBody Administrateur administrateur){
        return administrateurService.creerAdministrateur(administrateur);
    }


    @Operation(summary = "Connexion d'un administrateur")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",description = "Administrateur connecter",content = {
                    @Content(mediaType = "application/json",schema = @Schema(implementation = Administrateur.class))
            }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400",description = "Mauvaise requete", content = @Content),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404",description = "Administrateur introuvable", content = @Content),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500",description = "Erreur server", content = @Content)
    })
    @GetMapping("/login")
    public Object connexion(@Parameter(description = "Email de l'administrateur") @RequestParam("email") String email,
                            @Parameter(description = "Mot de passe de l'administrateur") @RequestParam("motDePasse") String motDePasse) {
        return administrateurService.connectionAdministrateur(email, motDePasse);
    }


    @Operation(summary = "Renvoie la liste des administrateur")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",description = "List renvoyer",content = {
                    @Content(mediaType = "application/json",schema = @Schema(implementation = Administrateur.class))
            }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400",description = "Mauvaise requete", content = @Content),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "204",description = "List vide", content = @Content),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500",description = "Erreur server", content = @Content)
    })
    @GetMapping("/list")
    public List<Administrateur> allAdmins(){
        return administrateurService.listAdministrateurs();
    }


    @Operation(summary = "Modifier un admin")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",description = "Administrateur modifier",content = {
                    @Content(mediaType = "application/json",schema = @Schema(implementation = Administrateur.class))
            }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400",description = "Mauvaise requete", content = @Content),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404",description = "Administrateur n'existe pas", content = @Content),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500",description = "Erreur server", content = @Content)
    })
    @PutMapping("/modifier")
    public  Object modifierAdministrateur(@Valid @RequestBody Administrateur administrateur) {
        return administrateurService.modifierAdministrateur(administrateur);
    }

    @GetMapping("/read/{idAdministrateur}")
    @Operation(summary = "Affichage  d'un Administrateur")
    public ResponseEntity<Administrateur> getAdministrateurById(@Valid @PathVariable int idAdministrateur){
        return new ResponseEntity<>(administrateurService.getAdministrateurById(idAdministrateur), HttpStatus.OK) ;}
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
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",description = "Administrateur supprimer",content = {
                    @Content(mediaType = "application/json",schema = @Schema(implementation = Administrateur.class))
            }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400",description = "Mauvaise requete", content = @Content),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404",description = "Administrateur introuvable", content = @Content),
            @ApiResponse(responseCode = "500",description = "Erreur server", content = @Content)
    })
    @DeleteMapping("/supprimer")
    public String supprimer(@Valid @RequestBody Administrateur administrateur) {
        return administrateurService.supprimeAdministrateur(administrateur);
    }

}
