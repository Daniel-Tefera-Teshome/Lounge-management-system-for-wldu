import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
class WDULaunch extends JFrame{
JPasswordField pwd1;
JTextField tf1,tfd1,tfd2;
JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,lbo;
JButton btn1,btn2,btn3;
WDULaunch(){
ImageIcon gg = new ImageIcon(getClass().getResource("woldia.png"));
        JLabel lbo = new JLabel(gg);
        lbo.setBounds(900, 2, 300, 230);
        add(lbo);
	setBounds(0,0,1500,700);
	setTitle(" Automating WDU Launch System");
	setSize(620,800);
	setLocation(0,0);
	setLayout(new FlowLayout());
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setResizable(false);
	l1 = new JLabel("UserName");
	l1.setForeground(Color.BLACK);
    l1.setBounds(300, 0, 1200, 50);
    l1.setFont(new Font(Font.SERIF, Font.BOLD, 20));
	l2 = new JLabel("Password");
	l2.setForeground(Color.BLACK);
    l2.setBounds(300, 0, 1200, 50);
    l2.setFont(new Font(Font.SERIF, Font.BOLD, 20));
	tf1 = new JTextField();
	tf1.setText("UserName here please");
		tf1.addFocusListener(new FocusAdapter(){
				public void focusGained(FocusEvent e){
					tf1.setText("");
				}
		});
	l3 = new JLabel("Automating Woldia University Launch System");
    l3.setForeground(Color.BLUE);
    l3.setBounds(300, 0, 1200, 50);
    l3.setFont(new Font(Font.SERIF, Font.BOLD, 30));
	l0 = new JLabel(".............................................");
    l0.setForeground(Color.GREEN);
    l0.setBounds(300, 0, 1200, 50);
    l0.setFont(new Font(Font.SERIF, Font.BOLD, 50));
	l9 = new JLabel(".............................................");
    l9.setForeground(Color.GREEN);
    l9.setBounds(300, 0, 1200, 50);
    l9.setFont(new Font(Font.SERIF, Font.BOLD, 50));
	l4 = new JLabel("Woldia University, Faculty of Technology");
    l4.setForeground(Color.red);
    l4.setBounds(300, 0, 1200, 50);
    l4.setFont(new Font(Font.SERIF, Font.BOLD, 30));
	l5 = new JLabel("Department of Computer Science,");
    l5.setForeground(Color.red);
    l5.setBounds(300, 0, 1200, 50);
    l5.setFont(new Font(Font.SERIF, Font.BOLD, 30));
	l6 = new JLabel("Section -- 3");
    l6.setForeground(Color.red);
    l6.setBounds(300, 0, 1200, 50);
    l6.setFont(new Font(Font.SERIF, Font.BOLD, 30));
	l7 = new JLabel("Group One,");
    l7.setForeground(Color.red);
    l7.setBounds(300, 0, 1200, 50);
    l7.setFont(new Font(Font.SERIF, Font.BOLD, 30));
	l8 = new JLabel("Advanced Programming Project");
    l8.setForeground(Color.red);
    l8.setBounds(300, 0, 1200, 50);
    l8.setFont(new Font(Font.SERIF, Font.BOLD, 30));
	l10 = new JLabel(".............................................");
    l10.setForeground(Color.GREEN);
    l10.setBounds(300, 0, 1200, 50);
    l10.setFont(new Font(Font.SERIF, Font.BOLD, 50));
	pwd1 = new JPasswordField();
	pwd1.setColumns(10);
	//pwd1.setText("");
	pwd1.setEchoChar('#');
	btn1 = new JButton("Log In");
	btn1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ev){
			Connection c;
			Statement s;
			ResultSet r;
			
			try{
				Class.forName("com.mysql.jdbc.Driver");
				c = DriverManager.getConnection("jdbc:mysql://localhost/WDULaunchSystem", "root", "daniel");
				s = c.createStatement();
				r = s.executeQuery("SELECT * FROM account WHERE username = '"+ tf1.getText() +"' AND password ='"+ new String(pwd1.getPassword()) +"'");
				r.last();
				if(r.getRow() == 1){
					setVisible(false);
					MainMenu meu = new MainMenu();
				}
				else if(r.getRow() == 0){
				JOptionPane.showMessageDialog(null,"Incorrect UserName and PassWord ","Error message",JOptionPane.ERROR_MESSAGE);
				tf1.setText(" ");
				pwd1.setText("");
				}
			}catch(Exception ex){
				//JOptionPane.showMessageDialog(null,ex,"Error message",JOptionPane.ERROR_MESSAGE);
				System.out.println(ex);
			}
			/*if(tf1.getText().equals(st[0]) && new String(pwd1.getPassword()).equals(st[1])){
				setVisible(false);
				MainMenu meu = new MainMenu();
			}
			else{
				JOptionPane.showMessageDialog(null,"Incorrect UserName and PassWord ","Error message",JOptionPane.ERROR_MESSAGE);
				tf1.setText(" ");
				pwd1.setText(" ");
			}*/
		}
	});
	btn2 = new JButton("Create new account");
	btn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Account accou = new Account();
				setVisible(false);
			}
	});
	
	add(l10);
	add(l0);
	add(l3);
	add(l0);
	add(l4);
	add(l5);
	add(l6);
	add(l7);
	add(l8);
	add(l9);
	add(l1);
	add(tf1);
	add(l2);
	add(pwd1);
	add(btn1);
	add(btn2);
	//pack();
	setVisible(true);
	}
	public static void main(String args[]){
		WDULaunch wdu = new WDULaunch();
	}
class Account extends JFrame{
JLabel l1,l2;
JPanel p1;
JButton btn1;
Account(){
//setSize(400,400);
setTitle("Create New Account");
setLocation(0,0);
setLayout(new FlowLayout());
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Border b = BorderFactory.createEtchedBorder();
Border b1 = BorderFactory.createTitledBorder(b, "New Account");
setResizable(false);
p1 = new JPanel();
tfd1 = new JTextField(20);
tfd2 = new JTextField(20);
l1 = new JLabel("Enter UserName");
l2 = new JLabel("Enter PassWord");
btn1 = new JButton("Save changes");
btn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Connection con;
				Statement stmt;
				ResultSet rs;
				try{
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/WDULaunchSystem","root","daniel");
					stmt = con.createStatement();
					String str1 = tfd1.getText();
					String str2 = tfd2.getText();
					stmt.executeUpdate("INSERT INTO Account values('"+str1+"' , '"+str2+"')");
					//st[0] = str1;
					//st[1] = str2;
					/*rs = stmt.executeQuery("Select * from Account");
					while(rs.next() != false){
						String username = rs.getString(1);
						String password = rs.getString(2);
						st[0] = username;
						st[1] = password;
					}*/
				con.close();
				stmt.close();
				//rs.close();
				}
				catch(Exception r){
					System.out.println(r);
			}
			}
	});
	btn3 = new JButton("back");
	btn3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				WDULaunch wldu = new WDULaunch();
				setVisible(false);
			}
	});
p1.add(l1);
p1.add(tfd1);
p1.add(l2);
p1.add(tfd2);
p1.setBorder(b1);
add(p1);
add(btn1);
add(btn3);
pack();
setVisible(true);
}
}
}

