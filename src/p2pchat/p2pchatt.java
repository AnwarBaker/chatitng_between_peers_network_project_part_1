package p2pchat;



import javax.swing.JFrame;


public class p2pchatt {

 
    public static void main(String[] args) {
        // TODO code application logic here
        Client client1 = new Client();
        client1.setVisible(true);
        client1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Client client2 = new Client();
        client2.setVisible(true);
        client2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
    }
}
