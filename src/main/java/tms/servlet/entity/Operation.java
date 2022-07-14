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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Operation operation1 = (Operation) o;

        if (Double.compare(operation1.num1, num1) != 0) return false;
        if (Double.compare(operation1.num2, num2) != 0) return false;
        if (Double.compare(operation1.result, result) != 0) return false;
        return operation != null ? operation.equals(operation1.operation) : operation1.operation == null;
    }

    @Override
    public int hashCode() {
        int result1;
        long temp;
        temp = Double.doubleToLongBits(num1);
        result1 = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(num2);
        result1 = 31 * result1 + (int) (temp ^ (temp >>> 32));
        result1 = 31 * result1 + (operation != null ? operation.hashCode() : 0);
        temp = Double.doubleToLongBits(result);
        result1 = 31 * result1 + (int) (temp ^ (temp >>> 32));
        return result1;
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
