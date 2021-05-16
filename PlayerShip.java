public class PlayerShip {
    
    int size;
    String shipLook;
    int initialPosX;
    int initialPosY;
    Square[] playerShipSquares;
    public static PlayerShip battleship = new PlayerShip(4, "b");
    public static PlayerShip cruiser = new PlayerShip(3, "c");
    public static PlayerShip submarine = new PlayerShip(3, "s");
    public static PlayerShip destroyer = new PlayerShip(2, "d");
    public static PlayerShip carrier = new PlayerShip(5, "x");

    public PlayerShip(int size, String shipLook) {
        this.size = size;
        this.playerShipSquares = new Square[size];
        this.shipLook = shipLook;
        fillShipSquares();
    }


    public String getLook() {
        return shipLook;
    }
    public int getInitialPosX() {
        return initialPosX;
    }

    public int getInitialPosY() {
        return initialPosY;
    }

    public int getSize() {
        return size;
    }

    public void fillShipSquares() {
        for (int i = 0; i < playerShipSquares.length; i++) {
            playerShipSquares[i] = new Square();
            playerShipSquares[i].look = shipLook;
        }
    }
}