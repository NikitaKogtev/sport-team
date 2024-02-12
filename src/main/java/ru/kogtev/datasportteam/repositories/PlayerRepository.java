package ru.kogtev.datasportteam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kogtev.datasportteam.models.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

}
