package tests;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.junit.Before;
import pages.LoginPage;
import suporte.Web;

//Classe utilizada como teste dos pages objects para não alterar os primeiros testes
public class InformacoesUsuarioPageObjectsTest {
    private WebDriver navegador;

    @Before
    public void setUp(){
        //variável recebe o retorno do método criado na classe Web (um nova página no chrome)
        navegador = Web.createChrome();
    }

    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(){
        //uma nova instancia da classe LoginPage com o navegador(criado na classe Web) como parâmetro
        new LoginPage(navegador)
                //chama os métodos criados nas duas pages objects
                .clickSignIn()
                .typeLogin("julio0001");
    }

    @After
    public void tearDown(){
        navegador.quit();
    }
}
