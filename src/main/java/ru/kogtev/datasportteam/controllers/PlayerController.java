package ru.kogtev.datasportteam.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kogtev.datasportteam.dto.PlayerDTO;
import ru.kogtev.datasportteam.models.Player;
import ru.kogtev.datasportteam.services.PlayerService;

import java.util.List;

@RestController
@RequestMapping("/teams/{teamId}/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping()
    public ResponseEntity<List<PlayerDTO>> getPlayersByTeamId(@PathVariable int teamId) {
        List<PlayerDTO> players = playerService.getPlayersByTeamId(teamId);
        return ResponseEntity.ok(players);
    }


}
