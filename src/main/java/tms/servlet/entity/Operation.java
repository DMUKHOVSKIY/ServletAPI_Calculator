package tms.servlet.entity;

import java.sql.Date;

public class Operation {
    private double num1;
    private double num2;
    private String operation;
    private double result;
    private User user;
    private int id;
    private Date date;

    public static class Builder {
        private final Operation op;

        public Builder() {
            op = new Operation();
        }

        public Builder num1(double num1) {
            op.num1 = num1;
            return this;
        }

        public Builder num2(double num2) {
            op.num2 = num2;
            return this;
        }

        public Builder operation(String operation) {
            op.operation = operation;
            return this;
        }

        public Builder result(double result) {
            op.result = result;
            return this;
        }

        public Builder user(User user){
            op.user = user;
            return this;
        }

        public Builder id(int id){
            op.id = id;
            return this;
        }

        public Builder date(Date date){
            op.date = date;
            return this;
        }

        public Operation build(){
            return op;
        }
    }

    public void setResult(double result) {
        this.result = result;
    }

    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }

    public String getOperation() {
        return operation;
    }

    public double getResult() {
        return result;
    }

    public User getUser() {
        return user;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "num1=" + num1 +
                ", num2=" + num2 +
                ", operation='" + operation + '\'' +
                ", result='" + result + '\'' +
                ", user=" + user +
                ", date=" + date +
                ", id=" + id +
                '}';
    }
}
