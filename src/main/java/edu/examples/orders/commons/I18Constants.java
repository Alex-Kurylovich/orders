package edu.examples.orders.commons;

import lombok.Getter;

@Getter
public enum I18Constants {
    NO_ITEM_FOUND("entity.absent");

    final String key;
    I18Constants(String key) {
        this.key = key;
    }
}
