package br.com.go.sistemainventario.modelo;


/**
 *
 * @author oliveira
 */
public class Administrador {

	private int idAdmin;
	private String nomeCompletoAdmin;
	private int matriculaAdmin;
	private String telefoneAdmin;
	private String emailAdmin;
        private char statusAdmin;
        private String senhaAdmin;

    private Administrador(Builder builder) {
        this.idAdmin = builder.idAdmin;
        this.nomeCompletoAdmin = builder.nomeCompletoAdmin;
        this.matriculaAdmin = builder.matriculaAdmin;
        this.telefoneAdmin = builder.telefoneAdmin;
        this.emailAdmin = builder.emailAdmin;
        this.statusAdmin = builder.statusAdmin;
        this.senhaAdmin = builder.senhaAdmin;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getNomeCompletoAdmin() {
        return nomeCompletoAdmin;
    }

    public void setNomeCompletoAdmin(String nomeCompletoAdmin) {
        this.nomeCompletoAdmin = nomeCompletoAdmin;
    }

    public int getMatriculaAdmin() {
        return matriculaAdmin;
    }

    public void setMatriculaAdmin(int matriculaAdmin) {
        this.matriculaAdmin = matriculaAdmin;
    }

    public String getTelefoneAdmin() {
        return telefoneAdmin;
    }

    public void setTelefoneAdmin(String telefoneAdmin) {
        this.telefoneAdmin = telefoneAdmin;
    }

    public String getEmailAdmin() {
        return emailAdmin;
    }

    public void setEmailAdmin(String emailAdmin) {
        this.emailAdmin = emailAdmin;
    }

    public char getStatusAdmin() {
        return statusAdmin;
    }

    public void setStatusAdmin(char statusAdmin) {
        this.statusAdmin = statusAdmin;
    }

    public String getSenhaAdmin() {
        return senhaAdmin;
    }

    public void setSenhaAdmin(String senhaAdmin) {
        this.senhaAdmin = senhaAdmin;
    }

    public static class Builder {
        
        private int idAdmin;
	private String nomeCompletoAdmin;
	private int matriculaAdmin;
	private String telefoneAdmin;
	private String emailAdmin;
        private char statusAdmin;
        private String senhaAdmin;
        
        public Builder idAdmin(int idAdmin) {
            this.idAdmin = idAdmin;
            return this;
        }
        
        public Builder nomeCompletoAdmin(String nomeCompletoAdmin) {
            this.nomeCompletoAdmin = nomeCompletoAdmin;
            return this;
        }
        
        public Builder matriculaAdmin(int matriculaAdmin) {
            this.matriculaAdmin = matriculaAdmin;
            return this;
        }
        
        public Builder telefoneAdmin(String telefoneAdmin) {
            this.telefoneAdmin = telefoneAdmin;
            return this;
        }
        
        public Builder emailAdmin(String emailAdmin) {
            this.emailAdmin = emailAdmin;
            return this;
        }
        
        public Builder statusAdmin(char statusAdmin) {
            this.statusAdmin = statusAdmin;
            return this;
        }
        
        public Builder senhaAdmin(String senhaAdmin) {
            this.senhaAdmin = senhaAdmin;
            return this;
        }
        
        public Administrador contruir() {
            return new Administrador(this);
        }
    }
}
