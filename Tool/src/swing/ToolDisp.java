package swing;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ToolDisp extends JFrame {

	private int i = 0;
	private int sizeX = 700;
	private int sizeY = 700;

	private JPanel jPanel = new JPanel();
	private JLabel jLabel = new JLabel("hoge");
	private JButton jButton = new JButton("hoge");
	private JTextArea jTextArea = new JTextArea("hoge");

	public ToolDisp(String title) {
		// タイトル設定
		setTitle(title);
		// 画面サイズ
		setSize(sizeX, sizeY);
		// ウィンドウクローズでjava停止
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 画面中央に表示
		setLocationRelativeTo(null);

		// テキストエリアのサイズ設定
		jTextArea.setPreferredSize(new Dimension(sizeX - 500, sizeY - 500));
		// フォーカスリスナ
		jTextArea.addFocusListener(new TxtAreaListener());
		// アクションリスナ
		jButton.addActionListener(new BtnListener());
		// レイアウト設置
		jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));

		// オブジェクトの配置
		jPanel.add(jLabel);
		jPanel.add(jTextArea);
		jPanel.add(jButton);

		Container container = getContentPane();
		container.add(jPanel);

	}

	public static void main(String[] args) {
		ToolDisp toolDisp = new ToolDisp("Title");
		toolDisp.setVisible(true);
	}

	class BtnListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(jTextArea.getText());
			i ++;
			jTextArea.setText("hoge:" + i);
		}

	}

	class TxtAreaListener implements FocusListener {

		@Override
		public void focusGained(FocusEvent e) {
			jTextArea.selectAll();
		}

		@Override
		public void focusLost(FocusEvent e) {

		}

	}

}
