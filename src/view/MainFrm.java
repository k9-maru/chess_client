package view;

import control.ClientCtr;
import model.ObjectWrapper;
import model.Player;

import javax.swing.*;
import java.util.ArrayList;

/**
 * @author Administrator
 */

public class MainFrm extends javax.swing.JFrame {
    private ClientCtr mySocket;
    private Player player;

    /**
     * Creates new form MainFrm
     */
    public MainFrm(Player p, ClientCtr socket) {
        player = p;
        mySocket = socket;
        initComponents(p);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                mySocket.sendData(new ObjectWrapper(ObjectWrapper.LOGOUT_USER, player));
            }
        });

        mySocket.getActiveFunction().add(new ObjectWrapper(ObjectWrapper.REPLY_LOGOUT_USER, this));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents(Player p) {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btncreate = new javax.swing.JButton();
        btnjoin = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtusername = new javax.swing.JTextField(p.getUsername());
        jLabel7 = new javax.swing.JLabel();
        txtwins = new javax.swing.JTextField("" + p.getWins());
        jLabel8 = new javax.swing.JLabel();
        txtloses = new javax.swing.JTextField("" + p.getLoses());
        btnfriend = new javax.swing.JButton();
        btnlogout = new javax.swing.JButton();
        btnonlineplayer = new javax.swing.JButton();
        btnranking = new javax.swing.JButton();
        btngroup = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Main Frame");

        btncreate.setText("Create a new Room");
        btncreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncreateActionPerformed(evt);
            }
        });

        btnjoin.setText("Join an exist Room");
        btnjoin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnjoinActionPerformed(evt);
            }
        });

        jLabel5.setText("Player Information:");

        jLabel6.setText("username:");

        txtusername.setEditable(false);
        txtusername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusernameActionPerformed(evt);
            }
        });

        jLabel7.setText("wins:");

        txtwins.setEditable(false);

        jLabel8.setText("loses:");

        txtloses.setEditable(false);

        btnfriend.setText("Friend");
        btnfriend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfriendActionPerformed(evt);
            }
        });

        btnlogout.setText("Log out");
        btnlogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlogoutActionPerformed(evt);
            }
        });

        btnonlineplayer.setText("Online Player");
        btnonlineplayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnonlineplayerActionPerformed(evt);
            }
        });

        btnranking.setText("Ranking");
        btnranking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrankingActionPerformed(evt);
            }
        });

        btngroup.setText("Group");
        btngroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngroupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnjoin, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btncreate)
                                        .addComponent(btngroup, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(86, 86, 86)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnonlineplayer, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnfriend, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnranking, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel7)
                                                        .addComponent(jLabel8)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(99, 99, 99)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel1)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(txtusername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(txtwins, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(txtloses, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(120, 120, 120)
                                                .addComponent(btnlogout, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel1)
                                .addGap(50, 50, 50)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(txtwins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(txtloses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btncreate)
                                        .addComponent(btnfriend))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnjoin)
                                        .addComponent(btnonlineplayer))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btngroup)
                                        .addComponent(btnranking))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                .addComponent(btnlogout)
                                .addGap(19, 19, 19))
        );

        pack();

    }// </editor-fold>

    private void btncreateActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        //new RoomFrm().setVisible(true);
    }

    private void btnjoinActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        //new RoomListFrm().setVisible(true);
    }

    private void btnfriendActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        for (ObjectWrapper func : mySocket.getActiveFunction())
            if (func.getData() instanceof FriendFrm) {
                ((OnlinePlayerFrm) func.getData()).setVisible(true);
                return;
            }
        FriendFrm ff = new FriendFrm(mySocket, player);
        ff.setVisible(true);
    }

    private void btnonlineplayerActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        for (ObjectWrapper func : mySocket.getActiveFunction())
            if (func.getData() instanceof OnlinePlayerFrm) {
                ((OnlinePlayerFrm) func.getData()).setVisible(true);
                return;
            }
        OnlinePlayerFrm opf = new OnlinePlayerFrm(mySocket, player);
        opf.setVisible(true);
    }

    private void btnrankingActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnlogoutActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        mySocket.sendData(new ObjectWrapper(ObjectWrapper.LOGOUT_USER, player));
    }

    private void btngroupActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void txtusernameActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btncreate;
    private javax.swing.JButton btngroup;
    private javax.swing.JButton btnjoin;
    private javax.swing.JButton btnlogout;
    private javax.swing.JButton btnonlineplayer;
    private javax.swing.JButton btnranking;
    private javax.swing.JButton btnfriend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtloses;
    private javax.swing.JTextField txtusername;
    private javax.swing.JTextField txtwins;
    // End of variables declaration

    public void receivedDataProcessing(ObjectWrapper data) {
        switch (data.getPerformative()) {
            case ObjectWrapper.REPLY_LOGOUT_USER:
                if (data.getData().equals("ok")) {
                    mySocket.sendData(new ObjectWrapper(ObjectWrapper.ONLINE_PLAYER, player)); // update online player
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "An error occurred while trying to log out");
                }
                break;
        }
    }
}

