package interfaz;
import biblioteca.Docente;
import biblioteca.Estudiante;
import biblioteca.Libro;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JOptionPane;

public class JFrameInterfazPrincipal extends javax.swing.JFrame {
    
    public ArrayList<Libro> listaLibro = new ArrayList<>();
    public ArrayList<Estudiante> listaEstudiante = new ArrayList<>();
    public ArrayList<Docente> listaDocente = new ArrayList<>();


    public JFrameInterfazPrincipal() {
        initComponents();
        this.setTitle("Biblioteca - Universidad Andrés Bello");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        Image ico = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/icono.png"));
        this.setIconImage(ico);

        importarLibro();
        importarEstudiante();
        importarDocente();
        
    }

    public void importarLibro(){
        try {
            CsvReader leerLibro = new CsvReader("Libro.csv");
            leerLibro.readHeaders();
            while(leerLibro.readRecord()){
                String a = leerLibro.get(0);
                String b = leerLibro.get(1);
                String c = leerLibro.get(2);
                int d = Integer.parseInt(leerLibro.get(3));
                Libro lib = new Libro(a,b,c,d);
                listaLibro.add(lib);
            }
            leerLibro.close();
        } catch(FileNotFoundException e){
            e.printStackTrace();        
        } catch(IOException e){
            e.printStackTrace();
        }
    }
      public void agregarRegistroLibro(Libro lib){
        listaLibro.add(lib);
        exportarLibro(lib);
    }
    
    public void exportarLibro(Libro pl){
        String archiLib = "Libro.csv";
        boolean existe = new File(archiLib).exists();
        try {
          if(existe){
            CsvWriter wriCSV = new CsvWriter(new FileWriter(archiLib,true), ',');
                wriCSV.write(pl.getISBN());
                wriCSV.write(pl.getTitulo());
                wriCSV.write(pl.getAutor());
                wriCSV.write(pl.getCantBiblioteca()+"");
                wriCSV.endRecord();
              wriCSV.close();
            }
          } catch(IOException e){
            e.printStackTrace();
          }
    }
    
