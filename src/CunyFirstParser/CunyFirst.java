package CunyFirstParser;

/** Data used for parsing all HTML information found on the webpages. */
public interface CunyFirst {

   // HTML id fields for important data found of CunyFirst
   public static final String instHtmlID = "CLASS_SRCH_WRK2_INSTITUTION$42$";
   public static final String termHtmlID = "CLASS_SRCH_WRK2_STRM$45$";
   public static final String deptHtmlID = "SSR_CLSRCH_WRK_SUBJECT_SRCH$0";
   public static final String nbrHtmlID = "SSR_CLSRCH_WRK_CLASS_NBR$10";
   public static final String checkboxHtmlID = "SSR_CLSRCH_WRK_SSR_OPEN_ONLY$chk$5";
   public static final String courseNumberID = "SSR_CLSRCH_WRK_SSR_EXACT_MATCH1$1";
   public static final String rangeID = "SSR_CLSRCH_WRK_CATALOG_NBR$1";
   public static final String submitCodeName = "ICAction";
   public static final String submitCodeValue = "CLASS_SRCH_WRK2_SSR_PB_CLASS_SRCH";
   public static final String submitID = "CLASS_SRCH_WRK2_SSR_PB_CLASS_SRCH";
   public static final String classCapacityID = "SSR_CLS_DTL_WRK_ENRL_CAP";
   public static final String classTotalID = "SSR_CLS_DTL_WRK_ENRL_TOT";
   public static final String availableSeatsID = "SSR_CLS_DTL_WRK_AVAILABLE_SEATS";
   public static final String goBackID = "CLASS_SRCH_WRK2_SSR_PB_BACK";
   public static final String timeID = "MTG_DAYTIME";
   public static final String roomID = "MTG_ROOM";
   public static final String instrID = "MTG_INSTR";
   public static final String openOrClosedID = "SSSIMAGECENTER";
   public static final String nbrID = "MTG_CLASS_NBR";
   public static final String lecID = "MTG_CLASSNAME";
   public static final String headingID = "win0divGPSSR_CLSRSLT_WRK_GROUPBOX2";
   public static final String cPerHeadingID = "ACE_$ICField104";

   // JSoup commands for parsing result page information
   public static String rPageFindTime = "[id^=" + timeID + "]";
   public static String rPageFindRoom = "[id^=" + roomID + "]";
   public static String rPageFindInstr = "[id^=" + instrID + "]";
   public static String rPageFindOpen = "img[class=" + openOrClosedID + "]";
   public static String rPageFindNbr = "a[id^=" + nbrID + "]";
   public static String rPageFindLecIds = "a[id^=" + lecID + "]";
   public static String rPageFindHeading = "div[id^=" + headingID + "]";
   public static String rPagePerHeading = "table[id^=" + cPerHeadingID + "]";
   
   // JSoup commands for parsing class enrollment information
   public static String findClassCapacity = "span[id=" + classCapacityID + "]";
   public static String findClassTotal = "span[id=" + classTotalID + "]";
   public static String findAvailableSeats = "span[id=" + availableSeatsID + "]";
   
   
   // Error codes which don't belong here... will move later
   public static final String longWebsiteURL = "https://hrsa.cunyfirst.cuny.edu/psc/cnyhcprd/GUEST/HRMS/c/COMMUNITY_ACCESS.CLASS_SEARCH.GBL?PortalActualURL=https%3a%2f%2fhrsa.cunyfirst.cuny.edu%2fpsc%2fcnyhcprd%2fGUEST%2fHRMS%2fc%2fCOMMUNITY_ACCESS.CLASS_SEARCH.GBL&amp;PortalContentURL=https%3a%2f%2fhrsa.cunyfirst.cuny.edu%2fpsc%2fcnyhcprd%2fGUEST%2fHRMS%2fc%2fCOMMUNITY_ACCESS.CLASS_SEARCH.GBL&amp;PortalContentProvider=HRMS&amp;PortalCRefLabel=Class%20Search&amp;PortalRegistryName=GUEST&amp;PortalServletURI=https%3a%2f%2fhome.cunyfirst.cuny.edu%2fpsp%2fcnyepprd%2f&amp;PortalURI=https%3a%2f%2fhome.cunyfirst.cuny.edu%2fpsc%2fcnyepprd%2f&amp;PortalHostNode=ENTP&amp;NoCrumbs=yes";
   public static final String errorMessage = "There seems to be a connection issue with CUNYFirst.\nTry again, or come back later.";
   public static final String nullResultsReturnedError = "There was either a communication error with CUNYFirst or\nthe search returned no results that matched the criteria specified.";
}