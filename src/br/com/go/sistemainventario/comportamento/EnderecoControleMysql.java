/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.sistemainventario.comportamento;

import br.com.go.sistemainventario.modelo.Endereco;
import br.com.go.sistemainventario.modelo.EnderecoControle;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author oliveira
 */
public class EnderecoControleMysql extends QueryHelper implements EnderecoControle {

    /**
     * Este método é responsável por passar um objeto do tipo Endereço para 
     * o banco de dados que realizará a persistência do mesmo.
     * @param endereco O endereço a ser gravado no banco
     * @return True se os dados forem gravados corretamente ou
     * false se a operação falhar.
     * @throws SQLException
     */
    @Override
    public boolean cadastrarEndereco(Endereco endereco) throws SQLException {
        //preparando a string que recebe a instrução SQL que será executada pelo banco        
        this.query = "INSERT INTO endereco (logradouroEndereco, numeroEndereco, complementoEndereco, "
                + "bairroEndereco, cidadeEndereco, cepEndereco, estadoEndereco) "
                + "VALUES(?, ? , ? , ? , ? , ?, ?)";
                
        //preparando o Objeto prepStament para receber uma conexão com o banco de dados
        this.mySqlControle.setPrepStatement(this.mySqlControle.getConnection().prepareStatement(this.query));
        //substituindo as ? pelos valores que serão gravados no banco
        this.mySqlControle.getPrepStatement().setString(1, endereco.getLogradouroEndereco());
        this.mySqlControle.getPrepStatement().setString(2, endereco.getNumEndereco());
        this.mySqlControle.getPrepStatement().setString(3, endereco.getComplementoEndereco());
        this.mySqlControle.getPrepStatement().setString(4, endereco.getBairroEndereco());
        this.mySqlControle.getPrepStatement().setString(5, endereco.getCidadeEndereco());
        this.mySqlControle.getPrepStatement().setString(6, endereco.getCepEndereco());
        this.mySqlControle.getPrepStatement().setString(7, endereco.getEstadoEndereco());
        
        /* mandando o banco executar a instrução SQL, retorna verdadeiro se alguma linha for "afetada" (gravada)
            * ou retorna false se nenhum dado foi gravado/alterado/afetado
        */        
        return mySqlControle.executeUpdate();
    }

    /**
     *
     * @param endereco
     * @return
     * @throws SQLException
     */
    @Override
    public boolean atualizarEndereco(Endereco endereco) throws SQLException {
        //preparando a string que recebe a instrução SQL que será executada pelo banco
        this.query = "UPDATE endereco SET logradouroEndereco = ?, numeroEndereco = ?, "
                + "complementoEndereco = ?, bairroEndereco = ?, cidadeEndereco = ?, "
                + "cepEndereco = ?, estadoEndereco = ?, statusEndereco = ? "
                + "WHERE idEndereco = ?";
        //preparando o Objeto prepStament para receber uma conexão com o banco de dados
        this.mySqlControle.setPrepStatement(this.mySqlControle.getConnection().prepareStatement(this.query));
        this.mySqlControle.getPrepStatement().setString(1, endereco.getLogradouroEndereco());
        this.mySqlControle.getPrepStatement().setString(2, endereco.getNumEndereco());
        this.mySqlControle.getPrepStatement().setString(3, endereco.getComplementoEndereco());
        this.mySqlControle.getPrepStatement().setString(4, endereco.getBairroEndereco());
        this.mySqlControle.getPrepStatement().setString(5, endereco.getCidadeEndereco());
        this.mySqlControle.getPrepStatement().setString(6, endereco.getCepEndereco());
        this.mySqlControle.getPrepStatement().setString(7, endereco.getEstadoEndereco());
        this.mySqlControle.getPrepStatement().setString(8, String.valueOf(endereco.getStatusEndereco()));
        this.mySqlControle.getPrepStatement().setInt(9, endereco.getIdEndereco());

        return mySqlControle.executeUpdate();
    }

