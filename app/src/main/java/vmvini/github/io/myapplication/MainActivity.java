package vmvini.github.io.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private LinearLayout ll;
    private TableLayout tl;
    private TextView tv;

    private Button bt1;
    private Button bt2;

    private void createColumn(CheckBox cb, TableRow tr, TableRow.LayoutParams trp){
        tr.addView(cb, trp);
    }

    private void createColumn(String col, TableRow tr,  TableRow.LayoutParams trp){
        TextView textView = new TextView(this);
        textView.setText(col);
        textView.setGravity(Gravity.CENTER);
        tr.addView(textView, trp );
    }

    private void createTableRow(int color, CheckBox cb, String col2, TableLayout tl, TableLayout.LayoutParams lp, TableRow.LayoutParams trp){
        TableRow tr = new TableRow(this);
        tr.setBackgroundColor(color);
        createColumn(cb, tr, trp);
        createColumn(col2, tr, trp);
        tl.addView(tr, lp);
    }

    private void createTableRow(int color, String col1, String col2, TableLayout tl, TableLayout.LayoutParams lp, TableRow.LayoutParams trp){
        TableRow tr = new TableRow(this);
        tr.setBackgroundColor(color);
        createColumn(col1, tr, trp);
        createColumn(col2, tr, trp);
        tl.addView(tr, lp);
    }

    private TableLayout createTableLayout(){
        TableLayout.LayoutParams tableLayoutParams = new TableLayout.LayoutParams();
        TableLayout tableLayout = new TableLayout(this);
        tableLayout.setBackgroundColor(Color.GRAY);

        TableRow.LayoutParams tableRowParams = new TableRow.LayoutParams();
        tableRowParams.setMargins(1, 1, 1, 1);
        tableRowParams.weight = 1;

        createTableRow(Color.GRAY, "OK", "Descrição de Tarefas", tableLayout, tableLayoutParams, tableRowParams);


        CheckBox cb = new CheckBox(this);
        createTableRow(Color.WHITE, cb, "Leitura de Texto SObre Android", tableLayout, tableLayoutParams, tableRowParams);


        CheckBox cb2 = new CheckBox(this);
        createTableRow(Color.WHITE, cb2, "Responder QUIZ 1", tableLayout, tableLayoutParams, tableRowParams);

        CheckBox cb3 = new CheckBox(this);
        createTableRow(Color.WHITE, cb3, "Implementar a Prática 1", tableLayout, tableLayoutParams, tableRowParams);




        return tableLayout;

    }


    private void buildLinearLayout(){
        // creating LinearLayout
        ll = new LinearLayout(this);
        // specifying vertical orientation
        ll.setOrientation(LinearLayout.VERTICAL);
        // creating LayoutParams
        LinearLayout.LayoutParams linLayoutParam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        // set LinearLayout as a root element of the screen
        setContentView(ll, linLayoutParam);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        buildLinearLayout();

        tv = new TextView(this);
        tv.setText("HELLO WORLD");
        ll.addView(tv);

        bt1 = new Button(this);
        bt1.setText("ver notas");
        bt1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Context context = getApplicationContext();
                CharSequence text = "Visualizar notas";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });


        bt2 = new Button(this);
        bt2.setText("dashboard");
        bt2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Context context = getApplicationContext();
                CharSequence text = "DASHBOARD";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

        ll.addView(createTableLayout());

        ll.addView(bt1);
        ll.addView(bt2);





    }


}
