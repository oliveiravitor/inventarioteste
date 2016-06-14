package br.com.go.sistemainventario.modelo;

import java.sql.SQLException;
import java.util.ArrayList;



public interface UsuarioFinalControle {

	public abstract boolean cadastrarUsuarioFinal(UsuarioFinal usuarioFinal) throws SQLException;

	public abstract boolean atualizarUsuarioFinal(UsuarioFinal usuarioFinal) throws SQLException;
        
        public abstract int getUltimoIdUsuarioFinalCadastrado() throws SQLException;      
        
        public abstract ArrayList listarUsuarioFinal() throws SQLException;
        
        public abstract UsuarioFinal buscarUsuarioFinal(int idUsuarioFinal) throws SQLException;
        
}
