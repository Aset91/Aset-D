package Services;

import Entities.Organization;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class OrganizationService {

    public static List<Organization> getAllOrganizationsCreatedAfterDate(List<Organization> organizationList, LocalDate date) {
        List<Organization> organizations = organizationList.stream()
                .filter(organization -> organization.getFoundationDateAsDate().isAfter(date))
                .collect(Collectors.toList());

        return organizations;
    }
}
