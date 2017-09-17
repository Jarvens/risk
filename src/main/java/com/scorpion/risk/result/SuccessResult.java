package com.scorpion.risk.result;


/**
 * Created on 2017/9/16.
 */
public class SuccessResult extends BaseResult {

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public SuccessResult(Object data) {
        this();
        this.data = data;
    }

    public SuccessResult() {
        super(SUCCESS);
    }
}
