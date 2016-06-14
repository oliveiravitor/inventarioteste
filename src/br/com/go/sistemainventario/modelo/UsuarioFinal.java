package br.com.go.sistemainventario.modelo;

public class UsuarioFinal {

    private int idUsuarioFinal;
    private String nomeCompletoUsuario;
    private int matriculaUsuario;
    private String emailUsuario;
    private String telefoneUsuario;
    private char statusUsuario;

    private UsuarioFinal() {

    }

    private UsuarioFinal(Builder builder) {
        this.idUsuarioFinal = builder.idUsuarioFinal;
        this.nomeCompletoUsuario = builder.nomeCompletoUsuario;
        this.matriculaUsuario = builder.matriculaUsuario;
        this.emailUsuario = builder.emailUsuario;
        this.telefoneUsuario = builder.telefoneUsuario;
        this.statusUsuario = builder.statusUsuario;
    }

    public int getIdUsuarioFinal() {
        return idUsuarioFinal;
    }

    public void setIdUsuarioFinal(int idUsuarioFinal) {
        this.idUsuarioFinal = idUsuarioFinal;
    }

    public String getNomeCompletoUsuario() {
        return nomeCompletoUsuario;
    }

    public void setNomeCompletoUsuario(String nomeCompletoUsuario) {
        this.nomeCompletoUsuario = nomeCompletoUsuario;
    }

    public int getMatriculaUsuario() {
        return matriculaUsuario;
    }

    public void setMatriculaUsuario(int matriculaUsuario) {
        this.matriculaUsuario = matriculaUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getTelefoneUsuario() {
        return telefoneUsuario;
    }

    public void setTelefoneUsuario(String telefoneUsuario) {
        this.telefoneUsuario = telefoneUsuario;
    }

    public char getStatusUsuario() {
        return statusUsuario;
    }

    public void setStatusUsuario(char statusUsuario) {
        this.statusUsuario = statusUsuario;
    }

    public static class Builder {

        private int idUsuarioFinal;
        private String nomeCompletoUsuario;
        private int matriculaUsuario;
        private String emailUsuario;
        private String telefoneUsuario;
        private char statusUsuario;

        public Builder idUsuarioFinal(int idUsuarioFinal) {
            this.idUsuarioFinal = idUsuarioFinal;
            return this;
        }

        public Builder nomeCompletoUsuario(String nomeCompletoUsuario) {
            this.nomeCompletoUsuario = nomeCompletoUsuario;
            return this;
        }

        public Builder matriculaUsuario(int matriculaUsuario) {
            this.matriculaUsuario = matriculaUsuario;
            return this;
        }

        public Builder emailUsuario(String emailUsuario) {
            this.emailUsuario = emailUsuario;
            return this;
        }

        public Builder telefoneUsuario(String telefoneUsuario) {
            this.telefoneUsuario = telefoneUsuario;
            return this;
        }

        public Builder statusUsuario(char statusUsuario) {
            this.statusUsuario = statusUsuario;
            return this;
        }
        
        public UsuarioFinal construir() {
            return new UsuarioFinal(this);
        }
    }
}
