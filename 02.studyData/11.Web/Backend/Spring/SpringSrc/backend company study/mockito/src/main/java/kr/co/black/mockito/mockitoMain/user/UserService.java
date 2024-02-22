package kr.co.black.mockito.mockitoMain.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User getUser(){
      return new User("black","0000");
    }

    public int getLoginErrNum() {
     return 1;
    }
}
