package learn.lhb.aop.logging.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @author Herbie Leung
 * @date 2020/7/21
 * @time 09:26
 */
public class OrderDTO implements Serializable {


    private static final long serialVersionUID = -90000035L;

    private String OrderNo;

    private Map<String,Object> OrderMap;

    private List<OrderDTO> OrderList;

    @Override
    public String toString() {
        return "OrderDTO{" +
                "OrderNo='" + OrderNo + '\'' +
                ", OrderMap=" + OrderMap +
                ", OrderList=" + OrderList +
                '}';
    }

    public String getOrderNo() {
        return OrderNo;
    }

    public void setOrderNo(String orderNo) {
        OrderNo = orderNo;
    }

    public Map<String, Object> getOrderMap() {
        return OrderMap;
    }

    public void setOrderMap(Map<String, Object> orderMap) {
        OrderMap = orderMap;
    }

    public List<OrderDTO> getOrderList() {
        return OrderList;
    }

    public void setOrderList(List<OrderDTO> orderList) {
        OrderList = orderList;
    }
}
