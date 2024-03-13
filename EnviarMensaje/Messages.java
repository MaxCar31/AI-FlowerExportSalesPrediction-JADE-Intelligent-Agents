package EnviarMensaje;

import jade.core.AID;
import jade.core.Agent;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;

import java.io.IOException;
import java.io.Serializable;

public class Messages {
    public static void sendMessages(
            Agent emitterAgent,
            String receiverAgentName,
            String messageContent,
            String conversationId,
            int messageType
    ) throws IOException {
        ACLMessage acl = new ACLMessage(messageType);

        AID aid = new AID();
        aid.setLocalName(receiverAgentName);
        acl.addReceiver(aid);

        acl.setSender(emitterAgent.getAID());

        acl.setContent(messageContent);

        acl.setLanguage(FIPANames.ContentLanguage.FIPA_SL);

        acl.setConversationId(conversationId);

        emitterAgent.send(acl);
    }

    public static void sendMessages(
            Agent emitterAgent,
            String receiverAgentName,
            Serializable messageContent,
            String conversationId,
            int messageType
    ) throws IOException {
        ACLMessage acl = new ACLMessage(messageType);

        AID aid = new AID();
        aid.setLocalName(receiverAgentName);
        acl.addReceiver(aid);

        acl.setSender(emitterAgent.getAID());

        acl.setContentObject(messageContent);

        acl.setLanguage(FIPANames.ContentLanguage.FIPA_SL);

        acl.setConversationId(conversationId);

        emitterAgent.send(acl);
    }
}
