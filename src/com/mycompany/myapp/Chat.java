/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.geom.Dimension;

/**
 * GUI builder created Form
 *
 * @author skoal
 */
public class Chat extends com.codename1.ui.Form {

    public Chat() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    public Chat(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Container gui_Container_Chat_Lists = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Label gui_Label_1_1 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    private com.codename1.ui.TextField gui_Text_Field_1_1 = new com.codename1.ui.TextField();
    private com.codename1.ui.Button gui_Button_Chat = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_Button_Chat.addActionListener(callback);
    }

    class EventCallbackClass implements com.codename1.ui.events.ActionListener, com.codename1.ui.events.DataChangedListener {
        private com.codename1.ui.Component cmp;
        public EventCallbackClass(com.codename1.ui.Component cmp) {
            this.cmp = cmp;
        }

        public EventCallbackClass() {
        }

        public void actionPerformed(com.codename1.ui.events.ActionEvent ev) {
            com.codename1.ui.Component sourceComponent = ev.getComponent();
            if(sourceComponent.getParent().getLeadParent() != null) {
                sourceComponent = sourceComponent.getParent().getLeadParent();
            }

            if(sourceComponent == gui_Button_Chat) {
                onButton_ChatActionEvent(ev);
            }
        }

        public void dataChanged(int type, int index) {
        }
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.BorderLayout());
        setTitle("Chat");
        setName("Chat");
        addComponent(com.codename1.ui.layouts.BorderLayout.NORTH, gui_Container_Chat_Lists);
        gui_Container_Chat_Lists.setScrollableY(false);
        gui_Container_Chat_Lists.setName("Container_Chat_Lists");
        gui_Container_Chat_Lists.addComponent(gui_Label_1_1);
        gui_Label_1_1.setName("Label_1_1");
        addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, gui_Container_1);
        gui_Container_1.setName("Container_1");
        gui_Container_1.addComponent(gui_Text_Field_1_1);
        gui_Container_1.addComponent(gui_Button_Chat);
        gui_Text_Field_1_1.setHint("say something");
        gui_Text_Field_1_1.setName("Text_Field_1_1");
        gui_Button_Chat.setText("Chat");
        gui_Button_Chat.setName("Button_Chat");
        gui_Container_Chat_Lists.setScrollableY(false);
        gui_Container_Chat_Lists.setName("Container_Chat_Lists");
        gui_Container_1.setName("Container_1");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onActionEvent(com.codename1.ui.events.ActionEvent ev) {

    }

    private void additionSetup() {
        int height = this.getBounds().getHeight();
        gui_Container_Chat_Lists.setHeight(200);
        gui_Container_Chat_Lists.setScrollSize(new Dimension(200, 200));
        Dimension d;

        //gui_Container_Chat_Lists.setScrollSize();
    }

    public void onButton_ChatActionEvent(com.codename1.ui.events.ActionEvent ev) {

        // append chat records 
        String chatContent = gui_Text_Field_1_1.getText();

        if (chatContent.trim().equals("")) {
            return;
        }

        Label l = new Label(chatContent);
        gui_Container_Chat_Lists.add(l);
        l.setAlignment(RIGHT);

        // respond
        gui_Container_Chat_Lists.add(new Label("hello world"));
        // clear text field
        gui_Text_Field_1_1.setText("");

        // repaint screen
        this.repaint();
    }

}
