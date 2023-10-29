package Main;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class Agent4 extends Agent {
    public void setup() {
        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                MessageTemplate template = MessageTemplate.or(
                        MessageTemplate.and(
                                MessageTemplate.MatchPerformative(ACLMessage.INFORM),
                                MessageTemplate.MatchOntology("WordNetEn")
                        ),
                        MessageTemplate.and(
                                MessageTemplate.MatchPerformative(ACLMessage.INFORM),
                                MessageTemplate.MatchLanguage("En")
                        )
                );
                ACLMessage message = receive(template);
                if (message != null) {
                    ACLMessage reponse = new ACLMessage(ACLMessage.INFORM);
                    reponse.setContent ("Le message " + message.getContent () + " well received by " + myAgent.getName()) ;
                    reponse.addReceiver(message.getSender());
                    send (reponse);
                    System.out.println("Le message " + message.getContent () + " well received by " + myAgent.getName());
                }
            }
        });
    }
}
