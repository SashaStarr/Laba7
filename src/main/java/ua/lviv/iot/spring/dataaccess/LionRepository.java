package ua.lviv.iot.spring.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.iot.spring.model.Lion;

@Repository
public interface LionRepository extends JpaRepository<Lion, Integer> {

}
