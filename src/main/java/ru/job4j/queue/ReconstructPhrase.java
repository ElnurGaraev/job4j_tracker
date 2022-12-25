package ru.job4j.queue;

import javax.print.DocFlavor;
import java.util.*;

public class ReconstructPhrase {
    private final Queue<Character> descendingElements;
    private final Queue<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Queue<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder st = new StringBuilder();
        int size = evenElements.size();
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                st.append(evenElements.peek());
                evenElements.poll();
            } else {
                evenElements.poll();
            }
        }
        return st.toString();
    }

    private String getDescendingElements() {
        Deque<Character> deque = new LinkedList<>(descendingElements);
        StringBuilder st = new StringBuilder();
        int size = descendingElements.size();
        for (int i = 0; i < size; i++) {
            st.append(deque.peekLast());
            deque.pollLast();
        }
        return st.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
