package Arabe.Kalanso.demo.Repository;

import Arabe.Kalanso.demo.Modeles.Audio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AudioRepository extends JpaRepository<Audio,Long> {

    public  Audio findByLibelle(String audio);
}
