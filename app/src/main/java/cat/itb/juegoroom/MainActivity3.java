package cat.itb.juegoroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    private TextView textView_pregunta;
    private TextView textView_currentQuestion;
    private EditText editText_answer;
    private TextView textView_remainSeconds;
    private TextView textView_totalScore;
    private Button buttonTornar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        textView_pregunta = (TextView) findViewById(R.id.textView_pregunta);
        textView_currentQuestion = (TextView) findViewById(R.id.textView_currentQuestion);
        editText_answer = (EditText) findViewById(R.id.editText_answer);
        textView_remainSeconds = (TextView) findViewById(R.id.textView_remainSeconds);
        textView_totalScore = (TextView) findViewById(R.id.textView_totalScore);
        buttonTornar = (Button) findViewById(R.id.buttonTornar);

//        editText_answer.setOnClickListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if (keyCode == 66 && event.getAction() == KeyEvent.ACTION_UP) {
//                    // CORREGIMOS
//                }
//                return false;
//            }
//        });

        buttonTornar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(intent);
            }
        });



    }
}