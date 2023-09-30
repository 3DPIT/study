package design.pattern.facade.facade1;

public class Message {
    private Row row;

    public Message(Row row) {
        this.row = row;
    }
    public String makeName(){
        return "Name : \"" + row.getNanme() + "\"";
    }
    public String makeBirthday(){
        return "Birthday" + row.getBirthday();
    }

    public String makeEmail() {
        return "Email" + row.getEmail();
    }
}
