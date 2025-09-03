package com.app.copro.repository;

import com.app.copro.model.Syndic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SyndicRepository extends JpaRepository<Syndic, Long> {
    
    @Query("SELECT s FROM Syndic s JOIN FETCH s.projet p WHERE p.idMakePlan = :idMakePlan")
    List<Syndic> findByProjetIdMakePlan(@Param("idMakePlan") Long idMakePlan);
}
