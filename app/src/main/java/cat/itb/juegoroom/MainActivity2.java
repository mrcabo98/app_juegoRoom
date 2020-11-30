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

        editText_name = (EditText) findViewById(R.id.editText_name);
        buttonStart = (Button) findViewById(R.id.buttonStart);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = editText_name.getText().toString();
                if (nombre != null && !nombre.isEmpty()) {
                    Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity2.this, "Error, debes introducir un nombre",Toast.LENGTH_SHORT).show();
                }
            }
        });

//        editText_name.setOnClickListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if (keyCode == 66 && event.getAction() == KeyEvent.ACTION_UP) {
//                    return true;
//                }
//            }
//        });

    }
}