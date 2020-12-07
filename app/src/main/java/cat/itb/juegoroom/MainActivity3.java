package cat.itb.juegoroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import cat.itb.juegoroom.database.Puntuacio;

public class MainActivity3 extends AppCompatActivity {
    private TextView textView_pregunta;
    private TextView textView_currentQuestion;
    private EditText editText_answer;
    private TextView textView_remainSeconds;
    private TextView textView_totalScore;
    private Button buttonTornar;
    private int contador = 0;
    private int puntuacion = 0;
    String nombre;
    private String respuesta;
    private Integer[] ordenPreguntas = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
    private List<Integer> evitarRepetidas;
    private CountDownTimer countDownTimer;

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

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            nombre = bundle.getString("editText_name");
        } else {
            Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();
        }

        preguntasDiferentes();
        main();

        buttonTornar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.appRepository.insert(new Puntuacio(nombre, puntuacion));
                Intent intent = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    public void preguntasDiferentes() {
        evitarRepetidas = Arrays.asList(ordenPreguntas);
        Collections.shuffle(evitarRepetidas);
    }

    public void main() {
        if (contador < 5) {
            setCountDownTimer();
            mostrarPregunta();
        } else {
            textView_pregunta.setVisibility(View.INVISIBLE);
            textView_currentQuestion.setVisibility(View.INVISIBLE);
            editText_answer.setVisibility(View.INVISIBLE);
            textView_remainSeconds.setVisibility(View.INVISIBLE);
            String totalScore = getString(R.string.totalScore, puntuacion);
            textView_totalScore.setText(totalScore);
            textView_totalScore.setVisibility(View.VISIBLE);
            buttonTornar.setVisibility(View.VISIBLE);
        }
    }

    public void mostrarPregunta() {
        textView_pregunta.setText(MainActivity.appRepository.findById(evitarRepetidas.get(contador)).getEnunciat());
        textView_currentQuestion.setText((contador + 1) + " de 5");
        getPregunta();
    }

    public void getPregunta() {
        editText_answer.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == 66 && event.getAction() == KeyEvent.ACTION_UP) {
                    respuesta = editText_answer.getText().toString();
                    editText_answer.setText("");
                    encontrarRespuesta(respuesta);
                }
                return false;
            }
        });
    }

    public void encontrarRespuesta(String respuesta) {
        if (respuesta.equalsIgnoreCase(MainActivity.appRepository.findById(evitarRepetidas.get(contador)).getResposta())) {
            puntuacion++;
        }
        countDownTimer.cancel();
        aumentarContador();

    }

    public void aumentarContador() {
        contador++;
        main();
    }

    public void setCountDownTimer() {
        countDownTimer = new CountDownTimer(10000, 1000) {
            long timer = 10000;

            @Override
            public void onTick(long millisUntilFinished) {
                textView_remainSeconds.setText("Seconds remaining : " + (((int) millisUntilFinished / 1000) + 1));
            }

            @Override
            public void onFinish() {
                aumentarContador();
            }
        }.start();
    }

}