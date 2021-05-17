package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import service.util.Callback;

import static org.junit.jupiter.api.Assertions.*;

class LoginTest {


    @InjectMocks
    private Login login;

    @Mock
    private Webservice webservice;

    @Captor
    private ArgumentCaptor<Callback> callbackArgumentCaptor;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        System.out.println("@BeforeEach -> setUp()");
    }

    @Test
    public void doLoginTest() {
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                String user = (String) invocationOnMock.getArguments()[0];
                String pass = (String) invocationOnMock.getArguments()[1];
                Callback callback = (Callback) invocationOnMock.getArguments()[2];
                callback.onSuccess("OK");
                return null;
            }
        }).when(webservice).login(ArgumentMatchers.anyString(),ArgumentMatchers.anyString(), ArgumentMatchers.any(Callback.class));

        login.doLogin();
        assertTrue(login.isLogin());
        BDDMockito.verify(webservice, BDDMockito.times(1)).login(ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.any(Callback.class));
    }

    @Test
    public void doLoginErrorTest() {
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                String user = (String) invocationOnMock.getArguments()[0];
                String pass = (String) invocationOnMock.getArguments()[1];
                Callback callback = (Callback) invocationOnMock.getArguments()[2];
                callback.onFail("Error");
                return null;
            }
        }).when(webservice).login(ArgumentMatchers.anyString(),ArgumentMatchers.anyString(), ArgumentMatchers.any(Callback.class));

        login.doLogin();
        assertFalse(login.isLogin());
        BDDMockito.verify(webservice, BDDMockito.times(1)).login(ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.any(Callback.class));
    }
}