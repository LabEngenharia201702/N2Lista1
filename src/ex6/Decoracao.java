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
public abstract class Decoracao extends Componente{
    Componente componente;
    Decoracao(Componente componente)
    {
        this.componente=componente;
    }
    
}
