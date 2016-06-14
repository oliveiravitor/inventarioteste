/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.sistemainventario.comportamento;

import br.com.go.sistemainventario.modelo.Localidade;
import br.com.go.sistemainventario.modelo.LocalidadeControle;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author oliveira
 */
public class LocalidadeControleMysql extends QueryHelper implements LocalidadeControle {
       
   @Override
    public boolean cadastrarLocalidade(Localidade localidade) throws SQLException {
        this.query = "INSERT INTO localidade "
                + "(idEnderecoLocal, identificacaoLocal, setorLocal) "
                + "VALUES (?, ?, ?)";

        this.mySqlControle.setPrepStatement(
                this.mySqlControle.getConnection().prepareStatement(this.query)
        );

        this.mySqlControle.getPrepStatement().setInt(1,
                localidade.getEnderecoLocalidade().getIdEndereco()
        );
        this.mySqlControle.getPrepStatement().setString(2,
                localidade.getIdentificacaoLocal()
        );
        this.mySqlControle.getPrepStatement().setString(3,
                localidade.getSetorLocal()
        );

        return this.mySqlControle.executeUpdate();
    }

    @Override
    public boolean atualizarLocalidade(Localidade localidade) throws SQLException {
        this.query = "UPDATE localidade SET idEnderecoLocal = ?, "
                + "identificacaoLocal = ?, "
                + "setorLocal = ?, "
                + "statusLocal = ? "
                + "WHERE idLocalidade = ?";
        
        this.mySqlControle.setPrepStatement(this.mySqlControle.getConnection()
                .prepareStatement(query)
        );
        
        this.mySqlControle.getPrepStatement().setInt(1, localidade
                .getEnderecoLocalidade()
                .getIdEndereco()
        );        
        this.mySqlControle.getPrepStatement().setString(2, localidade.getIdentificacaoLocal());
        this.mySqlControle.getPrepStatement().setString(3, localidade.getSetorLocal());
        this.mySqlControle.getPrepStatement().setString(4, String.valueOf(localidade.getStatusLocalidade()));
        this.mySqlControle.getPrepStatement().setInt(5, localidade.getIdLocalidade());
        
        System.out.println("Query update localidade : " + this.mySqlControle.getPrepStatement().toString());
        
        return this.mySqlControle.executeUpdate();
    }

    @Override
    public int getUltimoIdLocalidadeCadastrada() throws SQLException {
        this.query = "SELECT idLocalidade "
                + "FROM localidade "
                + "ORDER BY idLocalidade "
                + "DESC LIMIT 1";

        this.mySqlControle.setPrepStatement(this.mySqlControle.getConnection().prepareStatement(this.query));

        this.resultSet = mySqlControle.executeQuerySelect();

        int idLocalidade = 0;
        if (resultSet.next()) {
            idLocalidade = resultSet.getInt("idLocalidade");            
        }
        
        this.resultSet.close();
        this.mySqlControle.closeConnection();
        
        return idLocalidade;
    }

    @Override
    public ArrayList listarLocalidade() throws SQLException {
        this.query = "SELECT * FROM localidade "
                + "ORDER BY idLocalidade";
        
        this.mySqlControle.setPrepStatement(this.mySqlControle.getConnection().prepareStatement(this.query));
        
        this.resultSet = this.mySqlControle.executeQuerySelect();
        
        ArrayList<Localidade> listaLocalidade = new ArrayList<>();
        
        while (this.resultSet.next()) {
            listaLocalidade.add(new Localidade.Builder()
                    .idLocalidade(this.resultSet.getInt("idLocalidade"))
                    .enderecoLocalidade(ControleSistema
                            .enderecoControle()
                            .buscarEndereco(this.resultSet.getInt("idEnderecoLocal"))
                    )
                    .identificacaoLocal(this.resultSet.getString("identificacaoLocal"))
                    .setorLocal(this.resultSet.getString("setorLocal"))
                    .statusLocalidade(this.resultSet.getString("statusLocal").charAt(0))
                    .construir()
            );
        }
        
        this.resultSet.close();
        this.mySqlControle.closeConnection();
        
        return listaLocalidade;        
    }

    @Override
    public Localidade buscarLocalidade(int idLocalidade) throws SQLException {
        this.query = "SELECT * FROM localidade "
                + "WHERE idLocalidade = ?";
        
        this.mySqlControle.setPrepStatement(this.mySqlControle.getConnection().prepareStatement(this.query));
        
        this.mySqlControle.getPrepStatement().setInt(1, idLocalidade);
        
        this.resultSet = this.mySqlControle.executeQuerySelect();
        
        Localidade localidade = null;
        
        if (this.resultSet.next()) {
            localidade =  new Localidade.Builder()
                    .idLocalidade(this.resultSet.getInt("idLocalidade"))
                    .identificacaoLocal(this.resultSet.getString("identificacaoLocal"))
                    .setorLocal(this.resultSet.getString("setorLocal"))
                    .statusLocalidade(this.resultSet.getString("statusLocal").charAt(0))
                    .construir();
        }
        
        this.resultSet.close();
        this.mySqlControle.closeConnection();
        
        return localidade;
    }

}
