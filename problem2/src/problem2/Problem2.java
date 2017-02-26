/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem2;
/**
 *
 * @author ihm2015004
 */
import java.util.Scanner;/**To take input*/
import java.io.File;/**For file creation*/
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.lang.Object;
import java.util.Objects;
/**
 *
 * @author iiita
 */
public class Problem2 {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws java.lang.CloneNotSupportedException
     */
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
       
        
      int numberOfGirls,i,n,numberOfBoys,numberOfCouples,c;
      
      inputCreator input = new inputCreator();
      File file;
      
     
      
    
      file = input.getFile(1);
      Scanner scan = new Scanner(file);
       n =scan.nextInt();
      couple[] pair = new couple[n+1];
       
       
       
       
       
       /*This part of code initiates the girls with the input given in the input file girls.
       give input in the following format
       name
       attraction
       intelligence
       maintanenceBudget
       preference
       type
       */
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
       
     
       
       
       
       
       /*This part of code initiates the boys with the input given in the files girls
       give input in the following format
       name
       attraction
       intelligence
       budget
       type
       minimumAttractionRequired
       */
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
       /*This part of code initiates all the gifts with input.The input file is taken from the "gifts" file.
       Enter the number of gifts first.Then enter each gift in the following format.
       type
       if type is luxury then
            difficulty
            luxuryRating
            price
            value
       if type is essential then
            price 
            value
       if type is utility then
            price
            utilityClass
            utilityValue
            value
       */
       
       
       
       
       
       file = input.getFile(3);
       scan = new Scanner (file);
      
       n = scan.nextInt();
       gift[] gifts = new gift[n];
       for ( i = 0; i < n ; i ++ )
       {
           gifts[i] = new gift();
           gifts[i].name = scan.next();
           gifts[i].type = scan.nextInt();
           gifts[i].price = scan.nextDouble();
           /*//this part of code is not neccesary for second question.
           if(Objects.equals(gifts[i].type, new String("luxury")))
           {
              gifts[i].l.difficulty = scan.nextDouble();
              gifts[i].l.luxuryRating = scan.nextDouble();
                gifts[i].l.price = scan.nextDouble();
               gifts[i].l.value = scan.nextDouble();
           }
           else if ( Objects.equals(gifts[i].type, new String("essential")))
           {
               gifts[i].e.price = scan.nextDouble();
             gifts[i].e.value = scan.nextDouble();
           }
           else
           {
               gifts[i].u.price = scan.nextDouble();
               gifts[i].u.utilityClass = scan.nextDouble();
               gifts[i].u.utilityValue = scan.nextDouble();
              gifts[i].u.value = scan.nextDouble();
           }*/
        }
       
       
       
    
            
       //Sorting Gifts
        gift temp = new gift();
        for ( i = 0;i < n; i ++)
        {
            
            for(int j = i + 1; j < n; j ++)
            {
        
                if (gifts[i].price > gifts[j].price)
                {
                    temp = gifts[i];
 
                    gifts[i] = gifts[j];
                    gifts[j] = temp;
                }
              
            }
        }
       
       
       
       
        
        
       numberOfCouples = 0;
       /*This part of the code checks all the pairs and initiates a couple if the pair accept each other.
       No input is required.
       Then it prints the couples so formed.
       */
       for ( i = 0,c = 0; i < g.length; i ++ )
       {
           
          if(g[i].check(b[i]) == 1) {
               if ((b[i].check(g[i])) == 1) {
                   
                  pair[c] = new couple(g[i],b[i]);
                  System.out.println(pair[c].b.Name + " " + pair[c].g.Name);
                  pair[c].computeRelationAttributesAndPrintGifts(gifts, gifts.length);
                
                  c++;
               }
               
          }
          numberOfCouples = c;
         }
 //      System.out.println(numberOfCouples + "check");
       for ( i = 0; i < numberOfCouples; i ++)
       {
  //        System.out.println(pair[i].b.Name + " " + pair[i].g.Name + "check");
       }
       
       
       
       
       
       
       
       
       
       
       
     
       
 //  System.out.println("At sorting couple happiness");
   couple tem = new couple(g[0],b[0]);
 
    for ( i = 0; i < numberOfCouples;i++)
    {
      
        for(int j = i + 1 ; j < numberOfCouples; j ++ )
        {
          
           
            if(pair[i].happiness > pair[j].happiness);
            {
                
                    tem = pair[i];
                    pair[i] = pair[j];
                    pair[j] = tem;
            } 
          
        }
    }
    
    
    
    
    
    
    System.out.println("Enter any number less than "+numberOfCouples);
  //  System.out.println("At couples most happy");
    scan = new Scanner(System.in);
    int k = scan.nextInt();
    
 //10
 System.out.println("the "+ k +" most happy couples");
    if(k < numberOfCouples)
    {
        for ( i= 0; i<k; i++) {
                System.out.println(pair[i].b.Name +" "+pair[i].g.Name);
        }
    }
    
    
          
    /*This part of the code sorts the couples array according the happiness
        
    */
    for ( i = 0; i < numberOfCouples;i++)
    {
        for( int j = i + 1 ; j < numberOfCouples;j++)
        {
            if(pair[i].compatability < pair[j].compatability)
            {
                    tem = pair[i];
                    pair[i] = pair[j];
                    pair[j] = tem;
                    
            } 
            
        }
        
    }






     //This part of code prints the k happiest couples;   
    System.out.println("Enter any number less than "+numberOfCouples);
    k = scan.nextInt();
    if(k < numberOfCouples)
    {
        System.out.println("the "+ k + " most compatible couples");
        }
        for ( i= 0; i<k; i++) {
                System.out.println(pair[i].b.Name + " "  + pair[i].g.Name );
        }
    }
}

       
       
       
    
    