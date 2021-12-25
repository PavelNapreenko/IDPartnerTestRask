package org.example.test_task.repository;

import org.example.test_task.model.RateClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RatesRepository extends JpaRepository<RateClass, Integer> {

    @Query("select r from #{#entityName} r where r.name = :name order by r.date")
    List<RateClass> findByName(@Param("name") String name);

    @Query("select r from #{#entityName} r where r.date = :date order by r.date")
    List<RateClass> findByDate(@Param("date") Date date);


    @Query("select r from #{#entityName} r where r.name = :name and r.date = :date order by r.date")
    List<RateClass> findByNameAndDate(@Param("name") String name,
                                      @Param("date") Date date);
}