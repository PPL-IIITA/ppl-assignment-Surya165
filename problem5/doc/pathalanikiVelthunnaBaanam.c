#include<stdio.h>
#include<unistd.h>
#include<time.h>
#include<stdlib.h>
int main()
{
	time_t t;
	srand((unsigned) time ( &t));
	int i,j,lineNumber,number;
	int a[100];
	a[99] = '*';
	int oscill;
	oscill = 0;
	lineNumber = 1;
	while (1)
	{
	for ( j = 0 ; j < 100; j ++ ) 
	{
		number = rand()%100;
		for (i = 0; i < 100; i ++ )
		{
	//		number = rand()%100;
			if(i != lineNumber && i != 100 - lineNumber && i!= number )
			{
				a[i] = ' ';
			}
			else
			{
				a[i] = '*';
			}
			printf("%c",a[i]);
	
		}
		//sleep(1);
		usleep(30000);
		lineNumber ++;
		printf("\t\tStar Wars");
		printf("\n");
	}
	 for ( j = 0 ; j < 100  ; j ++ )
        {	
		number = rand()%100;
                for (i = 0; i < 100; i ++ )
                {
			
                        if(i != lineNumber  && i != 100 - lineNumber && i != 50 && i != number) 
                        {
                                a[i] = ' ';
				
				
                        }
                        else
                        {
                                a[i] = '*';
                        }
                        printf("%c",a[i]);

                }
		//sleep(1);
		usleep(30000);
		lineNumber--;
		printf("\t\tStar Wars");
		printf("\n");
        }
	}
	
}
