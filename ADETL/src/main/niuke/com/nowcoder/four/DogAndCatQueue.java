package com.nowcoder.four;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Yjm
 * @create 2019-08-19 19:19
 */

//问题：可以先来后到取出狗，也可以先来后到取出猫，也可以取出猫狗队列中最先来的
public class DogAndCatQueue {
    public static void main(String[] args) {
        DogCatQ test = new DogCatQ();
        Pet dog1 = new Dog();
        Pet cat1 = new Cat();
        Pet dog2 = new Dog();
        Pet cat2 = new Cat();
        Pet dog3 = new Dog();
        Pet cat3 = new Cat();

        test.push(dog1);
        test.push(cat1);
        test.push(dog2);
        test.push(cat2);
        test.push(dog3);
        test.push(cat3);

        test.push(dog1);
        test.push(cat1);
        test.push(dog2);
        test.push(cat2);
        test.push(dog3);
        test.push(cat3);

        test.push(dog1);
        test.push(cat1);
        test.push(dog2);
        test.push(cat2);
        test.push(dog3);
        test.push(cat3);

        /*while(!test.isDogQueueEmpty()){
            System.out.println(test.dogPoll().getPetType());
        }*/
        while (!test.isEmpty()){
            System.out.println(test.allPoll().getPetType());
        }

    }
}

class Pet{
    private String type;

    public Pet(String type) {
        this.type = type;
    }

    public String getPetType(){
        return this.type;
    }
}
class Dog extends Pet{
    public Dog() {
        super("dog");
    }
}
class Cat extends Pet{
    public Cat() {
        super("cat");
    }
}

class DogCatEnter{
    private Pet pet;
    private int count;

    public DogCatEnter(Pet pet, int count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return pet;
    }

    public int getCount() {
        return count;
    }

    public String getPetType(){
        return this.pet.getPetType();
    }
}


class DogCatQ{
    private Queue<DogCatEnter> dogQueue;
    private Queue<DogCatEnter> catQueue;
    private int count;

    public DogCatQ() {
        this.dogQueue = new LinkedList<DogCatEnter>();;
        this.catQueue = new LinkedList<DogCatEnter>();
        this.count = 0;
    }

    public void push(Pet pet){
        if(pet == null) return ;

        if("dog".equals(pet.getPetType())){
            this.dogQueue.offer(new DogCatEnter(pet,count++));
        }else if("cat".equals(pet.getPetType())){
            this.catQueue.offer(new DogCatEnter(pet,count++));
        }else{
            throw new RuntimeException("type is error");
        }
    }

    public Pet allPoll(){
        if(!this.dogQueue.isEmpty()&&!this.catQueue.isEmpty()){
            if(this.dogQueue.peek().getCount() < this.catQueue.peek().getCount()){
                return this.dogQueue.poll().getPet();
            }else {
                return this.catQueue.poll().getPet();
            }
        }else if(!this.dogQueue.isEmpty()){
            return this.dogQueue.poll().getPet();
        }else if(!this.catQueue.isEmpty()){
            return this.catQueue.poll().getPet();
        } else {
            throw new RuntimeException("Dog and Cat queue are empty");
        }


    }

    public Dog dogPoll(){
        if(this.dogQueue.isEmpty()){
            throw new RuntimeException("Dog queue is empty");
        }

        return (Dog)this.dogQueue.poll().getPet();
    }

    public Cat catPoll(){
        if(this.catQueue.isEmpty()){
            throw new RuntimeException("Cat queue is empty");
        }

        return (Cat) this.catQueue.poll().getPet();
    }

    public boolean isEmpty(){
        return this.dogQueue.isEmpty()&&this.catQueue.isEmpty();
    }

    public boolean isDogQueueEmpty(){
        return this.dogQueue.isEmpty();
    }

    public boolean isCatQueueEmpty(){
        return this.catQueue.isEmpty();
    }

}
