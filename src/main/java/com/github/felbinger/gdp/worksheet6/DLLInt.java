package com.github.felbinger.gdp.worksheet6;

public final class DLLInt {
    @SuppressWarnings("checkstyle:visibilitymodifier")
    public DLLInt prev;
    @SuppressWarnings("checkstyle:visibilitymodifier")
    public int element;
    @SuppressWarnings("checkstyle:visibilitymodifier")
    public DLLInt next;

    public DLLInt(DLLInt p, int e, DLLInt n) {
        prev = p;
        element = e;
        next = n;
    }
}
