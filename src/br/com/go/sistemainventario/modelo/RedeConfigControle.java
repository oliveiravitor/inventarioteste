package br.com.go.sistemainventario.modelo;

import java.sql.SQLException;
import java.util.ArrayList;


public interface RedeConfigControle {

	public abstract boolean cadastrarRedeConfig(RedeConfig redeConfig) throws SQLException;
        
	public abstract boolean atualizarRedeConfig(RedeConfig redeConfig) throws SQLException;
        
        public abstract RedeConfig buscarRedeConfig(int idEquipamento) throws SQLException;
        
}
