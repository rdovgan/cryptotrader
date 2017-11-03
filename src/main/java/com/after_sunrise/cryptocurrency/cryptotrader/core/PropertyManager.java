package com.after_sunrise.cryptocurrency.cryptotrader.core;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.Set;

/**
 * @author takanori.takase
 * @version 0.0.1
 */
public interface PropertyManager {

    Instant getNow();

    String getVersion();

    Duration getTradingInterval();

    Integer getTradingThreads();

    Map<String, Set<String>> getTradingTargets();

    Boolean getTradingActive(String site, String instrument);

    Integer getTradingFrequency(String site, String instrument);

    BigDecimal getTradingSpread(String site, String instrument);

    BigDecimal getTradingSpreadAsk(String site, String instrument);

    BigDecimal getTradingSpreadBid(String site, String instrument);

    BigDecimal getTradingSigma(String site, String instrument);

    BigDecimal getTradingExposure(String site, String instrument);

    BigDecimal getTradingAversion(String site, String instrument);

    BigDecimal getTradingSplit(String site, String instrument);

    Duration getTradingDuration(String site, String instrument);

    BigDecimal getFundingOffset(String site, String instrument);

    Map<String, Set<String>> getHedgeProducts(String site, String instrument);

    Set<String> getEstimators(String site, String instrument);

}
