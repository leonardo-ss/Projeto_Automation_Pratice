package automation_pratice.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation_pratice.core.BasePage;
import automation_pratice.core.DriverFactory;

public class LoginPage extends BasePage{

    public void acessarTelaCadastro(){
        clicarLink("Sign in");
    }

    public void setEmail(String email){
        escrever("email_create", email);
    }

    public void clicarBotaoCriar(){
        clicarBotao("SubmitCreate");
    }

    public String obterErro(){
        return obterTexto(By.xpath("//div[@id='create_account_error']/ol/li"));
    }

    public void selecionarMasculino(){
        clicarRadio("id_gender1");
    }

    public void selecionarFeminino(){
        clicarRadio("id_gender2");
    }

    public void setFirstName(String name){
        escrever("customer_firstname", name);
    }

    public void setLastName(String sobrename){
        escrever("customer_lastname", sobrename);
    }

    public void setPassword(String password){
        escrever("passwd", password);
    }


    public void setDiaNasc(String dia){
        selecionarCombo("days", dia);
    }
    public void setMesNasc(String mes){
        selecionarCombo("days", mes);
    }
    public void setAnoNasc(String ano){
        selecionarCombo("days", ano);
    }

    /****** Endereço *******/

    public void setFirstNameAddress(String name){
        escrever("firstname", name);
    }

    public void setLastNameAddress(String sobrename){
        escrever("lastname", sobrename);
    }

    public void setAddress(String texto){
        escrever("address1", texto);
    }

    public void setCity(String city){
        escrever("city", city);
    }

    public void setState(String state){
        selecionarCombo("id_state", state);
    }

    public void setZipCode(String code){
        escrever("postcode", code);
    }

    public void setMobilePhone(String mobile){
        escrever("phone_mobile", mobile);
    }

    /****** Botão Registrar *****/

    public void clicarBotaoRegistrar(){
        clicarBotao("submitAccount");
    }


    public List<String> obterErros(){
        List<WebElement> erros = DriverFactory.getDriver().findElements(By.xpath("//div[@class='alert alert-danger']//li"));
        List<String> retorno = new ArrayList<String>();
        for(WebElement erro: erros){
            retorno.add(erro.getText());
        }
        return retorno;
    }
}
