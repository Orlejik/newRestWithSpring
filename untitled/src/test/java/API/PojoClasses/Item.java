package API.PojoClasses;

public class Item {
    private String plant;
    private String invNumber;
    private String accNumber;
    private String item_name;
    private String item_brand;
    private String item_model;
    private String serialnumber;
    private String location;
    private String hostname;
    private String ip_address;
    private Boolean isDamaged;
    private String user_name;
    private String department;
    private String operator_number;
    private String user_added_item;

    public Item(
                String plant,
                String invNumber,
                String accNumber,
                String item_name,
                String item_brand,
                String item_model,
                String serialnumber,
                String location,
                String hostname,
                String ip_address,
                Boolean isDamaged,
                String user_name,
                String department,
                String operator_number,
                String user_added_item) {
        this.plant = plant;
        this.invNumber = invNumber;
        this.accNumber = accNumber;
        this.item_name = item_name;
        this.item_brand = item_brand;
        this.item_model = item_model;
        this.serialnumber = serialnumber;
        this.location = location;
        this.hostname = hostname;
        this.ip_address = ip_address;
        this.isDamaged = isDamaged;
        this.user_name = user_name;
        this.department = department;
        this.operator_number = operator_number;
        this.user_added_item = user_added_item;
    }

    public String getPlant() {
        return plant;
    }

    public String getInvNumber() {
        return invNumber;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public String getItem_name() {
        return item_name;
    }

    public String getItem_brand() {
        return item_brand;
    }

    public String getItem_model() {
        return item_model;
    }

    public String getSerialnumber() {
        return serialnumber;
    }

    public String getLocation() {
        return location;
    }

    public String getHostname() {
        return hostname;
    }

    public String getIp_address() {
        return ip_address;
    }

    public Boolean getIsDamaged() {
        return isDamaged;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getDepartment() {
        return department;
    }

    public String getOperator_number() {
        return operator_number;
    }

    public String getUser_added_item() {
        return user_added_item;
    }
}
