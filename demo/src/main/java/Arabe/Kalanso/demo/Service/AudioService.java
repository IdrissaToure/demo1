package Arabe.Kalanso.demo.Service;

import Arabe.Kalanso.demo.Modeles.Audio;
import Arabe.Kalanso.demo.Repository.AudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
@Service
public class AudioService {
    private Audio audio;

    @Autowired
    public AudioRepository audioRepository;


    //methode ajout
   // public void createAudio(Audio audio, MultipartFile multipartFileImage, MultipartFile multipartFileAudio) throws Exception {
       /* if (audioRepository.findByLibelle(audio.getIdAudio()) == null) {
            //ajout de l'image
            if (multipartFileImage != null) {
                String location = "C:\\xampp\\htdocs\\demarche";
                try {
                    Path rootlocation = Paths.get(location);
                    if (!Files.exists(rootlocation)) {
                        Files.createDirectories(rootlocation);
                        Files.copy(multipartFileImage.getInputStream(),
                                rootlocation.resolve(multipartFileImage.getOriginalFilename()));
                        audio.setIdAudio("http://10.175.48.71/demarche/" + multipartFileImage.getOriginalFilename());
                    } else {
                        try {
                            String nom = location + "\\" + multipartFileImage.getOriginalFilename();
                            Path name = Paths.get(nom);
                            if (!Files.exists(name)) {
                                Files.copy(multipartFileImage.getInputStream(),
                                        rootlocation.resolve(multipartFileImage.getOriginalFilename()));
                                audio.setAudio("http://10.175.48.133/demarche/" + multipartFileImage.getOriginalFilename());
                            } else {
                                Files.delete(name);
                                Files.copy(multipartFileImage.getInputStream(), rootlocation.resolve(multipartFileImage.getOriginalFilename()));
                                audio.setAudio("http://10.175.48.133/demarche/" + multipartFileImage.getOriginalFilename());
                            }
                        } catch (Exception e) {
                            throw new Exception("Impossible de télécharger l\'image");
                        }
                    }

                } catch (Exception e) {
                    throw new Exception(e);
                }

            }
        }
    }*/
}