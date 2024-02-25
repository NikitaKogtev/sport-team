package ru.kogtev.datasportteam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kogtev.datasportteam.dto.TeamDTO;
import ru.kogtev.datasportteam.models.Player;
import ru.kogtev.datasportteam.models.Team;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {
    List<Team> findBySportType(String sportType);

    List<Team> findByFoundDateBetween(int fistDate, int secondDate);

}
