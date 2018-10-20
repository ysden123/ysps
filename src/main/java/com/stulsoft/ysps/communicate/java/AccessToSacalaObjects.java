/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.ysps.communicate.java;

/**
 * Demonstrates accessing Scala case class attributes from Java
 *
 * @author Yuriy Stul
 */
public class AccessToSacalaObjects {
    public static void main(String[] args) {
        System.out.println("==>main");
        // Create new instance of the Scala case class
        ScalaObject1 so1 = new ScalaObject1("some name", 123, 123.45);
        // Access to toString method
        System.out.printf("so1: %s%n", so1);
        // Access to val attributes
        System.out.printf("so1.age() = %d%n", so1.age());
        System.out.printf("so1.name() = %s%n", so1.name());
        // Access to var attributes: read
        System.out.printf("(1) so1.weight() = %.2f%n", so1.weight());
        // Access to var attributes: write (update)
        so1.weight_$eq(543.21);
        System.out.printf("(2) so1.weight() = %.2f%n", so1.weight());
        System.out.println("<==main");
    }
}
