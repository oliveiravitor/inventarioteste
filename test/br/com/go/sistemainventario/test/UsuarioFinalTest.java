/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.sistemainventario.test;

import br.com.go.sistemainventario.comportamento.ControleSistema;
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
public class UsuarioFinalTest {

    public UsuarioFinalTest() {
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
    public void cadastrarUsuarioFinal() throws SQLException {
        UsuarioFinal usuariofinal = new UsuarioFinal.Builder()
                .nomeCompletoUsuario("João Batista")
                .matriculaUsuario(24)
                .emailUsuario("jb24@gaymail.com")
                .telefoneUsuario("12-98888-8888")
                .construir();

        assertTrue(ControleSistema
                .usuarioControle()
                .cadastrarUsuarioFinal(usuariofinal)
        );
    }

    @Test
    public void atualizarUsuarioFinal() throws SQLException {
        UsuarioFinal usuariofinal = new UsuarioFinal.Builder()
                .nomeCompletoUsuario("Ziggy")
                .matriculaUsuario(1036)
                .emailUsuario("zyggystardust@gmail.com")
                .telefoneUsuario("12-98888-8888")
                .construir();

        ControleSistema.usuarioControle().cadastrarUsuarioFinal(usuariofinal);

        usuariofinal.setIdUsuarioFinal(ControleSistema
                .usuarioControle()
                .getUltimoIdUsuarioFinalCadastrado()
        );
        usuariofinal.setTelefoneUsuario("98888-8888");

        assertTrue(ControleSistema
                .usuarioControle()
                .atualizarUsuarioFinal(usuariofinal)
        );
    }
}
