package com.harry.Audio_Forum.frontend;

import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("login")
public class Login extends VerticalLayout {

    public Login() {
        this.add ( new LoginForm() );
        this.setSizeFull ();
        this.setJustifyContentMode ( JustifyContentMode.CENTER );
        this.setDefaultHorizontalComponentAlignment ( FlexComponent.Alignment.CENTER );
    }
}
