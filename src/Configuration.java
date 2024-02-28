public class Configuration {
    private String description;
    private double prixMax;
    private Composant [] composants = new Composant[20];
    private int nmbComposants;
    private final int maxComposants = 20;

    public Configuration(String description, double prixMax, Composant[] composants){
        this.description = description;
        this.prixMax = prixMax;
        for(int i = 0; i < composants.length; i++){
            this.composants[i] = composants[i];
        }
        this.nmbComposants = NmbComposants();
    }
    public Configuration(Configuration originale){
this.description = new String(originale.description);
this.prixMax = originale.prixMax;
for(int i = 0; i < originale.composants.length; i++){
    this.composants[i] = originale.composants[i];;//ici
}
    }
    public double calculerTotal(double taxe){
        double prix = 0;
        double taxes = 1 + taxe;
        if(composants.length != 0) {
            for (int i = 0; i < composants.length; i++) {
                if(composants[i] != null) {
                    prix = composants[i].getPrix() + prix;
                }
            }
        }
        return (prix * taxes);
    }
    public Composant rechercher(String categorie){
        String categoriePiece;
        categorie = categorie.toUpperCase().trim();
        if(composants.length != 0) {
            for (int i = 0; i < composants.length; i++) {
                if(composants[i] != null) {
                    categoriePiece = composants[i].getCategorie();
                    if (categoriePiece.equals(categorie)) {
                        return composants[i];
                    }
                }
            }
        }
        return null;
    }
    public boolean ajouter(Composant composant) {
        String categorie = composant.getCategorie();
        String cateCompo;
        String nomCompo;
        String marqueCompo;
        int compteurBoucle = 0;
        if(nmbComposants < maxComposants){
        for (int i = 0; i < composants.length; i++) {
            if(composants[i] != null){
            if (categorie.equals(composants[i].getCategorie())) {
                cateCompo = composants[i].getCategorie();
                nomCompo = composants[i].getNom();
                marqueCompo = composants[i].getMarque();
                System.out.println("Il y a deja un composant de cette categorie : [" + cateCompo + "] " + marqueCompo + " " + nomCompo);
                return false;
            }
            }
        }
                for (int i = 0; i < composants.length; i++) {
                    if (composants[i] == null) {
                        composants[i] = composant;
                        if (calculerTotal(0) > prixMax) {//icii
                            cateCompo = composants[i].getCategorie();
                            nomCompo = composants[i].getNom();
                            marqueCompo = composants[i].getMarque();
                            composants[i] = null;
                            System.out.println("L'ajout de ce composant fera depasse le prix maximal : [" + cateCompo + "] " + marqueCompo + " " + nomCompo);
                            return false;
                        } else {
                            cateCompo = composants[i].getCategorie();
                            nomCompo = composants[i].getNom();
                            marqueCompo = composants[i].getMarque();
                            System.out.println("[" + cateCompo + "] " + marqueCompo + " " + nomCompo + " ajoute a la configuration (total = " + calculerTotal(0) + "$)");
                            this.nmbComposants = NmbComposants();
                            return true;
                        }
                    }
                }
   }
             System.out.println("Nombre de composents maximum atteint!");
             return false;
    }
    public boolean retirer(Composant composant) {
        String cateCompo = composant.getCategorie();
        String nomCompo = composant.getNom();
        String marqueCompo = composant.getMarque();
        for(int i = 0; i < composants.length; i++){
            if(composants[i] == composant){
                    for (int j = i; j < composants.length; j++) {
                        if (j + 1 < 19) {
                            if(composants[i +1] == null){
                                composants[i] = null;
                            }
                            if (composants[j + 1] != null) {
                                composants[j] = composants[j + 1];
                            } if (composants[j+2] == null) {
                                composants[j+1] = null;
                            }
                        }
                    }
                    System.out.println("[" + cateCompo + "] " + marqueCompo + " " + nomCompo + " retirer de la configuration (total = " + calculerTotal(0) + "$)");
                    this.nmbComposants = NmbComposants();
                    return true;
                }
            }
        System.out.println("Composant introuvable: " + "[" + cateCompo + "] " + marqueCompo + " " + nomCompo);
return false;
    }
    public boolean remplacer(Composant composant){
        String cateCompoRempl = composant.getCategorie();
        String nomCompoRempl = composant.getNom();
        String marqueCompoRempl = composant.getMarque();
        String cateCompo;
        String nomCompo;
        String marqueCompo;
        String categorie = composant.getCategorie();
        for(int i = 0; i < composants.length; i++){
            if(composants[i] != null){
            if(composants[i].getCategorie().equals(categorie)) {
                cateCompo = composants[i].getCategorie();
                nomCompo = composants[i].getNom();
                marqueCompo = composants[i].getMarque();
                composants[i] = null;
                System.out.println("[" + cateCompo + "] " + marqueCompo + " " + nomCompo + " retirer de la configuration (total = " + calculerTotal(0) + "$)");
                composants[i] = composant;
                System.out.println("[" + cateCompoRempl + "] " + marqueCompoRempl + " " + nomCompoRempl + " ajoute a la configuration (total = " + calculerTotal(0) + "$)");
                return true;
            }
            }
        }
return false;
    }
    public String toString() {
        System.out.println(description + " (" + prixMax + "$):");
        for(int i = 0; i < composants.length; i++){
            if(composants[i] != null){
                System.out.println((i + 1) + " : " + "[" + composants[i].getCategorie() + "]" + " " + composants[i].getMarque() + " " + composants[i].getNom() + " (" + composants[i].getPrix() + "$)");
            }
        }
return "";
    }

    public Composant[] getComposants() { return composants; }
    public int getNbComposants(){ return nmbComposants; }

    public int NmbComposants(){
        int nombreComposants = 0;
        if(composants.length != 0) {
            for (int i = 0; i < composants.length; i++) {
                if (composants[i] != null) {
                    nombreComposants++;
                }
            }
        }
        return nombreComposants;
    }
}
