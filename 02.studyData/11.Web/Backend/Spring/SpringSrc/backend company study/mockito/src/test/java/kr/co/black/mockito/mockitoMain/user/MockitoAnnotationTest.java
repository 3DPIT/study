package kr.co.black.mockito.mockitoMain.user;

import kr.co.black.mockito.mockitoMain.user.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MockitoAnnotationTest {

    @Mock
    UserService userService;

    @Test
    void testReferenceType(){
        Assertions.assertNull(userService.getUser());
    }

    @Test
    void testPrimitiveType(){
        Assertions.assertEquals(0, userService.getLoginErrNum());
    }
}
