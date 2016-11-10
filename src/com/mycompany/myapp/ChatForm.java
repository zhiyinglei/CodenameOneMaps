/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.*;
import static com.codename1.ui.layouts.BoxLayout.Y_AXIS;
//import com.codename1.ui.Form;

/**
 *
 * @author skoal
 */
public class ChatForm extends Form {

    TextField chatInput;
    Container cntList;

    int count = 1;

    public ChatForm() {

        this.setTitle("chatting......");
        this.setLayout(new com.codename1.ui.layouts.BorderLayout());

        cntList = new Container(new com.codename1.ui.layouts.BoxLayout(Y_AXIS)  );
        cntList.setScrollableY(true);

        chatInput = new TextField();
        chatInput.setHint("say something");

        this.addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, chatInput);
        this.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, cntList);

        chatInput.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                appendChatRecords();

            }
        });

    }


    private void appendChatRecords() {

        // append chat records 
        String chatContent = chatInput.getText();

        if (chatContent.trim().equals("")) {
            return;
        }

        Label l = new Label(chatContent);
        cntList.add(l);
        l.setAlignment(RIGHT);

        // respond
        count++;
        Label respondMsg = new Label("hello world " + count);
        cntList.add(respondMsg);

        //repaint container
        cntList.revalidate();
        cntList.scrollComponentToVisible(respondMsg);

        // clear text field
        chatInput.setText("");

    }
}
