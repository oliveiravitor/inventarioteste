package br.com.go.sistemainventario.modelo;


/**
 *
 * @author oliveira
 */
public class Endereco {

    private int idEndereco;
    private String logradouroEndereco;
    private String numEndereco;
    private String complementoEndereco;
    private String bairroEndereco;
    private String cidadeEndereco;
    private String cepEndereco;
    private String estadoEndereco;
    private char statusEndereco;
    
    private Endereco() {}    
    
    private Endereco(Builder builder) {
        this.idEndereco = builder.idEndereco;
        this.logradouroEndereco = builder.logradouroEndereco;
        this.numEndereco = builder.numEndereco;
        this.complementoEndereco = builder.complementoEndereco;
        this.bairroEndereco = builder.bairroEndereco;
        this.cidadeEndereco = builder.cidadeEndereco;
        this.cepEndereco = builder.cepEndereco;
        this.estadoEndereco = builder.estadoEndereco;
        this.statusEndereco = builder.statusEndereco;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getLogradouroEndereco() {
        return logradouroEndereco;
    }

    public void setLogradouroEndereco(String LogradouroEndereco) {
        this.logradouroEndereco = LogradouroEndereco;
    }

    public String getNumEndereco() {
        return numEndereco;
    }

    public void setNumEndereco(String numEndereco) {
        this.numEndereco = numEndereco;
    }

    public String getComplementoEndereco() {
        return complementoEndereco;
    }

    public void setComplementoEndereco(String complementoEndereco) {
        this.complementoEndereco = complementoEndereco;
    }

    public String getBairroEndereco() {
        return bairroEndereco;
    }

    public void setBairroEndereco(String bairroEndereco) {
        this.bairroEndereco = bairroEndereco;
    }

    public String getCidadeEndereco() {
        return cidadeEndereco;
    }

    public void setCidadeEndereco(String cidadeEndereco) {
        this.cidadeEndereco = cidadeEndereco;
    }

    public String getCepEndereco() {
        return cepEndereco;
    }

    public void setCepEndereco(String cepEndereco) {
        this.cepEndereco = cepEndereco;
    }

    public String getEstadoEndereco() {
        return estadoEndereco;
    }

    public void setEstadoEndereco(String estadoEndereco) {
        this.estadoEndereco = estadoEndereco;
    }

    public char getStatusEndereco() {
        return statusEndereco;
    }

    public void setStatusEndereco(char statusEndereco) {
        this.statusEndereco = statusEndereco;
    }
    
    @Override
    public String toString() {
        return this.logradouroEndereco + ", "
                + this.numEndereco + " - "
                + this.complementoEndereco + " - "
                + this.bairroEndereco + " - "
                + this.cidadeEndereco + " - "
                + this.cepEndereco + " - "
                + this.estadoEndereco;
    }

    public static class Builder {

        private int idEndereco;
        private String logradouroEndereco;
        private String numEndereco;
        private String complementoEndereco;
        private String bairroEndereco;
        private String cidadeEndereco;
        private String cepEndereco;
        private String estadoEndereco;
        private char statusEndereco;
        
        public Builder idEndereco(int idEndereco) {
            this.idEndereco = idEndereco;
            return this;
        }
        
        public Builder logradouroEndereco(String logradouroEndereco) {
            this.logradouroEndereco = logradouroEndereco;
            return this;
        }
        
        public Builder numEndereco(String numEndereco) {
            this.numEndereco = numEndereco;
            return this;
        }
        
        public Builder complementoEndereco(String complementoEndereco) {
            this.complementoEndereco = complementoEndereco;
            return this;
        }
        
        public Builder bairroEndereco(String bairroEndereco) {
            this.bairroEndereco = bairroEndereco;
            return this;            
        }
        
        public Builder cidadeEndereco(String cidadeEndereco) {
            this.cidadeEndereco = cidadeEndereco;
            return this;
        }
        
        public Builder cepEndereco(String cepEndereco) {
            this.cepEndereco = cepEndereco;
            return this;
        }
        
        public Builder estadoEndereco(String estadoEndereco) {
            this.estadoEndereco = estadoEndereco;
            return this;
        }       
        
        public Builder statusEndereco(char statusEndereco) {
            this.statusEndereco = statusEndereco;
            return this;
        }
        
        public Endereco construir() {
            return new Endereco(this);
        }
    }
}
