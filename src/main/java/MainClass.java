import java.util.*;
import Model.*;

public class MainClass {
    public static void main(String[] args){
        /*
        Monom m = new Monom(1,3);
        Monom n = new Monom();
        Polinom pl = new Polinom();

        System.out.println("hello");
        System.out.println(m.getExp() + " " + m.getNr());
         */

        //String s1 = "-2x^3-x^23+46+6x^3-3+2+x+x^3";"-34x^2 + 3 + x^2-45x+7+x^2";
        String s1 = "2x^3 - x^4";
        String s2 = "x^2-45x+7";

        Polinom p1 = new Polinom();

        p1.fString(s1);
        p1.reorder();
        p1.afisare();
    }
}
