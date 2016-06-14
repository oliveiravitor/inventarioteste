package br.com.go.sistemainventario.modelo;

import java.sql.SQLException;


/**
 *
 * @author oliveira
 */
public interface AdministradorControle {

	public abstract boolean cadastrarAdmin(Administrador administrador) throws SQLException;

	public abstract Boolean atualizarAdmin(Administrador administrador) throws SQLException;

        public abstract int getUltimoIdAdminCadastrado() throws SQLException;
}
