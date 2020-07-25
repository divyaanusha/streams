package epam.streams;
import java.util.*;
import java.util.stream.Collectors;

@FunctionalInterface
interface Average
{
	public double calculate(List<Integer> list);
}
interface Palindrome_check
{
	public boolean check(String s);
		
}
class EpamTask
{
	public static void main(String arg[])
	{
		/*   average of the numbers  */
		
		List<Integer> list = Arrays.asList(11,11,1,12);
		
		Average average = (l)->l.stream().mapToInt(i->i).average().getAsDouble();
		
		System.out.println("Average ofintegers : " + average.calculate(list));
		
		
		
		
		/*   filtering string by criteria */
		
		List<String> string = Arrays.asList("anusha","are","epam","all","task","available");
		
		Optional<List<String>> op = Optional.ofNullable(string);
		
		if(op.isPresent())
		{
			System.out.println("Filtering the list gives : "+string.stream()
					.filter(i->i.length()==3)
					.filter(i->i.charAt(0)=='a')
					.collect(Collectors.toList()));
		}
		else
		{
			System.out.println(" gives null pointer exception ");
		}
		
		
		/* filtering palindromes from list */
		
		List<String> p_string = Arrays.asList("vaav","raav","ana","ani");
		
		
		Palindrome_check p_check = (s)->						//functional interface defining using lambda syntax
		{
			String reverse=new StringBuilder(s).reverse().toString();
			
			return(s.equals(reverse));
		};
		
		Optional<List<String> > op_for_palindrome = Optional.ofNullable(p_string);
		
		
		if(op_for_palindrome.isPresent())	
		{
			List<String> result_palindrome_list =
					p_string.stream()
					.filter(i->p_check.check(i))
					.collect(Collectors.toList());
			
			System.out.println("palindromes are : "+result_palindrome_list);
		}
		else	System.out.println("**** no palindromes found ****");
	}
	
}








