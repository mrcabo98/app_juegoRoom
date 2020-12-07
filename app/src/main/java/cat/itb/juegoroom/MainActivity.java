package cat.itb.juegoroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import cat.itb.juegoroom.database.AppDatabase;
import cat.itb.juegoroom.database.AppRepository;
import cat.itb.juegoroom.database.DAO.PreguntaDAO;
import cat.itb.juegoroom.database.DAO.PuntuacioDAO;
import cat.itb.juegoroom.database.Pregunta;

public class MainActivity extends AppCompatActivity {
    private Button buttonPlay;
    private Button buttonStats;

    private ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>() {{
        add(new Pregunta("Capital de Argentina", "Buenos Aires"));
        add(new Pregunta("Capital de Bélgica", "Bruselas"));
        add(new Pregunta("Capital de Canadá", "Ottawa"));
        add(new Pregunta("Capital de Colombia", "Bogotá"));
        add(new Pregunta("Capital de Croacia", "Zagreb"));
        add(new Pregunta("Capital de España", "Madrid"));
        add(new Pregunta("Capital de Estados Unidos", "Washington"));
        add(new Pregunta("Capital de Grecia", "Atenas"));
        add(new Pregunta("Capital de Honduras", "Tegucigalpa"));
        add(new Pregunta("Capital de Irlanda", "Dublín"));
        add(new Pregunta("Capital de Japón", "Tokio"));
        add(new Pregunta("Capital de Kenia", "Nairobi"));
        add(new Pregunta("Capital de Luxemburgo", "Luxemburgo"));
        add(new Pregunta("Capital de México", "México"));
        add(new Pregunta("Capital de Noruega", "Oslo"));
        add(new Pregunta("Capital de Perú", "Lima"));
        add(new Pregunta("Capital de Ruanda", "Kigali"));
        add(new Pregunta("Capital de Tailandia", "Bangkok"));
        add(new Pregunta("Capital de Túnez", "Túnez"));
        add(new Pregunta("Capital de Zimbabue", "Harare"));
    }};

    static AppDatabase appDatabase;
    static PreguntaDAO preguntaDAO;
    static PuntuacioDAO puntuacioDAO;
    static AppRepository appRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonPlay = findViewById(R.id.buttonPlay);
        buttonStats = findViewById(R.id.buttonStats);
        appDatabase = AppDatabase.getInstance(this.getApplicationContext());
        preguntaDAO = appDatabase.preguntaDAO();
        puntuacioDAO = appDatabase.puntuacioDAO();
        appRepository = new AppRepository(preguntaDAO, puntuacioDAO);

        if (appRepository.totalPreguntas() == 0) {
            generarPreguntas();
        }

        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        buttonStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, MainActivity4.class);
                startActivity(intent2);
            }
        });

    }

    public void generarPreguntas() {
        for (Pregunta p : preguntas) {
            appRepository.insert(p);
        }
    }

}