class MainMenu extends JFrame{
JLabel l0,l1,l2,l3,l7;
JMenuBar mb;
JMenu customer_mgt;
JMenu employee_mgt;
JMenu suplier_mgt;
JMenu food_mgt;
JMenu order;
JMenu report;
JMenu exit;
JMenuItem customer_regestration,employee_regestration,food_regestration,suplier_regestration,order_request,exite,member;
JMenuItem customer_modify,customer_view,employee_modify,employee_view,food_modify,food_view,suplier_modify,suplier_view;
JMenuItem customer_delete,employee_delete,food_delete,suplier_delete,order_delete,order_modify,order_view;
MainMenu(){
	setTitle("MainMenu");
	setSize(600,300);
	setLocation(0,0);
	setLayout(new FlowLayout());
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setResizable(false);
	customer_mgt = new JMenu("Customer Mgt");
	employee_mgt = new JMenu("Employee Mgt");
	suplier_mgt = new JMenu("Suplier Mgt");
	food_mgt = new JMenu("Food Mgt");
	order = new JMenu("Order");
	report = new JMenu("Report");
	mb = new JMenuBar();
	l0 = new JLabel(".............................................");
    l0.setForeground(Color.red);
    l0.setBounds(300, 0, 1200, 50);
    l0.setFont(new Font(Font.SERIF, Font.BOLD, 50));
	l3 = new JLabel(".............................................");
    l3.setForeground(Color.red);
    l3.setBounds(300, 0, 1200, 50);
    l3.setFont(new Font(Font.SERIF, Font.BOLD, 50));
	customer_regestration = new JMenuItem("Customer Registration");
	customer_regestration.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ke){
					Customer cust = new Customer();
					setVisible(false);
					Customer.btn3.setEnabled(false);
				}
		});
	l7 = new JLabel("WellCome To WDULaunch");
    l7.setForeground(Color.MAGENTA);
    l7.setBounds(300, 0, 1200, 50);
    l7.setFont(new Font(Font.SERIF, Font.BOLD, 30)); 
	member = new JMenuItem("Member");
	member.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
		new Member();
		setVisible(false);
	}
	});
	employee_regestration= new JMenuItem("Employee Registration");
	order_modify = new JMenuItem("Order_Modify");
	order_modify.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent asev){
			new Order();
			setVisible(false);
			Order.btn1.setEnabled(false);
		}
	});
	order_view = new JMenuItem("Order_View");
	order_view.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				new OrderView();
				setVisible(false);
			}
		});
	employee_modify = new JMenuItem("Employee Modify");
		employee_modify.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				new Employee();
				setVisible(false);
				Employee.btn1.setEnabled(false);
			}
		});
	employee_view = new JMenuItem("Employee View");
	employee_view.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				new EmployeeView();
				setVisible(false);
			}
		});
	customer_modify = new JMenuItem("Customer Modify");
		customer_modify.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				new Customer();
				setVisible(false);
				Customer.btn1.setEnabled(false);
			}
		});
	customer_view = new JMenuItem("Customer View");
	customer_view.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae){
			new CustomerView();
			setVisible(false);
		}
	});
	food_modify = new JMenuItem("Food Modify");
		food_modify.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				new Food();
				setVisible(false);
				Food.btn1.setEnabled(false);
			}
		});
	food_view = new JMenuItem("Food View");
	food_view.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				new FoodView();
				setVisible(false);
			}
		});
	order_request = new JMenuItem("Order Request");
	suplier_regestration = new JMenuItem("Supplier Registration");
	suplier_modify = new JMenuItem("Supplier Modify");
	suplier_modify.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				new Suplier();
				setVisible(false);
				Suplier.btn1.setEnabled(false);
			}
		});
	suplier_view = new JMenuItem("Supplier View");
			suplier_view.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ke){
					new SuplierView();
					setVisible(false);					
				}
		});
	customer_delete = new JMenuItem("Customer_Delete");
		customer_delete.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ke){
					new CFrame();
					setVisible(false);					
				}
		});
	employee_delete = new JMenuItem("Employee_Delete");
	employee_delete.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ke){
					new EFrame();				
					setVisible(false);
				}
		});
	food_delete = new JMenuItem("Food_Delete");
	food_delete.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ke){
					new FFrame();				
					setVisible(false);
				}
		});
	suplier_delete = new JMenuItem("Supplier_Delete");
	suplier_delete.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ke){
					new SFrame();				
					setVisible(false);
				}
		});
	order_delete = new JMenuItem("Order_Delete");
	order_delete.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ke){
					new OFrame();				
					setVisible(false);
				}
		});
	employee_regestration.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ke){
					Employee emp = new Employee();				
					setVisible(false);
					Employee.btn3.setEnabled(false);
				}
		});
	food_regestration = new JMenuItem("Food Registration");
	food_regestration.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ke){
					Food food = new Food();				
					setVisible(false);
					Food.btn3.setEnabled(false);
				}
		});
	//suplier = new JMenuItem("Supplier Form");
	suplier_regestration.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ke){
					Suplier sup = new Suplier();				
					setVisible(false);
					Suplier.btn3.setEnabled(false);
				}
		});
	//order = new JMenuItem("Order Form");
	order_request.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ke){
					Order order = new Order();				
					setVisible(false);
					Order.btn3.setEnabled(false);
				}
		});
	exit = new JMenu("Edit");
	exite = new JMenuItem("Exit");
	exite.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ke){
					System.exit(0);				
				}
		});
	customer_mgt.add(customer_regestration);
	customer_mgt.add(customer_modify);
	customer_mgt.add(customer_delete);
	customer_mgt.add(customer_view);
	employee_mgt.add(employee_regestration);
	employee_mgt.add(employee_modify);
	employee_mgt.add(employee_view);
	employee_mgt.add(employee_delete);
	food_mgt.add(food_regestration);
	food_mgt.add(food_modify);
	food_mgt.add(food_view);
	food_mgt.add(food_delete);
	suplier_mgt.add(suplier_regestration);
	suplier_mgt.add(suplier_modify);
	suplier_mgt.add(suplier_view);
	suplier_mgt.add(suplier_delete);
	order.add(order_request);
	order.add(order_delete);
	order.add(order_modify);
	order.add(order_view);
	exit.add(exite);
	exit.add(member);
	//order.add(employee);
	//file.add(food);
	//file.add(suplier);
	//file.add(order);
	//edit.add(exit);
	//edit.add(insert);
	//edit.add(select);
	//edit.add(delete);
	mb.add(customer_mgt);
	mb.add(employee_mgt);
	mb.add(food_mgt);
	mb.add(suplier_mgt);
	mb.add(order);
	mb.add(report);
	mb.add(exit);
	setJMenuBar(mb);
	add(l0);
	add(l7);
	add(l3);
	//pack();
	setVisible(true);
	}
	public static void main(String args[]){
		MainMenu mainu = new MainMenu();
	}
}
class CFrame extends JFrame{
JButton btn1,btn2,btn3;
JLabel l1,l2;
JTextField CustID,tf2;
	CFrame(){
	ImageIcon ic = new ImageIcon("da.jpg");
	setIconImage(ic.getImage());
	setTitle("Deletion");
	setSize(400,500);
	setLocation(0,0);
	setLayout(new FlowLayout());
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setResizable(true);
	l1 = new JLabel("Enter the CustID that you want to delete:");
	CustID = new JTextField(10);
	btn1 = new JButton("back");
	btn2 = new JButton("delete");
	btn1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ke){
					MainMenu menu = new MainMenu();	
					setVisible(false);
				}
		});
	btn2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ke){
				try{
					Connection con;
					Statement stmt;
					String url = "jdbc:mysql://localhost:3306/WDULaunchSystem";
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection(url,"root","daniel");
					stmt = con.createStatement();
					String str1 = CustID.getText();
					String sql = "DELETE FROM Customer WHERE CustID = '" + str1 + "'";
					stmt.executeUpdate(sql);
					JOptionPane.showMessageDialog(null,"Deletion is succeed ","Deletion message",JOptionPane.INFORMATION_MESSAGE);
					con.close();
					stmt.close();
					}
					catch(Exception ex){
						System.out.println(ex);
					}
				}
		});	
	add(l1);
	add(CustID);
	add(btn1);
	add(btn2);
	pack();
	setVisible(true);
	}
	public static void main(String args[]){
		CFrame cf = new CFrame();
	}
}
class SFrame extends JFrame{
JButton btn1,btn2,btn3;
JLabel l1,l2;
JTextField sup_no,tf2;
	SFrame(){
	ImageIcon ic = new ImageIcon("da.jpg");
	setIconImage(ic.getImage());
	setTitle("Deletion");
	setSize(400,500);
	setLocation(0,0);
	setLayout(new FlowLayout());
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setResizable(true);
	l1 = new JLabel("Enter the sup_no that you want to delete:");
	sup_no = new JTextField(10);
	btn1 = new JButton("back");
	btn2 = new JButton("delete");
	btn1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ke){
					MainMenu menu = new MainMenu();	
					setVisible(false);
				}
		});
	btn2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ke){
				try{
					Connection con;
					Statement stmt;
					String url = "jdbc:mysql://localhost:3306/WDULaunchSystem";
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection(url,"root","daniel");
					stmt = con.createStatement();
					String str1 = sup_no.getText();
					int x = Integer.parseInt(str1);
					String sql = "DELETE FROM Suplier WHERE sup_no = " + str1 + "";
					stmt.executeUpdate(sql);
					JOptionPane.showMessageDialog(null,"Deletion is succeed ","Deletion message",JOptionPane.INFORMATION_MESSAGE);
					con.close();
					stmt.close();
					}
					catch(Exception ex){
						System.out.println(ex);
					}
				}
		});	
	add(l1);
	add(sup_no);
	add(btn1);
	add(btn2);
	pack();
	setVisible(true);
	}
	public static void main(String args[]){
		SFrame cf = new SFrame();
	}
}
class OFrame extends JFrame{
JButton btn1,btn2,btn3;
JLabel l1,l2;
JTextField or_no,tf2;
	OFrame(){
	ImageIcon ic = new ImageIcon("da.jpg");
	setIconImage(ic.getImage());
	setTitle("Deletion");
	setSize(400,500);
	setLocation(0,0);
	setLayout(new FlowLayout());
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setResizable(true);
	l1 = new JLabel("Enter the or_no that you want to delete:");
	or_no = new JTextField(10);
	btn1 = new JButton("back");
	btn2 = new JButton("delete");
	btn1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ke){
					MainMenu menu = new MainMenu();	
					setVisible(false);
				}
		});
	btn2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ke){
				try{
					Connection con;
					Statement stmt;
					String url = "jdbc:mysql://localhost:3306/WDULaunchSystem";
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection(url,"root","daniel");
					stmt = con.createStatement();
					String str1 = or_no.getText();
					int x = Integer.parseInt(str1);
					String sql = "DELETE FROM Orderr WHERE or_no = " + str1 + "";
					stmt.executeUpdate(sql);
					JOptionPane.showMessageDialog(null,"Deletion is succeed ","Deletion message",JOptionPane.INFORMATION_MESSAGE);
					con.close();
					stmt.close();
					}
					catch(Exception ex){
						System.out.println(ex);
					}
				}
		});	
	add(l1);
	add(or_no);
	add(btn1);
	add(btn2);
	pack();
	setVisible(true);
	}
	public static void main(String args[]){
		OFrame of = new OFrame();
	}
}
class EFrame extends JFrame{
JButton btn1,btn2,btn3;
JLabel l1,l2;
JTextField EmpID,tf2;
	EFrame(){
	ImageIcon ic = new ImageIcon("da.jpg");
	setIconImage(ic.getImage());
	setTitle("Deletion");
	setSize(400,500);
	setLocation(0,0);
	setLayout(new FlowLayout());
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setResizable(true);
	l1 = new JLabel("Enter the EmpID that you want to delete:");
	EmpID = new JTextField(10);
	btn1 = new JButton("back");
	btn2 = new JButton("delete");
	btn1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ke){
					MainMenu menu = new MainMenu();	
					setVisible(false);
				}
		});
	btn2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ke){
				try{
					Connection con;
					Statement stmt;
					String url = "jdbc:mysql://localhost:3306/WDULaunchSystem";
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection(url,"root","daniel");
					stmt = con.createStatement();
					String str1 = EmpID.getText();
					String sql = "DELETE FROM Employee WHERE EmpID = '" + str1 + "'";
					stmt.executeUpdate(sql);
					JOptionPane.showMessageDialog(null,"Deletion is succeed ","Deletion message",JOptionPane.INFORMATION_MESSAGE);
					con.close();
					stmt.close();
					}
					catch(Exception ex){
						System.out.println(ex);
					}
				}
		});	
	add(l1);
	add(EmpID);
	add(btn1);
	add(btn2);
	pack();
	setVisible(true);
	}
	public static void main(String args[]){
		EFrame df = new EFrame();
	}
}

