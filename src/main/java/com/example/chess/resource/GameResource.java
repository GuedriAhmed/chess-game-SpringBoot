package com.example.chess.resource;

import com.example.chess.model.Game;
import com.example.chess.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/games")
public class GameResource {

    private final GameService gameService;

    @Autowired
    public GameResource(GameService gameService) {
        this.gameService = gameService;
    }


    @PostMapping("/start")
    public ResponseEntity<Game> createGame(@RequestBody Game game) {
        return ResponseEntity.ok(gameService.createGame(game));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> getGame(@PathVariable Long id) {
        return gameService.getGameById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/status/{status}")
    public List<Game> getGamesByStatus(@PathVariable String status) {
        return gameService.getGamesByStatus(status);
    }

    @PutMapping("/update-status/{id}")
    public ResponseEntity<Game> updateStatus(@PathVariable Long id, @RequestParam String status) {
        return ResponseEntity.ok(gameService.updateGameStatus(id, status));
    }
}