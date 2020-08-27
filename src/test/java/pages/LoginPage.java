package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Classe Page Object onde retorna a página Login Page
public class LoginPage {

    private WebDriver navegador;

    //método construtor
    public LoginPage(WebDriver navegador) {
        this.navegador = navegador;
    }

    //método que retorna a página FormPage após o click em SignIn
    //Na capitulo 24 Page object(Parte 2) Julio menciona que o metodo pode ser escrito em Portugeus e trocou para clicarSignIn
    public LoginFormPage clicarSignIn(){
        navegador.findElement(By.linkText("Sign in")).click();

        //após o click retorna a página LoginFormPage
        return new LoginFormPage(navegador);
    }
}
