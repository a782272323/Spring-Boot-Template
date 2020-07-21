package learn.lhb.aop.logging.controller;

import com.alibaba.fastjson.JSON;
import learn.lhb.aop.logging.config.PrintlnLog;
import learn.lhb.aop.logging.entity.OrderDTO;
import learn.lhb.aop.logging.entity.OrderVO;
import learn.lhb.aop.logging.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description  
 * @author Herbie Leung
 * @date 2020/7/21 
 * @time 09:23
 */
@RestController
public class OrderController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OrderService orderService;


    /**
     * 普通的打印日志
     * @param orderVO
     * @param name
     * @return
     */
    @GetMapping("/order")
    public OrderDTO getOrder1(OrderVO orderVO, String name) {
        log.info("订单详情入参：orderVO={},name={}", JSON.toJSONString(orderVO), name);
        OrderDTO orderInfo = orderService.getOrderInfo(orderVO);
        log.info("订单详情结果：orderInfo={}", JSON.toJSONString(orderInfo));
        return orderInfo;
    }

    /**
     * 使用aop打印日志
     * @param orderVO
     * @param name
     * @return
     */
    @PrintlnLog(description = "订单详情Controller")
    @GetMapping("/aop/order")
    public OrderDTO getOrder2(OrderVO orderVO, String name) {
        OrderDTO orderInfo = orderService.getOrderInfo(orderVO);
        return orderInfo;
    }
}
