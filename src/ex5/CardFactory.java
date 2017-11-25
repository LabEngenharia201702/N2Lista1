/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex5;

import java.util.Date;

/**
 *
 * @author diego
 */
public class CardFactory extends Factory {
    static private CardFactory instance;
    //Singleton Method
    static CardFactory getInstance()
    {
       if(instance==null)
       {
           instance= new CardFactory();
       }
       return instance;
    }
    /***
     * Retorna um CreditCard com uma instância de uma de suas filhas
     * @param numero
     * @param dataExpiracao
     * @param titular
     * @return 
     */
    @Override
    CreditCard CriarCartao(String numero,String dataExpiracao,String titular)
    {
        CreditCard cartao=null;
        char[] n=numero.toCharArray();
        
        /***
         * A partir do primeiro digito do cartão sabe-se à qual bandeira pertece
         * A seguir qual primeiro digito pertence a qual cartão:
         *      3- American Express
         *      4- Visa
         *      5- MasterCard
         */
        switch(n[0])
        {
            case '3':
                cartao=new AmExCC(numero, dataExpiracao, titular);
                break;
            case '4':
                cartao=new VisaCC(numero, dataExpiracao, titular);
                break;
            case '5':
                cartao=new MasterCC(numero, dataExpiracao, titular);
                break;
        }
        return cartao;
    }


}
