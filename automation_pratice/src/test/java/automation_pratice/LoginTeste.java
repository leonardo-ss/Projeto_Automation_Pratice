package automation_pratice;

import static automation_pratice.core.DriverFactory.getDriver;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import automation_pratice.core.BaseTest;
import automation_pratice.page.LoginPage;

public class LoginTeste extends BaseTest {
    
    LoginPage loginPage = new LoginPage();

    @Test
    public void loginEmailInvalido(){
        loginPage.acessarTelaCadastro();
        loginPage.setEmail("teste");
        loginPage.clicarBotaoCriar();
        
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals("Invalid email address.",loginPage.obterErro());
    }

    @Test
    public void cadastroCompleto(){
        loginPage.acessarTelaCadastro();
        loginPage.setEmail("leo@teste.com");
        loginPage.clicarBotaoCriar();

        
    }

}
