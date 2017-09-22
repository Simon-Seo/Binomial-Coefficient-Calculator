package comsimon_seo.github.binomcoeffcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.math.BigInteger;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button_calculate;
    TextView textView_output;
    EditText editText_BigInteger_n, editText_BigInteger_k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_calculate = (Button)findViewById(R.id.button_calculate);
        textView_output = (TextView)findViewById(R.id.textView_output);
        editText_BigInteger_n = (EditText)findViewById(R.id.editText_BigInteger_n);
        editText_BigInteger_k = (EditText)findViewById(R.id.editText_BigInteger_k);

        button_calculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.button_calculate:
                String string_n = editText_BigInteger_n.getText().toString();
                String string_k = editText_BigInteger_k.getText().toString();
                BigInteger BigInteger_n = new BigInteger("-1");
                BigInteger BigInteger_k = BigInteger.ZERO;

                if (!string_n.equals("")&&!string_k.equals("")) {
                    BigInteger_n = new BigInteger(string_n);
                    BigInteger_k = new BigInteger(string_k);
                }

                String string_output;
                if (BigInteger_n.compareTo(BigInteger_k) >= 0) {
                    BigInteger BigInteger_nCk = choose(BigInteger_n, BigInteger_k);
                    string_output = String.valueOf(BigInteger_nCk);
                } else {
                    string_output = "0";
                }

                textView_output.setText(string_output);
                break;
        }
    }

    public BigInteger choose(BigInteger n, BigInteger k) {
        if (k.compareTo(BigInteger.ZERO) == 0) {
            return new BigInteger("1");
        }
        if (k.compareTo(n.divide(new BigInteger("2"))) == 1) {
            return choose(n, n.subtract(k));
        }
        return n.multiply(choose(n.subtract(BigInteger.ONE), k.subtract(BigInteger.ONE))).divide(k);
    }
}
