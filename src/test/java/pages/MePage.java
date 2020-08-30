package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MePage extends BasePage{

    //herdando a classe pai BasePage
    public MePage(WebDriver navegador) {
        super(navegador);
    }


    public MePage clicarMoreDataAboutYou(){
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

        return this;
    }

    public AddContactPage clicarBotaoAddMoreDataAboutYou(){
        navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

        //retorna o navegador para a page de adicionar contato
        return new AddContactPage(navegador);
    }
}
