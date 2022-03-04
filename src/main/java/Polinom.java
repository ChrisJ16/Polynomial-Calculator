import java.util.*;

public class Polinom {
    private List<Monom> polinom = new ArrayList<>();

    public void add(Monom m)
    {
        polinom.add(m);
    }

    public void fString(String s){
        s=s.replaceAll(" ", "");

        StringTokenizer st = new StringTokenizer(s, "x^");
        while(st.hasMoreTokens())
        {
            System.out.println(st.nextToken());
        }
    }

    public void afisare(){
        for(Monom m: polinom)
        {
            System.out.println(m.afisare());
        }
    }
}
