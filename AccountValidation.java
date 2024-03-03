import java.util.*;

class AccountValidation {
    public Map<String, String> userDataBase = new HashMap<>();
    public static boolean running = true;

    public static void main(String[] args) {
        LoginPage loginPg = new LoginPage();
        loginPg.loginPage();
        Scanner scanner = new Scanner(System.in);
        while (running) {
            System.out.print("Do You want to continue [Y/n] : ");
            String wantToRun = scanner.nextLine();
            switch (wantToRun) {
                case "Y", "y" -> {
                    loginPg.loginPage();
                }
                case "N", "n" -> {
                    running = false;
                    scanner.close();
                }
                default -> {
                    System.err.println("\nEither press Y or n");
                    System.out.println();
                }
            }

        }
    }

}

class LoginPage {
    AccountValidation av = new AccountValidation();
    String username;
    String password;
    public int userChoice;
    static Scanner sc = null;

    // Login page interface
    public void loginPage() {
        System.out.println("------- Login Page -------");
        System.out.println(String.format("|\t%s\t |", "------------"));
        System.out.println(String.format("|\t| %.8s |\t |", "1.SignIn"));
        System.out.println(String.format("|\t%s\t |", "------------"));
        System.out.println(String.format("|\t| %.8s | \t |", "2.SignUp"));
        System.out.println(String.format("|\t%s\t |", "------------"));
        System.out.println("--------------------------");
        loginSelection();
    }

    // sign in or sign up
    public void loginSelection() {
        try {
            System.out.print("Enter Your Choice : ");
            sc = new Scanner(System.in);
            userChoice = sc.nextInt();
            // validates user input
            switch (userChoice) {
                case 1 -> {
                    signIn();
                }
                case 2 -> {
                    signUp();
                }
                default -> {
                    System.err.println("\nPress Either 1 or 2..");
                    System.out.println();
                    loginSelection();
                }
            }
        }
        // catch when user types something other than numbers
        catch (InputMismatchException e) {
            System.err.println("\nNumbers only valid..");
            System.out.println();
            loginSelection();
        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println("Exiting...");
        } finally {
            if (sc == null) {
                sc.close();
            }
        }
    }

    //asks sign in
    public void askSignIn(){
        System.out.print("want to sign in[Y/n] : ");
        String choice = sc.next();
        if((choice.equalsIgnoreCase("Y"))){
            signIn();
        }
        else if(!(choice.equalsIgnoreCase("N"))){
            System.err.println("\nEither press y or n");
            System.out.println();
            askSignIn();
        }
    }

    //sign up method
    public void signUp() {
        try {
            acceptsUserName();
            acceptsPassWord();
            addCredentialsToDB(username,password);
            askSignIn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //sign in method
    public void signIn() {
        String usrname;
        String passwd;
        System.out.print("Enter your username : ");
        usrname = sc.next();
        System.out.print("Enter your password : ");
        passwd = sc.next();
        // checks user exits or not
        if (av.userDataBase.containsKey(usrname)) {
            // validates username and password
            if (av.userDataBase.get(usrname).equals(passwd)) {
                System.out.println("Signed in successfully..");
            } else {
                System.err.println("\nusername and password does not match");
                System.out.println();
                signIn();
            }
        } else {
            System.err.println("\nusername not found");
            System.out.println();
            createAccountIfUsernameNotFound();
        }
    }

    // accepts username if not exits
    public void acceptsUserName() {
        System.out.print("Enter Username : ");
        sc = new Scanner(System.in);
        username = sc.nextLine();
        if (av.userDataBase.containsKey(username)) {
            System.err.println("\nusername already exits");
            System.out.println();
            acceptsUserName();
        }
    }

    // accepts password only if its atleast 4 characters
    public void acceptsPassWord() {
        System.out.print("Enter Password : ");
        password = sc.nextLine();
        if (!(password.length() >= 4)) {
            System.err.println("\npassword must contains alteast 4 characters");
            System.out.println();
            acceptsPassWord();
        }
    }

    // calls signup method if user wants to create a new account
    public void createAccountIfUsernameNotFound() {
        System.out.print("Do you want to create a new account[Y/n] : ");
        String usrChoice = sc.next();
        if (usrChoice.equalsIgnoreCase("Y")) {
            signUp();
        }
        // ensures user enters valid input
        else if (!(usrChoice.equalsIgnoreCase("N"))) {
            System.err.println("\nEither press Y or N ");
            System.out.println();
            createAccountIfUsernameNotFound();
        }
    }

    // add username and password to userDatabase
    public void addCredentialsToDB(String username, String password) {
        av.userDataBase.put(username, password);
        System.out.println("Account created successfully.."); 
    }

    /*     //move view to top
    public void cls(){
        System.out.print("\033[H\033[2J");
    } */
}