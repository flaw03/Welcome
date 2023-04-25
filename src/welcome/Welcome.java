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


    private static void ajouterNoms(StringBuilder msg , String nom , int i , String separateur){
        msg.append(separateur);
        msg.append(nomMajuscule(nom));
        if (i > 1) {
            msg.append(" (x").append(i).append(")");
        }
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

        int[] tabDoubonMaj = new int[10];
        int[] tabDoubonMin = new int[10];

        int[] nbMaj = new int[]{0};
        int[] nbMin = new int[]{0};

        for (String nom : noms) {
            if (nom.toUpperCase().equals(nom)) {
                ajouterTab(nom,nomMaj,tabDoubonMaj,nbMaj);
            } else {
                ajouterTab(nom,nomMin,tabDoubonMin,nbMin);
            }
        }
        concatenerNoms(msgMajuscule, nomMaj,tabDoubonMaj, nbMaj);
        concatenerNoms(msgMinuscule, nomMin,tabDoubonMin, nbMin);
    }

    private static void ajouterTab(String nom, String[] nomMaj, int[] tabDoubon, int[] nb) {
        boolean in = false;
        for (int i = 0 ; i < nb[0] ; i++){
            if (nomMaj[i].equals(nom)) {
                tabDoubon[i] ++;
                in = true;
                break;
            }
        }
        if (!in) {
            nomMaj[nb[0]] = nom;
            tabDoubon[nb[0]] = 1;
            nb[0]++;
        }
    }


    private static void concatenerNoms (StringBuilder msg , String[]noms,int[] tab ,int[] nbNom){
        switch (nbNom[0]) {
            case 1:
                ajouterNoms(msg, noms[0],tab[0],", ");
            case 0:
                break;
            default:
                concatenerPlusieurNoms(msg, noms, tab,nbNom);
                break;
        }
    }

    private static void concatenerPlusieurNoms(StringBuilder msg, String[] noms,int[] tab, int[] nbNom) {
        int i = 0;
        String and;
        for (; i< nbNom[0] -1; i++){
            ajouterNoms(msg, noms[i],tab[i],", ");
        }
        if (noms[i].toUpperCase().equals(noms[i])){
            and = " AND ";
        }else {
            and =" and ";
        }
        ajouterNoms(msg,noms[i],tab[i],and);
    }
}


