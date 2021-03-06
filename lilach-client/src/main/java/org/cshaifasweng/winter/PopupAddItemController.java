package org.cshaifasweng.winter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import org.cshaifasweng.winter.events.DashboardSwitchEvent;
import org.cshaifasweng.winter.events.OrderCreateEvent;
import org.cshaifasweng.winter.events.PopupAddItemEvent;
import org.cshaifasweng.winter.models.Item;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class PopupAddItemController implements Initializable {

    private List<Item> cart;
    private Stage stage;
    private Map<Long, Long> quantities;

    @FXML
    void continueShopping(ActionEvent event) {
        stage.hide();
        stage.close();
    }

    @FXML
    void goToCart(ActionEvent event) {
        EventBus.getDefault().post(new DashboardSwitchEvent("order"));
        EventBus.getDefault().post(new OrderCreateEvent(cart ,quantities));
        stage.hide();
        stage.close();
    }

    @Subscribe
    public void handleCartSet(PopupAddItemEvent event) {
        cart = event.getCart();
        stage = event.getPopupStage();
        quantities = event.getQuantities();
    }

    @Override
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        EventBus.getDefault().register(this);
    }
}
