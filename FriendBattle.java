//Tutaj nie pojawiaja sie strzaly

public class FriendBattle {
    private String[] ships = { "battleship", "cruiser", "submarine", "destroyer", "carrier" };
    private Ship[] shipsObj = { new Ship(4, "B"), new Ship(3, "C"), new Ship(3, "S"), new Ship(2, "D"),
            new Ship(5, "Y") };
    private Ship[] shipsObj2 = { new Ship(4, "B"), new Ship(3, "C"), new Ship(3, "S"), new Ship(2, "D"),
            new Ship(5, "Y") };
    UserInterface ui = new UserInterface();
    int player = 1;

    public void friendBattle() {
        Ocean ocean = new Ocean(15, 15);
        Ocean oceanEnemy = new Ocean(15, 15);
        ocean.fillOcean();
        for (int i = 0; i < ships.length; i++) {
            System.out.println("P1 Give your coordinates for " + ships[i] + " :\n");
            ocean.placeShip2(shipsObj[i]);
        }
        System.out.println("Palyer 1 board:");
        oceanEnemy.fillOcean();
        for (int i = 0; i < ships.length; i++) {
            System.out.println("P1 Give your coordinates for " + ships[i] + " :\n");
            oceanEnemy.placeShip2(shipsObj2[i]);
        }
        System.out.println("P2 Your board:");
        System.out.println("Palyer 2 board:");
        while (ocean.score2 < 17 || oceanEnemy.score2 < 17) {
            
            switch (player) {
                case 1:
                    System.out.println("Score player 1: " + ocean.score2);
                    ocean.printOcean();
                    ocean.placeShoot();
                    player++;
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    break;
                case 2:
                    System.out.println("Score player 2: " + oceanEnemy.score2); 
                    oceanEnemy.printOcean();
                    oceanEnemy.placeShoot();
                    player--;
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    break;
            }
            if (ocean.score2 >= 17 ) {
                System.out.println("Player 1 won!!!");
                break;
            }
            if (oceanEnemy.score2 >= 17) {
                System.out.println("Player 2 won!!!");
                break;
            }
        }
    }
}