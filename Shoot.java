public class Shoot{

    int size;
    static String shootLook;
    Square[] shootSquares;

    public int getSize(){
        return size;
    }

    public Shoot(int size, String shootLook){
        this.size = size;
        this.shootSquares = new Square[size];
        Shoot.shootLook = shootLook;
        fillShootSquares();
    }
    
    public void fillShootSquares(){
        for (int i = 0; i < shootSquares.length; i++){
        shootSquares[i] = new Square();
        shootSquares[i].look = shootLook;
        }
    }
    
}