package AgentesMonitores;

import EnviarMensaje.AgenteInfo;
import EnviarMensaje.Messages;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

import java.io.IOException;

/**
 * @author max
 */

public class AgenteMonitor4 extends Agent {
    final private int CUPO = 10000;

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
        @Override
        public void action() {
            ACLMessage msj = blockingReceive();

            try {
                AgenteInfo InformacionAgente = (AgenteInfo) msj.getContentObject();

                if (InformacionAgente.getValorX() > -CUPO) {
                    Messages.sendMessages(this.getAgent(), "AgenteMonitor3", "No se puede vender con: " + InformacionAgente.obtenerEc(), "IDM:AG4-AG3", ACLMessage.INFORM
                    );
                }else {
                    Messages.sendMessages(this.getAgent(), "AgenteMonitor2", "Se aprueba La función con la ecuación " + InformacionAgente.obtenerEc(), "IDM:AG4-AG2", ACLMessage.INFORM);
                }

            } catch (UnreadableException e) {
                System.out.println("Error al deserializar AgenteInfo en AgenteMonitor4");
            } catch (IOException e) {
                System.out.println("Error al enviar mensaje IDM:AG4-AG3");
            }
        }
    }
}
