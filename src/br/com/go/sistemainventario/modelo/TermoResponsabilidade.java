package br.com.go.sistemainventario.modelo;

import java.util.Date;

public class TermoResponsabilidade {

    private int idTermo;
    private int idEquip;
    private int numTermo;
    private UsuarioFinal usuarioFinal;
    private Date dataInicioTermo;
    private Date dataTerminoTermo;

    private TermoResponsabilidade() {
        
    }

    private TermoResponsabilidade(Builder builder) {
        this.idTermo = builder.idTermo;
        this.idEquip = builder.idEquip;
        this.numTermo = builder.numTermo;
        this.usuarioFinal = builder.usuarioFinal;
        this.dataInicioTermo = builder.dataInicioTermo;
        this.dataTerminoTermo = builder.dataTerminoTermo;
    }

    public int getIdTermo() {
        return idTermo;
    }

    public void setIdTermo(int idTermo) {
        this.idTermo = idTermo;
    }

    public int getIdEquip() {
        return idEquip;
    }

    public void setIdEquip(int idEquip) {
        this.idEquip = idEquip;
    }

    public int getNumTermo() {
        return numTermo;
    }

    public void setNumTermo(int numTermo) {
        this.numTermo = numTermo;
    }

    public UsuarioFinal getUsuarioFinal() {
        return usuarioFinal;
    }

    public void setUsuarioFinal(UsuarioFinal usuarioFinal) {
        this.usuarioFinal = usuarioFinal;
    }

    public Date getDataInicioTermo() {
        return dataInicioTermo;
    }

    public void setDataInicioTermo(Date dataInicioTermo) {
        this.dataInicioTermo = dataInicioTermo;
    }

    public Date getDataTerminoTermo() {
        return dataTerminoTermo;
    }

    public void setDataTerminoTermo(Date dataTerminoTermo) {
        this.dataTerminoTermo = dataTerminoTermo;
    }

    public static class Builder {

        private int idTermo;
        private int idEquip;
        private int numTermo;
        private UsuarioFinal usuarioFinal;
        private Date dataInicioTermo;
        private Date dataTerminoTermo;

        public Builder idTermo(int idTermo) {
            this.idTermo = idTermo;
            return this;
        }
        
        public Builder idEquip(int idEquip) {
            this.idEquip = idEquip;
            return this;
        }
        
        public Builder numTermo(int numTermo) {
            this.numTermo = numTermo;
            return this;
        }

        public Builder usuarioFinal(UsuarioFinal usuarioFinal) {
            this.usuarioFinal = usuarioFinal;
            return this;
        }

        public Builder dataInicioTermo(Date dataInicioTermo) {
            this.dataInicioTermo = dataInicioTermo;
            return this;
        }

        public Builder dataTerminoTermo(Date dataTerminoTermo) {
            this.dataTerminoTermo = dataTerminoTermo;
            return this;
        }

        public TermoResponsabilidade construir() {
            return new TermoResponsabilidade(this);
        }
    }
}
