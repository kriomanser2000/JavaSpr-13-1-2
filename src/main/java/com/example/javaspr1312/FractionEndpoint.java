package com.example.javaspr1312;

import com.example.fractions.service.FractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class FractionEndpoint
{
    private static final String NAMESPACE_URI = "http://example.com/fractions";
    @Autowired
    private FractionService fractionService;
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "FractionOperationRequest")
    @ResponsePayload
    public FractionOperationResponse handleFractionOperation(@RequestPayload FractionOperationRequest request) {
        int[] result = new int[2];
        switch (request.getOperation())
        {
            case "add":
                result = fractionService.add(request.getNumerator1(), request.getDenominator1(),
                        request.getNumerator2(), request.getDenominator2());
                break;
            case "subtract":
                result = fractionService.subtract(request.getNumerator1(), request.getDenominator1(),
                        request.getNumerator2(), request.getDenominator2());
                break;
            case "multiply":
                result = fractionService.multiply(request.getNumerator1(), request.getDenominator1(),
                        request.getNumerator2(), request.getDenominator2());
                break;
            case "divide":
                result = fractionService.divide(request.getNumerator1(), request.getDenominator1(),
                        request.getNumerator2(), request.getDenominator2());
                break;
            case "simplify":
                result = fractionService.simplify(request.getNumerator1(), request.getDenominator1());
                break;
            default:
                throw new IllegalArgumentException("Unsupported operation: " + request.getOperation());
        }
        FractionOperationResponse response = new FractionOperationResponse();
        response.setResultNumerator(result[0]);
        response.setResultDenominator(result[1]);
        return response;
    }
}
