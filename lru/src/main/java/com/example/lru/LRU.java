package com.example.lru;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * @param <K>
 * @param <V>
 */
public class LRU<K, V> {

    //链表长度
    private int _size = 0;

    //缓存容量
    private int _capacity;

    //数据缓存
    private HashMap<K, ListNode<K, V>> _dic;


    //头结点数据
    private ListNode<K, V> _linkHead;



    public HashMap<K,ListNode<K,V>> Map(){
        return  _dic;
    }

    /**
     * @param capacity
     */
    public LRU(int capacity) {
        _linkHead = new ListNode<K, V>(null, null);
        _linkHead._next = _linkHead._prev = _linkHead;
        this._capacity = capacity;
        this._dic = new HashMap<K, ListNode<K, V>>();
    }


    public V Get(K key) {
        if (_dic.containsKey(key)) {
            ListNode<K, V> target = _dic.get(key);
            //使用过改元素，则将元素移动到头结点
            MoveToHead(target);
            return target._value;
        } else {
            return null;
        }
    }


    /**
     * 设置一个值
     * @param key
     * @param value
     */
    public void Set(K key,V value){
        ListNode<K,V> target;
        if (_dic.containsKey(key)){
            target=_dic.get(key);
            target._value=value;
            //移动到表头
            MoveToHead(target);

        }else {
            target =new ListNode<K,V>(key,value);
            //添加到表头
            AttachToHead(target);
            _dic.put(key,target);
            _size++;
        }
        if (_size>_capacity){
            ListNode<K,V> listNode=RemoveLast();
            _size--;
        }
    }


    /**
     * 删除最后一个元素
     * @return
     */
    private ListNode<K,V> RemoveLast(){
        ListNode<K,V> delNode=_linkHead._prev;
        RemoveFromList(delNode);
        _dic.remove(delNode._key);
        return delNode;
    }



    private void MoveToHead(ListNode<K, V> target) {
        //删除本节点
        RemoveFromList(target);

        //添加到头结点
        AttachToHead(target);
    }

    /**
     * 将孤立的节点放到头结点
     * @param target
     */
    private void AttachToHead(ListNode<K, V> target) {
        target._prev=_linkHead;
        target._next=_linkHead._next;
        _linkHead._next._prev=target;
        _linkHead._next=target;
    }

    /**
     * 删除本节点
     * @param target
     */
    private void RemoveFromList(ListNode<K, V> target) {
        target._prev._next=target._next;
        target._next._prev=target._prev;
    }

    public int Count() {
        return _size;
    }
}


class ListNode<K, V> {

    /**
     * 前一节点
     */
    public ListNode<K, V> _prev;

    /**
     * 后一节点
     */
    public ListNode<K, V> _next;

    //键
    public K _key;

    //值
    public V _value;

    /***
     * 构造
     * @param key
     * @param value
     */
    public ListNode(K key, V value) {
        this._key = key;
        this._value = value;
        this._prev = null;
        this._next = null;
    }


}