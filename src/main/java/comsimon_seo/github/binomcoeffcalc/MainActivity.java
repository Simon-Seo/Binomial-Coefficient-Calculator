package comsimon_seo.github.binomcoeffcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button_calculate;
    TextView textView_output;
    EditText editText_int_n, editText_int_k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_calculate = (Button)findViewById(R.id.button_calculate);
        textView_output = (TextView)findViewById(R.id.textView_output);
        editText_int_n = (EditText)findViewById(R.id.editText_int_n);
        editText_int_k = (EditText)findViewById(R.id.editText_int_k);

        button_calculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.button_calculate:
                String string_n = editText_int_n.getText().toString();
                String string_k = editText_int_k.getText().toString();
                int int_n = -1;
                int int_k = 0;

                if (!string_n.equals("")&&!string_k.equals("")) {
                    int_n = Integer.parseInt(string_n);
                    int_k = Integer.parseInt(string_k);
                }

                String string_output;
                if (int_n >= int_k) {
                    int int_nCk = choose(int_n, int_k);
                    string_output = String.valueOf(int_nCk);
                } else {
                    string_output = "0";
                }

                textView_output.setText(string_output);
                break;
        }
    }

    public int choose(int n, int k) {
        if (k == 0) {
            return 1;
        }
        if (k > n/2) {
            return choose(n, n-k);
        }
        return n * choose(n-1, k-1) / k;
    }
}
