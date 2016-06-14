/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.sistemainventario.test;

import br.com.go.sistemainventario.comportamento.ControleSistema;
import br.com.go.sistemainventario.modelo.Endereco;
import br.com.go.sistemainventario.modelo.Equipamento;
import br.com.go.sistemainventario.modelo.Fornecedor;
import br.com.go.sistemainventario.modelo.Localidade;
import br.com.go.sistemainventario.modelo.UsuarioFinal;
import br.com.go.sistemainventario.mysql.RestaurarBackupMYSQL;
import java.sql.SQLException;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author oliveira
 */
public class EquipamentoImpressoraTest {

    private static Endereco endereco;
    private static Localidade localidade;
    private static Fornecedor fornecedor;
    private static UsuarioFinal usuariofinal;

    public EquipamentoImpressoraTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        RestaurarBackupMYSQL.restoreDB();

        endereco = new Endereco.Builder()
                .logradouroEndereco("Av. Miguel Varlez")
                .numEndereco("666")
                .bairroEndereco("Centro")
                .cidadeEndereco("Caraguatatuba")
                .cepEndereco("11660000")
                .estadoEndereco("SP")
                .construir();

        fornecedor = new Fornecedor.Builder()
                .nomeContatoFornecedor("João Batista")
                .nomeFornecedor("Patrimônio - estoque TI")
                .emailFornecedor("pratromonioti@suaempresa.com.br")
                .telefoneFornecedor("12-98888-7777")
                .enderecoFornecedor(endereco)
                .construir();

        try {
            ControleSistema
                    .enderecoControle()
                    .cadastrarEndereco(endereco);

            endereco.setIdEndereco(ControleSistema
                    .enderecoControle()
                    .getUltimoIdEnderecoCadastrado()
            );

            ControleSistema
                    .fornecedorControle()
                    .cadastrarFornecedor(fornecedor);
            
            fornecedor.setIdFornecedor(ControleSistema
                    .fornecedorControle().getUltimoIdFornecedorCadastrado()
                    
            );

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        endereco = new Endereco.Builder()
                .logradouroEndereco("Av. Corrimão")
                .numEndereco("233")
                .bairroEndereco("Barranco baixo")
                .cidadeEndereco("Caraguatatuba")
                .cepEndereco("1166000")
                .estadoEndereco("SP")
                .construir();

        try {
            ControleSistema.
                    enderecoControle()
                    .cadastrarEndereco(endereco);

            endereco.setIdEndereco(ControleSistema
                    .enderecoControle()
                    .getUltimoIdEnderecoCadastrado()
            );

            localidade = new Localidade.Builder()
                    .enderecoLocalidade(endereco)
                    .identificacaoLocal("Casa da mãe joana")
                    .setorLocal("Deseducação")
                    .construir();

            ControleSistema
                    .localidadeControle()
                    .cadastrarLocalidade(localidade);
            
            localidade.setIdLocalidade(ControleSistema
                    .localidadeControle()
                    .getUltimoIdLocalidadeCadastrada()
            );

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        usuariofinal = new UsuarioFinal.Builder()
                .nomeCompletoUsuario("Estoque")
                .matriculaUsuario(1)
                .telefoneUsuario("12-98888-8888")
                .construir();

        try {
            ControleSistema
                    .usuarioControle()
                    .cadastrarUsuarioFinal(usuariofinal);
            
            usuariofinal.setIdUsuarioFinal(ControleSistema
                        .usuarioControle().getUltimoIdUsuarioFinalCadastrado()
            );

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }    

    @Test
    public void cadastrarEquipamento() throws SQLException {
        Equipamento equipamentoDesktop = new Equipamento.Builder()
                .usarioFinal(usuariofinal)
                .localidade(localidade)
                .fornecedor(fornecedor)
                .tipoEquip('I')
                .origemEquip('P')
                .modeloEquip("LX-810")
                .construir();
        
        
        assertTrue(ControleSistema
                .equipamentoControle()
                .cadastrarEquipamento(equipamentoDesktop)
        );
    }
}
