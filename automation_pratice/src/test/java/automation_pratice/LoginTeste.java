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

    @Test
    public void cadastroCompleto(){
        loginPage.acessarTelaCadastro();
        loginPage.setEmail("leo1@teste.com");
        loginPage.clicarBotaoCriar();

        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id_gender1")));

        loginPage.setMasculino();
        loginPage.setFirstName("Leonardo");
        loginPage.setLastName("Santos");
        loginPage.setPassword("123456");
        loginPage.setDiaNasc("29");
        loginPage.setMesNasc("11");
        loginPage.setAnoNasc("1994");

        Assert.assertEquals("Leonardo",loginPage.obterFirstNameAddress());
        Assert.assertEquals("Santos", loginPage.obterLastNameAddress());
        loginPage.setAddress("Rua Erro 404");
        loginPage.setCity("Teste");
        loginPage.setState("New York");
        loginPage.setZipCode("00000");
        loginPage.setMobilePhone("55 11 979964012");

        loginPage.clicarBotaoRegistrar();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='header_user_info']//span")));

        Assert.assertEquals("Leonardo Santos", loginPage.obterSucesso());
        System.out.println(loginPage.obterSucesso());
    }

}
