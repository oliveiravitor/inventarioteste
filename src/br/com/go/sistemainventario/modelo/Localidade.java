package br.com.go.sistemainventario.modelo;

/**
 *
 * @author oliveira
 */
public class Localidade {

    private int idLocalidade;
    private String identificacaoLocal;
    private String setorLocal;
    private Endereco enderecoLocalidade;
    private char statusLocalidade;

    private Localidade(Builder builder) {
        this.idLocalidade = builder.idLocalidade;
        this.identificacaoLocal = builder.identificacaoLocal;
        this.setorLocal = builder.setorLocal;
        this.enderecoLocalidade = builder.enderecoLocalidade;
        this.statusLocalidade = builder.statusLocalidade;
    }

    private Localidade() {

    }

    public int getIdLocalidade() {
        return idLocalidade;
    }

    public void setIdLocalidade(int idLocalidade) {
        this.idLocalidade = idLocalidade;
    }

    public String getIdentificacaoLocal() {
        return identificacaoLocal;
    }

    public void setIdentificacaoLocal(String identificacaoLocal) {
        this.identificacaoLocal = identificacaoLocal;
    }

    public String getSetorLocal() {
        return setorLocal;
    }

    public void setSetorLocal(String setorLocal) {
        this.setorLocal = setorLocal;
    }

    public Endereco getEnderecoLocalidade() {
        return enderecoLocalidade;
    }

    public void setEnderecoLocalidade(Endereco enderecoLocalidade) {
        this.enderecoLocalidade = enderecoLocalidade;
    }

    public char getStatusLocalidade() {
        return statusLocalidade;
    }

    public void setStatusLocalidade(char statusLocalidade) {
        this.statusLocalidade = statusLocalidade;
    }
       
    public static class Builder {

        private int idLocalidade;
        private String identificacaoLocal;
        private String setorLocal;
        private Endereco enderecoLocalidade;
        private char statusLocalidade;
        
        public Builder idLocalidade(int idLocalidade) {
            this.idLocalidade = idLocalidade;
            return this;
        }
        
        public Builder identificacaoLocal(String identificacaoLocal) {
            this.identificacaoLocal = identificacaoLocal;
            return this;
        }
        
        public Builder setorLocal(String setorLocal) {
            this.setorLocal = setorLocal;
            return this;
        }
        
        public Builder enderecoLocalidade(Endereco enderecoLocalidade) {
            this.enderecoLocalidade = enderecoLocalidade;
            return this;
        }
        
        public Builder statusLocalidade(char statusLocalidade) {
            this.statusLocalidade = statusLocalidade;
            return this;
        }
        
        public Localidade construir() {
            return new Localidade(this);
        }
    }
}
