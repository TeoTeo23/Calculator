package com.example.calculator;

import androidx.annotation.NonNull;

public class Calculator {
    public int prefix;
    public int suffix;
    public int result;

    public Calculator(int p, int s){
        this.prefix = p;
        this.suffix = s;
    }
    public int getPrefix(){ return this.prefix; }
    public int getSuffix(){ return this.suffix; }
    public int getResult(){ return this.result; }

    public void setResult(int r){ this.result = r; }

    public int sum(int p, int s){ return p + s; }
    public int sub(int p, int s){ return p - s; }
    public int mul(int p, int s){ return p * s; }
    public int div(int p, int s) throws  DivisionException{
        if(s == 0)
            throw new DivisionException("Divsion by zero.\r\n");
        return p / s;
    }
    public int elv(int p, int exp){ return (int)Math.pow(p, exp); }
    public int factorial(int p) throws FactorialException{
        if(p < 0)
            throw new FactorialException("Factorial with negative number.\r\n");
        if(p <= 1)
            return 1;
        return p * factorial(p - 1);
    }
    public double mod(int p, int s){ return p % s; }
    @NonNull
    @Override
    public String toString(){
        return String.valueOf(this.getResult());
    }
}
