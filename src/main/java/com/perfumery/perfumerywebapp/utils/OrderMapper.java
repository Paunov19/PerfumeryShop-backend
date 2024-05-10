package com.perfumery.perfumerywebapp.utils;

import com.perfumery.perfumerywebapp.dtos.OrderDTO;
import com.perfumery.perfumerywebapp.models.Order;
import com.perfumery.perfumerywebapp.enums.OrderStatusEnum;
import com.perfumery.perfumerywebapp.models.User;

public class OrderMapper {

    public static OrderDTO convertToOrderDTO(Order order, User user) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setDeliveryAddress(order.getDeliveryAddress());
        orderDTO.setCustomerTelephone(order.getCustomerTelephone());
        orderDTO.setOrderDate(order.getOrderDate());
        orderDTO.setStatus(mapStatusToString(order.getStatus()));
        orderDTO.setTotalPrice(order.getTotalPrice());
        orderDTO.setUsername(user.getFirstName());

        return orderDTO;
    }

    public static String mapStatusToString(OrderStatusEnum status) {
        switch (status) {
            case PENDING:
                return "Поръчката е направена";
            case ACCEPTED:
                return "Поръчката е приета";
            case PACKAGING:
                return "Опаковане на поръчката";
            case READY_TO_SEND:
                return "Готова за изпращане";
            case OUT_FOR_DELIVERY:
                return "Предадена на куриерската компания";
            case DELIVERED:
                return "Доставена";
            case CANCELED:
                return "Отказана";
            default:
                return null;
        }
    }
}
