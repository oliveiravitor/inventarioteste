package br.com.go.sistemainventario.modelo;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author oliveira
 */
public interface EquipamentoControle {

    public abstract boolean cadastrarEquipamento(Equipamento equipamento) throws SQLException;

    public abstract boolean atualizarEquipamento(Equipamento equipamento) throws SQLException;

    public abstract int getUltimoIdCadastradoEquip() throws SQLException;

    public abstract ArrayList listarEquipamento() throws SQLException;

    public abstract Equipamento buscarEquip(int idEquip) throws SQLException;

    public abstract ArrayList listarEquipamentoDisponivel() throws SQLException;

    public abstract ArrayList listarEquipamentoCompleto() throws SQLException;
}
