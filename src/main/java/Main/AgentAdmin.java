package Main;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class AgentAdmin extends Agent {
    public void setup() {
        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                try {
                    // Attendre 5 secondes (5000 millisecondes)
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // Une fois que l'attente est terminée, envoyez les messages
                ACLMessage cfpFr = new ACLMessage(ACLMessage.CFP);
                cfpFr.addReceiver(new AID("Agent1",AID.ISLOCALNAME));
                cfpFr.setContent("Message de type CFP en français");
                cfpFr.setLanguage("Fr");
                send(cfpFr);

                ACLMessage cfpEn = new ACLMessage(ACLMessage.CFP);
                cfpEn.addReceiver(new AID("Agent2",AID.ISLOCALNAME));
                cfpEn.setContent("Message de type CFP en anglais");
                cfpEn.setLanguage("En");
                send(cfpEn);

                ACLMessage informWordNetFr = new ACLMessage(ACLMessage.INFORM);
                informWordNetFr.addReceiver(new AID("Agent3",AID.ISLOCALNAME));
                informWordNetFr.setContent("Message de type INFORM avec ontologie WordNetFr");
                informWordNetFr.setOntology("WordNetFr");
                send(informWordNetFr);

                ACLMessage informEn = new ACLMessage(ACLMessage.INFORM);
                informEn.addReceiver(new AID("Agent4",AID.ISLOCALNAME));
                informEn.setContent("Message de type INFORM en anglais");
                informEn.setLanguage("En");
                send(informEn);
            }
        });
    }
}

