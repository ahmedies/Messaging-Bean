/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myproject.messaging.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author Ahmed Rezgui <ahmad.rezgui at gmail.com>
 */
@MessageDriven(mappedName = "jms/MyProjectTopic", activationConfig = {
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
    @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "TopicListener1"),
    @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "TopicListener1")
})
public class TopicListener1 implements MessageListener {
    
    public TopicListener1() {
    }
    
    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            TextMessage text = (TextMessage) message;
            try {
                System.out.println(this.getClass().getName() + " : " + text.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }

        }
    }
}
