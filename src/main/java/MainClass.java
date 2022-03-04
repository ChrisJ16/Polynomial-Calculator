import java.util.*;

public class MainClass {
    public static void main(String[] args){
        /*
        Monom m = new Monom(1,3);
        Monom n = new Monom();
        Polinom pl = new Polinom();

        System.out.println("hello");
        System.out.println(m.getExp() + " " + m.getNr());
         */

        String s1 = "x^3 + 3x^2 - 4";
        String s2 = "x^4 - x";

        Polinom p1 = new Polinom();
        Polinom p2 = new Polinom();

        p1.fString(s1);
    }
}
