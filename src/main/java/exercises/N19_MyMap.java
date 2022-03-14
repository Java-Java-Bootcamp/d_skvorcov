
package exercises;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;


public class N19_MyMap<K, V> implements Map<K, V> {

    final int initialSize = 2;
    int size = 0;
    Object[] keys = new Object[initialSize];
    Object[] values = new Object[initialSize];
    
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public V get(Object key) {
        Objects.requireNonNull(key, "key is null");
        
        for (int i = 0; i < size; i++) {
            if(keys[i].equals(key))
                return (V) values[i];
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if(keys[i].equals(key)){
                values[i] = value;
                return value;
            }
        }
        if(size+1 > keys.length){
            keys = Arrays.copyOf(keys, keys.length*2);
            values = Arrays.copyOf(values, values.length*2);
        }
        
        keys[size] = key;
        values[size++] = value;
        return value;
    }

    @Override
    public V remove(Object key) {
        Object ret = null;
        for (int i = 0; i < size; i++) {
            if(keys[i].equals(key)){
                ret = values[i];
                keys[i] = null;
                values[i] = null;
                break;
            }
        }
        size--;
        if(size < keys.length/4 && keys.length/2>initialSize){
            keys = Arrays.copyOf(keys, keys.length/2);
            values = Arrays.copyOf(values, keys.length/2);
        }
        return (V) ret;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            keys[i] = null;
            values[i] = null;
        }
        size = initialSize;
    }

    /**
     * Методы ниже имплементировать не надо
     */
    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }
}