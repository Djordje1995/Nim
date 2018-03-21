package etf.nim.bd140657d;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

@SuppressWarnings("serial")
public class Aplikacija extends JFrame {
	boolean covekCovek, covekMasina, masinaMasina, jednostavan, komplikovani, profesionalni, lak, normalan, tezak;
	public int brojStubova = 0;
	public int[] zetoni = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	public int[] stari = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	public int pos;
	public int value;
	public int stariBroj = 10;
	Algoritmi alg;
	Bot bot1;
	Bot bot2;
	BotAB botab1;
	BotAB botab2;
	Pro pro1;
	Pro pro2;
	JPanel panelPrvi;
	JPanel panelDrugi;
	JPanel panelTreci;
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	JPanel panel4;
	JPanel panel5;
	JButton button;
	JTextArea area;
	JRadioButton cc;
	JRadioButton cm;
	JRadioButton mm;
	JRadioButton simple;
	JRadioButton advanced;
	JRadioButton pro;
	JLabel labela1;
	JLabel labela2;

	JLabel labela3;
	JLabel labela4;
	JLabel prazna1, prazna2;
	JTextField tekstfield1;
	JTextField tekstfieldarray;
	JTextField tf1;
	JTextField tf2;
	JTextField tf3;
	JTextField tf4;
	JTextField tf5;
	JTextField tf6;
	JTextField tf7;
	JTextField tf8;
	JTextField tf9;
	JTextField tf10;

	JLabel labela5, labela6, labela7;
	JRadioButton easy, medium, hard;
	int level;

	ButtonGroup grupa1;
	ButtonGroup grupa2;
	ButtonGroup grupa3;

	boolean bioBreak;
	///////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////// za 1. panel

	JPanel p21, p22, p23;
	// za 3. od 2.
	JPanel p231, p232, p233;
	JPanel pan1, pan2, pan3, pan4;
	JTextArea ta31, ta32;
	JButton b331, b332;

	JPanel p1, p2, p3, p4, p5, p6, p7, p8, p9, p10;
	JTextField tf11, tf12, tf13, tf14, tf15, tf16, tf17, tf18, tf19, tf110;
	JTextField tf21, tf22, tf23, tf24, tf25, tf26, tf27, tf28, tf29, tf210;
	JTextField tf31, tf32, tf33, tf34, tf35, tf36, tf37, tf38, tf39, tf310;
	JTextField tf41, tf42, tf43, tf44, tf45, tf46, tf47, tf48, tf49, tf410;
	JTextField tf51, tf52, tf53, tf54, tf55, tf56, tf57, tf58, tf59, tf510;
	JTextField tf61, tf62, tf63, tf64, tf65, tf66, tf67, tf68, tf69, tf610;
	JTextField tf71, tf72, tf73, tf74, tf75, tf76, tf77, tf78, tf79, tf710;
	JTextField tf81, tf82, tf83, tf84, tf85, tf86, tf87, tf88, tf89, tf810;
	JTextField tf91, tf92, tf93, tf94, tf95, tf96, tf97, tf98, tf99, tf910;
	JTextField tf101, tf102, tf103, tf104, tf105, tf106, tf107, tf108, tf109, tf1010;

