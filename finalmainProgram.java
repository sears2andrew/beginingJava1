//this program was written by Andrew Sears

import java.util.Scanner;
import static java.lang.System.out;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class finalmainProgram {

   private static String lname = null;					//set variables set and used by diferent methods
   private static String title = null;					
   public static void main(String[] args) throws FileNotFoundException {
      Calendar cal = new GregorianCalendar();			//open calender
      int hour = cal.get(Calendar.HOUR_OF_DAY);		//get the hour of day
      Scanner input = new Scanner(System.in);			//open scanner
      Scanner inputFile = new Scanner(new File("accountData.txt"));	//open file
      out.print("Enter the userid: ");				//ask for id
      String id = input.next();						//take input as id
      out.print("Enter the password: ");				//ask for password
      String userPass = input.next();					//take input as password
      int error = 0, done = 0;						//declair variable for loop and error count
   	
      while(done == 0){								//while done is false
         String line = inputFile.nextLine();			//take in next line of file
         String[] array = new String[5];				//make array for line of file
         array = line.split(" ");					//split up line by each string
         accounts a1 = new accounts(array);			//declar a1
         error = check(array, id, userPass);			//run error count method
         if(error > -1){								//if error count is 0 or 1
            done = 1;								//done is true
            lname = a1.getlname();					//set lname from current line read
            title = a1.gettitle();					//set title from current line read
         }
         else if(inputFile.hasNext());				//if file has next line
         else										//if no currect line found
            done = 1;								//dcone is true
      }
   	
      if (error >= 0){								//if errors returned 0 or 1
         if (error == 1)								//if 1 error
            out.println("Well, you were close - I'll let you in this time...");		//print that there was an error
         if (hour <= 11)								//if hour is before noon
            out.print("Good Morning, ");			//print it is morning
         else										//if after noon
            out.print("Good afternoon, ");			//print it is afternoon
         out.print(title + " " + lname);				//print to user
      }
      else											//if errors returned -1
         out.print("No account with the given userid and password was found");		//print that no account exists
      input.close();									//close scanner
      inputFile.close();								//close file
   }
   public static int check(String[] array, String id, String pass){
      accounts a1 = new accounts(array);				//array data from other class
      int error = 0;									//set error count to 0
      String userid = a1.getuserid();				//get userid from other class
      String password = a1.getpassword();			//get password from other class
      int place = 0;								//set place counter to 0
      int lengthPass = pass.length();				//get pass length
      int lengthPassword = password.length();		//get password length
      int lengthId = id.length();					//get id length
      int lengthUserId = userid.length();			//get userid length
      if(lengthPass == lengthPassword && lengthId == lengthUserId){		//if password and id lengths are equal
         for(int i = lengthPass;i > 0;i--){								//for length of password
            if (Character.valueOf(pass.charAt(place)) != Character.valueOf(password.charAt(place)))	//if character values are not same
               error += 1;						//add 1 to error count
            place++;							//add 1 to place counter for next character comparison
         }
         place = 0;								//reset place counter
         for(int i = lengthId;i > 0;i--){		//for length of id
            if (Character.valueOf(userid.charAt(place)) != Character.valueOf(id.charAt(place)))		//if id character values are not same
               error += 1;						//add one to error count
            place++;							//add 1 to place counter for next character comparison
         }
      }
      else										//if charater counts are not equal
         error = -1;								//set error count to -1
      if (error > 1)								//if error count is over 1
         error = -1;								//set error count to -1
   		
      return error;								//return error count
   }

}
