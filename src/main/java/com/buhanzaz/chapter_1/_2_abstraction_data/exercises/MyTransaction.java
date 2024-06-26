package com.buhanzaz.chapter_1._2_abstraction_data.exercises;

import java.util.Date;
import java.util.Objects;

public class MyTransaction implements Comparable<MyTransaction> {
    private final String who;
    private final Date when;
    private final double amount;

    public MyTransaction(String who, Date when, double amount) {
        this.who = who;
        this.when = when;
        this.amount = amount;
    }

    public MyTransaction(String transaction) {
        String[] split = transaction.split("\\s+");
        this.who = split[0];
        this.when = new Date(Long.parseLong(split[1]));
        this.amount = Double.parseDouble(split[2]);
    }

    public String who() {
        return who;
    }

    public Date when() {
        return when;
    }

    public double amount() {
        return amount;
    }

    @Override
    public String toString() {
        return "MyTransaction{" + "Who=" + who +
                ", When=" + when +
                ", Amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MyTransaction other = (MyTransaction) obj;
        return this.who.equals(other.who) && this.when.equals(other.when) && this.amount == other.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(who, when, amount);
    }

    @Override
    public int compareTo(MyTransaction o) {
        return this.when.compareTo(o.when());
    }
}
