package com.movies.demoHQL.repository;

import com.movies.demoHQL.model.Vehiculo;
import com.movies.demoHQL.model.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Integer> {

    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> findAllPatentes();

    @Query("SELECT v.patente, v.marca FROM Vehiculo v ORDER BY añoFab")
    List<String> findAllPatentesandMarca();

    /*
    @Query("SELECT v.patente, v.marca FROM Vehiculo v ORDER BY añoFab")

    //@Query("FROM Actor")
    //List<Vehiculo> findAllActors();

    //Actor findByFirstName(String firstName);

    //@Query("From Actor A WHERE A.firstName LIKE :name")
    //Vehiculo findByFirstName(@Param("name") String name);

   //@Query("FROM Movie M WHERE M.id = :id")
   //Siniestro findMovieOfActor(@Param("id") Integer id);

 */
}
