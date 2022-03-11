package Model;

import java.util.*;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polinom {
    private List<Monom> polinom = new ArrayList<Monom>();

    public List<Monom> getPolinom()
    {
        return this.polinom;
    }

    public void setPolinom(List<Monom> p)
    {
        this.polinom = p;
    }

    public void add(Monom m)
    {
        polinom.add(m);
    }

    public void fString(String s){
        s=s.replaceAll(" ", "");
        s=s.replaceAll("X", "x");

        String polinom_pattern = "[+-]?[^-+]+" ;  //"\\d*+[\"x\"][\"^\"]\\d+|[+-][\\d^x]+";
        Pattern pattern = Pattern.compile(polinom_pattern);
        Matcher matcher = pattern.matcher(s);

        while(matcher.find()) {
            String c = matcher.group().toString();

            float nr=0; int exp=0;

            if(c.contains("x")) {
                if(c.charAt(0) == '-' && c.charAt(1)=='x') c=c.replaceFirst("-", "-1");
                if(c.charAt(0) == '+' && c.charAt(1)=='x') c=c.replaceFirst("\\+", "+1");
                int iendx = c.indexOf('x');
                int ienda = c.indexOf('^');
                if(iendx != -1 && !c.substring(0, iendx).isEmpty())
                    nr = Float.parseFloat(c.substring(0, iendx));
                else
                    nr = 1;
                if(ienda != -1 && !c.substring(ienda+1, c.length()).isEmpty()) {
                    exp = Integer.parseInt(c.substring(ienda + 1, c.length()));
                }
                else
                    exp = 1;
            }
            else
            {
                nr = Float.parseFloat(c);
            }
            polinom.add(new Monom(nr, exp));
        }
        this.reorder();
    }

    public void reorder()
    {
        Collections.sort(this.polinom);

        for(int i=0; i<polinom.size(); i++)
        {
            for(int j=i+1; j<polinom.size(); j++)
            {
                if(polinom.get(i).getExp() == polinom.get(j).getExp())
                {
                    polinom.get(i).setNr(polinom.get(i).getNr() + polinom.get(j).getNr());
                    polinom.remove(j);
                    j--;
                }
            }
        }
    }

    public String getPolString()
    {
        String rez = "";
        for(Monom m : polinom)
            rez += m.afisareUtil()+"+";
        return rez;
    }

    public void mulScalar(int x)
    {
        for(Monom m: polinom)
        {
            m.setNr(m.getNr() * x);
        }
    }

    public void mulMonom(Monom m)
    {
        for(Monom myMonom: polinom)
        {
            myMonom.setNr(myMonom.getNr()*m.getNr());
            myMonom.setExp(myMonom.getExp()+m.getExp());
        }
    }

    public void getRidOfZero()
    {
        for(int i=0; i<polinom.size(); i++)
        {
            if(polinom.get(i).getNr()==0)
                polinom.remove(i);
        }
    }

    public int getGrad()
    {
        return polinom.get(0).getExp();
    }

    public String getNicePolString()
    {
        String rez = "";
        for(Monom m : polinom)
        {
            if(m.getExp()==0)
                rez += m.getNr()+"+";
            else if((m.getNr()==1.0 || m.getNr()==-1.0) && m.getExp()==0)
                rez+="1+";
            else if(m.getNr()==1.0 || m.getNr()==-1.0)
                rez += "x^"+m.getExp()+"+";
            else
                rez += m.afisareUtil()+"+";
        }
        rez=rez.replaceAll("\\+-", "-");
        int length = rez.length();
        rez = rez.substring(0, length-1);
        return rez;
    }

    public void afisare(){
        for(Monom m: polinom)
        {
            System.out.println(m.afisare());
        }
        System.out.println();
    }
}
