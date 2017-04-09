/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem5;

/**
 *
 * @author iiita
 */
public class girl {
	String Name;
	double Attr;
	double Intel;
	double Maint;
	String Pref;
	String Type;
	double happiness;
	int commited;   
	int check(boy b)
	{   
		if(this.Maint <= b.budget)
		{
			return 1;
		}
		return 0;
	}
}
