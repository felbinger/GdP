package com.github.felbinger.gdp.worksheet6;

public final class SLLInt {
    // SLLInt: Single Linked List
    @SuppressWarnings("checkstyle:visibilitymodifier")
    public int element;
    @SuppressWarnings("checkstyle:visibilitymodifier")
    public SLLInt next;

    public SLLInt(int e, SLLInt n) {
        element = e;
        next = n;
    }

    public SLLInt(int e) {
        element = e;
        next = null;
    }
}
