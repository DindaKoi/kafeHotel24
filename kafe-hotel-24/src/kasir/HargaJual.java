/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasir;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Sadindiiw!
 */
public class HargaJual extends javax.swing.JFrame {

    public Statement st;
    public PreparedStatement ps;
    public ResultSet rs;
    Connection conn = koneksi.koneksi.getCon();
    public HargaJual() {
        initComponents();
        showData();
        reset();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void showData(){
        DefaultTableModel model = (DefaultTableModel)tbl_jual.getModel();
        model.setRowCount(0);
        try{
            String sql = "SELECT * FROM harga";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()){
                String menu = rs.getString("menu");
                String itm1 = rs.getString("item1");
                String itm2 = rs.getString("item2");
                String itm3 = rs.getString("item3");
                String itm4 = rs.getString("item4");
                String totalHarga = rs.getString("total_harga");
                String hargaJual = rs.getString("harga_jual");
                NumberFormat kursIndo = NumberFormat.getIntegerInstance(new Locale("id",
                "ID"));
                
                Object[] Rowdata = {menu, itm1, itm2,itm3,itm4,kursIndo.format(totalHarga),kursIndo.format(hargaJual)};
                model.addRow(Rowdata);
            }
        }catch (Exception e){
            
        }
    }
    
    private void reset(){
        txt_menu.setText("");
        txt_item1.setText("");
        txt_item2.setText("");
        txt_item3.setText("");
        txt_item4.setText("");
        txt_totalbiaya.setText("");
        txt_hargajual.setText("");

        btn_simpan.setText("Simpan");

    }
    