class FFrame extends JFrame{
JButton btn1,btn2,btn3;
JLabel l1,l2;
JTextField food_no,tf2;
	FFrame(){
	ImageIcon ic = new ImageIcon("da.jpg");
	setIconImage(ic.getImage());
	setTitle("Deletion");
	setSize(400,500);
	setLocation(0,0);
	setLayout(new FlowLayout());
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setResizable(true);
	l1 = new JLabel("Enter the Food_no that you want to delete:");
	food_no = new JTextField(10);
	btn1 = new JButton("back");
	btn2 = new JButton("delete");
	btn1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ke){
					MainMenu menu = new MainMenu();	
					setVisible(false);
				}
		});
	btn2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ke){
				try{
					Connection con;
					Statement stmt;
					String url = "jdbc:mysql://localhost:3306/WDULaunchSystem";
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection(url,"root","daniel");
					stmt = con.createStatement();
					String str1 = food_no.getText();
					int x = Integer.parseInt(str1);
					//int x = Integer.ParseInt(str1);
					String sql = "DELETE FROM Food WHERE fo_no = " + x + "";
					stmt.executeUpdate(sql);
					JOptionPane.showMessageDialog(null,"Deletion is succeed ","Deletion message",JOptionPane.INFORMATION_MESSAGE);
					con.close();
					stmt.close();
					}
					catch(Exception ex){
						System.out.println(ex);
					}
				}
		});	
	add(l1);
	add(food_no);
	add(btn1);
	add(btn2);
	pack();
	setVisible(true);
	}
	public static void main(String args[]){
		FFrame df = new FFrame();
	}
}

class Customer extends JFrame{
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
static JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10;
static JComboBox <String> cb1,cb2;
JPanel p1,p2,p3,p4,p5;
static JButton btn1,btn3;
JButton btn2;
Customer(){
	setTitle("Customer Form");
	setSize(620,400);
	setLocation(0,0);
	setLayout(new FlowLayout());
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setResizable(false);
	Border b = BorderFactory.createEtchedBorder();
 	Border b1 = BorderFactory.createTitledBorder(b, "Sex");
	l1 = new JLabel("First Name:");
	l2 = new JLabel("Last Name:");
	l3 = new JLabel("Cust ID:");
	l4 = new JLabel("Cust Tel:");
	l5 = new JLabel("Sex:");
	l6 = new JLabel("Cust City:");
	l7 = new JLabel("Cust Age:");
	l8 = new JLabel("Product code:");
	l9 = new JLabel("Address:");
	l10 = new JLabel("Email:");
	btn1 = new JButton("Submit->");
	btn1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ke){
					try{
					Connection con;
					Statement stmt;
					String url = "jdbc:mysql://localhost:3306/WDULaunchSystem";
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection(url,"root","daniel");
					stmt = con.createStatement();
					String str1 = tf1.getText();
					String str2 = tf2.getText();
					String str3 = tf3.getText();
					String str9 = tf4.getText();
					int x = Integer.parseInt(str9);
					String str6 = tf6.getText();
					String str10 = tf7.getText();
					int y = Integer.parseInt(str10);
					String str8 = cb1.getSelectedItem().toString();
					String str11 = tf9.getText();
					String str12 = tf10.getText();					
					stmt.executeUpdate("INSERT INTO Customer values('"+str1+"' , '"+str2+"' , '"+str3+"' , "+x+
					" , '"+str6+"' , "+y+" , '"+str8+"' , '"+str12+"' , '"+str11+"')");
					JOptionPane.showMessageDialog(null,"Insertion Succeed ","Insertion message",JOptionPane.INFORMATION_MESSAGE);
					con.close();
					stmt.close();
					}
					catch(Exception ex){
						System.out.println(ex);
					}
				}
		});
	btn2 = new JButton("Back");
	btn2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ke){
					MainMenu menu = new MainMenu();	
					setVisible(false);
				}
		});
	btn3 = new JButton("Modify");
	btn3.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent acev){
			try{
					Connection con;
					Statement stmt;
					String url = "jdbc:mysql://localhost:3306/WDULaunchSystem";
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection(url,"root","daniel");
					stmt = con.createStatement();
					String str1 = tf1.getText();
					String str2 = tf2.getText();
					String str3 = tf3.getText();
					String str9 = tf4.getText();
					int x = Integer.parseInt(str9);
					String str6 = tf6.getText();
					String str10 = tf7.getText();
					int y = Integer.parseInt(str10);
					String str8 = cb1.getSelectedItem().toString();       
					String str11 = tf9.getText();
					String str12 = tf10.getText();					
					stmt.executeUpdate("UPDATE Customer SET FName = '"+str1+"' , LName = '"+str2+"' ,CustTel = "+x+
					" ,Custcity = '"+str6+"' ,CustAge = "+y+" ,Address = '"+str8+"' ,Email = '"+str12+"' ,Sex = '"+str11+"' WHERE CustID = '"+str3+"'");
					JOptionPane.showMessageDialog(null,"Update Succeed ","Update message",JOptionPane.INFORMATION_MESSAGE);
					con.close();
					stmt.close();
					}
					catch(Exception ex){
						System.out.println(ex);
					}
		}
	});
	p1 = new JPanel();
	tf1 = new JTextField(20);
	tf1.addKeyListener(new KeyAdapter(){
		public void keyTyped(KeyEvent ke){
			char c = ke.getKeyChar();
			if(c < 65 || c > 91)
			if(c < 97 || c > 123)
				//if(c < 'A' || c > 'Z')
				//if(c < 'a' || c > 'z')
					ke.consume();
			}
		});
	tf2 = new JTextField(20);
	tf2.addKeyListener(new KeyAdapter(){
		public void keyTyped(KeyEvent ke){
			char c = ke.getKeyChar();
			if(c < 65 || c > 91)
			if(c < 97 || c > 123)
			//if(c < 'A' || c > 'Z')
			//if(c < 'a' || c > 'z')
			ke.consume();
		}
    });
	tf3 = new JTextField(20);
	tf4 = new JTextField(20);
	tf4.addKeyListener(new KeyAdapter(){
		public void keyTyped(KeyEvent ke){
			char c = ke.getKeyChar();
			if(c < '0' || c > '9')
			ke.consume();		
		}
	});
	cb1 = new JComboBox<>();
	cb1.addItem("Male");
	cb1.addItem("female");
	tf6 = new JTextField(20);
	tf6.addKeyListener(new KeyAdapter(){
		public void keyTyped(KeyEvent ke){
			char c = ke.getKeyChar();
			if(c < 65 || c > 91)
			if(c < 97 || c > 123)
			//if(c < 'A' || c > 'Z')
			//if(c < 'a' || c > 'z')
			ke.consume();
		}
	});
	tf7 = new JTextField(20);
	tf7.addKeyListener(new KeyAdapter(){
		public void keyTyped(KeyEvent ke){
			char c = ke.getKeyChar();
			if(c < '0' || c > '9')
			ke.consume();
		}
	});
	tf9 = new JTextField(20);
	tf10 = new JTextField(20);
	tf10.addKeyListener(new KeyAdapter(){
		public void keyTyped(KeyEvent ke){
			char c = ke.getKeyChar();
			if(c < 'a' || c > 'z')
			if(c < 'A' || c > 'Z')
			ke.consume();
		}
	});
	p1.setBorder(b1);
	add(l1);
	add(tf1);
	add(l2);
	add(tf2);
	add(l3);
	add(tf3);
	add(l4);
	add(tf4);
	add(l6);
	add(tf6);
	add(l7);
	add(tf7);
	add(l9);
	add(tf10);
	add(l10);
	add(tf9);
	p1.add(cb1);
	//add(l5);
	add(p1);
	add(btn1);
	add(btn2);
	add(btn3);
	//pack();
	setVisible(true);
}
public static void main(String args[]){
		Customer cust = new Customer();
	}

}

