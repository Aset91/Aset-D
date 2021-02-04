import Classes.Organization;
import Classes.Securities;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException, FileNotFoundException {
        File file = new File("src\\main\\java\\JSONFile\\Organizations.json");

        ObjectMapper mapper = new ObjectMapper();
        Organization[] organizations = mapper.readValue(file, Organization[].class);

        Stream.of(organizations).forEach(org -> {
                    System.out.println(String.join("", "\"", org.getName(), "\" - \"", org.getFoundationDate(), "\""));
                }
        );

        List<Organization> orgs = new ArrayList<>();
        orgs.addAll(Arrays.asList(organizations));
        System.out.println(orgs);

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter mainDateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate today = LocalDate.now();
        String todayDate = today.toString();

        LocalDate dateTime = LocalDate.parse(todayDate, df);
        System.out.println("Test: " + dateTime.toString());

        System.out.println("Test: " + getDatesList(orgs));

        // Почему стрим берется из массива если до этого был сделан Лист?
        /*Stream.of(organizations)
                .flatMap(c -> c.securities.stream())
                .filter(b -> formatStringToLocalDate(getDatesList(orgs), mainDateTimeFormatter).isBefore(LocalDate.now()))
                .collect(Collectors.toList())
                .forEach(System.out::println);*/

        // Правильный фильтр по датам
        List<Securities> outdatedSecurities = new ArrayList<>();
        orgs.forEach(org -> {
            outdatedSecurities.addAll(
                    org.getSecurities().stream()
                        .filter(security -> security.getValidTillAsDate().isBefore(LocalDate.now()))
                        .collect(Collectors.toList()));
        });

        System.out.println("Просроченные ценные бумаги:");
        System.out.println(outdatedSecurities);
    }

    public static LocalDate formatStringToLocalDate(List<String> date, DateTimeFormatter dateFormatter) {
        LocalDate localDate = null;
        for (String dateString: date) {
            LocalDate.parse(dateString, dateFormatter);
        }
        return localDate;
    }

    public static List<String> getDatesList(List<Organization> orgClass) {

        List<String> listDates = new ArrayList<>();
        String date;
        for (Organization o : orgClass) {
            for (Securities s : o.getSecurities()) {
                 date = s.getValidTill();
                 listDates.add(date);
            }
        }
        return listDates;
    }
}




