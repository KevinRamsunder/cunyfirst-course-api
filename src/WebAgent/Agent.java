package WebAgent;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.IncorrectnessListener;
import com.gargoylesoftware.htmlunit.WebClient;

public abstract class Agent {

   protected WebClient webClient;

   public Agent() {
      init();
   }

   private void init() {
      webClient = new WebClient(BrowserVersion.FIREFOX_17);
      webClient.getOptions().setCssEnabled(false);
      webClient.getOptions().setJavaScriptEnabled(true);
      webClient.getOptions().setThrowExceptionOnScriptError(false);
      webClient.getCookieManager().setCookiesEnabled(true);
      webClient.setIncorrectnessListener(new IncorrectnessListener() {
         @Override
         public void notify(String arg0, Object arg1) {
         }
      });
   }
}