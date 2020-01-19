package org.cshaifasweng.winter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import org.cshaifasweng.winter.events.DashboardSwitchEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class DashboardController implements Initializable {
    @FXML
    private ScrollPane containerPane;

    private void setPage(String page) {
        try {
            containerPane.setContent(LayoutManager.getInstance().getFXML(page));
            Refreshable controller = (Refreshable) LayoutManager.getInstance().getController(page);
            controller.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void handlePageChange(DashboardSwitchEvent event) throws IOException {
        setPage(event.pageName);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setPage("primary");
        EventBus.getDefault().register(this);
    }
    @FXML
    void fileComplaint(ActionEvent event) {
        setPage("complaint_filing");
    }

    @FXML
    void handleComplaint(ActionEvent event) {
        setPage("complaint_handling");
    }

    public boolean CartIsEmpty=true;   // to setup
    public boolean LoggedIn=false;       // to setup

    @FXML
     void CartButton(ActionEvent event) {
        if (CartIsEmpty && LoggedIn) {
            setPage("Empty_Cart_Customer");
        }
        else if (CartIsEmpty) {
            setPage("Empty_Cart_Guest");
        }
        else  {
            setPage("Customer_Cart");
        }


    }


}
