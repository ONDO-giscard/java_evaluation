package entities;

import java.util.ArrayList;

public class Client {
    private int id;
    private String nomComplet;
    private String tel;
    private String email;
    
    //OneToMany Un Client peut avoir plusieurs Compte
    private ArrayList<Adresse> adresses;
    

    public Client() {
    }
    public Client(String nomComplet, String tel, String email) {
        this.nomComplet = nomComplet;
        this.tel = tel;
        this.email = email;
    }
    public Client(int id, String nomComplet, String tel, String email) {
        this.id = id;
        this.nomComplet = nomComplet;
        this.tel = tel;
        this.email = email;
    }
    public ArrayList<Adresse> getAdresses() {
        return adresses;
    }
    public void setAdresses(ArrayList<Adresse> adresses) {
        this.adresses = adresses;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNomComplet() {
        return nomComplet;
    }
    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Client [id=" + id + ", nomComplet=" + nomComplet + ", tel=" + tel + ", email=" + email + "]";
    }
}
