package br.com.go.sistemainventario.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.com.go.sistemainventario.modelo.Endereco;
import br.com.go.sistemainventario.modelo.Localidade;
import br.com.go.sistemainventario.mysql.RestaurarBackupMYSQL;
import br.com.go.sistemainventario.comportamento.ControleSistema;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class LocalidadeTest {
    
    private static Endereco endereco; 
    
    public LocalidadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        RestaurarBackupMYSQL.restoreDB();
        endereco = new Endereco.Builder()
                .logradouroEndereco("Rua Matilde V. Mendes")
                .numEndereco("54")
                .complementoEndereco("Recanto Sandra")
                .bairroEndereco("Martim de Sá")
                .cidadeEndereco("Caraguatatuba")
                .cepEndereco("1166743")
                .estadoEndereco("SP")
                .construir();

        try {
            ControleSistema.enderecoControle().cadastrarEndereco(endereco);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
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
    public void cadastrarLocalidade() throws SQLException {
        endereco.setIdEndereco(ControleSistema
                .enderecoControle()
                .getUltimoIdEnderecoCadastrado()
        );
        
        Localidade localidade = new Localidade.Builder()
                .enderecoLocalidade(endereco)
                .identificacaoLocal("Sei lá")
                .setorLocal("Deseducação")
                .construir();
        
        assertTrue(ControleSistema
                .localidadeControle()
                .cadastrarLocalidade(localidade)
        );        
    }
    
    @Test
    public void atualizarLocalidade() throws SQLException {
        endereco.setIdEndereco(ControleSistema
                .enderecoControle()
                .getUltimoIdEnderecoCadastrado()
        );
        
        Localidade localidade = new Localidade.Builder()
                .enderecoLocalidade(endereco)
                .identificacaoLocal("jwahekojh")
                .setorLocal("Almoxarifado")
                .construir();
        
       ControleSistema.localidadeControle().cadastrarLocalidade(localidade);
       
       localidade.setIdentificacaoLocal("Almoxarifado");
       localidade.setSetorLocal("Deseducação");
       localidade.setIdLocalidade(
               ControleSistema
               .localidadeControle()
               .getUltimoIdLocalidadeCadastrada()
       );
       
        assertTrue(ControleSistema
                .localidadeControle()
                .atualizarLocalidade(localidade)
        );
    }
}
