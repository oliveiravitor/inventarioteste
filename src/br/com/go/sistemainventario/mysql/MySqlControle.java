package br.com.go.sistemainventario.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author oliveira
 */
public class MySqlControle {

    private static Connection conn;
    private PreparedStatement prepStatement;

    public MySqlControle() {
    }

    public PreparedStatement getPrepStatement() {
        return prepStatement;
    }

    public void setPrepStatement(PreparedStatement prepStatement) {
        this.prepStatement = prepStatement;
    }

    /**
     * Método que cria uma conexão com o banco de dados
     *
     * @return uma conexão com o banco de dados
     * @throws java.sql.SQLException
     */
    public Connection getConnection() throws SQLException {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/inventarioteste", "root", "");
            return conn;
        } catch (ClassNotFoundException ex) {
            throw new SQLException(ex.getMessage());
        }
    }

    /**
     * Método que encerra uma conexão com o banco de dados
     *
     * @throws java.sql.SQLException
     */
    public void closeConnection() throws SQLException {
        MySqlControle.conn.close();
        this.prepStatement.close();
    }

    /**
     *
     * @return @throws java.sql.SQLException
     */
    public boolean executeUpdate() throws SQLException {
        int aux;
        aux = this.prepStatement.executeUpdate();
        return aux > 0;
    }

    /**
     *
     * @return @throws java.sql.SQLException
     */
    public ResultSet executeQuerySelect() throws SQLException {
        return this.prepStatement.executeQuery();
    }
    
    public void excluirRegistro(String SQL) throws SQLException {
        conn = getConnection();
        prepStatement = conn.prepareStatement(SQL);
        prepStatement.executeUpdate(SQL);
        closeConnection();
    }
}