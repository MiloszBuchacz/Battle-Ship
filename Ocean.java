// Pomimo zmian printuje sie tylko o a nigdy x choć po dupa debagingu wiadomo ze ogarnia dobre warunki

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Ocean {
    UserInterface ui = new UserInterface();
    Random rand = new Random();
    List<Coordinates> shiPos = new ArrayList<>();
    List<Coordinates> shiPos2 = new ArrayList<>();
    static int shootTrue;
    int score = 0;
    int score2 = 0;
    private Square[][] ocean;

    public Ocean(int fieldX, int fieldY) {
        this.ocean = new Square[fieldX][fieldY];
    }

    public Square[][] getOcean() {
        return ocean;
    }

    public Square[][] fillOcean() {
        for (Square[] line : ocean) {
            for (int i = 0; i < 15; i++) {
                line[i] = new Square();
            }
        }
        return ocean;
    }

    public void printOcean() {
        String printedLine = "";
        for (Square[] line : ocean) {
            for (int i = 0; i < line.length; i++) {
                printedLine += line[i].getLook() + "  ";
            }
            System.out.println(printedLine);
            printedLine = "";
        }
    }

    public void placeShip(Ship ship) {
        Square square = new Square();
        boolean[] truthy = new boolean[ship.getSize()];
        int x = (int) (Math.random() * (14 - ship.getSize()) + 0);
        int y = (int) (Math.random() * (14 - ship.getSize()) + 0);
        for (int j = 0; j < truthy.length; j++) {
            if (ocean[x + j][y].getLook() == square.getLook()) {
                truthy[j] = true;
            }
            else {
                truthy[j] = false;
            }
        }
        if (isAllTrue(truthy)) {
            for (int i = 0; i < ship.getSize(); i++) {
                ocean[x + i][y] = ship.shipSquares[i];
                Coordinates c = new Coordinates(x + i, y);
                shiPos.add(c);
            }
        }
        else {
            placeShip(ship);
        }
    }

    public static boolean isAllTrue(boolean[] arr) {
        for (boolean b : arr)
            if (!b)
                return false;
        return true;
    }
   
    
    public void placeShip2(Ship ship) {
        Square square = new Square();
        boolean[] truthy = new boolean[ship.getSize()];
        int x = ui.getIntInput("For x:");
        int y = ui.getIntInput("For y:");
        for (int j = 0; j < truthy.length; j++) {
            if (ocean[x + j][y].getLook() == square.getLook()) {
                truthy[j] = true;
            } else {
                truthy[j] = false;
            }
        }
        if (isAllTrue(truthy)) {
            for (int i = 0; i < ship.getSize(); i++) {
                ocean[x + i][y] = ship.shipSquares[i];
                ocean[x + i][y] = ship.shipSquares[i];
                Coordinates c = new Coordinates(x, y);
                shiPos2.add(c);
            }
        }
        else {
            System.out.println("This place is already taken, choose other");
            placeShip2(ship);
        }
    }


    public void placeShoot(){
        int a = ui.getIntInput("where you want to shoot(x pos)");
        int b = ui.getIntInput("and (y pos)");
        for (int i = 0; i < shiPos.size(); i++) {
            if (shiPos.get(i).x == a && shiPos.get(i).y == b) {
                score++;
                Shoot shoot = new Shoot(1, "x");
                for (int j = 0; j < shoot.getSize(); j++) {
                    ocean[a + j][b] = shoot.shootSquares[j];
                } 
            }
            else if (shiPos.get(i).x != a || shiPos.get(i).y != b) {
                Shoot shoott = new Shoot(1, "o");
                for (int k = 0; k < shoott.getSize(); k++) {
                    ocean[a + k][b] = shoott.shootSquares[k];
                }
            }
        }
    }

    public boolean placeRandomShoot() {
        boolean wasShoot = false;
        int a = rand.nextInt(15);
        int b = rand.nextInt(15);
        if (ocean[a][b].getLook() != Square.getDefaultLook() && ocean[a][b].getLook() != Square.GetShootedLook()) {
            System.out.println("Trafioned");
            score++;
            ocean[a][b].setLook("x");
            wasShoot = true;
        }
        else if(ocean[a][b].getLook() == Square.getDefaultLook()){
            System.out.println("trafilem az w nic");
            ocean[a][b].setLook("o");
        }
        return wasShoot;

        
        // for (int i = 0; i < shiPos2.size(); i++) {
        //     if (shiPos2.get(i).x == a && shiPos2.get(i).y == b) {
        //         score2++;
        //         Shoot shoot = new Shoot(1, "x");
        //         for (int j = 0; j < shoot.getSize(); j++) {
        //             ocean[a + j][b] = shoot.shootSquares[j];
        //         } 
        //     }
        //     else if (shiPos2.get(i).x != a || shiPos2.get(i).y != b) {
        //         Shoot shoott = new Shoot(1, "o");
        //         for (int k = 0; k < shoott.getSize(); k++) {
        //             ocean[a + k][b] = shoott.shootSquares[k];
        //         }
        //     }
        // }
        
    }
}



