import java.io.IOException;

import CunyFirstParser.ClassStructure;
import CunyFirstParser.containers.ClassSection;
import WebAgent.UserAgent;

/** A sample text execution of this application using typical search parameters */

public class MainClassSearch {

   public static void main(String[] args) throws IOException {
      /*
       * Initialize agent and customize your search options. The keys provided
       * here are from the HTML. More user-friendly options are coming soon...
       */
      
      UserAgent agent = new UserAgent();
      agent.setInstitution("QNS01");
      agent.setTerm("1159");
      agent.setDepartment("CSCI");

      // Submit your query.
      ClassStructure struct = agent.submitAndGetResults();

      // Get the section you are looking for.
      ClassSection lec = struct.getClassSection(0, 0);

      // Get the enrollment information, such as seats available.
      agent.attachEnrollmentInfo(lec);

      // Finish, print results.
      System.out.println(lec.inDepthDisplay());
   }
}