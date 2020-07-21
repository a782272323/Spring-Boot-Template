package learn.lhb.aop.logging.service;

import learn.lhb.aop.logging.entity.OrderDTO;
import learn.lhb.aop.logging.entity.OrderVO;

/**
 * @Description  
 * @author Herbie Leung
 * @date 2020/7/21 
 * @time 09:23
 */
public interface OrderService {

    OrderDTO getOrderInfo(OrderVO orderVO);
}
