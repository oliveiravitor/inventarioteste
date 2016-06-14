/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.sistemainventario.comportamento;
import br.com.go.sistemainventario.modelo.*;
import java.sql.SQLException;

/**
 *
 * @author oliveira
 */
public class AdministradorControleMysql implements AdministradorControle {

    @Override
    public boolean cadastrarAdmin(Administrador administrador) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean atualizarAdmin(Administrador administrador) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getUltimoIdAdminCadastrado() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }      
}