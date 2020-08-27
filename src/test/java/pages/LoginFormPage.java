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
    //Autor: Adriana Jesus
    //Alterações realizadas baseada na Abordagem estrutural um metodo para cada campo, Ex. DigitarLogin, DigitarSenha, etc...
    //Parada no Capitulo 24 onde Julio explicará sobre a Abordagem funcional no tempo de 6:28


    public LoginFormPage digitarLogin(String login) {
        navegador.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(login);

        //o método retorna a mesma página LoginFormPage, mas com o campo login preenchido
        return this;
    }
    public LoginFormPage digitarSenha(String password){
        navegador.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys(password);
        //o método retonar a mesma página LoginFormPage, mas com o campo Password preenchido
        return this;

    }
    public  SecretaPage clicarSignIn(){
        navegador.findElement(By.linkText("Sign in"));
        return new SecretaPage(navegador);
    }
}
