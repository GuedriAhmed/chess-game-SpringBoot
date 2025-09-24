package com.example.chess.service.implimentation;


import com.example.chess.model.Game;
import com.example.chess.model.Invitation;
import com.example.chess.model.User;
import com.example.chess.repo.GameRepo;
import com.example.chess.repo.InvitationRepo;
import com.example.chess.repo.UserRepo;
import com.example.chess.service.GameService;
import com.example.chess.service.InvitationService;
import jakarta.transaction.Transactional;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class InvitationServiceImpl implements InvitationService {

    private final InvitationRepo invitationRepo;
    private final UserRepo userRepo;
    private final GameService gameService;

    @Override
    public Invitation sendInvitation(String senderUsername, String receiverUsername) {
        User sender = userRepo.findByUsername(senderUsername)
                .orElseThrow(() -> new RuntimeException("Sender not found"));
        User receiver = userRepo.findByUsername(receiverUsername)
                .orElseThrow(() -> new RuntimeException("Receiver not found"));

        Invitation invitation = Invitation.builder()
                .sender(sender)
                .receiver(receiver)
                .status(Invitation.Status.PENDING)
                .build();

        return invitationRepo.save(invitation);
    }

    @Override
    public Invitation respondToInvitation(Long invitationId, Invitation.Status status) {
        Invitation invitation = invitationRepo.findById(invitationId)
                .orElseThrow(() -> new RuntimeException("Invitation not found"));

        invitation.setStatus(status);
        // If accepted, create game automatically
        if (status == Invitation.Status.ACCEPTED) {
            Game game = Game.builder()
                    .player1(invitation.getSender())
                    .player2(invitation.getReceiver())
                    .status("IN_PROGRESS")
                    .build();
            gameService.createGame(game);
        }
        return invitationRepo.save(invitation);
    }

    @Override
    public List<Invitation> getPendingInvitations(String receiverUsername) {
        User receiver = userRepo.findByUsername(receiverUsername)
                .orElseThrow(() -> new RuntimeException("Receiver not found"));

        return invitationRepo.findByReceiverAndStatus(receiver, Invitation.Status.PENDING);
    }
}
