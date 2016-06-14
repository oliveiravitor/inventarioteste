/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.sistemainventario.comportamento;

import br.com.go.sistemainventario.modelo.TermoResponsabilidade;
import br.com.go.sistemainventario.modelo.TermoResponsabilidadeControle;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author oliveira
 */
public class TermoResponsabilidadeControleMysql extends QueryHelper implements TermoResponsabilidadeControle {

    @Override
    public boolean cadastrarTermo(TermoResponsabilidade termoResponsabilidade) throws SQLException {
        this.query = "INSERT INTO termoResponsabilidade "
                + "(numTermo, idUsuarioFinal) "
                + "VALUES (?, ?)";

        this.mySqlControle.setPrepStatement(this.mySqlControle.getConnection().prepareStatement(this.query));

        this.mySqlControle.getPrepStatement().setInt(1, termoResponsabilidade.getNumTermo());
        this.mySqlControle.getPrepStatement().setInt(2, termoResponsabilidade.getUsuarioFinal().getIdUsuarioFinal());

        return this.mySqlControle.executeUpdate();
    }

    @Override
    public boolean atualizarTermo(TermoResponsabilidade termoResponsabilidade) throws SQLException {
        this.query = "UPDATE termoResponsabilidade "
                + "SET numTermo = ?,"
                + "idUsuarioFinal = ?, "
                + "dataInicioTermo = ?, "
                + "dataTerminoTermo = ? "
                + "WHERE idTermo = ?";

        this.mySqlControle.setPrepStatement(this.mySqlControle.getConnection().prepareStatement(this.query));

        this.mySqlControle.getPrepStatement().setInt(1, termoResponsabilidade.getNumTermo());
        this.mySqlControle.getPrepStatement().setInt(2, termoResponsabilidade.getUsuarioFinal().getIdUsuarioFinal());
        this.mySqlControle.getPrepStatement().setDate(3, (Date) termoResponsabilidade.getDataInicioTermo());
        this.mySqlControle.getPrepStatement().setDate(4, (Date) termoResponsabilidade.getDataInicioTermo());
        this.mySqlControle.getPrepStatement().setInt(5, termoResponsabilidade.getIdTermo());

        return this.mySqlControle.executeUpdate();
    }

    @Override
    public int getUltimoIdTermoCadastrado() throws SQLException {
        this.query = "SELECT idTermo "
                + "FROM  termoResponsabilidade "
                + "ORDER BY idTermo "
                + "DESC LIMIT 1";

        this.mySqlControle.setPrepStatement(this.mySqlControle.getConnection().prepareStatement(this.query));

        this.resultSet = mySqlControle.executeQuerySelect();

        int idTermo = 0;
        
        if (resultSet.next()) {
            idTermo = resultSet.getInt("idTermo");
        }

        this.resultSet.close();
        this.mySqlControle.closeConnection();
        
        return idTermo;
    }

    @Override
    public ArrayList buscarTermoResp(int idUsuarioFinal) throws SQLException {
        this.query = "SELECT * FROM termoResponsabilidade "
                + "WHERE idUsuarioFinal = ?";

        this.mySqlControle.setPrepStatement(this.mySqlControle.getConnection().prepareStatement(this.query));

        this.mySqlControle.getPrepStatement().setInt(1, idUsuarioFinal);

        this.resultSet = this.mySqlControle.executeQuerySelect();

        ArrayList<TermoResponsabilidade> listaTermoResp = new ArrayList<>();

        while (this.resultSet.next()) {
            TermoResponsabilidade termoResponsabilidade;
            
            termoResponsabilidade = new TermoResponsabilidade.Builder()
                    .idTermo(this.resultSet.getInt("idTermo"))
                    .numTermo(this.resultSet.getInt("numTermo"))
                    .dataInicioTermo(this.resultSet.getDate("dataInicioTermo"))
                    .construir();
            
            if (this.resultSet.getDate("dataTerminoTermo") != null) {
                termoResponsabilidade.setDataTerminoTermo(
                        this.resultSet.getDate("dataTerminoTermo")
                );
            } else {
                termoResponsabilidade.setDataTerminoTermo(new java.util.Date(0000, 00, 00));
            }
            
            listaTermoResp.add(termoResponsabilidade);            
        }
        
        this.resultSet.close();
        this.mySqlControle.closeConnection();

        return listaTermoResp;
    }

}
