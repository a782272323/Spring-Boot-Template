package learn.lhb.aop.logging.entity;

import java.io.Serializable;

/**
 * @Description
 * @author Herbie Leung
 * @date 2020/7/21
 * @time 09:25
 */
public class OrderVO implements Serializable {


    private static final long serialVersionUID = -92868911L;
    private String OrderNo;

    @Override
    public String toString() {
        return "OrderVo{" +
                "OrderNo='" + OrderNo + '\'' +
                '}';
    }

    public String getOrderNo() {
        return OrderNo;
    }

    public void setOrderNo(String orderNo) {
        OrderNo = orderNo;
    }
}
