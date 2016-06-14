/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.sistemainventario.comportamento;

import br.com.go.sistemainventario.modelo.Equipamento;
import br.com.go.sistemainventario.modelo.EquipamentoControle;
import br.com.go.sistemainventario.modelo.Fornecedor;
import br.com.go.sistemainventario.modelo.Localidade;
import br.com.go.sistemainventario.modelo.UsuarioFinal;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author oliveira
 */
public class EquipamentoControleMysql extends QueryHelper implements EquipamentoControle {

    @Override
    public boolean cadastrarEquipamento(Equipamento equipamento) throws SQLException {
        this.query = "INSERT INTO equipamento "
                + "(idUsuarioFinal, idLocalidade, idFornecedor, tipoEquip, origemEquip, "
                + "modeloEquip, numSerieEquip, numSerieGabineteEquip, numSerieMouseEquip, "
                + "numSerieTecladoEquip, numSerieMonitorEquip) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        this.mySqlControle.setPrepStatement(this.mySqlControle.getConnection().prepareStatement(this.query));
        
        this.mySqlControle.getPrepStatement().setInt(1, equipamento.getUsuarioFinal().getIdUsuarioFinal());
        this.mySqlControle.getPrepStatement().setInt(2, equipamento.getLocalidade().getIdLocalidade());
        this.mySqlControle.getPrepStatement().setInt(3, equipamento.getFornecedor().getIdFornecedor());
        this.mySqlControle.getPrepStatement().setString(4, String.valueOf(equipamento.getTipoEquip()));
        this.mySqlControle.getPrepStatement().setString(5, String.valueOf(equipamento.getOrigemEquip()));
        this.mySqlControle.getPrepStatement().setString(6, equipamento.getModeloEquip());
        this.mySqlControle.getPrepStatement().setString(7, equipamento.getNumSerieEquip());
        this.mySqlControle.getPrepStatement().setString(8, equipamento.getNumSerieGabineteEquip());
        this.mySqlControle.getPrepStatement().setString(9, equipamento.getNumSerieMouseEquip());
        this.mySqlControle.getPrepStatement().setString(10, equipamento.getNumSerieTecladoEquip());
        this.mySqlControle.getPrepStatement().setString(11, equipamento.getNumSerieMonitorEquip());
        
        System.out.println("Query cadastrar equipamento" + this.mySqlControle.getPrepStatement().toString());
        
        return this.mySqlControle.executeUpdate();
    }

    @Override
    public boolean atualizarEquipamento(Equipamento equipamento) throws SQLException {
        this.query = "UPDATE equipamento SET idUsuarioFinal = ?, "
                + "idLocalidade = ?, "
                + "idFornecedor = ?, "
                + "tipoEquip = ?, "
                + "origemEquip = ?, "
                + "modeloEquip = ?, "
                + "numSerieEquip = ?, "
                + "numSerieGabineteEquip = ?, "
                + "numSerieMouseEquip = ?, "
                + "numSerieTecladoEquip = ?, "
                + "numSerieMonitorEquip = ?, "
                + "statusEquip = ?, "
                + "dataEntradaEquip = ? "
                + "WHERE idEquip = ? ";
        
        this.mySqlControle.setPrepStatement(this.mySqlControle.getConnection().prepareStatement(this.query));
        
        this.mySqlControle.getPrepStatement().setInt(1, equipamento.getUsuarioFinal().getIdUsuarioFinal());
        this.mySqlControle.getPrepStatement().setInt(2, equipamento.getLocalidade().getIdLocalidade());
        this.mySqlControle.getPrepStatement().setInt(3, equipamento.getFornecedor().getIdFornecedor());
        this.mySqlControle.getPrepStatement().setString(4, String.valueOf(equipamento.getTipoEquip()));
        this.mySqlControle.getPrepStatement().setString(5, String.valueOf(equipamento.getOrigemEquip()));
        this.mySqlControle.getPrepStatement().setString(6, equipamento.getModeloEquip());
        this.mySqlControle.getPrepStatement().setString(7, equipamento.getNumSerieEquip());
        this.mySqlControle.getPrepStatement().setString(8, equipamento.getNumSerieGabineteEquip());
        this.mySqlControle.getPrepStatement().setString(9, equipamento.getNumSerieMouseEquip());
        this.mySqlControle.getPrepStatement().setString(10, equipamento.getNumSerieTecladoEquip());
        this.mySqlControle.getPrepStatement().setString(11, equipamento.getNumSerieMonitorEquip());
        this.mySqlControle.getPrepStatement().setString(12, String.valueOf(equipamento.getStatusEquip()));
        this.mySqlControle.getPrepStatement().setDate(13, (Date) equipamento.getDataEntrada());
        this.mySqlControle.getPrepStatement().setInt(14, equipamento.getIdEquip());
        
        return this.mySqlControle.executeUpdate();
        
    }

