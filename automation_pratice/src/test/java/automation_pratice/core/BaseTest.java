package automation_pratice.core;

import static automation_pratice.core.DriverFactory.getDriver;
import static automation_pratice.core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Before;

public class BaseTest {
    

    @Before
    public void inicializa(){
        getDriver().get("http://automationpractice.com/index.php");
    }

    @After
    public void finaliza(){
        killDriver();
    }
}
