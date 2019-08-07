
public class Validator {
	public static void main(String[] args){}
	
	public static boolean isInt(String str){
		try{
			@SuppressWarnings("unused")
			int num = Integer.parseInt(str);
			return true;
		}catch(NumberFormatException e){
			AlertBox1.display("Please check your input", str + "is not a number");
			return false;
		}
	}
	
	public boolean checkLength(String str){
		return true;
	}
	
	public static int intReturn(String str){
		int month = 0;
		String m = str;
		
		switch (m) {
		
			case "January" : month = 1;
				break;
			
			case "February" : month = 2;
				break;
			
			case "March" : month = 3;
				break;
			
			case "April" : month = 4;
				break;
			
			case "May" : month = 5;
				break;
			
			case "June" : month = 6;
				break;
			
			case "July" : month = 7;
				break;
			
			case "August" : month = 8;
				break;
			
			case "Septemeber" : month = 9;
				break;
			
			case "October" : month = 10;
				break;
			
			case "November" : month = 11;
				break;	
			
			case "December" : month = 12;
				break;
		}
		
		return month;
	}
	
	
	
	

}
