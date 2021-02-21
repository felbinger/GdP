package com.github.felbinger.gdp.worksheet6;

public final class SeqByDLLOperation {

    private SeqByDLLOperation() {
        throw new UnsupportedOperationException();
    }

    public static String getString(SeqByDLL seq, boolean inverted) {
        if (seq == null || seq.head == null || seq.tail == null) {
            throw new IllegalArgumentException();
        }
        DLLInt cur = (inverted) ? seq.tail : seq.head;
        String out = Integer.toString(cur.element);
        while (((inverted) ? cur.prev : cur.next) != null) {
            cur = ((inverted) ? cur.prev : cur.next);
            out += String.format(":%d", cur.element);
        }
        return out;
    }

    public static SeqByDLL insert(int value, SeqByDLL seq) {
        if (seq == null) {
            throw new IllegalArgumentException();
        }
        DLLInt insertionElement = new DLLInt(null, value, null);
        if (value <= seq.head.element) {
            insertionElement.next = seq.head;
            return new SeqByDLL(insertionElement, seq.tail);
        }
        if (value >= seq.tail.element) {
            insertionElement.prev = seq.tail;
            seq.tail.next = insertionElement;
            return new SeqByDLL(seq.head, insertionElement);
        }
        DLLInt curHead = seq.head;
        while (curHead.next != null) {
            if (value <= curHead.next.element) {
                DLLInt previous = curHead.next;
                curHead.next = insertionElement;
                insertionElement.next = previous;
                return seq;
            }
            curHead = curHead.next;
        }
        curHead.next = insertionElement;
        return seq;
    }
}
