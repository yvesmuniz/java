package dollar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;



public class ViewInput {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	ReadData rd = new ReadData();

    private Document document;
    private static Double dolar;
    
    public ViewInput(Document document) {
        this.document = document;
    }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewInput window = new ViewInput();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewInput() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1048, 622);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(140, 74, 158, 49);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Taxa de juros dom\u00E9stica:");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 16));
		lblNewLabel_1.setBounds(34, 37, 427, 52);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Taxa de juros no pa\u00EDs estrangeiro:");
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(34, 90, 427, 46);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("Per\u00EDodos at\u00E9 o vencimento do contrato futuro:");
		lblNewLabel_1_3.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(34, 147, 451, 46);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_2 = new JLabel("Base de tempo para taxa de juros dom\u00E9stica:");
		lblNewLabel_1_2.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(34, 204, 451, 46);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Base de tempo para taxa de juros pa\u00EDs estrangeiro:");
		lblNewLabel_1_1_1.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(34, 261, 451, 46);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Dolar atual:");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 16));
		lblNewLabel_2.setBounds(34, 351, 239, 36);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(548, 56, 86, 20);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(548, 113, 86, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(548, 170, 86, 20);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(548, 230, 86, 20);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(548, 287, 86, 20);
		frame.getContentPane().add(textField_4);
		
		JButton btnNewButton = new JButton("START");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				double i = Double.parseDouble(textField.getText());    
				double j = Double.parseDouble(textField_1.getText());    
				double n = Double.parseDouble(textField_2.getText());    
				double m = Double.parseDouble(textField_3.getText());    
				double p = Double.parseDouble(textField_4.getText());    
				
				rd.setI(i);
				rd.setJ(j);
				rd.setN(n);
				rd.setM(m);
				rd.setP(p);
								
				
				starter();
				
				String d = Double.toString(getDolar());
				String r = Double.toString(getDate(rd));
				
				
				
				
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 16));
		btnNewButton.setBounds(480, 495, 131, 63);
		frame.getContentPane().add(btnNewButton);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(34, 398, 176, 101);
		frame.getContentPane().add(lblNewLabel_3);
	}
	
	JLabel lblNewLabel_3;
	
	
	
	public void starter() {
        

        boolean loop = true;
        
        try{
             	
    	
        while(loop){
            
            Document document = Jsoup.connect("https://br.investing.com/currencies/").get();
            ViewInput parser = new ViewInput(document);
            parser.getDate(rd);
            parser.getDolar();
            System.out.println();
            System.out.println();
        } 
            
        }catch (IOException e) {
        e.printStackTrace();
    }
        

}
	
	public double getDolar(){
        Element element = document.getElementById("TSB__summary_last_2103");
        StringBuilder str = new StringBuilder(element.text());

        Double valor = Double.valueOf(String.valueOf(str.deleteCharAt(1)));
        Double dolar = valor / 10000;
        return dolar;
    }
    
    
    public double getDate(ReadData rd) {
     
    	
        Element element = document.getElementById("TSB__summary_last_2103");
        StringBuilder str = new StringBuilder(element.text());

        Double valor = Double.valueOf(String.valueOf(str.deleteCharAt(1)));
        Double dolar = valor / 10000;
        System.out.println("Preço atual do dolar: "+dolar);
        
        
        double result, r1, r2, p1, p2;
        r1 = rd.getN() / rd.getM();
        r2 = rd.getN() / rd.getP();
                
        result = dolar * (Math.pow((1 + rd.getI()), r1)) / (Math.pow((1 + rd.getJ()), r2));
        System.out.println("Resultado: "+result);
        System.out.println();
        
        
        return result;
    }
}
