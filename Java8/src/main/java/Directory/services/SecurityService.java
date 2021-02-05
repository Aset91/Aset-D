package Directory.services;

import Directory.entities.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class SecurityService {
    private static final List<String> SUPPORTED_CURRENCY = Arrays.asList("EU", "USD", "RU");

    public static List<Security> getAllOverdueSecurities(List<Organization> organizationList) {
        List<Security> overdueSecurityList = new ArrayList<>();

        organizationList.forEach(org -> {
            overdueSecurityList.addAll(
                    org.getSecurities().stream()
                            .filter(security -> security.getValidTillAsDate().isBefore(LocalDate.now()))
                            .collect(Collectors.toList()));
        });
        return overdueSecurityList;
    }

    public static List<Security> getAllSecuritiesByCurrency(List<Organization> organizationList, Currency currency) {
        List<Security> securityList = new ArrayList<>();

        organizationList.forEach(org -> {
            securityList.addAll(
                    org.getSecurities().stream()
                            .filter(security -> security.getCode().startsWith(currency.getTitle()))
                            .collect(Collectors.toList()));
        });
        return securityList;
    }
}
