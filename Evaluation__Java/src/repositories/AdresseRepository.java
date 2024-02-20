package repositories;

import java.sql.ResultSet;
import java.util.ArrayList;

import core.Database;
import entities.Adresse;
import entities.Client;

public class AdresseRepository extends Database {
    // private final String SQL_SELECT_ALL="select * from adresse  ";
    private final String SQL_SELECT_BY_CLIENT="select a.* from adresse a, client c where a.client=c.id and c.id=?";
    private final String SQL_INSERT="INSERT INTO `adresse` (`ville`, `quartier`, `numVilla`, `client`) VALUES (?,?,?,?) ";
 

    
      public void insert(Adresse adresse){
         
          try {
             ouvrirConnexion();
             initPrepareStatement(SQL_INSERT);
             statement.setString(1, adresse.getVille());
             statement.setString(2, adresse.getQuartier());
             statement.setInt(3, adresse.getNumeVilla());
             statement.setInt(4, adresse.getClient().getId());
              executeUpdate();
             fermerConnexion();
          } catch (Exception e) 
           {
            System.out.println("Erreur de chargement du Driver");
           }
          }

      public ArrayList<Adresse>  selectAllByClient(Client client){
            ArrayList<Adresse> adresses=new ArrayList<>();
            try {
                ouvrirConnexion();
                initPrepareStatement(SQL_SELECT_BY_CLIENT);
                statement.setInt(1, client.getId());
                ResultSet rs= executeSelect();
                while (rs.next()) {
                    //rs une ligne de la requete ==> a une agence
                    Adresse adresse=new Adresse();
                    adresse.setId(rs.getInt("id"));
                    adresse.setVille(rs.getString("ville"));
                    adresse.setQuartier(rs.getString("quartier"));
                    adresse.setNumeVilla(rs.getInt("numVilla"));
                    adresse.setClient(client);
                    adresses.add(adresse);
                }
                rs.close();
                fermerConnexion();
            } catch (Exception e) {
                System.out.println("Erreur de chargement du Driver");
            }
            return adresses;
     }

}
