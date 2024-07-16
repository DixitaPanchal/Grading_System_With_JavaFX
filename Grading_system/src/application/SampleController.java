package application;

import java.net.URL;
import java.util.ResourceBundle;

import data.Student;
import data.dataflow;
import data.userprocesses;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SampleController implements Initializable {
	
	functions fn = new functions();
	
	String nm, rn, sec;
	
	double english, maths, science, socialsci,hindilang;
	
	char ResultGrade;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		addDoubleValidation(eng);
		addDoubleValidation(math);
		addDoubleValidation(sci);
		addDoubleValidation(ss);
		addDoubleValidation(hindi);
		  
		
		// TODO Auto-generated method stub
		calculatebtn.setOnAction(new EventHandler<ActionEvent>() {
			
						
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				try{
					
					if(checkTextFields())
					{
						english = Double.parseDouble(eng.getText());
						maths = Double.parseDouble(math.getText());
						science = Double.parseDouble(sci.getText());
						socialsci = Double.parseDouble(ss.getText());
						hindilang = Double.parseDouble(hindi.getText());
						
						double[] marks = {english, maths, science, socialsci, hindilang};
						
						double total = fn.calculateTotal(marks);
						double average = fn.calculateAverage(marks);
						
						double percentage = fn.calculatePercentage(total, marks.length *100);
						
						char grade = fn.calculategrade(total, marks.length*100);
						
						if(percentage<=100 && total<=500 && average<=500)
						{
							percentagelb.setText(String.valueOf(percentage)+ "%");
							totallb.setText(String.valueOf(total));
							avglb.setText(String.valueOf(average));
							gradelb.setText(String.valueOf(grade));

							
						}
						else
						{
							errorlb.setText("Please enter the marks less than or equal to 100");
						}
						
				
						
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();

				
			}
		}});
		
		clearbtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub\
				
				name.clear();
				rollno.clear();
				section.clear();
				eng.clear();
				math.clear();
				sci.clear();
				ss.clear();
				hindi.clear();
				totallb.setText("");
				avglb.setText("");
				errorlb.setText("");
				gradelb.setText("");
				percentagelb.setText("");
				
				
				
			}
		});
		
		savebtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				if(checkTextFields())
				{
				gText();
				errorlb.setText("Saved");
				
				}
				
			}
		});
	
	}
	
	
	
    @FXML
    private TextField name;

    @FXML
    private Label errorlb;

    @FXML
    private TextField rollno;

    @FXML
    private TextField section;

    @FXML
    private TextField eng;

    @FXML
    private TextField math;

    @FXML
    private TextField sci;

    @FXML
    private TextField ss;

    @FXML
    private TextField hindi;

    @FXML
    private Label totallb;

    @FXML
    private Label avglb;

    @FXML
    private Label gradelb;

    @FXML
    private Button calculatebtn;

    @FXML
    private Label percentagelb;

    @FXML
    private Button clearbtn;

    @FXML
    private Button savebtn;
    
    
    
    
    
    private void addDoubleValidation(TextField textField) {
    	textField.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observableValue,
					String oldValue, String newValue) {
				// TODO Auto-generated method stub
				if(!newValue.matches("\\d*(\\.\\d*)?")){
					textField.setText(oldValue);
					errorlb.setText("Please enter valid numbers for marks");
				}
				else{
					try{
						double value = Double.parseDouble(newValue);
						if(value > 100)
						{
							textField.setText(oldValue);
							errorlb.setText("Values must be less than or equal to 100");
						}
						else
						{
							errorlb.setText("");
						}
					}
					catch(Exception e)
					{
						errorlb.setText("Please enter valid number for marks");
					}
				}
				
			}
    		
    		
		});
    }
    
    
    
    
    
    boolean checkTextFields() {
    	TextField[] fields = {name, rollno, section, eng, math, sci, ss, hindi};
    	
    	for(TextField field: fields)
    	{
    		if(field.getText().isEmpty())
    		{
        		errorlb.setText("Please enter all the data");
        		return false;
    		}

    		
    	}
    	
    		errorlb.setText("");
    		return true;
    	
    }
    
  
    
    public void gText() {
    	
    	nm = name.getText();
    	rn = rollno.getText();
    	sec = section.getText();
    	english = Double.parseDouble(eng.getText());
		maths = Double.parseDouble(math.getText());
		science = Double.parseDouble(sci.getText());
		socialsci = Double.parseDouble(ss.getText());
		hindilang = Double.parseDouble(hindi.getText());
		
		double[] marks = {english, maths, science, socialsci, hindilang};
		
		double total = fn.calculateTotal(marks);
		double average = fn.calculateAverage(marks);
		
		double percentage = fn.calculatePercentage(total, marks.length *100);
		
		char grade = fn.calculategrade(total, marks.length*100);
    	
  
    	dataflow.studentobj = new Student();
    	dataflow.studentobj.setName(nm);
    	dataflow.studentobj.setRollno(rn);
    	dataflow.studentobj.setSection(sec);
    	dataflow.studentobj.setEng(english);
    	dataflow.studentobj.setMath(maths);
    	dataflow.studentobj.setSci(science);
    	dataflow.studentobj.setSs(socialsci);
    	dataflow.studentobj.setHindi(hindilang);
    	dataflow.studentobj.setTotal(total);
    	dataflow.studentobj.setAverage(average);
    	dataflow.studentobj.setPercentage(percentage);
    	dataflow.studentobj.setGrade(grade);
    	
    	
    	userprocesses.saveData(nm, rn, sec, english, maths, science, socialsci, hindilang, total, average, percentage, grade);
    	
    }
    
   


	
}
