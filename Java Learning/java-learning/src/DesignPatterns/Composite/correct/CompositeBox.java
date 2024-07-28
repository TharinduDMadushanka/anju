package DesignPatterns.Composite.correct;

import java.util.ArrayList;
import java.util.Arrays;

public class CompositeBox implements Box{

    private final ArrayList<Box> elements = new ArrayList<Box>();

    public CompositeBox(Box ...boxes) {
        elements.addAll(Arrays.asList(boxes));
    }

    @Override
    public double calculate() {
        return elements.stream().mapToDouble(Box::calculate).sum();
    }
}
