package cn.com.hohistar.tutorial.springboothelloworld.web.vo;

public class Result<T> {

    private boolean succ;
    private String code;
    private String msg;
    private T data;

    public Result() {
        this.succ = false;
    }

    public Result(String code, String msg, T data) {
        this.succ = false;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public boolean isSucc() {
        return succ;
    }

    public void setSucc(boolean succ) {
        this.succ = succ;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "succ=" + succ +
                ", code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
