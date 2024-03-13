package AgentesMonitores;

import EnviarMensaje.AgenteInfo;
import EnviarMensaje.Messages;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

import java.io.IOException;

public class AgenteMonitor2 extends Agent {
    @Override
    protected void setup() {
        addBehaviour(new Behaivour());
        super.setup();
    }

    @Override
    protected void takeDown() {
        super.takeDown();
    }

    class Behaivour extends CyclicBehaviour {
        private int NumHIjo = 0;

        @Override
        public void action() {
            if (NumHIjo > 2) {
                System.out.println("Adios soy " + getName());
                doDelete();
                return;
            }
            ACLMessage msj = blockingReceive();
            NumHIjo++;

            try {
                AgenteInfo agenteInfo = (AgenteInfo) msj.getContentObject();

                System.out.println(agenteInfo.toString() + "\n\n");

                if (agenteInfo.getValorX() > -10000){
                    Messages.sendMessages(this.getAgent(), "AgenteMonitor3", "Se puede vender con: " + agenteInfo.obtenerEc(), "IDM:AG2-AG1", ACLMessage.INFORM);
                }else {
                    Messages.sendMessages(this.getAgent(), "AgenteMonitor4", agenteInfo, "IDM:AG2-AG3", ACLMessage.INFORM);
                }
            } catch (UnreadableException | IOException e) {
                System.out.println("Error while deserializing AgenteInfo in AgenteMonitor2");
            }
        }
    }
}
