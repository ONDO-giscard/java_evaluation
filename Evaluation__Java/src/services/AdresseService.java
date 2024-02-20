package services;

import java.util.List;

import entities.Adresse;
import entities.Client;
import repositories.AdresseRepository;

public class AdresseService {
    private AdresseRepository adresseRepository=new AdresseRepository();
         public void addAdresse(Adresse client){
           adresseRepository.insert(client);
         }
         public List<Adresse> listerAdresseByClient(Client client){
            return adresseRepository.selectAllByClient(client);
         }
}
