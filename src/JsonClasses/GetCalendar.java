package JsonClasses;
public class GetCalendar implements java.io.Serializable {

		private static final long serialVersionUID = 1L;
		private String overallID = "getCalendar";
		private String cbsID;
		
		//Getters and setters for everything, bitch
		public String getOverallID() {
			return overallID;
		}
		public void setOverallID(String overallID) {
			this.overallID = overallID;
		}
		public String getcbsID() {
			return cbsID;
		}
		public void setcbsID(String cbsID) {
			this.cbsID = cbsID;
		}

}