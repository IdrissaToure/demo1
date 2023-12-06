package Arabe.Kalanso.demo.Repository;

import Arabe.Kalanso.demo.Modeles.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministrateurRepository extends JpaRepository<Administrateur,Long> {
    public Administrateur findByEmailAndMotDePasse(String email, String motDePsse);

    public Administrateur findByIdAdministrateur(long id);

    public Administrateur findByEmail(String Email);

}
