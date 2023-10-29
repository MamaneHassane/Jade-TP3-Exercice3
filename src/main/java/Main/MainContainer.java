package Main;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.ControllerException;

import static java.lang.Runtime.*;

public class MainContainer {
    public static void main(String[] args)  {
        Runtime runtime = Runtime.instance();
        ProfileImpl profile = new ProfileImpl();
        profile.setParameter(Profile.GUI,"true");
        AgentContainer mainContainer = runtime.createMainContainer(profile);
        try {
            mainContainer.start();
        } catch (ControllerException e) {
            e.getCause();
        }
    }
}
