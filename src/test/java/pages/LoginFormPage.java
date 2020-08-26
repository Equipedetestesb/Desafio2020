package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPage {
    private WebDriver navegador;

    //método construtor
    public LoginFormPage(WebDriver navegador){
        this.navegador = navegador;
    }

    //método que recebe o login como parâmetro e passa para o campo login da página
    public LoginFormPage typeLogin(String login) {
        navegador.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys("julio0001");

        //o método retorna a mesma página LoginFormPage, mas com o campo login preenchido
        return this;
    }
}
