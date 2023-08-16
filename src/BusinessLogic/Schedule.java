package BusinessLogic;

import java.time.LocalDate;

public class Schedule {
	LocalDate dateandtime;
	String the_job;
	public void settingschedule(LocalDate dandt, String thee_job) {
		this.dateandtime=dandt;
		the_job=thee_job;
	}
}
