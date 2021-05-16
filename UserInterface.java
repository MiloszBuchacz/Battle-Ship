import java.util.Scanner;

public class UserInterface {
    Scanner sc = new Scanner(System.in);
    
    public String getStrInput(String message) {
        System.out.println(message);
        return sc.next();
    }

    public int getIntInput(String message) {
        System.out.println(message);
        return sc.nextInt();
    }
}