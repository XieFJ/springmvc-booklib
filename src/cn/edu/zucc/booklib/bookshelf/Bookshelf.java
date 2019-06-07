/*
 * 
 * Copyright 2001 Sun Microsystems, Inc. All Rights Reserved.
 * 
 * This software is the proprietary information of Sun Microsystems, Inc. Use is
 * subject to license terms.
 *  
 */

package cn.edu.zucc.booklib.bookshelf;

import java.util.Collection;
import java.util.HashMap;

import cn.edu.zucc.booklib.databean.BeanBook;

public class Bookshelf {
    HashMap<String,BookshelfItem> items = null;

    int numberOfItems = 0;

    public Bookshelf() {
        items = new HashMap<>();
    }

    public synchronized void add(int bookId, BeanBook book) {
        if (items.containsKey(bookId)) {
            BookshelfItem scitem = (BookshelfItem) items.get(bookId);
            scitem.incrementQuantity();
        } else {
            BookshelfItem newItem = new BookshelfItem(book);
            items.put(bookId, newItem);
        }

        numberOfItems++;
    }

    public synchronized void remove(int bookId) {
        if (items.containsKey(bookId)) {
            BookshelfItem scitem = (BookshelfItem) items.get(bookId);
            scitem.decrementQuantity();

            if (scitem.getQuantity() <= 0)
                items.remove(bookId);

            numberOfItems--;
        }
    }

    public synchronized Collection<BookshelfItem> getItems() {
        return items.values();
    }

    protected void finalize() throws Throwable {
        items.clear();
    }

    public synchronized int getNumberOfItems() {
        return numberOfItems;
    }

//    public synchronized double getTotal() {
//        double amount = 0.0;
//
//        for (Iterator i = getItems().iterator(); i.hasNext();) {
//            BookshelfItem item = (BookshelfItem) i.next();
//            BeanBook book = (BeanBook) item.getItem();
//
////            amount += item.getQuantity() * BeanBook.getPrice();
//        }
//        return roundOff(amount);
//    }
//
//    private double roundOff(double x) {
//        long val = Math.round(x * 100); // cents
//        return val / 100.0;
//    }

    public synchronized void clear() {
        items.clear();
        numberOfItems = 0;
    }
}
