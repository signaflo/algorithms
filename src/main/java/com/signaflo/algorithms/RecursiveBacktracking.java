package com.signaflo.algorithms;

import java.util.Objects;

public final class RecursiveBacktracking<T extends DecisionChoice, V extends Goal> {

    private final int numberOfChoices;
    private T currentDecision;
    private V goal;

    private RecursiveBacktracking(Builder<T, V> builder) {
        this.numberOfChoices = builder.numberOfChoices;
        this.currentDecision = Objects.requireNonNull(builder.initialDecision);
        this.goal = Objects.requireNonNull(builder.goal);
    }

    public boolean makeNextDecision(T lastDecisionChoice) {
        boolean atGoal = false;
        int choiceNumber = 0;
        while (!atGoal && choiceNumber < numberOfChoices) {
            currentDecision = nextChoice(choiceNumber, lastDecisionChoice);
            if (currentDecision.isValid()) {
                currentDecision.record();
                if (goal.hasBeenReached()) {
                    return true;
                } else {
                    atGoal = makeNextDecision(currentDecision);
                    if (!atGoal) {
                        currentDecision.unRecord();
                    }
                }
            }
            choiceNumber++;
        }
        return atGoal;
    }

    private T nextChoice(int choiceNumber, T lastDecision) {
        return null;
    }

    public static <T extends DecisionChoice, V extends Goal> Builder<T, V> builder() {
        return new Builder<>();
    }

    public static class Builder<T extends DecisionChoice, V extends Goal> {
        private int numberOfChoices = 0;
        private T initialDecision;
        private V goal;

        public Builder<T, V> setNumberOfChoices(int numberOfChoices) {
            this.numberOfChoices = numberOfChoices;
            return this;
        }

        public Builder<T, V> setInitialDecision(T initialDecision) {
            this.initialDecision = Objects.requireNonNull(initialDecision);
            return this;
        }

        public Builder<T, V> setGoal(V goal) {
            this.goal = Objects.requireNonNull(goal);
            return this;
        }

        public RecursiveBacktracking<T, V> build() {
            return new RecursiveBacktracking<>(this);
        }

    }
}
