public class Composant {
    private String categorie;
    private String marque;
    private String nom;
    private double prix;
    private double rabais;
    public Composant(String pcategorie, String pmarque, String pnom, double pprix){
        this.categorie = pcategorie.toUpperCase().trim();
        this.marque = pmarque;
        this.nom = pnom;
        this.prix = pprix;
    }
    public Composant copier(){
        String copieNom = this.nom;
        String copieCategorie = this.categorie;
        String copieMarque = this.marque;
        double copiePrix = this.prix;
        Composant copie = new Composant(copieCategorie, copieMarque, copieNom, copiePrix);
        return copie;
    }
    public boolean estIdentique(Composant autre){
        if(categorie == autre.getCategorie()){
            if(marque == autre.getMarque()) {
                if(nom == autre.getNom()) {
                    return true;
                }
                else{ return false;}
            }
            else{ return false;}
        }
        return false;
    }
    public String toString(){
        return "[" + categorie + "] " + marque + " " + nom;
    }
    public String getNom(){
        return nom;
    }
    public String getCategorie(){
        return categorie;
    }
    public String getMarque(){
        return marque;
    }
    public double getPrix(){
        double rab = 1 - rabais;
        return (this.prix * rab);
    }

    public double getRabais() {
        return rabais;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    public void setMarque(String marque) {
        this.marque = marque;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }
    public void setRabais(double rabais) {
        this.rabais = rabais;
    }
}


