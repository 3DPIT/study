package kr.co.black.mockito.mockitoMain.product;

public class Product {
    String serial;
    String name;

    public Product(String serial, String name) {
        this.serial = serial;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}
