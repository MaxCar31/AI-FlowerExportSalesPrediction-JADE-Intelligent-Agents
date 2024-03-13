package AgentesMonitores;

import Contenedor.Contenedor;
import FuncionesAptitud.AG1;
import FuncionesAptitud.AG2;
import FuncionesAptitud.AG3;
import EnviarMensaje.AgenteInfo;
import EnviarMensaje.Messages;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;


import java.io.IOException;

/**
 * @author max
 */

public class AgenteMonitorH extends Agent {
    private Contenedor container;
    private int numHijo;

    @Override
    protected void setup() {
        addBehaviour(new BehaviourN());
        super.setup();
    }

    @Override
    protected void takeDown() {
        String nombreAgenteHijo = "AgenteMonitorH" + (numHijo + 1);

        if (numHijo < 3) {
            System.out.println("Creacion agente: " + nombreAgenteHijo);
            container.crearHijos(nombreAgenteHijo, new Object[]{container, (numHijo + 1)});
            System.out.println("Adios soy " + getName());
        }

        super.takeDown();
    }

    class BehaviourN extends SimpleBehaviour {
        private boolean bandera = false;

        int[] ReturnEc;

        @Override
        public void action() {
            System.out.println("\n\n" + getName());

            container = (Contenedor) getArguments()[0];
            numHijo = (int) getArguments()[1];

            String ecuacion = "";

            Object[] pruebas = {
                    new AG1(),
                    new AG2(),
                    new AG3()
            };

            String[] ecuaciones = {
                    "y = -0.2585 x^6 + x^5 (-19.338) + 562.55 x^4 + x^3 (-7979.2) + 56266 x^2 - 171797 x - 8038.4",
                    "y = 3884.7x - 173594 ",
                    "y = 27156ln(x) – 188752"
            };

            try {

                ReturnEc = ((AG2) pruebas[numHijo]).empezar();
                ecuacion = ecuaciones[numHijo];

                AgenteInfo agenteInfo = new AgenteInfo(
                        ecuacion,
                        ReturnEc[0],
                        ReturnEc[1]
                );

                System.out.println("Resultado de la mejor generacion: " + ReturnEc[0] + " ; " + ReturnEc[1]);

                System.out.println(agenteInfo);

                try {
                    Messages.sendMessages(this.getAgent(), "AgenteMonitor2", agenteInfo, numHijo + "AgenteMonitor2", ACLMessage.INFORM);
                } catch (IOException e) {
                    System.out.println("Error entre el  AgenteMonitorH-Agent2 in AgentM");
                }
            } catch (Exception e) {
                System.out.println("Finalizado");
            } finally {
                bandera = true;
                doDelete();
            }
        }

        @Override
        public boolean done() {
            return bandera;
        }
    }
}
