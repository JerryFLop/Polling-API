package com.Jermeiahpollingapi.pollingapi.dto;

import java.util.Collection;

public class OptionCount {
    private Long optionId;
    private int count;

    public Long getOptionId() {
        return optionId;
    }
    public void setOptionId(Long optionId) {
        this.optionId = optionId;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
}
