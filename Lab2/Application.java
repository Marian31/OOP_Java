class Help implements Command{
    @Override
    public void execute() {
        System.out.println("Help executed");
    }
}
class Echo implements Command{
    String x;
    String[] args;
    Echo (String[] args){
        this.args = args;
            x = args[1];
    }
    @Override
    public void execute() {
        System.out.println(x);
    }
}
class Date implements Command{
    @Override
    public void execute() {
        System.out.println(System.currentTimeMillis());
    }
}
class Exit implements Command{
    @Override
    public void execute() {
        System.out.println("Goodbye!");
    }
}
public class Application {
    public static void main(String[] args) {
        if (args != null ){
            int length = args.length;
            if  (length == 1) {
                String first = args[0];
                if ("help".equals(first))
                    new Help().execute();
                else if ("exit".equals(first))
                    new Exit().execute();
                else
                    System.out.println("Error");
            }
            else if( length ==2 ) {
                String first = args[0];
                if ("echo".equals(first))
                    new Echo(args).execute();
                else if ("date".equals(first) && "now".endsWith(args[1]))
                    new Date().execute();
                else
                    System.out.println("Error");
            }
            else
                System.out.println("Error");
        }
        else
            System.out.println("Error");
    }
}
        