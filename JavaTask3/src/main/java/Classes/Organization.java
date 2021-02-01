package Classes;

import java.util.ArrayList;
import java.util.List;

public class Organization {
    public String name;
    public String address;
    public long phoneNumber;
    public long inn;
    public long ogrn;
    public String foundationDate;
    public List<Securities> securities = new ArrayList<>();


    @Override
    public String toString() {
        return "[name=\"" + name + "\", address=\"" + address + "\", phoneNumber=\""
                + phoneNumber + "\", inn=\"" + inn + "\", ogrn=\"" + ogrn + "\", foundationDate=\"" +
                foundationDate + "\", securities=\"" + securities + "\"]";
    }
}
