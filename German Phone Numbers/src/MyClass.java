import java.util.Scanner;
public class MyClass 
{
	public static void main(String[] args) 
	{
		Scanner inp = new Scanner(System.in);
		System.out.print("Enter the Phone numbers: ");
		String givenNumber = inp.nextLine();
		String finalNumber = "";
		
		// STAGE 1 - REMOVES CHARACTERS LIKE (,),- AND ACCEPTS NUMERIC VALUES AND '+' .
		givenNumber = givenNumber.replaceAll("[^+0-9]", ""); 										// Accept only numeric values, removes other symbols like ("-,(,)and spaces")
		System.out.println("STAGE 1 OUTPUT IS " + givenNumber);
		
		// STAGE 2 - CHECKS THE POSITION OF '4' AND REPLACES THE '0' WITH COUNTRY CODE +49 .
		if (givenNumber.substring(1, 2).equals("4") || givenNumber.substring(2, 3).equals("4")) 	// Checks if numeral '4' is in the digit position 1 or 2
			{
				givenNumber = givenNumber.replaceAll("^[0]{1,4}", "+"); 							// Replaces the phone number starting with '0' and maximum of 3 occurrences with '+'
				System.out.println("STAGE 2 OUTPUT IS " + givenNumber);
			} 
		else 
			{
				givenNumber = givenNumber.replaceAll("^[0]{1,4}", "+49"); 							// Replaces the phone number starting with '0' and maximum of 3 occurrences with '+49'
				System.out.println("STAGE 2.1 OUTPUT IS " + givenNumber);

			}

		// STAGE 3 - CHECKS IF THERE IS A '0' FOLLOWED BY THE COUNTRY CODE THEN IT DELETS THAT '0' AND MAKES THE PHONE NUMBER A VALID ONE
		if (givenNumber.substring(3, 4).equals("0")) 												// CHECKS IF THE DIGIT AFTER COUNTRY CODE IS '0'
			{
				givenNumber = givenNumber.replaceAll("[0]{1,3}", ""); // DELETS THAT '0' AND MAKES THE PHONE NUMBER A VALID ONE.
				System.out.println("STAGE 3 OUTPUT IS " + givenNumber);
			}

		// STAGE 4 - DETECTS PHONE NUMBERS THAT ARE NOT MOBILE NUMBERS AND ADDS COUNTRY CODE AS PREFIX
		if (!givenNumber.substring(0, 1).equals("4") && !givenNumber.substring(0, 1).equals("+")) 	// DETECS PHONE NUMBERS THAT ARE NOT MOBILE NUMBERS.
			{

				givenNumber = "+49" + givenNumber; 													// PREFIXES COUNTRY CODE TO THE NUMBER
				System.out.println("STAGE 4 OUTPUT IS " + givenNumber);
			}

		// STAGE 5 -  SEPERATES THE GIVEN PHONE NUMBER INTO STANDARD REPRESENTATION <COUNTRY CODE> <AREA CODE> <NUMBER>
		String a = givenNumber.substring(3, 4);

		if (a.equals("1") && givenNumber.length() > 8) 
			{

			finalNumber = givenNumber.substring(0, 3) + " " + givenNumber.substring(3, 6) + " " + givenNumber.substring(6); // STANDARD REPRESENTATION FOR MOBILE NUMBER
			} 
		else 
			{
			finalNumber = givenNumber.substring(0, 3) + " " + givenNumber.substring(3); 				// STANDARD REPRESENTATION FOR NUMBERS EXCLUDING MOBILE NUMBER
			}

		// STAGE 6 - DISPLAY THE FINAL OUTPUT 
		System.out.println("Final representation of number in <COUNTRY CODE> <AREA CODE> <NUMBER>  = " + finalNumber);

	}

}