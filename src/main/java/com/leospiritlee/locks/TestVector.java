package com.leospiritlee.locks;

import java.util.Vector;

/**
 * @Project: CodeSegment
 * @ClassName TestVector
 * @description: Vector 测试
 *  方法一 和 方法二 会冲突
 * @author: leospiritlee
 * @create: 2020-06-21 17:32
 **/
public class TestVector {

    private Vector<String> vector;

    /**
     *  方法一
     * @param vector
     * @return
     */
    public Object getLast(Vector vector){
        int lastIndex = vector.size() - 1;
        return vector.get(lastIndex);
    }

    /**
     *  方法二
     * @param vector
     * @return
     */
    public void deleteLast(Vector vector){
        int lastIndex = vector.size() - 1;
        vector.remove(lastIndex);
    }

    public Object getLastSynchronized(Vector vector){
        synchronized(vector){
            int lastIndex = vector.size() - 1;
            return vector.get(lastIndex);
        }
    }

    public void deleteLastSynchronized(Vector vector){
        synchronized(vector){
            int lastIndex = vector.size() - 1;
            vector.remove(lastIndex);
        }
    }

}
