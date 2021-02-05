package Directory;

import Directory.entities.*;
import Directory.services.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;


public class Main {
    private static DateTimeFormatter defaultDateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        OrganizationRepository organizationRepository = new OrganizationRepository();
        List<Organization> organizationList = organizationRepository.getOrganizationList();

        printOrganizationsWithFoundationDate(organizationList);

        printAllOverdueSecurities(organizationList);

        printAllOrganizationsAfterUserDate(organizationList);

        printAllSecuritiesByCurrency(organizationList);
    }

    private static void printOrganizationsWithFoundationDate(List<Organization> organizationList) {
        organizationList.forEach(org -> {
            System.out.println(String.join("", "\"", org.getName(), "\" - \"", org.getFoundationDate(), "\""));
        });
        System.out.println();
    }

    private static void printAllOverdueSecurities(List<Organization> organizationList) {
        List<Security> overdueSecurityList = SecurityService.getAllOverdueSecurities(organizationList);

        System.out.println("Ценные бумаги, просроченные на текущий день:");
        overdueSecurityList.forEach(security -> {
            System.out.println(security.toString());
        });

        System.out.println("Общее количество: " + overdueSecurityList.size());
        System.out.println();
    }

    private static void printAllOrganizationsAfterUserDate(List<Organization> organizationList) {
        LocalDate userDate = null;

        Scanner in = new Scanner(System.in);
        while (userDate == null) {
            System.out.println("Введите дату в формате «ДД/ММ/ГГГГ»");
            String value = in.nextLine();
            userDate = LocalDate.parse(value, defaultDateFormat);

            if (userDate == null) {
                System.out.println("Введено некорректное значение. Попробуйте еще раз");
            }
        }

       List<Organization> organizations = OrganizationService.getAllOrganizationsCreatedAfterDate(organizationList, userDate);

        if (!organizations.isEmpty()) {
            organizations.forEach(org -> {
                System.out.println(String.join("", "\"", org.getName(), "\" - \"", org.getFoundationDate(), "\""));
            });
        } else {
            System.out.println("Данные не найдены");
        }
        System.out.println();
    }

    private static void printAllSecuritiesByCurrency(List<Organization> organizationList) {
        Currency userCurrency = null;

        Scanner in = new Scanner(System.in);
        while (userCurrency == null) {
            System.out.println("Введите валюту в одном из форматов EU, USD, RU");
            String value = in.nextLine();

            try {
                userCurrency = Currency.valueOf(value);
            } catch (IllegalArgumentException e) {
                System.out.println("Введено некорректное значение. Попробуйте еще раз");
            }
        }

        List<Security> securityList = SecurityService.getAllSecuritiesByCurrency(organizationList, userCurrency);
        if (!securityList.isEmpty()) {
            securityList.forEach(security -> {
                System.out.println(security.toString());
            });
        } else {
            System.out.println("Данные не найдены");
        }
    }
}
