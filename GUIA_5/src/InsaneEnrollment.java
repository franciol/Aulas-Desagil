
public class InsaneEnrollment extends Enrollment{
	double penalty;
	
	
	public InsaneEnrollment(int idIn, String nameIn, double penalty) {
		super(idIn, nameIn);
		this.penalty = penalty;
	}
	
	@Override
	double getFinalGrade() {
	double fim =  this.penalty * finalGrade;
		return fim;
		
	}
	
	

}
