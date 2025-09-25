package digitalzoo.com;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Menjalankan GUI di Event Dispatch Thread (EDT) untuk keamanan thread Swing
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Membuat objek ZooFrame dan menampilkannya
                ZooFrame zooApp = new ZooFrame();
                zooApp.setVisible(true);
            }
        });
    }
}
