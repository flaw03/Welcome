package welcome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WelcomeTest {

    @Test
    void welcomeNom(){
        assertEquals(Welcome.welcome("Assane"),"Hello, Assane");
        assertEquals(Welcome.welcome("Noah"),"Hello, Noah");
        assertEquals(Welcome.welcome("Jeremy"),"Hello, Jeremy");
    }

    @Test
    void WelcomeChaineVide(){
        assertEquals(Welcome.welcome(""),"Hello, my friend");
        assertEquals(Welcome.welcome(" "),"Hello, my friend");
        assertEquals(Welcome.welcome(null),"Hello, my friend");
    }
}
