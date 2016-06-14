/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.sistemainventario.test;

import br.com.go.sistemainventario.comportamento.ControleSistema;
import br.com.go.sistemainventario.modelo.Endereco;
import br.com.go.sistemainventario.modelo.Fornecedor;
import br.com.go.sistemainventario.mysql.RestaurarBackupMYSQL;
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
public class FornecedorTest {

    private static Endereco endereco;

    public FornecedorTest() {
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
            boolean cadastrarEndereco = ControleSistema
                    .enderecoControle()
                    .cadastrarEndereco(endereco);

            if (cadastrarEndereco) {
                endereco.setIdEndereco(ControleSistema
                        .enderecoControle()
                        .getUltimoIdEnderecoCadastrado()
                );
            }
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
    public void cadastrarFornecedor() throws SQLException {
        Fornecedor fornecedor = new Fornecedor.Builder()
                .nomeContatoFornecedor("Bafo de bode")
                .nomeFornecedor("Pirata Informática")
                .emailFornecedor("pirata@piratainformatica.com.br")
                .telefoneFornecedor("11-32456789")
                .enderecoFornecedor(endereco)
                .construir();
        
        assertTrue(ControleSistema
                .fornecedorControle()
                .cadastrarFornecedor(fornecedor)
        );
    }
    
    @Test
    public void atualizarFornecedor() throws SQLException {
        Fornecedor fornecedor = new Fornecedor.Builder()
                .nomeContatoFornecedor("Bafo de bode")
                .nomeFornecedor("Pirata Informática")
                .emailFornecedor("pirata@piratainformatica.com.br")
                .telefoneFornecedor("11-32456789")
                .enderecoFornecedor(endereco)
                .construir();
        
        ControleSistema
                .fornecedorControle()
                .cadastrarFornecedor(fornecedor);
        
        fornecedor.setIdFornecedor(ControleSistema
                .fornecedorControle().getUltimoIdFornecedorCadastrado()
        );
        
        assertTrue(ControleSistema
                .fornecedorControle()
                .atualizarFornecedor(fornecedor)
        );        
    }
}
