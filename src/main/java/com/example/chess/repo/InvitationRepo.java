package com.example.chess.repo;

import com.example.chess.model.Invitation;
import com.example.chess.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvitationRepo extends JpaRepository<Invitation, Long> {
    List<Invitation> findByReceiverAndStatus(User receiver, Invitation.Status status);
}
