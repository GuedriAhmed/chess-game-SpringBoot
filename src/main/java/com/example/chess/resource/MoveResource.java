package com.example.chess.resource;


import com.example.chess.model.Game;
import com.example.chess.model.Move;
import com.example.chess.model.User;
import com.example.chess.service.GameService;
import com.example.chess.service.MoveService;
import com.example.chess.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/moves")
public class MoveResource {


    private final MoveService moveService;
    private final GameService gameService;

    @PostMapping("/create")
    public ResponseEntity<String> createMove(
            @RequestParam Long gameId,
            @RequestParam String fromSquare,
            @RequestParam String toSquare,
            @RequestParam String username // the player who made the move
    ) {
        Game game = gameService.getGameById(gameId)
                .orElseThrow(() -> new RuntimeException("Game not found"));


        String playerName;
        if (game.getPlayer1().getUsername().equals(username)) {
            playerName = "Player 1";
        } else if (game.getPlayer2().getUsername().equals(username)) {
            playerName = "Player 2";
        } else {
            return ResponseEntity.badRequest().body("User is not part of this game");
        }

        Move move = new Move();
        move.setGame(game);
        move.setFromSquare(fromSquare);
        move.setToSquare(toSquare);
        move.setPlayer(game.getPlayer1());

        moveService.createMove(move); // save move

        return ResponseEntity.ok(username + " moves from " + fromSquare + " to " + toSquare +
                " in game " + game.getStatus() + " with " +
                (playerName.equals("Player 1") ? game.getPlayer2().getUsername() : game.getPlayer1().getUsername()));
    }

    @GetMapping("/game/{gameId}")
    public ResponseEntity<List<Move>> getMovesByGame(@PathVariable Long gameId) {
        return ResponseEntity.ok(moveService.getMovesByGameId(gameId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Move> getMoveById(@PathVariable Long id) {
        return moveService.getMoveById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
