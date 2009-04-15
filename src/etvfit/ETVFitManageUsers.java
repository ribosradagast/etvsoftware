/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ETVFitManageUsers.java
 *
 * Created on Apr 1, 2009, 11:37:08 AM
 */
package etvfit;

import etvfit.appcode.*;
import java.util.Vector;
import org.jdesktop.application.Action;

/**
 *
 * @author Justin
 */
public class ETVFitManageUsers extends javax.swing.JDialog {

    /** A return status code - returned if Cancel button has been pressed */
    public static final int RET_CANCEL = 0;
    /** A return status code - returned if OK button has been pressed */
    public static final int RET_OK = 1;
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                Vector v = new Vector<User>();
                v.add(new User("username", "password","Name1",1,
                        "address", "city", "state", 2, "phone",
                        "insurance",3, "medicalHistory",
                        "allergies")) ;

                  v.add(new User("username", "password","Name2",1,
                        "address", "city", "state", 2, "phone",
                        "insurance",3, "medicalHistory",
                        "allergies")) ;
                ETVFitManageUsers dialog = new ETVFitManageUsers(new javax.swing.JFrame(), true, v);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
					public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public Vector<User> users;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addMeButton;

    private javax.swing.JButton jButton1;

    private javax.swing.JLabel jLabel1;

    private javax.swing.JLabel jLabel2;

    private javax.swing.JLabel jLabel3;

    private javax.swing.JScrollPane jScrollPane1;

    private javax.swing.JLabel newUserLabel;

    private javax.swing.JButton okButton;

    private javax.swing.JTextField passTextField;

    private javax.swing.JButton removeUserButton;

    private javax.swing.JTextField userTextField;


