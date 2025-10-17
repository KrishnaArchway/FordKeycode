package com.archway.estore.util;

import com.archway.estore.common.ConfigurationServlet;
import com.archway.estore.common.Logger;
import com.archway.estore.wslx.ADFSCookieBean;
import com.archway.estore.wslx.CollectCookieInformationBean;
import com.ford.ito.jwt.JWTException;
import com.ford.ito.jwt.JWTPublicKey;
import com.ford.ito.jwt.JWTToken;
import com.ford.ito.jwt.JWTTokenValidatorOAuth2;
import com.ford.ito.jwt.JWTValidatorFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ADFSValidationTest {
   private static Logger logger = Logger.getLogger(ADFSValidationTest.class);
   private String s_jwtToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6Ikd3YjFRYXJpZUxpYThjQUZWS3A2ZGZBUkhMRSIsImtpZCI6Ikd3YjFRYXJpZUxpYThjQUZWS3A2ZGZBUkhMRSJ9.eyJhdWQiOiJ1cm46YXJjaHdheXZlaGljbGVvd25lcnNoaXA6cmVzb3VyY2U6d2ViX3ZlaGljbGVfb3duZXJzaGlwOnFhIiwiaXNzIjoiaHR0cHM6Ly9jb3JwcWEuc3RzLmZvcmQuY29tL2FkZnMvc2VydmljZXMvdHJ1c3QiLCJpYXQiOjE3NTA2ODEyMjgsIm5iZiI6MTc1MDY4MTIyOCwiZXhwIjoxNzUwNjg0ODI4LCJDb21tb25OYW1lIjoiZy1zaW1zMTEiLCJzdWIiOiJnLXNpbXMxMSIsInVzZXJpZCI6Imctc2ltczExIiwic2l0ZWNvZGUiOiJBUksyMyIsImNvdW50cnkiOiJVU0EiLCJBQ0lHUk9VUCI6Ik90aGVyIiwic3ViamVjdGlkIjoiZy1zaW1zMTFAZm9yZC5jb20iLCJhcHB0eXBlIjoiUHVibGljIiwiYXBwaWQiOiJ1cm46YXJjaHdheXZlaGljbGVvd25lcnNoaXA6Y2xpZW50aWQ6d2ViX3ZlaGljbGVfb3duZXJzaGlwOnFhIiwiYXV0aG1ldGhvZCI6InVybjpNRkE6dHJ1ZSIsImF1dGhfdGltZSI6IjIwMjUtMDYtMjNUMTI6MjU6MjcuMDYyWiIsInZlciI6IjEuMCJ9.nN9HAWR2RlZSLLwqxY8ork0Im5CcovEVjf2gYc0bDwj2GBAQdauh5Awj0N8CYC9UEK7G1DHErazsS7zXw-JMyr-RsjY1hzSqHgPmfh3_mFCwxzSHwTLmcwxx4Fi1P5ZQlIOHD984js6kub7r_lvpsipUafYeuwZwfib9u0Lol_DeG8oti-24AfLYXTB41TA89eRU29EVprEVXjC-ieboEc9U_HfoAQ1BAe_0GY4qCq9wQmplAd5p4-mag7Ee10SaKQ2YF1P5M5PwvkJFULAovDj13Ak8FGuRwbfw3IUHxo7c_cHuaNmcbgbZoOvmGC6Ln__PaLQKYDSxUkSs9LNAGQ";
   private List<String> l_publicKeys = new ArrayList();
   private String s_audience = "";

   public ADFSValidationTest(String jwtToken) {
      this.s_jwtToken = jwtToken;
      logger.warn("this.s_jwtToken ==== > " + this.s_jwtToken);
      //eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6Ikd3YjFRYXJpZUxpYThjQUZWS3A2ZGZBUkhMRSIsImtpZCI6Ikd3YjFRYXJpZUxpYThjQUZWS3A2ZGZBUkhMRSJ9.eyJhdWQiOiJ1cm46YXJjaHdheXZlaGljbGVvd25lcnNoaXA6cmVzb3VyY2U6d2ViX3ZlaGljbGVfb3duZXJzaGlwOnFhIiwiaXNzIjoiaHR0cHM6Ly9jb3JwcWEuc3RzLmZvcmQuY29tL2FkZnMvc2VydmljZXMvdHJ1c3QiLCJpYXQiOjE3NTA3NTkwNjMsIm5iZiI6MTc1MDc1OTA2MywiZXhwIjoxNzUwNzYyNjYzLCJDb21tb25OYW1lIjoiZy1zaW1zMTEiLCJzdWIiOiJnLXNpbXMxMSIsInVzZXJpZCI6Imctc2ltczExIiwic2l0ZWNvZGUiOiJBUksyMyIsImNvdW50cnkiOiJVU0EiLCJBQ0lHUk9VUCI6Ik90aGVyIiwic3ViamVjdGlkIjoiZy1zaW1zMTFAZm9yZC5jb20iLCJhcHB0eXBlIjoiUHVibGljIiwiYXBwaWQiOiJ1cm46YXJjaHdheXZlaGljbGVvd25lcnNoaXA6Y2xpZW50aWQ6d2ViX3ZlaGljbGVfb3duZXJzaGlwOnFhIiwiYXV0aG1ldGhvZCI6InVybjpNRkE6dHJ1ZSIsImF1dGhfdGltZSI6IjIwMjUtMDYtMjRUMTA6MDI6NDEuNDQyWiIsInZlciI6IjEuMCJ9.mnYGmNupue4QUpM5CwLm2VYFOibq3uckza8fPwTSVLsTzz3LA8nBUKCdc06gjlsZH3dOL4vCnSQxlTndIsJoAZQyNGM3rCzSoSX6PJ_1V2A3g5ZfS22_6vQ9UKJPVk2Y_HS1oFPyPlzbz-C1w0UNSDld6gtf6GopIDgipTP1fMwRgRx7TKGrAIcNMPa0hqFuktlTPXzJjHX2Ud6HEpdPC3PmF3GzoCeCz8zIkcTcWFB3lywu9YUA5pW5BUVgOdj7DJKvjphEik3_kGwxQzz8FoMII0-R7JhuQV3ou6zJDHu27qEY3Damgisy0CF9ZPGdEoXNBG7V0lK3QREni2cn0w
	   //this.s_jwtToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6Ikd3YjFRYXJpZUxpYThjQUZWS3A2ZGZBUkhMRSIsImtpZCI6Ikd3YjFRYXJpZUxpYThjQUZWS3A2ZGZBUkhMRSJ9.eyJhdWQiOiJ1cm46YXJjaHdheXZlaGljbGVvd25lcnNoaXA6cmVzb3VyY2U6d2ViX3ZlaGljbGVfb3duZXJzaGlwOnFhIiwiaXNzIjoiaHR0cHM6Ly9jb3JwcWEuc3RzLmZvcmQuY29tL2FkZnMvc2VydmljZXMvdHJ1c3QiLCJpYXQiOjE3NTA2ODEyMjgsIm5iZiI6MTc1MDY4MTIyOCwiZXhwIjoxNzUwNjg0ODI4LCJDb21tb25OYW1lIjoiZy1zaW1zMTEiLCJzdWIiOiJnLXNpbXMxMSIsInVzZXJpZCI6Imctc2ltczExIiwic2l0ZWNvZGUiOiJBUksyMyIsImNvdW50cnkiOiJVU0EiLCJBQ0lHUk9VUCI6Ik90aGVyIiwic3ViamVjdGlkIjoiZy1zaW1zMTFAZm9yZC5jb20iLCJhcHB0eXBlIjoiUHVibGljIiwiYXBwaWQiOiJ1cm46YXJjaHdheXZlaGljbGVvd25lcnNoaXA6Y2xpZW50aWQ6d2ViX3ZlaGljbGVfb3duZXJzaGlwOnFhIiwiYXV0aG1ldGhvZCI6InVybjpNRkE6dHJ1ZSIsImF1dGhfdGltZSI6IjIwMjUtMDYtMjNUMTI6MjU6MjcuMDYyWiIsInZlciI6IjEuMCJ9.nN9HAWR2RlZSLLwqxY8ork0Im5CcovEVjf2gYc0bDwj2GBAQdauh5Awj0N8CYC9UEK7G1DHErazsS7zXw-JMyr-RsjY1hzSqHgPmfh3_mFCwxzSHwTLmcwxx4Fi1P5ZQlIOHD984js6kub7r_lvpsipUafYeuwZwfib9u0Lol_DeG8oti-24AfLYXTB41TA89eRU29EVprEVXjC-ieboEc9U_HfoAQ1BAe_0GY4qCq9wQmplAd5p4-mag7Ee10SaKQ2YF1P5M5PwvkJFULAovDj13Ak8FGuRwbfw3IUHxo7c_cHuaNmcbgbZoOvmGC6Ln__PaLQKYDSxUkSs9LNAGQ";
   }

   public ADFSCookieBean validateAdfsToken() {
      String methodName = "validateAdfsToken";
      logger.debug("*************************************");
      logger.entering(methodName);
      this.s_audience = ConfigurationServlet.getApplicationProperty("audience.id");
      this.l_publicKeys.add(ConfigurationServlet.getApplicationProperty("adfs.key.cert"));
      String errorMessage = "";
      ADFSCookieBean adfsCookieData = null;

      try {
         adfsCookieData = new ADFSCookieBean();
         JWTPublicKey[] jwtKeys = this.convertStringKeysToJWTPublicKeys(this.l_publicKeys);
         JWTTokenValidatorOAuth2 jwtValidator = (JWTTokenValidatorOAuth2)JWTValidatorFactory.createADFSTokenValidator(1, jwtKeys);
         logger.warn("token: " + this.s_jwtToken);
         
         JWTToken token = jwtValidator.validateToken(this.s_jwtToken, this.s_audience, true);
         
         logger.warn("--Issue Time: {0}" + token.getIssueTime().toLocaleString());
         logger.warn("--Expiration Time: {0}" + token.getExpireTime().toLocaleString());
         logger.warn("Token Status is: " + token.getValidityStatus());
         logger.warn("Token type is: " + token.getTokenType());
         logger.warn("Token Issuer is: " + token.getIssuers());
         
         logger.warn("getValidityStatus: " + token.getValidityStatus());
         if (token.getValidityStatus() == 5) {
            adfsCookieData = this.assignValuetoWSLCookie(token);
            errorMessage = "Success! Redirected";
         } else if (token.getValidityStatus() == 0) {
            logger.warn("\nNo token provided!");
            errorMessage = "No token provided!";
         } else if (token.getValidityStatus() == 1) {
            logger.warn("\nToken is invalid!");
            errorMessage = "Token is invalid!";
         } else if (token.getValidityStatus() == 2) {
            logger.warn("\nToken has expired!");
            logger.warn("--Issue Time: {0}" + token.getIssueTime().toLocaleString());
            logger.warn("--Expiration Time: {0}" + token.getExpireTime().toLocaleString());
            errorMessage = "Token has expired!";
         } else if (token.getValidityStatus() == 3) {
            logger.warn("\nToken has an invalid signature!");
            errorMessage = "Token has an invalid signature!";
         } else if (token.getValidityStatus() == 4) {
            logger.warn("\nToken has an invalid Audience!");
            errorMessage = "Token has an invalid Audience!";
         } else {
            logger.warn("Token Status is: " + token.getValidityStatus());
            errorMessage = "<p>Issue in Token Status:: " + token.getValidityStatus() + ".\nIf Status is 6, Certificate Expired.\nPlease Contact KeyCode Admin.</p>";
         }
      } catch (Exception var10) {
         logger.warn("Exception Caught: " + var10.getMessage());
         logger.warn("Exception Stack: " + var10.getStackTrace());
      } finally {
         logger.exiting(methodName);
      }

      adfsCookieData.setErrorMessage(errorMessage);
      return adfsCookieData;
   }

   public JWTPublicKey[] convertStringKeysToJWTPublicKeys(List<String> keys) throws JWTException {
      int size = keys.size();
      JWTPublicKey[] jwtPublicKeys = new JWTPublicKey[size];

      for(int i = 0; i < keys.size(); ++i) {
         JWTPublicKey key = new JWTPublicKey((String)keys.get(i));
         jwtPublicKeys[i] = key;
      }

      return jwtPublicKeys;
   }

   private ADFSCookieBean assignValuetoWSLCookie(JWTToken token) {
      ADFSCookieBean adfsCookieData = new ADFSCookieBean();
      String methodName = "assignValuetoWSLCookie";
      logger.debug("*************************************");
      logger.entering(methodName);

      try {
         adfsCookieData.setAci(token.getPayloadClaimByKeyNameAsString("ACIGROUP"));
         adfsCookieData.setOrg(token.getPayloadClaimByKeyNameAsString("sitecode"));
         adfsCookieData.setOrgCode(token.getPayloadClaimByKeyNameAsString("country"));
         adfsCookieData.setUser(token.getPayloadClaimByKeyNameAsString("userid"));
         adfsCookieData.setDivAbbr(token.getPayloadClaimByKeyNameAsString("divAbbr"));
         adfsCookieData.setEmpCode(token.getPayloadClaimByKeyNameAsString("empcode"));
         adfsCookieData.setCompany(token.getPayloadClaimByKeyNameAsString("company"));
         adfsCookieData.setIssuer(token.getPayloadClaimByKeyNameAsString("iss"));
         adfsCookieData.setIssued(String.valueOf(token.getPayloadClaimByKeyNameAsLong("iat")));
         adfsCookieData.setRole(token.getPayloadClaimByKeyNameAsString("mrrole"));
         adfsCookieData.setExpires(String.valueOf(token.getPayloadClaimByKeyNameAsLong("exp")));
      } catch (Exception var8) {
         logger.warn("Exception Caught assignValuetoWSLCookie: " + var8.getMessage());
         logger.warn("Exception Stack assignValuetoWSLCookie: " + var8.getStackTrace());
      } finally {
         logger.exiting(methodName);
      }

      return adfsCookieData;
   }

   private void displayTokenInformation(JWTToken token) {
      this.displayPayloadFromStringArray(token.getAttributesAsStringArray());
   }

   private void displayPayloadFromStringArray(Map<String, String[]> StringArrayPayloadClaims) {
      CollectCookieInformationBean cookieData = null;
      logger.warn("--- PAYLOAD CLAIMS AS STRING");

      try {
         new CollectCookieInformationBean();
         Iterator var4 = StringArrayPayloadClaims.entrySet().iterator();

         while(var4.hasNext()) {
            Entry<String, String[]> entry = (Entry)var4.next();
            String[] var8;
            int var7 = (var8 = (String[])entry.getValue()).length;

            for(int var6 = 0; var6 < var7; ++var6) {
               String value = var8[var6];
               logger.warn((String)entry.getKey() + " = " + value);
            }
         }
      } catch (Exception var9) {
         logger.warn("EXCEPTION Parsing String Array Payload: ex.getMessage()");
      }

      logger.warn("");
   }
}