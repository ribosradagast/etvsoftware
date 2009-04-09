/*
 * ETVFitApp.java
 */
package etvfit;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import etvfit.appcode.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class ETVFitApp extends SingleFrameApplication {

    public DataHolder dataHolder;
    public static final int notRightUser = -1;
    public static final int cantFindFile = -2;
     public static final int noUsersAdded = -3;
    public static final String filename = "save.etvout";

    /**
     * At startup create and show the main frame of the application.
     */
    @Override
    protected void startup() {
        //Load in users from file
        FileInputStream fis;
        {
            ObjectInputStream in = null;
            try {
                fis = new FileInputStream(filename);
                in = new ObjectInputStream(fis);
                dataHolder = (DataHolder) in.readObject();
            } catch (Exception ex) {
                // Logger.getLogger(ETVFitApp.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(new java.awt.Frame(), "So we will start off with a blank program!",
                        "There was no save file found...", JOptionPane.INFORMATION_MESSAGE);
                dataHolder = new DataHolder();
            } finally {
                try {
                    in.close();
                } catch (Exception ex) {
                    // Do nothing, at least we tried to close the file...if it
                    // wasn't opened then we don't need to close it
                }
            }
        }



        //  if there are no users, prompt for new user
        if (dataHolder.users.size() == 0) {
            JOptionPane.showMessageDialog(new java.awt.Frame(),
                    "Since there are no users currently in the program, please add a new one!",
                    "Welcome to ETV Fit", JOptionPane.INFORMATION_MESSAGE);
            ETVFitManageUsers mng = new ETVFitManageUsers(new java.awt.Frame(), true, dataHolder.users);
            show(mng);
            if (mng.getReturnStatus() == (ETVFitManageUsers.RET_OK)) {
                this.dataHolder.users= mng.users;
            } else {
                //Exit
                mng.dispose();
                System.exit(noUsersAdded);
            }
        }
//        else {
            Login login = new Login(new java.awt.Frame(), true, this.dataHolder.users);
            show(login);
            if (login.getReturnStatus() == Login.RET_OK) {
                show(new ETVFitView(this, login.getUser()));

            } else {
                login.dispose();
                System.exit(notRightUser);
            }
//        }
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override
    protected void configureWindow(java.awt.Window root) {
    }

    public void SaveInfo(User currentUser) {
        ///Stick in this user
        //it's already in my users...
        dataHolder.users.remove(dataHolder.users.indexOf(currentUser));
        //now add it back in
         dataHolder.users.add(currentUser);

        FileOutputStream fos = null;
        {
            ObjectOutputStream out = null;
            try {
                fos = new FileOutputStream(filename);
                out = new ObjectOutputStream(fos);
                out.writeObject(dataHolder);
            } catch (IOException ex) {
                Logger.getLogger(ETVFitApp.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    fos.close();
                } catch (IOException ex) {
                    Logger.getLogger(ETVFitApp.class.getName()).log(Level.SEVERE, null, ex);

                    System.exit(cantFindFile);
                }
                try {
                    out.close();
                } catch (IOException ex) {
                    Logger.getLogger(ETVFitApp.class.getName()).log(Level.SEVERE, null, ex);

                    System.exit(cantFindFile);
                }
            }
        }
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of ETVFitApp
     */
    public static ETVFitApp getApplication() {
        return Application.getInstance(ETVFitApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(ETVFitApp.class, args);
    }
}
