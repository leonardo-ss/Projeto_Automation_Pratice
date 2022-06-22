package automation_pratice;

import static automation_pratice.core.DriverFactory.getDriver;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation_pratice.core.BaseTest;
import automation_pratice.core.DriverFactory;
import automation_pratice.page.LoginPage;

public class LoginTeste extends BaseTest {
    
    LoginPage loginPage = new LoginPage();

    DriverFactory driver = new DriverFactory();
    

    @Test
    public void loginEmailInvalido(){
        loginPage.acessarTelaCadastro();
        loginPage.setEmail("teste");
        loginPage.clicarBotaoCriar();
        
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='create_account_error']/ol/li")));
        Assert.assertEquals("Invalid email address.",loginPage.obterErro());
    }

    @Test
    public void cadastroSemPreencher(){
        loginPage.acessarTelaCadastro();
        loginPage.setEmail("leo@teste.com");
        loginPage.clicarBotaoCriar();

        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submitAccount")));

        loginPage.clicarBotaoRegistrar();

        List<String> erros = loginPage.obterErros();
        Assert.assertEquals(8, erros.size());
    }

}
