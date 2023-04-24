package welcome;


public class Welcome {

    public static String welcome(String nom) {
        StringBuilder msgMinuscule = new StringBuilder("Hello");
        StringBuilder msgMajuscule = new StringBuilder("HELLO");
        if(nom == null || nom.trim().equals("")){
            msgMinuscule.append(", my friend");
        } else{
            trierNoms(msgMinuscule,msgMajuscule ,nom);
        }
        ajouterPonctuation(msgMinuscule,msgMajuscule);
        return phrase(msgMinuscule, msgMajuscule);
    }

    private static String phrase(StringBuilder msgMinuscule, StringBuilder msgMajuscule) {
        if (msgMinuscule.toString().equals("Hello.") ){
            return msgMajuscule.toString();
        } else if (msgMajuscule.toString().equals("HELLO !")) {
            return msgMinuscule.toString();
        }else{
            return msgMinuscule + " AND " + msgMajuscule;
        }
    }


    private static void ajouterNoms(StringBuilder msg , String nom){

            msg.append(", ");
            msg.append(nomMajuscule(nom));
    }



    private static String nomMajuscule(String nom){
        nom = nom.trim();
        return  nom.substring(0, 1).toUpperCase() + nom.substring(1) ;
    }

    private static void ajouterPonctuation(StringBuilder msgMinuscule, StringBuilder msgMajuscule) {
        msgMinuscule.append(".");
        msgMajuscule.append(" !");
    }

    private static void trierNoms(StringBuilder msgMinuscule, StringBuilder msgMajuscule, String chainedenom) {
        String[] noms = chainedenom.split(",");
        String[] nomMaj = new String[10];
        String[] nomMin = new String[10];
        int nbMaj = 0;
        int nbMin = 0;
        for (String nom : noms) {
            if (nom.toUpperCase().equals(nom)) {
                nomMaj[nbMaj] = nom;
                nbMaj++;
            } else {
                nomMin[nbMin] = nom;
                nbMin++;
            }
        }
        concatenerNoms(msgMajuscule, nomMaj, nbMaj);
        concatenerNoms(msgMinuscule, nomMin, nbMin);
    }

    private static void concatenerNoms (StringBuilder msg , String[]noms ,int nbNom){
        switch (nbNom) {
            case 1:
                ajouterNoms(msg, noms[0]);
            case 0:
                break;
            default:
                concatenerPlusieurNoms(msg, noms, nbNom);
                break;
        }
    }

    private static void concatenerPlusieurNoms(StringBuilder msg, String[] noms, int nbNom) {
        for (int i = 0; i< nbNom -1; i++){
            ajouterNoms(msg, noms[i]);
        }
        if (noms[nbNom -1].toUpperCase().equals(noms[nbNom -1])){
            msg.append(" AND ");
        }else {
            msg.append(" and ");
        }
        msg.append(nomMajuscule(noms[nbNom - 1]));
    }
}


