package WebAgent;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.IncorrectnessListener;
import com.gargoylesoftware.htmlunit.WebClient;

/** Parent web driver, initializes connection properties */

public abstract class Agent {

   protected WebClient webClient;

   public Agent() {
      // initialize the agent
      init();
   }

   private void init() {
      webClient = new WebClient(BrowserVersion.FIREFOX_17); // User Agent
      webClient.getOptions().setCssEnabled(false); // Turn off CSS
      webClient.getOptions().setJavaScriptEnabled(true); // Javascript is required
      webClient.getOptions().setThrowExceptionOnScriptError(false); // Quiet error throwing
      webClient.getCookieManager().setCookiesEnabled(true); // Cookies needed
      webClient.setIncorrectnessListener(new IncorrectnessListener() { // Quiet more error throwing
         @Override
         public void notify(String arg0, Object arg1) {
         }
      });
   }
}