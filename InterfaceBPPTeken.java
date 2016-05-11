/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritme.bpp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Stijn_000
 */
public class InterfaceBPPTeken extends JPanel{
    
    private InterfaceBPP BPP;

    
    public InterfaceBPPTeken(InterfaceBPP BPP) {
       this.BPP = BPP;
       this.setPreferredSize(new Dimension(800, 600));
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 200;
        int y =80;
        int afm = 20;
        //if(BPP.CountTotalTime() < 10){
            g.setColor(Color.red);
            //g.fillOval(x, 50, 20, 20);
            g.fillOval(x, y, afm, afm);
            g.setColor(Color.black);
            //g.drawOval(x, 50, 20, 20);
            g.drawOval(x, y, afm, afm);
       // }
        
//            else {
//                g.setColor(Color.yellow);
//                //g.fillRect(x, 50, 10, 20);
//                g.fillRect (x, y, afm/2, afm);
//                g.setColor(Color.black);
//                //g.drawRect(x, 50, 10, 20);
//                g.drawRect(x, y, afm/2, afm);
//            }
//            x += afm;
//        }

    }
}
