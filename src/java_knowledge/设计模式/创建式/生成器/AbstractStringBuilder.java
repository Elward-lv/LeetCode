package java_knowledge.设计模式.创建式.生成器;

import java.util.Arrays;

/**
 * 生成器设计模式的实现
 */
public abstract class AbstractStringBuilder {
    protected char[] values;
    protected int count;

    public AbstractStringBuilder(int capcity) {
        values = new char[capcity];
        count = 0;
    }

    public AbstractStringBuilder append(char c){
        ensureCapacityInternal(count + 1);
        values[count++] = c;
        return this;
    }

    private void ensureCapacityInternal(int minimumCapacity){
        if(minimumCapacity - values.length > 0){
            extendsCapcity(minimumCapacity);
        }
    }

    private void extendsCapcity(int minimumCapacity) {
        int newCapcity = values.length * 2 + 2;
        if(newCapcity - minimumCapacity < 0){
            newCapcity = minimumCapacity;
        }
        if(newCapcity < 0){
            if (minimumCapacity < 0) {
                throw new OutOfMemoryError();
            }
            newCapcity = Integer.MAX_VALUE;
        }
        values = Arrays.copyOf(values,newCapcity);
    }
}
