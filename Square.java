public class Square {
    public String look = "~";
	public Square[] shootSquares;
    static int stan = 0;

    public String getLook() {
        return look;
    }

    public static String getDefaultLook() {
        return "~";
    }
    public static String GetShootedLook(){
        return "o";
    }
    
    public void setLook(String look) {
        this.look = look;
    }

}
    