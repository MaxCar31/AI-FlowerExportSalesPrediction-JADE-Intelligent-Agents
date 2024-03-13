package AgentesMonitores;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

/**
 * @author max
 */

public class AgenteMonitor3 extends Agent {
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
            System.out.println(getName());
            System.out.println("Identificador del mensaje " + msj.getConversationId());
            System.out.println(msj);

        }
    }
}
