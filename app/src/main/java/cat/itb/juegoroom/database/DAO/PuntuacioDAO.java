package cat.itb.juegoroom.database.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import cat.itb.juegoroom.database.Puntuacio;

@Dao
public interface PuntuacioDAO {
    @Query("SELECT * FROM puntuacio_table ORDER BY puntuacio DESC")
    List<Puntuacio> getAll();

    @Insert
    void insert(Puntuacio p);

    @Query("DELETE FROM puntuacio_table")
    void deleteAll();

}
