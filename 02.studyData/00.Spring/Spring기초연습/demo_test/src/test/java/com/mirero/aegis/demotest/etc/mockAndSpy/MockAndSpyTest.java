package com.mirero.aegis.demotest.etc.mockAndSpy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class MockAndSpyTest {

    @Spy
    TestReturnOne testReturnOneSpy;

    @Mock
    TestReturnOne testReturnOneMock;

    @Test
    public void TestReturnMock(){

        Assertions.assertThat(testReturnOneSpy.testMethod()).isEqualTo(1555);

        when(testReturnOneMock.testMethod()).thenReturn(1000);
        given(testReturnOneMock.testMethod()).willReturn(10003);

        Assertions.assertThat(testReturnOneMock.testMethod()).isEqualTo(10003);
    }

    public class TestReturnOne{
        int id;

        public int testMethod(){
            return 1555;
        }
    }
}
