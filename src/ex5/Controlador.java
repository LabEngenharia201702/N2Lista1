/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex5;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diego
 */
public class Controlador {
    private List<CreditCard> cartoes= new ArrayList<>();
    /***
     * Carrega todos os cartoes dentro do arquivo na variavel 'cartoes' desta classe
     */
    void CarregarCartoes()
    {
        List<String> lista=Leitor.listar("cartoes.txt");// Cada linha no arquivo será adicionado na 'lista'
        
        String[] dados;
        CardFactory f= CardFactory.getInstance();
        CreditCard cartao;
        for(String texto:lista)
        {
            dados=texto.split(";");
            cartao=f.CriarCartao(dados[0], dados[1], dados[2]);
            if (cartao!=null)
                cartoes.add(cartao);
            
        }
    }
   
    
    /***
     * Exibe todos os cartões em ordem na tela
     */
    void ExibirCartoes()
    {
        List<String> amex= new ArrayList<>();
        List<String> visa= new ArrayList<>();
        List<String> master= new ArrayList<>();
        List<String> disc= new ArrayList<>();
        String c;
        for(CreditCard cartao:cartoes) //Utilizado para carregar cada cartão em sua lista específica
        {
            c="Número: "+ cartao.getNumero()+"\n";
            c+="Data de Expiração: "+ cartao.getDataExpiracao()+"\n";
            c+="Titular: "+ cartao.getTitular()+"\n";
            if(cartao instanceof AmExCC)
            {
                amex.add(c);
            }else if(cartao instanceof VisaCC)
            {
                visa.add(c);
            }else if(cartao instanceof MasterCC)
            {
                master.add(c);
            }else if(cartao instanceof DiscoverCC)
            {
                disc.add(c);
            }
        }
        
        FormataVisualizacaoCartao("America Express", amex);
        FormataVisualizacaoCartao("Visa", visa);
        FormataVisualizacaoCartao("MasterCard", master);
        FormataVisualizacaoCartao("Discover", disc);        
        
    }
    
    private void FormataVisualizacaoCartao(String visu,List<String> lista)
    {
        System.out.println(visu);
        System.out.println("---------------");
        for(String l:lista)
        {
            System.out.println(l);

        }
    }
    
    
}
