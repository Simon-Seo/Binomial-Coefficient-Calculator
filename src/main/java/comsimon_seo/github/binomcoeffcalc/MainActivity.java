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
    }
}
