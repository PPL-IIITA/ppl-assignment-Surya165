/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem1;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
/**
 *
 * @author iiita
 */
public class Problem1 {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws java.lang.CloneNotSupportedException
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws FileNotFoundException, CloneNotSupportedException, UnsupportedEncodingException {
       int numberOfGirls,i,n,numberOfBoys,numberOfCouples,c;
      
      
      inputCreator input = new inputCreator();
      File file;
      
     
      
    
      file = input.getFile(1);
      Scanner scan = new Scanner(file);
       n =scan.nextInt();
       
       couple[] pair = new couple[n+1];
       girl g[] = new girl[n];
       for(i=0;i<n;i++)
       {
           g[i] = new girl();
           g[i].Name = scan.next();
           g[i].Attr = scan.nextDouble();
           g[i].Intel = scan.nextDouble();
           g[i].Maint = scan.nextDouble();
           g[i].Pref = scan.next();
           g[i].Type = scan.next();
       }
       numberOfGirls = n;
       
       file = input.getFile(2);
       scan = new Scanner(file);
       n = scan.nextInt();
       boy[] b = new boy[n];
       for(i=0;i<n;i++)
       {
          b[i] = new boy();
          b[i].Name = scan.next();
          b[i].Attr= scan.nextDouble();
          b[i].Intel = scan.nextDouble();
          b[i].budget = scan.nextDouble();
          b[i].Type = scan.next();
          b[i].MinAttr = scan.nextDouble();
       }
       //System.out.println(numberOfGirls);
       for ( i = 0,c = 0; i < numberOfGirls; i ++ )
       {
           
          if(g[i].check(b[i]) == 1) {
               if ((b[i].check(g[i])) == 1) {
                   //System.out.println("Checkpoint 1");
                   c ++;
                   pair[c] = new couple(g[i],b[i]);
                  //System.out.println(g[i].Name+" "+b[i].Name);
                   System.out.println(b[i].Name + " and " + g[i].Name +" are couples.");
               }
          }
          numberOfCouples = c;
         }
       
       
    }
    
}
