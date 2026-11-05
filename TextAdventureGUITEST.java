package Labs;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextAdventureGUITEST {

    // UI Components
    private JFrame window;
    private JTextArea roomDescArea, outputArea;
    private JTextField inputField;
    private JLabel RoomLabel;
    private JButton InventoryButton;

    private Color backgroundColor = new Color(173, 121, 92); //light brown
    private Color textColor = new Color(80, 48, 48); // Dark Brown Color
    private Color panelColor = new Color(218, 190, 140); //Sandy brown color
    private Color labelColor = new Color(113, 72, 65); //second darkest brown color
    
    // Game State Variables
    public RoomTest location = GameTest.getLocation();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TextAdventureGUITEST().createAndShowGUI());
    }

    public void createAndShowGUI() {
        // 1. Setup the main game window
        window = new JFrame("Swipe Dad's Car - Text Adventure");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(backgroundColor);
        ((JComponent) window.getContentPane()).setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50)); // Add a border to the window
        window.setLayout(new BorderLayout(50, 50)); // Custom absolute layout for retro precision

        // 2. Setup the Top/Player Stats Bar
        JPanel statsPanel = new JPanel();
        //statsPanel.setBounds(50, 20, 700, 40);
        statsPanel.setBackground(panelColor);
        statsPanel.setLayout(new GridLayout(1, 2));

        RoomLabel = new JLabel("Location: " + location.getName());
        RoomLabel.setForeground(labelColor);
        RoomLabel.setFont(new Font("Courier New", Font.PLAIN, 20));

        InventoryButton = new JButton("Inventory");
        InventoryButton.setBackground(backgroundColor);
        InventoryButton.setForeground(labelColor);
        InventoryButton.setBorder(BorderFactory.createLineBorder(labelColor, 1));
        InventoryButton.setFont(new Font("Courier New", Font.PLAIN, 20));
        InventoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle inventory button click
                outputArea.append(GameTest.getInventory());
            }
        });
        statsPanel.add(InventoryButton);
        statsPanel.add(RoomLabel);
        statsPanel.setBorder(BorderFactory.createLineBorder(labelColor, 3));

        window.add(statsPanel, BorderLayout.NORTH);
        
        //input area
        inputField = new JTextField();
        //inputField.setBounds(50, 360, 700, 40);
        inputField.setBackground(panelColor);
        inputField.setForeground(textColor);
        inputField.setFont(new Font("Courier New", Font.PLAIN, 22));
        inputField.setBorder(BorderFactory.createLineBorder(labelColor, 3));
        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = inputField.getText();
                if (!command.trim().isEmpty())
                    GameTest.runGame(command);
                inputField.setText("");
            }
        });

        window.add(inputField, BorderLayout.SOUTH);

        // 3. Setup the Main Text Story Area
        JPanel outputPanel = new JPanel();
       //outputPanel.setBounds(50, 90, 700, 250);
        outputPanel.setBackground(panelColor);
        outputPanel.setBorder(BorderFactory.createLineBorder(labelColor, 3));
        
        roomDescArea = new JTextArea();
        //roomDescArea.setBounds(50, 90, 700, 250);
        roomDescArea.setBackground(panelColor);
        roomDescArea.setForeground(textColor);
        roomDescArea.setFont(new Font("Courier New", Font.PLAIN, 22));
        roomDescArea.setLineWrap(true);
        roomDescArea.setWrapStyleWord(true);
        roomDescArea.setEditable(false);
        roomDescArea.setBorder(BorderFactory.createLineBorder(labelColor, 3));
        
        outputPanel.setLayout(new GridLayout(2,1));

        JScrollPane roomscroll = new JScrollPane(roomDescArea);
        roomscroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        roomscroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        outputPanel.add(roomscroll);
        
        //outputPanel.add(roomDescArea);

        outputArea = new JTextArea();
        //outputArea.setBounds(50, 90, 700, 500);
        outputArea.setBackground(panelColor);
        outputArea.setForeground(textColor);
        outputArea.setFont(new Font("Courier New", Font.PLAIN, 22));
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        outputArea.setEditable(false);
        outputArea.setBorder(BorderFactory.createLineBorder(labelColor, 3));

        JScrollPane scroll = new JScrollPane(outputArea);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        outputPanel.add(scroll);

        //outputPanel.add(outputArea, BorderLayout.SOUTH);
        
        window.add(outputPanel, BorderLayout.CENTER);

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
    public void updateGameText(String text) {
        outputArea.setText(""); // Clear previous output
        roomDescArea.setText(""); // Clear previous room description
        RoomLabel.setText("Location: " + GameTest.getLocation().getName());
        roomDescArea.setText(GameTest.getLocation().getDesc());
        outputArea.append(GameTest.getInputLog());
        outputArea.append("\n"+text);
    }

        // // 4. Setup the Action / Choice Button Panel
        // choiceButtonPanel = new JPanel();
        // choiceButtonPanel.setBounds(50, 380, 700, 150);
        // choiceButtonPanel.setBackground(Color.BLACK);
        // choiceButtonPanel.setLayout(new GridLayout(4, 1, 0, 10)); // 4 choices maximum vertically
        // window.add(choiceButtonPanel);

    //     // Transition to the initial game scene
    //     goToScene(location.getName());

    //     window.setVisible(true);
    // }

    // // Story and State Navigation Controller
    // private void goToScene(String position) {
    //     position = location.getName(); // Update position based on current room name
        
    //     // Refresh and clear choice buttons for the new scene
    //     // choiceButtonPanel.removeAll();

        // switch (position) {
        //     case "LivingRoom":
        //         mainTextArea.setText(RoomTest.RoomTestMap.get("LivingRoom"));
        //         addChoiceButton("Go to Kitchen", "Kitchen");
        //         addChoiceButton("Go to Bedroom", "Bedroom");
        //         addChoiceButton("Go to Office", "Office");
        //         break;

        //     case "gameOver":
        //         mainTextArea.setText("You perished in battle...\n\nGAME OVER.");
        //         // No more options available
        //         break;
        // }

        // // Inform Java Swing to repaint the UI modifications cleanly
        // choiceButtonPanel.revalidate();
        // choiceButtonPanel.repaint();
    }

    // Helper to generate choice buttons dynamically
    // private void addChoiceButton(String text, String targetScene) {
    //     JButton button = new JButton(text);
    //     button.setBackground(Color.BLACK);
    //     button.setForeground(Color.WHITE);
    //     button.setFont(new Font("Courier New", Font.PLAIN, 18));
    //     button.setFocusPainted(false);
        
    //     // Assign event handler to trigger the target scene routing
    //     button.addActionListener(new ActionListener() {
    //         @Override
    //         public void actionPerformed(ActionEvent e) {
    //             goToScene(targetScene);
    //         }
    //     });
        
    //     choiceButtonPanel.add(button);
    // }

//     // Synchronize current data with the visual UI components
//     private void updateStats() {
//         hpLabel.setText(String.valueOf(playerHP));
//         RoomLabel.setText(location.getName().toString());
//     }
// }

