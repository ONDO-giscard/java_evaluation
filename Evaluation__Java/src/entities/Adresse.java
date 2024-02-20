package entities;

public class Adresse {
    private int id;
    private String ville;
    private String quartier;
    private int numeVilla;

    private Client client;

    public Adresse() {
    }

    public Adresse(String ville, String quartier, int numeVilla, Client client) {
        this.ville = ville;
        this.quartier = quartier;
        this.numeVilla = numeVilla;
        this.client = client;
    }

    public Adresse(String ville, String quartier, int numeVilla) {
        this.ville = ville;
        this.quartier = quartier;
        this.numeVilla = numeVilla;
    }

    public Adresse(int id, String ville, String quartier, int numeVilla) {
        this.id = id;
        this.ville = ville;
        this.quartier = quartier;
        this.numeVilla = numeVilla;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getQuartier() {
        return quartier;
    }

    public void setQuartier(String quartier) {
        this.quartier = quartier;
    }

    public int getNumeVilla() {
        return numeVilla;
    }

    public void setNumeVilla(int numeVilla) {
        this.numeVilla = numeVilla;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Adresse [id=" + id + ", ville=" + ville + ", quartier=" + quartier + ", numeVilla=" + numeVilla + "]";
    }
}
