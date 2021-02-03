package Day1.lab3;

import java.io.Serializable;

public class MyClass implements Serializable {

    String s;
    int i;
    double d;
    transient String demo = "Non Transient Attribute";

    public MyClass(String s, int i, double d) {
        this.s = s;
        this.i = i;
        this.d = d;
    }

    public String toString() {
        return "s= " + s + "; i= " + i + "; d= " + d + "; demo= " + demo;
    }
}
