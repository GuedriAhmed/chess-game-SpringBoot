package com.example.chess.resource;


import com.example.chess.model.Invitation;
import com.example.chess.service.InvitationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invitations")
@RequiredArgsConstructor
public class InvitationResource {
    private final InvitationService invitationService;


    @PostMapping("/send")
    public ResponseEntity<Invitation> sendInvitation(
            @RequestParam String sender,
            @RequestParam String receiver
    ) {
        return ResponseEntity.ok(invitationService.sendInvitation(sender, receiver));
    }

    @PutMapping("/respond/{id}")
    public ResponseEntity<Invitation> respondInvitation(
            @PathVariable Long id,
            @RequestParam Invitation.Status status
    ) {
        return ResponseEntity.ok(invitationService.respondToInvitation(id, status));
    }

    @GetMapping("/pending/{username}")
    public ResponseEntity<List<Invitation>> pendingInvitations(@PathVariable String username) {
        return ResponseEntity.ok(invitationService.getPendingInvitations(username));
    }
}
