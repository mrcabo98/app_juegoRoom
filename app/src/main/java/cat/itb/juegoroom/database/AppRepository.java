package cat.itb.juegoroom.database;

import java.util.List;

import cat.itb.juegoroom.database.DAO.PreguntaDAO;
import cat.itb.juegoroom.database.DAO.PuntuacioDAO;

public class AppRepository {
    PreguntaDAO preguntaDAO;
    PuntuacioDAO puntuacioDAO;

    public AppRepository(PreguntaDAO preguntaDAO, PuntuacioDAO puntuacioDAO) {
        this.preguntaDAO = preguntaDAO;
        this.puntuacioDAO = puntuacioDAO;
    }

    // PREGUNTAS
    public void insert(Pregunta p) {
        this.preguntaDAO.Insert(p);
    }

    public Pregunta findById(int idPregunta) {
        return this.preguntaDAO.findById(idPregunta);
    }

    public int totalPreguntas() {
        return this.preguntaDAO.totalPreguntas();
    }

    // PUNTUACIÓN
    public List<Puntuacio> getAll() {
        return this.puntuacioDAO.getAll();
    }

    public void insert(Puntuacio p) {
        this.puntuacioDAO.insert(p);
    }

    public void deleteAll() {
        this.puntuacioDAO.deleteAll();
    }

}
