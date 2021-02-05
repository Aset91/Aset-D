package Directory.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Security {
    private String securityName;
    private String code;
    private LocalDate validTill;
    private String ownerName;

    // Копипаста из Organization, но на случай если форматы разные
    private static DateTimeFormatter defaultDateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Security() {

    }

    public String getSecurityName() {
        return securityName;
    }

    public void setSecurityName(String securityName) {
        this.securityName = securityName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValidTill() {
        return validTill.format(defaultDateFormat);
    }

    public LocalDate getValidTillAsDate() {
        return validTill;
    }

    public void setValidTill(String validTill) {
        this.validTill = LocalDate.parse(validTill, defaultDateFormat);
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        return "securityName = \"" + securityName +
                "\", code = \"" + code +
                "\", validTill = \"" + validTill +
                "\", ownerName = \"" + ownerName+ "\"";
    }
}
