package IBS.CandyBoxInterface;

import IBS.Candy.Candy;

public interface CandyBoxable {

    public void removeCandy(Candy candy);

    public void addCandy(Candy candy);

    public void showBoxWeight();

    public void showBoxPrice();

    public void showAllBoxCandies();

}
