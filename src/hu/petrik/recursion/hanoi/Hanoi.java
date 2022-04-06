package hu.petrik.recursion.hanoi;

import java.util.LinkedList;
public class Hanoi {
    HanoiState state;
    LinkedList<Step> queue;

    public Hanoi(Integer numberOfDisks) {
        this.state = new HanoiState(numberOfDisks);
        this.queue = new LinkedList<>();
    }

    public void solve(){
        createQueue(state);
        followInstructions();
    }

    private void createQueue(HanoiState state) {
        if (state.getNumberOfDisks() == 1) {
            queue.add(new Step(state.getFrom().getInitialName(),state.getTo().getInitialName()));
            return;
        }
        createQueue(
                new HanoiState(state.getNumberOfDisks() - 1, state.getFrom(), state.getTo(), state.getHelper()));
        queue.add(new Step(state.getFrom().getInitialName(),state.getTo().getInitialName()));
        createQueue(
                new HanoiState(state.getNumberOfDisks() - 1, state.getHelper(), state.getFrom(), state.getTo()));
    }

    private void followInstructions(){
        while (!queue.isEmpty()){
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.state.takeStep(queue.pollFirst());
            this.state.print();
        }
    }


}

