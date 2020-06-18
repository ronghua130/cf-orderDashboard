package coffeeshop;

import coffeeshop.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class OrderDashboardViewHandler {


    @Autowired
    private OrderDashboardRepository orderDashboardRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_CREATE_1 (@Payload OrderPlaced orderPlaced) {
        try {
            if (orderPlaced.isMe()) {
                // view 객체 생성
                OrderDashboard orderDashboard = new OrderDashboard();
                // view 객체에 이벤트의 Value 를 set 함
                orderDashboard.setOrderId(orderPlaced.getOrderId());
                orderDashboard.setCoffeeId(orderPlaced.getCoffeeId());
                orderDashboard.setCoffeeName(orderPlaced.getCoffeeName());
                orderDashboard.setPrice(orderPlaced.getPrice());
                orderDashboard.setQty(orderPlaced.getQty());
                orderDashboard.setOrderStatus(orderPlaced.getOrderStatus());
                // view 레파지 토리에 save
                orderDashboardRepository.save(orderDashboard);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaid_then_UPDATE_1(@Payload Paid paid) {
        try {
            if (paid.isMe()) {
        System.out.println("################# HERE Paid " );
                // view 객체 조회
                List<OrderDashboard> orderDashboardList = orderDashboardRepository.findByOrderId(paid.getOrderId());
                for(OrderDashboard orderDashboard : orderDashboardList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderDashboard.setTotalAmount(paid.getTotalAmount());
                    orderDashboard.setOrderStatus(paid.getOrderStatus());
                    orderDashboard.setPaymentStatus(paid.getPaymentStatus());
                    System.out.println("################# paid.getTotalAmount(): " + paid.getTotalAmount());
                    System.out.println("################# paid.paid.getOrderStatus(): " + paid.getOrderStatus());
                    System.out.println("################# paid.getPaymentStatus(): " + paid.getPaymentStatus());
                    // view 레파지 토리에 save
                    orderDashboardRepository.save(orderDashboard);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenMakeStarted_then_UPDATE_3(@Payload MakeStarted makeStarted) {
        try {
            if (makeStarted.isMe()) {
                System.out.println("################# HERE MakeStarted " );
                // view 객체 조회
                List<OrderDashboard> orderDashboardList = orderDashboardRepository.findByOrderId(makeStarted.getOrderId());
                for(OrderDashboard orderDashboard : orderDashboardList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderDashboard.setTotalAmount(makeStarted.getTotalAmount());
                    orderDashboard.setOrderStatus(makeStarted.getOrderStatus());
                    orderDashboard.setPaymentStatus(makeStarted.getPaymentStatus());
                    orderDashboard.setMakeStatus(makeStarted.getMakeStatus());
                    // view 레파지 토리에 save
                    orderDashboardRepository.save(orderDashboard);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenMakeCompleted_then_UPDATE_2(@Payload MakeCompleted makeCompleted) {
        try {
            if (makeCompleted.isMe()) {
                System.out.println("################# HERE MakeCompleted " );
                // view 객체 조회
                List<OrderDashboard> orderDashboardList = orderDashboardRepository.findByOrderId(makeCompleted.getOrderId());
                for(OrderDashboard orderDashboard : orderDashboardList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderDashboard.setOrderStatus(makeCompleted.getOrderStatus());
                    orderDashboard.setPaymentStatus(makeCompleted.getPaymentStatus());
                    orderDashboard.setMakeStatus(makeCompleted.getMakeStatus());
                    // view 레파지 토리에 save
                    orderDashboardRepository.save(orderDashboard);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCanceled_then_DELETE_1(@Payload OrderCanceled orderCanceled) {
        try {
            if (orderCanceled.isMe()) {
                // view 레파지 토리에 삭제 쿼리
                orderDashboardRepository.deleteByOrderId(orderCanceled.getOrderId());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}