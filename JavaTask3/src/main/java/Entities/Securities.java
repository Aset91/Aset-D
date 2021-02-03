package Entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Securities {
    private String securityName;
    private String code;
    private LocalDate validTill;
    private String ownerName;

    private static DateTimeFormatter defaultDateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Securities() {

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
                "\", ownerName = \"" + ownerName + "\"";
    }
}
