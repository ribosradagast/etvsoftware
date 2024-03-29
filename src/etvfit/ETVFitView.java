/*
 * ETVFitView.java
 */
package etvfit;

import etvfit.appcode.*;
import java.awt.Component;
import javax.swing.event.ListSelectionEvent;
import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 * The application's main frame.
 */
public class ETVFitView extends FrameView {

    User user = null;
    User prevUser = null;
    Calendar startDate;
    Calendar endDate;
    Calendar today;
    ETVFitApp app;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane actionsTabbedPane;

    private javax.swing.JButton addAppointmentButton;

    private javax.swing.JButton addNewMedicationButton;

    private javax.swing.JButton addNewSpecialistButton;

    private javax.swing.JPanel allergiesPanel;

    /**
     * 
     */
    private javax.swing.JScrollPane allergiesScrollPane;

    private javax.swing.JTextArea allergiesTextArea;

    private javax.swing.JLabel childEditingLabel;

    private javax.swing.JList childrenList;

    private javax.swing.JList currentMedicationsList;

    private javax.swing.JPanel currentMedicationsPanel;

    private javax.swing.JScrollPane currentMedicationsScrollPane;

    private javax.swing.JSeparator doctorSeparator;

    private javax.swing.JPanel doctorTabPanel;

    private javax.swing.JButton editAppointmentButton;

    private javax.swing.JButton editMedicationButton;

    private javax.swing.JButton editMyInfoButton;

    private javax.swing.JButton editPrimaryButton;

    private javax.swing.JButton editSpecialistButton;

    private javax.swing.JRadioButton femaleRadioButton;

    private javax.swing.ButtonGroup genderButtonGroup;

    private javax.swing.JButton jButton1;

    private javax.swing.JButton jButton2;

    private javax.swing.JButton jButton3;

    private javax.swing.JButton jButton4;

    private javax.swing.JButton jButton5;

    private javax.swing.JButton jButton6;

    private javax.swing.JLabel jLabel1;

    private javax.swing.JLabel jLabel10;

    private javax.swing.JLabel jLabel12;

    private javax.swing.JLabel jLabel13;

    private javax.swing.JLabel jLabel17;

    private javax.swing.JLabel jLabel18;

    private javax.swing.JLabel jLabel19;

    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelName1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JRadioButton maleRadioButton;
    private javax.swing.JPanel medicalHistoryPanel;
    private javax.swing.JTextArea medicalHistoryTextArea;
    private javax.swing.JSeparator medicationsSeparator;
    private javax.swing.JPanel medicationsTabPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JSplitPane moreInfoPanel;
    private javax.swing.JTextField myAddress1TextField;
    private javax.swing.JTextField myAgeTextField;
    private javax.swing.JTextField myCityTextField;
    private javax.swing.JSeparator myInfoSeparator;
    private javax.swing.JPanel myInfoTabPanel;
    private javax.swing.JTextField myInsuranceNumberTextField;
    private javax.swing.JTextField myInsuranceTextField;
    private javax.swing.JTextField myNameTextField;
    private javax.swing.JTextField myPhoneTextField;
    private javax.swing.JTextField myStateTextField;
    private javax.swing.JTextField myZipTextField;
    private javax.swing.JTextField newChildPasswordTextField;
    private javax.swing.JTextField newChildUsernameTextField;
    private javax.swing.JButton nextWeekButton;
    private javax.swing.JList pastMedicationsList;
    private javax.swing.JPanel pastMedicationsPanel;
    private javax.swing.JScrollPane pastMedicationsScrollPane;
    private javax.swing.JPanel personalInfoPanel;
    private javax.swing.JButton previousWeekButton;
    private javax.swing.JTextField primaryAddressTextField;
    private javax.swing.JPanel primaryButtonsPanel;
    private javax.swing.JTextField primaryCityTextField;
    private javax.swing.JLabel primaryNameLabel;
    private javax.swing.JTextField primaryNameTextField;
    private javax.swing.JPanel primaryPanel;
    private javax.swing.JTextField primaryPhoneTextField;
    private javax.swing.JTextField primaryStateTextField;
    private javax.swing.JTextField primaryZipTextField;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JList remindersList;
    private javax.swing.JPanel remindersPanel;
    private javax.swing.JScrollPane remindersScrollPane;
    private javax.swing.JMenuItem saveAllMenuItem;
    private javax.swing.JButton saveMyChangesButton;
    private javax.swing.JButton savePrimaryButton;
    private javax.swing.JButton saveSpecialistButton;
    private javax.swing.JScrollPane scheduleScrollPane;
    private javax.swing.JPanel scheduleTabPanel;
    private javax.swing.JTable scheduleTable;
    private javax.swing.JTextField specialistAddressTextField;
    private javax.swing.JPanel specialistButtonsPanel;
    private javax.swing.JTextField specialistCityTextField;
    private javax.swing.JTextField specialistNameTextField;
    private javax.swing.JPanel specialistPanel;
    private javax.swing.JTextField specialistPhoneTextField;
    private javax.swing.JSpinner specialistSpinner;
    private javax.swing.JTextField specialistStateTextField;
    private javax.swing.JTextField specialistZipTextField;
    private javax.swing.JTextField specialtyTextField;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JButton stopMedicationButton;
    private javax.swing.JLabel todayLabel;
    private javax.swing.JLabel welcomeLabel;
    private javax.swing.JLabel welcomeNameLabel;
    // End of variables declaration//GEN-END:variables
    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;
    private JDialog aboutBox;
    public ETVFitView(ETVFitApp app, User userOn) {
        super(app);
        this.user = userOn;
        this.app = app;
        initComponents();

        //OK, Let's dis-allow Children (who are not Parents)
        try {
            //Some bogus statement to test for Parent or not
            Parent p = ((Parent) user);
        } catch (ClassCastException c) {
            //If it's just a Child (User) then disable the Save option in the menu
            saveAllMenuItem.setEnabled(false);
            JOptionPane.showMessageDialog(new java.awt.Frame(),
                    "Welcome to Child Mode.  \nThe results of this session cannot be saved because you are a Child." +
                    "\nIn order to save your session results, please have your Parent log on \n" +
                    "and reenter your information through their \"Child-Editing Mode.\"",
                    "Child Mode", JOptionPane.ERROR_MESSAGE);
        }

        welcomeNameLabel.setText(user.getUsername());

        this.getFrame().setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.getFrame().addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                quitAction();
            }
        });

        scheduleTable.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {

                    public void valueChanged(ListSelectionEvent event) {

                        int row = scheduleTable.getSelectedRow();
                        int column = scheduleTable.getSelectedColumn();
                        //Check to see if anything's actually selected
                        if (row >= 0 && column >= 0) {
                            Object data = scheduleTable.getModel().getValueAt(row, column);

                            if (data == null || data.toString().equals("No items")) {
                                //do nothing
                                editAppointmentButton.setEnabled(false);
                            } else {
                                editAppointmentButton.setEnabled(true);
                            }
                        }
                    }
                });

        //   this.childEditingLabel.setVisible(false);




//Disable the buttons that are enabled by actions.
        editAppointmentButton.setEnabled(false);
        saveMyChangesButton.setEnabled(false);
        editMedicationButton.setEnabled(false);
        stopMedicationButton.setEnabled(false);
        savePrimaryButton.setEnabled(false);
        saveSpecialistButton.setEnabled(false);
        jButton3.setEnabled(false);
        jButton6.setEnabled(false);

