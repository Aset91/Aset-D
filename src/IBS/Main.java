package IBS;

import IBS.Candy.Candy;
import java.util.ArrayList;
import IBS.Candy.Chocolate;
import IBS.Candy.Marmalade;
import IBS.Candy.Marzipan;
import IBS.CandyBox.CandyBox;

public class Main {
    public static void main(String[] args) {
        CandyBox box = new CandyBox();
        Chocolate c = new Chocolate();
        box.addCandy(c);
        Marmalade m = new Marmalade();
        Marzipan mar = new Marzipan();
        Chocolate c1 = new Chocolate();
        box.addCandy(m);
        box.addCandy(mar);
        box.addCandy(c1);
        box.showAllBoxCandies();
        box.removeCandy(c1);
        box.removeCandy(m);
        box.showAllBoxCandies();
        box.showBoxPrice();
        box.showBoxWeight();
    }
}
