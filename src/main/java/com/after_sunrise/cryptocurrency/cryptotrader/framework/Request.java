package com.after_sunrise.cryptocurrency.cryptotrader.framework;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.Set;

import static lombok.AccessLevel.PRIVATE;

/**
 * @author takanori.takase
 * @version 0.0.1
 */
@Getter
@Builder
@ToString
@AllArgsConstructor(access = PRIVATE)
public class Request {

    private String site;

    private String instrument;

    private Instant currentTime;

    private Instant targetTime;

    private BigDecimal tradingSpread;

    private BigDecimal tradingSpreadAsk;

    private BigDecimal tradingSpreadBid;

    private BigDecimal tradingSigma;

    private BigDecimal tradingExposure;

    private BigDecimal tradingAversion;

    private Integer tradingSplit;

    private Duration tradingDuration;

    private BigDecimal fundingOffset;

    private Map<String, Set<String>> hedgeProducts;

}
