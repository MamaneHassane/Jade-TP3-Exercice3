package Main;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;

public class ConteneurCommunication {
    public static void main(String[] args) {
        Runtime runtime = Runtime.instance();
        ProfileImpl profileImpl = new ProfileImpl();
        profileImpl.setParameter(ProfileImpl.MAIN_HOST, "localhost");
        AgentContainer agentContainer = runtime.createAgentContainer(profileImpl);
        try {
            AgentController adminAgent = agentContainer.createNewAgent("AgentAdmin", "Main.AgentAdmin", new Object[]{});
            AgentController agent1 = agentContainer.createNewAgent("Agent1", "Main.Agent1", new Object[]{});
            AgentController agent2 = agentContainer.createNewAgent("Agent2", "Main.Agent2", new Object[]{});
            AgentController agent3 = agentContainer.createNewAgent("Agent3", "Main.Agent3", new Object[]{});
            AgentController agent4 = agentContainer.createNewAgent("Agent4", "Main.Agent4", new Object[]{});
            adminAgent.start();
            agent1.start();
            agent2.start();
            agent3.start();
            agent4.start();
        } catch (StaleProxyException e) {
            e.printStackTrace();
        }
    }
}

