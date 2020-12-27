package com.example.application.views.about;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.example.application.views.main.MainView;

@Route(value = "about", layout = MainView.class)
@PageTitle("About")
@CssImport("./styles/views/about/about-view.css")
public class AboutView extends Div {

    public AboutView() {
        setId("about-view");
        add(new Label("This is about the web app. You can create a list of what you want to do so you can remind yourself, now go back the ToDo list tab ;) "));
        add(new Label(" || Check the box if you are done with an activity. "));
    }

}
