package com.example.chess.service;

import com.example.chess.model.Move;

import java.util.List;
import java.util.Optional;

public interface MoveService {
    Move createMove(Move move);
    Optional<Move> getMoveById(Long id);
    List<Move> getMovesByGameId(Long gameId);
}