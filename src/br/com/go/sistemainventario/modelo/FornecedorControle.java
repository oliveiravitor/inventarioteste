package br.com.go.sistemainventario.modelo;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author oliveira
 */
public interface FornecedorControle {

    public abstract boolean cadastrarFornecedor(Fornecedor fornecedor) throws Exception;

    public abstract boolean atualizarFornecedor(Fornecedor fornecedor) throws Exception;

    public abstract int getUltimoIdFornecedorCadastrado() throws Exception;

    public abstract ArrayList listarFornecedor() throws Exception;

    public abstract Fornecedor buscarFornecedor(int idFornecedor) throws Exception;

    public abstract boolean teste() throws Exception;

}
