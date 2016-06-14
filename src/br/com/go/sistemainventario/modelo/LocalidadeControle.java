package br.com.go.sistemainventario.modelo;

import java.sql.SQLException;
import java.util.ArrayList;


public interface LocalidadeControle {

	public abstract boolean cadastrarLocalidade(Localidade localidade) throws SQLException;

	public abstract boolean atualizarLocalidade(Localidade localidade) throws SQLException;
        
        public abstract int getUltimoIdLocalidadeCadastrada() throws SQLException;
        
        public abstract ArrayList listarLocalidade() throws SQLException;
        
        public abstract Localidade buscarLocalidade(int idLocalidade) throws SQLException;

}
