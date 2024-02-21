package kr.co.black.mockito.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    String name;
    String phoneNumber;

    public User(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}