class Employee extends JFrame{
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
JTextField fnametxt,lnametxt,empidtxt,salarytxt,empostxt,empteltxt,qualitxt,experitxt,empcitytxt,empagetxt,tf11;
JComboBox <String> cb1sex,cb2bodmon,cb3bodday,cb4bodyear,cb6hdday,cb7hdyear,cb5hdmonth;
JPanel p1,p2,p3,p4,p5;
static JButton btn1,btn3;
JButton btn2;
	Employee(){
		setTitle("Employee Form");
		setSize(940,400);
		setLocation(0,0);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		Border b = BorderFactory.createEtchedBorder();
	 	Border b1 = BorderFactory.createTitledBorder(b, "Birth of Date");
		Border bb = BorderFactory.createEtchedBorder();
	 	Border bb1 = BorderFactory.createTitledBorder(bb, "Hire Date");
		l1 = new JLabel("First Name:");
		l2 = new JLabel("Last Name:");
		l3 = new JLabel("Employee ID:");
		l4 = new JLabel("Salary:");
		l5 = new JLabel("Emp Position:");
		l6 = new JLabel("Emp Tel:");
		l7 = new JLabel("Birth of Date:");
		l8 = new JLabel("Sex:");
		l9 = new JLabel("Hire Date:");
		l10 = new JLabel("Experience:");
		l11 = new JLabel("Qualification:");
		l12 = new JLabel("Emp City:");
		l13 = new JLabel("Emp Age:");
		btn1 = new JButton("Submit->");
			
			btn1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ke){
					try{
					Connection con;
					Statement stmt;
					String url = "jdbc:mysql://localhost:3306/WDULaunchSystem";
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection(url,"root","daniel");
					stmt = con.createStatement();
					String str1 = fnametxt.getText();
					String str2 = lnametxt.getText();
					String str3 = empidtxt.getText();
					String str4 = salarytxt.getText();
					System.out.println(str4);
					int x = Integer.parseInt(str4);
					String str5 = empostxt.getText();
					String str6 = empteltxt.getText();
					System.out.println(str6);
					int y = Integer.parseInt(str6);
					String str7 = qualitxt.getText();
					String str8 = experitxt.getText();
					System.out.println(str8);
					int z = Integer.parseInt(str8);
					String str9 = empcitytxt.getText();
					String str10 = empagetxt.getText();
					System.out.println(str10);
					int w = Integer.parseInt(str10);
					
					String str11 = cb1sex.getSelectedItem().toString();
					String str12 = cb2bodmon.getSelectedItem().toString();
					String str13 = cb3bodday.getSelectedItem().toString();
					System.out.println(str11 + " " + str12 + " " + str13);
					int a = Integer.parseInt(str13);
					String str14 = cb4bodyear.getSelectedItem().toString();
					int b = Integer.parseInt(str14);
					String str15 = cb5hdmonth.getSelectedItem().toString();
					String str16 = cb6hdday.getSelectedItem().toString();
					int c = Integer.parseInt(str16);
					String str17 = cb7hdyear.getSelectedItem().toString();
					int d = Integer.parseInt(str17);
					stmt.executeUpdate("INSERT INTO Employee values('"+str1+"' , '"+str2+"' , '"+str3+"' , "+x+
					" , '"+str5+"' , "+y+" , '"+str7+"',"+z+" , '"+str9+"' , "+w+" , '"+str11+"' , '"+str12+"' , "+a+
					" , "+b+" , '"+str15+"' , "+c+" , "+d+")");
					JOptionPane.showMessageDialog(null,"Insertion Succeed ","Insertion message",JOptionPane.INFORMATION_MESSAGE);
					con.close();
					stmt.close();
					}
					catch(Exception ex){
						System.out.println(ex);
					}
				}
		});
		btn3 = new JButton("Update");
			btn3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ke){
					try{
					Connection con;
					Statement stmt;
					String url = "jdbc:mysql://localhost:3306/WDULaunchSystem";
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection(url,"root","daniel");
					stmt = con.createStatement();
					String str1 = fnametxt.getText();
					String str2 = lnametxt.getText();
					String str3 = empidtxt.getText();
					String str4 = salarytxt.getText();
					System.out.println(str4);
					int x = Integer.parseInt(str4);
					String str5 = empostxt.getText();
					String str6 = empteltxt.getText();
					System.out.println(str6);
					int y = Integer.parseInt(str6);
					String str7 = qualitxt.getText();
					String str8 = experitxt.getText();
					System.out.println(str8);
					int z = Integer.parseInt(str8);
					String str9 = empcitytxt.getText();
					String str10 = empagetxt.getText();
					System.out.println(str10);
					int w = Integer.parseInt(str10);
					
					String str11 = cb1sex.getSelectedItem().toString();
					String str12 = cb2bodmon.getSelectedItem().toString();
					String str13 = cb3bodday.getSelectedItem().toString();
					System.out.println(str11 + " " + str12 + " " + str13);
					int a = Integer.parseInt(str13);
					String str14 = cb4bodyear.getSelectedItem().toString();
					int b = Integer.parseInt(str14);
					String str15 = cb5hdmonth.getSelectedItem().toString();
					String str16 = cb6hdday.getSelectedItem().toString();
					int c = Integer.parseInt(str16);
					String str17 = cb7hdyear.getSelectedItem().toString();     
					int d = Integer.parseInt(str17);
					System.out.println(str17);
					stmt.executeUpdate("UPDATE Employee SET FName = '"+str1+"' , LName = '"+str2+"' , Salary = "+x+
					
					" , Emp_pos = '"+str5+"' , Emp_tel = "+y+" , Quali = '"+str7+"' , Experi = "+z+" , Emp_city = '"+str9+"' ,Emp_age = "+w+" , Sex = '"+str11+"' , DOB_mon = '"+str12+"' , DOB_day =  "+a+
					" , DOB_year = "+b+" , HD_mon = '"+str15+"' ,HD_day = "+c+" , HD_year = "+d+" WHERE EmpID = '"+str3+"'");
					JOptionPane.showMessageDialog(null,"Update Succeed ","Update message",JOptionPane.INFORMATION_MESSAGE);
					con.close();
					stmt.close();
					}
					catch(Exception ex){
						JOptionPane.showMessageDialog(null,"Exception occur ","Exception message",JOptionPane.INFORMATION_MESSAGE);
					}
				}
		});
		fnametxt = new JTextField(20);
		btn2 = new JButton("Back");
		btn2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ke){
					MainMenu menu = new MainMenu();	
					setVisible(false);
				}
		});
		fnametxt.addKeyListener(new KeyAdapter(){
				public void keyTyped(KeyEvent ke){
					char c = ke.getKeyChar();
					if(c < 65 || c > 91)
					if(c < 97 || c > 123)
					//if(c < 'A' || c > 'Z')
					//if(c < 'a' || c > 'z')
						ke.consume();
				}
		    });
		lnametxt = new JTextField(20);
		lnametxt.addKeyListener(new KeyAdapter(){
				public void keyTyped(KeyEvent ke){
					char c = ke.getKeyChar();
					if(c < 65 || c > 91)
					if(c < 97 || c > 123)
					//if(c < 'A' || c > 'Z')
					//if(c < 'a' || c > 'z')
						ke.consume();
				}
		    });
		empidtxt = new JTextField(20);
		salarytxt = new JTextField(20);
		salarytxt.addKeyListener(new KeyAdapter(){
				public void keyTyped(KeyEvent ke){
					char c = ke.getKeyChar();
					    if(c !='.')
						if(c < '0' || c > '9')
							ke.consume();
					
				}
		});
		empostxt = new JTextField(20);
		empostxt.addKeyListener(new KeyAdapter(){
				public void keyTyped(KeyEvent ke){
					char c = ke.getKeyChar();
					if(c < 65 || c > 91)
					if(c < 97 || c > 123)
					//if(c < 'A' || c > 'Z')
					//if(c < 'a' || c > 'z')
						ke.consume();
				}
		});
		empteltxt = new JTextField(20);
		empteltxt.addKeyListener(new KeyAdapter(){
				public void keyTyped(KeyEvent ke){
					char c = ke.getKeyChar();
				 		if(c < '0' || c > '9')
							ke.consume();
					
				}
		});
		qualitxt = new JTextField(20);
		experitxt = new JTextField(20);
		experitxt.addKeyListener(new KeyAdapter(){
				public void keyTyped(KeyEvent ke){
					char c = ke.getKeyChar();
				 		if(c < '0' || c > '9')
							ke.consume();
					
				}
		});
		empcitytxt = new JTextField(20);
		empcitytxt.addKeyListener(new KeyAdapter(){
				public void keyTyped(KeyEvent ke){
					char c = ke.getKeyChar();
					if(c < 65 || c > 91)
					if(c < 97 || c > 123)
					//if(c < 'A' || c > 'Z')
					//if(c < 'a' || c > 'z')
						ke.consume();
				}
		    });
		empagetxt = new JTextField(20);
		empagetxt.addKeyListener(new KeyAdapter(){
				public void keyTyped(KeyEvent ke){
					char c = ke.getKeyChar();
					if(c < 65 || c > 91)
					if(c < 97 || c > 123)
					//if(c < 'A' || c > 'Z')
					//if(c < 'a' || c > 'z')
						ke.consume();
				}
		    });
		empagetxt = new JTextField(20);
		empagetxt.addKeyListener(new KeyAdapter(){
				public void keyTyped(KeyEvent ke){
					char c = ke.getKeyChar();
						if(c < '0' || c > '9')
							ke.consume();
					
				}
		});
		p1 = new JPanel();
		p2 = new JPanel();
		//p3 = new JPanel();
		cb1sex = new JComboBox<>();
		cb1sex.addItem("Male");
		cb1sex.addItem("female");
		cb2bodmon = new JComboBox<>();
		cb2bodmon.addItem("September");
		cb2bodmon.addItem("October");
		cb2bodmon.addItem("November");
		cb2bodmon.addItem("December");
		cb2bodmon.addItem("January");
		cb2bodmon.addItem("February");
		cb2bodmon.addItem("March");
		cb2bodmon.addItem("April");
		cb2bodmon.addItem("May");
		cb2bodmon.addItem("June");
		cb2bodmon.addItem("Julay");
		cb2bodmon.addItem("August");
		cb3bodday = new JComboBox<>();
		cb3bodday.addItem("1");
		cb3bodday.addItem("2");
		cb3bodday.addItem("3");
		cb3bodday.addItem("4");
		cb3bodday.addItem("5");
		cb3bodday.addItem("6");
		cb3bodday.addItem("7");
		cb3bodday.addItem("8");
		cb3bodday.addItem("9");
		cb3bodday.addItem("10");
		cb3bodday.addItem("11");
		cb3bodday.addItem("12");
		cb3bodday.addItem("13");
		cb3bodday.addItem("14");
		cb3bodday.addItem("15");
		cb3bodday.addItem("16");
		cb3bodday.addItem("17");
		cb3bodday.addItem("18");
		cb3bodday.addItem("19");
		cb3bodday.addItem("20");
		cb3bodday.addItem("21");
		cb3bodday.addItem("22");
		cb3bodday.addItem("23");
		cb3bodday.addItem("24");
		cb3bodday.addItem("25");
		cb3bodday.addItem("26");
		cb3bodday.addItem("27");
		cb3bodday.addItem("28");
		cb3bodday.addItem("29");
		cb3bodday.addItem("30");
		cb4bodyear = new JComboBox<>();
		cb4bodyear.addItem("1690");
		cb4bodyear.addItem("1700");
		cb4bodyear.addItem("1710");
		cb4bodyear.addItem("1720");
		cb4bodyear.addItem("1730");
		cb4bodyear.addItem("1740");
		cb4bodyear.addItem("1750");
		cb4bodyear.addItem("1760");
		cb4bodyear.addItem("1770");
		cb4bodyear.addItem("1780");
		cb4bodyear.addItem("1790");
		cb4bodyear.addItem("1800");
		cb4bodyear.addItem("1810");
		cb4bodyear.addItem("1820");
		cb4bodyear.addItem("1830");
		cb4bodyear.addItem("1840");
		cb4bodyear.addItem("1850");
		cb5hdmonth = new JComboBox<>();
		cb5hdmonth.addItem("September");
		cb5hdmonth.addItem("October");
		cb5hdmonth.addItem("November");
		cb5hdmonth.addItem("December");
		cb5hdmonth.addItem("January");
		cb5hdmonth.addItem("February");
		cb5hdmonth.addItem("March");
		cb5hdmonth.addItem("April");
		cb5hdmonth.addItem("May");
		cb5hdmonth.addItem("June");
		cb5hdmonth.addItem("Julay");
		cb5hdmonth.addItem("August");
		cb6hdday = new JComboBox<>();
		cb6hdday.addItem("1");
		cb6hdday.addItem("2");
		cb6hdday.addItem("3");
		cb6hdday.addItem("4");
		cb6hdday.addItem("5");
		cb6hdday.addItem("6");
		cb6hdday.addItem("7");
		cb6hdday.addItem("8");
		cb6hdday.addItem("9");
		cb6hdday.addItem("10");
		cb6hdday.addItem("11");
		cb6hdday.addItem("12");
		cb6hdday.addItem("13");
		cb6hdday.addItem("14");
		cb6hdday.addItem("15");
		cb6hdday.addItem("16");
		cb6hdday.addItem("17");
		cb6hdday.addItem("18");
		cb6hdday.addItem("19");
		cb6hdday.addItem("20");
		cb6hdday.addItem("21");
		cb6hdday.addItem("22");
		cb6hdday.addItem("23");
		cb6hdday.addItem("24");
		cb6hdday.addItem("25");
		cb6hdday.addItem("26");
		cb6hdday.addItem("27");
		cb6hdday.addItem("28");
		cb6hdday.addItem("29");
		cb6hdday.addItem("30");
		cb7hdyear = new JComboBox<>();
		cb7hdyear.addItem("1690");
		cb7hdyear.addItem("1700");
		cb7hdyear.addItem("1710");
		cb7hdyear.addItem("1720");
		cb7hdyear.addItem("1730");
		cb7hdyear.addItem("1740");
		cb7hdyear.addItem("1750");
		cb7hdyear.addItem("1760");
		cb7hdyear.addItem("1770");
		cb7hdyear.addItem("1780");
		cb7hdyear.addItem("1790");
		cb7hdyear.addItem("1800");
		cb7hdyear.addItem("1810");
		cb7hdyear.addItem("1820");
		cb7hdyear.addItem("1830");
		cb7hdyear.addItem("1840");
		cb7hdyear.addItem("1850");
		cb7hdyear.addItem("1850");
		cb7hdyear.addItem("1690");
		cb7hdyear.addItem("1700");
		cb7hdyear.addItem("1710");
		cb7hdyear.addItem("1720");
		cb7hdyear.addItem("1730");
		cb7hdyear.addItem("1740");
		cb7hdyear.addItem("1750");
		cb7hdyear.addItem("1760");
		cb7hdyear.addItem("1770");
		cb7hdyear.addItem("1780");
		cb7hdyear.addItem("1790");
		p1.setBorder(b1);
		p2.setBorder(bb1);
		add(l1);
		add(fnametxt);
		add(l2);
		add(lnametxt);
		add(l3);
		add(empidtxt);
		add(l4);
		add(salarytxt);
		add(l5);
		add(empostxt);
		add(l6);
		add(empteltxt);
		add(l11);
		add(qualitxt);
		add(l10);
		add(experitxt);
		add(l12);
		add(empcitytxt);
		add(l13);
		add(empagetxt);
		add(l8);
		add(cb1sex);
		p1.add(cb2bodmon);
		p1.add(cb3bodday);
		p1.add(cb4bodyear);
		p2.add(cb5hdmonth);
		p2.add(cb6hdday);
		p2.add(cb7hdyear);
		add(p1);
		add(p2);
		add(btn1);
		add(btn2);
		add(btn3);
		//pack();
		setVisible(true);
	}
	public static void main(String args[]){
		Employee emp = new Employee();
	}

}

