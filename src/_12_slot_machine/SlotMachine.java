package _12_slot_machine;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class SlotMachine implements ActionListener {

    private JFrame _frame = new JFrame();
    private JPanel _panel = new JPanel();

    private JLabel _slotCherry = null;
    private JLabel _slotSeven = null;
    private JLabel _slotOrange = null;

    private Icon _iconCherry = null;
    private Icon _iconSeven = null;
    private Icon _iconOrange = null;

    private JLabel _slot1 = new JLabel();
    private JLabel _slot2= new JLabel();
    private JLabel _slot3 = new JLabel();

    private JButton _spin = new JButton( "SPIN" );

    private final int _slotCherryID = 0;
    private final int _slotSevenID = 1;
    private final int _slotOrangeID = 2;

    private int x = 0;

    public SlotMachine()
    {
        init();


    }

    private void init()
    {
        initPanel();
        updateSlots();

       _frame.add( _panel);
       _frame.pack();
       _frame.setVisible( true );
    }

    private void initPanel()
    {
        initIcons();
        _spin.addActionListener( this );
        _panel.add( _spin);

        _panel.add( _slot1);
        _panel.add( _slot2);
        _panel.add( _slot3 );
    }

    private void initIcons()
    {
        try {
            _iconCherry = createIcon("cherry.jpg");
            _iconSeven = createIcon("Lucky7.jpg");
            _iconOrange = createIcon("Orange.jpg");
        }
        catch ( Exception ex )
        {
            System.out.println( ex.getStackTrace() );

        }
    }


    private void updateSlots()
    {
        updateSlotLabel( _slot1 );
        updateSlotLabel( _slot2 );
        updateSlotLabel( _slot3 );
    }

    private void updateSlotLabel( JLabel slotLabel )
    {
        Random rand = new Random();
        int slot = rand.nextInt( 3) ;
        Icon ic = getSlotIcon(( slot )) ;
        slotLabel.setIcon( ic );
    }

    private JLabel getSlotImage( int slotID )
    {
        System.out.println("slot id: " + slotID);
        JLabel label = null;
         if ( slotID == _slotCherryID )
         {
            label = _slotCherry;
         }
        else if ( slotID == _slotSevenID )
         {
             label = _slotSeven;
         }
         else if ( slotID == _slotOrangeID )
         {
             label = _slotOrange;
         }
         return label;
    }

    private Icon getSlotIcon(int slotID )
    {
        System.out.println("slot id: " + slotID);
        Icon ic = null;
        if ( slotID == _slotCherryID )
        {
            ic = _iconCherry;
        }
        else if ( slotID == _slotSevenID )
        {
            ic = _iconSeven;
        }
        else if ( slotID == _slotOrangeID )
        {
            ic = _iconOrange;
        }
        return ic;
    }

    private JLabel createLabelImage(String fileName)  {
        URL imageURL = getClass().getResource(fileName);
        if (imageURL == null){
            System.err.println("Could not find image " + fileName);
            return new JLabel();
        }
        Icon icon = new ImageIcon(imageURL);
        JLabel imageLabel = new JLabel(icon);
        return imageLabel;
    }

    private Icon createIcon(String fileName)  {
        URL imageURL = getClass().getResource(fileName);
        if (imageURL == null){
            System.err.println("Could not find image " + fileName);
            return null;
        }
        return new ImageIcon(imageURL);
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        updateSlots();
    }
}
