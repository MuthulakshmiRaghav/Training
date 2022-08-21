package week1.day1;

public class IsPrime {

	public static void main(String[] args) {
		
	int num=11,i,j=0;
	
	for(i=2;i<num;i++)
	{
	if(num%i==0)
		{
			j++;
			break;
		}
	}
	if(j==0)				
		System.out.println("Prime");
	else
		System.out.println("Not Prime");
	}
}
