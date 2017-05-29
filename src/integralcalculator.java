
import java.util.Scanner;
	
public class integralcalculator {
	static char op;
	static Scanner myScanner;
	
    public static void main(String[]args) {
        char functionKind = functionKind();
        if (functionKind == 'x'){
			System.out.println("You have not entered the right thing please retry");}
        else
        figureOut(functionKind);
    }

    private static char functionKind() {
        myScanner = new Scanner(System.in);
        String input;
        
        System.out.println("Are you entering a polynomial? [Y/N]");
        input = myScanner.nextLine();
        if(input.equalsIgnoreCase("Y")) return 'p';
        if(notNo(input)) return 'x';
        
        System.out.println("Are you entering a trignometric function? [Y/N]");
        input = myScanner.nextLine();
        if(input.equalsIgnoreCase("Y")) return 't';
        if(notNo(input)) return 'x';
        
        System.out.println("Are you entering a logarithmic function? [Y/N]");
        input = myScanner.nextLine();
        if(input.equalsIgnoreCase("Y")) return 'l';
        if(notNo(input)) return 'x';
        
        System.out.println("Are you entering a exponential function? (including natural logarithm) [Y/N]");
        input = myScanner.nextLine();
        if(input.equalsIgnoreCase("Y")) return 'e';
        if(notNo(input)) return 'x';
        
        System.out.println("Sorry. No further options.");
        return 'x';
    }
    
    public static void figureOut(char functionkind) {
        System.out.println("\nPlease enter your integral with the variable x. IE: integral of f(x)dx");
        System.out.println("If you are entering it as an polynomial please enter it like this example. 2x^2+3x-2");
        System.out.println("Please enter your equation: ");
        String integral = myScanner.nextLine();

        System.out.println("Are you looking for the definite integral? If yes type yes. If no type no");
        String defindef = myScanner.next();
        if (defindef.equalsIgnoreCase("no")) {
            if(functionkind == 't'){
                System.out.println(trig(integral));
            }
            else if (functionkind == 'p'){
                System.out.println(polynomial(integral));
            }
            else if (functionkind == 'l'){
                    System.out.println(log(integral));
            }
            else if (functionkind == 'e'){
                    System.out.println(exponetial(integral));
            }
    		else if (functionkind == 'x'){
    			System.out.println("You have not entered the right thing please retry");
        }
        }
        
        else if (defindef.equalsIgnoreCase("yes"))  {
            System.out.println("Please enter the upper limit: ");
            double upperlim = myScanner.nextDouble();

            System.out.println("Please enter the lower limit: ");
            double lowerlim = myScanner.nextDouble();
            
            if(lowerlim!=upperlim) {
                defintegralcalc(integral, upperlim, lowerlim);  
        if(functionkind == 't'){
			System.out.println("The indefinite integral is: " + trig(integral) + " + C");
			System.out.println("The definite integral is: " + defintegralcalc(trig(integral), upperlim, lowerlim));
		}
		else if (functionkind == 'p'){
			System.out.println("The indefinite integral is: " + polynomial(integral) + " + C");
			System.out.println("The definite integral is: " + defintegralcalc(polynomial(integral), upperlim, lowerlim));
		}
		else if (functionkind == 'l'){
			System.out.println("The indefinite integral is: " + log(integral) + " + C");
			System.out.println("The definite integral is: " + defintegralcalc(log(integral), upperlim, lowerlim));
		}
		else if (functionkind == 'e'){
			System.out.println("The indefinite integral is: " + exponetial(integral) + " + C");
			System.out.println("The definite integral is: " + defintegralcalc(exponetial(integral), upperlim, lowerlim));
		}
		else if (functionkind == 'x'){
			System.out.println("You have not entered the right thing please retry");
		}
            }
            else{
                System.out.println("You've entered the same value for the upper and lower limit. Therefore the value of the definit integral is 0");
            }
        }
            
    }
	
    private static boolean notNo(String x){
        if(x.equals("N") || x.equals("n")) {
            System.out.println("Neither yes or no has been entered please restart");
            return false;
        }
        return true;
    }
	

	

	static public String log(String integral){
		String log;
		
		return log;
	}
	
	static public String exponetial(String integral){
		String expo;
		
		return expo;
	}
	
	static public String trig(String integral){
		String trig;
			
		return trig;
	}
	
	static public String polynomial(String integral){
		String poly = "";
		double degree = countOccurrences(integral);
		int start = 0;
		int end =findplace('^', integral,start);
		double coeff = 0;
		int addsub = 0;
		double expon = 0;
		char pm = 'a';
		for(int z = 0; z < degree; z++){
		if(end == -1){
			break;
		}
		end =findplace('^', integral,start);
		coeff = Double.parseDouble(integral.substring(start, end-1));
		start = end +1;
		addsub = findpm(integral,start+1);
		
		if(addsub==-1){
			expon = Double.parseDouble(integral.substring(start, integral.length()));
		}
		else {
			expon = Double.parseDouble(integral.substring(start, addsub));
			pm = integral.charAt(addsub);
		}
		coeff = coeff/expon;
		expon++;
		poly += coeff + "x^" + expon;
		if (addsub!= -1)
			poly += pm;
		start = addsub + 1;
		}
		return poly;
	}
	
	public static int countOccurrences(String integral)
	{
		char x = 'x';
	    int count = 0;
	    for (int i=0; i < integral.length(); i++)
	    {
	        if (integral.charAt(i) == x)
	        {
	             count++;
	        }
	    }
	    return count;
	}
	
	public static int findplace(char y, String integral,int start){
		
		 for (int i=start; i < integral.length(); i++)
		    {
		        if (integral.charAt(i) == y)
		        {
		        	return i;
		        } 
		    }	
		 return -1;
	}
	
	public static int findpm(String integral,int start){
		
		 for (int i=start; i < integral.length(); i++)
		    {
		        if (integral.charAt(i) == '+' || integral.charAt(i) == '-')
		        {
		        	return i;
		        } 
		    }	
		 return -1;
	}
	
	
	
	
	static public double defintegralcalc(String integral, double uplim, double lowlim){
		double degree = countOccurrences(integral);
		int start = 0;
		int end =findplace('^', integral,start);
		double coeff = 0;
		int addsub = 0;
		double expon = 0;
		double answer = 0;
		for(int z = 0; z < degree; z++){
			
		if(end == -1){
			break;
		}
		end =findplace('^', integral,start);
		coeff = Double.parseDouble(integral.substring(start, end-1));
		start = end +1;
		addsub = findpm(integral,start+1);
		
		if(addsub==-1){
			expon = Double.parseDouble(integral.substring(start, integral.length()));
		}
		else {
			expon = Double.parseDouble(integral.substring(start, addsub));
		}
		coeff = coeff/expon;
		expon++;
		answer+=Math.pow((coeff*uplim),expon)-Math.pow((coeff*lowlim),expon);
		start = addsub + 1;
		}
		return answer;
	}
}	
