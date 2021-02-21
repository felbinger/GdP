package com.github.felbinger.gdp.worksheet6;

@SuppressWarnings("checkstyle:hideUtilityclassconstructor")
public final class SLLIntOperation {

    private SLLIntOperation() {
        throw new UnsupportedOperationException();
    }

    public static String getString(SLLInt seq) {
        if (seq == null) {
            throw new IllegalArgumentException();
        }
        return seq.element + ((seq.next != null) ? ":" + getString(seq.next) : "");
    }

    public static int getLength(SLLInt seq) {
        int len = 0;
        if (seq == null) {
            return len;
        }
        SLLInt cur = seq;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        return len;
    }

    public static boolean isSorted(SLLInt seq) {
        if (seq == null) {
            throw new IllegalArgumentException();
        }
        SLLInt cur = seq;
        while (cur.next != null) {
            if (cur.element > cur.next.element) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }

    public static SLLInt insert(int value, SLLInt seq) {
        if (!isSorted(seq)) {
            throw new IllegalArgumentException();
        }
        SLLInt insertionElement = new SLLInt(value);
        if (value < seq.element) {
            insertionElement.next = seq;
            return insertionElement;
        }
        SLLInt cur = seq;
        while (cur.next != null) {
            if (value <= cur.next.element) {
                SLLInt previous = cur.next;
                cur.next = insertionElement;
                insertionElement.next = previous;
                return seq;
            }
            cur = cur.next;
        }
        cur.next = insertionElement;
        return seq;
    }

    public static boolean isEqualRekursiv(SLLInt seq1, SLLInt seq2) {
        return getString(seq1).equals(getString(seq2));
    }

    public static boolean isEqualIterativ(SLLInt seq1, SLLInt seq2) {
        SLLInt cur1 = seq1;
        SLLInt cur2 = seq2;
        if (cur1 == null || cur2 == null) {
            throw new IllegalArgumentException();
        }
        if (getLength(cur1) != getLength(cur2)) {
            return false;
        }
        while (cur1.next != null && cur2.next != null) {
            if (cur1.element != cur2.element) {
                return false;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return true;
    }

    public static SLLInt concat(SLLInt seq1, SLLInt seq2) {
        if (seq1 == null) {
            throw new IllegalArgumentException();
        }
        SLLInt cur = seq1;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = seq2;
        return seq1;
    }
}
