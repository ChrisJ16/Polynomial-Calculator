package GUI;
import Model.*;
import Logic.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Controller implements  ActionListener{
    private View view;

    private OpPolinom op = new OpPolinom();

    public Controller(View v){
        this.view = v;
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        String s1 = view.getFirstPolinom().getText();
        String s2 = view.getSecondPolinom().getText();
        int ok=1;

        Polinom p1 = new Polinom();p1.fString(s1);
        Polinom p2 = new Polinom();p2.fString(s2);
        Polinom rez = new Polinom();

        switch (command)
        {
            case"Adunare":
                    rez=op.Add(p1,p2);
                break;
            case"Scadere":
                rez=op.Sub(p1,p2);
                break;
            case"Inmultire":
                rez=op.Mul(p1.getPolinom(),p2.getPolinom());
                break;
            case"Impartire":
                List<Polinom> rezDiv = op.Div(p1,p2); ok=0;
                view.getResult().setText("Cat:    " + rezDiv.get(0).getNicePolString() + "      Rest:    " + rezDiv.get(1).getNicePolString());
                break;
            case"Derivare":
                rez=op.Der(p1);
                break;
            case"Integrare":
                rez=op.Ing(p1);
                break;
            case"Exemplu":
                view.getFirstPolinom().setText("x^3 + 2x -5");
                view.getSecondPolinom().setText("-2x^2-4x+8");
                ok=0;
                break;
        }
        if(ok==1)
            view.getResult().setText(rez.getNicePolString());
    }
}
