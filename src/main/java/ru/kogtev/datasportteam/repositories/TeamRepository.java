package ru.kogtev.datasportteam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kogtev.datasportteam.models.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

}
