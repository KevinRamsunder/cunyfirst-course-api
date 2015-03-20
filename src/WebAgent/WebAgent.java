package WebAgent;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

import CunyFirstParser.CunyFirst;
import CunyFirstParser.containers.ClassSection;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.util.NameValuePair;

/**
 * Responsible for sending request parameters and retrieving
 * information from website.
 */

public abstract class WebAgent extends Agent {

   protected HtmlPage page; // webpage
   protected WebRequest requestSettings; // HTTP request parameters

   public WebAgent() {
      super();
      loadPage(); // load the main URL
      updatePage(); // use requestSettings to get results
   }

   private void loadPage() {
      // Process a HTTP POST request and get header information
      try {
         requestSettings = new WebRequest(new URL(CunyFirst.longWebsiteURL),
               HttpMethod.POST);
      } catch (MalformedURLException e1) {
         e1.printStackTrace();
      }
      requestSettings.setRequestParameters(new ArrayList());
   }

   /**
    * Use current HTML request parameters to update page.
    */
   protected void updatePage() {
      try {
         page = webClient.getPage(requestSettings);
      } catch (FailingHttpStatusCodeException | IOException e) {
         e.printStackTrace();
      }
      waitForBackground();
   }

   /**
    * This method produces a htmlPage based on the given WebRequest. This method
    * does this operation separately, it does not change the original htmlPage
    * or WebRequest.
    * 
    * @param newRequestSettings
    * @return new HtmlPage.
    */
   protected HtmlPage newlyGeneratedPage(WebRequest newRequestSettings) {
      HtmlPage newPage = null;
      try {
         newPage = webClient.getPage(newRequestSettings);
      } catch (FailingHttpStatusCodeException | IOException e) {
         e.printStackTrace();
      }
      waitForBackground();
      return newPage;
   }

   /** Extract necessary HTTP request parameters from HTML form */
   protected WebRequest getWebRequestData() {
      HtmlForm win0 = page.getFormByName("win0");
      return win0.getWebRequest(null);
   }
   
   protected void waitForBackground() {
      webClient.waitForBackgroundJavaScript(1000 * 60);
   }
   
   /** Manipulating HTTP header parameters to extract data from webpage */
   protected HtmlPage clickClass(ClassSection section) {
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

   /** More manipulation of HTTP header parameters to extract data from result page */
   protected void submitQueryToWebpage() {
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

      updatePage(); // refresh with updated html code
   }
}