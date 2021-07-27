package capture;

import util.ConnectDB;
import util.TrainLBPH;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import org.bytedeco.javacpp.BytePointer;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imencode;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imwrite;
import org.bytedeco.opencv.global.opencv_imgproc;
import static org.bytedeco.opencv.global.opencv_imgproc.COLOR_BGRA2GRAY;
import static org.bytedeco.opencv.global.opencv_imgproc.cvtColor;
import static org.bytedeco.opencv.global.opencv_imgproc.rectangle;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Rect;
import org.bytedeco.opencv.opencv_core.RectVector;
import org.bytedeco.opencv.opencv_core.Scalar;
import org.bytedeco.opencv.opencv_core.Size;
import org.bytedeco.opencv.opencv_objdetect.CascadeClassifier;
import org.bytedeco.opencv.opencv_videoio.VideoCapture;

/**
 * Method responsible for registering the users in the database. Is a JDialog
 * that you can register a person and register data like: name, surname, phone,
 * post, and information about social network.
 */
public class RegisterFace extends javax.swing.JDialog {

    private DaemonThread myThread = null;

    //JavaCV
    VideoCapture webSource = null;
    Mat cameraImage = new Mat();
    CascadeClassifier cascade = new CascadeClassifier(RegisterFace.class.getResource("haarcascade_frontalface_alt.xml").getPath().substring(1));

    BytePointer mem = new BytePointer();
    RectVector detectedFaces = new RectVector();

    int numSamples = 25, sample = 1, idPerson;

    public static boolean faceMade = false, faceDetectionFinished = false, camOn = false, option = false, detection = false, testing = false, normalOperation = true;

    //Connection
    ConnectDB con = new ConnectDB();

    /**
     * @param parent It's the JFrame that's calling it
     * @param modal is a window that blocks access to other windows while it is
     * not clicked.
     */
    public RegisterFace(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        getIdUser();
        startCamera();

    }

