package welcome;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Trim;

public class Welcome {

    public static String welcome(String nom) {;
        StringBuilder msg1 = new StringBuilder("Hello");
        StringBuilder msg2 = new StringBuilder("HELLO");
        if(nom == null || nom.trim().equals("")){
            msg1.append(", my friend");
        }
        else{
            trouveNoms(msg1,msg2 ,nom);
        }
        if (msg1.length() <= 5 ){
            return msg2.toString();
        } else if (msg2.length() <= 7 ) {
            return msg1.toString();
        }else{
            return msg1.toString() + ".AND " + msg2.toString();
        }
    }

    private static void ajouterNoms(StringBuilder msg1 , String nom){
            msg1.append(", ");
            msg1.append(nom.substring(0, 1).toUpperCase()).append(nom.substring(1));
    }
    private static void trouveNoms(StringBuilder msg1 ,StringBuilder msg2, String chainedenom ){
        String[] noms = chainedenom.split(",");
        for(int i = 0; i < noms.length ;i++){
            if (noms[i].toUpperCase().equals(noms[i])) {
                ajouterNoms(msg2, noms[i]);
            } else {
                ajouterNoms(msg1,noms[i]);
            }
        }
        msg2.append(" !");
    }
}