    @Override
    public int getUltimoIdEnderecoCadastrado() throws SQLException {
        this.query = "SELECT idEndereco "
                + "FROM endereco "
                + "ORDER BY idEndereco "
                + "DESC LIMIT 1";

        this.mySqlControle.setPrepStatement(this.mySqlControle.getConnection().prepareStatement(this.query));

        this.resultSet = mySqlControle.executeQuerySelect();

        int idEndereco = 0;
        
        if (resultSet.next()) {
            idEndereco =  resultSet.getInt("idEndereco");
        }
        
        this.resultSet.close();
        this.mySqlControle.closeConnection();
        
        return idEndereco;
    }

    @Override
    public Endereco buscarEndereco(int idEndereco) throws SQLException {
        //preparando a string que recebe a instrução SQL que será executada pelo banco
        this.query = "SELECT * FROM endereco "
                + "WHERE idEndereco = ? ";
        //preparando o Objeto prepStament para receber uma conexão com o banco de dados
        this.mySqlControle.setPrepStatement(this.mySqlControle.getConnection().prepareStatement(query));
        //substituindo as ? pelos valores que serão gravados no banco
        this.mySqlControle.getPrepStatement().setInt(1, idEndereco);
        //executando a instrução SQL e armazenando o resultado da consulta em um objeto do tipo resultSet (padrão java.sql)
        this.resultSet = this.mySqlControle.executeQuerySelect();
        //declarando o objeto do tipo endereço que será retornado pelo método
        Endereco endereco = null;
        //verificando se foi encontrado o endereço buscado
        if (resultSet.next()) {
            endereco = new Endereco.Builder()
                    .idEndereco(idEndereco)
                    .logradouroEndereco(this.resultSet.getString("logradouroEndereco"))
                    .numEndereco(this.resultSet.getString("numeroEndereco"))
                    .complementoEndereco(this.resultSet.getString("complementoEndereco"))
                    .bairroEndereco(this.resultSet.getString("bairroEndereco"))
                    .cidadeEndereco(this.resultSet.getString("cidadeEndereco"))
                    .cepEndereco(this.resultSet.getString("cepEndereco"))
                    .estadoEndereco(this.resultSet.getString("estadoEndereco"))
                    .statusEndereco(this.resultSet.getString("statusEndereco").charAt(0))
                    .construir();
        }
        //fechando a conexão com o banco        
        this.resultSet.close();
        this.mySqlControle.closeConnection();
        //retornando o endereço encontrado, ou não (null)
        return endereco;
    }

    @Override
    public ArrayList listarEndereco() throws Exception {
        this.query = "SELECT * FROM endereco "
                + "ORDER BY idEndereco";
        
        this.mySqlControle.setPrepStatement(this.mySqlControle.getConnection().prepareStatement(this.query));
        
        this.resultSet = this.mySqlControle.executeQuerySelect();
        
        ArrayList<Endereco> listaEndereco = new ArrayList<>();
        
        while (this.resultSet.next()) {
            listaEndereco.add(new Endereco.Builder()
                    .idEndereco(this.resultSet.getInt("idEndereco"))
                    .logradouroEndereco(this.resultSet.getString("logradouroEndereco"))
                    .numEndereco(this.resultSet.getString("numeroEndereco"))
                    .complementoEndereco(this.resultSet.getString("complementoEndereco"))
                    .bairroEndereco(this.resultSet.getString("bairroEndereco"))
                    .cidadeEndereco(this.resultSet.getString("cidadeEndereco"))
                    .cepEndereco(this.resultSet.getString("cepEndereco"))
                    .estadoEndereco(this.resultSet.getString("estadoEndereco"))
                    .statusEndereco(this.resultSet.getString("statusEndereco").charAt(0))
                    .construir()
            );
        }
        
        this.resultSet.close();
        this.mySqlControle.closeConnection();
        
        return listaEndereco;
    }

}
