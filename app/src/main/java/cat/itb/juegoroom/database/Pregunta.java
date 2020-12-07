package cat.itb.juegoroom.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "pregunta_table")
public class Pregunta {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_pregunta")
    private int id_pregunta;
    private String enunciat;
    private String resposta;

    public Pregunta(String enunciat, String resposta) {
        this.enunciat = enunciat;
        this.resposta = resposta;
    }

    public int getId_pregunta() {
        return id_pregunta;
    }

    public void setId_pregunta(int id_pregunta) {
        this.id_pregunta = id_pregunta;
    }

    public String getEnunciat() {
        return enunciat;
    }

    public void setEnunciat(String enunciat) {
        this.enunciat = enunciat;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
}
