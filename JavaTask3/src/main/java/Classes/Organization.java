package Classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Organization {
    private String name;
    private String address;
    private long phoneNumber;
    private long inn;
    private long ogrn;
    // Почему в json часть годов была полной, а часть сокращенной?
    private LocalDate foundationDate;
    private List<Securities> securities = new ArrayList<>();

    // Дефолтный формат даты, для того чтобы парсить их из файла
    private static DateTimeFormatter defaultDateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public String toString() {
        return "[name=\"" + name + "\", address=\"" + address + "\", phoneNumber=\""
                + phoneNumber + "\", inn=\"" + inn + "\", ogrn=\"" + ogrn + "\", foundationDate=\"" +
                foundationDate + "\", securities=\"" + securities + "\"]";
    }

    // Десериализация в Jackson использует сеттеры (если они есть) для того чтобы ставить значения в поля
    // Соответственно внутри каждого сеттера можно определить свою логику парсинга
    public void setFoundationDate(String date) {
        this.foundationDate = LocalDate.parse(date, defaultDateFormat);
    }

    public String getFoundationDate() {
        return foundationDate.format(defaultDateFormat);
    }

    public LocalDate getFoundationDateAsDate() {
        return foundationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getInn() {
        return inn;
    }

    public void setInn(long inn) {
        this.inn = inn;
    }

    public long getOgrn() {
        return ogrn;
    }

    public void setOgrn(long ogrn) {
        this.ogrn = ogrn;
    }

    public void setFoundationDate(LocalDate foundationDate) {
        this.foundationDate = foundationDate;
    }

    public List<Securities> getSecurities() {
        return securities;
    }

    public void setSecurities(List<Securities> securities) {
        this.securities = securities;
    }
}
