import java.util.*;
public class Factors{
     public static void main(String []args){
         Scanner sc = new Scanner(System.in);
         System.out.print("Enter any number : ");
         long num = sc.nextLong();
		 /*System.out.println("want to show how factors (Y/N) : ");
		 String show = sc.next().substring(0,1);
		 boolean b = false;
		 if(show.equalsIgnoreCase("y"))
			b = true;*/
         long s = System.currentTimeMillis();
         long sqrt = Math.round(Math.sqrt(num));
         System.out.println("your number is : " +num);
         
         List<Long> list = new ArrayList<Long>();
         for(long i=1; i<=sqrt; i++){
             if(num%i == 0){
				/*if(b){
					System.out.println(num +" % "+i+" = "+(num%i)+", so "+i +" is factor");
				}*/
                 list.add(i);
				 if(i != sqrt)
					list.add(num/i);
             }/*else{
				if(b){
					System.out.println(num +" % "+i+" = "+(num%i)+", and "+num+" / "+i +" = "+(new Double(num)/i)+" so "+i+" is not factor");
				}
			 }*/
         }
		 long e = System.currentTimeMillis();
         Collections.sort(list);
         System.out.println("list : "+list);
		 System.out.println("number of factors for "+num+" are "+list.size());
         System.out.println("Total time : "+(e-s)+" millisecs");
     }
}
