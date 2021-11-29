package com.nowcoder.six;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yjm
 * @create 2019-08-26 19:28
 */
/*设计RandomPool结构【题目】设计一种结构，在该结构中有如下三个功能：
        insert（key）：将某个key加入到该结构，做到不重复加入。
        delete（key）：将原本在结构中的某个key移除。
        getRandom）：等概率随机返回结构中的任何一个key。
        【要求】Insert、delete和getRandom方法的时间复杂度都是0（1）*/
public class RandomPool {
    public static void main(String[] args) {
        RPNode pool = new RPNode();
        pool.insert("zuo");
        pool.insert("cheng");
        pool.insert("yun");
        pool.delete("yun");
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());

    }

}
class RPNode{
    Map<String , Integer> pool_key_number;
    Map<Integer, String> pool_number_key ;
    private int size;
    public RPNode() {
        this.pool_key_number = new HashMap<>();
        this.pool_number_key = new HashMap<>();
        this.size = 0;
    }
    public void insert(String key) {
        if(key == null) return;
        if(!this.pool_key_number.containsKey(key)){
            this.pool_key_number.put(key,this.size);
            this.pool_number_key.put(this.size, key);
            size++;
        }

    }
    public void delete(String key){
        if(!this.pool_key_number.containsKey(key)) return;
        int n = this.pool_key_number.get(key); //最后一个节点最终要放的位置
        this.pool_key_number.remove(key);

        if(this.size > 1){
            String val = this.pool_number_key.get(this.size - 1);
            this.pool_key_number.put(val,n);
            this.pool_number_key.put(n, val);
            this.pool_number_key.remove(this.size - 1);
        }else {
            this.pool_number_key.remove(n);
        }
        this.size--;
    }
    public  String getRandom(){
        if(this.size == 0) return "";
        if(this.size == 1) return this.pool_number_key.get(0);

        int n = (int)(Math.random() * this.size );

        return this.pool_number_key.get(n);

    }

}