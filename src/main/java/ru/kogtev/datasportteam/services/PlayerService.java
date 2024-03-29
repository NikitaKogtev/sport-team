package ru.kogtev.datasportteam.services;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.kogtev.datasportteam.dto.PlayerDTO;
import ru.kogtev.datasportteam.models.Player;
import ru.kogtev.datasportteam.models.Team;
import ru.kogtev.datasportteam.repositories.PlayerRepository;
import ru.kogtev.datasportteam.repositories.TeamRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;
    private final ModelMapper modelMapper;

    //получить всех участников конкретной команды
    public List<PlayerDTO> getPlayersByTeamId(int teamId) {
        List<Player> players = playerRepository.findByTeamOwnerId(teamId);
        return players.stream()
                .map(player -> modelMapper.map(player, PlayerDTO.class))
                .collect(Collectors.toList());
    }

    //фильтрация игроков по роле в команде
    public List<PlayerDTO> getPlayersByRole(int teamId, String role) {
        List<Player> players = playerRepository.findByTeamOwnerIdAndRole(teamId, role);
        return players.stream()
                .map(player -> modelMapper.map(player, PlayerDTO.class))
                .collect(Collectors.toList());
    }

    //создание(добавление) участника команды
    public Player save(Player player) {
        return playerRepository.save(player);
    }

    //перевести участника из одной команды в другую
    public void transferPlayer(int playerId, int newTeamId) {
        Player player = playerRepository.findById(playerId).get();
        Team team = teamRepository.findById(newTeamId).get();
        player.setTeamOwner(team);
        playerRepository.save(player);
    }

    //изменение данных участника команды
    public void update(int id, PlayerDTO updatePlayer) {
        Player player = playerRepository.findById(id).get();
        modelMapper.map(updatePlayer, player);
        player.setId(id);
        playerRepository.save(player);
    }

    //удаление участника команды
    public void delete(int id) {
        playerRepository.deleteById(id);
    }
}
