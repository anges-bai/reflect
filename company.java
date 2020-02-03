public class Company {
    private String cname;
    private String address;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Company{" + "cname='" + cname +
                '\'' + ", address='" + address + '\'' + '}';
    }
}
