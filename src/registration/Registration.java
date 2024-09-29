package registration;

import java.util.Scanner;

public class Registration {

    String User;
    String Pass;
    String userName;
    String userLast;
    String user;
    String pass;
    Scanner input = new Scanner(System.in); 

    // Method to check if username is correctly formatted
    public boolean checkUsername(){
        boolean Username=false;
        for(int i=0; i<User.length(); i++){
            if(User.length() <=5){
                if((int)User.charAt(i) ==95)
                    Username=true;
            }
        }
        return Username;
    }

    // Method to check if password meets complexity requirements
    public boolean checkPasswordComplexity(){
        boolean Number =false;
        boolean Special=false;
        boolean Letters=false;  

        for(int i=0; i<Pass.length(); i++){
            if(Pass.length() >= 8){ 
                if((int)Pass.charAt(i) >=65 &&(int)Pass.charAt(i) <=90) {
                    Letters=true;
                }  
                if((int)Pass.charAt(i) >=48 &&(int)Pass.charAt(i) <=57){
                    Number=true;
                }          
                if((int)Pass.charAt(i) >=33 &&(int)Pass.charAt(i) <=47 || (int)Pass.charAt(i) >=58 &&(int)Pass.charAt(i) <=64 || (int)Pass.charAt(i) >=91 &&(int)Pass.charAt(i) <=96 || (int)Pass.charAt(i) >=123 &&(int)Pass.charAt(i) <=126)   
                    Special=true;
            }
        }
        return Letters && Number && Special;
    }

    // Method to register a user
    public String registerUser(){
        boolean validUsername = false;
        boolean validPassword = false;

        // Continuously prompt for username and password until they are valid
        while (!validUsername || !validPassword) {
            if(checkUsername()){
                System.out.println("Username successfully captured");
                validUsername = true;
            } else {
                System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length");
                System.out.println("Enter your username again:");
                User = input.next();
            }

            if(checkPasswordComplexity()){
                System.out.println("Password successfully captured");
                validPassword = true;
            } else {
                System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character");
                System.out.println("Enter your password again:");
                Pass = input.next();
            }
        }

        System.out.println("The username and password meet the complexity requirements. The user has been registered successfully.");
        return "User registered successfully.";
    }

    // Method to check if login credentials are correct
    public boolean loginUser(){
        boolean login=false;

        if(user.equals(User) && (pass.equals(Pass))){
            login=true;
        }
        return login;
    }

    // Method to return login status
    String returnLoginStatus(){
        if(loginUser()==true) {
            System.out.println("Successful Login");
            System.out.println("Welcome " +" "+ userName +" "+ userLast +" " + " It is great to see you again " );
        } else {
            System.out.println("Failed Login"); 
            System.out.println("Username or Password incorrect, please try again");    
        }  
        return "";
    } 

    public static void main(String[] args) {
        Registration Acc = new Registration();
        Scanner input = new Scanner(System.in); // Added Scanner instantiation
        boolean loggedIn = false;

        System.out.println("Enter your username");
        Acc.User = Acc.input.next();
        System.out.println("Enter your password");
        Acc.Pass = Acc.input.next();
        System.out.println("Enter your firstName");
        Acc.userName = Acc.input.next();
        System.out.println("Enter your lastName");
        Acc.userLast = Acc.input.next();
        System.out.println(Acc.registerUser());

        if (Acc.checkUsername() && Acc.checkPasswordComplexity()) {
            while (!loggedIn) {
                System.out.println("Enter your username");
                Acc.user = Acc.input.next();
                System.out.println("Enter your password");
                Acc.pass = Acc.input.next();
                if (Acc.loginUser()) {
                    System.out.println(Acc.returnLoginStatus());
                    loggedIn = true;
                } else {
                    System.out.println("Failed Login");
                    System.out.println("Username or Password incorrect, please try again");
                }
            }
        }
    }
}
