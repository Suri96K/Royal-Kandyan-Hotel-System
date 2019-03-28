/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package IT17029896;


import hotelsystem.Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Shehan
 */
public class Reservation1 extends javax.swing.JFrame 
{

    /**
     * Creates new form Reservation
     */
    
    private Connection connection = null;
    private Statement statement = null;
    private Statement statement2 = null;
    private ResultSet resultSet = null;
    private ResultSet resultSet2 = null;
    private final String url = "jdbc:mysql://localhost:3306/hotelsystem";
    private final String user = "root";
    private final String password = "";
    private final String driver = "com.mysql.jdbc.Driver";
    
    
    
    public Reservation1() {
        initComponents();
        
        try
        {
            Class.forName(driver);
            connection = DriverManager.getConnection(url,user,password);
            statement=connection.createStatement();
            
            
        } catch (Exception ex)
        {
            Logger.getLogger(CheckOut.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        allRooms.setVisible(false);
        
        int room = 1;
        try
        {
         statement=connection.createStatement();
         statement2=connection.createStatement();


      String sql3 ="SELECT COUNT(number) FROM room WHERE Booked=0";
      resultSet = statement.executeQuery(sql3);
      while(resultSet.next())
      {
          room=resultSet.getInt("COUNT(number)");
      }
      }
      catch (Exception e) {
      e.printStackTrace();
      }
        if(room==0)
        {
            Alerts A = new Alerts("There are No Free Rooms.");
            A.setDefaultCloseOperation(0);
            A.setVisible(true);
            A.setLocationRelativeTo(this);
            A.setAlwaysOnTop(true);
         
            
        }
        
        
        checkBooking CB = new checkBooking();
        CB.start();
        
    }
    
    
    class checkBooking extends Thread
    {
     @Override
        public void run()
        {
            try
            {
                
                //Removing past bookings from rooms table.
                String sql3 ="SELECT * FROM bookings Where endDate < CAST(CURDATE() AS DATE)";
                resultSet = statement.executeQuery(sql3);
                while(resultSet.next())
                {
                           String sql2 = "UPDATE room SET Booked = 0, GuestID = null , BookingID = null "
                                        + "WHERE GuestID = "+resultSet.getInt("guestID")+" AND BookingID="+resultSet.getInt("id")+" "
                                        + "AND type = '"+resultSet.getString("type")+"'";
                        
                            PreparedStatement pst = connection.prepareStatement(sql2);
                            pst.executeUpdate();
                }
                
                int max = 0;
                
                
                //allocating rooms for bookings of today
                String sql ="SELECT * FROM bookings Where CAST(CURDATE() AS DATE) BETWEEN startDate AND endDate AND today = 0";
                resultSet = statement.executeQuery(sql);
                while(resultSet.next())
                {
                    for(int i=0;i<resultSet.getInt("numberofRooms");i++)
                    {
                        String sql4 = "SELECT MAX(number) FROM room WHERE type = '"+resultSet.getString("type")+"' AND Booked=0";
                        resultSet2 = statement2.executeQuery(sql4);
                        while(resultSet2.next())
                        {
                            max = resultSet2.getInt("MAX(number)");
                        }
                    
                        String sql2 = "UPDATE room SET Booked = 1, GuestID = "+resultSet.getInt("guestID")+", BookingID="+resultSet.getInt("id")+" "
                                      + "WHERE number = "+max;

                         PreparedStatement pst = connection.prepareStatement(sql2);
                         pst.executeUpdate();
                         
                         String sql5 = "UPDATE bookings SET today = 1 "
                                      + "WHERE id = "+resultSet.getInt("id");

                         PreparedStatement pst2 = connection.prepareStatement(sql5);
                         pst2.executeUpdate();

                              
                          
                    }
                }
                
                
                
                
                
                //Hall Managing
                
                String sql6 ="SELECT tableNo,id,guestId FROM reservation Where CAST(CURDATE() AS DATE) = date AND tableNo > 9900";
                resultSet = statement.executeQuery(sql6);
                while(resultSet.next())
                {
                        String sql2 = "UPDATE halls SET Booked = 1, GuestID = "+resultSet.getInt("guestId")+", ReservationID="+resultSet.getInt("id")+" "
                                      + "WHERE number = "+resultSet.getInt("tableNo");

                         PreparedStatement pst = connection.prepareStatement(sql2);
                         pst.executeUpdate();
                     
                    
                }
                
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
            
            
            
            
            //Guest's Leaving Today
        int rows=0;
        String contents[][] = null;
        
        try{
            String sql2 ="SELECT COUNT(room.number) "
                        + "FROM bookings,room,guest "
                        + "WHERE bookings.endDate = CAST(CURDATE() AS DATE) "
                        + "AND bookings.guestID = guest.ID "
                        + "AND room.BookingID = bookings.id";
            resultSet = statement.executeQuery(sql2);
            while(resultSet.next())
            {
                rows=resultSet.getInt("COUNT(room.number)");
            }
        
        
         contents = new String[rows][2];
        

           String sql ="SELECT room.number,guest.name "
                        + "FROM bookings,room,guest "
                        + "WHERE bookings.endDate = CAST(CURDATE() AS DATE) "
                        + "AND bookings.guestID = guest.ID "
                        + "AND room.BookingID = bookings.id";
            resultSet = statement.executeQuery(sql);
            int i=0;
            while(resultSet.next())
            {
                contents[i][0]=String.valueOf(resultSet.getInt("number"));
                contents[i][1]=resultSet.getString("name");
                i = i + 1;
            }
           }
                catch (Exception e) {
                e.printStackTrace();
                }

                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                contents,
                new String []
                {
                    "Room Number", "Guest Name"
                }
                )
                {
                boolean[] canEdit = new boolean []
                {
                    false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex)
                {
                    return canEdit [columnIndex];
                }
                });
        
        
            
            
            
            
            
            
            
            
            
            
            
         try
         {
             Thread.sleep(43200000); //12 hours
         } catch (InterruptedException ex)
         {
             Logger.getLogger(Reservation1.class.getName()).log(Level.SEVERE, null, ex);
         }
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        Tabs = new javax.swing.JTabbedPane();
        Reservations = new javax.swing.JPanel();
        GType = new javax.swing.JComboBox<>();
        GName = new javax.swing.JTextField();
        Demo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        GNumber = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        GEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        GNext1 = new javax.swing.JButton();
        GNext4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        HallBookings = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        Rooms = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        Floors1 = new javax.swing.JButton();
        Bookings = new javax.swing.JButton();
        Guests = new javax.swing.JButton();
        GuestsRoom = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        GNext3 = new javax.swing.JButton();
        Halls = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        currentRoom = new javax.swing.JTextField();
        GuestName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        otherRooms = new javax.swing.JTextField();
        allRooms = new javax.swing.JButton();
        roomAmount = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        isEmpty = new javax.swing.JLabel();
        GNext2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(36, 47, 65));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        Tabs.setBackground(new java.awt.Color(100, 255, 218));
        Tabs.setForeground(new java.awt.Color(36, 47, 65));
        Tabs.setDoubleBuffered(true);

        Reservations.setBackground(new java.awt.Color(50, 50, 86));
        Reservations.setToolTipText("");
        Reservations.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        GType.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        GType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NIC", "Passport" }));
        GType.setToolTipText("Select if guest is giving Passport or NIC");
        GType.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        GType.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                GTypeActionPerformed(evt);
            }
        });

        GName.setBackground(new java.awt.Color(50, 50, 86));
        GName.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        GName.setForeground(new java.awt.Color(255, 255, 255));
        GName.setToolTipText("Enter Guest's Name");
        GName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        GName.setCaretColor(new java.awt.Color(255, 255, 255));
        GName.setMargin(new java.awt.Insets(2, 2, 0, 2));
        GName.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                GNameActionPerformed(evt);
            }
        });

        Demo.setBackground(new java.awt.Color(100, 255, 218));
        Demo.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        Demo.setText("Demo");
        Demo.setToolTipText("");
        Demo.setBorder(null);
        Demo.setBorderPainted(false);
        Demo.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                DemoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NIC/Passport Number:");

        GNumber.setBackground(new java.awt.Color(50, 50, 86));
        GNumber.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        GNumber.setForeground(new java.awt.Color(255, 255, 255));
        GNumber.setToolTipText("Enter NIC or Passport Number");
        GNumber.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        GNumber.setCaretColor(new java.awt.Color(255, 255, 255));
        GNumber.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        GNumber.setDragEnabled(true);
        GNumber.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                GNumberActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Full Name:");

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Reservation");

        GEmail.setBackground(new java.awt.Color(50, 50, 86));
        GEmail.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        GEmail.setForeground(new java.awt.Color(255, 255, 255));
        GEmail.setToolTipText("Enter Guest's Email");
        GEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        GEmail.setCaretColor(new java.awt.Color(255, 255, 255));
        GEmail.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                GEmailActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText(" Guest Email:");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Type:");

        GNext1.setBackground(new java.awt.Color(100, 255, 218));
        GNext1.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        GNext1.setText("Logout");
        GNext1.setToolTipText("");
        GNext1.setBorder(null);
        GNext1.setBorderPainted(false);
        GNext1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                GNext1ActionPerformed(evt);
            }
        });

        GNext4.setBackground(new java.awt.Color(100, 255, 218));
        GNext4.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        GNext4.setText("Room Booking");
        GNext4.setToolTipText("");
        GNext4.setBorder(null);
        GNext4.setBorderPainted(false);
        GNext4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                GNext4ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));

        HallBookings.setBackground(new java.awt.Color(100, 255, 218));
        HallBookings.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        HallBookings.setText("Hall Booking");
        HallBookings.setToolTipText("");
        HallBookings.setBorder(null);
        HallBookings.setBorderPainted(false);
        HallBookings.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                HallBookingsActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(100, 255, 218));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton1.setText("Report");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ReservationsLayout = new javax.swing.GroupLayout(Reservations);
        Reservations.setLayout(ReservationsLayout);
        ReservationsLayout.setHorizontalGroup(
            ReservationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ReservationsLayout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(GNext1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ReservationsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Demo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(ReservationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ReservationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(ReservationsLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(HallBookings, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(ReservationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ReservationsLayout.createSequentialGroup()
                        .addGroup(ReservationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(GNumber)
                            .addComponent(GName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(GEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GNext4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        ReservationsLayout.setVerticalGroup(
            ReservationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReservationsLayout.createSequentialGroup()
                .addGroup(ReservationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GNext1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGroup(ReservationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ReservationsLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(ReservationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ReservationsLayout.createSequentialGroup()
                                .addComponent(GType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(GNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addGroup(ReservationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(GName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48)
                                .addComponent(GEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ReservationsLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addGroup(ReservationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ReservationsLayout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(75, 75, 75))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ReservationsLayout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(91, 91, 91)
                        .addGroup(ReservationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(GNext4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HallBookings, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(58, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ReservationsLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Demo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        Tabs.addTab("Reservation", Reservations);

        Rooms.setBackground(new java.awt.Color(50, 50, 86));
        Rooms.setToolTipText("");
        Rooms.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Rooms");

        Floors1.setBackground(new java.awt.Color(100, 255, 218));
        Floors1.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        Floors1.setText("View Rooms");
        Floors1.setToolTipText("");
        Floors1.setBorder(null);
        Floors1.setBorderPainted(false);
        Floors1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                Floors1ActionPerformed(evt);
            }
        });

        Bookings.setBackground(new java.awt.Color(100, 255, 218));
        Bookings.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        Bookings.setText("View Bookings");
        Bookings.setToolTipText("");
        Bookings.setBorder(null);
        Bookings.setBorderPainted(false);
        Bookings.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                BookingsActionPerformed(evt);
            }
        });

        Guests.setBackground(new java.awt.Color(100, 255, 218));
        Guests.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        Guests.setText("View Guests");
        Guests.setToolTipText("");
        Guests.setBorder(null);
        Guests.setBorderPainted(false);
        Guests.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                GuestsActionPerformed(evt);
            }
        });

        GuestsRoom.setBackground(new java.awt.Color(100, 255, 218));
        GuestsRoom.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        GuestsRoom.setText("Change Guest's Room");
        GuestsRoom.setToolTipText("");
        GuestsRoom.setBorder(null);
        GuestsRoom.setBorderPainted(false);
        GuestsRoom.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                GuestsRoomActionPerformed(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(50, 50, 86));
        jLabel13.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Guest's Leaving Today");
        jLabel13.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jTable1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String []
            {
                "Room Number", "Guest Name"
            }
        )
        {
            boolean[] canEdit = new boolean []
            {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        GNext3.setBackground(new java.awt.Color(100, 255, 218));
        GNext3.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        GNext3.setText("Logout");
        GNext3.setToolTipText("");
        GNext3.setBorder(null);
        GNext3.setBorderPainted(false);
        GNext3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                GNext3ActionPerformed(evt);
            }
        });

        Halls.setBackground(new java.awt.Color(100, 255, 218));
        Halls.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        Halls.setText("View Halls");
        Halls.setToolTipText("");
        Halls.setBorder(null);
        Halls.setBorderPainted(false);
        Halls.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                HallsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RoomsLayout = new javax.swing.GroupLayout(Rooms);
        Rooms.setLayout(RoomsLayout);
        RoomsLayout.setHorizontalGroup(
            RoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 910, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RoomsLayout.createSequentialGroup()
                .addContainerGap(133, Short.MAX_VALUE)
                .addGroup(RoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Floors1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Bookings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Guests, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(GuestsRoom, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                    .addComponent(Halls, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(74, 74, 74)
                .addGroup(RoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(134, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RoomsLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(GNext3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        RoomsLayout.setVerticalGroup(
            RoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RoomsLayout.createSequentialGroup()
                .addComponent(GNext3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addGroup(RoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(RoomsLayout.createSequentialGroup()
                        .addComponent(Floors1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(Bookings, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(Guests, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(GuestsRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(Halls, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RoomsLayout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        Tabs.addTab("Rooms", Rooms);

        jPanel2.setBackground(new java.awt.Color(50, 50, 86));

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Check Out");

        currentRoom.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        currentRoom.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                currentRoomActionPerformed(evt);
            }
        });

        GuestName.setEditable(false);
        GuestName.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        GuestName.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        GuestName.setEnabled(false);
        GuestName.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                GuestNameActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Guest's Name:");

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Enter Room Number:");

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("All Rooms under this Guest:");

        otherRooms.setEditable(false);
        otherRooms.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        otherRooms.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                otherRoomsActionPerformed(evt);
            }
        });

        allRooms.setBackground(new java.awt.Color(100, 255, 218));
        allRooms.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        allRooms.setText("Check out");
        allRooms.setToolTipText("");
        allRooms.setBorder(null);
        allRooms.setBorderPainted(false);
        allRooms.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                allRoomsActionPerformed(evt);
            }
        });

        roomAmount.setEditable(false);
        roomAmount.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        roomAmount.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                roomAmountActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Amount for room(s) only:");

        isEmpty.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        isEmpty.setForeground(new java.awt.Color(255, 255, 255));

        GNext2.setBackground(new java.awt.Color(100, 255, 218));
        GNext2.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        GNext2.setText("Logout");
        GNext2.setToolTipText("");
        GNext2.setBorder(null);
        GNext2.setBorderPainted(false);
        GNext2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                GNext2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(229, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(allRooms, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel10))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(otherRooms, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roomAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(25, 25, 25)
                        .addComponent(GuestName, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(25, 25, 25)
                        .addComponent(currentRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(isEmpty, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(GNext2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(GNext2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(currentRoom))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(isEmpty, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GuestName))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(otherRooms)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roomAmount))
                .addGap(56, 56, 56)
                .addComponent(allRooms, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(126, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Tabs.addTab("Check Out", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tabs)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tabs)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GNumberActionPerformed
       jLabel8.setText("");
       GName.setText("");
       GEmail.setText("");
        try{
        String sql ="SELECT name,email FROM guest WHERE type='"+GType.getSelectedItem()+"' AND number='"+GNumber.getText()+"' ";
            resultSet = statement.executeQuery(sql);
            
            while(resultSet.next())
            {
                GName.setText(resultSet.getString("name"));
                GEmail.setText(resultSet.getString("email"));
                jLabel8.setText("(returning guest)");
            }
           }
                catch (Exception e) {
                e.printStackTrace();
                }
    }//GEN-LAST:event_GNumberActionPerformed

    private void DemoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DemoActionPerformed
        
       GName.setText("Alex KingKiller");
       GType.setSelectedIndex(1);
       GNumber.setText("543885705");
       GEmail.setText("KingKiller@hotmail.com");
       
    }//GEN-LAST:event_DemoActionPerformed

    public void setText(String name,String number,String Type,String email)
    {
        GName.setText(name);
        GNumber.setText(number);
        GType.setSelectedItem(Type);
        GEmail.setText(email);
    }
    
    private void GNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GNameActionPerformed

    private void GTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GTypeActionPerformed

    private void GEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GEmailActionPerformed

    public void setTab(int index)
    {
        this.Tabs.setSelectedIndex(index);
    }
    
    
    private void Floors1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Floors1ActionPerformed
        RoomView RV = new RoomView();
        RV.setVisible(true);
        RV.setLocationRelativeTo(this);
        RV.setExtendedState(this.getExtendedState());
        this.setVisible(false);
    }//GEN-LAST:event_Floors1ActionPerformed

    private void BookingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookingsActionPerformed
      Bookings B = new Bookings();
      B.setVisible(true);
      B.setLocationRelativeTo(this);
      B.setExtendedState(this.getExtendedState());
      this.setVisible(false);
    }//GEN-LAST:event_BookingsActionPerformed

    private void GuestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuestsActionPerformed
        Guests G = new Guests();
        G.setVisible(true);
        G.setLocationRelativeTo(this);
        G.setExtendedState(this.getExtendedState());
        this.setVisible(false);
    }//GEN-LAST:event_GuestsActionPerformed

    private void GuestsRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuestsRoomActionPerformed
        GuestsRoom GR = new GuestsRoom();
        GR.setVisible(true);
        GR.setLocationRelativeTo(this);
        GR.setExtendedState(this.getExtendedState());
        this.setVisible(false);
    }//GEN-LAST:event_GuestsRoomActionPerformed

    private void currentRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currentRoomActionPerformed

         //Validating Inputs
        roomAmount.setText("");
        isEmpty.setText("");
        String NumberPattern = "[0-9]+";
        
        if(!currentRoom.getText().matches(NumberPattern))
        {
            Alerts A = new Alerts("Please Check the Number");
            A.setDefaultCloseOperation(0);
            A.setVisible(true);
            A.setLocationRelativeTo(this);
            return;
        }
        
        
        allRooms.setVisible(false);
        int curRm = Integer.valueOf(currentRoom.getText());

        String sql = "SELECT guest.name,room.type FROM guest,room WHERE room.GuestID=guest.id AND room.number="+curRm;

        try
        {

            resultSet = statement.executeQuery(sql);
            GuestName.setText("");
            while(resultSet.next())
            {
                GuestName.setText(resultSet.getString("name"));

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        String sql2 = "SELECT room.number,bookings.amount FROM guest,room,bookings WHERE room.GuestID=guest.id AND bookings.guestID=guest.id AND room.BookingID=bookings.id AND guest.name='"+GuestName.getText()+"'";
        String rooms = "";
        try
        {

            resultSet = statement.executeQuery(sql2);
            while(resultSet.next())
            {
                rooms = rooms + resultSet.getString("number");
                rooms = rooms + ", ";
                roomAmount.setText(String.valueOf(resultSet.getDouble("amount")));
                allRooms.setVisible(true);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        otherRooms.setText(rooms);
        
        if(roomAmount.getText().equalsIgnoreCase(""))
        {
            isEmpty.setText("Room is Empty.");
        }



    }//GEN-LAST:event_currentRoomActionPerformed

    private void GuestNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuestNameActionPerformed
        // TODO add your handling code here: 
    }//GEN-LAST:event_GuestNameActionPerformed

    private void otherRoomsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_otherRoomsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_otherRoomsActionPerformed

    private void allRoomsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allRoomsActionPerformed

        int GID = 0;
        try 
		{
                String sql2 ="SELECT GuestID from room WHERE number = "+currentRoom.getText();
                            resultSet = statement.executeQuery(sql2);
                            while(resultSet.next())
                            {
                                GID = resultSet.getInt("GuestID");
                            }



                String sql = "INSERT INTO messages(Sender,Message,Receiver) VALUES(?,?,?)";

			
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1,"Receptionist");
                        pst.setString(2,"Check Room(s): "+otherRooms.getText());
                        pst.setString(3,"HouseKeeping");
                        
			pst.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
        
        
        CheckOut CO = new CheckOut(otherRooms.getText(),Double.parseDouble(roomAmount.getText()),GID);
        CO.setVisible(true);
        CO.setLocationRelativeTo(this);
        CO.setDefaultCloseOperation(0);
        
        currentRoom.setText("");
        GuestName.setText("");
        roomAmount.setText("");
        otherRooms.setText("");
        isEmpty.setText("");
    }//GEN-LAST:event_allRoomsActionPerformed

    private void roomAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roomAmountActionPerformed

    private void GNext1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GNext1ActionPerformed
       Login L = new Login();
       L.setVisible(true);
       L.setLocationRelativeTo(null);
       L.setExtendedState(JFrame.MAXIMIZED_BOTH);
       this.dispose();
    }//GEN-LAST:event_GNext1ActionPerformed

    private void GNext2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_GNext2ActionPerformed
    {//GEN-HEADEREND:event_GNext2ActionPerformed
         Login L = new Login();
       L.setVisible(true);
       L.setLocationRelativeTo(null);
       L.setExtendedState(JFrame.MAXIMIZED_BOTH);
       this.dispose();
    }//GEN-LAST:event_GNext2ActionPerformed

    private void GNext3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_GNext3ActionPerformed
    {//GEN-HEADEREND:event_GNext3ActionPerformed
         Login L = new Login();
       L.setVisible(true);
       L.setLocationRelativeTo(null);
       L.setExtendedState(JFrame.MAXIMIZED_BOTH);
       this.dispose();
    }//GEN-LAST:event_GNext3ActionPerformed

    private void GNext4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_GNext4ActionPerformed
    {//GEN-HEADEREND:event_GNext4ActionPerformed
       //Validating Inputs
        String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        String IDPattern = "[A-Za-z-0-9]+";
        String NamePattern = "[A-Za-z ]+";
        
        if(!GName.getText().matches(NamePattern))
        {
            Alerts A = new Alerts("Please Check the Name");
            A.setDefaultCloseOperation(0);
            A.setVisible(true);
            A.setLocationRelativeTo(this);
        }
        else if(!GNumber.getText().matches(IDPattern))
        {
            Alerts A = new Alerts("Please check NIC/Passport Number");
            A.setDefaultCloseOperation(0);
            A.setVisible(true);
            A.setLocationRelativeTo(this);
        }
        else if(!GEmail.getText().matches(emailPattern))
        {
            Alerts A = new Alerts("Email format is Incorrect");
            A.setDefaultCloseOperation(0);
            A.setVisible(true);
            A.setLocationRelativeTo(this);
        }
        else if(GType.getSelectedItem().toString().equalsIgnoreCase("NIC") && GNumber.getText().length() != 10)
        {
            Alerts A = new Alerts("Please check NIC Number");
            A.setDefaultCloseOperation(0);
            A.setVisible(true);
            A.setLocationRelativeTo(this);        
        }
        else if(GType.getSelectedItem().toString().equalsIgnoreCase("passport") && GNumber.getText().length() != 9)
        {
            Alerts A = new Alerts("Please check Passport Number");
            A.setDefaultCloseOperation(0);
            A.setVisible(true);
            A.setLocationRelativeTo(this);        
        }        
        else
        {
            Guest G1 = new Guest();
            G1.setName(GName.getText());
            G1.setNumber(GNumber.getText());
            G1.setEmail(GEmail.getText());
            G1.setType(String.valueOf(GType.getSelectedItem()));

            Reservation2 R = new Reservation2(G1);
            R.setVisible(true);
            R.setLocationRelativeTo(this);
            R.setExtendedState(this.getExtendedState());
            this.setVisible(false);
        }
    }//GEN-LAST:event_GNext4ActionPerformed

    private void HallBookingsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_HallBookingsActionPerformed
    {//GEN-HEADEREND:event_HallBookingsActionPerformed
        //Validating Inputs
        String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        String IDPattern = "[A-Za-z-0-9]+";
        String NamePattern = "[A-Za-z ]+";
        
        if(!GName.getText().matches(NamePattern))
        {
            Alerts A = new Alerts("Please Check the Name");
            A.setDefaultCloseOperation(0);
            A.setVisible(true);
            A.setLocationRelativeTo(this);
        }
        else if(!GNumber.getText().matches(IDPattern))
        {
            Alerts A = new Alerts("Please check NIC/Passport Number");
            A.setDefaultCloseOperation(0);
            A.setVisible(true);
            A.setLocationRelativeTo(this);
        }
        else if(!GEmail.getText().matches(emailPattern))
        {
            Alerts A = new Alerts("Email format is Incorrect");
            A.setDefaultCloseOperation(0);
            A.setVisible(true);
            A.setLocationRelativeTo(this);
        }
        else
        {
            Guest G1 = new Guest();
            G1.setName(GName.getText());
            G1.setNumber(GNumber.getText());
            G1.setEmail(GEmail.getText());
            G1.setType(String.valueOf(GType.getSelectedItem()));

            HallBookings GR = new HallBookings(G1);
            GR.setVisible(true);
            GR.setLocationRelativeTo(this);
            GR.setExtendedState(this.getExtendedState());
            this.setVisible(false);
        }

        
    }//GEN-LAST:event_HallBookingsActionPerformed

    private void HallsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_HallsActionPerformed
    {//GEN-HEADEREND:event_HallsActionPerformed
        Halls B = new Halls();
        B.setVisible(true);
        B.setLocationRelativeTo(this);
        B.setExtendedState(this.getExtendedState());
        this.setVisible(false);
    }//GEN-LAST:event_HallsActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed

        Report R = new Report();
        R.setVisible(true);
        R.setLocationRelativeTo(this);
        R.setExtendedState(this.getExtendedState());
        this.setVisible(false);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Reservation1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reservation1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reservation1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reservation1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reservation1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bookings;
    private javax.swing.JButton Demo;
    private javax.swing.JButton Floors1;
    private javax.swing.JTextField GEmail;
    private javax.swing.JTextField GName;
    private javax.swing.JButton GNext1;
    private javax.swing.JButton GNext2;
    private javax.swing.JButton GNext3;
    private javax.swing.JButton GNext4;
    private javax.swing.JTextField GNumber;
    private javax.swing.JComboBox<String> GType;
    private javax.swing.JTextField GuestName;
    private javax.swing.JButton Guests;
    private javax.swing.JButton GuestsRoom;
    private javax.swing.JButton HallBookings;
    private javax.swing.JButton Halls;
    private javax.swing.JPanel Reservations;
    private javax.swing.JPanel Rooms;
    private javax.swing.JTabbedPane Tabs;
    private javax.swing.JButton allRooms;
    private javax.swing.JTextField currentRoom;
    private javax.swing.JLabel isEmpty;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField otherRooms;
    private javax.swing.JTextField roomAmount;
    // End of variables declaration//GEN-END:variables
}
