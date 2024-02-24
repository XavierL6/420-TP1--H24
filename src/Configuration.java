public class Configuration {
    private String description;
    private double prixMax;
    private Composant [] composants;
    private int nmbComposants;
    private final int maxComposants = 20;

    public Configuration(String description, double prixMax, Composant[] composants){
        this.description = description.toUpperCase();
        this.prixMax = prixMax;
        this.composants = composants;
    }
    public Configuration(Configuration originale){

    }
    public double calculerTotal(double taxe){
        double prix = 0;
        Composant nom;
        if(composants[0] != null) {
            for (int i = 0; i < composants.length; i++) {
                nom = composants[i];
                prix =+ nom.getPrix();
            }
        }
        return prix;
    }
    public Composant rechercher(String categorie){
        String categoriePiece;
        if(composants[0] != null) {
            for (int i = 0; i < composants.length; i++) {
                 categoriePiece = composants[i].getCategorie();
                 if(categoriePiece == categorie){
                     return composants[i];
                 }
            }
        }
        return null;
    }
    public boolean ajouter(Composant composant){
        String categorie = composant.getCategorie();
    if(maxComposants > nmbComposants){
        for(int i = 0; i < composants.length; i++){
            if(categorie == composants[i].getCategorie()){
                return false;
            }
            else{
                for(int x = 0; x < composants.length; i++){
                    if(composants[x] == null){
                        composants[x] = composant;
                        if(calculerTotal(0.15) > prixMax){
                            composants[x] = null;
                            return false;
                        }
                        else{
                            return true;
                        }
                    }
                }
            }
        }
    }
    return false;
    }
    public boolean retirer(Composant composant) {

    }
    public boolean remplacer(Composant composant){

    }
    public String toString() {

    }

    public Composant[] getComposants() { return composants; }
    public int getNbComposants(){ return nmbComposants; }
}