    private javax.swing.JList usersList;
    // End of variables declaration//GEN-END:variables
    private int returnStatus = RET_CANCEL;
    /** Creates new form ETVFitManageUsers */
    public ETVFitManageUsers(java.awt.Frame parent, boolean modal, Vector<User> users) {
        super(parent, modal);
        this.users = users;
        initComponents();
        newUserLabel.setVisible(false);
        addMeButton.setVisible(false);

        usersList.setListData(this.users);

    }
    @Action
    public void addUser() {
        if (usersList.isSelectionEmpty()) {
            //then we must be adding a new one
            User newUser = new Parent(userTextField.getText(), passTextField.getText());
            users.add(newUser);

            //Update the List
            usersList.setListData(this.users);
        } else {
            //get the index of the one that's being changed and update it in the "users" array
            int index = usersList.getSelectedIndex();
            users.get(index).setUsername(userTextField.getText());
            users.get(index).setPassword(passTextField.getText());
        }

        //disable the textboxes and clear them.
        userTextField.setEnabled(false);
        passTextField.setEnabled(false);
        userTextField.setText("");
        passTextField.setText("");
        addMeButton.setVisible(false);
        newUserLabel.setVisible(false);
    }
    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose(RET_CANCEL);
    }//GEN-LAST:event_closeDialog
    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }
    /** @return the return status of this dialog - one of RET_OK or RET_CANCEL */
    public int getReturnStatus() {
        return returnStatus;
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        okButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        usersList = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        userTextField = new javax.swing.JTextField();
        passTextField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        removeUserButton = new javax.swing.JButton();
        newUserLabel = new javax.swing.JLabel();
        addMeButton = new javax.swing.JButton();

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(etvfit.ETVFitApp.class).getContext().getResourceMap(ETVFitManageUsers.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setModal(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
			public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        okButton.setIcon(resourceMap.getIcon("okButton.icon")); // NOI18N
        okButton.setText(resourceMap.getString("okButton.text")); // NOI18N
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        usersList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public Object getElementAt(int i) { return strings[i]; }
            public int getSize() { return strings.length; }
        });
        usersList.setListData(users);
        usersList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        usersList.setName("usersList"); // NOI18N
        usersList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(usersList);

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        userTextField.setText(resourceMap.getString("userTextField.text")); // NOI18N
        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(etvfit.ETVFitApp.class).getContext().getActionMap(ETVFitManageUsers.class, this);
        userTextField.setAction(actionMap.get("boxEdited")); // NOI18N
        userTextField.setName("userTextField"); // NOI18N
        userTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
			public void keyTyped(java.awt.event.KeyEvent evt) {
                ETVFitManageUsers.this.keyTyped(evt);
            }
        });

        passTextField.setText(resourceMap.getString("passTextField.text")); // NOI18N
        passTextField.setAction(actionMap.get("boxEdited")); // NOI18N
        passTextField.setName("passTextField"); // NOI18N
        passTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
			public void keyTyped(java.awt.event.KeyEvent evt) {
                ETVFitManageUsers.this.keyTyped(evt);
            }
        });

        jButton1.setAction(actionMap.get("newUser")); // NOI18N
        jButton1.setIcon(resourceMap.getIcon("jButton1.icon")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N

        removeUserButton.setAction(actionMap.get("removeUser")); // NOI18N
        removeUserButton.setIcon(resourceMap.getIcon("removeUserButton.icon")); // NOI18N
        removeUserButton.setText(resourceMap.getString("removeUserButton.text")); // NOI18N
        removeUserButton.setName("removeUserButton"); // NOI18N
        if(users.size()==0 ){
            removeUserButton.setEnabled(false);
        }

        newUserLabel.setText(resourceMap.getString("newUserLabel.text")); // NOI18N
        newUserLabel.setName("newUserLabel"); // NOI18N

        addMeButton.setAction(actionMap.get("addUser")); // NOI18N
        addMeButton.setIcon(resourceMap.getIcon("addMeButton.icon")); // NOI18N
        addMeButton.setText(resourceMap.getString("addMeButton.text")); // NOI18N
        addMeButton.setName("addMeButton"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(54, 54, 54)
                .addComponent(newUserLabel))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(passTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                    .addComponent(userTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(addMeButton)
                                .addGap(28, 28, 28))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeUserButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(okButton)))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newUserLabel)
                    .addComponent(jLabel1))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(userTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(passTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addComponent(addMeButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(removeUserButton)
                    .addComponent(okButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void keyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keyTyped
    
        addMeButton.setVisible(true);

    }//GEN-LAST:event_keyTyped
    private void listValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listValueChanged

        newUserLabel.setText("Please edit user information:");
        newUserLabel.setVisible(true);
        if (!usersList.isSelectionEmpty()) {
            userTextField.setEnabled(true);
            passTextField.setEnabled(true);

            userTextField.setText(users.get(usersList.getSelectedIndex()).getUsername());
            passTextField.setText(users.get(usersList.getSelectedIndex()).getPassword());
            addMeButton.setVisible(false);

            //show the remove button
            removeUserButton.setEnabled(true);
        }
    }//GEN-LAST:event_listValueChanged
    @Action
    public void newUser() {
        newUserLabel.setVisible(true);
        userTextField.setEnabled(true);
        passTextField.setEnabled(true);

        addMeButton.setVisible(true);

        userTextField.setText("");
        passTextField.setText("");
        usersList.clearSelection();

        //disable the remove button
        removeUserButton.setEnabled(false);
    }
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        doClose(RET_OK);
    }//GEN-LAST:event_okButtonActionPerformed
    @Action
    public void removeUser() {
        //pretty easy
        int index = usersList.getSelectedIndex();

        users.remove(index);

        removeUserButton.setEnabled(false);
        //update view

        //disable the textboxes and clear them.
        userTextField.setEnabled(false);
        passTextField.setEnabled(false);
        userTextField.setText("");
        passTextField.setText("");
        addMeButton.setVisible(false);
        newUserLabel.setVisible(false);

        usersList.setListData(this.users);

    }
}
