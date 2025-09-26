import org.example.JackieService;
import org.example.Main;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class JackieTest {
    @Test
    public void testJackie() throws FileNotFoundException {
        JackieService service0 = new JackieService();
        
        JackieService service = new JackieService("files/jackie.txt");

        System.out.println("3. feladat: " + service.getLinesLenght()); // 10
    }

    @Test
    public void MainTest() throws IOException {
        Main.main(null);
    }
}
