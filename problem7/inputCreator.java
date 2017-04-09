/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem7;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author iiita
 */
public class inputCreator {
    Scanner scan = new Scanner(System.in);
//    int n = scan.nextInt();
    String s = System.getProperty("user.dir");
    int girls;
    int boys;
    int k;
    int gifts;
    
    
    
    
    
    Random r = new Random();
    
    
    File getFile(int i) throws FileNotFoundException, UnsupportedEncodingException
    {
       
        File file;
        PrintWriter writer;
        file= new File(s);
        Scanner input;
        switch (i) {
                
            case 1:
                input  = new Scanner(System.in);
                System.out.println("Enter the number of Girls");
                this.girls = input.nextInt();
                file = new File(s+"/girls");
                writer = new PrintWriter(file,"UTF-8");
                writer.println(this.girls);
                for( int j = 0; j < this.girls; j ++ )
                {
                    writer.println("girl"+j+" " + num(5)  + " " + num(5) + " " + num(5) + " " + num(3) + " " + num(3) );
                }
                writer.flush();
                input = new Scanner(file);
     
                break;
            case 2:
                input = new Scanner(System.in);
                System.out.println("Enter the number of boys");
                this.boys = input.nextInt();       
     
                file = new File(s+"/boys");
                writer = new PrintWriter(file,"UTF-8");
                writer.println(this.boys);
                for( int j = 0; j < boys; j ++ )
                {
                  writer.println("boy"+j+ " " + num(5) + " " + num(5) + " " + num(10000) + " " + num(3) + " " + num(5)  );
                }
                writer.flush();
                input  = new Scanner(file);
           
      
                break;
            case 4:
                //
            default:
               
              input = new Scanner(System.in);
                System.out.println("Enter the number of gifts:");
               this.gifts = input.nextInt();       

                file = new File(s+"/gifts");
               
                
                writer = new PrintWriter(file,"UTF-8");
                writer.println(this.gifts);
                for( int j = 0; j < this.gifts; j ++ )
                {
                  writer.println("gift" + j + " " + num(3) +" " +  num(10000) );
                }
                writer.flush();
                input  = new Scanner(file);
                break;
        }
       
        return file;
    }
    
    
    
    
    int  num(int j )
    {
        int i;
        i = r.nextInt();
        i = i % j;
        i = Math.abs(i);
        return i;
    }
    
}
