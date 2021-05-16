public class SinglePlayer {
    private String[] ships = { "battleship", "cruiser", "submarine", "destroyer", "carrier" };
    private Ship[] shipsObj = {new Ship(4, "B"), new Ship(3, "C"), new Ship(3, "S"), new Ship(2, "D"), new Ship(5, "Y")};
    
    public void singlePlayerGame() {
        Ocean ocean = new Ocean(15, 15);
        Ocean oceanEnemy = new Ocean(15, 15);
        oceanEnemy.fillOcean();
        for (int i = 0; i < ships.length; i++) {
            System.out.println("Give your coordinates for " + ships[i] + " :\n");
            oceanEnemy.placeShip2(shipsObj[i]);
        }
        System.out.println("Your board:");
        ocean.fillOcean();
        ocean.placeShip(new Ship(3, "&"));
        ocean.placeShip(new Ship(4, "&"));
        ocean.placeShip(new Ship(3, "&"));
        ocean.placeShip(new Ship(2, "&"));
        ocean.placeShip(new Ship(5, "&"));
        System.out.println("Computer board:");
        while (true){
            System.out.println("Score: " + ocean.score); 
            ocean.printOcean();
            ocean.placeShoot();
            System.out.println("Score enemy: " + oceanEnemy.score2); 
            oceanEnemy.printOcean();
            oceanEnemy.placeRandomShoot();
            if (ocean.score >= 17 ) {
                System.out.println("You won!!!");
                break;
            }
            if (oceanEnemy.score2 >= 17) {
                System.out.println("Computer won!!!");
                break;
            }
        }
    }
}
