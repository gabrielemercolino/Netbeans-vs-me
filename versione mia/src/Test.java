
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.EventQueue;

import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.LayoutStyle.ComponentPlacement.RELATED;

public class Test extends JFrame {

    public Test() {

        initUI();
    }

    private void initUI() {

        var pane = getContentPane();
        var layout = new GroupLayout(pane);
        pane.setLayout(layout);

        var label = new JLabel("Name:");
        var field = new JTextField(15);

        GroupLayout.SequentialGroup sequencialGroup = layout.createSequentialGroup();

        sequencialGroup.addComponent(label).addPreferredGap(RELATED).addComponent(field,
                GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                GroupLayout.PREFERRED_SIZE);

        layout.setHorizontalGroup(sequencialGroup);

        GroupLayout.ParallelGroup pg = layout.createParallelGroup(
                LEADING, false);

        pg.addComponent(label).addComponent(field);
        layout.setVerticalGroup(pg);

        layout.setAutoCreateContainerGaps(true);

        pack();

        setTitle("Simple");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            var ex = new Test();
            ex.setVisible(true);
        });
    }
}
