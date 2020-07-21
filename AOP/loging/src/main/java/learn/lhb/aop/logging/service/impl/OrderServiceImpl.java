package learn.lhb.aop.logging.service.impl;

import learn.lhb.aop.logging.entity.OrderDTO;
import learn.lhb.aop.logging.entity.OrderVO;
import learn.lhb.aop.logging.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @author Herbie Leung
 * @date 2020/7/21
 * @time 09:24
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public OrderDTO getOrderInfo(OrderVO orderVO) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderNo("A0000001");
        Map<String, Object> map = new HashMap<>();
        map.put("money", 444);
        map.put("shopId", 1002);
        orderDTO.setOrderMap(map);
        return orderDTO;
    }
}
