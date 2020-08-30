package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//classe pai contrutor de método
public class BasePage {
    protected WebDriver navegador;

    //recebe o parâmetro externo e atribui ao navegador interno
    public BasePage(WebDriver navegador){
        this.navegador = navegador;
    }

    public String capturarTextoToast(){
        return navegador.findElement(By.id("toast-container")).getText();
    }
}
