package ru.kogtev.datasportteam.services;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.kogtev.datasportteam.dto.TeamDTO;
import ru.kogtev.datasportteam.models.Team;
import ru.kogtev.datasportteam.repositories.TeamRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;
    private final ModelMapper modelMapper;

    //получение списка всех команд
    public List<TeamDTO> getAllTeams() {
        List<Team> teams = teamRepository.findAll();
        return teams.stream()
                .map(team -> modelMapper.map(team, TeamDTO.class))
                .collect(Collectors.toList());
    }

    //получение команд по виду спорта
    public List<TeamDTO> getTeamsBySportType(String sportType) {
        List<Team> teams = teamRepository.findBySportType(sportType);
        return teams.stream()
                .map(team -> modelMapper.map(team, TeamDTO.class))
                .collect(Collectors.toList());
    }

    //получение команд за период по дате основания
    public List<TeamDTO> getTeamsByFoundDateBetween(int fistDate, int secondDate) {
        List<Team> teams = teamRepository.findByFoundDateBetween(fistDate, secondDate);
        return teams.stream()
                .map(team -> modelMapper.map(team, TeamDTO.class))
                .collect(Collectors.toList());
    }

    //создание(добавление) команды
    public Team save(Team team) {
        return teamRepository.save(team);
    }

    //изменение данных команды
    public void update(int id, Team updateTeam) {
        updateTeam.setId(id);
        teamRepository.save(updateTeam);
    }

    //удаление команды
    public void delete(int id) {
        teamRepository.deleteById(id);
    }
}