class Food extends JFrame{
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
JTextField tf1,tf2,tf3,tf4,tf5,tf6;
JComboBox <String> cb1,cb2,cb3,cb4,cb5;
JPanel p1;
static JButton btn1,btn3;
JButton btn2,butt;
	Food(){
		setTitle("Menu");
		setSize(940,400);
		setLocation(0,0);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		Border b = BorderFactory.createEtchedBorder();
	 	Border b1 = BorderFactory.createTitledBorder(b, "Food Menu");
		//l1 = new JLabel("Food Name:");
		l2 = new JLabel("Food no:");
		l3 = new JLabel("Quantity:");
		//l4 = new JLabel("Price:");
		l5 = new JLabel("Product code:");
		l6 = new JLabel(" Soft Drink:");
		l7 = new JLabel("Break Fast:");
		l8 = new JLabel("Lunch:");
		l9 = new JLabel("Dinner:");
		l10 = new JLabel("Hot Drink:");
		l11 = new JLabel("Total cost");
		btn1 = new JButton("Submit->");
			btn1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ke){
					try{
					Connection con;
					Statement stmt;
					String url = "jdbc:mysql://localhost:3306/WDULaunchSystem";
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection(url,"root","daniel");
					stmt = con.createStatement();
					String str1 = tf2.getText();
					int x = Integer.parseInt(str1);
					String str2 = tf3.getText();
					int y = Integer.parseInt(str2);
					String str3 = tf5.getText();
					//String str4 = tf3.getText();
					//int z = Integer.parseInt(str4);
					String str5 = cb1.getSelectedItem().toString();
					String str6 = cb2.getSelectedItem().toString();
					String str7 = cb3.getSelectedItem().toString();
					String str8 = cb4.getSelectedItem().toString();
					String str9 = cb5.getSelectedItem().toString();
					stmt.executeUpdate("INSERT INTO Food values("+x+" , "+y+" , '"+str3+"' , '"+str5+"' , '"+str6+"' , '"+str7+"' , '"+str8+"' , '"+str8+"')");
					JOptionPane.showMessageDialog(null,"Insertion Succeed ","Insertion message",JOptionPane.INFORMATION_MESSAGE);
					con.close();
					stmt.close();
					}
					catch(Exception ex){
						System.out.println(ex);
					}
				}
		});
		btn3 = new JButton("Modify");
			btn3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ke){
					try{
					Connection con;
					Statement stmt;
					String url = "jdbc:mysql://localhost:3306/WDULaunchSystem";
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection(url,"root","daniel");
					stmt = con.createStatement();
					String str1 = tf2.getText();
					int x = Integer.parseInt(str1);
					String str2 = tf3.getText();
					int y = Integer.parseInt(str2);
					String str3 = tf5.getText();
					//String str4 = tf3.getText();
					//int z = Integer.parseInt(str4);
					String str5 = cb1.getSelectedItem().toString();
					String str6 = cb2.getSelectedItem().toString();
					String str7 = cb3.getSelectedItem().toString();
					String str8 = cb4.getSelectedItem().toString();
					String str9 = cb5.getSelectedItem().toString();
					stmt.executeUpdate("UPDATE Food SET Quant = "+y+" , PCode = '"+str3+"' , so_dr  = '"+str5+"' , ho_dr = '"+str6+"' , br_fast = '"+str7+"' , Lunch = '"+str8+"' ,Dinner = '"+str8+"' WHERE Fo_no = "+x+" ");
					JOptionPane.showMessageDialog(null,"Update Succeed ","Update message",JOptionPane.INFORMATION_MESSAGE);
					con.close();
					stmt.close();
					}
					catch(Exception ex){
						System.out.println(ex);
					}
				}
		});
		btn2 = new JButton("Back");
		btn2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ke){
					MainMenu menu = new MainMenu();
					setVisible(false);
				}
		});
		tf1 = new JTextField(10);
		p1 = new JPanel();
		tf1.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent ke){
				char c = ke.getKeyChar();
				if(c < '0' || c > '9')
					ke.consume();
				
	
				}
		});
	tf6 = new JTextField(5);
	tf6.setEnabled(false);	
    butt = new JButton("Total");
	butt.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
		String st1,st2,st3,st4,st5,st6;
		float sodrprice = 0,hodrprice = 0,bfprice = 0,lprice = 0,dprice = 0;
		st1 = (String)cb1.getSelectedItem();
		if(st1 == "Fanta...7"){
			sodrprice = 7;
		}
		else if(st1 == "Pepsi...7"){
			sodrprice = 7;
		}
		else if(st1 == "Mirinda...7")
		{
			sodrprice = 7;
		}
		else if(st1 == "CocaCola...7")
		{
		sodrprice = 7;
		}
		else if(st1 == "7up...7")
		{
		sodrprice = 7;
		}
		else if(st1 == "Sprite...7")
		{
		sodrprice = 7;
		}
		else if(st1 == "Prigat Juice...15"){
			sodrprice = 15;
		}
		else if(st1 == "Mango Juice...15"){
			sodrprice = 15;
		}
		else if(st1 == "Water - 1/2 litre...7"){
			sodrprice = 7;
		}
		else if(st1 == "Water - 1 litre...10"){
			sodrprice = 10;
		}
		else if(st1 == "Water - 2 litre...15"){
			sodrprice = 15;
		}
		else{
			sodrprice = 0;
		}
		st2 =(String) cb2.getSelectedItem();
		if(st2 == " "){
			hodrprice = 0;
		}
		else if(st2 == "Tea...1"){
			hodrprice = 1;
		}
		else if(st2 == "Coffee...2"){
			hodrprice = 2;
		}
		else if(st2 == "Mango Tea...1"){
			hodrprice = 1;
		}
		else if(st2 == "Orange Tea...1"){
			hodrprice = 1;
		}
		else if(st2 == "Lewz...2"){
			hodrprice = 2;
		}
		else if(st2 == "Keshir...1"){
			hodrprice = 1;
		}
		else{
			hodrprice = 3;
		}
		
		st3 =(String) cb3.getSelectedItem();
		if(st3 == " "){
			bfprice = 0;
		}
		else if(st3 == "Injera Fifer...9"){
			bfprice = 9;
		}
		else if(st3 == "Dabo...2"){
			bfprice = 2;
		}
		else if(st3 == "Enkulal Firfir...12"){
			bfprice = 12;
		}
		else if(st3 == "Kuanta Firfer...18"){
			bfprice = 18;
		}
		else if(st3 == "Sanduch...7"){
			bfprice = 7;
		}
		else if(st3 == "Asanbusa...2"){
			bfprice = 2;
		}
		else if(st3 == "Bonbolino...3"){
			bfprice = 3;
		}
		else if(st3 == "Ambash...6"){
			bfprice = 6;
		}
		else if(st3 == "Makarone...10"){
			bfprice = 10;
		}
		else{
			bfprice = 9;
		}
		st4 = (String)cb4.getSelectedItem();
		if(st4 == " "){
			lprice = 0;
		}
		else if(st4 == "Beyeaynet...12"){
			lprice = 12;
		}
		else if(st4 == "Key Wot...20"){
			lprice = 20;
		}
		else if(st4 == "Key dinch...12"){
			lprice = 12;
		}
		else if(st4 == "Nech dinch...12"){
			lprice = 12;
		}
		else if(st4 == "Shiro...10"){
			lprice = 10;
		}
		else if(st4 == "Tegabeno...15"){
			lprice = 15;
		}
		else if(st4 == "Pasta...10"){
			lprice = 10;
		}
		else if(st4 == "Kik...15"){
			lprice = 15;
		}
		else if(st4 == "Misr...10"){
			lprice = 10;
		}
		else{
			lprice = 10;
		}
		st5 = (String) cb5.getSelectedItem();
		if(st5 == " "){
			dprice = 0;
		}
		else if(st5 == "Beyeaynet...12"){
			dprice = 12;
		}
		else if(st5 == "Key Wot...20"){
			dprice = 20;
		}
		else if(st5 == "Key dinch...12"){
			dprice = 12;
		}
		else if(st5 == "Nech dinch...12"){
			dprice = 12;
		}
		else if(st5 == "Shiro...11"){
			dprice = 11;
		}
		else if(st5 == "Tegabeno...15"){
			dprice = 15;
		}
		else if(st5 == "Pasta...10"){
			dprice = 10;
		}
		else if(st5 == "Kik...13"){
			dprice = 13;
		}
		else if(st5 == "Misr...9"){
			dprice = 11;
		}
		else{
			dprice = 9;
		}
		st6 = tf3.getText();
		float fl = Float.parseFloat(st6);
		//String st7 = tf1.getText();
		//float ft;
		//ft = Float.parseFloat(st7);
		float flt;
		flt = ((sodrprice + hodrprice + bfprice + lprice + dprice)*fl);		
		/*if(ft > flt){
			JOptionPane.showMessageDialog(null,"Thank you for the tip","Info message",JOptionPane.INFORMATION_MESSAGE);	
		}
		else if(ft == flt){
			JOptionPane.showMessageDialog(null,"Thank you you paid correctly ","Info message",JOptionPane.INFORMATION_MESSAGE);	
		}
		else{
			JOptionPane.showMessageDialog(null,"Your balance  is inssufcient please recorrect your payment","Error message",JOptionPane.ERROR_MESSAGE);
			System.out.println(flt);
			tf1.setText(" ");
		}*/
		tf6.setText(""+flt);
		JOptionPane.showMessageDialog(null,"Thank you For Your Invitation ","WDULaunch",JOptionPane.INFORMATION_MESSAGE);	
}
});
		
		tf2 = new JTextField(10);
		tf2.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent ke){
				char c = ke.getKeyChar();
				if(c < '0' || c > '9')
					ke.consume();
					
				}
		});
		tf3 = new JTextField(10);
			tf3.addKeyListener(new KeyAdapter(){
				public void keyTyped(KeyEvent ke){
					char c = ke.getKeyChar();
					    if(c !='.')
						if(c < '0' || c > '9')
							ke.consume();
					
				}
		});
		tf4 = new JTextField(10);
		tf5 = new JTextField(10);
		cb1 = new JComboBox<>();
		cb1.addItem("");
		cb1.addItem("Fanta...7");
		cb1.addItem("Pepsi...7");
		cb1.addItem("Mirinda...7");
		cb1.addItem("CocaCola...7");
		cb1.addItem("7Up...7");
		cb1.addItem("Sprite...7");
		cb1.addItem("Prigat Juice...15");
		cb1.addItem("Mango Juice...15");
		cb1.addItem("Water - 1/2 litre...7");
		cb1.addItem("Water - 1 litre...10");
		cb1.addItem("Water - 2 litre...15");
		cb1.addItem("");
		cb1.addItem("");
		cb1.addItem("");
		cb2 = new JComboBox<>();
		cb2.addItem("");
		cb2.addItem("Tea...1");
		cb2.addItem("Coffee...2");
		cb2.addItem("Mango Tea...1");
		cb2.addItem("Orange Tea...1");
		cb2.addItem("Lewz...2");
		cb2.addItem("Keshir...1");
		cb2.addItem("Milk...3");
		cb3 = new JComboBox<>();
		cb3.addItem("");
		cb3.addItem("Injera Firfer...9");
		cb3.addItem("Dabo...2");
		cb3.addItem("Enkulal Firfir...12");
		cb3.addItem("Kuanta Firfer...18");
		cb3.addItem("Sanduch...7");
		cb3.addItem("Asanbusa...7");
		cb3.addItem("Bonbolino...3");
		cb3.addItem("Ambasha...6");
		cb3.addItem("Makarone...10");
		cb3.addItem("Ruz...9");
		cb4 = new JComboBox<>();
		cb4.addItem("");
		cb4.addItem("Beyeaynet...12");
		cb4.addItem("Key wot...20");
		cb4.addItem("Key dinch...12");
		cb4.addItem("Nech dinch...12");
		cb4.addItem("Shiro...10");
		cb4.addItem("Tegabeno...15");
		cb4.addItem("Pasta...10");
		cb4.addItem("kik...15");
		cb4.addItem("Misr...10");
		cb4.addItem("Enkula sils...10");
		cb4.addItem("");
		cb5 = new JComboBox<>();
		cb5.addItem("");
		cb5.addItem("Beyeaynet...12");
		cb5.addItem("Key wot...20");
		cb5.addItem("Key dinch...12");
		cb5.addItem("Nech dinch...12");
		cb5.addItem("Shiro...11");
		cb5.addItem("Tegabeno...15");
		cb5.addItem("Pasta...10");
		cb5.addItem("kik...10");
		cb5.addItem("Misr...9");
		cb5.addItem("Enkula sils...9");
		cb5.addItem("");
		p1.setBorder(b1);
		p1.add(l6);
		p1.add(cb1);
		p1.add(l10);
		p1.add(cb2);
		p1.add(l7);
		p1.add(cb3);
		p1.add(l8);
		p1.add(cb4);
		p1.add(l9);
		p1.add(cb5);
		add(l2);
		add(tf2);
		add(l3);
		add(tf3);
		//add(l4);
		//add(tf1);
		add(l5);
		add(tf5);
		add(p1);
		add(btn1);
		add(btn2);
		add(butt);
		add(btn3);
		add(l11);
		add(tf6);
		setVisible(true);
	}
	public static void main(String args[]){
		Food food  = new Food();
	}
}

