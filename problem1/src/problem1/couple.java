/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem1;
import java.lang.Object;
/**
 *
 * @author iiita
 */
public class couple {
    girl g = new girl();
    boy b = new boy();
    couple(girl g,boy b)
    {
        this.g = g;
        this.b = b;
        
        //System.out.println(g.Name+" "+b.Name);
        //System.out.println(this.g.Name + " "+this.b.Name);
    }
    void name()
    {
        //System.out.println(this.b.Name+ " " + this.g.Name);
    }
    int check()
    {
        if ( 1 == b.check(g) && 1 == g.check(b))
        {
            return 1;
        } 
        else {
        }
        return 0;
    }
}
