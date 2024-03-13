package Contenedor;

import AgentesMonitores.AgenteMonitor2;
import AgentesMonitores.AgenteMonitor3;
import AgentesMonitores.AgenteMonitor4;
import AgentesMonitores.AgenteMonitorH;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

public class Contenedor {
    AgentContainer mainContenedor;
    AgentController agentController;



    public void inicializaContendor() {
        jade.core.Runtime runtime = jade.core.Runtime.instance();
        runtime.setCloseVM(true);

        Profile profile = new ProfileImpl(null, 5324, null);
        mainContenedor = runtime.createMainContainer(profile);
        inicializaAgentes();
    }

    private void inicializaAgentes() {
        try {
            mainContenedor.createNewAgent("AgenteMonitorH", AgenteMonitorH.class.getName(), new Object[]{this, 0}).start();
            mainContenedor.createNewAgent("AgenteMonitor2", AgenteMonitor2.class.getName(), null).start();
            mainContenedor.createNewAgent("AgenteMonitor3", AgenteMonitor3.class.getName(), new Object[]{this}).start();
            mainContenedor.createNewAgent("AgenteMonitor4", AgenteMonitor4.class.getName(), null).start();
        } catch (StaleProxyException ex) {
            System.out.println("No se ha podido crear el agente");
        }
    }

    public void crearHijos(String nickname, Object[] conocimiento) {
        try {
            mainContenedor.createNewAgent(nickname, AgenteMonitorH.class.getName(), conocimiento).start();
        } catch (StaleProxyException ex) {
            System.out.println("No se ha podido crear el hijo");
        }
    }
}

