package com.example.application.views.todo;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.charts.model.Label;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.application.views.main.MainView;
import com.vaadin.flow.router.RouteAlias;

import javafx.scene.control.CheckBox;

@Route(value = "todo", layout = MainView.class)
@PageTitle("My To Do List")
@CssImport("./styles/views/todo/todo-view.css")
@RouteAlias(value = "", layout = MainView.class)
public class todoView extends HorizontalLayout {

    private TextField todoName;
    private TextField todoDesc;
    private Button submit;
    private List<String> list = new ArrayList<>();
   
   

    public todoView() {
        setId("todo-view");
        VerticalLayout todosList = new VerticalLayout();
        todoName = new TextField("Todo Item");
        todoDesc = new TextField("Description");
        submit = new Button("submit");
        DateTimePicker valueDateTimePicker = new DateTimePicker();
        LocalDateTime now = LocalDateTime.now();
        valueDateTimePicker.setValue(now);  
        add(todoName,todoDesc,valueDateTimePicker, submit);
        setVerticalComponentAlignment(Alignment.END, todoName, submit);
        submit.addClickListener( e-> {
            Notification.show("Item added! Item is : " + todoName.getValue());
            Checkbox checkBox = new Checkbox(todoName.getValue() + " || Descripition : " + todoDesc.getValue() + "  || To do before  : " + valueDateTimePicker.getValue());
            todosList.add(checkBox);
            list.add(todoName.getValue());
            checkBox.addValueChangeListener(ev -> {
                todosList.remove(checkBox);
                });
            
             });
        
       add( todosList);

       
      
    }

}