class Suplier extends JFrame{
JLabel l1,l2,l3,l4,l5,l6;
JTextField tf1,tf2,tf3,tf4,tf5,tf6;
JPanel p1;
static JButton btn1,btn3;
JButton btn2;
	Suplier(){
		setTitle("Suplier Info");
		setSize(800,400);
		setLocation(0,0);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		l1 = new JLabel("Supplier Company name");
		l2 = new JLabel("City");
		l3 = new JLabel("Email");
		l4 = new JLabel("Telephone no");
		l6 = new JLabel("Sup_no");
		tf1 = new JTextField(20);
		tf2 = new JTextField(10);
		tf3 = new JTextField(20);
		tf4 = new JTextField(20);
		tf6 = new JTextField(5);
		btn1 = new JButton("Submit->");
		
			btn1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ke){
					try{
					Connection con;
					Statement stmt;
					String url = "jdbc:mysql://localhost:3306/WDULaunchSystem";
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection(url,"root","daniel");
					stmt = con.createStatement();
					String str1 = tf1.getText();
					String str2 = tf2.getText();
					String str3 = tf3.getText();
					String str4 = tf4.getText();
					int y = Integer.parseInt(str4);
					String str5 = tf6.getText();
					int k = Integer.parseInt(str5);
					stmt.executeUpdate("INSERT INTO Suplier values('"+str1+"' , '"+str2+"' , '"+str3+"' , "+y+" , "+k+" )");
					JOptionPane.showMessageDialog(null,"Inserted successfully ","Insertion message",JOptionPane.INFORMATION_MESSAGE);
					con.close();
					stmt.close();
					}
					catch(Exception ex){
						System.out.println(ex);
					}
				}
		});
		btn3 = new JButton("Modify");
		btn3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ke){
					try{
					Connection con;
					Statement stmt;
					String url = "jdbc:mysql://localhost:3306/WDULaunchSystem";
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection(url,"root","daniel");
					stmt = con.createStatement();
					String str1 = tf1.getText();
					String str2 = tf2.getText();
					String str3 = tf3.getText();
					String str4 = tf4.getText();
					int y = Integer.parseInt(str4);
					String str5 = tf6.getText();
					int k = Integer.parseInt(str5);
					stmt.executeUpdate("UPDATE Suplier SET Sup_name = '"+str1+"' ,Sup_city = '"+str2+"' ,Email = '"+str3+"' ,Sup_tel = "+y+" WHERE Sup_no = "+k+"");
					JOptionPane.showMessageDialog(null,"Update successfully ","Update message",JOptionPane.INFORMATION_MESSAGE);
					con.close();
					stmt.close();
					}
					catch(Exception ex){
						System.out.println(ex);
					}
				}
		});
		btn2 = new JButton("Back");
		btn2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ke){
					MainMenu menu = new MainMenu();
					setVisible(false);
				}
		});
		tf4.addKeyListener(new KeyAdapter(){
				public void keyTyped(KeyEvent ke){
					char c = ke.getKeyChar();
						if(c < '0' || c > '9')
							ke.consume();					
				}
		});
		add(l1);
		add(tf1);
		add(l2);
		add(tf2);
		add(l3);
		add(tf3);
		add(l4);
		add(tf4);
		add(l6);
		add(tf6);
		add(btn1);
		add(btn2);
		add(btn3);
		setVisible(true);
	}
	public static void main(String args[]){
		Suplier sup = new Suplier();
	}
}

