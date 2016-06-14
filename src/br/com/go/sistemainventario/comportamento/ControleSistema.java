/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.sistemainventario.comportamento;

/**
 *
 * @author oliveira
 */
public class ControleSistema {
    
    public static AdministradorControleMysql admnistradorControle() {
        return new AdministradorControleMysql();
    } 
    
    public static EnderecoControleMysql enderecoControle() {
        return new EnderecoControleMysql();
    }
    
    public static FornecedorControleMysql fornecedorControle() {
        return new FornecedorControleMysql();
    }
    
    public static LocalidadeControleMysql localidadeControle() {
        return new LocalidadeControleMysql();
    }
    
    public static UsuarioFinalControleMysql usuarioControle() {
        return  new UsuarioFinalControleMysql();
    }
    
    public static TermoResponsabilidadeControleMysql termoControle() {
        return new TermoResponsabilidadeControleMysql();
    }
    
    public static EquipamentoControleMysql equipamentoControle() {
        return new EquipamentoControleMysql();
    }
    
    public static RedeConfigControleMysql redeConfig() {
        return new RedeConfigControleMysql();
    }
}
