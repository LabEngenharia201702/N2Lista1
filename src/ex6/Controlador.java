/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex6;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diego
 */
public class Controlador {
    
    List<Componente> componentes= new ArrayList<>();
    FabricaDecoracao fd=new FabricaDecoracao();
    FabricaTicket ft= new FabricaTicket();
    
    public void CriarTicket()
    {
        
    }
    public void ExibirMenu()
    {
        System.out.println("1 - Adicionar Ticket");
        System.out.println("2 - Ver Tickets");
        System.out.println("0 - Sair");
        
    }
    
}
