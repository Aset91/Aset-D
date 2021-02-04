package Classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Securities {
    public String securityName;
    public String code;
    public LocalDate validTill;
    public String ownerName;

    // Копипаста из Organization, но на случай если форматы разные
    private static DateTimeFormatter defaultDateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public String toString() {
        return "[securityName = \"" + securityName + "\", code = \"" + code + "\", validTill = \"" + validTill + "\", ownerName = \"" + ownerName+ "\"]";
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

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