    public int buscarLibro(String pisbn){
       int largo = listaLibro.size();
       int indexLib = -1;
       for (int i=0;i<largo;i++){
           if(pisbn.equals(listaLibro.get(i).getISBN())){
               indexLib = i;
               break;
           }   
       }
       return indexLib; 
   }
    //Funcion para guardar los cambios al eliminar y al editar un libro
    public void actualizarDatosLibro(){
        String archiLib = "Libro.csv";
        boolean existe = new File(archiLib).exists();
        if(existe){
            File archiLibOb = new File(archiLib);
            archiLibOb.delete();
        }
        try {
            CsvWriter wriCSV = new CsvWriter(new FileWriter(archiLib,true), ',');
            //Datos
            wriCSV.write("ISBN");
            wriCSV.write("Titulo");
            wriCSV.write("Autor");
            wriCSV.write("Cant Biblioteca");
            wriCSV.endRecord();
            int largo = listaLibro.size();
            for (int i=0;i<largo;i++){
                Libro l = (Libro)listaLibro.get(i);
                wriCSV.write(l.getISBN());
                wriCSV.write(l.getTitulo());
                wriCSV.write(l.getAutor());
                wriCSV.write(l.getCantBiblioteca()+"");
                wriCSV.endRecord();
            }
            wriCSV.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    //ESTUDIANTE
    public void importarEstudiante(){
        try {
            CsvReader leerEstudiante = new CsvReader("Estudiante.csv");
            leerEstudiante.readHeaders();
            while(leerEstudiante.readRecord()){
                String a = leerEstudiante.get(0);
                String b = leerEstudiante.get(1);
                String c = leerEstudiante.get(2);
                String d = leerEstudiante.get(3);
                Estudiante est = new Estudiante(a,b,c,d,"");
                listaEstudiante.add(est);
            }
            leerEstudiante.close();
        } catch(FileNotFoundException e){
            e.printStackTrace();        
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    //Agrega estudiante desde la pantalla DIALOG
    public void agregarRegistroEstudiante(Estudiante est){
        listaEstudiante.add(est);
        exportarEstudiante(est);
    }
    
    public void exportarEstudiante(Estudiante est){
        String archiEst = "Estudiante.csv";
        boolean existe = new File(archiEst).exists();
        try {
          if(existe){
            CsvWriter wriCSV = new CsvWriter(new FileWriter(archiEst,true), ',');
                wriCSV.write(est.getNombre());
                wriCSV.write(est.getRut());
                wriCSV.write(est.getGenero());
                wriCSV.write(est.getCarrera()+"");
                wriCSV.endRecord();
                wriCSV.close();
            }
          } catch(IOException e){
            e.printStackTrace();
          }
    }
    
    public int buscarEstudiante(String prut){
       int largo = listaEstudiante.size();
       int indexEst = -1;
       for (int i=0;i<largo;i++){
           if(prut.equals(listaEstudiante.get(i).getRut())){
               indexEst = i;
               break;
           }   
       }
       return indexEst; 
    }
    //Funcion para guardar los cambios al eliminar y al editar un usuario Estudiante
    public void actualizarDatosEstudiante(){
        String archiEst = "Estudiante.csv";
        boolean existe = new File(archiEst).exists();
        if(existe){
            File archiEstOb = new File(archiEst);
            archiEstOb.delete();
        }
        try {
            CsvWriter wriCSV = new CsvWriter(new FileWriter(archiEst,true), ',');
            //Datos
            wriCSV.write("Nombre");
            wriCSV.write("Rut");
            wriCSV.write("Género");
            wriCSV.write("Carrera");
            wriCSV.endRecord();
            int largo = listaEstudiante.size();
            for (int i=0;i<largo;i++){
                Estudiante e = (Estudiante)listaEstudiante.get(i);
                wriCSV.write(e.getNombre());
                wriCSV.write(e.getRut());
                wriCSV.write(e.getGenero());
                wriCSV.write(e.getCarrera());
                 wriCSV.write(e.getPrestamo()+"");
                wriCSV.endRecord();
            }
            wriCSV.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    //DOCENTE
    public void importarDocente(){
        try {
            CsvReader leerDocente = new CsvReader("Docente.csv");
            leerDocente.readHeaders();
            while(leerDocente.readRecord()){
                String a = leerDocente.get(0);
                String b = leerDocente.get(1);
                String c = leerDocente.get(2);
                String d = leerDocente.get(3);
                //String e = leerDocente.get(4);
                String f = leerDocente.get(5);
                String g = leerDocente.get(6);
                Docente doc = new Docente(a,b,c,d,"",f,g);
                listaDocente.add(doc);
            }
            leerDocente.close();
        } catch(FileNotFoundException e){
            e.printStackTrace();        
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    //Agrega docente desde la pantalla DIALOG
    public void agregarRegistroDocente(Docente doc){
        listaDocente.add(doc);
        exportarDocente(doc);
    }
    
    public void exportarDocente(Docente doc){
        String archiDoc = "Docente.csv";
        boolean existe = new File(archiDoc).exists();
        try {
          if(existe){
            CsvWriter wriCSV = new CsvWriter(new FileWriter(archiDoc,true), ',');
                wriCSV.write(doc.getNombre());
                wriCSV.write(doc.getRut());
                wriCSV.write(doc.getGenero());
                wriCSV.write(doc.getCarrera());
                wriCSV.write(doc.getPrestamo());
                wriCSV.write(doc.getProfesion());
                wriCSV.write(doc.getGrado()+"");
                wriCSV.endRecord();
                wriCSV.close();
            }
          } catch(IOException e){
            e.printStackTrace();
          }
    }
    
    public int buscarDocente(String pdoc){
       int largo = listaDocente.size();
       int indexDoc = -1;
       for (int i=0;i<largo;i++){
           if(pdoc.equals(listaDocente.get(i).getRut())){
               indexDoc = i;
               break;
           }   
           
           
       }
       return indexDoc; 
   }
    //Funcion para guardar los cambios al eliminar y al editar un usuario Docente
    public void actualizarDatosDocente(){
        String archiDoc = "Docente.csv";
        boolean existe = new File(archiDoc).exists();
        if(existe){
            File archiDocOb = new File(archiDoc);
            archiDocOb.delete();
        }
        try {
            CsvWriter wriCSV = new CsvWriter(new FileWriter(archiDoc,true), ',');
            //Datos
            wriCSV.write("Nombre");
            wriCSV.write("Rut");
            wriCSV.write("Género");
            wriCSV.write("Carrera");
            wriCSV.write("Profesión");
            wriCSV.write("Grado");
            wriCSV.endRecord();
            int largo = listaDocente.size();
            for (int i=0;i<largo;i++){
                Docente d = (Docente)listaDocente.get(i);
                wriCSV.write(d.getNombre());
                wriCSV.write(d.getRut());
                wriCSV.write(d.getGenero());
                wriCSV.write(d.getCarrera());
                wriCSV.write(d.getPrestamo());
                wriCSV.write(d.getProfesion()); 
                wriCSV.write(d.getGrado()+"");
                wriCSV.endRecord();
            }
            wriCSV.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        label1 = new java.awt.Label();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setFont(new java.awt.Font("Ubuntu Light", 0, 12)); // NOI18N
        jButton1.setText("Generar Préstamo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Ubuntu Light", 0, 12)); // NOI18N
        jButton4.setText("Registrar Libro");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Ubuntu Light", 0, 12)); // NOI18N
        jButton6.setText("Generar Devolución");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Ubuntu Light", 0, 12)); // NOI18N
        jButton7.setText("Registrar Usuario");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Logo.png"))); // NOI18N
        jLabel1.setAlignmentY(0.0F);
        jLabel1.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jButton9.setFont(new java.awt.Font("Ubuntu Light", 0, 12)); // NOI18N
        jButton9.setText("Editar Usuario");
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton9MouseClicked(evt);
            }
        });
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Ubuntu Light", 0, 12)); // NOI18N
        jButton10.setText("Eliminar Usuario");
        jButton10.setToolTipText("");
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton10MouseClicked(evt);
            }
        });
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Ubuntu Light", 0, 12)); // NOI18N
        jButton5.setText("Eliminar Libro");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Ubuntu Light", 0, 12)); // NOI18N
        jButton8.setText("Más Información");
        jButton8.setActionCommand("Eliminar Libro");
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        label1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        label1.setEnabled(false);
        label1.setFont(new java.awt.Font("Serif", 2, 12)); // NOI18N
        label1.setText("Universidad Andrés Bello, 2019.");

        jButton2.setFont(new java.awt.Font("Ubuntu Light", 0, 12)); // NOI18N
        jButton2.setText("Registro de Usuarios");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Ubuntu Light", 0, 12)); // NOI18N
        jButton3.setText("Registro de Libros");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                            .addComponent(jButton9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton9))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(jButton2))
                .addGap(22, 22, 22)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String[] a = { "Docente", "Estudiante"};
        int o = JOptionPane.showOptionDialog(null, 
                "Seleccione el tipo de usuario", "Acceso a Préstamo",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, a, a[0]);
        
       
        if (o == 0){
            JFramePrestamoDocente prestamo = new JFramePrestamoDocente(this);
            prestamo.setVisible(true);   
            
        }
        else if (o == 1) {
            JFramePrestamoEstudiante est = new JFramePrestamoEstudiante(this);
            est.setVisible(true);
        }    
        
        else {
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        JDialogAñadirLibro w = new JDialogAñadirLibro(this,true);
        w.setVisible(true);      
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        String[] a = {"Docente", "Estudiante"};
        int o = JOptionPane.showOptionDialog(null, "Seleccione el tipo de usuario", "Acceso a Registro", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, a, a[0]);
        if (o == 0){
            JDialogDocente doc = new JDialogDocente(this, true);
            doc.setVisible(true);
        }
        else if (o == 1){
            JDialogEstudiante est = new JDialogEstudiante(this, true);
            est.setVisible(true);
        }        
        else{
            
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
          String[] a = { "Docente", "Estudiante"};
        int o = JOptionPane.showOptionDialog(null, 
                "Seleccione el tipo de usuario", "Acceso a Devolución",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, a, a[0]);
        
       
        if (o == 0){
            JDialogDevolucionDocente dc = new JDialogDevolucionDocente(this, true);
            dc.setVisible(true);   
            
        }
        else if (o == 1) {
            JDialogDevolucionEstudiante est = new JDialogDevolucionEstudiante(this, true);
            est.setVisible(true);
        }    
        
        else {
            
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        String[] a = {"Docente", "Estudiante"};
        int o = JOptionPane.showOptionDialog(null, "Seleccione el tipo de usuario", "Acceso a Editar", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, a, a[0]);
        if (o == 0){
            JDialogEditarDocente ed = new JDialogEditarDocente(this,true);
            ed.setVisible(true);
        }
        else if (o == 1){
            JDialogEditarEstudiante es = new JDialogEditarEstudiante(this,true);
            es.setVisible(true);
        }
        else{
            
        }
        
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        String[] a = {"Docente", "Estudiante"};
        int o = JOptionPane.showOptionDialog(null, "Seleccione el tipo de usuario", "Acceso a Eliminar", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, a, a[0]);
        if (o == 0){
            JDialogEliminarDocente ed = new JDialogEliminarDocente(this,true);
            ed.setVisible(true);
        }
        else if (o == 1){
            JDialogEliminarEstudiante ee = new JDialogEliminarEstudiante(this,true);
            ee.setVisible(true);
        }
        else{
            
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        JDialogEliminarLibro eliminarlibro = new JDialogEliminarLibro(this,true);
        eliminarlibro.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

  
        



        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked

    }//GEN-LAST:event_jButton7MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked

    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseClicked
       
    }//GEN-LAST:event_jButton9MouseClicked

    private void jButton10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseClicked
        
    }//GEN-LAST:event_jButton10MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
        JFrameInformacion mas = new JFrameInformacion();
        mas.setVisible(true);
    }//GEN-LAST:event_jButton8MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JFrameRegistroUsuario rg = new JFrameRegistroUsuario(listaEstudiante,listaDocente);
        rg.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        JFrameRegistroLibro rl = new JFrameRegistroLibro(listaLibro);
        rl.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameInterfazPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}
