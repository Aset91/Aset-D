package IBS;

import java.util.*;

public class CandyBox implements CandyBoxable {
    private static List<Candy> candyList = new ArrayList<>();
    private double boxWeigth;
    private double boxPrice;


    @Override
    public void removeCandy(Candy candy) {
        candyList.remove(candy);
    }

    @Override
    public void addCandy(Candy candy) {
        candyList.add(candy);
    }

    @Override
    public void showBoxWeight() {
        for (Candy c : candyList) {
            boxWeigth += c.getWeight();
        }
        System.out.println(boxWeigth);
    }

    @Override
    public void showBoxPrice() {
        for (Candy c : candyList) {
            boxPrice += c.getPrice();
        }
        System.out.println(boxPrice);
    }

    @Override
    public void showAllBoxCandies() {
        for (Candy c : candyList) {
            System.out.println(c.getName() + ", " + c.getWeight() + ", " + c.getPrice() + ", " + c.getShape());
        }
    }

    public static void main(String[] args) {

        CandyBox candyBox = new CandyBox();
        Chocolate x = new Chocolate("Choco", 0.4, 0.95, "round");
        candyBox.addCandy(x);
        Marmalade mar = new Marmalade("Hasbro", 0.7, 1.8, "bear");
        candyBox.addCandy(mar);
        Marzipan m = new Marzipan("Merci", 0.9, 9.7, "square");
        candyBox.addCandy(m);
        candyBox.showAllBoxCandies();
        candyBox.removeCandy(m);
        candyBox.showBoxWeight();
        candyBox.showBoxPrice();
        candyBox.showAllBoxCandies();

    }

}

