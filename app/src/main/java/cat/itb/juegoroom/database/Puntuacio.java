package cat.itb.juegoroom.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "puntuacio_table")
public class Puntuacio {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_puntuacio")
    private int id_puntuacio;
    private String user_name;
    private int puntuacio;

    public Puntuacio(String user_name, int puntuacio) {
        this.user_name = user_name;
        this.puntuacio = puntuacio;
    }

    public int getId_puntuacio() {
        return id_puntuacio;
    }

    public void setId_puntuacio(int id_puntuacio) {
        this.id_puntuacio = id_puntuacio;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getPuntuacio() {
        return puntuacio;
    }

    public void setPuntuacio(int puntuacio) {
        this.puntuacio = puntuacio;
    }
}
