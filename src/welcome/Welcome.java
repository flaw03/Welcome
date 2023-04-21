package welcome;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Trim;

public class Welcome {

    public static String welcome(String nom) {;
        StringBuilder msg = new StringBuilder("Hello, ");
        if(nom == null || nom.trim().equals("")){
            msg.append("my friend");
        }
        else{
            msg.append(nom.substring(0, 1).toUpperCase()).append(nom.substring(1));
            if (nom.toUpperCase().equals(nom)){
                msg.append(" !");
                return msg.toString().toUpperCase();
            }
        }
        return msg.toString();
    }
}
