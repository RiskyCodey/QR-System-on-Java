package idproject;

public class IdProject {

    public static void main(String args[]) {
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            home homeFrame = new home();
            homeFrame.setVisible(true);
            homeFrame.pack();
        });
    }
}