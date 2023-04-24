package welcome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WelcomeTest {

    @Test
    void welcomeNom(){
        assertEquals(Welcome.welcome("assane"),"Hello, Assane.");
        assertEquals(Welcome.welcome("noah"),"Hello, Noah.");
        assertEquals(Welcome.welcome("jeremy"),"Hello, Jeremy.");
    }

    @Test
    void WelcomeChaineVide(){
        assertEquals(Welcome.welcome(""),"Hello, my friend.");
        assertEquals(Welcome.welcome(" "),"Hello, my friend.");
        assertEquals(Welcome.welcome(null),"Hello, my friend.");
    }

    @Test
    void pourquoi_tu_Cris(){
        assertEquals(Welcome.welcome("ASSANE"),"HELLO, ASSANE !");
        assertEquals(Welcome.welcome("JEREMY"),"HELLO, JEREMY !");
        assertEquals(Welcome.welcome("NOAH"),"HELLO, NOAH !");
    }

    @Test
    void deux_nom(){
        assertEquals(Welcome.welcome("assane,jeremy"),"Hello, Assane and Jeremy.");
        assertEquals(Welcome.welcome("amy,bob"),"Hello, Amy and Bob.");

    }

    @Test
    void plusieur_nom(){
        assertEquals(Welcome.welcome("amy,bob,jery"),"Hello, Amy, Bob and Jery.");
        assertEquals(Welcome.welcome("assane,jeremy,noah"),"Hello, Assane, Jeremy and Noah.");
        assertEquals(Welcome.welcome("assane,jeremy,noah,jery"),"Hello, Assane, Jeremy, Noah and Jery.");

    }

    @Test
    void cris_pas_cris(){
        assertEquals(Welcome.welcome("amy,BOB,Jerry"),"Hello, Amy and Jerry. AND HELLO, BOB !");
        assertEquals(Welcome.welcome("amy,BOB,JERRY"),"Hello, Amy. AND HELLO, BOB AND JERRY !");
        assertEquals(Welcome.welcome("AMY,BOB,Jerry"),"Hello, Jerry. AND HELLO, AMY AND BOB !");
        assertEquals(Welcome.welcome("AMY,BOB,Jerry,theo"),"Hello, Jerry and Theo. AND HELLO, AMY AND BOB !");
    }

}
