package IBS.CandyBox;

import IBS.Candy.Candy;
import IBS.CandyBoxInterface.CandyBoxable;

import java.util.*;

public class CandyBox implements CandyBoxable {
    private List<Candy> candyList = new ArrayList<>();


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
        double boxWeigth = 0;
        for (Candy c : candyList) {
            boxWeigth += c.getWeight();
        }
        System.out.println("Вес коробки: " + boxWeigth);
    }

    @Override
    public void showBoxPrice() {
         double boxPrice = 0;
        for (Candy c : candyList) {
            boxPrice += c.getPrice();
        }
        System.out.println("Стоимость коробки: " + boxPrice);
    }

    @Override
    public void showAllBoxCandies() {
        System.out.println("В коробке: ");
        for (Candy c : candyList) {
            System.out.println(c.getName() + ", " + c.getWeight() + ", " + c.getPrice() + ", " + c.getShape());
        }
    }


}

