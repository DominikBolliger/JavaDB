import javax.xml.crypto.Data;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        DatabaseConf db = new DatabaseConf("localhost", "root", "");
        for (int i = 1; i < 11; i++) {
            try {
                System.out.println("run: " + i);
                TimeUnit.SECONDS.sleep(1);
                db.connect();
                db.write(i,i,i);
                db.closeConnection();
                if (i == 10){
                    i=0;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