    private void formatRupiah(){
        if(!txt_hargajual.getText().equals("")){
            String repl = txt_hargajual.getText().replaceAll("[^\\d]", "");
            double formatRP = Double.parseDouble(repl);
            DecimalFormat dcf = new DecimalFormat("#,###,###");
            txt_hargajual.setText(dcf.format(formatRP));
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btn_menu = new javax.swing.JButton();
        txt_menu = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_item1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_item2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_item3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_item4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_totalbiaya = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_hargajual = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btn_hapus = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        btn_simpan = new javax.swing.JButton();
        harga_itm1 = new javax.swing.JTextField();
        harga_itm2 = new javax.swing.JTextField();
        harga_itm3 = new javax.swing.JTextField();
        harga_itm4 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_jual = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(99, 68, 18));

        jPanel2.setBackground(new java.awt.Color(163, 133, 99));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Harga Jual Menu - Kitchen Page");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(163, 133, 99));

        btn_menu.setBackground(new java.awt.Color(0, 204, 0));
        btn_menu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_menu.setForeground(new java.awt.Color(255, 255, 255));
        btn_menu.setText("Pilih Menu");
        btn_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_menuMouseClicked(evt);
            }
        });
        btn_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_menuActionPerformed(evt);
            }
        });

        txt_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_menuActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Nama Menu");

        txt_item1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_item1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Item 1");

        txt_item2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_item2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Item 2");

        txt_item3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_item3ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Item 3");

        txt_item4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_item4ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Item 4");

        txt_totalbiaya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalbiayaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Total Biaya");

        txt_hargajual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hargajualActionPerformed(evt);
            }
        });
        txt_hargajual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_hargajualKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Harga Jual");

        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_reset.setText("reset");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        btn_simpan.setBackground(new java.awt.Color(153, 204, 0));
        btn_simpan.setText("simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        harga_itm1.setBackground(new java.awt.Color(255, 204, 0));
        harga_itm1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        harga_itm1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        harga_itm2.setBackground(new java.awt.Color(255, 204, 0));
        harga_itm2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        harga_itm2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        harga_itm3.setBackground(new java.awt.Color(255, 204, 0));
        harga_itm3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        harga_itm3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        harga_itm4.setBackground(new java.awt.Color(255, 204, 0));
        harga_itm4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        harga_itm4.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("=");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("=");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("=");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("=");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_totalbiaya, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(38, 38, 38)
                        .addComponent(txt_item3, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_item4, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_item2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(38, 38, 38)
                                    .addComponent(txt_item1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(38, 38, 38)
                                    .addComponent(txt_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btn_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(331, 331, 331))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_hargajual, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel9)
                                .addComponent(jLabel10))
                            .addComponent(jLabel11)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(harga_itm1)
                            .addComponent(harga_itm2)
                            .addComponent(harga_itm3)
                            .addComponent(harga_itm4, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))))
                .addGap(267, 267, 267))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_item1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(harga_itm1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_item2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(harga_itm2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_item3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(harga_itm3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_item4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(harga_itm4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_totalbiaya, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_hargajual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_hapus)
                    .addComponent(btn_reset)
                    .addComponent(btn_simpan))
                .addContainerGap())
        );

        tbl_jual.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Menu", "Item 1", "Item 2", "Item 3", "Item 4", "Total Harga", "Harga Jual"
            }
        ));
        tbl_jual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_jualMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_jual);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 639, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_menuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_menuActionPerformed

    private void txt_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_menuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_menuActionPerformed

    private void txt_item1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_item1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_item1ActionPerformed

    private void txt_item2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_item2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_item2ActionPerformed

    private void txt_item3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_item3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_item3ActionPerformed

    private void txt_item4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_item4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_item4ActionPerformed

    private void txt_totalbiayaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalbiayaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalbiayaActionPerformed

    private void txt_hargajualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hargajualActionPerformed
    }//GEN-LAST:event_txt_hargajualActionPerformed

    private void txt_hargajualKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_hargajualKeyReleased
       formatRupiah();
    }//GEN-LAST:event_txt_hargajualKeyReleased

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        try{
           if(txt_menu.getText().equals("")|| txt_menu.getText().equals("")){
               JOptionPane.showMessageDialog(null, "Silahkan pilih data yang tersedia"
               , "Validasi", JOptionPane.INFORMATION_MESSAGE);
           }else{
               int konfir = JOptionPane.showConfirmDialog(null, "Anda yakin akan menghapus data?",
                       "Hapus Menu", JOptionPane.YES_NO_OPTION);
               if(konfir==0){
                   int selectedRow = tbl_jual.getSelectedRow();
                   String id = tbl_jual.getValueAt(selectedRow, 0).toString();
                   String sql = "DELETE FROM harga WHERE menu=?";
                   ps = conn.prepareStatement(sql);
                   ps.setString(1, id);
                   ps.executeUpdate();
                   showData();
                   reset();
               }else{
                   reset();
               }
           }    
       }catch (Exception e){
           
       }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void tbl_jualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_jualMouseClicked
        DefaultTableModel model = (DefaultTableModel)tbl_jual.getModel();
        int selectedRow = tbl_jual.getSelectedRow();
        
        txt_menu.setText(model.getValueAt(selectedRow, 1).toString());
        txt_item1.setText(model.getValueAt(selectedRow, 2).toString());
        txt_item2.setText(model.getValueAt(selectedRow, 3).toString());
        txt_item3.setText(model.getValueAt(selectedRow, 4).toString());
        txt_item4.setText(model.getValueAt(selectedRow, 5).toString());
        txt_totalbiaya.setText(model.getValueAt(selectedRow, 6).toString());
        txt_hargajual.setText(model.getValueAt(selectedRow, 7).toString());
        
        btn_simpan.setText("update");
        formatRupiah();
    }//GEN-LAST:event_tbl_jualMouseClicked

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        if(txt_menu.getText().equals("")||txt_hargajual.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Data yang dimasukkan belum lengkap", "Validasi",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            st = conn.createStatement();
            if(btn_simpan.getText()== "Simpan"){
                String find = "SELECT * FROM harga WHERE menu='" + txt_menu.getText() +
                        "' ";
                rs = st.executeQuery(find);
                if(rs.next()){
                    JOptionPane.showMessageDialog(null, "Menu sudah ada, masukkan menu lain", "Validasi",
                    JOptionPane.WARNING_MESSAGE);
                }else{
                    String menu = txt_menu.getText();
                    String itm1 = txt_item1.getText();
                    String itm2 = txt_item2.getText();
                    String itm3 = txt_item3.getText();
                    String itm4 = txt_item4.getText();
                    String totalbiaya = txt_totalbiaya.getText();
                    String hargajual = txt_hargajual.getText();
                    String ReplaceHarga = hargajual.replaceAll(",", "");
                    
                    String sql = "INSERT INTO harga (menu,item1,item2,item3,item4,total_harga,"
                            + "harga_jual)VALUES (?,?,?,?,?,?,?)";
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, menu);
                    ps.setString(2, itm1);
                    ps.setString(3, itm2);
                    ps.setString(4, itm3);
                    ps.setString(5, itm4);
                    ps.setString(6, totalbiaya);
                    ps.setString(7, ReplaceHarga);
                    
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Menu berhasil update!", "Input Menu",
                    JOptionPane.INFORMATION_MESSAGE);
                    showData();
                    reset();
                }
            } else {
                int selectedRow = tbl_jual.getSelectedRow();
                String id = tbl_jual.getValueAt(selectedRow, 0).toString();
                String menu = txt_menu.getText();
                String itm1 = txt_item1.getText();
                String itm2 = txt_item2.getText();
                String itm3 = txt_item3.getText();
                String itm4 = txt_item4.getText();
                String totalbiaya = txt_totalbiaya.getText(); 
                String hargajual = txt_hargajual.getText();
                String ReplaceHarga = hargajual.replaceAll(",", "");
                
                String sql = "UPDATE harga SET item1=?, item2=?, item3=?,"
                        + "item4=?, total_harga=?, harga_jual=? WHERE menu=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, menu);
                ps.setString(2, itm1);
                ps.setString(3, itm2);
                ps.setString(4, itm3);
                ps.setString(5, itm4);
                ps.setString(6, totalbiaya);
                ps.setString(7, ReplaceHarga);
                ps.setString(8, id);
                
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil di Update", "input data",
                        JOptionPane.INFORMATION_MESSAGE);
                showData();
                reset();
            }
        } catch (Exception e){
            
        }
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        reset();
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_menuMouseClicked
        try {
        String query = "SELECT menu FROM harga";
        ps = conn.prepareStatement(query);
        rs = ps.executeQuery();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nama Menu");
        while (rs.next()) {
            model.addRow(new Object[]{rs.getString("menu")});
        }

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        JOptionPane.showMessageDialog(null, scrollPane, "Pilih Menu", JOptionPane.PLAIN_MESSAGE);
        int row = table.getSelectedRow();
                if (row != -1) {
                    String selectedMenu = table.getValueAt(row, 1).toString(); 
                    txt_menu.setText(selectedMenu);
                }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Gagal mengambil data: " + e.getMessage());
    }
    }//GEN-LAST:event_btn_menuMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        home.kitchen ktc = new home.kitchen();
        ktc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(HargaJual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HargaJual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HargaJual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HargaJual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HargaJual().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_menu;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JTextField harga_itm1;
    private javax.swing.JTextField harga_itm2;
    private javax.swing.JTextField harga_itm3;
    private javax.swing.JTextField harga_itm4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_jual;
    private javax.swing.JTextField txt_hargajual;
    private javax.swing.JTextField txt_item1;
    private javax.swing.JTextField txt_item2;
    private javax.swing.JTextField txt_item3;
    private javax.swing.JTextField txt_item4;
    private javax.swing.JTextField txt_menu;
    private javax.swing.JTextField txt_totalbiaya;
    // End of variables declaration//GEN-END:variables
}
