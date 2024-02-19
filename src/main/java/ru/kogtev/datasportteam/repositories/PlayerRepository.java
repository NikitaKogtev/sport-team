package ru.kogtev.datasportteam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kogtev.datasportteam.models.Player;
import ru.kogtev.datasportteam.models.Team;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    List<Player> findByTeamOwner(Team team);

    List<Player> findByTeamOwnerAndRole(Team team, String role);
}
