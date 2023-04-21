package welcome;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Trim;

public class Welcome {

    public static String welcome(String nom) {;
        StringBuilder msg = new StringBuilder("Hello, ");
        if(nom == null || nom.trim().equals("")){
            msg.append("my friend");
        }
        else{
            msg.append(nom);
        }
        return msg.toString();
    }
}
