import CunyFirstParser.ClassStructure;
import CunyFirstParser.containers.ClassSection;
import WebAgent.UserAgent;

public class MainClassSearch {

   public static void main(String[] args) {
      /*
       * Initialize agent and customize your search options. The keys provided
       * here are from the HTML. More user-friendly options coming soon...
       */
      UserAgent agent = new UserAgent();
      agent.setInstitution("QNS01");
      agent.setTerm("1152");
      agent.setDepartment("CSCI");
      agent.setClassNBR("63584");

      // Submit your query.
      ClassStructure struct = agent.submitAndGetResults();

      // Choose the section you are looking for.
      ClassSection lec = struct.getClassSection(0, 0);

      // Get the enrollment information, such as seats available.
      agent.attachEnrollmentInfo(lec);

      // Finish, print results.
      System.out.println(lec.inDepthDisplay());
   }
}