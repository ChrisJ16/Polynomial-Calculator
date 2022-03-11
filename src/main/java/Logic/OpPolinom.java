package Logic;

import Model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OpPolinom {

    public Polinom Add(Polinom p1, Polinom p2)
    {
        Polinom rez = new Polinom();
        rez.fString(p1.getPolString() + "+" + p2.getPolString());
        return rez;
    }

    public Polinom Sub(Polinom p1, Polinom p2)
    {
        Polinom rez = new Polinom();
        p2.mulScalar(-1);
        rez.fString(p1.getPolString() + "+" + p2.getPolString());
        return rez;
    }

    public  Polinom Mul(List<Monom> p1, List<Monom> p2)
    {
        Polinom rez = new Polinom();

        for(Monom m: p1)
        {
            for(Monom n: p2)
            {
                rez.add(new Monom(m.getNr() * n.getNr(), m.getExp() + n.getExp()));
            }
        }
        return rez;
    }

    public List<Polinom> Div(Polinom p1, Polinom p2)
    {
        List<Polinom> rez = new ArrayList<>();
        OpPolinom op = new OpPolinom();
        Polinom quit = new Polinom();
        Polinom emptyPol = new Polinom();

        while(p1.getPolinom().size() != 0 && p1.getGrad()>=p2.getGrad())
        {
            Monom i = p2.getPolinom().get(0); //monmul constant din impartitor
            Monom j = new Monom(p1.getPolinom().get(0));
            Polinom iter = new Polinom();
            if(j.getExp() >= i.getExp())
            {
                Monom iterM = new Monom(0,0);
                iterM.setNr(j.getNr()/i.getNr());
                iterM.setExp(j.getExp() - i.getExp());
                iter.getPolinom().add(iterM);
            }
            else break;
            Polinom aux = op.Mul(p2.getPolinom(), iter.getPolinom());
            aux = op.Sub(emptyPol, aux);
            quit = op.Add(quit, iter);
            p1 = op.Add(p1, aux);
            p1.getRidOfZero();
        }
        rez.add(quit); rez.add(p1);
        return rez;
    }

    public Polinom Der(Polinom p)
    {
        int coef=1;

        for(Monom m : p.getPolinom())
        {
            coef = m.getExp();
            m.setNr(m.getNr() * coef);
            m.setExp(coef-1);
        }
        p.getRidOfZero();

        return p;
    }

    public Polinom Ing(Polinom p)
    {
        float coef=0;
        int exp=0;
        Polinom rez = new Polinom();

        for(Monom m: p.getPolinom())
        {
            coef=m.getNr();
            exp=m.getExp()+1;
            rez.add(new Monom(coef/exp, exp));
        }
        return rez;
    }
}
