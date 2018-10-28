package jp.techacademy.naoto.tsunogai.calcapp;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.math.BigDecimal;
import android.support.design.widget.Snackbar;
import java.lang.String;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText  = (EditText) findViewById(R.id.editText) ;
        editText2 = (EditText) findViewById(R.id.editText2);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String s1 = editText.getText().toString();
        String s2 = editText2.getText().toString();

        if (s1.equals("") ||  s2.equals("")) {
            Snackbar.make(v,"数値を入力してください", Snackbar.LENGTH_INDEFINITE)
                    .setAction("OK", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Log.d("UI-PARTS", "OKをタップした");
                        }
                    }).show();
        }else {
            BigDecimal bd1 = new BigDecimal(s1);
            BigDecimal bd2 = new BigDecimal(s2);
            BigDecimal value = new BigDecimal(0);

            if (v.getId() == R.id.button1) {
                value = bd1.add(bd2);
            }else if (v.getId() == R.id.button2) {
                value = bd1.subtract(bd2);
            }else if (v.getId() == R.id.button3) {
                value = bd1.multiply(bd2);
            }else if (v.getId() == R.id.button4) {
                value = bd1.divide(bd1,5);
            }

            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("RESULT",value);

            startActivity(intent);

        }
    }

}