package com.example.chess.service.implimentation;

import com.example.chess.model.Game;
import com.example.chess.repo.GameRepo;
import com.example.chess.service.GameService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class GameServiceImpl implements GameService {
    private final GameRepo gameRepository;

    @Override
    public Game createGame(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public Optional<Game> getGameById(Long id) {
        return gameRepository.findById(id);
    }

    @Override
    public List<Game> getAllGames() {
        return (List<Game>) gameRepository.findAll();
    }

    @Override
    public List<Game> getGamesByStatus(String status) {
        return gameRepository.findByStatus(status);
    }

    @Override
    public Game updateGameStatus(Long id, String status) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Game not found"));
        game.setStatus(status);
        return gameRepository.save(game);
    }

}
