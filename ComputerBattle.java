import java.util.concurrent.TimeUnit;

//Tutaj nie pojawiaja sie w ogole strzaly i wszystko leci za szybko

public class ComputerBattle {
    private Ship[] shipsObj = {new Ship(4, "B"), new Ship(3, "C"), new Ship(3, "S"), new Ship(2, "D"), new Ship(5, "Y")};
    private Ship[] shipsObj2 = {new Ship(4, "B"), new Ship(3, "C"), new Ship(3, "S"), new Ship(2, "D"), new Ship(5, "Y")};

    public void computerBattle() {
        Ocean ocean = new Ocean(15, 15);
        Ocean oceanEnemy = new Ocean(15, 15);
        ocean.fillOcean();
        for (int i =0; i < shipsObj.length; i++) {
            ocean.placeShip(shipsObj[i]);
        }
        oceanEnemy.fillOcean();
        for (int i =0; i < shipsObj2.length; i++) {
            oceanEnemy.placeShip(shipsObj2[i]);
        }
        
        System.out.println("Computer 1 board:");
        while (true){
            System.out.println("Score: " + ocean.score); 
            ocean.printOcean();
            ocean.placeRandomShoot();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }            

            System.out.println("Score enemy: " + oceanEnemy.score); 
            oceanEnemy.printOcean();
            oceanEnemy.placeRandomShoot();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (ocean.score > 1 ) {
                System.out.println("Computer 1 won!!!");
                break;
            }
            if (oceanEnemy.score > 1) {
                System.out.println("Computer 2 won!!!");
                break;
            }
        }
    }
}