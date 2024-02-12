package design.pattern.facade.facade1;

public class Row {
    private String name;
    private String birthday;
    private String email;

    public Row(String nanme, String birthday, String email) {
        this.name = nanme;
        this.birthday = birthday;
        this.email = email;
    }

    public String getNanme() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getEmail() {
        return email;
    }
}
