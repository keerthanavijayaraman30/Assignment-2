package employeeSalary;

public class EmpSalary {

	double basic;
	double boa;
	double bonus;
	int grade;
	double mgross;
	double pf;
	double ygross;
	double tax;
	double takehome;

	public EmpSalary(int gr, double bas, double all, double bo) {
		this.grade = gr;
		this.basic = bas;
		this.boa = all;
		this.bonus = bo;

	}

	
	// calculate monthly
	void calcMonthlyGross() {
		pf = basic * 0.12;
		mgross = (basic + boa + bonus)-pf;

	}

	// tax deduction
	void taxDeduction() {
		ygross = mgross * 12;
		if (ygross <= 250000) {
			tax = 0.0;
		} else if (ygross > 250000 && ygross < 500000) {
			tax = (0.05 * ygross) / 12;
		} else if (ygross > 500000 && ygross < 750000) {
			tax = (0.10 * ygross) / 12;
		} else if (ygross > 750000 && ygross < 1000000) {
			tax = (0.15 * ygross) / 12;
		} else if (ygross > 1000000 && ygross < 1250000) {
			tax = (0.20 * ygross) / 12;
		} else if (ygross > 1250000 && ygross < 1500000) {
			tax = (0.25 * ygross) / 12;
		} else if (ygross > 1500000) {
			tax = (0.30 * ygross) / 12;
		}
	}

	void calcMonthlySal() {
		
		calcMonthlyGross();
		taxDeduction();
		takehome = mgross -  tax;
		System.out.println("Monthly take home Salary for Employee Grade  " + grade + " = " + takehome);

	}

	public static void main(String[] args) {

		EmpSalary e1 = new EmpSalary(1, 7000, 5000, 2000);
		e1.calcMonthlySal();
		EmpSalary e2 = new EmpSalary(2,10000,7000,2500); 
		e2.calcMonthlySal();
		EmpSalary e3 = new EmpSalary(3,12000,9000,3000);
		e3.calcMonthlySal();
		EmpSalary e4 = new EmpSalary(4,15000,17000,4000);
		e4.calcMonthlySal();
		 
	}

}