//Put on the dates: current and week-of
        DateFormat dfm = new SimpleDateFormat("MMMM dd, yyyy");

        today = Calendar.getInstance();
        startDate = Calendar.getInstance();

        while (startDate.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
            startDate.add(Calendar.DAY_OF_WEEK, -1);
        }
        endDate = Calendar.getInstance();
        while (endDate.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
            endDate.add(Calendar.DAY_OF_WEEK, -1);
        }
        endDate.add(Calendar.DAY_OF_MONTH, 7);

        TitledBorder title;
        String niceDate = dfm.format(startDate.getTime());
        title = BorderFactory.createTitledBorder("The week of: " + niceDate);
        dfm = new SimpleDateFormat("EEEE, MMMM dd, yyyy");
        todayLabel.setText("Today's date is: " + dfm.format(today.getTime()));
        scheduleScrollPane.setBorder(title);

        getFrame().setResizable(false);

        //hackish code to put in a frame icon
        org.jdesktop.application.ResourceMap resourceMap1 = org.jdesktop.application.Application.getInstance(etvfit.ETVFitApp.class).getContext().getResourceMap(ETVFitView.class);
        ImageIcon icon = resourceMap1.getImageIcon("frameIcon.icon"); // NOI18N
        getFrame().setIconImage(icon.getImage());


        loadData();

        this.childEditingLabel.setVisible(false);
        //Hide the "New child" stuff
        jLabel9.setVisible(false);
        jLabel10.setVisible(false);
        newChildUsernameTextField.setVisible(false);
        newChildPasswordTextField.setVisible(false);
        jButton5.setVisible(false);
        jButton4.setVisible(false);

        // ETVFitView.setIconImage(Toolkit.getDefaultToolkit().getImage("etv.jpg"));
        // <editor-fold defaultstate="collapsed" desc="Busy Icons, etc">
        // status bar initialization - message timeout, idle icon and busy animation, etc


        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                statusMessageLabel.setText("");
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        statusAnimationLabel.setIcon(idleIcon);
        progressBar.setVisible(false);

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {

            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        statusAnimationLabel.setIcon(busyIcons[0]);
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(true);
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                    statusAnimationLabel.setIcon(idleIcon);
                    progressBar.setVisible(false);
                    progressBar.setValue(0);
                } else if ("message".equals(propertyName)) {
                    String text = (String) (evt.getNewValue());
                    statusMessageLabel.setText((text == null) ? "" : text);
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer) (evt.getNewValue());
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(false);
                    progressBar.setValue(value);
                }
            }
        });
    //</editor-fold>
    }
    @Action
    public void AddChild() {

        //Show the "New child" stuff
        jLabel9.setVisible(true);
        jLabel10.setVisible(true);
        newChildUsernameTextField.setVisible(true);
        newChildPasswordTextField.setVisible(true);
        jButton5.setVisible(true);
    }
    @Action
    public void addSpecialist() {
        this.user.getSpecialists().add(new Doctor());
        loadInSelectedSpecialist(this.user.getSpecialists().size() - 1);
        SpinnerNumberModel model = new SpinnerNumberModel(1, 1, user.getSpecialists().size(), 1);
        this.specialistSpinner.setModel(model);
        this.specialistSpinner.setValue(user.getSpecialists().size());
    }
    @Action
    public void addThisChild() {
        ((Parent) user).addNewChild(new User(this.newChildUsernameTextField.getText(),
                this.newChildPasswordTextField.getText()));
        //Hide the "New child" stuff
        jLabel9.setVisible(false);
        jLabel10.setVisible(false);
        newChildUsernameTextField.setVisible(false);
        newChildPasswordTextField.setVisible(false);
        jButton5.setVisible(false);
        childrenList.setListData(((Parent) user).children);
    }
    private void childrenListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_childrenListValueChanged

        if (!childrenList.isSelectionEmpty()) {
            jButton3.setEnabled(true);
            jButton6.setEnabled(true);
        } else {
            jButton3.setEnabled(false);
            this.jButton6.setEnabled(false);
        }
    }//GEN-LAST:event_childrenListValueChanged
    private void currentMedicationsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_currentMedicationsListValueChanged
        if (!currentMedicationsList.isSelectionEmpty()) {
            editMedicationButton.setEnabled(true);
            this.stopMedicationButton.setEnabled(true);
        } else {
            editMedicationButton.setEnabled(false);
            this.stopMedicationButton.setEnabled(false);
        }
    }//GEN-LAST:event_currentMedicationsListValueChanged
    @Action
    public void editAppointment() {

        Vector<Doctor> myDocs = new Vector<Doctor>();
        myDocs.add(user.getPrimaryPhysician());
        myDocs.addAll(user.getSpecialists());

        Appointment editAppt = (Appointment) scheduleTable.getValueAt(scheduleTable.getSelectedRow(), scheduleTable.getSelectedColumn());
        JFrame mainFrame = ETVFitApp.getApplication().getMainFrame();

        ETVFitAppointmentBox appointmentBox = new ETVFitAppointmentBox(mainFrame, true, editAppt, myDocs);
        appointmentBox.setLocationRelativeTo(mainFrame);

        ETVFitApp.getApplication().show(appointmentBox);
        if (appointmentBox.getReturnStatus() == ETVFitAppointmentBox.RET_OK) {
            populateAppointments();
        }

    }
    @Action
    public void editChild() {

        JOptionPane.showMessageDialog(new java.awt.Frame(),
                "Now entering Child-Editing Mode, where you can change the information of your child.  \n" +
                "Your information fields will be replaced by those of your selected child.\n" +
                "To return to your information, press the \"Return to Parent Mode\" button.",
                "Child-Editing Mode", JOptionPane.INFORMATION_MESSAGE);
        prevUser =
                user;
        user =
                ((Parent) user).children.get(childrenList.getSelectedIndex());
        // user=login.getUser();
        loadData();

        jButton4.setVisible(true);
        jButton6.setVisible(false);
        jButton2.setVisible(false);
        jButton3.setVisible(false);
        this.childEditingLabel.setVisible(true);
    }
    @Action
    public void editMedication() {
        //Find the selected med
        Medication selectedMed = user.medications.get(currentMedicationsList.getSelectedIndex());
        JFrame mainFrame = ETVFitApp.getApplication().getMainFrame();

        Vector<Doctor> myDocs = new Vector<Doctor>();
        myDocs.add(user.getPrimaryPhysician());
        myDocs.addAll(user.getSpecialists());

        ETVFitMedicationsBox medicationBox = new ETVFitMedicationsBox(mainFrame, true, selectedMed, myDocs);
        medicationBox.setLocationRelativeTo(mainFrame);

        ETVFitApp.getApplication().show(medicationBox);
        if (medicationBox.getReturnStatus() == ETVFitMedicationsBox.RET_OK) {
            populateMedications();
        } //Otherwise, don't do anything

    }
    @Action
    public void EditMyInfo() {
        for (Component o : this.personalInfoPanel.getComponents()) {
            if (!o.getClass().isInstance(new JLabel())) {
                o.setEnabled(true);
            }

        }
        this.allergiesTextArea.setEditable(true);
        this.allergiesTextArea.setEnabled(true);
        this.medicalHistoryTextArea.setEnabled(true);
        this.medicalHistoryTextArea.setEditable(true);
        this.editMyInfoButton.setEnabled(false);
    }
    @Action
    public void EditPrimaryInfo() {
        for (Component o : this.primaryPanel.getComponents()) {
            if (!o.getClass().isInstance(new JLabel())) {
                o.setEnabled(true);
            }

        }
        this.savePrimaryButton.setEnabled(true);
        this.editPrimaryButton.setEnabled(false);
    }
    @Action
    public void EditSecondaryInfo() {
        for (Component o : this.specialistPanel.getComponents()) {
            if (!o.getClass().isInstance(new JLabel())) {
                o.setEnabled(true);
            }

        }
        this.saveSpecialistButton.setEnabled(true);
        this.editSpecialistButton.setEnabled(false);
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        welcomeLabel = new javax.swing.JLabel();
        welcomeNameLabel = new javax.swing.JLabel();
        todayLabel = new javax.swing.JLabel();
        actionsTabbedPane = new javax.swing.JTabbedPane();
        scheduleTabPanel = new javax.swing.JPanel();
        scheduleScrollPane = new javax.swing.JScrollPane();
        scheduleTable = new javax.swing.JTable();
        previousWeekButton = new javax.swing.JButton();
        nextWeekButton = new javax.swing.JButton();
        addAppointmentButton = new javax.swing.JButton();
        remindersPanel = new javax.swing.JPanel();
        remindersScrollPane = new javax.swing.JScrollPane();
        remindersList = new javax.swing.JList();
        editAppointmentButton = new javax.swing.JButton();
        myInfoTabPanel = new javax.swing.JPanel();
        myInfoSeparator = new javax.swing.JSeparator();
        personalInfoPanel = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        myNameTextField = new javax.swing.JTextField();
        myAgeTextField = new javax.swing.JTextField();
        maleRadioButton = new javax.swing.JRadioButton();
        femaleRadioButton = new javax.swing.JRadioButton();
        myAddress1TextField = new javax.swing.JTextField();
        myCityTextField = new javax.swing.JTextField();
        myStateTextField = new javax.swing.JTextField();
        myZipTextField = new javax.swing.JTextField();
        myPhoneTextField = new javax.swing.JTextField();
        myInsuranceTextField = new javax.swing.JTextField();
        myInsuranceNumberTextField = new javax.swing.JTextField();
        editMyInfoButton = new javax.swing.JButton();
        saveMyChangesButton = new javax.swing.JButton();
        moreInfoPanel = new javax.swing.JSplitPane();
        medicalHistoryPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        medicalHistoryTextArea = new javax.swing.JTextArea();
        allergiesPanel = new javax.swing.JPanel();
        allergiesScrollPane = new javax.swing.JScrollPane();
        allergiesTextArea = new javax.swing.JTextArea();
        medicationsTabPanel = new javax.swing.JPanel();
        medicationsSeparator = new javax.swing.JSeparator();
        currentMedicationsPanel = new javax.swing.JPanel();
        currentMedicationsScrollPane = new javax.swing.JScrollPane();
        currentMedicationsList = new javax.swing.JList();
        addNewMedicationButton = new javax.swing.JButton();
        stopMedicationButton = new javax.swing.JButton();
        editMedicationButton = new javax.swing.JButton();
        pastMedicationsPanel = new javax.swing.JPanel();
        pastMedicationsScrollPane = new javax.swing.JScrollPane();
        pastMedicationsList = new javax.swing.JList();
        doctorTabPanel = new javax.swing.JPanel();
        doctorSeparator = new javax.swing.JSeparator();
        primaryPanel = new javax.swing.JPanel();
        primaryNameLabel = new javax.swing.JLabel();
        primaryNameTextField = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        primaryAddressTextField = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        primaryCityTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        primaryStateTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        primaryZipTextField = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        primaryPhoneTextField = new javax.swing.JTextField();
        primaryButtonsPanel = new javax.swing.JPanel();
        editPrimaryButton = new javax.swing.JButton();
        savePrimaryButton = new javax.swing.JButton();
        specialistPanel = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        specialistSpinner = new javax.swing.JSpinner();
        addNewSpecialistButton = new javax.swing.JButton();
        jLabelName1 = new javax.swing.JLabel();
        specialistNameTextField = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        specialistAddressTextField = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        specialistCityTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        specialistStateTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        specialistZipTextField = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        specialistPhoneTextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        specialtyTextField = new javax.swing.JTextField();
        specialistButtonsPanel = new javax.swing.JPanel();
        editSpecialistButton = new javax.swing.JButton();
        saveSpecialistButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        childrenList = new javax.swing.JList();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        newChildUsernameTextField = new javax.swing.JTextField();
        newChildPasswordTextField = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        childEditingLabel = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JSeparator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        saveAllMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        genderButtonGroup = new javax.swing.ButtonGroup();

        mainPanel.setName("mainPanel"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(etvfit.ETVFitApp.class).getContext().getResourceMap(ETVFitView.class);
        welcomeLabel.setText(resourceMap.getString("welcomeLabel.text")); // NOI18N
        welcomeLabel.setName("welcomeLabel"); // NOI18N

        welcomeNameLabel.setText(resourceMap.getString("nameLabel.text")); // NOI18N
        welcomeNameLabel.setName("nameLabel"); // NOI18N

        todayLabel.setText(resourceMap.getString("todayLabel.text")); // NOI18N
        todayLabel.setName("todayLabel"); // NOI18N

        actionsTabbedPane.setName("actionsTabbedPane"); // NOI18N
        actionsTabbedPane.setPreferredSize(new java.awt.Dimension(578, 251));

        scheduleTabPanel.setName("scheduleTabPanel"); // NOI18N

        scheduleScrollPane.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("scheduleScrollPane.border.title"))); // NOI18N
        scheduleScrollPane.setName("scheduleScrollPane"); // NOI18N

        scheduleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"No items", "No items", "No Items", "No items", "No items", "No items", "No items"},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scheduleTable.setColumnSelectionAllowed(true);
        scheduleTable.setFillsViewportHeight(true);
        scheduleTable.setName("scheduleTable"); // NOI18N
        scheduleTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scheduleTable.setShowHorizontalLines(false);
        scheduleTable.getTableHeader().setReorderingAllowed(false);
        scheduleScrollPane.setViewportView(scheduleTable);
        scheduleTable.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("scheduleTable.columnModel.title0")); // NOI18N
        scheduleTable.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("scheduleTable.columnModel.title1")); // NOI18N
        scheduleTable.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("scheduleTable.columnModel.title2")); // NOI18N
        scheduleTable.getColumnModel().getColumn(3).setHeaderValue(resourceMap.getString("scheduleTable.columnModel.title3")); // NOI18N
        scheduleTable.getColumnModel().getColumn(4).setHeaderValue(resourceMap.getString("scheduleTable.columnModel.title4")); // NOI18N
        scheduleTable.getColumnModel().getColumn(5).setHeaderValue(resourceMap.getString("scheduleTable.columnModel.title5")); // NOI18N
        scheduleTable.getColumnModel().getColumn(6).setResizable(false);
        scheduleTable.getColumnModel().getColumn(6).setHeaderValue(resourceMap.getString("scheduleTable.columnModel.title6")); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(etvfit.ETVFitApp.class).getContext().getActionMap(ETVFitView.class, this);
        previousWeekButton.setAction(actionMap.get("previousWeek")); // NOI18N
        previousWeekButton.setIcon(resourceMap.getIcon("previousWeekButton.icon")); // NOI18N
        previousWeekButton.setText(resourceMap.getString("previousWeekButton.text")); // NOI18N
        previousWeekButton.setName("previousWeekButton"); // NOI18N

        nextWeekButton.setAction(actionMap.get("nextWeek")); // NOI18N
        nextWeekButton.setIcon(resourceMap.getIcon("nextWeekButton.icon")); // NOI18N
        nextWeekButton.setText(resourceMap.getString("nextWeekButton.text")); // NOI18N
        nextWeekButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        nextWeekButton.setName("nextWeekButton"); // NOI18N

        addAppointmentButton.setAction(actionMap.get("newAppointment")); // NOI18N
        addAppointmentButton.setIcon(resourceMap.getIcon("addAppointmentButton.icon")); // NOI18N
        addAppointmentButton.setText(resourceMap.getString("addAppointmentButton.text")); // NOI18N
        addAppointmentButton.setName("addAppointmentButton"); // NOI18N

        remindersPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("remindersPanel.border.title"))); // NOI18N
        remindersPanel.setName("remindersPanel"); // NOI18N

        remindersScrollPane.setName("remindersScrollPane"); // NOI18N

        remindersList.setModel( new DefaultListModel());
        remindersList.setName("remindersList"); // NOI18N
        remindersScrollPane.setViewportView(remindersList);

        javax.swing.GroupLayout remindersPanelLayout = new javax.swing.GroupLayout(remindersPanel);
        remindersPanel.setLayout(remindersPanelLayout);
        remindersPanelLayout.setHorizontalGroup(
            remindersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(remindersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(remindersScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .addContainerGap())
        );
        remindersPanelLayout.setVerticalGroup(
            remindersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(remindersScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        editAppointmentButton.setAction(actionMap.get("editAppointment")); // NOI18N
        editAppointmentButton.setIcon(resourceMap.getIcon("editAppointmentButton.icon")); // NOI18N
        editAppointmentButton.setText(resourceMap.getString("editAppointmentButton.text")); // NOI18N
        editAppointmentButton.setName("editAppointmentButton"); // NOI18N

        javax.swing.GroupLayout scheduleTabPanelLayout = new javax.swing.GroupLayout(scheduleTabPanel);
        scheduleTabPanel.setLayout(scheduleTabPanelLayout);
        scheduleTabPanelLayout.setHorizontalGroup(
            scheduleTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scheduleTabPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(scheduleTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scheduleScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                    .addGroup(scheduleTabPanelLayout.createSequentialGroup()
                        .addGroup(scheduleTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nextWeekButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(previousWeekButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(scheduleTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(editAppointmentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addAppointmentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(remindersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        scheduleTabPanelLayout.setVerticalGroup(
            scheduleTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scheduleTabPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scheduleScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(scheduleTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(scheduleTabPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(remindersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(scheduleTabPanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(scheduleTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(addAppointmentButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(previousWeekButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(scheduleTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nextWeekButton)
                            .addComponent(editAppointmentButton))))
                .addGap(129, 129, 129))
        );

        actionsTabbedPane.addTab(resourceMap.getString("scheduleTabPanel.TabConstraints.tabTitle"), resourceMap.getIcon("scheduleTabPanel.TabConstraints.tabIcon"), scheduleTabPanel, resourceMap.getString("scheduleTabPanel.TabConstraints.tabToolTip")); // NOI18N

        myInfoTabPanel.setName("myInfoTabPanel"); // NOI18N
        myInfoTabPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        myInfoSeparator.setOrientation(javax.swing.SwingConstants.VERTICAL);
        myInfoSeparator.setName("myInfoSeparator"); // NOI18N
        myInfoTabPanel.add(myInfoSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 20, 300));

        personalInfoPanel.setEnabled(false);
        personalInfoPanel.setName("personalInfoPanel"); // NOI18N

        jLabel13.setText(resourceMap.getString("jLabel13.text")); // NOI18N
        jLabel13.setName("jLabel13"); // NOI18N

        jLabel26.setText(resourceMap.getString("jLabel26.text")); // NOI18N
        jLabel26.setName("jLabel26"); // NOI18N

        jLabel27.setText(resourceMap.getString("jLabel27.text")); // NOI18N
        jLabel27.setName("jLabel27"); // NOI18N

        jLabel28.setText(resourceMap.getString("jLabel28.text")); // NOI18N
        jLabel28.setName("jLabel28"); // NOI18N

        jLabel29.setText(resourceMap.getString("jLabel29.text")); // NOI18N
        jLabel29.setName("jLabel29"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel30.setText(resourceMap.getString("jLabel30.text")); // NOI18N
        jLabel30.setName("jLabel30"); // NOI18N

        jLabel31.setText(resourceMap.getString("jLabel31.text")); // NOI18N
        jLabel31.setName("jLabel31"); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        myNameTextField.setText(resourceMap.getString("myNameTextField.text")); // NOI18N
        myNameTextField.setEnabled(false);
        myNameTextField.setName("myNameTextField"); // NOI18N

        myAgeTextField.setText(resourceMap.getString("myAgeTextField.text")); // NOI18N
        myAgeTextField.setEnabled(false);
        myAgeTextField.setName("myAgeTextField"); // NOI18N

        genderButtonGroup.add(maleRadioButton);
        maleRadioButton.setText(resourceMap.getString("maleRadioButton.text")); // NOI18N
        maleRadioButton.setEnabled(false);
        maleRadioButton.setName("maleRadioButton"); // NOI18N

        genderButtonGroup.add(femaleRadioButton);
        femaleRadioButton.setSelected(true);
        femaleRadioButton.setEnabled(false);
        femaleRadioButton.setLabel(resourceMap.getString("femaleRadioButton.label")); // NOI18N
        femaleRadioButton.setName("femaleRadioButton"); // NOI18N

        myAddress1TextField.setText(resourceMap.getString("myAddress1TextField.text")); // NOI18N
        myAddress1TextField.setEnabled(false);
        myAddress1TextField.setName("myAddress1TextField"); // NOI18N

        myCityTextField.setText(resourceMap.getString("myCityTextField.text")); // NOI18N
        myCityTextField.setEnabled(false);
        myCityTextField.setName("myCityTextField"); // NOI18N

        myStateTextField.setText(resourceMap.getString("myStateTextField.text")); // NOI18N
        myStateTextField.setEnabled(false);
        myStateTextField.setName("myStateTextField"); // NOI18N

        myZipTextField.setText(resourceMap.getString("myZipTextField.text")); // NOI18N
        myZipTextField.setEnabled(false);
        myZipTextField.setName("myZipTextField"); // NOI18N

        myPhoneTextField.setText(resourceMap.getString("myPhoneTextField.text")); // NOI18N
        myPhoneTextField.setEnabled(false);
        myPhoneTextField.setName("myPhoneTextField"); // NOI18N

        myInsuranceTextField.setText(resourceMap.getString("myInsuranceTextField.text")); // NOI18N
        myInsuranceTextField.setEnabled(false);
        myInsuranceTextField.setName("myInsuranceTextField"); // NOI18N

        myInsuranceNumberTextField.setText(resourceMap.getString("myInsuranceNumberTextField.text")); // NOI18N
        myInsuranceNumberTextField.setEnabled(false);
        myInsuranceNumberTextField.setName("myInsuranceNumberTextField"); // NOI18N

        editMyInfoButton.setAction(actionMap.get("EditMyInfo")); // NOI18N
        editMyInfoButton.setIcon(resourceMap.getIcon("editMyInfoButton.icon")); // NOI18N
        editMyInfoButton.setText(resourceMap.getString("editMyInfoButton.text")); // NOI18N
        editMyInfoButton.setName("editMyInfoButton"); // NOI18N

        saveMyChangesButton.setAction(actionMap.get("SaveMyInfo")); // NOI18N
        saveMyChangesButton.setIcon(resourceMap.getIcon("saveMyChangesButton.icon")); // NOI18N
        saveMyChangesButton.setText(resourceMap.getString("saveMyChangesButton.text")); // NOI18N
        saveMyChangesButton.setName("saveMyChangesButton"); // NOI18N

        javax.swing.GroupLayout personalInfoPanelLayout = new javax.swing.GroupLayout(personalInfoPanel);
        personalInfoPanel.setLayout(personalInfoPanelLayout);
        personalInfoPanelLayout.setHorizontalGroup(
            personalInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personalInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(personalInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(personalInfoPanelLayout.createSequentialGroup()
                        .addComponent(editMyInfoButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addComponent(saveMyChangesButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, personalInfoPanelLayout.createSequentialGroup()
                        .addGroup(personalInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, personalInfoPanelLayout.createSequentialGroup()
                                .addGroup(personalInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, personalInfoPanelLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(21, 21, 21))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, personalInfoPanelLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, personalInfoPanelLayout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(personalInfoPanelLayout.createSequentialGroup()
                                .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(personalInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(personalInfoPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(myInsuranceNumberTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
                            .addComponent(myInsuranceTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                            .addGroup(personalInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(personalInfoPanelLayout.createSequentialGroup()
                                    .addComponent(maleRadioButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(femaleRadioButton))
                                .addComponent(myCityTextField)
                                .addComponent(myAddress1TextField)
                                .addComponent(myNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                                .addComponent(myAgeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(myStateTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(personalInfoPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(myPhoneTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
                            .addComponent(myZipTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        personalInfoPanelLayout.setVerticalGroup(
            personalInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personalInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(personalInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(personalInfoPanelLayout.createSequentialGroup()
                        .addGroup(personalInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(myNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(personalInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(myAgeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(personalInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(maleRadioButton)
                            .addComponent(femaleRadioButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(personalInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(myAddress1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(personalInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(myCityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(personalInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(myStateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(personalInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(myZipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(personalInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(myPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(myInsuranceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(personalInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(myInsuranceNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(personalInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editMyInfoButton)
                            .addComponent(saveMyChangesButton))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, personalInfoPanelLayout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addGap(70, 70, 70))))
        );

        myInfoTabPanel.add(personalInfoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 290));

        moreInfoPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        moreInfoPanel.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        moreInfoPanel.setName("moreInfoPanel"); // NOI18N

        medicalHistoryPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("medicalHistoryPanel.border.title"))); // NOI18N
        medicalHistoryPanel.setName("medicalHistoryPanel"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        medicalHistoryTextArea.setColumns(20);
        medicalHistoryTextArea.setEditable(false);
        medicalHistoryTextArea.setRows(5);
        medicalHistoryTextArea.setName("medicalHistoryTextArea"); // NOI18N
        jScrollPane2.setViewportView(medicalHistoryTextArea);

        javax.swing.GroupLayout medicalHistoryPanelLayout = new javax.swing.GroupLayout(medicalHistoryPanel);
        medicalHistoryPanel.setLayout(medicalHistoryPanelLayout);
        medicalHistoryPanelLayout.setHorizontalGroup(
            medicalHistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(medicalHistoryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                .addContainerGap())
        );
        medicalHistoryPanelLayout.setVerticalGroup(
            medicalHistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        moreInfoPanel.setTopComponent(medicalHistoryPanel);

        allergiesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("allergiesPanel.border.title"))); // NOI18N
        allergiesPanel.setName("allergiesPanel"); // NOI18N

        allergiesScrollPane.setName("allergiesScrollPane"); // NOI18N

        allergiesTextArea.setColumns(20);
        allergiesTextArea.setEditable(false);
        allergiesTextArea.setRows(5);
        allergiesTextArea.setName("allergiesTextArea"); // NOI18N
        allergiesScrollPane.setViewportView(allergiesTextArea);

        javax.swing.GroupLayout allergiesPanelLayout = new javax.swing.GroupLayout(allergiesPanel);
        allergiesPanel.setLayout(allergiesPanelLayout);
        allergiesPanelLayout.setHorizontalGroup(
            allergiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(allergiesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(allergiesScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                .addContainerGap())
        );
        allergiesPanelLayout.setVerticalGroup(
            allergiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(allergiesScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
        );

        moreInfoPanel.setRightComponent(allergiesPanel);

        myInfoTabPanel.add(moreInfoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 260, 250));

        actionsTabbedPane.addTab(resourceMap.getString("myInfoTabPanel.TabConstraints.tabTitle"), resourceMap.getIcon("myInfoTabPanel.TabConstraints.tabIcon"), myInfoTabPanel, resourceMap.getString("myInfoTabPanel.TabConstraints.tabToolTip")); // NOI18N

        medicationsTabPanel.setName("medicationsTabPanel"); // NOI18N
        medicationsTabPanel.setPreferredSize(new java.awt.Dimension(578, 223));
        medicationsTabPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        medicationsSeparator.setOrientation(javax.swing.SwingConstants.VERTICAL);
        medicationsSeparator.setName("medicationsSeparator"); // NOI18N
        medicationsTabPanel.add(medicationsSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 30, 300));

        currentMedicationsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("currentMedicationsPanel.border.title"))); // NOI18N
        currentMedicationsPanel.setName("currentMedicationsPanel"); // NOI18N

        currentMedicationsScrollPane.setName("currentMedicationsScrollPane"); // NOI18N

        currentMedicationsList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Lexapro, a XX dose taken 1 time daily for horrible pain and random spazzing", "Seroxa, a XX dose taken 2 times daily for horrible pain and random spazzing", "Prozac, a XX dose taken 3 times daily for horrible pain and random spazzing", "Luvox, a XX dose taken 4 times daily for horrible pain and random spazzing", "Celexa, a XX dose taken 5 times daily for horrible pain and random spazzing" };
            public Object getElementAt(int i) { return strings[i]; }
            public int getSize() { return strings.length; }
        });
        currentMedicationsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        currentMedicationsList.setName("PastMedsList"); // NOI18N
        currentMedicationsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                currentMedicationsListValueChanged(evt);
            }
        });
        currentMedicationsScrollPane.setViewportView(currentMedicationsList);

        addNewMedicationButton.setAction(actionMap.get("newMedication")); // NOI18N
        addNewMedicationButton.setIcon(resourceMap.getIcon("addNewMedicationButton.icon")); // NOI18N
        addNewMedicationButton.setText(resourceMap.getString("addNewMedicationButton.text")); // NOI18N
        addNewMedicationButton.setName("addNewMedicationButton"); // NOI18N

        stopMedicationButton.setIcon(resourceMap.getIcon("stopMedicationButton.icon")); // NOI18N
        stopMedicationButton.setText(resourceMap.getString("stopMedicationButton.text")); // NOI18N
        stopMedicationButton.setEnabled(false);
        stopMedicationButton.setName("stopMedicationButton"); // NOI18N
        stopMedicationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopMedicationButtonActionPerformed(evt);
            }
        });

        editMedicationButton.setAction(actionMap.get("editMedication")); // NOI18N
        editMedicationButton.setIcon(resourceMap.getIcon("editMedicationButton.icon")); // NOI18N
        editMedicationButton.setText(resourceMap.getString("editMedicationButton.text")); // NOI18N
        editMedicationButton.setName("editMedicationButton"); // NOI18N

        javax.swing.GroupLayout currentMedicationsPanelLayout = new javax.swing.GroupLayout(currentMedicationsPanel);
        currentMedicationsPanel.setLayout(currentMedicationsPanelLayout);
        currentMedicationsPanelLayout.setHorizontalGroup(
            currentMedicationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(currentMedicationsPanelLayout.createSequentialGroup()
                .addGroup(currentMedicationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(currentMedicationsPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(currentMedicationsScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
                    .addGroup(currentMedicationsPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(addNewMedicationButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editMedicationButton, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
                    .addGroup(currentMedicationsPanelLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(stopMedicationButton)))
                .addContainerGap())
        );
        currentMedicationsPanelLayout.setVerticalGroup(
            currentMedicationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(currentMedicationsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(currentMedicationsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(currentMedicationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(editMedicationButton)
                    .addComponent(addNewMedicationButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stopMedicationButton)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        medicationsTabPanel.add(currentMedicationsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 290, 260));

        pastMedicationsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("pastMedicationsPanel.border.title"))); // NOI18N
        pastMedicationsPanel.setName("pastMedicationsPanel"); // NOI18N

        pastMedicationsScrollPane.setName("pastMedicationsScrollPane"); // NOI18N

        pastMedicationsList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Marplan", "Manerix", "Nardil", "Parnate", "l-deprenyl", "Eldepryl", "Zelapar", "Emsam", " " };
            public Object getElementAt(int i) { return strings[i]; }
            public int getSize() { return strings.length; }
        });
        pastMedicationsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        pastMedicationsList.setName("CurrentMedsList"); // NOI18N
        pastMedicationsScrollPane.setViewportView(pastMedicationsList);

        javax.swing.GroupLayout pastMedicationsPanelLayout = new javax.swing.GroupLayout(pastMedicationsPanel);
        pastMedicationsPanel.setLayout(pastMedicationsPanelLayout);
        pastMedicationsPanelLayout.setHorizontalGroup(
            pastMedicationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pastMedicationsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pastMedicationsScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                .addContainerGap())
        );
        pastMedicationsPanelLayout.setVerticalGroup(
            pastMedicationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pastMedicationsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pastMedicationsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        medicationsTabPanel.add(pastMedicationsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 280, 260));

        actionsTabbedPane.addTab(resourceMap.getString("medicationsTabPanel.TabConstraints.tabTitle"), resourceMap.getIcon("medicationsTabPanel.TabConstraints.tabIcon"), medicationsTabPanel, resourceMap.getString("medicationsTabPanel.TabConstraints.tabToolTip")); // NOI18N

        doctorTabPanel.setName("doctorTabPanel"); // NOI18N
        doctorTabPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        doctorSeparator.setOrientation(javax.swing.SwingConstants.VERTICAL);
        doctorSeparator.setName("doctorSeparator"); // NOI18N
        doctorTabPanel.add(doctorSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 10, 300));

        primaryPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("primaryPanel.border.title"))); // NOI18N
        primaryPanel.setName("primaryPanel"); // NOI18N

        primaryNameLabel.setText(resourceMap.getString("primaryNameLabel.text")); // NOI18N
        primaryNameLabel.setName("primaryNameLabel"); // NOI18N

        primaryNameTextField.setText(resourceMap.getString("primaryNameTextField.text")); // NOI18N
        primaryNameTextField.setEnabled(false);
        primaryNameTextField.setName("primaryNameTextField"); // NOI18N

        jLabel32.setText(resourceMap.getString("jLabel32.text")); // NOI18N
        jLabel32.setName("jLabel32"); // NOI18N

        primaryAddressTextField.setText(resourceMap.getString("primaryAddressTextField.text")); // NOI18N
        primaryAddressTextField.setEnabled(false);
        primaryAddressTextField.setName("primaryAddressTextField"); // NOI18N

        jLabel33.setText(resourceMap.getString("jLabel33.text")); // NOI18N
        jLabel33.setName("jLabel33"); // NOI18N

        primaryCityTextField.setText(resourceMap.getString("primaryCityTextField.text")); // NOI18N
        primaryCityTextField.setEnabled(false);
        primaryCityTextField.setName("primaryCityTextField"); // NOI18N

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        primaryStateTextField.setText(resourceMap.getString("primaryStateTextField.text")); // NOI18N
        primaryStateTextField.setEnabled(false);
        primaryStateTextField.setName("primaryStateTextField"); // NOI18N

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        primaryZipTextField.setText(resourceMap.getString("primaryZipTextField.text")); // NOI18N
        primaryZipTextField.setEnabled(false);
        primaryZipTextField.setName("primaryZipTextField"); // NOI18N

        jLabel25.setText(resourceMap.getString("jLabel25.text")); // NOI18N
        jLabel25.setName("jLabel25"); // NOI18N

        primaryPhoneTextField.setText(resourceMap.getString("primaryPhoneTextField.text")); // NOI18N
        primaryPhoneTextField.setEnabled(false);
        primaryPhoneTextField.setName("primaryPhoneTextField"); // NOI18N

        primaryButtonsPanel.setName("primaryButtonsPanel"); // NOI18N

        editPrimaryButton.setAction(actionMap.get("EditPrimaryInfo")); // NOI18N
        editPrimaryButton.setIcon(resourceMap.getIcon("editPrimaryButton.icon")); // NOI18N
        editPrimaryButton.setText(resourceMap.getString("editPrimaryButton.text")); // NOI18N
        editPrimaryButton.setName("editPrimaryButton"); // NOI18N

        savePrimaryButton.setAction(actionMap.get("savePrimaryInfo")); // NOI18N
        savePrimaryButton.setIcon(resourceMap.getIcon("savePrimaryButton.icon")); // NOI18N
        savePrimaryButton.setText(resourceMap.getString("savePrimaryButton.text")); // NOI18N
        savePrimaryButton.setName("savePrimaryButton"); // NOI18N

        javax.swing.GroupLayout primaryButtonsPanelLayout = new javax.swing.GroupLayout(primaryButtonsPanel);
        primaryButtonsPanel.setLayout(primaryButtonsPanelLayout);
        primaryButtonsPanelLayout.setHorizontalGroup(
            primaryButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(primaryButtonsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(editPrimaryButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(savePrimaryButton)
                .addContainerGap())
        );
        primaryButtonsPanelLayout.setVerticalGroup(
            primaryButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(primaryButtonsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(primaryButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editPrimaryButton)
                    .addComponent(savePrimaryButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout primaryPanelLayout = new javax.swing.GroupLayout(primaryPanel);
        primaryPanel.setLayout(primaryPanelLayout);
        primaryPanelLayout.setHorizontalGroup(
            primaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(primaryPanelLayout.createSequentialGroup()
                .addGroup(primaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, primaryPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(primaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(primaryNameLabel)
                            .addComponent(jLabel32)
                            .addComponent(jLabel4)
                            .addComponent(jLabel33)
                            .addComponent(jLabel5)
                            .addComponent(jLabel25))
                        .addGap(10, 10, 10)
                        .addGroup(primaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(primaryZipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(primaryStateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(primaryAddressTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                            .addComponent(primaryCityTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                            .addComponent(primaryNameTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, primaryPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(primaryPhoneTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))))
                    .addGroup(primaryPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(primaryButtonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        primaryPanelLayout.setVerticalGroup(
            primaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(primaryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(primaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(primaryNameLabel)
                    .addComponent(primaryNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(primaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(primaryAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(primaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(primaryCityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(primaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(primaryStateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(primaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(primaryZipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(primaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(primaryPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(primaryButtonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        doctorTabPanel.add(primaryPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 290, 280));

        specialistPanel.setName("specialistPanel"); // NOI18N

        jLabel17.setText(resourceMap.getString("jLabel17.text")); // NOI18N
        jLabel17.setName("jLabel17"); // NOI18N

        specialistSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), null, null, Integer.valueOf(1)));
        specialistSpinner.setEditor(new javax.swing.JSpinner.NumberEditor(specialistSpinner, ""));
        specialistSpinner.setName("specialistSpinner"); // NOI18N
        specialistSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                specialistSpinnerStateChanged(evt);
            }
        });

        addNewSpecialistButton.setAction(actionMap.get("addSpecialist")); // NOI18N
        addNewSpecialistButton.setIcon(resourceMap.getIcon("addNewSpecialistButton.icon")); // NOI18N
        addNewSpecialistButton.setText(resourceMap.getString("addNewSpecialistButton.text")); // NOI18N
        addNewSpecialistButton.setName("addNewSpecialistButton"); // NOI18N

        jLabelName1.setText(resourceMap.getString("jLabelName1.text")); // NOI18N
        jLabelName1.setName("jLabelName1"); // NOI18N

        specialistNameTextField.setText(resourceMap.getString("specialistNameTextField.text")); // NOI18N
        specialistNameTextField.setEnabled(false);
        specialistNameTextField.setName("specialistNameTextField"); // NOI18N

        jLabel18.setText(resourceMap.getString("jLabel18.text")); // NOI18N
        jLabel18.setName("jLabel18"); // NOI18N

        specialistAddressTextField.setText(resourceMap.getString("specialistAddressTextField.text")); // NOI18N
        specialistAddressTextField.setEnabled(false);
        specialistAddressTextField.setName("specialistAddressTextField"); // NOI18N

        jLabel34.setText(resourceMap.getString("jLabel34.text")); // NOI18N
        jLabel34.setName("jLabel34"); // NOI18N

        specialistCityTextField.setText(resourceMap.getString("specialistCityTextField.text")); // NOI18N
        specialistCityTextField.setEnabled(false);
        specialistCityTextField.setName("specialistCityTextField"); // NOI18N

        jLabel7.setText(resourceMap.getString("jLabel7.text")); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N

        specialistStateTextField.setText(resourceMap.getString("specialistStateTextField.text")); // NOI18N
        specialistStateTextField.setEnabled(false);
        specialistStateTextField.setName("specialistStateTextField"); // NOI18N

        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        specialistZipTextField.setText(resourceMap.getString("specialistZipTextField.text")); // NOI18N
        specialistZipTextField.setEnabled(false);
        specialistZipTextField.setName("specialistZipTextField"); // NOI18N

        jLabel19.setText(resourceMap.getString("jLabel19.text")); // NOI18N
        jLabel19.setName("jLabel19"); // NOI18N

        specialistPhoneTextField.setText(resourceMap.getString("specialistPhoneTextField.text")); // NOI18N
        specialistPhoneTextField.setEnabled(false);
        specialistPhoneTextField.setName("specialistPhoneTextField"); // NOI18N

        jLabel12.setText(resourceMap.getString("jLabel12.text")); // NOI18N
        jLabel12.setName("jLabel12"); // NOI18N

        specialtyTextField.setText(resourceMap.getString("specialtyTextField.text")); // NOI18N
        specialtyTextField.setEnabled(false);
        specialtyTextField.setName("specialtyTextField"); // NOI18N

        specialistButtonsPanel.setName("specialistButtonsPanel"); // NOI18N

        editSpecialistButton.setAction(actionMap.get("EditSecondaryInfo")); // NOI18N
        editSpecialistButton.setIcon(resourceMap.getIcon("editSpecialistButton.icon")); // NOI18N
        editSpecialistButton.setText(resourceMap.getString("editSpecialistButton.text")); // NOI18N
        editSpecialistButton.setName("editSpecialistButton"); // NOI18N

        saveSpecialistButton.setAction(actionMap.get("SaveSpecialistInfo")); // NOI18N
        saveSpecialistButton.setIcon(resourceMap.getIcon("saveSpecialistButton.icon")); // NOI18N
        saveSpecialistButton.setText(resourceMap.getString("saveSpecialistButton.text")); // NOI18N
        saveSpecialistButton.setName("saveSpecialistButton"); // NOI18N

        jButton1.setAction(actionMap.get("removeSpecialist")); // NOI18N
        jButton1.setIcon(resourceMap.getIcon("jButton1.icon")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N

        javax.swing.GroupLayout specialistButtonsPanelLayout = new javax.swing.GroupLayout(specialistButtonsPanel);
        specialistButtonsPanel.setLayout(specialistButtonsPanelLayout);
        specialistButtonsPanelLayout.setHorizontalGroup(
            specialistButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(specialistButtonsPanelLayout.createSequentialGroup()
                .addGroup(specialistButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(specialistButtonsPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(editSpecialistButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(saveSpecialistButton))
                    .addGroup(specialistButtonsPanelLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        specialistButtonsPanelLayout.setVerticalGroup(
            specialistButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(specialistButtonsPanelLayout.createSequentialGroup()
                .addGroup(specialistButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editSpecialistButton)
                    .addComponent(saveSpecialistButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1))
        );

        javax.swing.GroupLayout specialistPanelLayout = new javax.swing.GroupLayout(specialistPanel);
        specialistPanel.setLayout(specialistPanelLayout);
        specialistPanelLayout.setHorizontalGroup(
            specialistPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(specialistPanelLayout.createSequentialGroup()
                .addGroup(specialistPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(specialistPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(specialistPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(specialistPanelLayout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(specialistSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addNewSpecialistButton))
                            .addGroup(specialistPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(specialistPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabelName1))
                                .addGap(35, 35, 35)
                                .addGroup(specialistPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(specialistStateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(specialistCityTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                    .addComponent(specialistZipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(specialistAddressTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                    .addComponent(specialistNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)))))
                    .addGroup(specialistPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(specialistPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addGroup(specialistPanelLayout.createSequentialGroup()
                                .addGroup(specialistPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(specialistPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(specialistPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(specialtyTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)))
                            .addComponent(specialistButtonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        specialistPanelLayout.setVerticalGroup(
            specialistPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(specialistPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(specialistPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(specialistSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addNewSpecialistButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(specialistPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelName1)
                    .addComponent(specialistNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(specialistPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(specialistAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(specialistPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(specialistCityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(specialistPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(specialistStateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(specialistPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(specialistZipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(specialistPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(specialistPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(specialistPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(specialtyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(specialistButtonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        doctorTabPanel.add(specialistPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 280, 290));

        actionsTabbedPane.addTab(resourceMap.getString("doctorTabPanel.TabConstraints.tabTitle"), resourceMap.getIcon("doctorTabPanel.TabConstraints.tabIcon"), doctorTabPanel, resourceMap.getString("doctorTabPanel.TabConstraints.tabToolTip")); // NOI18N

        jPanel1.setName("jPanel1"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        childrenList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public Object getElementAt(int i) { return strings[i]; }
            public int getSize() { return strings.length; }
        });
        childrenList.setName("childrenList"); // NOI18N
        childrenList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                childrenListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(childrenList);

        jLabel8.setText(resourceMap.getString("jLabel8.text")); // NOI18N
        jLabel8.setName("jLabel8"); // NOI18N

        jButton2.setAction(actionMap.get("AddChild")); // NOI18N
        jButton2.setIcon(resourceMap.getIcon("jButton2.icon")); // NOI18N
        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N

        jButton3.setAction(actionMap.get("editChild")); // NOI18N
        jButton3.setIcon(resourceMap.getIcon("jButton3.icon")); // NOI18N
        jButton3.setText(resourceMap.getString("jButton3.text")); // NOI18N
        jButton3.setName("jButton3"); // NOI18N

        jButton4.setAction(actionMap.get("returnToParentMode")); // NOI18N
        jButton4.setIcon(resourceMap.getIcon("jButton4.icon")); // NOI18N
        jButton4.setText(resourceMap.getString("jButton4.text")); // NOI18N
        jButton4.setName("jButton4"); // NOI18N

        jLabel9.setText(resourceMap.getString("jLabel9.text")); // NOI18N
        jLabel9.setName("jLabel9"); // NOI18N

        jLabel10.setText(resourceMap.getString("jLabel10.text")); // NOI18N
        jLabel10.setName("jLabel10"); // NOI18N

        newChildUsernameTextField.setText(resourceMap.getString("newChildUsernameTextField.text")); // NOI18N
        newChildUsernameTextField.setName("newChildUsernameTextField"); // NOI18N

        newChildPasswordTextField.setText(resourceMap.getString("newChildPasswordTextField.text")); // NOI18N
        newChildPasswordTextField.setName("newChildPasswordTextField"); // NOI18N

        jButton5.setAction(actionMap.get("addThisChild")); // NOI18N
        jButton5.setText(resourceMap.getString("jButton5.text")); // NOI18N
        jButton5.setName("jButton5"); // NOI18N

        jButton6.setAction(actionMap.get("removeChild")); // NOI18N
        jButton6.setIcon(resourceMap.getIcon("jButton6.icon")); // NOI18N
        jButton6.setText(resourceMap.getString("jButton6.text")); // NOI18N
        jButton6.setName("jButton6"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(newChildPasswordTextField)
                                    .addComponent(newChildUsernameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))))
                        .addGap(69, 69, 69)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)))
                    .addComponent(jLabel8))
                .addGap(79, 79, 79))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(68, 68, 68))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(newChildUsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(newChildPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton4))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        actionsTabbedPane.addTab(resourceMap.getString("jPanel1.TabConstraints.tabTitle"), resourceMap.getIcon("jPanel1.TabConstraints.tabIcon"), jPanel1); // NOI18N

        childEditingLabel.setBackground(resourceMap.getColor("childEditingLabel.background")); // NOI18N
        childEditingLabel.setForeground(resourceMap.getColor("childEditingLabel.foreground")); // NOI18N
        childEditingLabel.setText(resourceMap.getString("childEditingLabel.text")); // NOI18N
        childEditingLabel.setBorder(javax.swing.BorderFactory.createLineBorder(resourceMap.getColor("childEditingLabel.border.lineColor"))); // NOI18N
        childEditingLabel.setName("childEditingLabel"); // NOI18N
        childEditingLabel.setOpaque(true);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(actionsTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(welcomeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(welcomeNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(childEditingLabel)
                        .addGap(37, 37, 37)
                        .addComponent(todayLabel)))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(welcomeLabel)
                            .addComponent(welcomeNameLabel)
                            .addComponent(todayLabel)))
                    .addComponent(childEditingLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(actionsTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        jMenuItem4.setAction(actionMap.get("showManageUsers")); // NOI18N
        jMenuItem4.setIcon(resourceMap.getIcon("jMenuItem4.icon")); // NOI18N
        jMenuItem4.setText(resourceMap.getString("jMenuItem4.text")); // NOI18N
        jMenuItem4.setName("jMenuItem4"); // NOI18N
        fileMenu.add(jMenuItem4);

        jSeparator2.setName("jSeparator2"); // NOI18N
        fileMenu.add(jSeparator2);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem1.setIcon(resourceMap.getIcon("jMenuItem1.icon")); // NOI18N
        jMenuItem1.setText(resourceMap.getString("jMenuItem1.text")); // NOI18N
        jMenuItem1.setName("jMenuItem1"); // NOI18N
        fileMenu.add(jMenuItem1);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem3.setIcon(resourceMap.getIcon("jMenuItem3.icon")); // NOI18N
        jMenuItem3.setText(resourceMap.getString("jMenuItem3.text")); // NOI18N
        jMenuItem3.setName("jMenuItem3"); // NOI18N
        fileMenu.add(jMenuItem3);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem2.setIcon(resourceMap.getIcon("jMenuItem2.icon")); // NOI18N
        jMenuItem2.setText(resourceMap.getString("jMenuItem2.text")); // NOI18N
        jMenuItem2.setName("jMenuItem2"); // NOI18N
        fileMenu.add(jMenuItem2);

        saveAllMenuItem.setAction(actionMap.get("saveAll")); // NOI18N
        saveAllMenuItem.setIcon(resourceMap.getIcon("saveAllMenuItem.icon")); // NOI18N
        saveAllMenuItem.setText(resourceMap.getString("saveAllMenuItem.text")); // NOI18N
        saveAllMenuItem.setName("saveAllMenuItem"); // NOI18N
        fileMenu.add(saveAllMenuItem);

        jSeparator1.setName("jSeparator1"); // NOI18N
        fileMenu.add(jSeparator1);

        exitMenuItem.setAction(actionMap.get("quitAction")); // NOI18N
        exitMenuItem.setIcon(resourceMap.getIcon("exitMenuItem.icon")); // NOI18N
        exitMenuItem.setText(resourceMap.getString("exitMenuItem.text")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setIcon(resourceMap.getIcon("aboutMenuItem.icon")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        statusPanel.setName("statusPanel"); // NOI18N

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N

        progressBar.setName("progressBar"); // NOI18N

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 428, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusAnimationLabel)
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusMessageLabel)
                    .addComponent(statusAnimationLabel)
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        setComponent(mainPanel);
        setMenuBar(menuBar);
        setStatusBar(statusPanel);
    }// </editor-fold>//GEN-END:initComponents
    private void loadData() {


        // <editor-fold defaultstate="collapsed" desc="Populate MyInfo from User">
        this.myNameTextField.setText(user.getName());
        this.myAgeTextField.setText(String.valueOf(user.getAge()));

        if (user.getSex() == User.MALE) {
            maleRadioButton.setSelected(true);
        } else {
            femaleRadioButton.setSelected(true);
        }

        this.myAddress1TextField.setText(user.getAddress());
        this.myCityTextField.setText(user.getCity());
        this.myStateTextField.setText(user.getState());
        this.myZipTextField.setText(String.valueOf(user.getZip()));
        this.myPhoneTextField.setText(user.getPhone());
        this.myInsuranceTextField.setText(user.getInsurance());
        this.myInsuranceNumberTextField.setText(Long.toString(user.getInsuranceNumber()));

        this.medicalHistoryTextArea.setText(user.getMedicalHistory());
        this.allergiesTextArea.setText(user.getAllergies());
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="Populate Doctor from User.Doctor">

        this.primaryNameTextField.setText(user.getPrimaryPhysician().getName());
        this.primaryAddressTextField.setText(user.getPrimaryPhysician().getAddress());
        this.primaryCityTextField.setText(user.getPrimaryPhysician().getCity());
        this.primaryStateTextField.setText(user.getPrimaryPhysician().getState());
        this.primaryZipTextField.setText(Integer.toString(user.getPrimaryPhysician().getZip()));
        this.primaryPhoneTextField.setText(user.getPrimaryPhysician().getPhone());
        // </editor-fold>

        //Get number of specialists
        //Update the spinner
        SpinnerNumberModel model = new SpinnerNumberModel(1, 1, user.getSpecialists().size(), 1);
        this.specialistSpinner.setModel(model);

        //load in the selected one
        loadInSelectedSpecialist(Integer.parseInt(this.specialistSpinner.getValue().toString()) - 1);
        //monitor the spinner for changes


        populateMedications();

        populateAppointments();

        try {
            childrenList.setEnabled(true);
            childrenList.setListData(((Parent) user).children);
        } catch (ClassCastException e) {
            //they're not a parent...get rid of that list
            childrenList.setEnabled(false);
        }

    }
    private void loadInSelectedSpecialist(
            int selected) {
        //load in the selected one
        Doctor specialistOn = user.getSpecialists().get(selected);
        this.specialistNameTextField.setText(specialistOn.getName());
        this.specialistAddressTextField.setText(specialistOn.getAddress());
        this.specialistCityTextField.setText(specialistOn.getCity());
        this.specialistStateTextField.setText(specialistOn.getState());
        this.specialistZipTextField.setText(Integer.toString(specialistOn.getZip()));
        this.specialistPhoneTextField.setText(specialistOn.getPhone());
        this.specialtyTextField.setText(specialistOn.getSpeciality());
    }
    @Action
    public void newAppointment() {
        if (!user.getPrimaryPhysician().getName().equals("")) {

            Vector<Doctor> myDocs = new Vector<Doctor>();
            myDocs.add(user.getPrimaryPhysician());
            myDocs.addAll(user.getSpecialists());

            Appointment newAppt = new Appointment();
            JFrame mainFrame = ETVFitApp.getApplication().getMainFrame();

            ETVFitAppointmentBox appointmentBox = new ETVFitAppointmentBox(mainFrame, true, newAppt, myDocs);
            appointmentBox.setLocationRelativeTo(mainFrame);

            ETVFitApp.getApplication().show(appointmentBox);
            if (appointmentBox.getReturnStatus() == ETVFitAppointmentBox.RET_OK) {

                this.user.appointments.add(newAppt);
                populateAppointments();

            }//Otherwise, don't add it


        } else {
            JOptionPane.showMessageDialog(new java.awt.Frame(),
                    "You must have a Primary Care Physician to add Appointments",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
    @Action
    public void newMedication() {
        if (!user.getPrimaryPhysician().getName().equals("")) {

            Vector<Doctor> myDocs = new Vector<Doctor>();
            myDocs.add(user.getPrimaryPhysician());
            myDocs.addAll(user.getSpecialists());

            Medication newMed = new Medication();
            JFrame mainFrame = ETVFitApp.getApplication().getMainFrame();

            ETVFitMedicationsBox medicationBox = new ETVFitMedicationsBox(mainFrame, true, newMed, myDocs);
            medicationBox.setLocationRelativeTo(mainFrame);

            ETVFitApp.getApplication().show(medicationBox);
            if (medicationBox.getReturnStatus() == ETVFitMedicationsBox.RET_OK) {
                this.user.medications.add(newMed);
                populateMedications();

            }//Otherwise, don't add it


        } else {
            JOptionPane.showMessageDialog(new java.awt.Frame(),
                    "You must have a Primary Care Physician to add Medications",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
    @Action
    public void nextWeek() {
        endDate.add(Calendar.DAY_OF_MONTH, 7);
        startDate.add(Calendar.DAY_OF_MONTH, 7);

        DateFormat dfm = new SimpleDateFormat("MMMM dd, yyyy");
        String niceDate = dfm.format(startDate.getTime());
        TitledBorder title = BorderFactory.createTitledBorder("The week of: " + niceDate);
        scheduleScrollPane.setBorder(title);
        populateAppointments();

    }
    private void populateAppointments() {
        scheduleTable.setModel(new DefaultTableModel(new Object[][]{
                    {"No items", "No items", "No Items", "No items", "No items", "No items", "No items"},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null}
                },
                new String[]{
                    "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
                }));
        //Populate scheduleTable from appointments for this week
        //loop through all of our appointments
        for (Appointment a : user.appointments) {
            //See if it falls within this week
            if (startDate.before(a.getDate())) {
                if (endDate.after(a.getDate())) {
                    //put it in the correct place in the table
                    int index = a.getDate().get(Calendar.DAY_OF_WEEK) - 1;
                    int i = 0;
                    while (true) {
                        try {
                            Object o = scheduleTable.getValueAt(i, index);
                            if (o == null || o.toString().equals("No items")) {
                                //Put it there
                                scheduleTable.setValueAt(a, i, index);
                                break;

                            } else {
                                i++;
                            }

                        } catch (ArrayIndexOutOfBoundsException e) {
                            //There must have been too many things in the table.
                            //Add a row
                            ((DefaultTableModel) scheduleTable.getModel()).addRow(new Vector());
                        //Keep our loop working
                        }

                    }
                }
            }
        }
        populateTodaysAppointments();
    }
    private void populateMedications() {
        currentMedicationsList.setListData(user.medications);
        this.pastMedicationsList.setListData(user.getPriorMedications());
    }
    public void populateTodaysAppointments() {
        remindersList.setModel(new DefaultListModel());

        //Populate scheduleTable from appointments for this week
        //loop through all of our appointments
        for (Appointment a : user.appointments) {
            //See if it falls within this week
            if (a.getDate().get(Calendar.DAY_OF_MONTH) == today.get(Calendar.DAY_OF_MONTH) &&
                    a.getDate().get(Calendar.YEAR) == today.get(Calendar.YEAR) &&
                    a.getDate().get(Calendar.MONTH) == today.get(Calendar.MONTH)) {
                ((DefaultListModel) remindersList.getModel()).addElement(a);
            }
        }
    }
    @Action
    public void previousWeek() {
        endDate.add(Calendar.DAY_OF_MONTH, -7);
        startDate.add(Calendar.DAY_OF_MONTH, -7);

        DateFormat dfm = new SimpleDateFormat("MMMM dd, yyyy");
        String niceDate = dfm.format(startDate.getTime());
        TitledBorder title = BorderFactory.createTitledBorder("The week of: " + niceDate);
        scheduleScrollPane.setBorder(title);
        populateAppointments();

    }
    @Action
    public void quitAction() {
        //OK, Let's dis-allow Children (who are not Parents)
        try {
            //Some bogus statement to test for Parent or not
            Parent p = ((Parent) user);
            //if that statement executed, then prompt for saving, etc.
            // Perform any other operations you might need
            // before exit.
            int n = JOptionPane.showConfirmDialog(
                    new java.awt.Frame(),
                    "Would you like to save before you exit?",
                    "Save Result of Session?",
                    JOptionPane.YES_NO_OPTION);

            if (n == JOptionPane.YES_OPTION) {
                this.app.SaveInfo(user);
            }

        } catch (ClassCastException c) {
            //If it's just a Child (User) then say so
            JOptionPane.showMessageDialog(new java.awt.Frame(),
                    "The results of this session will not be saved because you are a Child." +
                    "\nIn order to save your session results, please have your Parent log on \n" +
                    "and reenter your information through \"Child-Editing Mode.\"",
                    "Child Mode", JOptionPane.ERROR_MESSAGE);
        }

        this.getFrame().dispose();
        System.exit(0);
    }
    @Action
    public void removeChild() {
        ((Parent) user).children.remove(((Parent) user).children.get(childrenList.getSelectedIndex()));
        childrenList.setListData(((Parent) user).children);
    }
    @Action
    public void removeSpecialist() {
        if (this.user.getSpecialists().size() > 1) {
            int removeIndex = Integer.parseInt(specialistSpinner.getValue().toString());
            this.user.getSpecialists().remove(removeIndex - 1);
            System.out.println(this.user.getSpecialists().size());
            this.specialistSpinner.setValue(user.getSpecialists().size());
            loadInSelectedSpecialist(this.user.getSpecialists().size() - 1);
        } else {
            JOptionPane.showMessageDialog(new java.awt.Frame(),
                    "You must have at lease one Specialist",
                    "Invalid Remove Operation", JOptionPane.ERROR_MESSAGE);
        }

    }
    @Action
    public void returnToParentMode() {
        user = prevUser;
        prevUser =
                null;
        loadData();

    }
    @Action
    public void saveAll() {
        this.app.SaveInfo(user);

    }
    @Action
    public void SaveMyInfo() {
        for (Component o : this.personalInfoPanel.getComponents()) {
            if (!o.getClass().isInstance(new JLabel())) {
                o.setEnabled(false);
            }

        }
        this.allergiesTextArea.setEditable(false);
        this.allergiesTextArea.setEnabled(false);
        this.medicalHistoryTextArea.setEnabled(false);
        this.medicalHistoryTextArea.setEditable(false);
        this.editMyInfoButton.setEnabled(true);
        this.saveMyChangesButton.setEnabled(false);


        ///add everything back into the User
        // <editor-fold defaultstate="collapsed" desc="Populate User from MyInfo">

        user.setName(this.myNameTextField.getText());
        user.setAge(Integer.parseInt(this.myAgeTextField.getText()));

        if (maleRadioButton.isSelected() == true) {
            user.setSex(User.MALE);
        } else {
            user.setSex(User.FEMALE);
        }

        user.setAddress(this.myAddress1TextField.getText());
        user.setCity(this.myCityTextField.getText());
        user.setState(this.myStateTextField.getText());
        user.setZip(Integer.parseInt(this.myZipTextField.getText()));
        user.setPhone(this.myPhoneTextField.getText());
        user.setInsurance(this.myInsuranceTextField.getText());
        user.setInsuranceNumber(Long.parseLong(this.myInsuranceNumberTextField.getText()));

        user.setMedicalHistory(this.medicalHistoryTextArea.getText());
        user.setAllergies(this.allergiesTextArea.getText());
    // </editor-fold>


    }
    @Action
    public void savePrimaryInfo() {
        for (Component o : this.primaryPanel.getComponents()) {
            if (!o.getClass().isInstance(new JLabel())) {
                o.setEnabled(false);
            }

        }
        this.savePrimaryButton.setEnabled(false);
        this.editPrimaryButton.setEnabled(true);

        // <editor-fold defaultstate="collapsed" desc="Populate User.Doctor from Doctor">
        user.getPrimaryPhysician().setName(this.primaryNameTextField.getText());
        user.getPrimaryPhysician().setAddress(this.primaryAddressTextField.getText());
        user.getPrimaryPhysician().setCity(this.primaryCityTextField.getText());
        user.getPrimaryPhysician().setState(this.primaryStateTextField.getText());
        user.getPrimaryPhysician().setZip(Integer.parseInt(this.primaryZipTextField.getText()));
        user.getPrimaryPhysician().setPhone(this.primaryPhoneTextField.getText());
    // </editor-fold>
    }
    @Action
    public void SaveSpecialistInfo() {
        for (Component o : this.specialistPanel.getComponents()) {
            if (o.getClass().isInstance(new JTextField())) {
                o.setEnabled(false);
            }

        }
        this.saveSpecialistButton.setEnabled(false);
        this.editSpecialistButton.setEnabled(true);

        // <editor-fold defaultstate="collapsed" desc="Populate User.Specialist from Specialist">
        int selected = Integer.parseInt(this.specialistSpinner.getValue().toString()) - 1;
        Doctor specialistOn = user.getSpecialists().get(selected);
        specialistOn.setName(this.specialistNameTextField.getText());
        specialistOn.setAddress(this.specialistAddressTextField.getText());
        specialistOn.setCity(this.specialistCityTextField.getText());
        specialistOn.setState(this.specialistStateTextField.getText());
        specialistOn.setZip(Integer.parseInt(this.specialistZipTextField.getText()));
        specialistOn.setPhone(this.specialistPhoneTextField.getText());
        specialistOn.setSpeciality(this.specialtyTextField.getText());
    // </editor-fold>
    }
    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = ETVFitApp.getApplication().getMainFrame();
            aboutBox =
                    new ETVFitAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }

        ETVFitApp.getApplication().show(aboutBox);
    }
    @Action
    public void showManageUsers() {
        //get this user and its children
        Vector<User> visibleUsers = new Vector<User>();
        visibleUsers.add(user);
        try {
            visibleUsers.addAll(((Parent) user).children);
        } catch (ClassCastException e) {
            //oh well, don't add the children
        }

        ETVFitManageUsers mng = new ETVFitManageUsers(new java.awt.Frame(), true, visibleUsers);
        mng.setLocationRelativeTo(ETVFitApp.getApplication().getMainFrame());
        ETVFitApp.getApplication().show(mng);

        if (mng.getReturnStatus() == (ETVFitManageUsers.RET_OK)) {
            visibleUsers = mng.users;
        }
//Merge visibleUsers and .users vector

        for (User u : visibleUsers) {
            if (!app.dataHolder.users.contains(u)) {
                app.dataHolder.users.add(u);
            }

        }
        mng.dispose();
    }
    private void specialistSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_specialistSpinnerStateChanged
        //Check to see if it's within range
        if (Integer.parseInt(specialistSpinner.getValue().toString()) > 0 &&
                Integer.parseInt(specialistSpinner.getValue().toString()) <= user.getSpecialists().size()) {
            loadInSelectedSpecialist(Integer.parseInt(specialistSpinner.getValue().toString()) - 1);
        } else {
            specialistSpinner.setValue(1);
        }
    }//GEN-LAST:event_specialistSpinnerStateChanged
    private void stopMedicationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopMedicationButtonActionPerformed
        user.stopTaking(user.medications.get(currentMedicationsList.getSelectedIndex()));
        //update the lists
        populateMedications();
    }//GEN-LAST:event_stopMedicationButtonActionPerformed
}
