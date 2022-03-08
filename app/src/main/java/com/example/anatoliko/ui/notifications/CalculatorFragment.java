package com.example.anatoliko.ui.notifications;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.anatoliko.R;

import java.util.concurrent.TimeUnit;

public class CalculatorFragment extends Fragment {

    private CalculatorViewModel calculatorViewModel;

    Button btn;
    Switch s;
    EditText b1,b2,b3,b4;
    RadioButton r1,r2,r3;
    RadioGroup g1;
    TextView t1,t2,t3,t4,res;
    Button results;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        calculatorViewModel =
                ViewModelProviders.of(this).get(CalculatorViewModel.class);
        View root = inflater.inflate(R.layout.fragment_calculator, container, false);

        b1 = root.findViewById(R.id.Bathmos1);
        b2 = root.findViewById(R.id.Bathmos2);
        b3 = root.findViewById(R.id.Bathmos3);
        b4 = root.findViewById(R.id.Bathmos4);

        t1 = root.findViewById(R.id.mathima1);
        t2 = root.findViewById(R.id.mathima2);
        t3 = root.findViewById(R.id.mathima3);
        t4 = root.findViewById(R.id.mathima4);

        res = root.findViewById(R.id.apotelesma);

        s = root.findViewById(R.id.switch1);

        r1 = root.findViewById(R.id.RB1);
        r2 = root.findViewById(R.id.RB2);
        r3 = root.findViewById(R.id.RB3);

        g1 = (RadioGroup) root.findViewById(R.id.rdg);

        g1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                if(checkedId==R.id.RB1)
                {
                    t1.setText("ΑΡΧΑΙΑ");
                    t2.setText("ΙΣΤΟΡΙΑ Κ.");
                    t3.setText("ΚΟΙΝΩΝΙΟΛΟΓΙΑ");
                    t4.setText("ΕΚΘΕΣΗ");
                }
                if(checkedId==R.id.RB2)
                {
                    t1.setText("ΜΑΘΗΜΑΤΙΚΑ Κ.");
                    t2.setText("ΦΥΣΙΚΗ");
                    t3.setText("ΧΗΜΕΙΑ");
                    t4.setText("ΕΚΘΕΣΗ");
                }
                if(checkedId==R.id.RB3)
                {
                    t1.setText("ΒΙΟΛΟΓΙΑ");
                    t2.setText("ΧΗΜΕΙΑ");
                    t3.setText("ΦΥΣΙΚΗ");
                    t4.setText("ΕΚΘΕΣΗ");
                }
                if(checkedId==R.id.RB4)
                {
                    t1.setText("ΜΑΘΗΜΑΤΙΚΑ Κ.");
                    t2.setText("ΑΟΘ");
                    t3.setText("ΑΕΠΠ");
                    t4.setText("ΕΚΘΕΣΗ");
                }
            }
        });

        results = root.findViewById(R.id.btn);
        results.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                boolean temp = true;

                do {
                    if (String.valueOf(b1.getText()).isEmpty() || String.valueOf(b2.getText()).isEmpty() || String.valueOf(b3.getText()).isEmpty() || String.valueOf(b4.getText()).isEmpty()) {
                        temp = false;
                        Toast.makeText(getActivity(), "ΔΕΝ ΕΙΣΗΧΘΗΣΑΝ ΒΑΘΜΟΙ", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    else {
//                    Float[] Bathmoi = new Float[]{new Float(String.valueOf(b1.getText())), new Float(String.valueOf(b2.getText())), new Float(String.valueOf(b3.getText())), new Float(String.valueOf(b4.getText()))};
//                    Float.parseFloat("23.6");
                        Float[] Bathmoi = new Float[4];
//                    new Float(Float.parseFloat(String.valueOf(b1.getText()))), new Float(Float.parseFloat(String.valueOf(b2.getText()))), new Float(Float.parseFloat(String.valueOf(b3.getText()))), new Float(Float.parseFloat(String.valueOf(b4.getText())))
                        float bathmos0 = Float.valueOf(b1.getText().toString());
                        float bathmos1 = Float.valueOf(b2.getText().toString());
                        float bathmos2 = Float.valueOf(b3.getText().toString());
                        float bathmos3 = Float.valueOf(b4.getText().toString());
                        Bathmoi[0] = bathmos0;
                        Bathmoi[1] = bathmos1;
                        Bathmoi[2] = bathmos2;
                        Bathmoi[3] = bathmos3;
//                        System.out.println(Bathmoi);

                        int checker = 3;

                        if (s.isChecked()) {
                            for (int i = 0; i < 4; i++) {
                                if (Bathmoi[i] > 100 || Bathmoi[i] < 0) {
                                    checker = 2;
                                    break;
                                }
                            }
                            if (checker == 2) {
                                Toast.makeText(getActivity(), "ΛΑΘΟΣ ΕΙΣΑΓΩΓΗ ΒΑΘΜΩΝ", Toast.LENGTH_SHORT).show();
                                res.setText("");
                            }else{
//                                Toast.makeText(getActivity(), "ΣΩΣΤΗ ΕΙΣΑΓΩΓΗ ΒΑΘΜΩΝ", Toast.LENGTH_SHORT).show();
                                double r = (Bathmoi[0] * 66 + Bathmoi[1] * 54 + Bathmoi[2] * 40 + Bathmoi[3] * 40);
                                res.setText(String.valueOf(r));
                            }
                            break;

                        } else {
                            for (int i = 0; i < 4; i++) {
                                if (Bathmoi[i] > 20 || Bathmoi[i] < 0){
                                    checker = 2;
                                    break;
                                }
                            }
                            if (checker == 2) {
                                Toast.makeText(getActivity(), "ΛΑΘΟΣ ΕΙΣΑΓΩΓΗ ΒΑΘΜΩΝ", Toast.LENGTH_SHORT).show();
                                res.setText("");
                            }else {
//                                Toast.makeText(getActivity(), "ΣΩΣΤΗ ΕΙΣΑΓΩΓΗ ΒΑΘΜΩΝ", Toast.LENGTH_SHORT).show();
                                double r = (Bathmoi[0] * 5 * 66 + Bathmoi[1] * 5 * 54 + Bathmoi[2] * 5 * 40 + Bathmoi[3] * 5 * 40);
                                res.setText(String.valueOf(r));
                            }
                            break;
                        }
                    }
                } while (temp == true);
            }
        });

        return root;

    }
}