    public RegisterFace() {
        initComponents();
        getIdUser();
        startCamera();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel9 = new keeptoo.KGradientPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        txtFirstName = new javax.swing.JTextField();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        txtLastName = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        counterLabel = new javax.swing.JLabel();
        saveButton = new keeptoo.KButton();
        label_photo = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtIdLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel9.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel9.setkFillBackground(false);
        kGradientPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setForeground(new java.awt.Color(170, 170, 170));
        jLabel3.setText("First Name");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel4.setForeground(new java.awt.Color(170, 170, 170));
        jLabel4.setText("Last Name");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, -1, -1));

        kGradientPanel1.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setkEndColor(new java.awt.Color(57, 114, 227));
        kGradientPanel1.setkFillBackground(false);
        kGradientPanel1.setkStartColor(new java.awt.Color(122, 227, 192));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtFirstName.setBorder(null);
        txtFirstName.setOpaque(false);
        kGradientPanel1.add(txtFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 160, 20));

        jPanel3.add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 180, 20));

        kGradientPanel2.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel2.setkEndColor(new java.awt.Color(57, 114, 227));
        kGradientPanel2.setkFillBackground(false);
        kGradientPanel2.setkStartColor(new java.awt.Color(122, 227, 192));
        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtLastName.setBorder(null);
        txtLastName.setOpaque(false);
        kGradientPanel2.add(txtLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 160, 20));

        jPanel3.add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 180, 20));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(200, 204, 208));
        jLabel13.setText("Personal Information");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        kGradientPanel9.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, 420, 140));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("After registration, capture 25 photos.");
        kGradientPanel9.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 400, 370, 30));

        counterLabel.setBackground(new java.awt.Color(255, 255, 255));
        counterLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        counterLabel.setForeground(new java.awt.Color(32, 78, 199));
        counterLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        counterLabel.setText("00/25");
        counterLabel.setOpaque(true);
        kGradientPanel9.add(counterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 430, 370, 20));

        saveButton.setText("Save");
        saveButton.setkAllowTab(false);
        saveButton.setkEndColor(new java.awt.Color(118, 195, 118));
        saveButton.setkHoverEndColor(new java.awt.Color(22, 92, 22));
        saveButton.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        saveButton.setkHoverStartColor(new java.awt.Color(80, 142, 80));
        saveButton.setkPressedColor(new java.awt.Color(28, 72, 28));
        saveButton.setkStartColor(new java.awt.Color(87, 167, 87));
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        kGradientPanel9.add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 370, 370, 30));
        saveButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        label_photo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        kGradientPanel9.add(label_photo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 360, 390));

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(100, 100, 100));
        jLabel12.setText("Register Face");
        kGradientPanel9.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel1.setBackground(new java.awt.Color(90, 68, 193));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setBackground(new java.awt.Color(90, 68, 193));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("ID Face");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 40));

        txtIdLabel.setBackground(new java.awt.Color(90, 68, 193));
        txtIdLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtIdLabel.setForeground(new java.awt.Color(255, 255, 255));
        txtIdLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtIdLabel.setText("1");
        jPanel1.add(txtIdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 40, 40));

        jButton1.setBackground(new java.awt.Color(213, 83, 83));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Filled_Circle_15px_1.png"))); // NOI18N
        jButton1.setToolTipText("Close");
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 30, 40));

        kGradientPanel9.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 410, 40));

        getContentPane().add(kGradientPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 460));

        setSize(new java.awt.Dimension(820, 460));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed

    }//GEN-LAST:event_saveButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegisterFace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterFace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterFace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterFace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RegisterFace dialog = new RegisterFace(new javax.swing.JFrame(), true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel counterLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private keeptoo.KGradientPanel kGradientPanel9;
    private javax.swing.JLabel label_photo;
    private keeptoo.KButton saveButton;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JLabel txtIdLabel;
    private javax.swing.JTextField txtLastName;
    // End of variables declaration//GEN-END:variables

    /**
     * This method reads the users registered in the database and adds the value
     * of +1, if there is no registration, that is, if there are 0 records, the
     * id will be 1.
     */
    private int getIdUser() {
        int id = 0;
        con.createConnection();
        con.executeSQL("SELECT * FROM person ORDER BY id DESC LIMIT 1");
        try {
            con.rs.first();
            txtIdLabel.setText(String.valueOf(con.rs.getInt("id")));
            id = Integer.parseInt(txtIdLabel.getText());
            id++;
            System.out.println(id);
            txtIdLabel.setText(Integer.toString(id));
        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    /**
     * This class is responsible for: displaying the image in JLabel, Detect
     * Face, and Save Images. .
     */
    class DaemonThread implements Runnable {

        protected volatile boolean runnable = false;

        @Override
        public void run() {
            synchronized (this) {
                while (runnable) {
                    try {
                        //System.out.println(option);

                        if (webSource.grab()) {
                            webSource.retrieve(cameraImage);
                            Graphics g = label_photo.getGraphics(); // show image on JLabel

                            Mat imageGray = new Mat();
                            cvtColor(cameraImage, imageGray, COLOR_BGRA2GRAY);

                            RectVector detectedFaces = new RectVector(); //face Detection

                            cascade.detectMultiScale(cameraImage, detectedFaces, 1.1, 1, 1, new Size(150, 150), new Size(500, 500));

                            long numberFaces = detectedFaces.size();
                            if (testing) {
                                numberFaces = 1;
                                normalOperation = false;
                            }

                            for (int i = 0; i < numberFaces; i++) {
                                detection = true;

                                System.out.println("for");

                                Rect faceData = null;
                                Mat face = null;
                                if (normalOperation) {
                                    // repetition to find the faces
                                    faceData = detectedFaces.get(0);
                                    rectangle(cameraImage, faceData, new Scalar(255, 255, 0, 2), 3, 0, 0);

                                    face = new Mat(imageGray, faceData);
                                    opencv_imgproc.resize(face, face, new Size(160, 160));

                                }
                                // when saveButton is clicked
                                if (saveButton.getModel().isPressed()) {
                                    // checking for inputs
                                    System.out.println("btn Clicked");

                                    if (txtFirstName.getText().equals("") || txtFirstName.getText().equals(" ") || txtLastName.getText().equals("") || txtLastName.getText().equals(" ")) {
                                        option = true;
                                        System.out.println("if");
                                        JOptionPane.showMessageDialog(null, "Empty Input Error");
                                    } else {
                                        option = false;
                                        if (sample <= numSamples) {
                                            String cropped = "src\\photos\\person." + txtIdLabel.getText() + "." + sample + ".jpg";
                                            imwrite(cropped, face);
                                            faceMade = true;
                                            counterLabel.setText(String.valueOf(sample) + "/25");
                                            sample++;
                                        }
                                        if (sample > 25) {
                                            new TrainLBPH().trainPhotos();// if the count is greater than 25, it finishes taking the photo, generates the file
                                            insertDatabase(); //insert the data in DB
                                            JOptionPane.showMessageDialog(null, "Face Saved");
                                            stopCamera(); // Stop the Camera
                                            faceDetectionFinished = true;
                                        }

                                    }
                                }
                            }
                            imencode(".bmp", cameraImage, mem);
                            Image im = ImageIO.read(new ByteArrayInputStream(mem.getStringBytes()));
                            BufferedImage buff = (BufferedImage) im;
                            try {
                                if (g.drawImage(buff, 0, 0, null)) {
                                    if (runnable == false) {
                                        System.out.println("Photo Saved");
                                        this.wait();
                                    }
                                }
                            } catch (Exception e) {
                            }
                        }

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
            System.out.println(faceDetectionFinished);
        }
    }

    /**
     * This method inserts the information into the database.
     */
    private void insertDatabase() {
        ControlPerson cod = new ControlPerson();
        ModelPerson mod = new ModelPerson();

        mod.setId(Integer.parseInt(txtIdLabel.getText()));
        mod.setFirst_name(txtFirstName.getText());
        mod.setLast_name(txtLastName.getText());
        cod.insert(mod);
    }

    /**
     * This method turns off the software connection with your web cam.
     */
    public void stopCamera() {
        myThread.runnable = false;
        webSource.release();
        dispose();
        camOn = false;
    }

    /**
     * This method connects the software to the web cam. VideoCapture(0); is the
     * default camera on your computer.
     */
    public void startCamera() {

        webSource = new VideoCapture(0);

        myThread = new DaemonThread();
        Thread t = new Thread(myThread);
        t.setDaemon(true);
        myThread.runnable = true;
        t.start();
        camOn = true;

    }

    public void btnclicked() {
        saveButton.doClick();
    }

    public void setTxtFirstName(String txt) {
        txtFirstName.setText(txt);
    }

    public void setTxtLastName(String txt) {
        txtLastName.setText(txt);
    }

}
