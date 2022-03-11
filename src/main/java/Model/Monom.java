package Model;
import java.util.*;

public class Monom implements  Comparable<Monom>{
    private float nr;
    private int exp;

    public Monom(){};

    public Monom(float a, int b){
        this.nr=a;
        this.exp=b;
    }

    public Monom(Monom m){
        this.nr=m.getNr();
        this.exp=m.getExp();
    }

    public void setNr(float a){
        this.nr=a;
    }

    public void setExp(int a){
        this.exp=a;
    }

    public float getNr(){
        return this.nr;
    }

    public int getExp(){
        return  this.exp;
    }

    @Override
    public int compareTo(Monom o) {
        if(this.exp >= o.exp)
            return -1;
        return 1;
    }

    public String afisare(){
        return this.nr + "*x^" + this.exp;
    }

    public String afisareUtil(){
        return this.nr + "x^" + this.exp;
    }
}
