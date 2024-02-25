package ru.kogtev.datasportteam.services;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kogtev.datasportteam.dto.PlayerDTO;
import ru.kogtev.datasportteam.dto.TeamDTO;
import ru.kogtev.datasportteam.models.Player;
import ru.kogtev.datasportteam.models.Team;
import ru.kogtev.datasportteam.repositories.PlayerRepository;
import ru.kogtev.datasportteam.repositories.TeamRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final ModelMapper modelMapper;

    public PlayerService(PlayerRepository playerRepository, ModelMapper modelMapper) {
        this.playerRepository = playerRepository;
        this.modelMapper = modelMapper;
    }

    //получить всех участников конкретной команды
    public List<PlayerDTO> getPlayersByTeamId (int teamId) {
        List<Player> players = playerRepository.findByTeamOwnerId(teamId);
        return players.stream()
                .map(player -> modelMapper.map(player, PlayerDTO.class))
                .collect(Collectors.toList());
    }

//    // перевести участника из одной команды в другую
//    public void transferPlayer(int id, Team team, Player updatePlayer) {
//        updatePlayer.setId(id);
//        updatePlayer.setTeamOwner(team);
//        playerRepository.save(updatePlayer);
//    }
//
//    // изменение данных участника команды
//    public void update(int id, Player updatePlayer) {
//        updatePlayer.setId(id);
//        playerRepository.save(updatePlayer);
//    }
//
//    //удаление участника команды
//    public void delete(int id) {
//        playerRepository.deleteById(id);
//    }


}
