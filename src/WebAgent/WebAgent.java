package WebAgent;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import CunyFirstParser.CunyFirst;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public abstract class WebAgent extends Agent {

   protected HtmlPage page;
   protected WebRequest requestSettings;

   public WebAgent() {
      super();
      loadPage();
      updatePage();
   }

   private void loadPage() {
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

   protected void waitForBackground() {
      webClient.waitForBackgroundJavaScript(1000 * 60);
   }
}