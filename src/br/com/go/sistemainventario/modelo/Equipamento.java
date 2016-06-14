package br.com.go.sistemainventario.modelo;

import java.util.Date;

/**
 *
 * @author oliveira
 */
public class Equipamento {

    private int idEquip;
    private char tipoEquip;
    private char origemEquip;
    private String modeloEquip;
    private String numSerieEquip;
    private String numSerieGabineteEquip;
    private String numSerieMouseEquip;
    private String numSerieTecladoEquip;
    private String numSerieMonitorEquip;
    private char statusEquip;
    private Date dataEntrada;
    private Date dataDescarte;
    private RedeConfig redeConfig;
    private Localidade localidade;
    private Fornecedor fornecedor;
    private UsuarioFinal usuarioFinal;

    private Equipamento(Builder builder) {
        this.idEquip = builder.idEquip;
        this.tipoEquip = builder.tipoEquip;
        this.origemEquip = builder.origemEquip;
        this.modeloEquip = builder.modeloEquip;
        this.numSerieEquip = builder.numSerieEquip;
        this.numSerieGabineteEquip = builder.numSerieGabineteEquip;
        this.numSerieMonitorEquip = builder.numSerieMonitorEquip;
        this.numSerieMouseEquip = builder.numSerieMouseEquip;
        this.numSerieTecladoEquip = builder.numSerieTecladoEquip;
        this.statusEquip = builder.statusEquip;
        this.dataEntrada = builder.dataEntrada;
        this.dataDescarte = builder.dataDescarte;
        this.redeConfig = builder.redeConfig;
        this.localidade = builder.localidade;
        this.fornecedor = builder.fornecedor;
        this.usuarioFinal = builder.usuarioFinal;
    }

    public int getIdEquip() {
        return idEquip;
    }

    public void setIdEquip(int idEquip) {
        this.idEquip = idEquip;
    }

    public char getTipoEquip() {
        return tipoEquip;
    }

    public void setTipoEquip(char tipoEquip) {
        this.tipoEquip = tipoEquip;
    }

    public char getOrigemEquip() {
        return origemEquip;
    }

    public void setOrigemEquip(char origemEquip) {
        this.origemEquip = origemEquip;
    }

    public String getModeloEquip() {
        return modeloEquip;
    }

    public void setModeloEquip(String modeloEquip) {
        this.modeloEquip = modeloEquip;
    }

    public String getNumSerieEquip() {
        return numSerieEquip;
    }

    public void setNumSerieEquip(String numSerieEquip) {
        this.numSerieEquip = numSerieEquip;
    }

    public String getNumSerieGabineteEquip() {
        return numSerieGabineteEquip;
    }

    public void setNumSerieGabineteEquip(String numSerieGabineteEquip) {
        this.numSerieGabineteEquip = numSerieGabineteEquip;
    }

    public String getNumSerieMouseEquip() {
        return numSerieMouseEquip;
    }

    public void setNumSerieMouseEquip(String numSerieMouseEquip) {
        this.numSerieMouseEquip = numSerieMouseEquip;
    }

    public String getNumSerieTecladoEquip() {
        return numSerieTecladoEquip;
    }

    public void setNumSerieTecladoEquip(String numSerieTecladoEquip) {
        this.numSerieTecladoEquip = numSerieTecladoEquip;
    }

    public String getNumSerieMonitorEquip() {
        return numSerieMonitorEquip;
    }

    public void setNumSerieMonitorEquip(String numSerieMonitorEquip) {
        this.numSerieMonitorEquip = numSerieMonitorEquip;
    }

    public char getStatusEquip() {
        return statusEquip;
    }

    public void setStatusEquip(char StatusEquip) {
        this.statusEquip = StatusEquip;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataDescarte() {
        return dataDescarte;
    }

    public void setDataDescarte(Date dataDescarte) {
        this.dataDescarte = dataDescarte;
    }

    public RedeConfig getRedeConfig() {
        return redeConfig;
    }

    public void setRedeConfig(RedeConfig redeConfig) {
        this.redeConfig = redeConfig;
    }

    public Localidade getLocalidade() {
        return localidade;
    }

    public void setLocalidade(Localidade localidade) {
        this.localidade = localidade;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public UsuarioFinal getUsuarioFinal() {
        return usuarioFinal;
    }

    public void setUsuarioFinal(UsuarioFinal usuarioFinal) {
        this.usuarioFinal = usuarioFinal;
    }

    public static class Builder {

        private int idEquip;
        private char tipoEquip;
        private char origemEquip;
        private String modeloEquip;
        private String numSerieEquip;
        private String numSerieGabineteEquip;
        private String numSerieMouseEquip;
        private String numSerieTecladoEquip;
        private String numSerieMonitorEquip;
        private char statusEquip;
        private Date dataEntrada;
        private Date dataDescarte;
        private RedeConfig redeConfig;
        private Localidade localidade;
        private Fornecedor fornecedor;
        private UsuarioFinal usuarioFinal;

        public Builder idEquip(int idEquip) {
            this.idEquip = idEquip;
            return this;
        }

        public Builder tipoEquip(char tipoEquip) {
            this.tipoEquip = tipoEquip;
            return this;
        }

        public Builder origemEquip(char origemEquip) {
            this.origemEquip = origemEquip;
            return this;
        }

        public Builder modeloEquip(String modeloEquip) {
            this.modeloEquip = modeloEquip;
            return this;
        }

        public Builder numSerieEquip(String numSerieEquip) {
            this.numSerieEquip = numSerieEquip;
            return this;
        }

        public Builder numSerieGabineteEquip(String numSerieGabineteEquip) {
            this.numSerieGabineteEquip = numSerieGabineteEquip;
            return this;
        }

        public Builder numSerieMouseEquip(String numSerieMouseEquip) {
            this.numSerieMouseEquip = numSerieMouseEquip;
            return this;
        }

        public Builder numSerieTecladoEquip(String numSerieTecladoEquip) {
            this.numSerieTecladoEquip = numSerieTecladoEquip;
            return this;
        }
        
        public Builder numSerieMonitorEquip(String numSerieMonitorEquip) {
            this.numSerieMonitorEquip = numSerieMonitorEquip;
            return this;
        }

        public Builder statusEquip(char statusEquip) {
            this.statusEquip = statusEquip;
            return this;
        }
        
        public Builder dataEntrada(Date dataEntrada) {
            this.dataEntrada = dataEntrada;
            return this;
        }
       
        public Builder dataDescarte(Date dataDescarte) {
            this.dataDescarte = dataDescarte;
            return this;
        }
        
        public Builder fornecedor(Fornecedor fornecedor) {
            this.fornecedor = fornecedor;
            return this;
        }

        public Builder usarioFinal(UsuarioFinal usuarioFinal) {
            this.usuarioFinal = usuarioFinal;
            return this;
        }
        
        public Builder localidade(Localidade localidade) {
            this.localidade = localidade;
            return this;
        }
        
        public Equipamento construir() {
            return new Equipamento(this);
        }
    }
}
