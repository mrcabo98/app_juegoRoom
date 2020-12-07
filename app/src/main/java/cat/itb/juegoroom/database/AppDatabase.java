package cat.itb.juegoroom.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import cat.itb.juegoroom.database.DAO.PreguntaDAO;
import cat.itb.juegoroom.database.DAO.PuntuacioDAO;

@Database(entities = {Pregunta.class, Puntuacio.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public static AppDatabase INSTANCE;

    public abstract PreguntaDAO preguntaDAO();

    public abstract PuntuacioDAO puntuacioDAO();

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, AppDatabase.class, "juego.db")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }

}