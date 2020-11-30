package cat.itb.juegoroom.database;

import java.util.List;

import cat.itb.juegoroom.database.DAO.PuntuacioDAO;

public class AppRepository {

    PuntuacioDAO dao;

    public AppRepository(PuntuacioDAO dao) {
        this.dao = dao;
    }

    public void insert(Puntuacio p) {
        this.dao.insert(p);
    }

    public List<Puntuacio> getAll() {
        return this.dao.getAll();
    }

    public void delete(Puntuacio p) {
        this.dao.delete(p);
    }

}
