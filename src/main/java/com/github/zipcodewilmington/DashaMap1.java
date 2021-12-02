package com.github.zipcodewilmington;
import com.github.zipcodewilmington.sample.MyLinkedList;

/**
 * @author xtofer
 * @version 1.0.0
 * @date 10/21/19 9:05 AM
 */
public class DashaMap1 implements HashMapX {
    MyLinkedList[] list;


    private String HashFunctionOne(String input) {
        if (input.length() > 0) {
            return (String.valueOf(input.charAt(0)).toLowerCase());
        }
        return null;
    }


    @Override
    public void set(String key, Integer value) {
        String hashFunctionOne = HashFunctionOne(key);
        int index = hashFunctionOne.charAt(0)-97;

        this.list[index].addNode(key, Integer.parseInt(String.valueOf(value)));

    }

    @Override
    public String delete(String key) {
        return null;
    }

    @Override
    public String get(String key) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        if (size() == 0){
            return true;
        }
        return false;
    }

    @Override
    public long size() {
        return 0;
    }

    @Override
    public boolean bucketSize(String key) {
        return false;
    }
}
