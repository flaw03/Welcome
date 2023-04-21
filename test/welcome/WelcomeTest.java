package welcome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WelcomeTest {

    @Test
    void welcomeNom(){
        assertEquals(Welcome.welcome("assane"),"Hello, Assane");
        assertEquals(Welcome.welcome("noah"),"Hello, Noah");
        assertEquals(Welcome.welcome("jeremy"),"Hello, Jeremy");
    }

    @Test
    void WelcomeChaineVide(){
        assertEquals(Welcome.welcome(""),"Hello, my friend");
        assertEquals(Welcome.welcome(" "),"Hello, my friend");
        assertEquals(Welcome.welcome(null),"Hello, my friend");
    }

    @Test
    void pourquoi_tu_Cris(){
        assertEquals(Welcome.welcome("ASSANE"),"HELLO, ASSANE !");
        assertEquals(Welcome.welcome("JEREMY"),"HELLO, JEREMY !");
        assertEquals(Welcome.welcome("NOAH"),"HELLO, NOAH !");
    }


}
