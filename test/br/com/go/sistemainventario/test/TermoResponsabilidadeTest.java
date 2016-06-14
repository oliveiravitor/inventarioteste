/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.sistemainventario.test;

import br.com.go.sistemainventario.comportamento.ControleSistema;
import br.com.go.sistemainventario.modelo.TermoResponsabilidade;
import br.com.go.sistemainventario.modelo.UsuarioFinal;
import br.com.go.sistemainventario.mysql.RestaurarBackupMYSQL;
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
public class TermoResponsabilidadeTest {

    private static UsuarioFinal usuarioFinal;

    public TermoResponsabilidadeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        RestaurarBackupMYSQL.restoreDB();

        usuarioFinal = new UsuarioFinal.Builder()
                .nomeCompletoUsuario("João Batista")
                .matriculaUsuario(24)
                .emailUsuario("jb24@gaymail.com")
                .telefoneUsuario("12-98888-8888")
                .construir();

        try {
            ControleSistema
                    .usuarioControle()
                    .cadastrarUsuarioFinal(usuarioFinal);

            usuarioFinal.setIdUsuarioFinal(ControleSistema
                    .usuarioControle()
                    .getUltimoIdUsuarioFinalCadastrado()
            );
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
    public void cadastrarTermoResponsabilidade() throws SQLException {
        TermoResponsabilidade termoResponsabilidade;

        termoResponsabilidade = new TermoResponsabilidade.Builder()
                .numTermo(100)
                .usuarioFinal(usuarioFinal)
                .construir();

        assertTrue(ControleSistema
                .termoControle()
                .cadastrarTermo(termoResponsabilidade)
        );
    }

    @Test
    public void atualizarTermoResponsabilidade() throws SQLException {
        TermoResponsabilidade termoResponsabilidade;

        termoResponsabilidade = new TermoResponsabilidade.Builder()
                .numTermo(110)
                .usuarioFinal(usuarioFinal)
                .construir();

        assertTrue(ControleSistema
                .termoControle()
                .cadastrarTermo(termoResponsabilidade)
        );

        termoResponsabilidade.setIdTermo(ControleSistema
                .termoControle().getUltimoIdTermoCadastrado()
        );
        termoResponsabilidade.setNumTermo(101);

        assertTrue(ControleSistema
                .termoControle()
                .atualizarTermo(termoResponsabilidade)
        );
    }

    @Test
    public void testarNovoGetIt() throws SQLException {
        TermoResponsabilidade termoResponsabilidade;

        termoResponsabilidade = new TermoResponsabilidade.Builder()
                .numTermo(1)
                .usuarioFinal(usuarioFinal)
                .construir();

        ControleSistema
                .termoControle()
                .cadastrarTermo(termoResponsabilidade);
        
        int idTermo = ControleSistema.termoControle().getUltimoIdTermoCadastrado();

        assertEquals(idTermo, ControleSistema
                .termoControle().getUltimoIdCadastrado("termoResponsabilidade", "idTermo")
        );
    }
}
