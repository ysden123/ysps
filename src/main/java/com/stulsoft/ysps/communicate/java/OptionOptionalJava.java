/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.ysps.communicate.java;

import java.util.Optional;

/**
 * @author Yuriy Stul
 */
public class OptionOptionalJava {
    public Optional<String> f1(boolean exists) {
        var resultFromScala = OptionOptionalEx1Service.f1(exists);
        if (resultFromScala.isDefined()) {
            return Optional.of(resultFromScala.get());
        } else {
            return Optional.empty();
        }
    }
}
