package com.example.chess.service.implimentation;

import com.example.chess.model.Move;
import com.example.chess.repo.MoveRepo;
import com.example.chess.service.MoveService;
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
public class MoveServiceImpl implements MoveService {

    private final MoveRepo moveRepo;

    @Override
    public Move createMove(Move move) {
        return moveRepo.save(move);
    }

    @Override
    public Optional<Move> getMoveById(Long id) {
        return moveRepo.findById(id);
    }

    @Override
    public List<Move> getMovesByGameId(Long gameId) {
        return moveRepo.findByGameId(gameId);
    }

}
