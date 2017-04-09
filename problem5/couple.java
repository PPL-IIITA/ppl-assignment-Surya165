/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem5;
import java.util.Objects;
/**
 *
 * @author ihm2015004
 */

public class couple {
    girl g = new girl();
    boy b = new boy();
    double happiness;
    double compatability;
    double totalPriceSpent;
    couple(girl g,boy b)
    {
        this.g = g;
        this.b = b;
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
    
    
    
    
   
    
    
    int giftAssign(gift[] gifts, double budget,int n)
    {
         int i;

            if(budget < gifts[0].price)
            {
         
                this.totalPriceSpent = gifts[0].price;
                b.budget = gifts[0].price;
                return 1;
            }
            else
            {
                for( i = 0; i < n && budget >= gifts[i].price;i++)
                {

                    b.budget = b.budget - gifts[i].price;
                }
                this.totalPriceSpent = b.budget - budget;
            }

            return i;
    }
    
    
    
    
    
    /**
     * Distributes gifts, and Calculates respective values of happiness and compatiblility
     * Also prints the list of gifts.
     */
    public void computeRelationAttributesAndPrintGifts(gift[] gifts,int n)
    {
        int noGifts,i;
        if(Objects.equals("1",b.Type) || Objects.equals("2", b.Type) )
        {
            noGifts = giftAssign(gifts,g.Maint,n);
       
        }
        else
        {
            noGifts = giftAssign(gifts, b.budget,n);
      
        }
 
        
        
        
        
        
        
//        System.out.println("The gifts are");
//        for ( i = 0 ; i < noGifts - 1 ; i++)
//              System.out.println("\t"+gifts[i].name+" which costs "+"rs." + gifts[i].price + " is 0f type "+ gifts[i].getType());
  //      System.out.print("\n");
        
        
        happiness = this.happiness();
        compatability = this.compatability();
            
    }
    
    
    
    
    
    
    /**
     * Calculates compatibility
     * This function calculates the compatability as the sum of absolute difference 
     * between attractions and intelligence and the remaining money the boy has with him
     */
    public double compatability(){
        
        this.compatability = Math.abs(b.Intel - g.Intel) + Math.abs(b.Attr - g.Attr) + (b.budget - g.Maint);
        return this.compatability;
                
    }
    
    
    
    
    
    
    
    //Calculates happiness
    public double happiness()
        {
 //           System.out.println(this.totalPriceSpent);
             if(Objects.equals(g.Type, new String("1")))
            {

                g.happiness = this.totalPriceSpent;
            }
            
             
             
            else if(Objects.equals(g.Type, new String("2")) )
            {
                g.happiness = Math.pow(2.0,(double)(this.totalPriceSpent));
            }
           
             
             else
            {
                g.happiness= Math.log((double)(this.totalPriceSpent));
            }
             
             
             
         
            
            
            
            //Calculates the happiness of the boy based on his type
            
            
            if(Objects.equals(b.Type, new String("1")))
            {
                b.happiness = b.budget - this.totalPriceSpent;
            }
            
            
            else if (Objects.equals(b.Type, new String("2")))
            {
               b.happiness = g.Intel;
            }
            
            
            else
            {
                b.happiness = g.happiness;
            }
            

            return b.happiness + g.happiness;
            
        }
    
  
}
