package algoritme.bpp;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class InterfaceBPP extends JFrame implements ActionListener {

    public static void main(String args[]) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceBPP().setVisible(true);
            }
        });
    }

    private JLabel jLabel1, OverviewItems, AmountBoxes, OrderList, EndTime, Percentage, OverviewProcess, Boxesnr, Timenr, jLabel2, BoxAmount, Progress;
    private JButton Add, Remove, Start, RemoveAll;
    private JProgressBar ProgressBar;
    private JList OverviewList, OrderListList;
    private JScrollPane jScrollPane1, jScrollPane2;
    //private JPanel Panel;
    private ArrayList<String> selecteditems = new ArrayList<>();
    private javax.swing.Timer time = null;
    private int count = 0;


    public InterfaceBPP() {
        InterfaceBPPTeken Panel = new InterfaceBPPTeken(this);
        
        jLabel1 = new javax.swing.JLabel();
        OverviewItems = new javax.swing.JLabel();
        AmountBoxes = new javax.swing.JLabel();
        OrderList = new javax.swing.JLabel();
        EndTime = new javax.swing.JLabel();
        Add = new javax.swing.JButton();
        Remove = new javax.swing.JButton();
        Start = new javax.swing.JButton();
        ProgressBar = new javax.swing.JProgressBar();
        Percentage = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        OverviewList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        OrderListList = new javax.swing.JList<>();
        OverviewProcess = new javax.swing.JLabel();
        Boxesnr = new javax.swing.JLabel();
        Timenr = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BoxAmount = new javax.swing.JLabel();
        Progress = new javax.swing.JLabel();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(new Color(204, 204, 204));
        setBounds(new Rectangle(500, 200, 0, 0));
        getContentPane().setLayout(null);
        setMinimumSize(new Dimension(850, 650));

        OverviewItems.setText("Overzicht items");
        getContentPane().add(OverviewItems);
        OverviewItems.setBounds(47, 67, 109, 20);

        AmountBoxes.setText("Aantal items:");
        getContentPane().add(AmountBoxes);
        AmountBoxes.setBounds(490, 80, 190, 20);

        OrderList.setText("Bestellijst");
        getContentPane().add(OrderList);
        OrderList.setBounds(253, 69, 66, 20);

        EndTime.setText("Eindtijd:");
        getContentPane().add(EndTime);
        EndTime.setBounds(492, 141, 60, 20);

        Add.setText("Add");
        Add.addActionListener(this);
        getContentPane().add(Add);
        Add.setBounds(47, 555, 61, 29);

        Remove.setText("Remove");
        Remove.addActionListener(this);
        getContentPane().add(Remove);
        Remove.setBounds(253, 555, 89, 29);

        Start.setText("Start");
        Start.addActionListener(this);
        getContentPane().add(Start);
        Start.setBounds(690, 550, 65, 29);

        ProgressBar.setBackground(new Color(153, 153, 153));
        ProgressBar.setForeground(new Color(51, 255, 51));
        getContentPane().add(ProgressBar);
        ProgressBar.setBounds(490, 220, 300, 30);

        Percentage.setText("Percentage");
        getContentPane().add(Percentage);
        Percentage.setBounds(492, 179, 77, 20);

        jScrollPane1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        OverviewList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7", "Item 8", "Item 9", "Item 10", "Item 11", "Item 12", "Item 13", "Item 14", "Item 15", "Item 16", "Item 17", "Item 18", "Item 19", "Item 20", "Item 21", "Item 22", "Item 23", "Item 24", "Item 25", "Item 26"};

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
        jScrollPane1.setViewportView(OverviewList);
        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(47, 103, 172, 419);

        OrderListList.setModel(getOrderListTest());
        OrderListList.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jScrollPane2.setViewportView(OrderListList);
        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(253, 105, 184, 417);

        OverviewProcess.setText("Overzicht proces");
        getContentPane().add(OverviewProcess);
        OverviewProcess.setBounds(492, 263, 117, 20);

        Panel.setBackground(new java.awt.Color(255, 255, 255));
        GroupLayout PanelLayout = new GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
                PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(0, 262, Short.MAX_VALUE)
        );
        PanelLayout.setVerticalGroup(
                PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(0, 221, Short.MAX_VALUE)
        );

        getContentPane().add(Panel);
        Panel.setBounds(492, 301, 262, 221);

        Boxesnr.setText("" + getOrderListamount());
        getContentPane().add(Boxesnr);
        Boxesnr.setBounds(690, 80, 97, 20);

        Timenr.setText("" + getOrderListTime());
        getContentPane().add(Timenr);
        Timenr.setBounds(690, 140, 97, 20);

        jLabel2.setText("Aantal dozen:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(490, 110, 100, 20);

        BoxAmount.setText("" + getBoxesAmount());
        getContentPane().add(BoxAmount);
        BoxAmount.setBounds(690, 110, 100, 20);

        Progress.setText("" + getOrderProgress());
        getContentPane().add(Progress);
        Progress.setBounds(690, 180, 100, 20);
        int tijd = (CountTotalTime() * 10);
        time = new javax.swing.Timer(tijd, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                ProgressBar.setValue(count);
                if (ProgressBar.getValue() < 100) {
                    ProgressBar.setValue(ProgressBar.getValue() + 1);
                }
            }
        });

    }

    //if(volledige enumeratie){
    //berekenen elke pakketen waar moeten hoeveel dozen je nodig bent
    //ong 1 a 2 sec
    int TijdBereken = 2;
    //dozen aanmaken
    //ong 5 - 10 sec per doos
    int TijdDoos = 10;
    //stop items erin
    //ong 3 - 5 sec per item
    int TijdItems = 5;

