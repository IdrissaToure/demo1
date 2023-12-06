package Arabe.Kalanso.demo.Modeles;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
public class Audio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAudio;


   // @Column(nullable = true)
    //private String audio;

    @Column(nullable = false)
    private String libelle;

    /*@Column(nullable = false)
    private String description;

    /*@OneToMany(mappedBy = "audio")
    @JsonIgnore
    private List<Audio> audioList;*/

   /* @NotNull
    @ManyToOne
    @JoinColumn(name = "idAdmin")
    private Administrareur admin;*/
}
