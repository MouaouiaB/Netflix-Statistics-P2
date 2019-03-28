package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class UserInterface implements Runnable {
    private JFrame frame;
    private JTabbedPane Tabs;
    private JTabbedPane SideTabs;
    private AddListener addListener;
    private DeleteListener deleteListener;
    private UpdateListener updateListener;
    private OverViewListener overViewListener;


    public UserInterface(){
        this.addListener = new AddListener();
        this.deleteListener = new DeleteListener();
        this.updateListener = new UpdateListener();
        this.overViewListener = new OverViewListener();
    }
    @Override
    public void run() {
        frame = new JFrame ("NetflixStatistics");
        frame.setPreferredSize(new Dimension(1000, 500));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);


    }

    private void createComponents(Container contentPane) {
        contentPane.setLayout(new BorderLayout());
        this.Tabs = new JTabbedPane();

        this.Tabs.setFont(new Font("Overview", Font.BOLD|Font.BOLD, 20 ));



        JPanel Account = new JPanel();

        this.Tabs.addTab("Toevoegen",addListener);
        Account.setLayout(new GridLayout(2,1,0,0));



        this.Tabs.addTab("Verwijderen",deleteListener);
        this.Tabs.addTab("Wijzigen",updateListener);
        this.Tabs.addTab("Overzicht",overViewListener);
        this.Tabs.addTab("Statestieken",overViewListener);

        contentPane.add(this.Tabs);



    }
}
