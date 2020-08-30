package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//herdando o construtor da classe pai
public class LoginPage extends BasePage{


    public LoginPage(WebDriver navegador) {
        super(navegador);
    }

//acessando o primeiro "Sign in" antes de fazer o login
// método que retorna a página FormPage após clicar em Sign in
// No capitulo 24 Objeto da página (Parte 2) Julio menciona que o metodo pode ser escrito em Português
// e trocou para clicarSignIn
    public LoginFormPage clicarSignIn(){
        navegador.findElement(By.linkText("Sign in")).click();

        //passando o navegador para a outra page
        // após o clique retorna a página LoginFormPage
        return new LoginFormPage(navegador);
    }
}
