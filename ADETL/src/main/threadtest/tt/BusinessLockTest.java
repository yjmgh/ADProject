package tt;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yuanjiameng
 * @create 2021-11-29 10:52
 * @describe
 */

class AccountWithLock{

    int balance;
    private Lock lock;

    public AccountWithLock() {
        this.balance = 0;
        this.lock = new ReentrantLock();
    }

    public void lockAccount(){
        lock.lock();
    }

    public void unLockAccount(){
        lock.unlock();
    }

    public void login(){
        //需要验证代码
    }

    public void logout(){


    }

    public void add (){
        balance += 800;
        System.out.println("After add balance is:" + balance);
    }

    public void minus(){

        balance -= 800;
        System.out.println("After minus balance is:" + balance);
    }
}

class AddThreadWithLock extends Thread{
    String person;
    AccountWithLock acc ;

    public AddThreadWithLock(String person, AccountWithLock acc) {
        this.person = person;
        this.acc = acc;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            acc.lockAccount();
            try {
                System.out.println(person + " add money,"+i+"cnt");
                acc.login();
                System.out.println(person + " login ");
                acc.add();
                System.out.println(person + " logout ");
                acc.logout();
            }finally {
                acc.unLockAccount();
            }
        }
    }
}


class MinusThreadWithLock extends Thread{
    String person;
    AccountWithLock acc ;

    public MinusThreadWithLock(String person, AccountWithLock acc) {
        this.person = person;
        this.acc = acc;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            acc.lockAccount();
            try{
                System.out.println(person + " minus money,"+i+"cnt");
                acc.login();
                System.out.println(person + " login ");
                acc.minus();
                System.out.println(person + " logout ");
                acc.logout();
            }finally {
                acc.unLockAccount();
            }
        }
    }
}

public class BusinessLockTest {


    public static void main(String[] args) {

        AccountWithLock acc = new AccountWithLock();

        Thread add = new AddThreadWithLock("Tom", acc);
        Thread minus = new MinusThreadWithLock("Peter", acc);

        add.start();
        minus.start();
    }
}
