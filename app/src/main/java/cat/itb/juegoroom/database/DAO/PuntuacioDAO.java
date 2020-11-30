package cat.itb.juegoroom.database.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import cat.itb.juegoroom.database.Puntuacio;

@Dao
public interface PuntuacioDAO {

    @Insert
    void insert(Puntuacio p);

    @Query("SELECT * FROM Puntuacio ORDER BY puntuacio DESC")
    List<Puntuacio> getAll();

    @Delete
    void delete(Puntuacio p);

}
