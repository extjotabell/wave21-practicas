package wave21.demoJPAHibernateSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wave21.demoJPAHibernateSpring.model.Joya;

@Repository
public interface JoyaRepository extends JpaRepository<Joya, Long> {

}
