/*import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class PracticeFiles {
    public static void main(String[] args) throws IOException {
        Student[] myStudents = readFileCreateArray();
        printStudents(myStudents);
    }
    public static Student[] readFileCreateArray() throws IOException{
    Student[] myStudents;
    int studentLength;
    int index = 0;
    String name;
    File aFile = new File("StudentData.txt");
    Scanner inFile = new Scanner(aFile);
    studentLength = inFile.nextInt();
    myStudents = new Student[studentLength];
    while(inFile.hasNext() && index < myStudents.length){
        name = inFile.next();
        Student aStudent = new Student(name);
        for (int i = 0; i < 6; i++){
            aStudent.getGrades().add(inFile.nextDouble());
        }
        myStudents[index] = aStudent;

    }

        return myStudents;
    }



    //for (int i = 1; i < studentLength; i++){

    public static void printStudents(Student[] myStuds) {
        for (int w = 0; w < myStuds.length; w++) {
            System.out.println(myStuds[w]);
        }
    }
}


 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PracticeFiles {

    public static void main(String []args) throws IOException {

        Student[] myStudents = readFileCreateArray();
        printStudents(myStudents);
        addToFile();

    }

    public static Student[] readFileCreateArray() throws IOException {

        Student[] myStudents;
        int studentLength = 0;
        int index = 0;
        String name;
        File aFile = new File("StudentData.txt");
        Scanner inFile = new Scanner(aFile);
        //studentLength = inFile.nextInt();
        //next couple lines goes through to count the amount of lines so it could make an array, then closes the file.
        while(inFile.hasNext()){
            studentLength++;
            inFile.nextLine();
        }
        inFile.close();

        myStudents = new Student[studentLength];
        inFile = new Scanner(aFile);

        while (inFile.hasNext() && index < myStudents.length) {

            name = inFile.next();
            Student aStudent = new Student(name);

            for (int i = 0; i < 6; i++) {

                aStudent.getGrades().add(inFile.nextDouble());
            }

            myStudents[index] = aStudent;
            index++;

        }
        inFile.close();

        return myStudents;
    }

    public static void printStudents(Student[] myStuds) {
        for(int i = 0; i < myStuds.length; i++) {

            System.out.println(myStuds[i]);

        }


    }
    public static void addToFile() throws IOException{
        // put " ,true " so it starts writing to the end, if not it will start at the beginning and erase contents of file
        FileWriter fw = new FileWriter("StudentData.txt", true);
        PrintWriter pw = new PrintWriter(fw);
        Scanner keyboard = new Scanner(System.in);
        String userReply, studentName, record;
        double[] grades;
        String newLine = "\n";
        pw.print(newLine);

        do {
            System.out.println("Please enter the student name: ");
            studentName = keyboard.nextLine();
                    grades = new double[6];
                    for(int i = 0; i < 6; i++){
                        System.out.println("Please enter the grade #" + (i + 1));
                        grades[i] = keyboard.nextDouble();
                        keyboard.nextLine();
                    }
                    record = studentName + " ";
                    for(int j = 0; j < grades.length; j++){
                        record = record + grades[j] + " ";
                    }
                    System.out.println(record);
                    pw.println(record);

            System.out.println("Do you want to add another record");
            userReply = keyboard.nextLine();
        }while (userReply.equalsIgnoreCase("yes"));
        pw.close();

    }
}