package com.river.weibo.vo;

public class ResponseVO<T> {

    public static final int CODE_SUCCESS = 200;
    public static final int CODE_FAILURE = 500;
    public static final int CODE_PARAM_ERROR = 400;

    public static final String MSG_SUCCESS = "Interface request is successful!";
    public static final String MSG_FAILURE = "The program processing error!";
    public static final String MSG_PARAM_ERROR = "Request parameter is wrong!";

    public static final String FAILURE_RESULT = "{\"code\":500,\"message\":\"The program processing error!\"}";

    /**
     * 响应相应码
     */
    private int code;
    /**
     * 响应相应信息
     */
    private String message;
    /**
     * 业务结果
     */
    private T data;

    private Integer total ;

    public ResponseVO buildSuccessResponse(){
        this.setCode(CODE_SUCCESS);
        this.setMessage(MSG_SUCCESS);
        return this;
    }
    public ResponseVO buildSuccessResponse(T data){
        this.setCode(CODE_SUCCESS);
        this.setMessage(MSG_SUCCESS);
        this.setData(data);
        return this;
    }
    public ResponseVO buildFailureResponse(){
        this.setCode(CODE_FAILURE);
        this.setMessage(MSG_FAILURE);
        return this;
    }
    public ResponseVO buildFailureResponse(String msg){
        this.setCode(CODE_FAILURE);
        this.setMessage(msg);
        return this;
    }

    public ResponseVO buildParamErrorResponse(){
        this.setCode(CODE_PARAM_ERROR);
        this.setMessage(MSG_PARAM_ERROR);
        return this;
    }

    public ResponseVO buildErrorResponse(String message){
        this.setCode(CODE_PARAM_ERROR);
        this.setMessage(message);
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public ResponseVO setData(T data) {
        this.data = data;
        return this;
    }

    public void setResult(int resultCode, String resultMessage) {
        this.code = resultCode;
        this.message = resultMessage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
