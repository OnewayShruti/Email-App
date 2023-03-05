package Email_Administration_App;

import java.util.Scanner;
import java.util.regex.Pattern;

public class EmailApp {

    Scanner userInput = new Scanner(System.in);
    private String firstname,lastname,department,primaryEmail,password,secondaryEmail,company,email;
    private int mailboxCapacity;

    public EmailApp(String firstname,String lastname){
        this.firstname = firstname;
        this.lastname = lastname;
        this.mailboxCapacity = 500;
        getAllUserdetails();
    }

//  add encapsulation to make it all private

//   GETTERS
    private String getFirstname() {
        System.out.print("Enter firstname : ");
        return userInput.next();
    }

    private String getLastname() {
        System.out.print("Enter lastname : ");
        return userInput.next();
    }

    private String getDepartment() {
        System.out.print("Select a department : \na -> Acounting\nb-> Sales\nc -> IT\nanyother character for no department : ");
        String character = userInput.next();

        switch(character)
        {
            case "a":
            {
                department = "Accounting";
                break;
            }
            case "b":
            {
                department = "Sales";
                break;
            }
            case "c":
            {
                department = "IT";
                break;
            }
            default:
            {
                department = null;
                break;
            }
        }
        return department;
    }
    private String getCompany() {
        System.out.print("Enter company name : ");
        return userInput.next();
    }

//  SETTERS
    private void setFirstname() {
        this.firstname = getFirstname();
    }
    private void setLastname() {
        this.lastname = getLastname();
    }
    private void setCompany() {
        this.company = getCompany();
    }
    private void setDepartment() {
        this.department = getDepartment();
    }
    private void setPrimaryEmail() {
        this.primaryEmail = getPrimaryEmail();
    }
    private void setMailboxCapacity() {
        this.mailboxCapacity = getMailboxCapacity();
    }
    private String getPrimaryEmail() {
        email = emailFormation( firstname,lastname,department,company);
        return email;
    }

    private void setPassword(){
        this.password = randomPasswordGenerator(8);
    }
    private int getMailboxCapacity() {
        System.out.print("Enter mail boc capaity name : ");
        return userInput.nextInt();
    }
    private String randomPasswordGenerator(int passwordLength){
        String passwordCharSet = "QAZWSXEDCRFVTGBYHNUJMIKOLPqazsxedcrfvtgbyhnujmikolp1234567890!@#$%^&*()";
//      decide the included symbols
        char[] charset = new char[passwordLength];
//      create an array of characters
        for (int iterator = 0; iterator < passwordLength; iterator++) {
            int randomIndex = (int)(Math.random() * passwordCharSet.length());
            charset[iterator] = passwordCharSet.charAt(randomIndex);
        }
        return new String(charset);
    }

    private String emailFormation(String firstname , String lastname , String department , String company){
        if(department == null){
             email = firstname + "." + lastname + "@" +  company + "." + "com";
        }
        else {
             email = firstname + "." + lastname + "@" + department + "." + company + "." + "com";
        }
        return email.toLowerCase();
    }
    private boolean emailValidation(){
        email = getPrimaryEmail();
        return Pattern.matches("[a-zA-Z]\\.[a-zA-Z]@[a-zA-Z]\\.[a-zA-Z]\\.com", email);
    }

//   call this method for secondary email
    private void getAllUserdetails(){
//        setFirstname();
//        setLastname();
        setCompany();
        setDepartment();
        setPrimaryEmail();
        setMailboxCapacity();
        setPassword();
        display();
    }
    private void display(){
        System.out.println(" ");
        System.out.println("************************************");
        System.out.println(" ");
        System.out.println("Name : " + firstname + " " + lastname);
        System.out.println("Company : " + company);
        System.out.println("Department : " + department);
        System.out.println("Primary Email : " + primaryEmail);
        System.out.println("Password : " + password);
        System.out.println("Set mailbox capacity : " + mailboxCapacity);
    }
}

//done
// department swicth case
// get all details -> form an email
// set methods
// display methods


//left
// generate password
// form REGEX


// forgot switchcase syntax
// department can be blank -> so matcher string will be generated according to department given or not


//************NOTES ********
// asscessing info through class APIs

// 1. private variables declarations
// 2. constructor -> pass first last names in object itself
// 3. write the seq of steps of what needs to be done in comments
// 4. build one feature from above seq , check if its working then go on to next one
// 5. constructor can be utillzed to call all the other functions from getAllUserdetails()
// 6. keep the methods also private
// 7. set getters & setters as public when you want them to be accessed by object directly
//  else rest all that is not supposed to be modified is private
// 8. write a simple comment explaining what it exectly does

//****** version 2 -> add validation through regular expression

//****** version 3 -> add UI

//****** version 4 -> deploy it somewhere

//****** version 5 -> add to github

//****** version 6 -> write articles on

// 1. getters/setters
// 2. regular expressions

