
package exercises;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;


public class N20_MyHashMap<K, V> implements Map<K, V>{
    
    class MyEntry<K, V>{
        K key;
        V value;
        MyEntry<K, V> next;
        
        public MyEntry(K key, V value, MyEntry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
        
    }
    
    final int initialSize = 2;
    int size = 0;
    MyEntry<K, V>[] table = new MyEntry[initialSize];
    
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
        int hash = hash((K) key);
        if(table[hash] != null){
            MyEntry<K, V> ret = table[hash];
            while(ret!=null){
                if(ret.key.equals(key))
                    return (V) ret.value;
                ret = ret.next;
            }
        }
        return null;
    }
    
    int hash(K key){
       return Math.abs(key.hashCode()) % table.length;
    }

    @Override
    public V put(K key, V value) {
        Objects.requireNonNull(key, "key is null");

        if(++size > table.length){
            System.out.println("увеличиваем размер после put c "+table.length+" до "+table.length*2);
            table = Arrays.copyOf(table, table.length*2);
        }
        
        MyEntry<K, V> e = new MyEntry<>(key, value, null);
        int hash = hash(key);
        if (table[hash] == null) {
            System.out.println("ПРОСТО ВСТАВИЛИ "+value.toString());
            table[hash] = e;
        } else {
            System.out.println("ПЕРЕСЕЧЕНИЕ"+value.toString()+" С "+table[hash].key);
            MyEntry<K, V> current = table[hash];
            MyEntry<K, V> previous = null;
            while (current != null) {
                if (current.key.equals(key)) {
                    System.out.println("НАШЕЛ ОБЪЕКТ С ТАКИМ ЖЕ KEY "+current.key+" "+key);
                    current.value = e.value;
                    break;
                }
                previous = current;
                current = current.next;
            }
            if(previous!=null) previous.next = e;
        }
        
        
        return null;
    }

    @Override
    public V remove(Object key) {
        Objects.requireNonNull(key, "key is null");
        
        int hash = hash((K) key);
        if(table[hash] != null){
            MyEntry<K, V> ret = table[hash];
            while(ret!=null){
                if(ret.key.equals(key)) {
                    ret = null;
                    return null;
                }
            }
            ret = ret.next;
        }
        return null;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            table[i] = null;
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
    public Set<Map.Entry<K, V>> entrySet() {
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
