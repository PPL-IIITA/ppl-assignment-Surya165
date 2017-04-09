/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem7;

/**
 *
 * @author iiita
 */
public class boy {
    String Name;
    double Attr;
    double Intel;
    double budget;
    String Type;
    double MinAttr;
    double happiness;
    int check(girl g)
    {
        if(g.Maint <= this.budget && g.Attr >= this.MinAttr)
        {
            return 1;
        }
        return 0;
    }
    
}
