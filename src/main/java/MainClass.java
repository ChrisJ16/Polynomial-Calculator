import java.util.*;
import javax.swing.*;
import Model.*;
import Logic.*;
import GUI.*;

public class MainClass {

    private static OpPolinom operatie;

    public static void main(String[] args){
        /*
        Monom m = new Monom(1,3);
        Monom n = new Monom();
        Polinom pl = new Polinom();

        System.out.println("hello");
        System.out.println(m.getExp() + " " + m.getNr());


        //String s1 = "-2x^3-x^23+46+6x^3-3+2+x+x^3";"-34x^2 + 3 + x^2-45x+7+x^2";
        String s1 = "x^3 + 2x -5";
        String s2 = "-2x^2-x+8";
        String s3 = "x^4-1";
        Monom m1 = new Monom(-1,2);

        Polinom p1 = new Polinom();
        Polinom p2 = new Polinom();
        Polinom p3 = new Polinom();
        operatie = new OpPolinom();

        p1.fString(s1);
        p2.fString(s2);
        p3.fString(s3);

        //Polinom rez = operatie.Mul(p1.getPolinom(),p2.getPolinom());
        List<Polinom> rezDiv = operatie.Div(p1,p2);

        Polinom rez = operatie.Ing(p1);

        rez.afisare();
        */

        JFrame frame = new View("Calculator de polinoame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
