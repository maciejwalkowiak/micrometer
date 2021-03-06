/**
 * Copyright 2017 Pivotal Software, Inc.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micrometer.core.samples;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.samples.utils.SampleConfig;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Demonstrates how monitoring systems deal with NaN values coming out of gauges.
 */
public class NullGaugeSample {
    public static void main(String[] args) throws InterruptedException {
        MeterRegistry registry = SampleConfig.myMonitoringSystem();
        AtomicInteger n = new AtomicInteger(100);

        registry.gauge("my.null.gauge", (Object) null, o -> 1.0);
        registry.gauge("my.nonnull.gauge", n);

        for(;;) {
            Thread.sleep(100);
        }
    }
}
