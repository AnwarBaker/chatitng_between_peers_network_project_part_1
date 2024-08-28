package p2pchat;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.*;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.text.*;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class Client extends javax.swing.JFrame {

    DatagramSocket socket;
    String userName;
    String localIp;
    int localPort;
    String remotIp;
    int remotPort;
    InetAddress remot_IPAddress;
    byte[] S_buffer;
    DatagramPacket sendpacket;
    byte[] R_buffer;
    DatagramPacket receive_packet;
    boolean conn = false;
    DefaultListModel dlm;

    public Client() {
        initComponents();
        
        DefaultListModel<String> dlm = new DefaultListModel<>();

        dlm = new DefaultListModel();
        //archiveee.setModel(dlm);
       // archiveee.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        textPaneArea.setEditable(false);
        inArea.setForeground(Color.GRAY);
        inArea.setText("enter text here");
        userName = "";
        localIp = "";
        localPort = 0;
        remotIp = "";
        remotPort = 0;
        R_buffer = new byte[50];
        receive_packet = new DatagramPacket(R_buffer, R_buffer.length);

    }


    @SuppressWarnings("unChecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        inArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Local_IP = new javax.swing.JTextField();
        Local_Port = new javax.swing.JTextField();
        Remot_IP = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Remot_Port = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        send = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        status = new javax.swing.JTextField();
        test = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        textPaneArea = new javax.swing.JTextPane();
        deleteoneline = new javax.swing.JButton();
        lineNumberTextField = new javax.swing.JTextField();
        deletealllines = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        archive = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        archivemsge = new javax.swing.JList<>();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 204));

        jPanel1.setForeground(new java.awt.Color(255, 255, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Username :");

        username.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        username.setToolTipText("");
        username.setPreferredSize(new java.awt.Dimension(7, 28));

        jButton1.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 0, 51));
        jButton1.setText("Login");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, new java.awt.Color(204, 204, 204)));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 153, 153));
        jButton2.setText("Logout");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, new java.awt.Color(204, 204, 204)));

        inArea.setColumns(20);
        inArea.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        inArea.setLineWrap(true);
        inArea.setRows(5);
        inArea.setWrapStyleWord(true);
        inArea.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inAreaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inAreaFocusLost(evt);
            }
        });
        jScrollPane2.setViewportView(inArea);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("TCP Server Port :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Avilable Interfaces");

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField2.setToolTipText("");
        jTextField2.setPreferredSize(new java.awt.Dimension(7, 28));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField3.setToolTipText("");
        jTextField3.setPreferredSize(new java.awt.Dimension(7, 28));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 153));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("TCP Server IP :");

        jComboBox1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(0, 153, 153));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Loopback Pseudo-Interface 1: 192.168.1.12", "Wi-Fi :192.168.1.112", "Ethernet: 169.254.49.56", " " }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Local Port :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Local IP :");

        Local_IP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Local_IP.setToolTipText("");
        Local_IP.setPreferredSize(new java.awt.Dimension(7, 28));
        Local_IP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Local_IPActionPerformed(evt);
            }
        });

        Local_Port.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Local_Port.setToolTipText("");
        Local_Port.setPreferredSize(new java.awt.Dimension(7, 28));
        Local_Port.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Local_PortActionPerformed(evt);
            }
        });

        Remot_IP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Remot_IP.setToolTipText("");
        Remot_IP.setPreferredSize(new java.awt.Dimension(7, 28));
        Remot_IP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Remot_IPActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 153));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Remote IP :");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 153));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Remote Port :");

        Remot_Port.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Remot_Port.setToolTipText("");
        Remot_Port.setPreferredSize(new java.awt.Dimension(7, 28));
        Remot_Port.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Remot_PortActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 153));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Archive msg");

        send.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        send.setForeground(new java.awt.Color(0, 153, 153));
        send.setText("Send");
        send.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, new java.awt.Color(204, 204, 204)));
        send.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 153));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Status :");

        status.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        status.setToolTipText("");
        status.setPreferredSize(new java.awt.Dimension(7, 28));
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });

        test.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        test.setForeground(new java.awt.Color(0, 153, 153));
        test.setText("Test Button");
        test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testActionPerformed(evt);
            }
        });

        textPaneArea.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        textPaneArea.setFocusCycleRoot(false);
        jScrollPane4.setViewportView(textPaneArea);

        deleteoneline.setText("delete one");
        deleteoneline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteonelineActionPerformed(evt);
            }
        });

        lineNumberTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lineNumberTextFieldActionPerformed(evt);
            }
        });

        deletealllines.setText("delete all");
        deletealllines.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletealllinesActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("select line ");

        archive.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        archive.setForeground(new java.awt.Color(0, 204, 204));
        archive.setText("Archive");
        archive.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        archive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                archiveActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(archivemsge);

        jButton3.setText("resend");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lineNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(176, 176, 176))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(archive, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                                            .addComponent(jScrollPane4))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(43, 43, 43)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                                            .addComponent(Local_IP, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(Local_Port, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(Remot_IP, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(Remot_Port, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(459, 459, 459)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jButton3)
                                            .addComponent(send, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(deleteoneline)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(test)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(deletealllines)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Local_IP, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Local_Port, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Remot_IP, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Remot_Port, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(send)
                                    .addComponent(test)
                                    .addComponent(deleteoneline)
                                    .addComponent(deletealllines)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(lineNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(archive, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void Local_IPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Local_IPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Local_IPActionPerformed

    private void Local_PortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Local_PortActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Local_PortActionPerformed

    private void Remot_IPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Remot_IPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Remot_IPActionPerformed

    private void Remot_PortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Remot_PortActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Remot_PortActionPerformed

    private void sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendActionPerformed
        // TODO add your handling code here:
        try {
            if (!conn) {
                JOptionPane.showMessageDialog(null, "To send successfully , use test button to open a connection  ");
            } else if (inArea.getText().equals("") || inArea.getText().equals("enter text here")) {
                JOptionPane.showMessageDialog(null, "Please write messege ,You can't send empty message");
            } else if (Remot_IP.getText().equals("") || Remot_Port.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "You should enter the remot Ip and the remot port");
            } else if (username.getText().equals("")){
                JOptionPane.showMessageDialog(null, "You should enter your name");
            } else {
                
                Style style = textPaneArea.addStyle("", null);
                StyleConstants.setForeground(style, Color.BLUE);
                StyleConstants.setBackground(style, Color.white);
                //___________________________________________________________________________________________________
                userName = username.getText();
                remotIp = Remot_IP.getText();
                remotPort = Integer.parseInt(Remot_Port.getText());
                remot_IPAddress = InetAddress.getByName(remotIp);
                String msg = inArea.getText();
                inArea.setText("");
                //___________________________________________________________________________________________________
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");             
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                String s1 = "ME: " + msg + " From " + localPort + " At time: " + sdf.format(timestamp) + "\n";
                
                //___________________________________________________________________________________________________
                StyledDocument doc = textPaneArea.getStyledDocument();
                
                
                
                 deletemsg.add(msg);
                 
                 
                 
                messages.add(s1);
                
                doc.insertString(doc.getLength(), s1, style);    
                
                msg = userName + ": " + msg;
                S_buffer = msg.getBytes();
                
                sendpacket = new DatagramPacket(S_buffer, S_buffer.length, remot_IPAddress, remotPort);
                socket.send(sendpacket);

            }
        } catch (UnknownHostException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException | BadLocationException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_sendActionPerformed

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusActionPerformed

    private void testActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testActionPerformed
        try {
            // TODO add your handling code here:
            if (Local_IP.getText().equals("") || Local_Port.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "You should enter the local Ip and the local port");
            } else {
                conn = true;
                Local_IP.getText();
                localPort = Integer.parseInt(Local_Port.getText());
                socket = new DatagramSocket(localPort);
                if (socket.isConnected()) {
                    JOptionPane.showMessageDialog(null, "The port conn");
                }
                receive channel = new receive(this);
                channel.start();
                JOptionPane.showMessageDialog(null, "The test is good, and the port is available");

            }
        } catch (SocketException ex) {
            JOptionPane.showMessageDialog(null, "The port is used");
        }
    }//GEN-LAST:event_testActionPerformed



    //private void deleteOneActionPerformed(java.awt.event.ActionEvent evt) {
      
    //}
    

    
    
    
  //  private void deleteAllActionPerformed(java.awt.event.ActionEvent evt) {
       
    //}
    
    private void deleteAllMessages() {
        StyledDocument doc = textPaneArea.getStyledDocument();
        try {
            doc.remove(0, doc.getLength());
        } catch (BadLocationException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        messages.clear(); // remove all messages from the messages ArrayList on the other side
    }
    
    
    public void sendMessage(String message) {
        try {
            byte[] buffer = message.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, remot_IPAddress, remotPort);
            socket.send(packet);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void addMessage(String message, String senderAddress, int senderPort) {
        try {
            Style style = textPaneArea.addStyle("", null);
            StyleConstants.setForeground(style, Color.RED);
            StyleConstants.setBackground(style, Color.white);

            //InetAddress S_IPAddress = receive_packet.getAddress();
         
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");                
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String s1 = message + " From " + senderPort + " At time: " + sdf.format(timestamp) + "\n";
    
    
            deletemsg.add(message);
            
            StyledDocument doc = textPaneArea.getStyledDocument();
            messages.add(s1);
            
            
          //  deletemsg.add(s1);
                    
                    
            doc.insertString(doc.getLength(), s1, style);    
            
            //String s = S_IPAddress.getHostAddress();
            String s = senderAddress;
            status.setText("Received From IP= " + s + ", port: " + senderPort);
            
        } catch (BadLocationException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex){
            System.out.println(ex);
        }
    }
    

    private void inAreaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inAreaFocusGained
        // TODO add your handling code here:
        if (inArea.getText().equals("enter text here")) {
            inArea.setText("");
            inArea.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_inAreaFocusGained

    private void inAreaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inAreaFocusLost
        // TODO add your handling code here:
        if (inArea.getText().isEmpty()) {
            inArea.setForeground(Color.GRAY);
            inArea.setText("enter text here");
        }
    }//GEN-LAST:event_inAreaFocusLost

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void deleteonelineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteonelineActionPerformed
        // TODO add your handling code here:
        
         try {
            int lineNumber = Integer.parseInt(lineNumberTextField.getText()) - 1; // subtract 1 to convert to 0-based index
            StyledDocument doc = textPaneArea.getStyledDocument();
            Element lineElement = doc.getDefaultRootElement().getElement(lineNumber);
            int startOffset = lineElement.getStartOffset();
            int endOffset = lineElement.getEndOffset();
            String deletedMessage = doc.getText(startOffset, endOffset - startOffset);
    
            // remove the message from this user's chat window
            doc.remove(startOffset, endOffset - startOffset);
            
            finalsave.add(deletemsg.get(lineNumber));
           
            
            
            
            
            
            messages.remove(lineNumber);
    
            // send a message to the other user to delete the message from their chat window
            String deleteMessage = "delete:" + lineNumber;
            sendMessage(deleteMessage);
    
            // log the deleted message
            System.out.println("Deleted message: " + deletedMessage);
    
        } catch (IndexOutOfBoundsException e){
            System.out.println("Index Out Of Bound");
        } catch (NullPointerException ex){
            System.out.println("NullPointerException");
        } catch (BadLocationException ex) {
            System.out.println("Bad Location Exception");
        } catch (NumberFormatException ex) {
            System.out.println("Number Format Exception");
        }
    }//GEN-LAST:event_deleteonelineActionPerformed

    
    
   /* private void archiveMessage (String message) {

finalsave.add(message);

Timer timer = new Timer(delay: 120000, e -> {
finalsave.remove(message);
((Timer)e.getSource()).stop();
notifyServerArchiveMessageExpired(message);

});

timer.setRepeats(false); // Ensure the timer only runs once
timer.start();
// Store the timer in case we need to cancel it if the message is restored.
archiveTimers.put(key:message, value:timer);

}*/

    
    
    
    
    private void lineNumberTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lineNumberTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lineNumberTextFieldActionPerformed

    private void deletealllinesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletealllinesActionPerformed
        // TODO add your handling code here:
         try {
            StyledDocument doc = textPaneArea.getStyledDocument();
            doc.remove(0, doc.getLength());
       //#########################     
     int i=0;
     while(i< deletemsg.size()){
     finalsave.add(deletemsg.get(i));
     i++;
     
     }
        //########################    
          
            
            
            messages.clear(); // remove all messages from the messages ArrayList on this side
    
            // send a message to the other user to delete all messages from their chat window and clear their messages ArrayList
            sendMessage("delete-all");
    
        } catch (BadLocationException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deletealllinesActionPerformed

    
 
    
    
    private void archiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_archiveActionPerformed
        // TODO add your handling code here:

   
 DefaultListModel dlm=new DefaultListModel();
        archivemsge.setModel(dlm);
        
        archivemsge.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
   
   
    for (String item : finalsave) {
       dlm.addElement(item+"\n"); 
}

    
    //######################################
    
    
    
    
    
    
   
   
   
    }//GEN-LAST:event_archiveActionPerformed

 
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
       
         archivemsge.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        archivemsge.addListSelectionListener(new ListSelectionListener() {
   
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) { // This ensures the event is not handled twice
            String selectedValue = archivemsge.getSelectedValue();
            g=selectedValue;
            
            
           
        }
    }
});
       
       try {
            if (g.equals("")){
                JOptionPane.showMessageDialog(null, "You should select a value");
            } else {
                
                Style style = textPaneArea.addStyle("", null);
                StyleConstants.setForeground(style, Color.BLUE);
                StyleConstants.setBackground(style, Color.white);
                //___________________________________________________________________________________________________
                userName = username.getText();
                remotIp = Remot_IP.getText();
                remotPort = Integer.parseInt(Remot_Port.getText());
                remot_IPAddress = InetAddress.getByName(remotIp);
                String msg = g;
                inArea.setText("");
                //___________________________________________________________________________________________________
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");             
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                String s1 = "ME: " + msg + " From " + localPort + " At time: " + sdf.format(timestamp) + "\n";
                
                //___________________________________________________________________________________________________
                StyledDocument doc = textPaneArea.getStyledDocument();
                
         
                messages.add(s1);
                
                doc.insertString(doc.getLength(), s1, style);    
                
                msg = userName + ": " + msg;
                S_buffer = msg.getBytes();
                
                sendpacket = new DatagramPacket(S_buffer, S_buffer.length, remot_IPAddress, remotPort);
                socket.send(sendpacket);

            }
        } catch (UnknownHostException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException | BadLocationException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }
       
        
    }//GEN-LAST:event_jButton3ActionPerformed
   
    private void deleteMessage(int lineNumber) {
        StyledDocument doc = textPaneArea.getStyledDocument();
        Element lineElement = doc.getDefaultRootElement().getElement(lineNumber);
        int startOffset = lineElement.getStartOffset();
        int endOffset = lineElement.getEndOffset();
        String deletedMessage = null;
    
        try {
            deletedMessage = doc.getText(startOffset, endOffset - startOffset);
            doc.remove(startOffset, endOffset - startOffset);
            System.out.println("Deleted message: " + deletedMessage);
            messages.remove(lineNumber);
        } catch (BadLocationException e) {
            System.out.println("Bad Location Exception");
        }
    }
    
    
    public void receive() {
        while (true) {
            try {
                byte[] buffer = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                String receivedMessage = new String(packet.getData(), 0, packet.getLength());
    
                if (receivedMessage.startsWith("delete:")) {
                    int lineNumber = Integer.parseInt(receivedMessage.substring(7));
                    SwingUtilities.invokeLater(() -> deleteMessage(lineNumber));
                } else if (receivedMessage.equals("delete-all")) {
                    SwingUtilities.invokeLater(() -> deleteAllMessages());
                } else {
                    String senderAddress = packet.getAddress().getHostAddress();
                    int senderPort = packet.getPort();
                    SwingUtilities.invokeLater(() -> addMessage(receivedMessage, senderAddress, senderPort));
                }
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new Client().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Local_IP;
    private javax.swing.JTextField Local_Port;
    private javax.swing.JTextField Remot_IP;
    private javax.swing.JTextField Remot_Port;
    private javax.swing.JButton archive;
    private javax.swing.JList<String> archivemsge;
    private javax.swing.JButton deletealllines;
    private javax.swing.JButton deleteoneline;
    private javax.swing.JTextArea inArea;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField lineNumberTextField;
    private javax.swing.JButton send;
    private javax.swing.JTextField status;
    private javax.swing.JButton test;
    private javax.swing.JTextPane textPaneArea;
    protected javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables

    private ArrayList <String> messages = new ArrayList<>();
    private ArrayList <String> deletemsg = new ArrayList<>();
                                   
    private ArrayList <String> finalsave = new ArrayList<>();
    
        

    
    
public String g="";

}
