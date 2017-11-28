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
        char n[]=numero.toCharArray();
        /***
         * A partir do primeiro digito do cartão sabe-se à qual bandeira pertece
         * A seguir como é difinido a qual bandeira pertence determinado cartão
         *      AmericanExpress - O primeiro dígito é 5 e o segundo dígito está no intervalo [1..5].O comprimento é de 16 dígitos.
         *      Visa - O primeiro dígito é 4. O comprimento é 13 ou 16 dígitos.
         *      MasterCard - O primeiro dígito é 5 e o segundo dígito está no intervalo [1..5].O comprimento é de 16 dígitos.
         *      Discover - Os primeiros quatro dígitos são 6011. O comprimento é 16 dígitos.

         */
        int digito2;
        if((numero.substring(0,4).equals("6014")) &&(numero.length()==16))// Discover
        {
            cartao = new DiscoverCC(numero, dataExpiracao, titular);
        }
        if(n[0]=='3' &&((n[1]=='4') || (n[1]=='7')) && numero.length()==15) //American Express
        {
            cartao=new AmExCC(numero, dataExpiracao, titular);
        }
        if(n[0]=='4' &&(numero.length()==13 || numero.length()==16))//Visa
        {
            cartao=new VisaCC(numero, dataExpiracao, titular);
        }
        digito2=Integer.parseInt(n[1]+"");
        if(numero.length()==16 &&(n[0]=='5' &&(digito2>0 && digito2<6))) //MasterCard
        {
            cartao=new MasterCC(numero, dataExpiracao, titular);
        }
        return cartao;
    }


}
