package model;

public record ConversionRateResponse(
        String timeLastUpdateUtc,
        String baseCode,
        String targetCode,
        double conversionResult
) {
}
