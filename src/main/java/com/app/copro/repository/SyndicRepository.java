package com.app.copro.repository;

import com.app.copro.model.Syndic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SyndicRepository extends JpaRepository<Syndic, Long> {
}
