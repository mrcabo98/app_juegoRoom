package cat.itb.juegoroom;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    private EditText editText_name;
    private Button buttonStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText_name = findViewById(R.id.editText_name);
        buttonStart = findViewById(R.id.buttonStart);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText_name.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Introduce el nombre!", Toast.LENGTH_SHORT).show();
                } else {
                    String nombre = editText_name.getText().toString();
                    Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                    intent.putExtra("editText_name", nombre);
                    startActivity(intent);
                }
            }
        });
    }
}