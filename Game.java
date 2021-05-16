public class Game {
    UserInterface uf = new UserInterface();

    public void printMenu() {
        System.out.println("\nWelcome!");
        System.out.println("\nThis is MM Battleship Game.\n\nHow do You want to play?\n");
        System.out.println("To play Singleplayer, choose => 1\n");
        System.out.println("To see computer-computer battle, choose => 2\n");
        System.out.println("To play battle with Your friend, choose => 3\n");
    }

    public int gameChoice() {
        int choice = uf.getIntInput("What kind of game do You choose?\n");
        return choice;
    }

    public void startGame() {
        SinglePlayer s = new SinglePlayer();
        ComputerBattle cb = new ComputerBattle();
        FriendBattle fb = new FriendBattle();
        switch (gameChoice()) {
            case 1:
                s.singlePlayerGame();
                break;
            case 2:
                cb.computerBattle();
                break;
            case 3:
                fb.friendBattle();
                break;
        }
    }
}