package br.com.go.sistemainventario.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.com.go.sistemainventario.modelo.Endereco;
import br.com.go.sistemainventario.mysql.RestaurarBackupMYSQL;
import br.com.go.sistemainventario.comportamento.ControleSistema;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author oliveira
 */
public class EnderecoTest {

    private Endereco endereco;

    public EnderecoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        RestaurarBackupMYSQL.restoreDB();
    }

    @AfterClass
    public static void tearDownClass() {

    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void cadastrarEndereco() throws SQLException {
        endereco = new Endereco.Builder()
                .logradouroEndereco("Rua Matilde V. Mendes")
                .numEndereco("54")
                .complementoEndereco("Recanto Sandra")
                .bairroEndereco("Martim de Sá")
                .cidadeEndereco("Caraguatatuba")
                .cepEndereco("1166743")
                .estadoEndereco("SP")
                .construir();

        assertTrue(ControleSistema
                .enderecoControle()
                .cadastrarEndereco(endereco)
        );
    }

    @Test
    public void atualizarEndereco() throws SQLException {
        endereco = new Endereco.Builder()
                .logradouroEndereco("Av. Corrimão")
                .numEndereco("233")
                .bairroEndereco("Barranco baixo")
                .cidadeEndereco("Caraguatatuba")
                .cepEndereco("1166000")
                .estadoEndereco("SP")
                .construir();

        assertTrue(ControleSistema.
                enderecoControle()
                .cadastrarEndereco(endereco)
        );

        endereco.setCepEndereco("11661-540");
        endereco.setIdEndereco(ControleSistema.enderecoControle()
                .getUltimoIdEnderecoCadastrado()
        );

        assertTrue(ControleSistema
                .enderecoControle()
                .atualizarEndereco(endereco)
        );
    }

    @Test
    public void alterarStatusEndereco() throws SQLException {
        endereco = new Endereco.Builder()
                .logradouroEndereco("Av. Ruéla")
                .numEndereco("466")
                .bairroEndereco("Azeitaria")
                .cidadeEndereco("Caraguatatuba")
                .cepEndereco("1166000")
                .estadoEndereco("SP")
                .construir();

        assertTrue(ControleSistema
                .enderecoControle()
                .cadastrarEndereco(endereco)
        );

        endereco.setCepEndereco("11662-740");
        endereco.setIdEndereco(ControleSistema
                .enderecoControle()
                .getUltimoIdEnderecoCadastrado()
        );
        endereco.setStatusEndereco('I');

        assertTrue(ControleSistema
                .enderecoControle()
                .atualizarEndereco(endereco));
    }
}
