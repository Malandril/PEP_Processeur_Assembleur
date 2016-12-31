package pep.projet_proc;

/**
 * Created by user on 29/12/2016.
 */
public class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Gets value.
     *
     * @return Value of value.
     */
    public V getValue() {
        return value;
    }

    /**
     * Sets new value.
     *
     * @param value New value of value.
     */
    public void setValue(V value) {
        this.value = value;
    }

    /**
     * Gets key.
     *
     * @return Value of key.
     */
    public K getKey() {
        return key;
    }

    /**
     * Sets new key.
     *
     * @param key New value of key.
     */
    public void setKey(K key) {
        this.key = key;
    }

}
