/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.sistemainventario.comportamento;

import br.com.go.sistemainventario.modelo.Fornecedor;
import br.com.go.sistemainventario.modelo.FornecedorControle;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author oliveira
 */
public class FornecedorControleMysql extends QueryHelper implements FornecedorControle {

    @Override
    public boolean cadastrarFornecedor(Fornecedor fornecedor) throws SQLException {
        this.query = "INSERT INTO fornecedor "
                + "(idEnderecoFornecedor, nomeContatoFornecedor, nomeFornecedor, "
                + "emailFornecedor, telefoneFornecedor) "
                + "VALUES (?, ?, ?, ?, ?)";

        this.mySqlControle.setPrepStatement(this.mySqlControle.getConnection().prepareStatement(this.query));

        this.mySqlControle.getPrepStatement().setInt(1, fornecedor.getEnderecoFornecedor().getIdEndereco());
        this.mySqlControle.getPrepStatement().setString(2, fornecedor.getNomeContatoFornecedor());
        this.mySqlControle.getPrepStatement().setString(3, fornecedor.getNomeFornecedor());
        this.mySqlControle.getPrepStatement().setString(4, fornecedor.getEmailFornecedor());
        this.mySqlControle.getPrepStatement().setString(5, fornecedor.getTelefoneFornecedor());

        return this.mySqlControle.executeUpdate();
    }

    @Override
    public boolean atualizarFornecedor(Fornecedor fornecedor) throws SQLException {
        this.query = "UPDATE fornecedor "
                + "SET idEnderecoFornecedor = ?, "
                + "nomeContatoFornecedor = ?, "
                + "nomeFornecedor = ?, "
                + "emailFornecedor = ?, "
                + "telefoneFornecedor = ?, "
                + "statusFornecedor = ? "
                + "WHERE idFornecedor = ?";

        this.mySqlControle.setPrepStatement(this.mySqlControle.getConnection().prepareStatement(this.query));

        this.mySqlControle.getPrepStatement().setInt(1, fornecedor.getEnderecoFornecedor().getIdEndereco());
        this.mySqlControle.getPrepStatement().setString(2, fornecedor.getNomeContatoFornecedor());
        this.mySqlControle.getPrepStatement().setString(3, fornecedor.getNomeFornecedor());
        this.mySqlControle.getPrepStatement().setString(4, fornecedor.getEmailFornecedor());
        this.mySqlControle.getPrepStatement().setString(5, fornecedor.getTelefoneFornecedor());
        this.mySqlControle.getPrepStatement().setString(6, fornecedor.getStatusFornecedor() + "");
        this.mySqlControle.getPrepStatement().setInt(7, fornecedor.getIdFornecedor());

        return this.mySqlControle.executeUpdate();
    }

    @Override
    public int getUltimoIdFornecedorCadastrado() throws SQLException {
        this.query = "SELECT idFornecedor "
                + "FROM fornecedor "
                + "ORDER BY idFornecedor "
                + "DESC LIMIT 1";

        this.mySqlControle.setPrepStatement(this.mySqlControle.getConnection().prepareStatement(this.query));

        this.resultSet = mySqlControle.executeQuerySelect();

        int idFornecedor = 0;

        if (resultSet.next()) {
            idFornecedor = resultSet.getInt("idFornecedor");
        }

        this.resultSet.close();
        this.mySqlControle.closeConnection();

        return idFornecedor;
    }

    @Override
    public ArrayList listarFornecedor() throws SQLException {
        this.query = "SELECT * FROM fornecedor "
                + "ORDER BY idFornecedor";

        this.mySqlControle.setPrepStatement(this.mySqlControle.getConnection().prepareStatement(this.query));

        this.resultSet = this.mySqlControle.executeQuerySelect();

        ArrayList<Fornecedor> listaFornecedor = new ArrayList<>();

        while (this.resultSet.next()) {
            listaFornecedor.add(new Fornecedor.Builder()
                    .idFornecedor(this.resultSet.getInt("idFornecedor"))
                    .enderecoFornecedor(ControleSistema
                            .enderecoControle()
                            .buscarEndereco(this.resultSet.getInt("idEnderecoFornecedor"))
                    )
                    .nomeFornecedor(this.resultSet.getString("nomeFornecedor"))
                    .nomeContatoFornecedor(this.resultSet.getString("nomeContatoFornecedor"))
                    .emailFornecedor(this.resultSet.getString("emailFornecedor"))
                    .telefoneFornecedor(this.resultSet.getString("telefoneFornecedor"))
                    .statusFornecedor(this.resultSet.getString("StatusFornecedor").charAt(0))
                    .construir()
            );
        }

        this.resultSet.close();
        this.mySqlControle.closeConnection();

        return listaFornecedor;
    }

    @Override
    public Fornecedor buscarFornecedor(int idFornecedor) throws SQLException {
        this.query = "SELECT * FROM fornecedor "
                + "WHERE idFornecedor = ?";

        this.mySqlControle.setPrepStatement(this.mySqlControle.getConnection().prepareStatement(this.query));

        this.mySqlControle.getPrepStatement().setInt(1, idFornecedor);

        this.resultSet = this.mySqlControle.executeQuerySelect();

        Fornecedor fornecedor = null;

        if (this.resultSet.next()) {
            fornecedor = new Fornecedor.Builder()
                    .idFornecedor(idFornecedor)
                    .nomeFornecedor(this.resultSet.getString("nomeFornecedor"))
                    .nomeContatoFornecedor(this.resultSet.getString("nomeContatoFornecedor"))
                    .emailFornecedor(this.resultSet.getString("emailFornecedor"))
                    .telefoneFornecedor(this.resultSet.getString("telefoneFornecedor"))
                    .statusFornecedor(this.resultSet.getString("StatusFornecedor").charAt(0))
                    .construir();
        }

        this.resultSet.close();
        this.mySqlControle.closeConnection();

        return fornecedor;
    }

    @Override
    public boolean teste() throws SQLException {
        return false;
    }
}