	public Aplikacija() {
		super("Nim");
		panelPrvi = new JPanel(new GridLayout(5, 1));

		covekCovek = false;
		covekMasina = false;
		masinaMasina = false;
		jednostavan = false;
		komplikovani = false;
		profesionalni = false;
		lak = false;
		normalan = false;
		tezak = false;

		alg = new Algoritmi();
		
		panel1 = new JPanel(new GridLayout(4, 2));
		panel2 = new JPanel(new GridLayout(3, 10));
		panel3 = new JPanel(new GridLayout(2, 3));
		panel4 = new JPanel(new GridLayout(1, 1));
		panel5 = new JPanel(new GridLayout(1, 1));
		panelPrvi.add(panel1);
		panelPrvi.add(panel2);
		panelPrvi.add(panel3);
		panelPrvi.add(panel4);
		panelPrvi.add(panel5);
		labela1 = new JLabel("Izbor igraca:");
		labela2 = new JLabel("Izbor bota:");
		labela3 = new JLabel("Broj stubova:");
		labela4 = new JLabel("Broj zetona:");
		prazna1 = new JLabel("         ");
		prazna2 = new JLabel("         ");
		tekstfield1 = new JTextField();
		tekstfield1.setText("");
		tf1 = new JTextField();
		tf2 = new JTextField();
		tf3 = new JTextField();
		tf4 = new JTextField();
		tf5 = new JTextField();
		tf6 = new JTextField();
		tf7 = new JTextField();
		tf8 = new JTextField();
		tf9 = new JTextField();
		tf10 = new JTextField();

		labela5 = new JLabel("Tezina bota:");
		labela6 = new JLabel("           ");
		labela7 = new JLabel("           ");
		easy = new JRadioButton("easy");
		medium = new JRadioButton("medium");
		hard = new JRadioButton("hard");

		button = new JButton("Play");
		area = new JTextArea();
		area.setEnabled(false);

		cc = new JRadioButton("covek-covek:");
		cm = new JRadioButton("covek-masina:");
		mm = new JRadioButton("masina-masina:");
		grupa1 = new ButtonGroup();
		grupa1.add(cc);
		grupa1.add(cm);
		grupa1.add(mm);

		simple = new JRadioButton("simple:");
		advanced = new JRadioButton("advanced:");
		pro = new JRadioButton("pro:");
		grupa2 = new ButtonGroup();
		grupa2.add(simple);
		grupa2.add(advanced);
		grupa2.add(pro);

		this.add(panelPrvi);
		///////////////////////////////////////////////////////////////////////////////////////////////////////////
		panel1.add(labela1); // pocetak panela 1
		panel1.add(labela2);
		panel1.add(cc);
		panel1.add(simple);
		simple.setEnabled(false);
		panel1.add(cm);
		panel1.add(advanced);
		advanced.setEnabled(false);
		panel1.add(mm);
		panel1.add(pro);
		pro.setEnabled(false);

		cc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				simple.setEnabled(false);
				advanced.setEnabled(false);
				pro.setEnabled(false);
				easy.setEnabled(false);
				medium.setEnabled(false);
				hard.setEnabled(false);
			}
		});

		cm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				simple.setEnabled(true);
				advanced.setEnabled(true);
				pro.setEnabled(true);
				easy.setEnabled(true);
				medium.setEnabled(true);
				hard.setEnabled(true);
			}
		});

		mm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				simple.setEnabled(true);
				advanced.setEnabled(true);
				pro.setEnabled(true);
				easy.setEnabled(true);
				medium.setEnabled(true);
				hard.setEnabled(true);
			}
		});

		// kraj panela 1
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// panel 2
		panel2.add(labela3);
		panel2.add(tekstfield1);
		tekstfield1.setText("");
		panel2.add(labela4);
		panel2.add(prazna1);
		panel2.add(prazna2);
		panel2.add(tf1);
		tf1.setEditable(false);
		panel2.add(tf2);
		tf2.setEditable(false);
		panel2.add(tf3);
		tf3.setEditable(false);
		panel2.add(tf4);
		tf4.setEditable(false);
		panel2.add(tf5);
		tf5.setEditable(false);
		panel2.add(tf6);
		tf6.setEditable(false);
		panel2.add(tf7);
		tf7.setEditable(false);
		panel2.add(tf8);
		tf8.setEditable(false);
		panel2.add(tf9);
		tf9.setEditable(false);
		panel2.add(tf10);
		tf10.setEditable(false);

		tf1.setText("");
		tf2.setText("");
		tf3.setText("");
		tf4.setText("");
		tf5.setText("");
		tf6.setText("");
		tf7.setText("");
		tf8.setText("");
		tf9.setText("");
		tf10.setText("");

		tekstfield1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Pattern p = Pattern.compile("([0-9]*)");
				Matcher m = p.matcher(tekstfield1.getText());

				if (m.matches()) {
					brojStubova = Integer.parseInt(tekstfield1.getText());

					if (brojStubova < 1 || brojStubova > 10) {
						area.setText("Neodgovarajuc broj Stubova!!!!!!!");
						tf1.setEditable(false);
						tf2.setEditable(false);
						tf3.setEditable(false);
						tf4.setEditable(false);
						tf5.setEditable(false);
						tf6.setEditable(false);
						tf7.setEditable(false);
						tf8.setEditable(false);
						tf9.setEditable(false);
						tf10.setEditable(false);
					} else {
						for (int i = 1; i <= 10; i++) {
							switch (i) {
							case 1:
								if (i <= brojStubova)
									tf1.setEditable(true);
								else
									tf1.setEditable(false);
								break;
							case 2:
								if (i <= brojStubova)
									tf2.setEditable(true);
								else
									tf2.setEditable(false);
								break;
							case 3:
								if (i <= brojStubova)
									tf3.setEditable(true);
								else
									tf3.setEditable(false);
								break;
							case 4:
								if (i <= brojStubova)
									tf4.setEditable(true);
								else
									tf4.setEditable(false);
								break;
							case 5:
								if (i <= brojStubova)
									tf5.setEditable(true);
								else
									tf5.setEditable(false);
								break;
							case 6:
								if (i <= brojStubova)
									tf6.setEditable(true);
								else
									tf6.setEditable(false);
								break;
							case 7:
								if (i <= brojStubova)
									tf7.setEditable(true);
								else
									tf7.setEditable(false);
								break;
							case 8:
								if (i <= brojStubova)
									tf8.setEditable(true);
								else
									tf8.setEditable(false);
								break;
							case 9:
								if (i <= brojStubova)
									tf9.setEditable(true);
								else
									tf9.setEditable(false);
								break;
							case 10:
								if (i <= brojStubova)
									tf10.setEditable(true);
								else
									tf10.setEditable(false);
								break;
							default:
								area.setText("Neodgovarajuc broj Stubova!!!!!!!");
							}
						}
					}
				} else {
					area.setText("Pogresan format!!!!!!!");
					tf1.setEditable(false);
					tf2.setEditable(false);
					tf3.setEditable(false);
					tf4.setEditable(false);
					tf5.setEditable(false);
					tf6.setEditable(false);
					tf7.setEditable(false);
					tf8.setEditable(false);
					tf9.setEditable(false);
					tf10.setEditable(false);
				}
			}

		});
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// panel3
		panel3.add(labela5);
		panel3.add(labela6);
		panel3.add(labela7);
		panel3.add(easy);
		easy.setEnabled(false);
		panel3.add(medium);
		medium.setEnabled(false);
		panel3.add(hard);
		hard.setEnabled(false);
		grupa3 = new ButtonGroup();
		grupa3.add(easy);
		grupa3.add(medium);
		grupa3.add(hard);

		///////////////////////////////////////////////////////////////////////////////////////////////////////////////
		panel4.add(area);
		area.setEditable(false);
		area.setEnabled(true);
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		panel5.add(button);
		area.setForeground(Color.RED);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pattern p = Pattern.compile("([0-9]*)");
				Matcher m;
				area.setText("");
				if (tekstfield1.getText().equals("")) {
					area.setText("nije unet broj stubova!!!!!!!!!");
				}
				else{
					if(tf1.getText().equals("")) area.setText("nije unet broj zetona!!!!!!!!!");
				}
				for (int i = 1; i <= brojStubova; i++) {
					switch (i) {
					case 1:
						bioBreak = false;
						m = p.matcher(tf1.getText());
						if (tf1.getText().equals("")) {
							area.setText("Nije uneta vrednost u 1. polje za zetone!!!!!!!");
						} else if (!m.matches()) {
							area.setText("Neodgovarajuca vrednost unutar 1. polja za zetone!!!!!!!");
						} else if (1 > Integer.parseInt(tf1.getText()) || Integer.parseInt(tf1.getText()) > 10) {
							area.setText("Vrednost van opsega unutar 1. polja za zetone!!!!!!!!");
						} else {
							for (int j = 0; j < i - 1; j++) {
								if (Integer.parseInt(tf1.getText()) == zetoni[j]) {
									area.setText("Nemoguca pocetna vrednost na 1. polju!!!!!!!!!!!1");
									bioBreak = true;
									break;
								}
							}
							if (bioBreak == false) {
								zetoni[0] = Integer.parseInt(tf1.getText());
							}
						}
						break;
					case 2:
						bioBreak = false;
						m = p.matcher(tf2.getText());
						if (tf2.getText().equals("")) {
							area.setText("Nije uneta vrednost u 2. polje za zetone!!!!!!!");
						} else if (!m.matches()) {
							area.setText("Neodgovarajuca vrednost unutar 2. polja za zetone!!!!!!!");
						} else if (1 > Integer.parseInt(tf2.getText()) || Integer.parseInt(tf2.getText()) > 10) {
							area.setText("Vrednost van opsega unutar 2. polja za zetone!!!!!!!!");
						} else {
							for (int j = 0; j < i - 1; j++) {
								if (Integer.parseInt(tf2.getText()) == zetoni[j]) {
									area.setText("Nemoguca pocetna vrednost na 2. polju!!!!!!!!!!!1");
									bioBreak = true;
									break;
								}
							}
							if (bioBreak == false) {
								zetoni[1] = Integer.parseInt(tf2.getText());
							}
						}
						break;
					case 3:
						bioBreak = false;
						m = p.matcher(tf3.getText());
						if (tf3.getText().equals("")) {
							area.setText("Nije uneta vrednost u 3. polje za zetone!!!!!!!");
						} else if (!m.matches()) {
							area.setText("Neodgovarajuca vrednost unutar 3. polja za zetone!!!!!!!");
						} else if (1 > Integer.parseInt(tf3.getText()) || Integer.parseInt(tf3.getText()) > 10) {
							area.setText("Vrednost van opsega unutar 3. polja za zetone!!!!!!!!");
						} else {
							for (int j = 0; j < i - 1; j++) {
								if (Integer.parseInt(tf3.getText()) == zetoni[j]) {
									area.setText("Nemoguca pocetna vrednost na 3. polju!!!!!!!!!!!1");
									bioBreak = true;
									break;
								}
							}
							if (bioBreak == false) {
								zetoni[2] = Integer.parseInt(tf3.getText());
							}
						}
						break;

					case 4:
						bioBreak = false;
						m = p.matcher(tf4.getText());
						if (tf4.getText().equals("")) {
							area.setText("Nije uneta vrednost u 4. polje za zetone!!!!!!!");
						} else if (!m.matches()) {
							area.setText("Neodgovarajuca vrednost unutar 4. polja za zetone!!!!!!!");
						} else if (1 > Integer.parseInt(tf4.getText()) || Integer.parseInt(tf4.getText()) > 10) {
							area.setText("Vrednost van opsega unutar 4. polja za zetone!!!!!!!!");
						} else {
							for (int j = 0; j < i - 1; j++) {
								if (Integer.parseInt(tf4.getText()) == zetoni[j]) {
									area.setText("Nemoguca pocetna vrednost na 4. polju!!!!!!!!!!!1");
									bioBreak = true;
									break;
								}
							}
							if (bioBreak == false) {
								zetoni[3] = Integer.parseInt(tf4.getText());
							}
						}
						break;

					case 5:
						bioBreak = false;
						m = p.matcher(tf5.getText());
						if (tf5.getText().equals("")) {
							area.setText("Nije uneta vrednost u 5. polje za zetone!!!!!!!");
						} else if (!m.matches()) {
							area.setText("Neodgovarajuca vrednost unutar 5. polja za zetone!!!!!!!");
						} else if (1 > Integer.parseInt(tf5.getText()) || Integer.parseInt(tf5.getText()) > 10) {
							area.setText("Vrednost van opsega unutar 5. polja za zetone!!!!!!!!");
						} else {
							for (int j = 0; j < i - 1; j++) {
								if (Integer.parseInt(tf5.getText()) == zetoni[j]) {
									area.setText("Nemoguca pocetna vrednost na 5. polju!!!!!!!!!!!1");
									bioBreak = true;
									break;
								}
							}
							if (bioBreak == false) {
								zetoni[4] = Integer.parseInt(tf5.getText());
							}
						}
						break;

					case 6:
						bioBreak = false;
						m = p.matcher(tf6.getText());
						if (tf6.getText().equals("")) {
							area.setText("Nije uneta vrednost u 6. polje za zetone!!!!!!!");
						} else if (!m.matches()) {
							area.setText("Neodgovarajuca vrednost unutar 6. polja za zetone!!!!!!!");
						} else if (1 > Integer.parseInt(tf6.getText()) || Integer.parseInt(tf6.getText()) > 10) {
							area.setText("Vrednost van opsega unutar 6. polja za zetone!!!!!!!!");
						} else {
							for (int j = 0; j < i - 1; j++) {
								if (Integer.parseInt(tf6.getText()) == zetoni[j]) {
									area.setText("Nemoguca pocetna vrednost na 6. polju!!!!!!!!!!!1");
									bioBreak = true;
									break;
								}
							}
							if (bioBreak == false) {
								zetoni[5] = Integer.parseInt(tf6.getText());
							}
						}
						break;

					case 7:
						bioBreak = false;
						m = p.matcher(tf7.getText());
						if (tf7.getText().equals("")) {
							area.setText("Nije uneta vrednost u 7. polje za zetone!!!!!!!");
						} else if (!m.matches()) {
							area.setText("Neodgovarajuca vrednost unutar 7. polja za zetone!!!!!!!");
						} else if (1 > Integer.parseInt(tf7.getText()) || Integer.parseInt(tf7.getText()) > 10) {
							area.setText("Vrednost van opsega unutar 7. polja za zetone!!!!!!!!");
						} else {
							for (int j = 0; j < i - 1; j++) {
								if (Integer.parseInt(tf7.getText()) == zetoni[j]) {
									area.setText("Nemoguca pocetna vrednost na 7. polju!!!!!!!!!!!1");
									bioBreak = true;
									break;
								}
							}
							if (bioBreak == false) {
								zetoni[6] = Integer.parseInt(tf7.getText());
							}
						}
						break;

					case 8:
						bioBreak = false;
						m = p.matcher(tf8.getText());
						if (tf8.getText().equals("")) {
							area.setText("Nije uneta vrednost u 8. polje za zetone!!!!!!!");
						} else if (!m.matches()) {
							area.setText("Neodgovarajuca vrednost unutar 8. polja za zetone!!!!!!!");
						} else if (1 > Integer.parseInt(tf8.getText()) || Integer.parseInt(tf8.getText()) > 10) {
							area.setText("Vrednost van opsega unutar 8. polja za zetone!!!!!!!!");
						} else {
							for (int j = 0; j < i - 1; j++) {
								if (Integer.parseInt(tf8.getText()) == zetoni[j]) {
									area.setText("Nemoguca pocetna vrednost na 8. polju!!!!!!!!!!!1");
									bioBreak = true;
									break;
								}
							}
							if (bioBreak == false) {
								zetoni[7] = Integer.parseInt(tf8.getText());
							}
						}
						break;

					case 9:
						bioBreak = false;
						m = p.matcher(tf9.getText());
						if (tf9.getText().equals("")) {
							area.setText("Nije uneta vrednost u 9. polje za zetone!!!!!!!");
						} else if (!m.matches()) {
							area.setText("Neodgovarajuca vrednost unutar 9. polja za zetone!!!!!!!");
						} else if (1 > Integer.parseInt(tf9.getText()) || Integer.parseInt(tf9.getText()) > 10) {
							area.setText("Vrednost van opsega unutar 9. polja za zetone!!!!!!!!");
						} else {
							for (int j = 0; j < i - 1; j++) {
								if (Integer.parseInt(tf9.getText()) == zetoni[j]) {
									area.setText("Nemoguca pocetna vrednost na 9. polju!!!!!!!!!!!1");
									bioBreak = true;
									break;
								}
							}
							if (bioBreak == false) {
								zetoni[8] = Integer.parseInt(tf9.getText());
							}
						}
						break;

					case 10:
						bioBreak = false;
						m = p.matcher(tf10.getText());
						if (tf10.getText().equals("")) {
							area.setText("Nije uneta vrednost u 10. polje za zetone!!!!!!!");
						} else if (!m.matches()) {
							area.setText("Neodgovarajuca vrednost unutar 10. polja za zetone!!!!!!!");
						} else if (1 > Integer.parseInt(tf10.getText()) || Integer.parseInt(tf10.getText()) > 10) {
							area.setText("Vrednost van opsega unutar 10. polja za zetone!!!!!!!!");
						} else {
							for (int j = 0; j < i - 1; j++) {
								if (Integer.parseInt(tf10.getText()) == zetoni[j]) {
									area.setText("Nemoguca pocetna vrednost na 10. polju!!!!!!!!!!!1");
									bioBreak = true;
									break;
								}
							}
							if (bioBreak == false) {
								zetoni[9] = Integer.parseInt(tf10.getText());
							}
						}
						break;
					}
				}
				if (cc.isSelected() || cm.isSelected() || mm.isSelected()) {
					if (cm.isSelected() || mm.isSelected()) {
						if (simple.isSelected() || advanced.isSelected() || pro.isSelected()) {
							if (easy.isSelected() || medium.isSelected() || hard.isSelected()) {
								// area.setText("");
							} else {
								area.setText("Nisu sva polja selektovana!!!!!!!!");
							}
						} else {
							area.setText("Nisu sva polja selektovana!!!!!!!!");
						}
					} else {
						// area.setText("");
					}
				} else {
					area.setText("Nisu sva polja selektovana!!!!!!!!");
				}

				if (!area.getText().equals("")) {

				} else {
					if (cc.isSelected()) {
						covekCovek = true;
						covekMasina = false;
						masinaMasina = false;
						jednostavan = false;
						komplikovani = false;
						profesionalni = false;
						lak = false;
						normalan = false;
						tezak = false;
					} else if (cm.isSelected()) {
						if (simple.isSelected()) {
							if (easy.isSelected()) {
								covekCovek = false;
								covekMasina = true;
								masinaMasina = false;
								jednostavan = true;
								komplikovani = false;
								profesionalni = false;
								lak = true;
								normalan = false;
								tezak = false;
							} else if (medium.isSelected()) {
								covekCovek = false;
								covekMasina = true;
								masinaMasina = false;
								jednostavan = true;
								komplikovani = false;
								profesionalni = false;
								lak = false;
								normalan = true;
								tezak = false;
							} else {
								covekCovek = false;
								covekMasina = true;
								masinaMasina = false;
								jednostavan = true;
								komplikovani = false;
								profesionalni = false;
								lak = false;
								normalan = false;
								tezak = true;
							}
						} else if (advanced.isSelected()) {
							if (easy.isSelected()) {
								covekCovek = false;
								covekMasina = true;
								masinaMasina = false;
								jednostavan = false;
								komplikovani = true;
								profesionalni = false;
								lak = true;
								normalan = false;
								tezak = false;
							} else if (medium.isSelected()) {
								covekCovek = false;
								covekMasina = true;
								masinaMasina = false;
								jednostavan = false;
								komplikovani = true;
								profesionalni = false;
								lak = false;
								normalan = true;
								tezak = false;
							} else {
								covekCovek = false;
								covekMasina = true;
								masinaMasina = false;
								jednostavan = false;
								komplikovani = true;
								profesionalni = false;
								lak = false;
								normalan = false;
								tezak = true;
							}
						} else {
							if (easy.isSelected()) {
								covekCovek = false;
								covekMasina = true;
								masinaMasina = false;
								jednostavan = false;
								komplikovani = false;
								profesionalni = true;
								lak = true;
								normalan = false;
								tezak = false;
							} else if (medium.isSelected()) {
								covekCovek = false;
								covekMasina = true;
								masinaMasina = false;
								jednostavan = false;
								komplikovani = false;
								profesionalni = true;
								lak = false;
								normalan = true;
								tezak = false;
							} else {
								covekCovek = false;
								covekMasina = true;
								masinaMasina = false;
								jednostavan = false;
								komplikovani = false;
								profesionalni = true;
								lak = false;
								normalan = false;
								tezak = true;
							}
						}
					} else if (mm.isSelected()) {
						if (simple.isSelected()) {
							if (easy.isSelected()) {
								covekCovek = false;
								covekMasina = false;
								masinaMasina = true;
								jednostavan = true;
								komplikovani = false;
								profesionalni = false;
								lak = true;
								normalan = false;
								tezak = false;
							} else if (medium.isSelected()) {
								covekCovek = false;
								covekMasina = false;
								masinaMasina = true;
								jednostavan = true;
								komplikovani = false;
								profesionalni = false;
								lak = false;
								normalan = true;
								tezak = false;
							} else {
								covekCovek = false;
								covekMasina = false;
								masinaMasina = true;
								jednostavan = true;
								komplikovani = false;
								profesionalni = false;
								lak = false;
								normalan = false;
								tezak = true;
							}
						} else if (advanced.isSelected()) {
							if (easy.isSelected()) {
								covekCovek = false;
								covekMasina = false;
								masinaMasina = true;
								jednostavan = false;
								komplikovani = true;
								profesionalni = false;
								lak = true;
								normalan = false;
								tezak = false;
							} else if (medium.isSelected()) {
								covekCovek = false;
								covekMasina = false;
								masinaMasina = true;
								jednostavan = false;
								komplikovani = true;
								profesionalni = false;
								lak = false;
								normalan = true;
								tezak = false;
							} else {
								covekCovek = false;
								covekMasina = false;
								masinaMasina = true;
								jednostavan = false;
								komplikovani = true;
								profesionalni = false;
								lak = false;
								normalan = false;
								tezak = true;
							}
						} else {
							if (easy.isSelected()) {
								covekCovek = false;
								covekMasina = false;
								masinaMasina = true;
								jednostavan = false;
								komplikovani = false;
								profesionalni = true;
								lak = true;
								normalan = false;
								tezak = false;
							} else if (medium.isSelected()) {
								covekCovek = false;
								covekMasina = false;
								masinaMasina = true;
								jednostavan = false;
								komplikovani = false;
								profesionalni = true;
								lak = false;
								normalan = true;
								tezak = false;
							} else {
								covekCovek = false;
								covekMasina = false;
								masinaMasina = true;
								jednostavan = false;
								komplikovani = false;
								profesionalni = true;
								lak = false;
								normalan = false;
								tezak = true;
							}
						}
					}
					napravi2();
					promena1();
				}
			}
		});
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////// za 2. panel

		panelDrugi = new JPanel(new GridLayout(2, 1));

		////////////////////

		this.setVisible(true);
		this.setBounds(400, 150, 500, 400);

	}

	public void napravi2() {

		p21 = new JPanel(new GridLayout(1, brojStubova));
		p22 = new JPanel(new GridLayout(4, 1));

		panelDrugi.add(p21);
		panelDrugi.add(p22);
		// panelDrugi.add(p23);

		p1 = new JPanel(new GridLayout(10, 1, 3, 2));
		p2 = new JPanel(new GridLayout(10, 1, 3, 2));
		p3 = new JPanel(new GridLayout(10, 1, 3, 2));
		p4 = new JPanel(new GridLayout(10, 1, 3, 2));
		p5 = new JPanel(new GridLayout(10, 1, 3, 2));
		p6 = new JPanel(new GridLayout(10, 1, 3, 2));
		p7 = new JPanel(new GridLayout(10, 1, 3, 2));
		p8 = new JPanel(new GridLayout(10, 1, 3, 2));
		p9 = new JPanel(new GridLayout(10, 1, 3, 2));
		p10 = new JPanel(new GridLayout(10, 1, 3, 2));

		tf11 = new JTextField();
		tf12 = new JTextField();
		tf13 = new JTextField();
		tf14 = new JTextField();
		tf15 = new JTextField();
		tf16 = new JTextField();
		tf17 = new JTextField();
		tf18 = new JTextField();
		tf19 = new JTextField();
		tf110 = new JTextField();

		tf21 = new JTextField();
		tf22 = new JTextField();
		tf23 = new JTextField();
		tf24 = new JTextField();
		tf25 = new JTextField();
		tf26 = new JTextField();
		tf27 = new JTextField();
		tf28 = new JTextField();
		tf29 = new JTextField();
		tf210 = new JTextField();

		tf31 = new JTextField();
		tf32 = new JTextField();
		tf33 = new JTextField();
		tf34 = new JTextField();
		tf35 = new JTextField();
		tf36 = new JTextField();
		tf37 = new JTextField();
		tf38 = new JTextField();
		tf39 = new JTextField();
		tf310 = new JTextField();

		tf41 = new JTextField();
		tf42 = new JTextField();
		tf43 = new JTextField();
		tf44 = new JTextField();
		tf45 = new JTextField();
		tf46 = new JTextField();
		tf47 = new JTextField();
		tf48 = new JTextField();
		tf49 = new JTextField();
		tf410 = new JTextField();

		tf51 = new JTextField();
		tf52 = new JTextField();
		tf53 = new JTextField();
		tf54 = new JTextField();
		tf55 = new JTextField();
		tf56 = new JTextField();
		tf57 = new JTextField();
		tf58 = new JTextField();
		tf59 = new JTextField();
		tf510 = new JTextField();

		tf61 = new JTextField();
		tf62 = new JTextField();
		tf63 = new JTextField();
		tf64 = new JTextField();
		tf65 = new JTextField();
		tf66 = new JTextField();
		tf67 = new JTextField();
		tf68 = new JTextField();
		tf69 = new JTextField();
		tf610 = new JTextField();

		tf71 = new JTextField();
		tf72 = new JTextField();
		tf73 = new JTextField();
		tf74 = new JTextField();
		tf75 = new JTextField();
		tf76 = new JTextField();
		tf77 = new JTextField();
		tf78 = new JTextField();
		tf79 = new JTextField();
		tf710 = new JTextField();

		tf81 = new JTextField();
		tf82 = new JTextField();
		tf83 = new JTextField();
		tf84 = new JTextField();
		tf85 = new JTextField();
		tf86 = new JTextField();
		tf87 = new JTextField();
		tf88 = new JTextField();
		tf89 = new JTextField();
		tf810 = new JTextField();

		tf91 = new JTextField();
		tf92 = new JTextField();
		tf93 = new JTextField();
		tf94 = new JTextField();
		tf95 = new JTextField();
		tf96 = new JTextField();
		tf97 = new JTextField();
		tf98 = new JTextField();
		tf99 = new JTextField();
		tf910 = new JTextField();

		tf101 = new JTextField();
		tf102 = new JTextField();
		tf103 = new JTextField();
		tf104 = new JTextField();
		tf105 = new JTextField();
		tf106 = new JTextField();
		tf107 = new JTextField();
		tf108 = new JTextField();
		tf109 = new JTextField();
		tf1010 = new JTextField();

		pan1 = new JPanel(new GridLayout(1, brojStubova));
		pan2 = new JPanel(new GridLayout(1, 1));
		pan3 = new JPanel(new GridLayout(1, 1));
		pan4 = new JPanel(new GridLayout(1, 2));

		p22.add(pan1);
		p22.add(pan2);
		p22.add(pan3);
		p22.add(pan4);

		ta31 = new JTextArea("");
		ta32 = new JTextArea("NA POTEZU JE 1. IGRAC");
		b331 = new JButton("Odigraj 1");
		b332 = new JButton("Odigraj 2");
		b332.setEnabled(false);

		if(lak == true){
			level = 2;
		}
		else if(normalan == true){
			level = 4;
		}
		else if(tezak == true){
			level = 8;
		}
		
		if(covekMasina == true){
			if(jednostavan == true){
				bot2 = new Bot(level);
			}
			else if(komplikovani == true){
				botab2 = new BotAB(level);
			}
			else if(profesionalni == true){
				pro2 = new Pro(level);
			}
			
		}
		else if(masinaMasina == true){
			if(jednostavan == true){
				bot1 = new Bot(level);
				bot2 = new Bot(level);
			}
			else if(komplikovani == true){
				botab1 = new BotAB(level);
				botab2 = new BotAB(level);
			}
			else if(profesionalni == true){
				pro1 = new Pro(level);
				pro2 = new Pro(level);
			}
			
		}
		
		b331.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ta31.setText("");
				for (int i = 0; i < brojStubova; i++) {
					stari[i] = zetoni[i];
				}
				int cnt = 0;
				if (covekCovek == true || covekMasina == true) {
					proveraIspravnosti();
					if (ta31.getText().equals("")) {
						stariBroj = value;
						ponovoBoji(pos);
						pos = 0;
						b332.setEnabled(true);
						b331.setEnabled(false);
						ta32.setText("NA POTEZU JE 2. IGRAC!");
						for (int i = 0; i < brojStubova; i++) {
							stari[i] = zetoni[i];
							if (zetoni[i] == 0)
								cnt++;
						}
						if (cnt == brojStubova) {
							ta32.setText("POBEDNIK JE 1. IGRAC!");
							b332.setEnabled(false);
							cnt = 0;
						}

					} else {
						for (int i = 0; i < brojStubova; i++) {
							zetoni[i] = stari[i];
						}
						// ta31.setText("");
					}
				}
				else{
					boolean bioBreak2 = false;
					
					if(jednostavan == true){
						bot1.formirajStablo(zetoni, stariBroj, brojStubova, 0);
						Cvor prvi = bot1.koren.deca.getFirst();

						for(Cvor c : prvi.deca){
							if(prvi.value == c.value){
								for(int i =0; i<brojStubova; i++){
									zetoni[i] = c.zetoni[i];
									if(zetoni[i] != stari[i]){
										pos = i;
										stariBroj = stari[i] - zetoni[i];
										bioBreak2 = true;
										break;
									}
								}
							}
							if(bioBreak2 == true) break;
						}
					}
					else if(komplikovani == true){
						botab1.formirajStablo(zetoni, stariBroj, brojStubova, 0);
						CvorAB prvi = botab1.koren.deca.getFirst();

						for(CvorAB c : prvi.deca){
							if(prvi.value == c.value){
								for(int i =0; i<brojStubova; i++){
									zetoni[i] = c.zetoni[i];
									if(zetoni[i] != stari[i]){
										pos = i;
										stariBroj = stari[i] - zetoni[i];
										bioBreak2 = true;
										break;
									}
								}
							}
							if(bioBreak2 == true) break;
						}
					}
					else if(profesionalni == true){
						pro1.formirajStablo(zetoni, stariBroj, brojStubova, 0);
						CvorAB prvi = pro1.koren.deca.getFirst();

						for(CvorAB c : prvi.deca){
							if(prvi.value == c.value){
								for(int i =0; i<brojStubova; i++){
									zetoni[i] = c.zetoni[i];
									if(zetoni[i] != stari[i]){
										pos = i;
										stariBroj = stari[i] - zetoni[i];
										bioBreak2 = true;
										break;
									}
								}
							}
							if(bioBreak2 == true) break;
						}
					}
					
					
					
					
					ponovoBoji(pos);
					pos = 0;
					for (int i = 0; i < brojStubova; i++) {
						stari[i] = zetoni[i];
						if (zetoni[i] == 0)
							cnt++;
					}
					if (cnt == brojStubova) {
						ta32.setText("POBEDNIK JE 1. IGRAC!");
						b331.setEnabled(false);
						cnt = 0;
					}
					else{
						b332.setEnabled(true);
						b331.setEnabled(false);
						ta32.setText("NA POTEZU JE 2. IGRAC!");
					}
					
					
					if(jednostavan == true){
						bot1.unisti();
					}
					else if(komplikovani == true){
						botab1.unisti();
					}
					else if(profesionalni == true){
						pro1.unisti();
					}
					
				}
			}
		});

		b332.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ta31.setText("");
				for (int i = 0; i < brojStubova; i++) {
					stari[i] = zetoni[i];
				}
				int cnt = 0;
				if (covekCovek == true) {
					proveraIspravnosti();
					if (ta31.getText().equals("")) {
						stariBroj = value;
						ponovoBoji(pos);
						pos = 0;

						b332.setEnabled(false);
						b331.setEnabled(true);
						ta32.setText("NA POTEZU JE 1. IGRAC!");
						for (int i = 0; i < brojStubova; i++) {
							stari[i] = zetoni[i];
							if (zetoni[i] == 0)
								cnt++;
						}
						if (cnt == brojStubova) {
							ta32.setText("POBEDNIK JE 2. IGRAC!");
							b331.setEnabled(false);
							cnt = 0;
						}

					} else {
						for (int i = 0; i < brojStubova; i++) {
							zetoni[i] = stari[i];
						}
						// ta31.setText("");
					}
				}
				else{
					boolean bioBreak2 = false;
					
					if(jednostavan == true){
						bot2.formirajStablo(zetoni, stariBroj, brojStubova, 0);
						Cvor prvi = bot2.koren.deca.getFirst();

						for(Cvor c : prvi.deca){
							if(prvi.value == c.value){
								for(int i =0; i<brojStubova; i++){
									zetoni[i] = c.zetoni[i];
									if(zetoni[i] != stari[i]){
										pos = i;
										stariBroj = stari[i] - zetoni[i];
										bioBreak2 = true;
										break;
									}
								}
							}
							if(bioBreak2 == true) break;
						}
					}
					else if(komplikovani == true){
						botab2.formirajStablo(zetoni, stariBroj, brojStubova, 0);
						CvorAB prvi = botab2.koren.deca.getFirst();

						for(CvorAB c : prvi.deca){
							if(prvi.value == c.value){
								for(int i =0; i<brojStubova; i++){
									zetoni[i] = c.zetoni[i];
									if(zetoni[i] != stari[i]){
										pos = i;
										stariBroj = stari[i] - zetoni[i];
										bioBreak2 = true;
										break;
									}
								}
							}
							if(bioBreak2 == true) break;
						}
					}
					else if(profesionalni == true){
						pro2.formirajStablo(zetoni, stariBroj, brojStubova, 0);
						CvorAB prvi = pro2.koren.deca.getFirst();

						for(CvorAB c : prvi.deca){
							if(prvi.value == c.value){
								for(int i =0; i<brojStubova; i++){
									zetoni[i] = c.zetoni[i];
									if(zetoni[i] != stari[i]){
										pos = i;
										stariBroj = stari[i] - zetoni[i];
										bioBreak2 = true;
										break;
									}
								}
							}
							if(bioBreak2 == true) break;
						}
					}
					
					ponovoBoji(pos);
					pos = 0;
					for (int i = 0; i < brojStubova; i++) {
						stari[i] = zetoni[i];
						if (zetoni[i] == 0)
							cnt++;
					}
					if (cnt == brojStubova) {
						ta32.setText("POBEDNIK JE 2. IGRAC!");
						b331.setEnabled(false);
						cnt = 0;
					}
					else{
						b332.setEnabled(false);
						b331.setEnabled(true);
						ta32.setText("NA POTEZU JE 1. IGRAC!");
					}
					
					if(jednostavan == true){
						bot2.unisti();
					}
					else if(komplikovani == true){
						botab2.unisti();
					}
					else if(profesionalni == true){
						pro2.unisti();
					}
					
				}
			}
		});

		ta31.setEditable(false);
		ta31.setEnabled(true);
		ta32.setEditable(false);
		ta32.setEnabled(true);

		pan2.add(ta31);
		pan3.add(ta32);
		pan4.add(b331);
		pan4.add(b332);

		// tf11.setBackground(Color.BLUE);

		for (int k = 0; k < brojStubova; k++) {
			switch (k) {
			case 0:
				pan1.add(tf1);
				tf1.setText("");
				p21.add(p1);
				p1.add(tf11);
				p1.add(tf12);
				p1.add(tf13);
				p1.add(tf14);
				p1.add(tf15);
				p1.add(tf16);
				p1.add(tf17);
				p1.add(tf18);
				p1.add(tf19);
				p1.add(tf110);
				for (int m = 1; m <= zetoni[0]; m++) {
					switch (m) {
					case 1:
						tf110.setBackground(Color.BLUE);
						break;
					case 2:
						tf19.setBackground(Color.BLUE);
						break;
					case 3:
						tf18.setBackground(Color.BLUE);
						break;
					case 4:
						tf17.setBackground(Color.BLUE);
						break;
					case 5:
						tf16.setBackground(Color.BLUE);
						break;
					case 6:
						tf15.setBackground(Color.BLUE);
						break;
					case 7:
						tf14.setBackground(Color.BLUE);
						break;
					case 8:
						tf13.setBackground(Color.BLUE);
						break;
					case 9:
						tf12.setBackground(Color.BLUE);
						break;
					case 10:
						tf11.setBackground(Color.BLUE);
						break;
					}
				}
				break;
			case 1:
				pan1.add(tf2);
				tf2.setText("");
				p21.add(p2);
				p2.add(tf21);
				p2.add(tf22);
				p2.add(tf23);
				p2.add(tf24);
				p2.add(tf25);
				p2.add(tf26);
				p2.add(tf27);
				p2.add(tf28);
				p2.add(tf29);
				p2.add(tf210);
				for (int m = 1; m <= zetoni[1]; m++) {
					switch (m) {
					case 1:
						tf210.setBackground(Color.BLUE);
						break;
					case 2:
						tf29.setBackground(Color.BLUE);
						break;
					case 3:
						tf28.setBackground(Color.BLUE);
						break;
					case 4:
						tf27.setBackground(Color.BLUE);
						break;
					case 5:
						tf26.setBackground(Color.BLUE);
						break;
					case 6:
						tf25.setBackground(Color.BLUE);
						break;
					case 7:
						tf24.setBackground(Color.BLUE);
						break;
					case 8:
						tf23.setBackground(Color.BLUE);
						break;
					case 9:
						tf22.setBackground(Color.BLUE);
						break;
					case 10:
						tf21.setBackground(Color.BLUE);
						break;
					}
				}
				break;
			case 2:
				pan1.add(tf3);
				tf3.setText("");
				p21.add(p3);
				p3.add(tf31);
				p3.add(tf32);
				p3.add(tf33);
				p3.add(tf34);
				p3.add(tf35);
				p3.add(tf36);
				p3.add(tf37);
				p3.add(tf38);
				p3.add(tf39);
				p3.add(tf310);
				for (int m = 1; m <= zetoni[2]; m++) {
					switch (m) {
					case 1:
						tf310.setBackground(Color.BLUE);
						break;
					case 2:
						tf39.setBackground(Color.BLUE);
						break;
					case 3:
						tf38.setBackground(Color.BLUE);
						break;
					case 4:
						tf37.setBackground(Color.BLUE);
						break;
					case 5:
						tf36.setBackground(Color.BLUE);
						break;
					case 6:
						tf35.setBackground(Color.BLUE);
						break;
					case 7:
						tf34.setBackground(Color.BLUE);
						break;
					case 8:
						tf33.setBackground(Color.BLUE);
						break;
					case 9:
						tf32.setBackground(Color.BLUE);
						break;
					case 10:
						tf31.setBackground(Color.BLUE);
						break;
					}
				}
				break;
			case 3:
				pan1.add(tf4);
				tf4.setText("");
				p21.add(p4);
				p4.add(tf41);
				p4.add(tf42);
				p4.add(tf43);
				p4.add(tf44);
				p4.add(tf45);
				p4.add(tf46);
				p4.add(tf47);
				p4.add(tf48);
				p4.add(tf49);
				p4.add(tf410);
				for (int m = 1; m <= zetoni[3]; m++) {
					switch (m) {
					case 1:
						tf410.setBackground(Color.BLUE);
						break;
					case 2:
						tf49.setBackground(Color.BLUE);
						break;
					case 3:
						tf48.setBackground(Color.BLUE);
						break;
					case 4:
						tf47.setBackground(Color.BLUE);
						break;
					case 5:
						tf46.setBackground(Color.BLUE);
						break;
					case 6:
						tf45.setBackground(Color.BLUE);
						break;
					case 7:
						tf44.setBackground(Color.BLUE);
						break;
					case 8:
						tf43.setBackground(Color.BLUE);
						break;
					case 9:
						tf42.setBackground(Color.BLUE);
						break;
					case 10:
						tf41.setBackground(Color.BLUE);
						break;
					}
				}
				break;
			case 4:
				pan1.add(tf5);
				tf5.setText("");
				p21.add(p5);
				p5.add(tf51);
				p5.add(tf52);
				p5.add(tf53);
				p5.add(tf54);
				p5.add(tf55);
				p5.add(tf56);
				p5.add(tf57);
				p5.add(tf58);
				p5.add(tf59);
				p5.add(tf510);
				for (int m = 1; m <= zetoni[4]; m++) {
					switch (m) {
					case 1:
						tf510.setBackground(Color.BLUE);
						break;
					case 2:
						tf59.setBackground(Color.BLUE);
						break;
					case 3:
						tf58.setBackground(Color.BLUE);
						break;
					case 4:
						tf57.setBackground(Color.BLUE);
						break;
					case 5:
						tf56.setBackground(Color.BLUE);
						break;
					case 6:
						tf55.setBackground(Color.BLUE);
						break;
					case 7:
						tf54.setBackground(Color.BLUE);
						break;
					case 8:
						tf53.setBackground(Color.BLUE);
						break;
					case 9:
						tf52.setBackground(Color.BLUE);
						break;
					case 10:
						tf51.setBackground(Color.BLUE);
						break;
					}
				}
				break;
			case 5:
				pan1.add(tf6);
				tf6.setText("");
				p21.add(p6);
				p6.add(tf61);
				p6.add(tf62);
				p6.add(tf63);
				p6.add(tf64);
				p6.add(tf65);
				p6.add(tf66);
				p6.add(tf67);
				p6.add(tf68);
				p6.add(tf69);
				p6.add(tf610);
				for (int m = 1; m <= zetoni[5]; m++) {
					switch (m) {
					case 1:
						tf610.setBackground(Color.BLUE);
						break;
					case 2:
						tf69.setBackground(Color.BLUE);
						break;
					case 3:
						tf68.setBackground(Color.BLUE);
						break;
					case 4:
						tf67.setBackground(Color.BLUE);
						break;
					case 5:
						tf66.setBackground(Color.BLUE);
						break;
					case 6:
						tf65.setBackground(Color.BLUE);
						break;
					case 7:
						tf64.setBackground(Color.BLUE);
						break;
					case 8:
						tf63.setBackground(Color.BLUE);
						break;
					case 9:
						tf62.setBackground(Color.BLUE);
						break;
					case 10:
						tf61.setBackground(Color.BLUE);
						break;
					}
				}
				break;
			case 6:
				pan1.add(tf7);
				tf7.setText("");
				p21.add(p7);
				p7.add(tf71);
				p7.add(tf72);
				p7.add(tf73);
				p7.add(tf74);
				p7.add(tf75);
				p7.add(tf76);
				p7.add(tf77);
				p7.add(tf78);
				p7.add(tf79);
				p7.add(tf710);
				for (int m = 1; m <= zetoni[6]; m++) {
					switch (m) {
					case 1:
						tf710.setBackground(Color.BLUE);
						break;
					case 2:
						tf79.setBackground(Color.BLUE);
						break;
					case 3:
						tf78.setBackground(Color.BLUE);
						break;
					case 4:
						tf77.setBackground(Color.BLUE);
						break;
					case 5:
						tf76.setBackground(Color.BLUE);
						break;
					case 6:
						tf75.setBackground(Color.BLUE);
						break;
					case 7:
						tf74.setBackground(Color.BLUE);
						break;
					case 8:
						tf73.setBackground(Color.BLUE);
						break;
					case 9:
						tf72.setBackground(Color.BLUE);
						break;
					case 10:
						tf71.setBackground(Color.BLUE);
						break;
					}
				}
				break;
			case 7:
				pan1.add(tf8);
				tf8.setText("");
				p21.add(p8);
				p8.add(tf81);
				p8.add(tf82);
				p8.add(tf83);
				p8.add(tf84);
				p8.add(tf85);
				p8.add(tf86);
				p8.add(tf87);
				p8.add(tf88);
				p8.add(tf89);
				p8.add(tf810);
				for (int m = 1; m <= zetoni[7]; m++) {
					switch (m) {
					case 1:
						tf810.setBackground(Color.BLUE);
						break;
					case 2:
						tf89.setBackground(Color.BLUE);
						break;
					case 3:
						tf88.setBackground(Color.BLUE);
						break;
					case 4:
						tf87.setBackground(Color.BLUE);
						break;
					case 5:
						tf86.setBackground(Color.BLUE);
						break;
					case 6:
						tf85.setBackground(Color.BLUE);
						break;
					case 7:
						tf84.setBackground(Color.BLUE);
						break;
					case 8:
						tf83.setBackground(Color.BLUE);
						break;
					case 9:
						tf82.setBackground(Color.BLUE);
						break;
					case 10:
						tf81.setBackground(Color.BLUE);
						break;
					}
				}
				break;
			case 8:
				pan1.add(tf9);
				tf9.setText("");
				p21.add(p9);
				p9.add(tf91);
				p9.add(tf92);
				p9.add(tf93);
				p9.add(tf94);
				p9.add(tf95);
				p9.add(tf96);
				p9.add(tf97);
				p9.add(tf98);
				p9.add(tf99);
				p9.add(tf910);
				for (int m = 1; m <= zetoni[8]; m++) {
					switch (m) {
					case 1:
						tf910.setBackground(Color.BLUE);
						break;
					case 2:
						tf99.setBackground(Color.BLUE);
						break;
					case 3:
						tf98.setBackground(Color.BLUE);
						break;
					case 4:
						tf97.setBackground(Color.BLUE);
						break;
					case 5:
						tf96.setBackground(Color.BLUE);
						break;
					case 6:
						tf95.setBackground(Color.BLUE);
						break;
					case 7:
						tf94.setBackground(Color.BLUE);
						break;
					case 8:
						tf93.setBackground(Color.BLUE);
						break;
					case 9:
						tf92.setBackground(Color.BLUE);
						break;
					case 10:
						tf91.setBackground(Color.BLUE);
						break;
					}
				}
				break;
			case 9:
				pan1.add(tf10);
				tf10.setText("");
				p21.add(p10);
				p10.add(tf101);
				p10.add(tf102);
				p10.add(tf103);
				p10.add(tf104);
				p10.add(tf105);
				p10.add(tf106);
				p10.add(tf107);
				p10.add(tf108);
				p10.add(tf109);
				p10.add(tf1010);
				for (int m = 1; m <= zetoni[9]; m++) {
					switch (m) {
					case 1:
						tf1010.setBackground(Color.BLUE);
						break;
					case 2:
						tf109.setBackground(Color.BLUE);
						break;
					case 3:
						tf108.setBackground(Color.BLUE);
						break;
					case 4:
						tf107.setBackground(Color.BLUE);
						break;
					case 5:
						tf106.setBackground(Color.BLUE);
						break;
					case 6:
						tf105.setBackground(Color.BLUE);
						break;
					case 7:
						tf104.setBackground(Color.BLUE);
						break;
					case 8:
						tf103.setBackground(Color.BLUE);
						break;
					case 9:
						tf102.setBackground(Color.BLUE);
						break;
					case 10:
						tf101.setBackground(Color.BLUE);
						break;
					}
				}
				break;
			}
		}
	}

	public void ponovoBoji(int pos) {
		switch (pos) {
		case 0:
			tf1.setText("");
			for (int m = zetoni[pos] + 1; m <= stari[pos]; m++) {
				switch (m) {
				case 1:
					tf110.setBackground(Color.WHITE);
					break;
				case 2:
					tf19.setBackground(Color.WHITE);
					break;
				case 3:
					tf18.setBackground(Color.WHITE);
					break;
				case 4:
					tf17.setBackground(Color.WHITE);
					break;
				case 5:
					tf16.setBackground(Color.WHITE);
					break;
				case 6:
					tf15.setBackground(Color.WHITE);
					break;
				case 7:
					tf14.setBackground(Color.WHITE);
					break;
				case 8:
					tf13.setBackground(Color.WHITE);
					break;
				case 9:
					tf12.setBackground(Color.WHITE);
					break;
				case 10:
					tf11.setBackground(Color.WHITE);
					break;
				}
			}
			break;
		case 1:
			tf2.setText("");
			for (int m = zetoni[pos] + 1; m <= stari[pos]; m++) {
				switch (m) {
				case 1:
					tf210.setBackground(Color.WHITE);
					break;
				case 2:
					tf29.setBackground(Color.WHITE);
					break;
				case 3:
					tf28.setBackground(Color.WHITE);
					break;
				case 4:
					tf27.setBackground(Color.WHITE);
					break;
				case 5:
					tf26.setBackground(Color.WHITE);
					break;
				case 6:
					tf25.setBackground(Color.WHITE);
					break;
				case 7:
					tf24.setBackground(Color.WHITE);
					break;
				case 8:
					tf23.setBackground(Color.WHITE);
					break;
				case 9:
					tf22.setBackground(Color.WHITE);
					break;
				case 10:
					tf21.setBackground(Color.WHITE);
					break;
				}
			}
			break;
		case 2:
			tf3.setText("");
			for (int m = zetoni[pos] + 1; m <= stari[pos]; m++) {
				switch (m) {
				case 1:
					tf310.setBackground(Color.WHITE);
					break;
				case 2:
					tf39.setBackground(Color.WHITE);
					break;
				case 3:
					tf38.setBackground(Color.WHITE);
					break;
				case 4:
					tf37.setBackground(Color.WHITE);
					break;
				case 5:
					tf36.setBackground(Color.WHITE);
					break;
				case 6:
					tf35.setBackground(Color.WHITE);
					break;
				case 7:
					tf34.setBackground(Color.WHITE);
					break;
				case 8:
					tf33.setBackground(Color.WHITE);
					break;
				case 9:
					tf32.setBackground(Color.WHITE);
					break;
				case 10:
					tf31.setBackground(Color.WHITE);
					break;
				}
			}
			break;
		case 3:
			tf4.setText("");
			for (int m = zetoni[pos] + 1; m <= stari[pos]; m++) {
				switch (m) {
				case 1:
					tf410.setBackground(Color.WHITE);
					break;
				case 2:
					tf49.setBackground(Color.WHITE);
					break;
				case 3:
					tf48.setBackground(Color.WHITE);
					break;
				case 4:
					tf47.setBackground(Color.WHITE);
					break;
				case 5:
					tf46.setBackground(Color.WHITE);
					break;
				case 6:
					tf45.setBackground(Color.WHITE);
					break;
				case 7:
					tf44.setBackground(Color.WHITE);
					break;
				case 8:
					tf43.setBackground(Color.WHITE);
					break;
				case 9:
					tf42.setBackground(Color.WHITE);
					break;
				case 10:
					tf41.setBackground(Color.WHITE);
					break;
				}
			}
			break;
		case 4:
			tf5.setText("");
			for (int m = zetoni[pos] + 1; m <= stari[pos]; m++) {
				switch (m) {
				case 1:
					tf510.setBackground(Color.WHITE);
					break;
				case 2:
					tf59.setBackground(Color.WHITE);
					break;
				case 3:
					tf58.setBackground(Color.WHITE);
					break;
				case 4:
					tf57.setBackground(Color.WHITE);
					break;
				case 5:
					tf56.setBackground(Color.WHITE);
					break;
				case 6:
					tf55.setBackground(Color.WHITE);
					break;
				case 7:
					tf54.setBackground(Color.WHITE);
					break;
				case 8:
					tf53.setBackground(Color.WHITE);
					break;
				case 9:
					tf52.setBackground(Color.WHITE);
					break;
				case 10:
					tf51.setBackground(Color.WHITE);
					break;
				}
			}
			break;
		case 5:
			tf6.setText("");
			for (int m = zetoni[pos] + 1; m <= stari[pos]; m++) {
				switch (m) {
				case 1:
					tf610.setBackground(Color.WHITE);
					break;
				case 2:
					tf69.setBackground(Color.WHITE);
					break;
				case 3:
					tf68.setBackground(Color.WHITE);
					break;
				case 4:
					tf67.setBackground(Color.WHITE);
					break;
				case 5:
					tf66.setBackground(Color.WHITE);
					break;
				case 6:
					tf65.setBackground(Color.WHITE);
					break;
				case 7:
					tf64.setBackground(Color.WHITE);
					break;
				case 8:
					tf63.setBackground(Color.WHITE);
					break;
				case 9:
					tf62.setBackground(Color.WHITE);
					break;
				case 10:
					tf61.setBackground(Color.WHITE);
					break;
				}
			}
			break;
		case 6:
			tf7.setText("");
			for (int m = zetoni[pos] + 1; m <= stari[pos]; m++) {
				switch (m) {
				case 1:
					tf710.setBackground(Color.WHITE);
					break;
				case 2:
					tf79.setBackground(Color.WHITE);
					break;
				case 3:
					tf78.setBackground(Color.WHITE);
					break;
				case 4:
					tf77.setBackground(Color.WHITE);
					break;
				case 5:
					tf76.setBackground(Color.WHITE);
					break;
				case 6:
					tf75.setBackground(Color.WHITE);
					break;
				case 7:
					tf74.setBackground(Color.WHITE);
					break;
				case 8:
					tf73.setBackground(Color.WHITE);
					break;
				case 9:
					tf72.setBackground(Color.WHITE);
					break;
				case 10:
					tf71.setBackground(Color.WHITE);
					break;
				}
			}
			break;
		case 7:
			tf8.setText("");
			for (int m = zetoni[pos] + 1; m <= stari[pos]; m++) {
				switch (m) {
				case 1:
					tf810.setBackground(Color.WHITE);
					break;
				case 2:
					tf89.setBackground(Color.WHITE);
					break;
				case 3:
					tf88.setBackground(Color.WHITE);
					break;
				case 4:
					tf87.setBackground(Color.WHITE);
					break;
				case 5:
					tf86.setBackground(Color.WHITE);
					break;
				case 6:
					tf85.setBackground(Color.WHITE);
					break;
				case 7:
					tf84.setBackground(Color.WHITE);
					break;
				case 8:
					tf83.setBackground(Color.WHITE);
					break;
				case 9:
					tf82.setBackground(Color.WHITE);
					break;
				case 10:
					tf81.setBackground(Color.WHITE);
					break;
				}
			}
			break;
		case 8:
			tf9.setText("");
			for (int m = zetoni[pos] + 1; m <= stari[pos]; m++) {
				switch (m) {
				case 1:
					tf910.setBackground(Color.WHITE);
					break;
				case 2:
					tf99.setBackground(Color.WHITE);
					break;
				case 3:
					tf98.setBackground(Color.WHITE);
					break;
				case 4:
					tf97.setBackground(Color.WHITE);
					break;
				case 5:
					tf96.setBackground(Color.WHITE);
					break;
				case 6:
					tf95.setBackground(Color.WHITE);
					break;
				case 7:
					tf94.setBackground(Color.WHITE);
					break;
				case 8:
					tf93.setBackground(Color.WHITE);
					break;
				case 9:
					tf92.setBackground(Color.WHITE);
					break;
				case 10:
					tf91.setBackground(Color.WHITE);
					break;
				}
			}
			break;
		case 9:
			tf10.setText("");
			for (int m = zetoni[pos] + 1; m <= stari[pos]; m++) {
				switch (m) {
				case 1:
					tf1010.setBackground(Color.WHITE);
					break;
				case 2:
					tf109.setBackground(Color.WHITE);
					break;
				case 3:
					tf108.setBackground(Color.WHITE);
					break;
				case 4:
					tf107.setBackground(Color.WHITE);
					break;
				case 5:
					tf106.setBackground(Color.WHITE);
					break;
				case 6:
					tf105.setBackground(Color.WHITE);
					break;
				case 7:
					tf104.setBackground(Color.WHITE);
					break;
				case 8:
					tf103.setBackground(Color.WHITE);
					break;
				case 9:
					tf102.setBackground(Color.WHITE);
					break;
				case 10:
					tf101.setBackground(Color.WHITE);
					break;
				}
			}
			break;
		}
	}

	public void proveraIspravnosti() {
		for (int i = 1; i <= brojStubova; i++) {
			switch (i) {
			case 1:
				if (tf1.getText().equals(""))
					break;
				else {
					Pattern p = Pattern.compile("([0-9]*)");
					Matcher m = p.matcher(tf1.getText());
					if (m.matches()) {
						zetoni[0] = zetoni[0] - Integer.parseInt(tf1.getText());
						pos = 0;
						value = Integer.parseInt(tf1.getText());
					} else {
						ta31.setText("pogresan format unet u polje 1.!!!!!!!!!!");
					}
				}
				break;
			case 2:
				if (tf2.getText().equals(""))
					break;
				else {
					Pattern p = Pattern.compile("([0-9]*)");
					Matcher m = p.matcher(tf2.getText());
					if (m.matches()) {
						zetoni[1] = zetoni[1] - Integer.parseInt(tf2.getText());
						pos = 1;
						value = Integer.parseInt(tf2.getText());
					} else {
						ta31.setText("pogresan format unet u polje 2.!!!!!!!!!!");
					}
				}
				break;
			case 3:
				if (tf3.getText().equals(""))
					break;
				else {
					Pattern p = Pattern.compile("([0-9]*)");
					Matcher m = p.matcher(tf3.getText());
					if (m.matches()) {
						zetoni[2] = zetoni[2] - Integer.parseInt(tf3.getText());
						pos = 2;
						value = Integer.parseInt(tf3.getText());
					} else {
						ta31.setText("pogresan format unet u polje 3.!!!!!!!!!!");
					}
				}
				break;
			case 4:
				if (tf4.getText().equals(""))
					break;
				else {
					Pattern p = Pattern.compile("([0-9]*)");
					Matcher m = p.matcher(tf4.getText());
					if (m.matches()) {
						zetoni[3] = zetoni[3] - Integer.parseInt(tf4.getText());
						pos = 3;
						value = Integer.parseInt(tf4.getText());
					} else {
						ta31.setText("pogresan format unet u polje 4.!!!!!!!!!!");
					}
				}
				break;
			case 5:
				if (tf5.getText().equals(""))
					break;
				else {
					Pattern p = Pattern.compile("([0-9]*)");
					Matcher m = p.matcher(tf5.getText());
					if (m.matches()) {
						zetoni[4] = zetoni[4] - Integer.parseInt(tf5.getText());
						pos = 4;
						value = Integer.parseInt(tf5.getText());
					} else {
						ta31.setText("pogresan format unet u polje 5.!!!!!!!!!!");
					}
				}
				break;
			case 6:
				if (tf6.getText().equals(""))
					break;
				else {
					Pattern p = Pattern.compile("([0-9]*)");
					Matcher m = p.matcher(tf6.getText());
					if (m.matches()) {
						zetoni[5] = zetoni[5] - Integer.parseInt(tf6.getText());
						pos = 5;
						value = Integer.parseInt(tf6.getText());
					} else {
						ta31.setText("pogresan format unet u polje 6.!!!!!!!!!!");
					}
				}
				break;
			case 7:
				if (tf7.getText().equals(""))
					break;
				else {
					Pattern p = Pattern.compile("([0-9]*)");
					Matcher m = p.matcher(tf7.getText());
					if (m.matches()) {
						zetoni[6] = zetoni[6] - Integer.parseInt(tf7.getText());
						pos = 6;
						value = Integer.parseInt(tf7.getText());
					} else {
						ta31.setText("pogresan format unet u polje 7.!!!!!!!!!!");
					}
				}
				break;
			case 8:
				if (tf8.getText().equals(""))
					break;
				else {
					Pattern p = Pattern.compile("([0-9]*)");
					Matcher m = p.matcher(tf8.getText());
					if (m.matches()) {
						zetoni[7] = zetoni[7] - Integer.parseInt(tf8.getText());
						pos = 7;
						value = Integer.parseInt(tf8.getText());
					} else {
						ta31.setText("pogresan format unet u polje 8.!!!!!!!!!!");
					}
				}
				break;
			case 9:
				if (tf9.getText().equals(""))
					break;
				else {
					Pattern p = Pattern.compile("([0-9]*)");
					Matcher m = p.matcher(tf9.getText());
					if (m.matches()) {
						zetoni[8] = zetoni[8] - Integer.parseInt(tf9.getText());
						pos = 8;
						value = Integer.parseInt(tf9.getText());
					} else {
						ta31.setText("pogresan format unet u polje 9.!!!!!!!!!!");
					}
				}
				break;
			case 10:
				if (tf10.getText().equals(""))
					break;
				else {
					Pattern p = Pattern.compile("([0-9]*)");
					Matcher m = p.matcher(tf10.getText());
					if (m.matches()) {
						zetoni[9] = zetoni[9] - Integer.parseInt(tf10.getText());
						pos = 9;
						value = Integer.parseInt(tf10.getText());
					} else {
						ta31.setText("pogresan format unet u polje 10.!!!!!!!!!!");
					}
				}
				break;
			}
		}

		//////////////////////////////////
		if (!alg.promena(stari, zetoni, brojStubova)) {
			ta31.setText("Ne mogu se skidati zetoni sa vise stubova!!!!");
		} else if (!alg.valid(value, stariBroj, pos, stari)) {
			ta31.setText("Nemoguca vrednost, pokusajte ponovo!!!!!!!!!!");

		} else if (!alg.provera(stari, brojStubova, pos, value)) {
			ta31.setText("Nemoguc potez!!!!!!!!!!");
		}
	}

	public void promena1() {
		this.remove(panelPrvi);
		this.add(panelDrugi);
		this.revalidate();
		this.repaint();
	}
}
