package com.example.chess.service;

import com.example.chess.model.Game;

import java.util.List;
import java.util.Optional;

public interface GameService {
    Game createGame(Game game);
    Optional<Game> getGameById(Long id);
    List<Game> getAllGames();
    List<Game> getGamesByStatus(String status);
    Game updateGameStatus(Long id, String status);

}
