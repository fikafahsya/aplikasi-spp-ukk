/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukk_spp;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author HP
 */
public class form_pembayaran extends javax.swing.JFrame {
    Connection con;
    DefaultTableModel tm;
    String idpembayaran;
    
    public void connect() {
        con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/db_spp1", "root", "");
        } catch (Exception e) {
            System.out.print("EROR KUERI KE DATABASE:\n" + e + "\n\n");
            
        }
    }
    
    private void refreshTable(){
        tm = new DefaultTableModel(null, new Object[] {"No", "Nama Petugas", "NISN", "Nama Siswa", "Tanggal Bayar", "Bulan Bayar", "Tarif SPP", "Jumlah Bayar"});
        tbPembayaran.setModel(tm);
        tbPembayaran.removeColumn(tbPembayaran.getColumnModel().getColumn(0));
        tm.getDataVector().removeAllElements();
        try{
            PreparedStatement s = con.prepareStatement("SELECT pembayaran.id_pembayaran, user.nama_user, pembayaran.nisn, siswa.nama, pembayaran.tgl_bayar, pembayaran.bulan_bayar, spp.nominal, pembayaran.jumlah_dibayar FROM pembayaran INNER JOIN siswa USING(nisn) INNER JOIN spp on siswa.id_spp = spp.id_spp INNER JOIN user on pembayaran.id_user = user.id_user");
            ResultSet r = s.executeQuery();
            while(r.next()){
                Object[] data ={
                    r.getString(1),
                    r.getString(2),
                    r.getString(3),
                    r.getString(4),
                    r.getString(5),
                    r.getString(6),
                    r.getString(7),
                    r.getString(8)
                        
                };
                tm.addRow(data);
                }
            }catch(Exception e){
                System.out.print("ERROR QUERY KE DATABSE:\n"+e+"\n\n");          
        }
    }
    
    public void cbidpetugas(){
        try {
            PreparedStatement s = con.prepareStatement("SELECT * FROM user WHERE  level='admin' or level='petugas'");
            ResultSet r = s.executeQuery();
                while (r.next()) {
                    cbIduser.addItem(r.getString("nama_user"));
                }
        }catch(Exception e){           
        }
    }
    
    public void cbnisn(){
        try {
            PreparedStatement s = con.prepareStatement("SELECT * FROM siswa");
            ResultSet r = s.executeQuery();
                while (r.next()) {
                    cbNisn.addItem(r.getString("nisn"));
                }
        }catch(Exception e){           
        }
    }
    
    public void cbidspp(){
        try {
            PreparedStatement s = con.prepareStatement("SELECT * FROM spp");
            ResultSet r = s.executeQuery();
                while (r.next()) {
                    cbTarif.addItem(r.getString("nominal"));
                }
        }catch(Exception e){           
        }
    }
    

    /**
     * Creates new form form_pembayaran
     */
    public form_pembayaran() {
        initComponents();
        connect();
        cbidpetugas();
        cbnisn();
        cbidspp();
        refreshTable();
        txtIdpetugas.hide();
        txtTarif.hide();
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
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbIduser = new javax.swing.JComboBox<>();
        txtJmlbayar = new javax.swing.JTextField();
        cbNisn = new javax.swing.JComboBox<>();
        jTgl = new com.toedter.calendar.JDateChooser();
        btnTambah = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        txtIdpetugas = new javax.swing.JTextField();
        txtTarif = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNamasiswa = new javax.swing.JTextField();
        cbTarif = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cbBulan = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPembayaran = new javax.swing.JTable();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153)));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("FORM PEMBAYARAN");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ukk_spp/uang (2).png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel3)))
                .addGap(19, 19, 19))
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("NAMA PETUGAS");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("NISN");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("TGL BAYAR");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Tarif SPP");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("JUMLAH BAYAR");

        cbIduser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-pilih  petugas-" }));
        cbIduser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbIduserActionPerformed(evt);
            }
        });
        cbIduser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbIduserKeyPressed(evt);
            }
        });

        txtJmlbayar.setEditable(false);

        cbNisn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-pilih nisn-" }));
        cbNisn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNisnActionPerformed(evt);
            }
        });
        cbNisn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbNisnKeyPressed(evt);
            }
        });

        btnTambah.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add-removebg-preview (2).png"))); // NOI18N
        btnTambah.setText("SAVE");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ukk_spp/edit (2).png"))); // NOI18N
        btnEdit.setText("EDIT");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnHapus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ukk_spp/hapus-removebg-preview (1).png"))); // NOI18N
        btnHapus.setText("DELETE");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        txtIdpetugas.setEditable(false);

        txtTarif.setEditable(false);
        txtTarif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTarifActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("NAMA SISWA");

        cbTarif.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-pilih tarif-" }));
        cbTarif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTarifActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Bulan Bayar");

        cbBulan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(jLabel1)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnTambah)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9)
                                .addComponent(jLabel10)))
                        .addGap(2, 2, 2)))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNamasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtJmlbayar, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTgl, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbNisn, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbIduser, 0, 181, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIdpetugas, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cbBulan, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbTarif, javax.swing.GroupLayout.Alignment.LEADING, 0, 134, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTarif, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 74, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(38, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbIduser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtIdpetugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbNisn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNamasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jTgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbBulan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbTarif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTarif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtJmlbayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153)));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("cari berdasarkan nama siswa");

        btnCari.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ukk_spp/cari__1_-removebg-preview.png"))); // NOI18N
        btnCari.setText("SEARCH");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        tbPembayaran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "", "", "", "", "", ""
            }
        ));
        tbPembayaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPembayaranMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbPembayaran);

        btnExit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ukk_spp/exit-removebg-preview (2).png"))); // NOI18N
        btnExit.setText("EXIT");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(btnCari)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCari)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        if ( cbIduser.getSelectedItem().equals("") || cbNisn.getSelectedItem().equals("") || txtNamasiswa.getText().equals("") || cbBulan.getSelectedItem().equals("") || txtTarif.getText().equals("") || txtJmlbayar.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Data harus terisi semua!");
        }else {
            
        
        String tampilTanggal="yyyy-MM-dd";
        SimpleDateFormat df =new SimpleDateFormat(tampilTanggal);
        String tglbayar=String.valueOf(df.format(jTgl.getDate()));
        
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE pembayaran SET id_user=?, nisn=?, tgl_bayar=?, bulan_bayar=?, id_spp=?, jumlah_dibayar=? WHERE id_pembayaran=?");
            ps.setString(1, txtIdpetugas.getText());
            ps.setString(2, cbNisn.getSelectedItem().toString());
            ps.setString(3, tglbayar);
            ps.setString(4, cbBulan.getSelectedItem().toString());
            ps.setString(5, txtTarif.getText());
            ps.setString(6, txtJmlbayar.getText());
            ps.setString(7, idpembayaran);
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data telah di update");
            refreshTable();
            cbIduser.setSelectedItem("");
            cbNisn.setSelectedItem("");
            jTgl.setDate(Date.valueOf(""));
            cbBulan.setSelectedItem("");
            txtTarif.setText("");
            txtJmlbayar.setText("");
        } catch (Exception e) {
            System.out.print("EROR KUERI KE DATABASE:\n" + e + "\n\n");
        }
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void cbIduserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbIduserActionPerformed
        // TODO add your handling code here:
         try {
            PreparedStatement s = con.prepareStatement("SELECT * FROM user WHERE nama_user='"+ cbIduser.getSelectedItem().toString() +"'");
            ResultSet r = s.executeQuery();
                while (r.next()) {
                    txtIdpetugas.setText(r.getString("id_user"));
                }
        }catch(Exception e){           
        }
    }//GEN-LAST:event_cbIduserActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        if (cbIduser.getSelectedItem().equals("") || cbNisn.getSelectedItem().equals("") || txtNamasiswa.getText().equals("") || cbBulan.getSelectedItem().equals("") || txtTarif.getText().equals("") || txtJmlbayar.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Data harus terisi semua!");
        }else {
        
        String tampilTanggal="yyyy-MM-dd";
        SimpleDateFormat df =new SimpleDateFormat(tampilTanggal);
        String tglbayar=String.valueOf(df.format(jTgl.getDate()));
        
        
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO pembayaran VALUES (?,?,?,?,?,?,?)");
            ps.setInt(1, 0);
            ps.setString(2, txtIdpetugas.getText());
            ps.setString(3, cbNisn.getSelectedItem().toString());
            ps.setString(4, tglbayar);
            ps.setString(5, cbBulan.getSelectedItem().toString());
            ps.setString(6, txtTarif.getText());
            ps.setString(7, txtJmlbayar.getText());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data telah tersimpan");
            refreshTable();
            cbIduser.setSelectedItem("");
            cbNisn.setSelectedItem("");
            jTgl.setDate(Date.valueOf(""));
            cbBulan.setSelectedItem("");
            txtTarif.setText("");
            txtJmlbayar.setText("");
        } catch (Exception e) {
            System.out.print("EROR KUERI KE DATABASE:\n" + e + "\n\n");
        }
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        String tampilTanggal="yyyy-MM-dd";
        SimpleDateFormat df =new SimpleDateFormat(tampilTanggal);
        String tglbayar=String.valueOf(df.format(jTgl.getDate()));
        
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM pembayaran WHERE id_pembayaran=?");
            ps.setString(1, idpembayaran);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data telah di hapus");
            refreshTable();
            cbIduser.setSelectedItem("");
            cbNisn.setSelectedItem("");
            jTgl.setDate(Date.valueOf(""));
            cbBulan.setSelectedItem("");
            txtTarif.setText("");
            txtJmlbayar.setText("");
        } catch (Exception e) {
            System.out.print("EROR KUERI KE DATABASE:\n" + e + "\n\n");
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        dispose();
        login ad=new login();
        ad.show();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        tm = new DefaultTableModel(null, new Object[] {"No", "Nama Petugas", "NISN", "Nama Siswa", "Tanggal Bayar", "Bulan Bayar", "Tarif SPP", "Jumlah Bayar"});
        tbPembayaran.setModel(tm);
        tbPembayaran.removeColumn(tbPembayaran.getColumnModel().getColumn(0));
        tm.getDataVector().removeAllElements();
        try {
            PreparedStatement s = con.prepareStatement("SELECT pembayaran.id_pembayaran, user.nama_user, pembayaran.nisn, siswa.nama, pembayaran.tgl_bayar, pembayaran.bulan_bayar, spp.nominal, pembayaran.jumlah_dibayar FROM pembayaran INNER JOIN siswa USING(nisn) INNER JOIN spp on siswa.id_spp = spp.id_spp INNER JOIN user on pembayaran.id_user = user.id_user WHERE nama LIKE '%" + txtCari.getText().toString() +"%'");
            ResultSet r = s.executeQuery();
            while(r.next()) {
                Object[] data ={
                    r.getString(1),
                    r.getString(2),
                    r.getString(3),
                    r.getString(4),
                    r.getString(5),
                    r.getString(6),
                    r.getString(7),
                    r.getString(8)
                };
                tm.addRow(data);
            }
        } catch(Exception e) {
            System.out.print("ERROR KUERI KE DATABASE:\n" + e + "\n\n");
        }
    }//GEN-LAST:event_btnCariActionPerformed

    private void tbPembayaranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPembayaranMouseClicked
        // TODO add your handling code here:
        int i = tbPembayaran.getSelectedRow();
        if (i == -1) {
            //tidak ada baris terseleksi
            return;

        }

        String idbayar = (String) tm.getValueAt(i, 0);
        idpembayaran=idbayar;

        String idpetugas = (String) tm.getValueAt(i, 1);
        cbIduser.setSelectedItem(idpetugas);

        String nisn = (String) tm.getValueAt(i, 2);
        cbNisn.setSelectedItem(nisn);
        
        String siswa = (String) tm.getValueAt(i, 3);
        txtNamasiswa.setText(siswa);
        
        String tglbayar = (String) tm.getValueAt(i, 4);
        jTgl.setDate(Date.valueOf(tglbayar));
        
        String bulan = (String) tm.getValueAt(i, 5);
        cbBulan.setSelectedItem(bulan);
        
        String idspp = (String) tm.getValueAt(i, 6);
        cbTarif.setSelectedItem(idspp);
        
        String jmlbayar = (String) tm.getValueAt(i, 7);
        txtJmlbayar.setText(jmlbayar);
    }//GEN-LAST:event_tbPembayaranMouseClicked

    private void cbIduserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbIduserKeyPressed
        // TODO add your handling code here
    }//GEN-LAST:event_cbIduserKeyPressed

    private void cbNisnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbNisnKeyPressed
        // TODO add your handling code here:
         
    }//GEN-LAST:event_cbNisnKeyPressed

    private void txtTarifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTarifActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTarifActionPerformed

    private void cbNisnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNisnActionPerformed
        // TODO add your handling code here:
         try {
            PreparedStatement s = con.prepareStatement("SELECT * FROM siswa WHERE nisn='"+ cbNisn.getSelectedItem().toString() +"'");
            ResultSet r = s.executeQuery();
                while (r.next()) {
                    txtNamasiswa.setText(r.getString("nama"));
                }
        }catch(Exception e){           
        }
    }//GEN-LAST:event_cbNisnActionPerformed

    private void cbTarifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTarifActionPerformed
        // TODO add your handling code here:
         try {
            PreparedStatement s = con.prepareStatement("SELECT * FROM spp WHERE nominal='"+ cbTarif.getSelectedItem().toString() +"'");
            ResultSet r = s.executeQuery();
                while (r.next()) {
                    txtTarif.setText(r.getString("id_spp"));
                    txtJmlbayar.setText(r.getString("nominal"));
                }
        }catch(Exception e){           
        }
    }//GEN-LAST:event_cbTarifActionPerformed

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
            java.util.logging.Logger.getLogger(form_pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_pembayaran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> cbBulan;
    private javax.swing.JComboBox<String> cbIduser;
    private javax.swing.JComboBox<String> cbNisn;
    private javax.swing.JComboBox<String> cbTarif;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private com.toedter.calendar.JDateChooser jTgl;
    private javax.swing.JTable tbPembayaran;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtIdpetugas;
    private javax.swing.JTextField txtJmlbayar;
    private javax.swing.JTextField txtNamasiswa;
    private javax.swing.JTextField txtTarif;
    // End of variables declaration//GEN-END:variables
}