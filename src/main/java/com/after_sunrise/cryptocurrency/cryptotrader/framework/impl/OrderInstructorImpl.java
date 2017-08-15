package com.after_sunrise.cryptocurrency.cryptotrader.framework.impl;

import com.after_sunrise.cryptocurrency.cryptotrader.core.ServiceFactory;
import com.after_sunrise.cryptocurrency.cryptotrader.framework.Context;
import com.after_sunrise.cryptocurrency.cryptotrader.framework.Instruction;
import com.after_sunrise.cryptocurrency.cryptotrader.framework.OrderInstructor;
import com.after_sunrise.cryptocurrency.cryptotrader.framework.PortfolioAdviser.Advice;
import com.after_sunrise.cryptocurrency.cryptotrader.framework.Trader.Request;
import com.google.inject.Inject;
import com.google.inject.Injector;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.after_sunrise.cryptocurrency.cryptotrader.framework.Trader.Request.ALL;
import static java.util.Optional.ofNullable;

/**
 * @author takanori.takase
 * @version 0.0.1
 */
@Slf4j
public class OrderInstructorImpl implements OrderInstructor {

    private static final List<Instruction> EMPTY = Collections.emptyList();

    private final Map<String, OrderInstructor> instructors;

    @Inject
    public OrderInstructorImpl(Injector injector) {
        this.instructors = injector.getInstance(ServiceFactory.class).loadMap(OrderInstructor.class);
    }

    @Override
    public String get() {
        return ALL;
    }

    @Override
    public List<Instruction> instruct(Context context, Request request, Advice advice) {

        if (!Request.isValid(request)) {

            log.trace("Invalid request : {}", request);

            return Collections.emptyList();

        }

        OrderInstructor instructor = instructors.get(request.getSite());

        if (instructor == null) {

            log.debug("Instructor not found for site : {}", request.getSite());

            return Collections.emptyList();

        }

        List<Instruction> instructions = ofNullable(instructor.instruct(context, request, advice)).orElse(EMPTY);

        log.debug("Instructions : {}", instructions.size());

        return instructions;

    }

}
