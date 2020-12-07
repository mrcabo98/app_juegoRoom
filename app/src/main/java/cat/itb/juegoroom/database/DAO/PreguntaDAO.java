package cat.itb.juegoroom.database.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import cat.itb.juegoroom.database.Pregunta;

@Dao
public interface PreguntaDAO {

    @Query("SELECT * FROM pregunta_table WHERE id_pregunta= :idPregunta")
    Pregunta findById(int idPregunta);

    @Insert
    void Insert(Pregunta p);

    @Query("SELECT COUNT(*) FROM pregunta_table")
    int totalPreguntas();

}
