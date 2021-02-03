package Services;


import Entities.Currency;
import Entities.Organization;
import Entities.Securities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SecurityService {
    private static final List<String> SUPPORTED_CURRENCY = Arrays.asList("EU", "USD", "RU");

    public static List<Securities> getAllOverdueSecurities(List<Organization> organizationList) {
        List<Securities> overdueSecurityList = new ArrayList<>();

        organizationList.forEach(org -> {
            overdueSecurityList.addAll(
                    org.getSecurities().stream()
                            .filter(security -> security.getValidTillAsDate().isBefore(LocalDate.now()))
                            .collect(Collectors.toList()));
        });
        return overdueSecurityList;
    }

    public static List<Securities> getAllSecuritiesByCurrency(List<Organization> organizationList, Currency currency) {
        List<Securities> securityList = new ArrayList<>();

        organizationList.forEach(org -> {
            securityList.addAll(
                    org.getSecurities().stream()
                            .filter(security -> security.getCode().startsWith(currency.getTitle()))
                            .collect(Collectors.toList()));
        });
        return securityList;
    }
}
