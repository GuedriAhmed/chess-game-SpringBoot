package com.example.chess.dto;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class MoveDTO {
    private Long gameId;
    private Long userId;
    private String username; // The player making the move
    private String fromSquare;

    private String toSquare;
}
