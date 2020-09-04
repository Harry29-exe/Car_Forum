package com.harry.Audio_Forum.frontend;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("hello")
public class HelloGui extends VerticalLayout {

    public HelloGui() {
        HorizontalLayout header = new HorizontalLayout();
        header.setJustifyContentMode(JustifyContentMode.CENTER);
        header.setDefaultVerticalComponentAlignment(Alignment.CENTER);
        header.setHeight("20%");
        header.setWidth("100%");

        VerticalLayout content = new VerticalLayout();
        content.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        content.setJustifyContentMode(JustifyContentMode.CENTER);
        content.setHeight("80%");
        content.setWidth("100%");


        TextField textFieldName = new TextField("Name");
        TextField textFieldSurname = new TextField("Surname");
        Button buttonAccept = new Button("Login", VaadinIcon.CONNECT.create());
        content.add(textFieldName,textFieldSurname, buttonAccept);


        this.add( content);
        this.setSizeFull();
        this.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        this.setJustifyContentMode(JustifyContentMode.CENTER);

    }
}
