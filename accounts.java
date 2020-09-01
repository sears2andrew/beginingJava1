

public class accounts {
   private String lname= null;			//set variables for multi method use
   private String title= null;			
   private String userid= null;
   private String password= null;
   public accounts(String[] array){	
      this.lname = array[1];			//set last name variable
      this.title = array[2];			//set title variable
      this.userid = array[3];			//set user id variable
      this.password = array[4];		//set password variable
   }
   public String getlname(){			//create return method for last name
      return lname;					//return last name 
   }
   public String gettitle(){			//create return method for title variable
      return title;					//return title
   }
   public String getuserid(){			//create return method for title variable
      return userid;					//return user id
   }
   public String getpassword(){		//create return method for password variable
      return password;				//return password variable
   }
}
