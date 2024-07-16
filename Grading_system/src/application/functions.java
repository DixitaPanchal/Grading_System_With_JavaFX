package application;

public class functions {
	
		
	public double calculateTotal(double[] marks)
	{
		double total = 0.0;
		for(double mark: marks)
		{
			total += mark;
		}
		
		return total;
	}
	
	public double calculateAverage(double[] marks)
	{
		double total = calculateTotal(marks);
		return total / marks.length;
	}
	
	public double calculatePercentage(double total, double maxTotal)
	{
		return (total/maxTotal)*100;
	}
	
	
	public char calculategrade(double total, double maxTotal)
	{
		if(calculatePercentage(total, maxTotal) >= 90)
			return 'A';
		else if(calculatePercentage(total, maxTotal) < 90 && calculatePercentage(total, maxTotal)>=80)
			return 'B';
		else if(calculatePercentage(total, maxTotal) < 80 && calculatePercentage(total, maxTotal)>=70)
			return 'C';
		else if(calculatePercentage(total, maxTotal) < 70 && calculatePercentage(total, maxTotal)>=60)
			return 'D';
		else if(calculatePercentage(total, maxTotal) < 60 && calculatePercentage(total, maxTotal)>=50)
			return 'E';
		else
			return 'F';

		
	}


}
