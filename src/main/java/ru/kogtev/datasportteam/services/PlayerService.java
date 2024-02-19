package ru.kogtev.datasportteam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kogtev.datasportteam.models.Player;
import ru.kogtev.datasportteam.models.Team;
import ru.kogtev.datasportteam.repositories.PlayerRepository;
import ru.kogtev.datasportteam.repositories.TeamRepository;

import java.util.Collections;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository, TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    //получить всех участников конкретной команды
    public List<Player> findPlayersByTeamName(String teamName) {
        Team team = teamRepository.findByTeamName(teamName);
        return playerRepository.findByTeamOwner(team);

    }

    // Фильтрация по роли позиции в команде
    public List<Player> findPlayersByTeamNameAndRole(String teamName, String role) {
        Team team = teamRepository.findByTeamName(teamName);
        return playerRepository.findByTeamOwnerAndRole(team, role);
    }


    //добавление игрока(участника)
    public void save(Player player) {
        playerRepository.save(player);
    }

    // перевести участника из одной команды в другую
    public void transferPlayer(int id, Team team, Player updatePlayer) {
        updatePlayer.setId(id);
        updatePlayer.setTeamOwner(team);
        playerRepository.save(updatePlayer);
    }

    // изменение данных участника команды
    public void update(int id, Player updatePlayer) {
        updatePlayer.setId(id);
        playerRepository.save(updatePlayer);
    }

    //удаление участника команды
    public void delete(int id) {
        playerRepository.deleteById(id);
    }


}
