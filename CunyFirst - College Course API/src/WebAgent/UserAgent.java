package WebAgent;

import java.util.List;

import CunyFirstParser.ClassStructure;
import CunyFirstParser.CunyFirst;
import CunyFirstParser.MainParser;
import CunyFirstParser.containers.ClassSection;
import CunyFirstParser.containers.EnrollmentInfo;
import CunyFirstParser.parsers.EnrollmentInfoParser;

import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSelect;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import com.gargoylesoftware.htmlunit.util.NameValuePair;

public class UserAgent extends SearchAgent {

   public UserAgent() {
      super();
   }

   public void setInstitution(String institutionKey) {
      HtmlSelect institution = getHtmlSelectElement(CunyFirst.instHtmlID);
      setHtmlSelectElementValue(institution, institutionKey);
      waitForBackground();
   }

   public void setDepartment(String departmentKey) {
      HtmlSelect department = getHtmlSelectElement(CunyFirst.deptHtmlID);
      setHtmlSelectElementValue(department, departmentKey);
      waitForBackground();
   }

   public void setTerm(String termKey) {
      HtmlSelect term = getHtmlSelectElement(CunyFirst.termHtmlID);
      setHtmlSelectElementValue(term, termKey);
      waitForBackground();
   }

   public void setClassNBR(String classNumber) {
      HtmlTextInput classNumberField = getHtmlTextInput(CunyFirst.nbrHtmlID);
      classNumberField.setText(classNumber);
      waitForBackground();
   }

   private void showClosedClasses() {
      HtmlSelect courseNum = getHtmlSelectElement(CunyFirst.courseNumberID);
      HtmlTextInput classNumberField = getHtmlTextInput(CunyFirst.rangeID);
      setHtmlSelectElementValue(courseNum, "G");
      classNumberField.setText(Integer.toString(0));
      waitForBackground();
   }

   public void attachEnrollmentInfo(ClassSection section) {
      HtmlPage resultPage = this.clickClass(section);
      String xml = resultPage.asXml();
      EnrollmentInfoParser infoParser = new EnrollmentInfoParser(xml);
      section.attachEnrollmentInfo(new EnrollmentInfo(infoParser));
   }

   private HtmlPage clickClass(ClassSection section) {
      WebRequest requestSettings = getWebRequestData();
      List<NameValuePair> list = requestSettings.getRequestParameters();
      NameValuePair clickCode = new NameValuePair("ICAction",
            section.getHtmlKey());

      for (int i = 0; i < list.size(); ++i) {
         String checkName = list.get(i).getName();
         if (checkName.equalsIgnoreCase("ICAction")) {
            requestSettings.getRequestParameters().set(i, clickCode);
            break;
         }
      }

      return newlyGeneratedPage(requestSettings);
   }

   public ClassStructure submitAndGetResults() {
      submit();
      MainParser parser = new MainParser(page.asXml());
      return parser.getClassStructure();
   }

   private void submit() {
      showClosedClasses();
      requestSettings = getWebRequestData();
      List<NameValuePair> list = requestSettings.getRequestParameters();

      NameValuePair submitCode = new NameValuePair(CunyFirst.submitCodeName,
            CunyFirst.submitCodeValue);
      NameValuePair checkBoxCode = new NameValuePair(CunyFirst.checkboxHtmlID,
            "N");

      for (int i = 0; i < list.size(); ++i) {
         String checkName = list.get(i).getName();

         if (checkName.equalsIgnoreCase("ICAction")) {
            requestSettings.getRequestParameters().set(i, submitCode);
         }

         if (checkName.equalsIgnoreCase(CunyFirst.checkboxHtmlID)) {
            requestSettings.getRequestParameters().set(i, checkBoxCode);
         }
      }

      // submit with updated html code
      updatePage();
   }
}