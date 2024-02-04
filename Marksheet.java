import java.util.*;

public class Marksheet {
    int tamil, english, maths, science, social, total;
    double average;
    String grade = null;
    Scanner sc = null;

    //main method
    public static void main(String[] args) {
        Marksheet ms = new Marksheet();

        while (true) {
            try {
                ms.getInput();
                break;
            }
            catch (InputMismatchException e) {
                System.out.println("Only numbers are valid");
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

//Get marks from the user
    public void getInput() {
        sc = new Scanner(System.in);
        
        tamil = validateMarks("Tamil");
        english = validateMarks("English");
        maths = validateMarks("Mathematics");
        science = validateMarks("Science");
        social = validateMarks("Social Science");

        total = (tamil + english + maths + science + social);
        average = total / 5;

        validateMarks(tamil,english,maths,science,social);
    }

    //validates marks entered is between 0 to 100
    public int validateMarks(String subject) {
        int marks;
        do{
            System.out.print("Enter your " + subject + " marks : ");
            marks = sc.nextInt();
            if(marks < 0 || marks > 100){
                System.out.println("Please enter marks between 0 to 100 ");
            }
        } while(marks < 0 || marks > 100);

        return marks;
        
    }

    //checks whether passed all subjects or not
    public void validateMarks(int tamil, int english, int maths,  int science, int social){
        if (tamil >= 35 && english >= 35 && maths >= 35 && science >= 35 && social >=35){
            printGrade();
        }
        else{
            System.out.println("Re-appear");
        }
    }

    //prints grade
    public void printGrade() {
        
        if(average >= 90 && average <= 100){
            System.out.println("Your grade is : O");
            grade = "O";
        }
        else if ( average >= 80 && average < 90){
            System.out.println("Your grade is : A+");
            grade = "A+";
        }
        else if ( average >= 60 && average < 80){
            System.out.println("Your grade is : A");
            grade = "A";
        }
        else if ( average >= 50 && average < 60){
            System.out.println("Your grade is : B");
            grade = "B";
        }
        else if ( average >= 40 && average < 50){
            System.out.println("Your grade is : C");
            grade = "C";
        }
        else {
            System.out.println("Your grade is : D");
            grade = "D";
        }
        markSheetNeedCheck();
    }
    
    //checks whether user wants marksheet or not
    public void markSheetNeedCheck(){
        sc = new Scanner(System.in);
        System.out.print("Do you need marksheet[Y/n] : ");
        String mSheetNeed = sc.nextLine();
        switch(mSheetNeed){
            case "Y" , "y" -> printMarkSheet();
            case "N" , "n" -> System.exit(0);
            default -> {
                System.out.println("Either press y or n ");
                markSheetNeedCheck();
            }
        }
        sc.close();
    }

    //prints the marksheet
    public void printMarkSheet(){
        System.out.println("---------------------------------");
        System.out.println(String.format("| %-16s | %-7s \t|","SUBJECTS","MARKS"));
        System.out.println("---------------------------------");
        System.out.println(String.format("| %-16s | %-7s \t|","TAMIL",tamil));
        System.out.println(String.format("| %-16s | %-7s \t|","ENGLISH",english));
        System.out.println(String.format("| %-16s | %-7s \t|","MATHEMATICS",maths));
        System.out.println(String.format("| %-16s | %-7s \t|","SCIENCE",science));
        System.out.println(String.format("| %-16s | %-7s \t|","SOCIAL SCIENCE",social));
        System.out.println("---------------------------------");
        System.out.println(String.format("\t\t%s : %s","TOTAL MARKS",total));
        System.out.println(String.format("\t\t%s : %s","OVERALL GRADE",grade));
        System.out.println("---------------------------------");
    }   
}