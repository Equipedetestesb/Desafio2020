package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPage extends BasePage{


    public LoginFormPage(WebDriver navegador) {
        super(navegador);
    }

    public LoginFormPage digitarLogin(String login){
        navegador.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(login);

        return this;
    }
    // método que recebe o login como parâmetro e passa para o campo login da página
    // Autor: Adriana Jesus
    // Alterações baseadas na Abordagem estrutural um método para cada campo, Ex. DigitarLogin, DigitarSenha, etc ...
    // Parada no Capitulo 24 onde Julio explicará sobre a Abordagem funcional no tempo de 6:28

    public LoginFormPage digitarSenha(String password){
        navegador.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys(password);

        // o método retonar a mesma página LoginFormPage, mas com o campo Senha preenchida
        return this;
    }

    public SecretaPage clicarSignIn(){
        navegador.findElement(By.linkText("SIGN IN")).click();

        // o método retorna a mesma página LoginFormPage, mas com o campo login preenchido
        return new SecretaPage(navegador);
    }

    public SecretaPage fazerLogin(String login, String senha){
        //os métodos estruturais são usados aqui atrvés deste método funcinonal
        digitarLogin(login);
        digitarSenha(senha);
        clicarSignIn();

        //retorna para a página secreta, o navegador que permite o encadeamento entre as pages
        return new SecretaPage(navegador);
    }
}
