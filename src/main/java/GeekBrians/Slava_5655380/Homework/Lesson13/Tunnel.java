package GeekBrians.Slava_5655380.Homework.Lesson13;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    Semaphore tunnelResource;
    public Tunnel(int throughputLimit) {
        this.tunnelResource = new Semaphore(throughputLimit);
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }
    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                // В тоннель не может одновременно заехать больше половины участников (условность).
                tunnelResource.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                tunnelResource.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
