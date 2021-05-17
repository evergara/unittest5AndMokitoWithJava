package service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import service.util.Callback;

import static org.junit.jupiter.api.Assertions.*;

class WebserviceTest {

    @InjectMocks
    private Webservice webservice;
    @Mock
    private Callback callback;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        System.out.println("@BeforeEach -> setUp()");
    }

    @AfterEach
    public void tearDown(){
        webservice = null;
        System.out.println("@AfterEach -> tearDown()");
    }

    @Test
    public void checkLoginTest(){
        assertTrue(webservice.checkLogin("admin", "123"));
    }

    @Test
    public void checkLoginErrorTest(){
        assertFalse(webservice.checkLogin("administrator", "123"));
    }

    @Test
    public void loginTest(){
        webservice.login("admin", "123", callback);
        BDDMockito.verify(callback).onSuccess("Usuario Correcto");
    }

    @Test
    public void loginErrorTest(){
        webservice.login("administrator", "123", callback);
        BDDMockito.verify(callback).onFail("Usuario Incorrecto");
    }


}