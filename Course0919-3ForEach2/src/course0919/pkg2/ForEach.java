/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0919.pkg2;

/**
 *
 * @author Eka
 */
public class ForEach{
    public static void forEach(Interable interable, Function function){
        for (int i=0; i<interable.getLength(); i++){
            function.function(interable.getData());
        }
    }
}
