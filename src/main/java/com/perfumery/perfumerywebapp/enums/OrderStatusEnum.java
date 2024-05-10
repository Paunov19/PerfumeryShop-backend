package com.perfumery.perfumerywebapp.enums;

public enum OrderStatusEnum {
    PENDING("Поръчката е направена"),
    ACCEPTED("Поръчката е приета"),
    PACKAGING("Опаковане на поръчката"),
    READY_TO_SEND("Готова за изпращане"),
    OUT_FOR_DELIVERY("Предадена на куриерската компания"),
    DELIVERED("Доставена"),
    CANCELED("Отказана");

    private final String status;

    OrderStatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}