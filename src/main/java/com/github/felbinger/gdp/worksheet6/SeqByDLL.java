package com.github.felbinger.gdp.worksheet6;

public final class SeqByDLL {
    @SuppressWarnings("checkstyle:visibilitymodifier")
    public DLLInt head;
    @SuppressWarnings("checkstyle:visibilitymodifier")
    public DLLInt tail;

    public SeqByDLL(DLLInt h, DLLInt t) {
        head = h;
        tail = t;
    }
}