    @Override
    public int getUltimoIdCadastradoEquip() throws SQLException {
        this.query = "SELECT idEquip "
                + "FROM equipamento "
                + "ORDER BY idEquip "
                + "DESC LIMIT 1";

        this.mySqlControle.setPrepStatement(this.mySqlControle.getConnection().prepareStatement(this.query));

        this.resultSet = mySqlControle.executeQuerySelect();

        int idEquip = 0;
        
        if (resultSet.next()) {
            idEquip = resultSet.getInt("idEquipamento");
        }
        
        this.resultSet.close();
        this.mySqlControle.closeConnection();
        
        return idEquip;
    }

    @Override
    public ArrayList listarEquipamento() throws SQLException {
        this.query = "SELECT * FROM equipamento "
                + "ORDER BY idEquip";

        this.mySqlControle.setPrepStatement(this.mySqlControle.getConnection().prepareStatement(this.query));

        System.out.println("Query listar equipamentos: " + this.mySqlControle.getPrepStatement().toString());

        this.resultSet = this.mySqlControle.executeQuerySelect();

        Equipamento equipamento;
        ArrayList<Equipamento> listaEquipamento = new ArrayList<>();

        while (this.resultSet.next()) {
            equipamento = new Equipamento.Builder()
                    .usarioFinal(new UsuarioFinal.Builder()
                            .idUsuarioFinal(this.resultSet.getInt("idUsuarioFinal"))
                            .construir()
                    )
                    .fornecedor(new Fornecedor.Builder()
                            .idFornecedor(this.resultSet.getInt("idFornecedor"))
                            .construir()
                    )
                    .localidade(new Localidade.Builder()
                            .idLocalidade(this.resultSet.getInt("idLocalidade"))
                            .construir()
                    )
                    .idEquip(this.resultSet.getInt("idEquip"))
                    .tipoEquip(this.resultSet.getString("tipoEquip").charAt(0))
                    .origemEquip(this.resultSet.getString("OrigemEquip").charAt(0))
                    .modeloEquip(this.resultSet.getString("modeloEquip"))
                    .numSerieEquip(this.resultSet.getString("numSerieEquip"))
                    .statusEquip(this.resultSet.getString("statusEquip").charAt(0))
                    .dataEntrada(this.resultSet.getDate("dataEntradaEquip"))
                    .construir();

            equipamento.setNumSerieGabineteEquip("");
            if (this.resultSet.getString("numSerieGabineteEquip") != null) {
                equipamento.setNumSerieGabineteEquip(this.resultSet.getString("numSerieGabineteEquip"));
            }

            equipamento.setNumSerieMouseEquip("");
            if (this.resultSet.getString("numSerieMouseEquip") != null) {
                equipamento.setNumSerieMouseEquip(this.resultSet.getString("numSerieMouseEquip"));
            }
            
            equipamento.setNumSerieTecladoEquip("");
            if (this.resultSet.getString("numSerieTecladoEquip") != null) {
                equipamento.setNumSerieTecladoEquip(this.resultSet.getString("numSerieTecladoEquip"));
            }
            
            equipamento.setNumSerieMonitorEquip("");
            if (this.resultSet.getString("numSerieMonitorEquip") != null) {
                equipamento.setNumSerieMonitorEquip(this.resultSet.getString("numSerieMonitorEquip"));
            } 
            
            listaEquipamento.add(equipamento);
        }
        
        this.resultSet.close();
        this.mySqlControle.closeConnection();

        return listaEquipamento;
    }

