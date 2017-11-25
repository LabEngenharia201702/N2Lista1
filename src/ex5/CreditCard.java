/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex5;

/**
 *
 * @author diego
 */
public class CreditCard {
    private String numero;
    private String titular;
    private String dataExpiracao;
    
    CreditCard(String numero,String dataExpiracao,String titular)
    {
        this.numero=numero;
        this.dataExpiracao=dataExpiracao;
        this.titular=titular;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @return the titular
     */
    public String getTitular() {
        return titular;
    }

    /**
     * @return the dataExpiracao
     */
    public String getDataExpiracao() {
        return dataExpiracao;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @param titular the titular to set
     */
    public void setTitular(String titular) {
        this.titular = titular;
    }

    /**
     * @param dataExpiracao the dataExpiracao to set
     */
    public void setDataExpiracao(String dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }
    
}
