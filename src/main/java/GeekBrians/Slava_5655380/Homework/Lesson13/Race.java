package GeekBrians.Slava_5655380.Homework.Lesson13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Race {
    private ArrayList<Stage> stages;
    private CyclicBarrier startBarrier;
    private CountDownLatch finishBarrier;
    private String winner = null;
    public ArrayList<Stage> getStages() { return stages; }
    public Race(int COMPETITORS_NUMBER, Stage... stages) {
        this.startBarrier = new CyclicBarrier(COMPETITORS_NUMBER + 1);
        this.finishBarrier = new CountDownLatch(COMPETITORS_NUMBER);
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }
    public CyclicBarrier getStartBarrier() {
        return startBarrier;
    }

    public String getWinner() {
        return winner;
    }

    public void waitUntilStart(){
        try {
            startBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
    public void waitUntilFinish(){
        try {
            finishBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void crossFinish(Car car) {
        // Первый участник, пересекший финишную черту, объявляется победителем (в момент пересечения этой самой черты).
        // Победитель должен быть только один (ситуация с 0 или 2+ победителями недопустима).
        if(this.winner == null)
            this.winner = car.getName();
        finishBarrier.countDown();
    }
}