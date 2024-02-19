package ru.kogtev.datasportteam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kogtev.datasportteam.models.Team;
import ru.kogtev.datasportteam.repositories.TeamRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    // получение списка всех команд
    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    //получение команд по виду спорта
    public List<Team> findBySportType(String sportType) {
        return teamRepository.findBySportType(sportType);
    }

    //получение команд за период по дате основания
    public List<Team> findByFoundDateBetween(int fistDate, int secondDate) {
        return teamRepository.findByFoundDateBetween(fistDate, secondDate);
    }

    //создание(добавление) команды
    public void save(Team team) {
        teamRepository.save(team);
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
