package org.cshaifasweng.winter;


import javafx.fxml.FXML;
import org.cshaifasweng.winter.events.DashboardSwitchEvent;
import org.greenrobot.eventbus.EventBus;

import java.io.IOException;


public class CartController implements Refreshable {


    @Override
    public void refresh() {
    }

    @FXML
    private void BackToCatalog() throws IOException {
        EventBus.getDefault().post(new DashboardSwitchEvent("primary"));
    }

    @FXML
    private void GoToLogin() throws IOException {
        EventBus.getDefault().post(new DashboardSwitchEvent("login_screen"));
    }

    @FXML
    private void GoToOrder() throws IOException {
        EventBus.getDefault().post(new DashboardSwitchEvent("order"));
    }



}