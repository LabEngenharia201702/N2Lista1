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
public abstract class Factory {
    abstract CreditCard CriarCartao(String numero,String dataExpiracao,String titular);
    
}