    @Override
    public Equipamento buscarEquip(int idEquip) throws SQLException {
        this.query = "SELECT * FROM equipamento "
                + "WHERE idEquip = ?";
        
        this.mySqlControle.setPrepStatement(this.mySqlControle.getConnection().prepareStatement(this.query));
        
        this.mySqlControle.getPrepStatement().setInt(1, idEquip);
        
        this.resultSet = this.mySqlControle.executeQuerySelect();
        
        Equipamento equipamento = null;
        
        if (this.resultSet.next()) {
            equipamento = new Equipamento.Builder()
                    .usarioFinal(new UsuarioFinal.Builder()
                            .idUsuarioFinal(this.resultSet.getInt("idUsuarioFinal"))
                            .construir()
                    )
                    .fornecedor(new Fornecedor.Builder()
                            .idFornecedor(this.resultSet.getInt("idFornecedor"))
                            .construir()
                    )
                    .localidade(new Localidade.Builder()
                            .idLocalidade(this.resultSet.getInt("idLocalidade"))
                            .construir()
                    )
                    .idEquip(this.resultSet.getInt("idEquip"))
                    .tipoEquip(this.resultSet.getString("tipoEquip").charAt(0))
                    .origemEquip(this.resultSet.getString("OrigemEquip").charAt(0))
                    .modeloEquip(this.resultSet.getString("modeloEquip"))
                    .numSerieEquip(this.resultSet.getString("numSerieEquip"))
                    .statusEquip(this.resultSet.getString("statusEquip").charAt(0))
                    .dataEntrada(this.resultSet.getDate("dataEntradaEquip"))
                    .construir();

            equipamento.setNumSerieGabineteEquip("");
            if (this.resultSet.getString("numSerieGabineteEquip") != null) {
                equipamento.setNumSerieGabineteEquip(this.resultSet.getString("numSerieGabineteEquip"));
            }

            equipamento.setNumSerieMouseEquip("");
            if (this.resultSet.getString("numSerieMouseEquip") != null) {
                equipamento.setNumSerieMouseEquip(this.resultSet.getString("numSerieMouseEquip"));
            }
            
            equipamento.setNumSerieTecladoEquip("");
            if (this.resultSet.getString("numSerieTecladoEquip") != null) {
                equipamento.setNumSerieTecladoEquip(this.resultSet.getString("numSerieTecladoEquip"));
            }
            
            equipamento.setNumSerieMonitorEquip("");
            if (this.resultSet.getString("numSerieMonitorEquip") != null) {
                equipamento.setNumSerieMonitorEquip(this.resultSet.getString("numSerieMonitorEquip"));
            } 
        }

        this.resultSet.close();
        this.mySqlControle.closeConnection();        
        
        return equipamento;
    }

    @Override
    public ArrayList listarEquipamentoDisponivel() throws SQLException {
        this.query = "SELECT * FROM equipamento "
                + "WHERE statusEquip = 'L' "
                + "ORDER BY idEquip";

        this.mySqlControle.setPrepStatement(this.mySqlControle.getConnection().prepareStatement(this.query));

        System.out.println("Query listar equipamentos: " + this.mySqlControle.getPrepStatement().toString());

        this.resultSet = this.mySqlControle.executeQuerySelect();

        Equipamento equipamento;
        ArrayList<Equipamento> listaEquipamento = new ArrayList<>();

        while (this.resultSet.next()) {
            equipamento = new Equipamento.Builder()
                    .usarioFinal(new UsuarioFinal.Builder()
                            .idUsuarioFinal(this.resultSet.getInt("idUsuarioFinal"))
                            .construir()
                    )
                    .fornecedor(new Fornecedor.Builder()
                            .idFornecedor(this.resultSet.getInt("idFornecedor"))
                            .construir()
                    )
                    .localidade(new Localidade.Builder()
                            .idLocalidade(this.resultSet.getInt("idLocalidade"))
                            .construir()
                    )
                    .idEquip(this.resultSet.getInt("idEquip"))
                    .tipoEquip(this.resultSet.getString("tipoEquip").charAt(0))
                    .origemEquip(this.resultSet.getString("OrigemEquip").charAt(0))
                    .modeloEquip(this.resultSet.getString("modeloEquip"))
                    .numSerieEquip(this.resultSet.getString("numSerieEquip"))
                    .statusEquip(this.resultSet.getString("statusEquip").charAt(0))
                    .dataEntrada(this.resultSet.getDate("dataEntradaEquip"))
                    .construir();

            equipamento.setNumSerieGabineteEquip("");
            if (this.resultSet.getString("numSerieGabineteEquip") != null) {
                equipamento.setNumSerieGabineteEquip(this.resultSet.getString("numSerieGabineteEquip"));
            }

            equipamento.setNumSerieMouseEquip("");
            if (this.resultSet.getString("numSerieMouseEquip") != null) {
                equipamento.setNumSerieMouseEquip(this.resultSet.getString("numSerieMouseEquip"));
            }
            
            equipamento.setNumSerieTecladoEquip("");
            if (this.resultSet.getString("numSerieTecladoEquip") != null) {
                equipamento.setNumSerieTecladoEquip(this.resultSet.getString("numSerieTecladoEquip"));
            }
            
            equipamento.setNumSerieMonitorEquip("");
            if (this.resultSet.getString("numSerieMonitorEquip") != null) {
                equipamento.setNumSerieMonitorEquip(this.resultSet.getString("numSerieMonitorEquip"));
            } 
            
            listaEquipamento.add(equipamento);
        }
        
        this.resultSet.close();
        this.mySqlControle.closeConnection();

        return listaEquipamento;
    }

