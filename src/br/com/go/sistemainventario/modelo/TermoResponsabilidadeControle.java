package br.com.go.sistemainventario.modelo;

import java.sql.SQLException;
import java.util.ArrayList;



public interface TermoResponsabilidadeControle {

	public abstract boolean cadastrarTermo(TermoResponsabilidade termoResponsabilidade) throws SQLException;

	public abstract boolean atualizarTermo(TermoResponsabilidade termoResponsabilidade) throws SQLException;
        
        public abstract int getUltimoIdTermoCadastrado() throws SQLException;
        
        public abstract ArrayList buscarTermoResp(int idUsuarioFinal) throws SQLException;

}
