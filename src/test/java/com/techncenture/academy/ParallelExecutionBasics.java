package com.techncenture.academy;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Instant;

public class ParallelExecutionBasics {

    long start = 0;
    long end = 0;

    @BeforeTest
    public void start(){
        System.out.println("starting to execute all test cases");
        start = Instant.now().getEpochSecond(); //recording the start time
    }


    @AfterTest
    public void end(){
        System.out.println("Finished running all test cases");
        end = Instant.now().getEpochSecond();

        System.out.println(end - start);
    }



    @Test
    public void test1() throws InterruptedException {
        System.out.println("Test 1");
        Thread.sleep(6000);
    }


    @Test
    public void test2() throws InterruptedException {
        System.out.println("Test 2");
        Thread.sleep(1780);
    }

    @Test
    public void test3() throws InterruptedException {
        System.out.println("Test 3");
        Thread.sleep(2640);
    }

    @Test
    public void test4() throws InterruptedException {
        System.out.println("Test 4");
        Thread.sleep(1040);
    }

    @Test
    public void test5() throws InterruptedException {
        System.out.println("Test 5");
        Thread.sleep(3600);
    }

    @Test
    public void test6() throws InterruptedException {
        System.out.println("Test 6");
        Thread.sleep(3200);
    }

    @Test
    public void test7() throws InterruptedException {
        System.out.println("Test 7");
        Thread.sleep(2500);
    }

    @Test
    public void test8() throws InterruptedException {
        System.out.println("Test 8");
        Thread.sleep(4000);
    }

    @Test
    public void test9() throws InterruptedException {
        System.out.println("Test 9");
        Thread.sleep(6300);
    }


    @Test
    public void test10() throws InterruptedException {
        System.out.println("Test 10");
        Thread.sleep(500);
    }

}
