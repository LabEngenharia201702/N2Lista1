/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author diego
 */
public class Controlador {
    
    List<Componente> componentes= new ArrayList<>();
    FabricaDecoracao fd=new FabricaDecoracao();
    FabricaTicket ft= new FabricaTicket();
    Componente componente;
    
    /***
     * Cria um novo ticket e o adiciona em 'componentes'
     */
    public void CriarTicket()
    {
        componente= ft.criarComponente("ticket");//Cria um Ticket
        
        componente.setTexto(DigitarTexto("ticket"));//Define o texto do ticket
        String tipoDecoracao;
        
        //Adiciona um cabecalho caso o usuário deseje
        tipoDecoracao="cabecalho";
        if(ConfirmarDecoracao(tipoDecoracao))
            AdicionarDecoracao( tipoDecoracao);

        //Adiciona um rodape caso o cliente deseje
        tipoDecoracao="rodape";
        if(ConfirmarDecoracao(tipoDecoracao))
            AdicionarDecoracao( tipoDecoracao);
        
        componentes.add(componente);//Adiciona o novo ticket na lista
        
    }
    
    void VisualizarTickets()
    {
        String separador="---------------------------------------";
        for(Componente c: componentes)
        {
            System.out.println(separador);
            Componente n=c;
            Rodape rodape;
            Cabecalho cabecalho;
            Ticket ticket;
            if(n instanceof Rodape)
            {
                rodape= (Rodape) n;
                n=rodape.getComponente();
            }
            else
                rodape=null;
            if (n instanceof Cabecalho)
            {
                cabecalho=(Cabecalho)n;
                n=cabecalho.getComponente();
            }
            else
            {
                cabecalho=null;
            }
            
            ticket=(Ticket)n;
            System.out.println("Ticket: "+ticket.getTexto());
            if(cabecalho!=null)
            {
                System.out.println("Cabecalho: "+cabecalho.getTexto());
            }
            if(rodape!=null)
            {
                System.out.println("Rodape: "+rodape.getTexto());
            }
        }
        System.out.println(separador);
    }
    /***
     * Mostra o menu das opcoes disponíveis
     */
    public void ExibirMenu()
    {
        System.out.println("1 - Adicionar Ticket");
        System.out.println("2 - Ver Tickets");
        System.out.println("0 - Sair");
        
    }
    
    /***
     * 
     * @param item É necessário saber de onde esse texto é para que sej informado ao usuário
     * @return 
     */
    public String DigitarTexto(String item)
    {
        String texto;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o texto do "+item+" : ");
        texto=scanner.next();
        
        return texto;
    }
    
    /***
     * Pergunta ao usuário se deseja receber uma Decoração do tipoDecoracao 
     * @param tipoDecoracao Informa o tipo da Decoracao
     * @return Retorna true caso a resposta seja afirmativa
     */
    boolean ConfirmarDecoracao(String tipoDecoracao)
    {
        String resposta;
        Scanner scanner= new Scanner(System.in);
        System.out.print("Deseja "+tipoDecoracao+"?[S/N]: ");
        resposta=scanner.next();
        if(resposta.trim().toUpperCase().equals("S"))
            return true;
        return false;
    }
    
    /***
     * 
     * @param c Componente que será decorado
     * @param tipoDecoracao Tipo de decoracao que será adicionada
     */
    private void AdicionarDecoracao(String tipoDecoracao)
    {
        Decoracao decoracao=(Decoracao) fd.criarComponente(tipoDecoracao);// Cria uma nova Decoracao do tipoDecoracao
        decoracao.setComponente(componente); //Faz com que o componente seja decorado
        componente=decoracao;// É alterado a referencia do Componente para a Decoracao porque ela encapsula o COmponente dentro dela, portanto ele não é perdido
        componente.setTexto(DigitarTexto(tipoDecoracao)); //Define o texto que está na nova Decoracao
    }
    
}
