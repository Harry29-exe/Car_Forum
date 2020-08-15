package com.harry.Audio_Forum.frontend;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;


@Route("hello")
public class HelloGui extends VerticalLayout {

    public HelloGui() {
        Button button = new Button("button", new Icon(VaadinIcon.CLOUD));
        add(button);
    }
}
