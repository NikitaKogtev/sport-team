package ru.kogtev.datasportteam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kogtev.datasportteam.models.Player;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    List<Player> findByTeamOwnerId(int teamId);

    List<Player> findByTeamOwnerIdAndRole(int id, String role);
}
