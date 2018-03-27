import java.util.Scanner;

interface ICommand {
    void execute();
}

class Menu implements ICommand {
    @Override
    public void execute() {
        System.out.println("Hi. I can count the number of the same words in your message and print them to you\n" +
                "Press 'H' or 'help' to call help menu.");
        System.out.print("New command: ");
    }
}

class Help implements ICommand {
    @Override
    public void execute() {
        System.out.println("Help instruction:\n" +
                "A. input text message введення даних;\n" +
                "V. view typed text message;\n" +
                "C. operating with text message(counting the same words);\n" +
                "R. get result;\n" +
                "X. exit program.");
    }
}

class Add implements ICommand{
    private Scanner s = new Scanner(System.in);
    private static String mes = "";

    @Override
    public void execute() {
        System.out.println("Write your text message: ");
        this.mes = s.nextLine();
        System.out.println("Input 'C' to operate with text message or write 'V' to see your data.");
    }

    public String getMes() {
        return mes;
    }
}
class View implements ICommand{
    private static String mes;

    View(String mes){
        this.mes = mes;
    }

    @Override
    public void execute() {
        if(mes == null || mes == "")
            System.out.println("You haven't write your text message yet. Press 'A' to add a text.");
        else
            System.out.println("Your text message: " + mes);
    }
}

class Count {
    private static String mes;
    private static String s[];
    private static int number[];

    Count(String mes) {
        this.mes = mes;
    }
    public void method() {
        if ("".equals(mes))
            System.out.println("You haven't write your text message yet. Press 'A' to add a text.");
        else {
            int k = 0, sp = 1;
            StringBuilder stb = new StringBuilder();
            stb.append("");
            for (int i = 0; i < mes.length(); i++) {
                if (mes.charAt(i) == ' ') {
                    sp++;
                }
            }
            s = new String[sp];
            for (int i = 0; i < mes.length(); i++) {
                if(mes.charAt(i) == ' '){
                    s[k] = stb.toString();
                    stb.replace(0, stb.length(), "");
                    k++;
                } else{
                    stb.append(mes.charAt(i));
                }
            }
            s[k]=stb.toString();
            number = new int[sp];
            for (int i = 0; i < s.length - 1; i++){
                for(int j = i + 1; j <  s.length; j++) {
                    if ("".equals(s[i]))
                        break;
                    else if (s[i].equals(s[j])) {
                        number[i]++;
                        s[j] = "";
                    }
                }
            }
            System.out.println("Operating complete. Input 'R' to see the result.");
        }
    }
 
    public int[] getNumber() {
        return number;
    }
    public String[] getS() {
        return s;
    }
}

class Result implements ICommand {
    private static int number[];
    private static String s[];
    String res[];
    private int k = 0;

    Result() throws Exception {
        try {
            this.s = new Count(new Add().getMes()).getS();
            this.number = new Count(new Add().getMes()).getNumber();
            this.k = s.length;
        } catch (Exception e) {
            System.out.println("You haven't write your text message yet. Press 'A' to add a text.");
        }
    }

    @Override
    public void execute() {
        for (int i = 0; i < k; i++) {
            int m = (20 -(s[i].length() % 20)) + 1;
            if (!("".equals(s[i]))) {
                System.out.print(s[i]);
                while (m != 0) {
                    System.out.print(" ");
                    m--;
                }
                System.out.println((number[i] + 1));
            }
        }
    }
}

class Exit implements ICommand{
    @Override
    public void execute() {
        System.out.println("Your welcome,the program successfully closed");
    }
}

class Other implements ICommand{

    @Override
    public void execute() {
        System.out.println("Incorrect input. Command not find. \n Press 'H' or 'help' to call help menu.");
    }
}

public class TextFind {
    public static void main(String[] args) throws Exception {
        new Menu().execute();
        Scanner s = new Scanner(System.in);
        String line = s.nextLine();
        while(!("X".equals(line))){
            if("H".equals(line) || "help".equals(line))
                new Help().execute();

            else if("A".equals(line))
                new Add().execute();

            else if("V".equals(line))
               new View(new Add().getMes()).execute();

            else if("C".equals(line))
                new Count(new Add().getMes()).method();

            else if("R".equals(line))
                new Result().execute();

            else
                new Other().execute();
            System.out.print("New command: ");
            line = s.nextLine();
        }
        new Exit().execute();
    }
}
