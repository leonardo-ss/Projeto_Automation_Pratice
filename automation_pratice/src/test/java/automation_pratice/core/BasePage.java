package automation_pratice.core;

import static automation_pratice.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
    
    /********** Link **********/
    public void clicarLink(String textoLink){
        getDriver().findElement(By.linkText(textoLink)).click();
    }

    /****** Text Field *******/
    public void escrever(By by, String texto){
        getDriver().findElement(by).clear();
        getDriver().findElement(by).sendKeys(texto);
    }
    public void escrever(String id_campo, String texto){
        getDriver().findElement(By.id(id_campo)).clear();
        getDriver().findElement(By.id(id_campo)).sendKeys(texto);
    }

    /******* Botão ******/

    public void clicarBotao(By by){
        getDriver().findElement(by).click();
    }
    public void clicarBotao(String id){
        getDriver().findElement(By.id(id)).click();
    }

    /******* texto ******/

    public String obterTexto(By by){
        return getDriver().findElement(by).getText();
    } 

    public String obterTexto(String id){
        return getDriver().findElement(By.id(id)).getText();
    } 

    public String obterValor(String id){
        return getDriver().findElement(By.id(id)).getAttribute("value");
    }

    /******* radio *******/

    public void clicarRadio(By by){
        getDriver().findElement(by).click();
    }

    public void clicarRadio(String id){
        getDriver().findElement(By.id(id)).click();
    }

    /******* Combo ******/

    public void selecionarComboValue(String id_campo, String valor){
        WebElement elemento = getDriver().findElement(By.id(id_campo));
        Select combo = new Select(elemento);
        combo.selectByValue(valor);
    }

    public void selecionarComboVisibleText(String id_campo, String valor){
        WebElement elemento = getDriver().findElement(By.id(id_campo));
        Select combo = new Select(elemento);
        combo.selectByVisibleText(valor);
    }
}
