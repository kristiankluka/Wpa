package bookstack.ui.controller;


import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;


@ManagedBean
@ApplicationScoped
public class Data {

    public Status[] getStatuses() {
        return Status.values();
    }

}