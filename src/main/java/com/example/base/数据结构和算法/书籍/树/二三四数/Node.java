package com.example.base.数据结构和算法.书籍.树.二三四数;

/**
 * @author jiwei.xue
 * @date 2021/1/4 10:50
 */
public class Node {

    private static final int ORDER = 4;

    private int numItems;

    private Node parent;

    private Node[] childArray = new Node[ORDER];

    private DataItem[] itemArray = new DataItem[ORDER - 1];

    /**
     * connect child to this node
     *
     * @param childNum
     * @param child
     */
    public void connectChild(int childNum, Node child) {
        childArray[childNum] = child;
        if (child != null) {
            child.parent = this;
        }
    }

    /**
     * disconnect child from this node,return it
     *
     * @param childNum
     * @return
     */
    public Node disconnectChild(int childNum) {
        Node tempNode = childArray[childNum];
        childArray[childNum] = null;
        return tempNode;
    }

    /**
     * get child
     *
     * @param childNum
     * @return
     */
    public Node getChild(int childNum) {
        return childArray[childNum];
    }

    /**
     * get parent
     *
     * @return
     */
    public Node getParent() {
        return parent;
    }

    /**
     * 是否是叶子节点
     *
     * @return
     */
    public boolean isLeaf() {
        return (childArray[0] == null) ? true : false;
    }

    /**
     * @return
     */
    public int getNumItems() {
        return numItems;
    }

    /**
     * get DataItem at index
     *
     * @param index
     * @return
     */
    public DataItem getItem(int index) {
        return itemArray[index];
    }

    /**
     * isFull
     *
     * @return
     */
    public boolean isFull() {
        return (numItems == ORDER - 1) ? true : false;
    }

    /**
     * 通过key查找索引
     *
     * @param key
     * @return
     */
    public int findItem(long key) {
        for (int j = 0; j < ORDER - 1; j++) {
            if (itemArray[j] == null) {
                break;
            } else if (itemArray[j].dData == key) {
                return j;
            }
        }
        return -1;
    }

    /**
     * 插入数据项
     *
     * @param newItem
     * @return
     */
    public int insertItem(DataItem newItem) {
        numItems++;
        long newKey = newItem.dData;
        for (int j = ORDER - 2; j >= 0; j--) {
            if (itemArray[j] == null) {
                continue;
            } else {
                long itskey = itemArray[j].dData;
                if (newKey < itskey) {
                    itemArray[j + 1] = itemArray[j];
                } else {
                    itemArray[j + 1] = newItem;
                    return j + 1;
                }
            }
        }
        itemArray[0] = newItem;
        return 0;
    }

    /**
     * 删除最大的数据项 remove largest item
     *
     * @return
     */
    public DataItem removeItem() {
        DataItem temp = itemArray[numItems - 1];
        itemArray[numItems - 1] = null;
        numItems--;
        return temp;
    }

    public void dispalyNode() {
        for (int j = 0; j < numItems; j++) {
            itemArray[j].displayItem();
        }
        System.out.println("/");
    }
}
