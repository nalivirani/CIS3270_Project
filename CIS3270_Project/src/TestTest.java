import java.time.LocalDate;

//import Flight;
public class TestTest {

	public static void main(String[] args) {
		Flight f = new Flight();
		Flight a = new Flight();
		
		LocalDate lc = LocalDate.of(2017, 12, 10);
		a = f.searchFlights("ATL" , "ORD", lc ).get(1);
		System.out.println(a.getfID());
		

	}

}
