package com.github.felbinger.gdp.worksheet6;

public final class SLLInt {

    @SuppressWarnings("checkstyle:visibilitymodifier")
    public transient int element;

    @SuppressWarnings("checkstyle:visibilitymodifier")
    public transient SLLInt next;

    public SLLInt(int e, SLLInt n) {
        element = e;
        next = n;
    }

    public SLLInt(int e) {
        element = e;
    }
}
