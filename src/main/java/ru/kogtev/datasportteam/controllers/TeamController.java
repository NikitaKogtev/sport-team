package ru.kogtev.datasportteam.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kogtev.datasportteam.dto.PlayerDTO;
import ru.kogtev.datasportteam.dto.TeamDTO;
import ru.kogtev.datasportteam.models.Team;
import ru.kogtev.datasportteam.services.PlayerService;
import ru.kogtev.datasportteam.services.TeamService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/teams")
@AllArgsConstructor
public class TeamController {

    private final TeamService teamService;
    private final PlayerService playerService;

    @GetMapping
    public ResponseEntity<List<TeamDTO>> getAllTeams() {
        List<TeamDTO> teams = teamService.getAllTeams();
        return ResponseEntity.ok(teams);
    }

    @GetMapping("/{teamId}/players")
    public ResponseEntity<List<PlayerDTO>> getPlayersByTeamId(@PathVariable int teamId) {
        List<PlayerDTO> players = playerService.getPlayersByTeamId(teamId);
        return ResponseEntity.ok(players);
    }

    @GetMapping("/{teamId}/players/{role}")
    public ResponseEntity<List<PlayerDTO>> getPlayersByTeamIdAndRole(@PathVariable int teamId, @PathVariable String role) {
        List<PlayerDTO> players = playerService.getPlayersByRole(teamId, role);
        return ResponseEntity.ok(players);
    }

    //(?sportDate=)
    @GetMapping("/sport")
    public ResponseEntity<List<TeamDTO>> getTeamsBySportType(@RequestParam String sportType) {
        List<TeamDTO> teams = teamService.getTeamsBySportType(sportType);
        return ResponseEntity.ok(teams);
    }

    //(?firstDate= &?secondDate= )
    @GetMapping("/foundation-date")
    public ResponseEntity<List<TeamDTO>> getTeamsByFoundationDate(@RequestParam int firstDate, int secondDate) {
        List<TeamDTO> teams = teamService.getTeamsByFoundDateBetween(firstDate, secondDate);
        return ResponseEntity.ok(teams);
    }

    @PostMapping("/add")
    public ResponseEntity<Team> addTeam(@RequestBody @Valid Team team) {
        Team addedTeam = teamService.save(team);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedTeam);
    }

    @PutMapping("/{teamId}")
    public ResponseEntity<Team> updateTeam(@PathVariable int teamId, @RequestBody @Valid Team team) {
        teamService.update(teamId, team);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{teamId}")
    public ResponseEntity<Team> deleteTeam(@PathVariable int teamId) {
        teamService.delete(teamId);
        return ResponseEntity.ok().build();
    }
}
