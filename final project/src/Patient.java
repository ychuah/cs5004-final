import java.text.SimpleDateFormat;
import java.util.Date;

public class Patient {
	private String patientName;
	private int birthDay;
	private int birthMonth;
	private int birthYear;
	private boolean covidSymptoms;
	
	public String getPatientName() {return patientName;}
//	public Date dateOfBirth() {return dateOfBirth;}
	public boolean covidSymptoms() {return covidSymptoms;}
		
	//constructor
	Patient(String patientName, int birthDate, int birthMonth, int birthYear, boolean covidSymptoms) {
		this.patientName = patientName;
		this.birthDay = birthDate;
		this.birthMonth = birthMonth;
		this.birthYear = birthYear;
		this.covidSymptoms = covidSymptoms;
		
		Date dateOfBirth = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
		
	}

	
}
