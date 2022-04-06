package hu.petrik.recursion;

import java.util.LinkedList;

import static hu.petrik.recursion.Recusives.reapeatString;

public class Hanoi {

    static void runHanoi(int n) {
        Runnable onUpdate = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        LinkedList<Integer> temp = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            temp.add(n + 1);
        }
        System.out.println(n);
        hanoi(new HanoiState(n, temp, new LinkedList<>(), new LinkedList<>()), onUpdate).print();
    }

    static void printHanoiState(int n, LinkedList<Integer> from, LinkedList<Integer> to, LinkedList<Integer> helper) {
        System.out.println();
        int spacer = String.valueOf(n).length();
        String formatter = "%" + spacer + "d ";
        for (int i = n - 1; i > -1; i--) {
            if (from.size() > i) {
                System.out.printf(formatter, from.get(i));
            } else {
                System.out.print(reapeatString(" ", spacer + 1));
            }
            if (helper.size() > i) {
                System.out.printf(formatter, helper.get(i));
            } else {
                System.out.print(reapeatString(" ", spacer + 1));
            }
            if (to.size() > i) {
                System.out.printf(formatter, to.get(i));
            } else {
                System.out.print(reapeatString(" ", spacer + 1));
            }
            System.out.println();
        }
        System.out.println();
    }

    static void printHanoiState(HanoiState state) {
        printHanoiState(state.n, state.from, state.to, state.helper);
    }

    static HanoiState hanoi(HanoiState state, Runnable notification) {
        System.out.println(state.n);
        if(state.n == 0){
            return state;
        }
        if (state.n == 1) {
            //state = move(state.n,state.from, state.to, state.helper);
            state.to.add(state.from.pollFirst());
            state.print();
            return state;
        }
        state = hanoi(new HanoiState(state.n - 1, state.from, state.helper, state.to), notification);
        state.to.add(state.from.pollFirst());
        //state = move(state.n,state.from, state.to, state.helper);
        state = hanoi(new HanoiState(state.n - 1, state.helper, state.to, state.from), notification);
        //notification.run();
        state.print();
        return state;
    }

    static HanoiState move(int n, LinkedList<Integer> from, LinkedList<Integer> to, LinkedList<Integer> helper) {
        HanoiState state = new HanoiState(n, from, to, helper);
        state.to.add(from.pollFirst());
        return state;
    }

    private static class HanoiState {
        public LinkedList<Integer> from, to, helper;
        public int n;

        protected HanoiState() {
        }

        protected HanoiState(int n, LinkedList<Integer> from, LinkedList<Integer> to, LinkedList<Integer> helper) {
            this.n = n;
            this.from = from;
            this.to = to;
            this.helper = helper;
        }

        protected void print() {
            printHanoiState(this);
        }
    }
}
