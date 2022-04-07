package com.springhow.examples.springboot.pdfdemo;


import com.springhow.examples.springboot.pdfdemo.pojo.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderHelper {

    public static Order getOrder() {
        Order order = new Order();
        order.setOrderId(1234);
        order.setDate("2077-09-05");
        Address address = new Address();
        address.setCity("Porto Alegre");
        address.setStreet("110 av. Ipiranga, Porto Alegre, RS - 91130-420");
        address.setZipCode("90309-420");
        address.setState("RS");
        Account account = new Account();
        account.setPhoneNumber("917-483-5146");
        account.setEmail("628jh4h624y@temporary-mail.net");
        account.setName("Mr. Eugene A King");
        account.setAddress(address);
        order.setAccount(account);

        List<Item> items = new ArrayList<>();
        order.setItems(items);
        Item item1 = new Item();
        item1.setName("NodeJS");
        item1.setPrice(BigDecimal.valueOf(5.0));
        item1.setQuantity(5);
        item1.setSku("100034");
        items.add(item1);
        Item item2 = new Item();
        item2.setName("ReactJS");
        item2.setPrice(BigDecimal.valueOf(4.5));
        item2.setSku("100075");
        item2.setQuantity(4);

        items.add(item2);
        Item item3 = new Item();
        item3.setName("Java Spring");
        item3.setPrice(BigDecimal.valueOf(3.0));
        item3.setSku("100022");
        item3.setQuantity(2);
        items.add(item3);

        Payment payment = new Payment();
        BigDecimal totalPrice = items.stream().map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()))).reduce(BigDecimal.ZERO, BigDecimal::add);
        payment.setAmount(totalPrice);
        payment.setCardNumber("4111111111111111");
        payment.setCvv("123");
        payment.setMonth("04");
        payment.setYear("2030");
        order.setPayment(payment);
        return order;
    }
}
