/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.sistemainventario.comportamento;

import br.com.go.sistemainventario.mysql.MySqlControle;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author oliveira
 */
public abstract class QueryHelper {

    protected MySqlControle mySqlControle;
    protected ResultSet resultSet;
    protected String query;

    public QueryHelper() {
        mySqlControle = new MySqlControle();
    }

    public int getUltimoIdCadastrado(String tabela, String primaryKeyField) throws SQLException {
        this.query = "SELECT " + primaryKeyField
                + " FROM " + tabela
                + " ORDER BY " + primaryKeyField
                + " DESC LIMIT 1";

        this.mySqlControle.setPrepStatement(this.mySqlControle.getConnection().prepareStatement(this.query));

        this.resultSet = mySqlControle.executeQuerySelect();

        if (resultSet.next()) {
            return resultSet.getInt(primaryKeyField);
        }
        return 0;
    }
}
