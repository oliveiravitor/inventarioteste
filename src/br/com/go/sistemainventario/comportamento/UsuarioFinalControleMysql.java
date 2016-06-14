/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.sistemainventario.comportamento;

import br.com.go.sistemainventario.modelo.UsuarioFinal;
import br.com.go.sistemainventario.modelo.UsuarioFinalControle;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author oliveira
 */
public class UsuarioFinalControleMysql extends QueryHelper implements UsuarioFinalControle {

    @Override
    public boolean cadastrarUsuarioFinal(UsuarioFinal usuarioFinal) throws SQLException {
        this.query = "INSERT INTO usuarioFinal "
                + "(nomeUsuario, matriculaUsuario, emailUsuario, telefoneUsuario) "
                + "VALUES (?, ?, ?, ?)";

        this.mySqlControle.setPrepStatement(this.mySqlControle.getConnection().prepareStatement(this.query));

        this.mySqlControle.getPrepStatement().setString(1, usuarioFinal.getNomeCompletoUsuario());
        this.mySqlControle.getPrepStatement().setInt(2, usuarioFinal.getMatriculaUsuario());
        this.mySqlControle.getPrepStatement().setString(3, usuarioFinal.getEmailUsuario());
        this.mySqlControle.getPrepStatement().setString(4, usuarioFinal.getTelefoneUsuario());

        return this.mySqlControle.executeUpdate();
    }

    @Override
    public boolean atualizarUsuarioFinal(UsuarioFinal usuarioFinal) throws SQLException {
        this.query = "UPDATE usuarioFinal "
                + "SET nomeUsuario = ?, "
                + "matriculaUsuario = ?, "
                + "emailUsuario = ?, "
                + "telefoneUsuario = ?, "
                + "statusUsuario = ? "
                + "WHERE idUsuarioFinal = ?";

        this.mySqlControle.setPrepStatement(this.mySqlControle.getConnection().prepareStatement(this.query));

        this.mySqlControle.getPrepStatement().setString(1, usuarioFinal.getNomeCompletoUsuario());
        this.mySqlControle.getPrepStatement().setInt(2, usuarioFinal.getMatriculaUsuario());
        this.mySqlControle.getPrepStatement().setString(3, usuarioFinal.getEmailUsuario());
        this.mySqlControle.getPrepStatement().setString(4, usuarioFinal.getTelefoneUsuario());
        this.mySqlControle.getPrepStatement().setString(5, String.valueOf(usuarioFinal.getStatusUsuario()));
        this.mySqlControle.getPrepStatement().setInt(6, usuarioFinal.getIdUsuarioFinal());

        return this.mySqlControle.executeUpdate();
    }

    @Override
    public int getUltimoIdUsuarioFinalCadastrado() throws SQLException {
        this.query = "SELECT idUsuarioFinal "
                + "FROM usuarioFinal "
                + "ORDER BY idUsuarioFinal "
                + "DESC LIMIT 1";

        this.mySqlControle.setPrepStatement(this.mySqlControle.getConnection().prepareStatement(this.query));

        this.resultSet = mySqlControle.executeQuerySelect();

        int idUsuarioFinal = 0;
        
        if (resultSet.next()) {
            idUsuarioFinal = resultSet.getInt("idUsuarioFinal");
        }

        this.resultSet.close();
        this.mySqlControle.closeConnection();
        
        return idUsuarioFinal;
    }

    @Override
    public ArrayList listarUsuarioFinal() throws SQLException {
        this.query = "SELECT * FROM usuarioFinal "
                + "ORDER BY idUsuarioFinal";
        
        this.mySqlControle.setPrepStatement(this.mySqlControle.getConnection().prepareStatement(this.query));
        
        this.resultSet = this.mySqlControle.executeQuerySelect();
        
        ArrayList<UsuarioFinal> listaUsuarioFinal = new ArrayList<>();
        
        while (this.resultSet.next()) {
            listaUsuarioFinal.add(new UsuarioFinal.Builder()
                    .idUsuarioFinal(this.resultSet.getInt("idUsuarioFinal"))
                    .matriculaUsuario(this.resultSet.getInt("matriculaUsuario"))
                    .nomeCompletoUsuario(this.resultSet.getString("nomeUsuario"))
                    .emailUsuario(this.resultSet.getString("emailUsuario"))
                    .telefoneUsuario(this.resultSet.getString("telefoneUsuario"))
                    .statusUsuario(this.resultSet.getString("statusUsuario").charAt(0))
                    .construir()
            );           
        }
        
        this.resultSet.close();
        this.mySqlControle.closeConnection();
        
        return listaUsuarioFinal;
    }

    @Override
    public UsuarioFinal buscarUsuarioFinal(int idUsuarioFinal) throws SQLException {
        this.query = "SELECT * FROM usuarioFinal "
                + "WHERE idUsuarioFinal = ?";
        
        this.mySqlControle.setPrepStatement(this.mySqlControle.getConnection().prepareCall(this.query));
        
        this.mySqlControle.getPrepStatement().setInt(1, idUsuarioFinal);
        
        this.resultSet = this.mySqlControle.executeQuerySelect();
        
        UsuarioFinal usuarioFinal = null;
                
        if (this.resultSet.next()) {
            usuarioFinal = new UsuarioFinal.Builder()
                    .idUsuarioFinal(this.resultSet.getInt("idUsuarioFinal"))
                    .matriculaUsuario(this.resultSet.getInt("matriculaUsuario"))
                    .nomeCompletoUsuario(this.resultSet.getString("nomeUsuario"))
                    .emailUsuario(this.resultSet.getString("emailUsuario"))
                    .telefoneUsuario(this.resultSet.getString("telefoneUsuario"))
                    .statusUsuario(this.resultSet.getString("statusUsuario").charAt(0))
                    .construir();
        }
             
        this.resultSet.close();
        this.mySqlControle.closeConnection();
        
        return usuarioFinal;
    }

}