class Order extends JFrame{
JLabel l1,l2,l3,l4,l5,l6;
JTextField tf1,tf2,tf3,tf4,tf5,tf6;
JComboBox <String> cb1,cb2,cb3,cb4,cb5,cb6,cb7;
JPanel p1,p2;
static JButton btn1,btn3;
JButton btn2;
	Order(){
		setTitle("Order Form");
		setSize(750,400);
		setLocation(0,0);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		Border b = BorderFactory.createEtchedBorder();
	 	Border b1 = BorderFactory.createTitledBorder(b, "Order Date");
		Border bb = BorderFactory.createEtchedBorder();
	 	Border bb1 = BorderFactory.createTitledBorder(bb, "Paid Date");
		p1 = new JPanel();
		p2 = new JPanel();
		l1 = new JLabel("Order No:");
		l2 = new JLabel("Order Date:");
		l3 = new JLabel("Payment Type:");
		l4 = new JLabel("Paid Date:");
		l5 = new JLabel("Order Quality:");
		l6 = new JLabel("Order Quantity:");
		btn1 = new JButton("Submit->");
		
			btn1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ke){
					try{
					Connection con;
					Statement stmt;
					String url = "jdbc:mysql://localhost:3306/WDULaunchSystem";
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection(url,"root","daniel");
					stmt = con.createStatement();
					String str1 = tf1.getText();
					int x = Integer.parseInt(str1);
					String str2 = tf2.getText();
					int y = Integer.parseInt(str2);
					String str3 = cb4.getSelectedItem().toString();
					String str4 = cb7.getSelectedItem().toString();
					String str5 = cb2.getSelectedItem().toString();
					String str6 = cb3.getSelectedItem().toString();
					int z = Integer.parseInt(str6);
					String str7 = cb5.getSelectedItem().toString();
					String str8 = cb6.getSelectedItem().toString();
					int a = Integer.parseInt(str8);
					stmt.executeUpdate("INSERT INTO Orderr values("+x+" , "+y+" , '"+str3+"' , '"+str4+
					"' , '"+str5+"' , "+z+" , '"+str7+"' , "+a+")");
					JOptionPane.showMessageDialog(null,"Insertion Succeed ","Insertion message",JOptionPane.INFORMATION_MESSAGE);
					con.close();
					stmt.close();
					}
					catch(Exception ex){
						System.out.println(ex);
					}
				}
		});
		btn3 = new JButton("Modify");
		
		btn3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ke){
					try{
					Connection con;
					Statement stmt;
					String url = "jdbc:mysql://localhost:3306/WDULaunchSystem";
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection(url,"root","daniel");
					stmt = con.createStatement();
					String str1 = tf1.getText();
					int x = Integer.parseInt(str1);
					String str2 = tf2.getText();
					int y = Integer.parseInt(str2);
					String str3 = cb4.getSelectedItem().toString();
					String str4 = cb7.getSelectedItem().toString();
					String str5 = cb2.getSelectedItem().toString();
					String str6 = cb3.getSelectedItem().toString();
					int z = Integer.parseInt(str6);
					String str7 = cb5.getSelectedItem().toString();
					String str8 = cb6.getSelectedItem().toString();
					int a = Integer.parseInt(str8);
					stmt.executeUpdate("UPDATE  Orderr SET or_qunt = "+y+" ,pay_type = '"+str3+"' ,or_qual = '"+str4+
					"' ,or_mon = '"+str5+"' , or_day = "+z+" , pa_mo = '"+str7+"' , pay_day = "+a+" WHERE  or_no = "+x+"");
					JOptionPane.showMessageDialog(null,"Update Succeed ","Update message",JOptionPane.INFORMATION_MESSAGE);
					con.close();
					stmt.close();
					}
					catch(Exception ex){
						System.out.println(ex);
					}
				}
		});
		
		btn2 = new JButton("Back");
		btn2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ke){
					MainMenu menu = new MainMenu();
					setVisible(false);
				}
		});
		tf1 = new JTextField(10);
		tf1.addKeyListener(new KeyAdapter(){
				public void keyTyped(KeyEvent ke){
					char c = ke.getKeyChar();
						if(c < '0' || c > '9')
							ke.consume();					
				}
		});
		tf2 = new JTextField(10);
		tf2.addKeyListener(new KeyAdapter(){
				public void keyTyped(KeyEvent ke){
					char c = ke.getKeyChar();
						if(c < '0' || c > '9')
							ke.consume();					
				}
		});
		tf3 = new JTextField(20);
		cb2 = new JComboBox<>();
		cb2.addItem("September");
		cb2.addItem("October");
		cb2.addItem("November");
		cb2.addItem("December");
		cb2.addItem("January");
		cb2.addItem("February");
		cb2.addItem("March");
		cb2.addItem("April");
		cb2.addItem("May");
		cb2.addItem("June");
		cb2.addItem("Julay");
		cb2.addItem("August");
		cb3 = new JComboBox<>();
		cb3.addItem("1");
		cb3.addItem("2");
		cb3.addItem("3");
		cb3.addItem("4");
		cb3.addItem("5");
		cb3.addItem("6");
		cb3.addItem("7");
		cb3.addItem("8");
		cb3.addItem("9");
		cb3.addItem("10");
		cb3.addItem("11");
		cb3.addItem("12");
		cb3.addItem("13");
		cb3.addItem("14");
		cb3.addItem("15");
		cb3.addItem("16");
		cb3.addItem("17");
		cb3.addItem("18");
		cb3.addItem("19");
		cb3.addItem("20");
		cb3.addItem("21");
		cb3.addItem("22");
		cb3.addItem("23");
		cb3.addItem("24");
		cb3.addItem("25");
		cb3.addItem("26");
		cb3.addItem("27");
		cb3.addItem("28");
		cb3.addItem("29");
		cb3.addItem("30");
		cb4 = new JComboBox<>();
		cb4.addItem("Cash");
		cb4.addItem("Check");
		cb5 = new JComboBox<>();
		cb5.addItem("September");
		cb5.addItem("October");
		cb5.addItem("November");
		cb5.addItem("December");
		cb5.addItem("January");
		cb5.addItem("February");
		cb5.addItem("March");
		cb5.addItem("April");
		cb5.addItem("May");
		cb5.addItem("June");
		cb5.addItem("Julay");
		cb5.addItem("August");
		cb6 = new JComboBox<>();
		cb6.addItem("1");
		cb6.addItem("2");
		cb6.addItem("3");
		cb6.addItem("4");
		cb6.addItem("5");
		cb6.addItem("6");
		cb6.addItem("7");
		cb6.addItem("8");
		cb6.addItem("9");
		cb6.addItem("10");
		cb6.addItem("11");
		cb6.addItem("12");
		cb6.addItem("13");
		cb6.addItem("14");
		cb6.addItem("15");
		cb6.addItem("16");
		cb6.addItem("17");
		cb6.addItem("18");
		cb6.addItem("19");
		cb6.addItem("20");
		cb6.addItem("21");
		cb6.addItem("22");
		cb6.addItem("23");
		cb6.addItem("24");
		cb6.addItem("25");
		cb6.addItem("26");
		cb6.addItem("27");
		cb6.addItem("28");
		cb6.addItem("29");
		cb6.addItem("30");
		cb7 = new JComboBox<>();
		cb7.addItem("High");
		cb7.addItem("Medium");
		cb7.addItem("Low");
		p1.setBorder(b1);
		p2.setBorder(bb1);
		add(l1);
		add(tf1);
		add(l6);
		add(tf2);
		add(l3);
		add(cb4);
		add(l5);
		add(cb7);
		add(l2);
		p1.add(cb2);
		p1.add(cb3);
		add(p1);
		add(l4);
		p2.add(cb5);
		p2.add(cb6);
		add(p2);
		add(btn1);
		add(btn2);
		add(btn3);
		setVisible(true);
		}
	public static void main(String args[]){
		Order order = new Order();
	}
}
class CustomerView extends JFrame{
JTable table;
JScrollPane pan;
JButton btn;
JPanel p;
CustomerView(){
	btn = new JButton("back");
	btn.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			new MainMenu();
			setVisible(false);
		}
	});
	setSize(1400,200);
	p = new JPanel();
	setResizable(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	table = new JTable();
	pan = new JScrollPane();
	setLayout(new FlowLayout());
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/WDULaunchSystem", "root", "daniel");
		Statement st = conn.createStatement();
		String query = "select * from Customer";
		ResultSet rs = st.executeQuery(query);
		if (rs.next()) {       
			Object[] rows = {"FName","LName","CustID","CustTel","Custcity","CustAge","sex","Address","Email"};
			DefaultTableModel model = new DefaultTableModel();
			model.setColumnIdentifiers(rows);
			table.setModel(model);
			table.setRowHeight(30);
			pan.setBounds(960, 410, 1800, 100);
			pan.add(table);
			//conn.add(pan);
			rs.beforeFirst();
			while (rs.next()){				
				String a = rs.getString("FName");
				System.out.println(a);
				String b = rs.getString("LName");
				String c = rs.getString("CustID");
				int d = rs.getInt("CustTel");
				String e = rs.getString("Custcity");
				int f = rs.getInt("CustAge");
				String g = rs.getString("sex");
				String h = rs.getString("Address");
				String i = rs.getString("Email");
				model.addRow(new Object[]{a,b,c,d,e,f,g,h,i});
			  }
		} else {
		System.out.println("dsds");
			JOptionPane.showMessageDialog(null, "There is no Customer", "Customer information", 1);
		}
		rs.close();
	} catch (Exception ex) {
		System.out.println("sfsdfsdfdsfsdfds\n" + ex);
		//JOptionPane.showMessageDialog(null, ex.getMessage(), "error", 0);
	}
	//p.add(btn);
	add(table);
	add(btn);
	//add(p);
	//add(p,BorderLayout.SOUTH);
	setVisible(true);
}
}
class EmployeeView extends JFrame{
JTable table;
JScrollPane pan;
JButton btn;
JPanel p;
EmployeeView(){
	btn = new JButton("back");
	btn.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			new MainMenu();
			setVisible(false);
		}
	});
	setSize(1400,200);
	p = new JPanel();
	setResizable(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	table = new JTable();
	pan = new JScrollPane();
	setLayout(new FlowLayout());
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/WDULaunchSystem", "root", "daniel");
		Statement st = conn.createStatement();
		String query = "select * from Employee";
		ResultSet rs = st.executeQuery(query);
		if (rs.next()) {       
			Object[] rows = {"FName","LName","EMPID","Salary","Emp_pos","Emp_tel","Quali","Experi","Emp_city" , "Emp_age" , "Sex" , "DOB_mon" , "DOB_day" , "DOB_year" , "HD_mon" , "HD_day" , "HD_year"};
			DefaultTableModel model = new DefaultTableModel();
			model.setColumnIdentifiers(rows);
			table.setModel(model);
			table.setRowHeight(30);
			pan.setBounds(960, 410, 1800, 100);
			pan.add(table);
			//conn.add(pan);
			rs.beforeFirst();
			while (rs.next()){
				String a = rs.getString("FName");
				String b = rs.getString("LName");
				String c = rs.getString("EmpID");
				int d = rs.getInt("Salary");
				String e = rs.getString("Emp_pos");
				int f = rs.getInt("Emp_tel");
				String g = rs.getString("Quali");
				int h = rs.getInt("Experi");
				String i = rs.getString("Emp_city");
				int j = rs.getInt("Emp_age");
				String k = rs.getString("Sex");
				String l = rs.getString("DOB_mon");
				int m = rs.getInt("DOB_day");
				int n = rs.getInt("DOB_year");
				String o = rs.getString("HD_mon");
				int p = rs.getInt("HD_day");
				int q = rs.getInt("HD_year");
				model.addRow(new Object[]{a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q});
			  }
		} else{ 
			JOptionPane.showMessageDialog(null, "There is no Employee", "Employee information", 1);
		}
		rs.close();
		//p.add(btn);
	add(table);
	add(btn);
	//add(p);
	//add(p,BorderLayout.SOUTH);
	setVisible(true);
	} catch (Exception ex) {
		System.out.println( ex);
		//JOptionPane.showMessageDialog(null, ex.getMessage(), "error", 0);
	}
}
}
class FoodView extends JFrame{
JTable table;
JScrollPane pan;
JButton btn;
JPanel p;
FoodView(){
	btn = new JButton("back");
	btn.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			new MainMenu();
			setVisible(false);
		}
	});
	setSize(1400,200);
	p = new JPanel();
	setResizable(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	table = new JTable();
	pan = new JScrollPane();
	setLayout(new FlowLayout());
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/WDULaunchSystem", "root", "daniel");
		Statement st = conn.createStatement();
		String query = "select * from Food";
		ResultSet rs = st.executeQuery(query);
		if (rs.next()) {       
			Object[] rows = {"Fo_no","Quant","PCode","so_dr","ho_dr","br_fast","Lunch","Dinner"};
			DefaultTableModel model = new DefaultTableModel();
			model.setColumnIdentifiers(rows);
			table.setModel(model);
			table.setRowHeight(30);
			pan.setBounds(960, 410, 1800, 100);
			pan.add(table);
			//conn.add(pan);
			rs.beforeFirst();
			while (rs.next()){
				int a = rs.getInt("Fo_no");
				int b = rs.getInt("Quant");
				String c = rs.getString("PCode");
				String d = rs.getString("so_dr");
				String e = rs.getString("ho_dr");
				String f = rs.getString("br_fast");
				String g = rs.getString("Lunch");
				String h = rs.getString("Dinner");
				model.addRow(new Object[]{a,b,c,d,e,f,g,h,});
			  }
		} else {
			JOptionPane.showMessageDialog(null, "There is no Food", "Food information", 1);
		}
		rs.close();
	} catch (Exception ex) {
		System.out.println(ex);
		JOptionPane.showMessageDialog(null, ex.getMessage(), "error", 0);
	}
	//p.add(btn);
	add(table);
	add(btn);
	//add(p);
	//add(p,BorderLayout.SOUTH);
	pack();
	setVisible(true);
}
}
class SuplierView extends JFrame{
JTable table;
JScrollPane pan;
JButton btn;
JPanel p;
SuplierView(){
	btn = new JButton("back");
	btn.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			new MainMenu();
			setVisible(false);
		}
	});
	setSize(1400,200);
	p = new JPanel();
	setResizable(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	table = new JTable();
	pan = new JScrollPane();
	setLayout(new FlowLayout());
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/WDULaunchSystem", "root", "daniel");
		Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		String query = "select * from Suplier";
		ResultSet rs = st.executeQuery(query);
		if (rs.next()) {       
			Object[] rows = {"Sup_name","Sup_city","Email","Sup_tel","Sup_no"};
			DefaultTableModel model = new DefaultTableModel();
			model.setColumnIdentifiers(rows);
			table.setModel(model);
			table.setRowHeight(30);
			pan.setBounds(960, 410, 1800, 100);
			pan.add(table);
			//conn.add(pan);
			rs.beforeFirst();
			while (rs.next()){				
				String a = rs.getString("Sup_name");
				String b = rs.getString("Sup_city");
				String c = rs.getString("Email");
				int d = rs.getInt("Sup_tel");
				int e = rs.getInt("Sup_no");
				model.addRow(new Object[]{a,b,c,d,e});
			  }
		} else {
			JOptionPane.showMessageDialog(null, "There is no Suplier", "Suplier information", 1);
		}
		rs.close();
	} catch (Exception ex) {
		System.out.println(ex);
		JOptionPane.showMessageDialog(null, ex.getMessage(), "error", 0);
	}
	//p.add(btn);
	add(table);
	add(btn);
	//add(p);
	//add(p,BorderLayout.SOUTH);
	pack();
	setVisible(true);
}
}
class OrderView extends JFrame{
JTable table;
JScrollPane pan;
JButton btn;
JPanel p;
OrderView(){
	btn = new JButton("back");
	btn.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			new MainMenu();
			setVisible(false);
		}
	});
	setSize(1400,200);
	p = new JPanel();
	setResizable(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	table = new JTable();
	pan = new JScrollPane();
	setLayout(new FlowLayout());
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/WDULaunchSystem", "root", "daniel");
		Statement st = conn.createStatement();
		String query = "select * from Orderr";
		ResultSet rs = st.executeQuery(query);
		if (rs.next()) {       
			Object[] rows = {"or_no","or_qunt","pay_type","or_qual","or_mon","or_day","pa_mo","pay_day"};
			DefaultTableModel model = new DefaultTableModel();
			model.setColumnIdentifiers(rows);
			table.setModel(model);
			table.setRowHeight(30);
			pan.setBounds(960, 410, 1800, 100);
			pan.add(table);
			//conn.add(pan);
			rs.beforeFirst();
			while (rs.next()){				
				int a = rs.getInt("or_no");
				int b = rs.getInt("or_qunt");
				String c = rs.getString("pay_type");
				String d = rs.getString("or_qual");
				String e = rs.getString("or_mon");
				int f = rs.getInt("or_day");
				String g = rs.getString("pa_mo");
				int h = rs.getInt("pay_day");
				model.addRow(new Object[]{a,b,c,d,e,f,g,h});
			  }
		} else {
		System.out.println("dsds");
			JOptionPane.showMessageDialog(null, "There is no Order", "Order information", 1);
		}
		rs.close();
	} catch (Exception ex) {
		System.out.println(ex);
		JOptionPane.showMessageDialog(null, ex.getMessage(), "error", 0);
	}
	//p.add(btn);
	add(table);
	add(btn);
	//add(p);
	//add(p,BorderLayout.SOUTH);
	pack();
	setVisible(true);
}
}
class Member extends JFrame{
JButton btn;
JComboBox <String> member;
Member(){
setSize(400,400);
btn = new JButton("Back");
btn.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			new MainMenu();
			setVisible(false);
		}
	});
setTitle("Developer");
setLayout(new FlowLayout());
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setResizable(true);
ImageIcon gg = new ImageIcon(getClass().getResource("woldia.png"));
        JLabel lbo = new JLabel(gg);
        lbo.setBounds(500, 2, 300, 2);
		member = new JComboBox<>();
		member.addItem("              Group---Members");
		member.addItem("     Name                              ID");
		member.addItem("Daniel Tefera ----------1699/08");
		member.addItem("Yohanes Tiruneh -----1924/08");
		member.addItem("Abere Maru ------------1640/08");
		member.addItem("Senait Anteneh -------3084/08");
		member.addItem("Rehaset Tesfaye -----1858/08");
		member.addItem("Zewudie Ayalew --------0303/07");
		member.addItem("Natnael Wondeson ----2360/06");
        add(lbo);
		add(member);
		add(btn);
		pack();
		setVisible(true);
		
}
}

