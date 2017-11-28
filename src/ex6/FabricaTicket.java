/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex6;

/**
 *
 * @author diego
 */
public class FabricaTicket implements Fabrica{

    @Override
    public Componente criarComponente(String texto) {
        Componente c=null;
        if("TICKET".equals(texto.toUpperCase()))
            c= new Ticket();
        return c;
    }
    
}
