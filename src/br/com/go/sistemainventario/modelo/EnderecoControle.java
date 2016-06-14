package br.com.go.sistemainventario.modelo;

import java.util.ArrayList;

/**
 *
 * @author oliveira
 */
public interface EnderecoControle {

	public abstract boolean cadastrarEndereco(Endereco endereco) throws Exception;

	public abstract boolean atualizarEndereco(Endereco endereco) throws  Exception;
        
        public abstract int getUltimoIdEnderecoCadastrado() throws Exception;
        
        public abstract Endereco buscarEndereco(int idEndereco) throws Exception;
        
        public abstract ArrayList listarEndereco() throws Exception;

}
