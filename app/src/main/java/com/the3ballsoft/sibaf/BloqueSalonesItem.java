package com.the3ballsoft.sibaf;

public class BloqueSalonesItem extends AbstractGroupItem {

    public BloqueSalonesItem(String salon, String bloque) {
        super(salon);
        setGroup(bloque);
    }

    public BloqueSalonesItem(String salon) {
        super(salon);
        setGroup(BloqueSalonesItem.class.getSimpleName());
    }


}