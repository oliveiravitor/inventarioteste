package br.com.go.sistemainventario.modelo;

public class RedeConfig {

    private int idEquipamento;
    private String ipRedeConfig;
    private String hostRedeConfig;

    private RedeConfig() {

    }

    private RedeConfig(Builder builder) {
        this.idEquipamento = builder.idEquipamento;
        this.ipRedeConfig = builder.ipRedeConfig;
        this.hostRedeConfig = builder.hostRedeConfig;
    }

    public int getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(int idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    public String getIpRedeConfig() {
        return ipRedeConfig;
    }

    public void setIpRedeConfig(String ipRedeConfig) {
        this.ipRedeConfig = ipRedeConfig;
    }

    public String getHostRedeConfig() {
        return hostRedeConfig;
    }

    public void setHostRedeConfig(String hostRedeConfig) {
        this.hostRedeConfig = hostRedeConfig;
    }

    public static class Builder {

        private int idEquipamento;
        private String ipRedeConfig;
        private String hostRedeConfig;
        
        public Builder idEquipamento(int idEquipamento) {
            this.idEquipamento = idEquipamento;
            return this;
        }
        
        public Builder ipRedeConfig(String ipRedeConfig) {
            this.ipRedeConfig = ipRedeConfig;
            return this;
        }
        
        public Builder hostRedeConfig(String hostRedeConfig) {
            this.hostRedeConfig = hostRedeConfig;
            return this;
            
        }
        
        public RedeConfig construir() {
            return  new RedeConfig(this);
        }
    }
}
