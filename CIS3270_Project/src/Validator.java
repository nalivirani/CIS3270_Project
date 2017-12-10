
public class Validator {
	public static void main(String[] args){}
	
	public static boolean isInt(String str){
		try{
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
	
	

}
