import java.io.FileNotFoundException;
import java.util.Random;
public class Prac4 {

    private static void makeException(int i) throws FileNotFoundException, UnknownException {
        /*0 NullPointerException
        1 ArrayIndexOutOfBoundsException
        2 -
        4 FileNotFoundException
        else UnknownExceptionException
        If the parameter 2 is given, print out ”No problems”.*/

        switch (i){
            case 0:
                throw new NullPointerException();
            case 1:
                throw new ArrayIndexOutOfBoundsException();
            case 2:
                System.out.println("No Problemo");
                break;
            case 4:
                throw new FileNotFoundException();
            default:
                throw new UnknownException();
        }
    }
    private static void f() {
        /*
         • NullPointerExceptions should be squashed with the rest of the method continuing to execute as
         normal.
         • Any other types of exception, should stop the rest of the method from executing and print out
         the exeception.
         You will be expecting output of:
         No problems
         java.io.FileNotFoundException
         */
        try{
            try{
                makeException(0); //NullPointer
            }catch(NullPointerException e){
            }
        makeException(2); //Print
        makeException(4); //FileNotFoundException
        makeException(2); //Print


        }catch(FileNotFoundException | ArrayIndexOutOfBoundsException | UnknownException e){
            System.out.println(e);

        }
    }


    private static void g(Random r) throws FileNotFoundException, UnknownException{
        try {
            int x = r.nextInt() % 6;
            int y = r.nextInt() % 7;
            makeException(x);
            System.out.println("x=" + x);
            makeException(y);
            System.out.println("y=" + y);
        }catch(NullPointerException | ArrayIndexOutOfBoundsException e){

        }
    }


    private static void h(Random r) throws UnknownException{
        try{
            g(r);
        }catch(FileNotFoundException e){
            System.out.println(e);
        }finally{
            System.out.println("Got there");
        }

    }
    public static void main(String[] args) {
        f();

        Random r=new Random();
        for (int i=0;i<5;++i) {
            try{
                h(r);
            }catch (UnknownException e){
                System.out.println(e);
            }
        }

    }

}
