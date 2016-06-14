/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.sistemainventario.comportamento;

import br.com.go.sistemainventario.modelo.RedeConfig;
import br.com.go.sistemainventario.modelo.RedeConfigControle;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author oliveira
 */
public class RedeConfigControleMysql extends QueryHelper implements RedeConfigControle{

    @Override
    public boolean cadastrarRedeConfig(RedeConfig redeConfig) throws SQLException {
        this.query = "INSERT INTO redeConfig "
                + "VALUES(?, ?, ?)";
        
        this.mySqlControle.setPrepStatement(this.mySqlControle.getConnection().prepareStatement(this.query));
        
        this.mySqlControle.getPrepStatement().setInt(1, redeConfig.getIdEquipamento());
        this.mySqlControle.getPrepStatement().setString(2, redeConfig.getIpRedeConfig());
        this.mySqlControle.getPrepStatement().setString(3, redeConfig.getHostRedeConfig());
        
        return this.mySqlControle.executeUpdate();
    }

    @Override
    public boolean atualizarRedeConfig(RedeConfig redeConfig) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public RedeConfig buscarRedeConfig(int idEquipamento) throws SQLException {
        this.query = "SELECT * from redeConfig "
                + "WHERE idEquip = ?";
        
        this.mySqlControle.setPrepStatement(this.mySqlControle.getConnection().prepareStatement(this.query));
        
        this.mySqlControle.getPrepStatement().setInt(1, idEquipamento);
        
        this.resultSet = this.mySqlControle.executeQuerySelect();
        
        RedeConfig redeConfig = null;
        
        if (this.resultSet.next()) {
            redeConfig = new RedeConfig.Builder()
                    .idEquipamento(idEquipamento)
                    .ipRedeConfig(this.resultSet.getString("ipRedeConfig"))
                    .hostRedeConfig(this.resultSet.getString("hostRedeConfig"))
                    .construir();
        }
        
        this.resultSet.close();
        this.mySqlControle.closeConnection();
        
        return redeConfig;
    }
    
}
