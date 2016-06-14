package br.com.go.sistemainventario.modelo;

/**
 *
 * @author oliveira
 */
public class Fornecedor {

    private int idFornecedor;
    private String nomeContatoFornecedor;
    private String nomeFornecedor;
    private String emailFornecedor;
    private String telefoneFornecedor;
    private Endereco enderecoFornecedor;
    private char statusFornecedor;

    private Fornecedor(Builder builder) {
        this.idFornecedor = builder.idFornecedor;
        this.nomeContatoFornecedor = builder.nomeContatoFornecedor;
        this.nomeFornecedor = builder.nomeFornecedor;
        this.emailFornecedor = builder.emailFornecedor;
        this.telefoneFornecedor = builder.telefoneFornecedor;
        this.enderecoFornecedor = builder.enderecoFornecedor;
        this.statusFornecedor = builder.statusFornecedor;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getNomeContatoFornecedor() {
        return nomeContatoFornecedor;
    }

    public void setNomeContatoFornecedor(String nomeContatoFornecedor) {
        this.nomeContatoFornecedor = nomeContatoFornecedor;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public String getEmailFornecedor() {
        return emailFornecedor;
    }

    public void setEmailFornecedor(String emailFornecedor) {
        this.emailFornecedor = emailFornecedor;
    }

    public String getTelefoneFornecedor() {
        return telefoneFornecedor;
    }

    public void setTelefoneFornecedor(String telefoneFornecedor) {
        this.telefoneFornecedor = telefoneFornecedor;
    }

    public Endereco getEnderecoFornecedor() {
        return enderecoFornecedor;
    }

    public void setEnderecoFornecedor(Endereco enderecoFornecedor) {
        this.enderecoFornecedor = enderecoFornecedor;
    }

    public char getStatusFornecedor() {
        return statusFornecedor;
    }

    public void setStatusFornecedor(char statusFornecedor) {
        this.statusFornecedor = statusFornecedor;
    }

    public static class Builder {

        private int idFornecedor;
        private String nomeContatoFornecedor;
        private String nomeFornecedor;
        private String emailFornecedor;
        private String telefoneFornecedor;
        private Endereco enderecoFornecedor;
        private char statusFornecedor;

        public Builder idFornecedor(int idFornecedor) {
            this.idFornecedor = idFornecedor;
            return this;
        }

        public Builder nomeContatoFornecedor(String nomeContatoFornecedor) {
            this.nomeContatoFornecedor = nomeContatoFornecedor;
            return this;
        }

        public Builder nomeFornecedor(String nomeFornecedor) {
            this.nomeFornecedor = nomeFornecedor;
            return this;
        }

        public Builder emailFornecedor(String emailFornecedor) {
            this.emailFornecedor = emailFornecedor;
            return this;
        }

        public Builder telefoneFornecedor(String telefoneFornecedor) {
            this.telefoneFornecedor = telefoneFornecedor;
            return this;
        }

        public Builder enderecoFornecedor(Endereco enderecoFornecedor) {
            this.enderecoFornecedor = enderecoFornecedor;
            return this;
        }

        public Builder statusFornecedor(char statusFornecedor) {
            this.statusFornecedor = statusFornecedor;
            return this;
        }

        public Fornecedor construir() {
            return new Fornecedor(this);
        }
    }
}
