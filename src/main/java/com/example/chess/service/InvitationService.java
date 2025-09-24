package com.example.chess.service;

import com.example.chess.model.Invitation;

import java.util.List;

public interface InvitationService {

    Invitation sendInvitation(String senderUsername, String receiverUsername);

    Invitation respondToInvitation(Long invitationId, Invitation.Status status);

    List<Invitation> getPendingInvitations(String receiverUsername);
}
