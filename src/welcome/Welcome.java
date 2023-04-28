package welcome;


public class Welcome {

    private static boolean yodaMaj;
    private static boolean yodaMin;
    private static final String[] nomMaj = new String[10];
    private static final String[] nomMin = new String[10];
    private static StringBuilder msgMinuscule ;
    private static StringBuilder msgMajuscule ;
    private static final int[] tabDoubonMaj = new int[10];
    private static final int[] tabDoubonMin = new int[10];
    private static int nbMaj = 0;
    private static int nbMin = 0;

    public static String welcome(String nom) {
        msgMinuscule = new StringBuilder("Hello");
        msgMajuscule = new StringBuilder("HELLO");
        if(nom == null || nom.trim().equals("")){
            msgMinuscule.append(", my friend.");
        } else{
            trierNoms(nom);
            ajouterPonctuation();
        }
        return phrase(msgMinuscule, msgMajuscule);
    }

    private static String phrase(StringBuilder msgMinuscule, StringBuilder msgMajuscule) {
        if (msgMinuscule.toString().equals("Hello")){
            return msgMajuscule.toString();
        } else if (msgMajuscule.toString().equals("HELLO")) {
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

    private static void ajouterPonctuation() {
        if (nbMin > 0) {
            if (yodaMin){
                msgMinuscule.delete(0,7);
                msgMinuscule.append(", Hello");
            }
            msgMinuscule.append(".");
        }
        if (nbMaj > 0) {
            if (yodaMaj) {
                msgMajuscule.delete(0, 7);
                msgMajuscule.append(", HELLO");
            }
            msgMajuscule.append(" !");
        }
    }

    private static void trierNoms(String chainedenom) {
        String[] noms = chainedenom.split(",");
        nbMaj = 0;
        nbMin = 0;
        yodaMaj = false;
        yodaMin = false;
        for (String nom : noms) {
            if (!nom.trim().equals("")){
                if (nom.toUpperCase().equals(nom)) {
                    nbMaj = ajouterTab(nom,nomMaj,tabDoubonMaj,nbMaj);
                    if (nom.equals("YODA")){
                        yodaMaj= true;
                    }
                } else {
                        nbMin = ajouterTab(nom, nomMin, tabDoubonMin, nbMin);
                        if (nom.equals("yoda")) {
                            yodaMin = true;
                        }
                }
            }
        }
        concatenerNoms(msgMajuscule, nomMaj,tabDoubonMaj, nbMaj);
        concatenerNoms(msgMinuscule, nomMin,tabDoubonMin, nbMin);
    }

    private static int ajouterTab(String nom, String[] nomMaj, int[] tabDoublon, int nb) {
        boolean dejaPresent = false;
        for (int i = 0 ; i < nb ; i++){
            if (nomMaj[i].equals(nom)) {
                tabDoublon[i] ++;
                dejaPresent = true;
                break;
            }
        }
        if (!dejaPresent) {
            nomMaj[nb] = nom;
            tabDoublon[nb] = 1;
            nb++;
        }
        return nb;
    }


    private static void concatenerNoms (StringBuilder msg , String[]noms,int[] tab ,int nbNom){
        switch (nbNom) {
            case 1:
                ajouterNoms(msg, noms[0],tab[0],", ");
            case 0:
                break;
            default:
                concatenerPlusieurNoms(msg, noms, tab,nbNom);
                break;
        }
    }

    private static void concatenerPlusieurNoms(StringBuilder msg, String[] noms,int[] tab, int nbNom) {
        int i = 0;
        String and;
        for (; i< nbNom -1; i++){
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


