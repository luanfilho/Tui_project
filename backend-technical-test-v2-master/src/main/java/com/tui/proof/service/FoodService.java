package com.tui.proof.service;

import com.tui.proof.model.OrderPilote;
import com.tui.proof.model.StatusOrder;
import com.tui.proof.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class FoodService {
    @Autowired
    private FoodRepository orderRepository;

    private static final DecimalFormat decfor = new DecimalFormat("0.00");
    private DecimalFormatSymbols dfs = new DecimalFormatSymbols();

    public List<OrderPilote> getAllOrders(){
        List<OrderPilote> orders =  (List<OrderPilote>)orderRepository.findAll();
        return orders;
    }

    /*
     * TODO: Get Shop By keyword
     */
    public List<OrderPilote> getOrdersByKeyword(String keyword){
        return orderRepository.findByKeyword(keyword);
    }

    public void save(OrderPilote order){

        decfor.setRoundingMode(RoundingMode.DOWN);
        dfs.setDecimalSeparator('.');
        decfor.setDecimalFormatSymbols(dfs);
        float total = Float.parseFloat(decfor.format(order.getPilotes() * 1.33f));

        order.setOrderTotal(total);

        orderRepository.save(order);
    }

    public OrderPilote findById(long number){
        return orderRepository.findById(number).get();
    }

    public void updateStatusPreparing(List<OrderPilote> orders) {
        for (OrderPilote order : orders){
            updateStatusPreparing(order);
        }
    }

    public boolean updateStatusPreparing(OrderPilote order) {

        if (order.getStatusOrder().equals(StatusOrder.Preparing)) {
            return true;
        }

        LocalDateTime creationDateTimePlus5 = order.getCreationDateTime().plusMinutes(5);
        if(LocalDateTime.now().isAfter(creationDateTimePlus5)) {
            order.setStatusOrder(StatusOrder.Preparing);
            save(order);
            return true;
        }
        return false;
    }

    public boolean validatPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("^\\d{10}$");
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
