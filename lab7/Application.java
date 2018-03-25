import java.util.Deque;
import java.util.LinkedList;

public class Application {

 public static double parse (String rpnString) {
        String res = "";
        boolean f = true;
        for (char el : rpnString.toCharArray()) {
            if (el == '.' && f) {
                res+=el;
                f = false;
                continue;
            }else if (Character.isDigit(el)) {
                res+=el;
                continue;
            }throw new RPNParserException();
        }
        return Double.parseDouble(res);
    }

    public static void main(String[] args) {
        if (args == null || args.length == 0 || args[0] == null)
            throw new RPNParserException();

        String[] input = args[0].split(" ");
        LinkedList<Double> steck = new LinkedList<Double>();
        try {
            for (String str : input) {
                if(str.equals("+"))
                    steck.push((steck.pop()+steck.pop()));
                else if(str.equals("*"))
                    steck.push(steck.pop()*steck.pop());
                else if(str.equals("-")) {
                    double a = steck.pop();
                    double b = steck.pop();
                    steck.push(b - a);
                }else if(str.equals("/")) {
                    double a = steck.pop();
                    double b =steck.pop();
                    steck.push(b / a);
                }else
                    steck.push(parse(str));
            }
        }catch (ArithmeticException ex){
            throw new ArithmeticException();
        }catch (Exception e) {
            throw new RPNParserException();
        }
        if (steck.size() > 1)
            throw new RPNParserException();

        Double result = steck.pop();
        if (result.isNaN() || result.isInfinite())//
            throw new ArithmeticException();

        int intresult = result.intValue();
        System.out.println(intresult);
    }
}