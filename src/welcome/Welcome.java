package welcome;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Trim;

public class Welcome {

    public static String welcome(String nom) {;
        StringBuilder msg = new StringBuilder("Hello");
        if(nom == null || nom.trim().equals("")){
            msg.append(", my friend");
        }
        else{
            trouveNoms(msg ,nom);
            if (nom.toUpperCase().equals(nom)){
                msg.append(" !");
                return msg.toString().toUpperCase();
            }
        }
        return msg.toString();
    }

    private static void ajouterNoms(StringBuilder msg , String nom){
            msg.append(", ");
            msg.append(nom.substring(0, 1).toUpperCase()).append(nom.substring(1));
    }
    private static void trouveNoms(StringBuilder msg, String chainedenom ){
        String[] noms = chainedenom.split(",");
        ajouterNoms(msg, noms[0]);
        if (noms.length >1){
            ajouterNoms(msg,noms[1]);
        }
    }
}
