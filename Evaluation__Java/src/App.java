import java.util.List;
import java.util.Scanner;

import entities.Adresse;
import entities.Client;
import services.AdresseService;
import services.ClientService;

public class App {
    public static void main(String[] args) throws Exception {
           AdresseService adresseService=new AdresseService();
           ClientService clientService=new ClientService();
           Scanner scanner=new Scanner(System.in);
           int choix;
           String tel;
           Client client;
           do{
              System.out.println("1-Ajouter un client");
              System.out.println("2-Lister les  clients");
              System.out.println("3-Ajouter une adresse et lui associe un client");
              System.out.println("4-Lister les adresse en affichant le nom du client");
              System.out.println("5-Quitter");
              choix=scanner.nextInt();
              scanner.nextLine();
              switch (choix) {
                case 1:
                      System.out.println("Entrer le numero de Telephone");
                      tel=scanner.nextLine();
                      client =clientService.recherClientParTelephone(tel);
                      if(client==null){
                        client=new Client();
                        client.setTel(tel);
                        System.out.println("Entrer le Nom et Prenom");
                        client.setNomComplet(scanner.nextLine());
                        System.out.println("Entrer Email");
                        client.setEmail(scanner.nextLine());
                        clientService.addClient(client);
                      }else{
                        System.out.println("Ce numero telephone existe deja");
                      }
                    
                case 2:
                      List<Client> clients = clientService.listerClients();
                      for (Client cl: clients) {
                            System.out.println("Nom et Prenom: "+ cl.getNomComplet());
                            System.out.println("Telephone : "+ cl.getTel());
                            System.out.println("Email : "+ cl.getEmail());
                            System.out.println("==================================");
                        }
                    break;
                case 3:
                    System.out.println("Entrer le numero de Telephone");
                    tel=scanner.nextLine();
                    client =clientService.recherClientParTelephone(tel);
                    if(client==null){
                        Adresse adresse=new Adresse();
                        System.out.println("Entrer la ville");
                        adresse.setVille(scanner.nextLine());
                        System.out.println("Entrer le quartier");
                        adresse.setQuartier(scanner.nextLine());
                        System.out.println("Entrer le numero de la villa");
                        adresse.setNumeVilla(scanner.nextInt());

                        adresse.setClient(client);
                        adresseService.addAdresse(adresse);
                    }else{
                      System.out.println("Ce numero telephone existe deja");
                    }
                    break;

                    
                    
                case 4:
                    System.out.println("Entrer le numero de Telephone");
                    tel=scanner.nextLine();
                    client =clientService.recherClientParTelephone(tel);
                    if(client==null){
                        System.out.println("Client : "+client.getNomComplet());
                        System.out.println("=============Adresse==============");
                        
                        for (Adresse add: adresseService.listerAdresseByClient(client)) {
                            System.out.println("ville: "+ add.getVille());
                            System.out.println("quartier : "+ add.getQuartier());
                            System.out.println("numero Villa : "+ add.getNumeVilla());
                            System.out.println("==================================");
                        }
                    }else{
                      System.out.println("Ce numero telephone existe deja");
                    }
                    break;
                default:
                    break;
              }
           }while(choix!=5);
           scanner.close();
    }
}
