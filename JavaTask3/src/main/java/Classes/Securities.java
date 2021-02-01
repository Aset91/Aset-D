package Classes;

public class Securities {
    public String securityName;
    public String code;
    public String validTill;
    public String ownerName;

    @Override
    public String toString() {
        return "[securityName = \"" + securityName + "\", code = \"" + code + "\", validTill = \"" + validTill + "\", ownerName = \"" + ownerName+ "\"]";
    }
}