//    private Timer timer;
    //}
    public void Add(String item) {
        selecteditems.add(item);
    }

    //print in console
    public void PrintOrderList() {
        System.out.println();
        System.out.println("~~~~~BestelLijst~~~~~");
        for (String O : selecteditems) {
            String itemnr = O;
            System.out.println("Item nummer: " + itemnr);
        }
        System.out.println("");
    }

    //print array in GUI
    public DefaultListModel getOrderListTest() {
        DefaultListModel result = new DefaultListModel<String>();
        for (String O : selecteditems) {
            result.addElement("Item " + O);
        }
        return result;
    }

    //Counting the arraylist and it will be printed in the GUI
    public int getOrderListamount() {
        DefaultListModel result = new DefaultListModel<String>();
        for (String O : selecteditems) {
            result.addElement("Item " + O);
        }
        int itemCount = selecteditems.size();
        return itemCount;
    }

    //
    public void PrintOrder() {
        System.out.println();

        if (OrderListList.getModel().getSize() == 0) {

            for (String O : selecteditems) {
                String itemnr = O;
                System.out.println("Item nummer: " + itemnr);
            }
        } else {
            DefaultListModel listModel = (DefaultListModel) OrderListList.getModel();
            listModel.removeAllElements();
        }

    }

    //Calculates time to create one or multiple boxes
    public int getBoxesAmountTime() {
        int itemCount = selecteditems.size();
        int Boxes;
        int rest = itemCount % 8; //calculates remaining items that won't fit in the box
        Boxes = (itemCount - rest) / 8; //calculates the required amount of boxes
        if (rest != 0) {
            Boxes++; // adds an additional box when there are remaining boxes
        }
        return Boxes * TijdDoos; //calculates the time to create the boxes by multiply the amount of boxes with the time to create one box
    }

    //Count the amount of boxes and can be printed in the GUI
    public int getBoxesAmount() {
        int itemCount = selecteditems.size();
        int Boxes;
        int rest = itemCount % 8; //calculates remaining items that won't fit in the box
        Boxes = (itemCount - rest) / 8; //calculates the required amount of boxes
        if (rest != 0) {
            Boxes++; // adds an additional box when there are remaining boxes
        }
        return Boxes;
    }

    //Calculates the required time in seconds
    public int CountTotalTime() {
        int itemCount = selecteditems.size();
        int CountTimeCalc = TijdBereken;
        int CountTimeBox = getBoxesAmountTime();
        int CountTimeItems = itemCount * TijdItems;
        int CountTotalTime = CountTimeCalc + CountTimeBox + CountTimeItems;

        return CountTotalTime;
    }

    //Calculate the required time in minutes
    public String getOrderListTime() {
        int CountTotalTime2 = CountTotalTime();
        int itemCount = selecteditems.size();

        if (itemCount == 0) {
            CountTotalTime2 = 0;
        }

        int begin = CountTotalTime2;
        int min, sec;
        sec = begin % 60;
        min = (begin - sec) / 60;

        if (sec < 10) {
            return min + ":0" + sec;
        } else {
            return min + ":" + sec;
        }
    }

    //ProgressBar
    public int getOrderProgress() {
        int Progress = 0;
        int tijdint = CountTotalTime();
        int percent = Progress / tijdint * 100;


//        if(selecteditems.isEmpty()){
//             percent = 0;
//        }

        return Progress;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        int percent = 0;
        javax.swing.Timer t = new javax.swing.Timer(percent, this);
        int index = OverviewList.getSelectedIndex();
        String items = Integer.toString(OverviewList.getSelectedIndex() + 1);
        int itemCount = selecteditems.size() + 1;

        if (evt.getSource() == t) {
            System.out.println("Timer aangeroepen");

        }
//        Add button
        if (index != -1 && evt.getSource() == Add) {
            selecteditems.add(items);
            OrderListList.setModel(getOrderListTest());
            Boxesnr.setText(String.valueOf(getOrderListamount()));
            Timenr.setText(String.valueOf(getOrderListTime()));
            BoxAmount.setText(String.valueOf(getBoxesAmount()));
            System.out.println("Item " + items + " is toegevoegd!");
            System.out.println("Met een geschatte eindtijd van: " + getOrderListTime());

            PrintOrderList();
            if (itemCount != 1) {
                System.out.println("Er zijn nu " + itemCount + " items");
            } else {

                System.out.println("Er is nu " + itemCount + " item");
            }

        }
        int orderindex = selecteditems.size();
        Progress.setText(String.valueOf(0));

//        startbutton
        if (orderindex != 0 && evt.getSource() == Start) {
            time.start();
        }
        if (orderindex == 0 && evt.getSource() == Start) {
            ProgressBar.setValue(0);
            Progress.setText(String.valueOf(0));


        }

        //Removal of a selected order
        int itemCountR = selecteditems.size();
        int orderindexR = OrderListList.getSelectedIndex();

        if (orderindexR != -1 && evt.getSource() == Remove) {
            selecteditems.remove(orderindexR);   //deleting order
            System.out.println("Item " + orderindexR + " is verwijderd");    //Message of completion
            OrderListList.setModel(getOrderListTest()); //update list in GUI
            Boxesnr.setText(String.valueOf(getOrderListamount()));
            Timenr.setText(String.valueOf(getOrderListTime()));
            BoxAmount.setText(String.valueOf(getBoxesAmount()));
            PrintOrderList();   //Update list in console

            itemCountR--;    //remove selected 1 from totalcount
            if (itemCountR != 1) {
                System.out.println("Nu zijn er nog maar " + itemCountR + " items");
            } else {
                System.out.println("Nu is er nog maar " + itemCountR + " item");
            }

            System.out.println("Met een geschatte eindtijd van: " + getOrderListTime());
        }

        //Error
        if (orderindexR == -1 && evt.getSource() == Remove) {
            System.out.println("Er moet eerst een item worden geselcteerd, voordat er iets kan worden verwijderd!");
        }
    }

    Iterable<InterfaceBPP> getList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    }



