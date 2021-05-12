/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.api.internal;

import org.gradle.api.plugins.Convention;

/**
 * Demarcates objects that expose a convention.
 *
 * Convention objects aren't going to be around forever, so this is a temporary interface.
 *
 * @deprecated The concept of conventions are considered as legacy. All usages should be replaced with extensions (see {@link org.gradle.api.plugins.ExtensionAware#getExtensions()}). This interface is scheduled for removal in Gradle 8.0.
 */
@Deprecated
public interface HasConvention {

    Convention getConvention();

}
