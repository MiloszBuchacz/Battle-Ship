public class Ship {

    int size;
    static String shipLook;
    Square[] shipSquares;


	public Square[] playerShipSquares;

    public Ship(int size, String shipLook) {
        this.size = size;
        this.shipSquares = new Square[size];
        Ship.shipLook = shipLook;
        fillShipSquares();
    }

    public int getSize() {
        return size;
    }

    public void fillShipSquares() {
        for (int i = 0; i < shipSquares.length; i++) {
            shipSquares[i] = new Square();
            shipSquares[i].look = shipLook;
        }
    }


}
