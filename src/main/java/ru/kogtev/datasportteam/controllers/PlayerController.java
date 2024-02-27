package ru.kogtev.datasportteam.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kogtev.datasportteam.dto.PlayerDTO;
import ru.kogtev.datasportteam.models.Player;
import ru.kogtev.datasportteam.services.PlayerService;

import javax.validation.Valid;


@RestController
@RequestMapping("/players")
@AllArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @PostMapping("/add")
    public ResponseEntity<Player> addTeam(@RequestBody @Valid Player player) {
        Player addedPlayer = playerService.save(player);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedPlayer);
    }

    @PatchMapping("/{playerId}/transfer/{newTeamId}")
    public ResponseEntity<Void> transferPlayer(@PathVariable int playerId, @PathVariable int newTeamId) {
        playerService.transferPlayer(playerId, newTeamId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{playerId}")
    public ResponseEntity<Player> updatePlayer(@PathVariable int playerId, @RequestBody @Valid PlayerDTO player) {
        playerService.update(playerId, player);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{playerId}")
    public ResponseEntity<Player> deletePlayer(@PathVariable int playerId) {
        playerService.delete(playerId);
        return ResponseEntity.ok().build();
    }
}
