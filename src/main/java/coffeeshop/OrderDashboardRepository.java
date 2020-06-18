package coffeeshop;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderDashboardRepository extends CrudRepository<OrderDashboard, Long> {

    List<OrderDashboard> findByOrderId(Long orderId);

    void deleteByOrderId(Long orderId);
}