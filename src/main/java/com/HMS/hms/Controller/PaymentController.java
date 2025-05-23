package com.HMS.hms.Controller;

import com.HMS.hms.Payment.Utility.ParameterBuilder;
import com.HMS.hms.Payment.Utility.Util;
import com.HMS.hms.Payment.parametermappings.SSLCommerzInitResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URL;
import java.util.Map;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @PostMapping("/initiate")
    public ResponseEntity<?> initiatePayment() throws IOException, UnsupportedEncodingException {
        Map<String, String> params = ParameterBuilder.constructRequestParameters();
        String paramString = ParameterBuilder.getParamsString(params, true);

        String sslcommerzUrl = "https://sandbox.sslcommerz.com/gwprocess/v4/api.php";
        URL url = new URL(sslcommerzUrl + "?" + paramString);
        String response = Util.postToUrl(sslcommerzUrl, paramString);

        SSLCommerzInitResponse initResponse = Util.extractInitResponse(response);

        if ("SUCCESS".equalsIgnoreCase(initResponse.getStatus())) {
//            return ResponseEntity.status(HttpStatus.FOUND)
//                    .location(URI.create(initResponse.getGatewayPageURL()))
//                    .build();
            return ResponseEntity.ok(Map.of("redirect_url", initResponse.getGatewayPageURL()));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(initResponse.getFailedreason());
        }
    }

    @PostMapping("/ssl-success-page")
    public ResponseEntity<?> handleSuccessPost(@RequestParam Map<String, String> params) {
        String tranId = params.getOrDefault("tran_id", "unknown");
        String valId = params.getOrDefault("val_id", "unknown");

        // 🔁 Redirect to static page with query params
        String redirectUrl = "/payment-success.html?tran_id=" + tranId + "&val_id=" + valId;

        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(redirectUrl))
                .build();
    }

    // Optional GET endpoint for testing in browser
    @GetMapping("/ssl-success-page")
    @ResponseBody
    public String paymentSuccessGet() {
        return "✅ Payment Success (GET)";
    }

    // ❌ Payment Failed
    @PostMapping("/ssl-fail-page")
    @ResponseBody
    public String paymentFailPost(@RequestParam Map<String, String> allParams) {
        System.out.println("❌ Payment failed: " + allParams);
        return "❌ Payment Failed<br><br>" + allParams.entrySet().stream()
                .map(e -> e.getKey() + ": " + e.getValue())
                .reduce("", (a, b) -> a + "<br>" + b);
    }

    // ⚠️ Payment Cancelled
    @PostMapping("/ssl-cancel-page")
    @ResponseBody
    public String paymentCancelPost(@RequestParam Map<String, String> allParams) {
        System.out.println("⚠️ Payment cancelled: " + allParams);
        return "⚠️ Payment Cancelled<br><br>" + allParams.entrySet().stream()
                .map(e -> e.getKey() + ": " + e.getValue())
                .reduce("", (a, b) -> a + "<br>" + b);
    }
}
