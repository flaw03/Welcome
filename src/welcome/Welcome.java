package welcome;


public class Welcome {

    public static String welcome(String nom) {
        StringBuilder msgMinuscule = new StringBuilder("Hello");
        StringBuilder msgMajuscule = new StringBuilder("HELLO");
        if(nom == null || nom.trim().equals("")){
            msgMinuscule.append(", my friend");
        } else{
            trouveNoms(msgMinuscule,msgMajuscule ,nom);
        }
        return phrase(msgMinuscule, msgMajuscule);
    }

    private static String phrase(StringBuilder msgMinuscule, StringBuilder msgMajuscule) {
        if (msgMinuscule.length() <= 5 ){
            return msgMajuscule.toString();
        } else if (msgMajuscule.length() <= 7 ) {
            return msgMinuscule.toString();
        }else{
            return msgMinuscule + ". AND " + msgMajuscule;
        }
    }


    private static void ajouterNoms(StringBuilder msg , String nom){
            msg.append(", ");
            msg.append(nom.substring(0, 1).toUpperCase()).append(nom.substring(1));
    }


    private static void trouveNoms(StringBuilder msgMinuscule ,StringBuilder msgMajuscule, String chainedenom ){
        String[] noms = chainedenom.split(",");
        for (String nom : noms) {
            if (nom.toUpperCase().equals(nom)) {
                ajouterNoms(msgMajuscule, nom);
            } else {
                ajouterNoms(msgMinuscule, nom);
            }
        }
        msgMajuscule.append(" !");
    }
}
