package com.github.inncontrol.communications.application.internal.commandservice;

import com.github.inncontrol.communications.domain.model.aggregates.Message;
import com.github.inncontrol.communications.domain.model.command.CreateMessageCommand;
import com.github.inncontrol.communications.domain.model.command.MarkMessageAsReadCommand;
import com.github.inncontrol.communications.domain.services.MessageCommandService;
import com.github.inncontrol.communications.infrastructure.persistence.jpa.repositories.MessageRepository;
import com.github.inncontrol.shared.application.internal.outboundedservices.acl.ExternalEmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MessageCommandServiceImpl implements MessageCommandService {

    private final MessageRepository messageRepository;
    private final ExternalEmployeeService externalEmployeeService;

    @Override
    public Optional<Message> handle(CreateMessageCommand command) {
        var senderEmployee = externalEmployeeService.getEmployeeByQuery(Map.of("email", command.senderEmail()));
        if (senderEmployee.getBody() == null) {
            throw new IllegalArgumentException("Sender employee not found");
        }
        var receiverEmployee = externalEmployeeService.getEmployeeByQuery(Map.of("email", command.receiverEmail()));
        if (receiverEmployee.getBody() == null) {
            throw new IllegalArgumentException("Receiver employee not found");
        }
        var message = new Message(senderEmployee.getBody().profileId(), receiverEmployee.getBody().profileId(), command.content());
        return Optional.of(messageRepository.save(message));
    }

    @Override
    public void handle(MarkMessageAsReadCommand command) {
        var message = messageRepository.findById(command.messageId());
        if (message.isEmpty()) {
            throw new IllegalArgumentException("Message not found");
        }
        message.get().markAsRead();
    }
}