    @Override
    public ArrayList listarEquipamentoCompleto() throws SQLException {
        this.query = "SELECT * FROM equipamentoFull "
                + "ORDER BY idEquip";
        
        this.mySqlControle.setPrepStatement(this.mySqlControle
                .getConnection()
                .prepareStatement(this.query));
        
        this.resultSet = this.mySqlControle.executeQuerySelect();
        
        ArrayList<Equipamento> listaEquipFull = new ArrayList<>();        
        Equipamento equipamento;

        while (this.resultSet.next()) {
            equipamento = new Equipamento.Builder()
                    .usarioFinal(new UsuarioFinal.Builder()
                            .idUsuarioFinal(this.resultSet.getInt("idUsuarioFinal"))
                            .nomeCompletoUsuario(this.resultSet.getString("nomeUsuario"))
                            .matriculaUsuario(this.resultSet.getInt("matriculaUsuario"))
                            .emailUsuario(this.resultSet.getString("emailUsuario"))
                            .telefoneUsuario(this.resultSet.getString("telefoneUsuario"))
                            .statusUsuario(this.resultSet.getString("statusUsuario").charAt(0))
                            .construir()
                    )
                    .fornecedor(new Fornecedor.Builder()
                            .idFornecedor(this.resultSet.getInt("idFornecedor"))
                            .nomeFornecedor(this.resultSet.getString("nomeFornecedor"))
                            .nomeContatoFornecedor(this.resultSet.getString("nomeContatoFornecedor"))
                            .emailFornecedor(this.resultSet.getString("emailFornecedor"))
                            .telefoneFornecedor(this.resultSet.getString("telefoneFornecedor"))
                            .statusFornecedor(this.resultSet.getString("statusFornecedor").charAt(0))
                            .construir()
                    )
                    .localidade(new Localidade.Builder()
                            .idLocalidade(this.resultSet.getInt("idLocalidade"))
                            .enderecoLocalidade(ControleSistema
                                    .enderecoControle()
                                    .buscarEndereco(this.resultSet.getInt("idEnderecoLocal")))
                            .identificacaoLocal(this.resultSet.getString("identificacaoLocal"))
                            .setorLocal(this.resultSet.getString("setorLocal"))
                            .statusLocalidade(this.resultSet.getString("statusLocal").charAt(0))
                            .construir()
                    )
                    .idEquip(this.resultSet.getInt("idEquip"))
                    .tipoEquip(this.resultSet.getString("tipoEquip").charAt(0))
                    .origemEquip(this.resultSet.getString("OrigemEquip").charAt(0))
                    .modeloEquip(this.resultSet.getString("modeloEquip"))
                    .numSerieEquip(this.resultSet.getString("numSerieEquip"))
                    .statusEquip(this.resultSet.getString("statusEquip").charAt(0))
                    .dataEntrada(this.resultSet.getDate("dataEntradaEquip"))
                    .construir();

            equipamento.setNumSerieGabineteEquip("");
            if (this.resultSet.getString("numSerieGabineteEquip") != null) {
                equipamento.setNumSerieGabineteEquip(this.resultSet.getString("numSerieGabineteEquip"));
            }

            equipamento.setNumSerieMouseEquip("");
            if (this.resultSet.getString("numSerieMouseEquip") != null) {
                equipamento.setNumSerieMouseEquip(this.resultSet.getString("numSerieMouseEquip"));
            }
            
            equipamento.setNumSerieTecladoEquip("");
            if (this.resultSet.getString("numSerieTecladoEquip") != null) {
                equipamento.setNumSerieTecladoEquip(this.resultSet.getString("numSerieTecladoEquip"));
            }
            
            equipamento.setNumSerieMonitorEquip("");
            if (this.resultSet.getString("numSerieMonitorEquip") != null) {
                equipamento.setNumSerieMonitorEquip(this.resultSet.getString("numSerieMonitorEquip"));
            } 
            
            listaEquipFull.add(equipamento);
        }
        
        this.resultSet.close();
        this.mySqlControle.closeConnection();

        return listaEquipFull;        
    }

   

   
    
}
