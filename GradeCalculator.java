import java.util.Scanner;
import java.util.ArrayList;
public class GradeCalculator {
    public static void main(String[] args){Scanner input= new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> subjects= new ArrayList<String>();
        ArrayList<Double> marks= new ArrayList<Double>();
        double total=0;
        int k=1;

        System.out.println("When you're done entering the marks enter 'done'");
        //String done=scanner.nextLine();
        while (true){
            System.out.println("Enter the name of the subject "+k+": ");
            String subject= scanner.nextLine();
            k++;
            if(subject.equalsIgnoreCase("done") /*|| mark == "done"*/){
                break;
            }
            System.out.println("Enter the marks for "+subject+": ");
            String mark= scanner.nextLine();

            subjects.add(subject);
            marks.add(Double.parseDouble(mark));
        }

        for(int i=0;i<subjects.size();i++){
            total= total+marks.get(i);
            if(marks.get(i)>=90 && marks.get(i)<=100){
                System.out.println(i+1+")"+subjects.get(i)+": "+marks.get(i)+" Grade Symbol: A");
            } else if (marks.get(i)>=80 && marks.get(i)<=89) {
                System.out.println(i+1+")"+subjects.get(i)+": "+marks.get(i)+" Grade Symbol: B");

            } else if (marks.get(i)>=70 && marks.get(i)<=79) {
                System.out.println(i+1+")"+subjects.get(i)+": "+marks.get(i)+" Grade Symbol: C");

            } else if (marks.get(i)>=60 && marks.get(i)<=69) {
                System.out.println(i+1+")"+subjects.get(i)+": "+marks.get(i)+" Grade Symbol: D");

            } else if (marks.get(i)>=50 && marks.get(i)<=59) {
                System.out.println(i+1+")"+subjects.get(i)+": "+marks.get(i)+" Grade Symbol: E");

            }
            else{
                System.out.println(i+1+")"+subjects.get(i)+": "+marks.get(i)+" Grade Symbol: F");

            }
        }
        double average_percent=(total/(100*marks.size()))*100;
        System.out.println("Total marks: "+total);
        System.out.printf("The average percentage: %.2f",average_percent);
    }
}
