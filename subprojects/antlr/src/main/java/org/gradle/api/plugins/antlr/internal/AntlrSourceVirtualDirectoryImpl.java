/*
 * Copyright 2010 the original author or authors.
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
package org.gradle.api.plugins.antlr.internal;

import groovy.lang.Closure;
import org.gradle.api.Action;
import org.gradle.api.file.SourceDirectorySet;
import org.gradle.api.internal.file.DefaultSourceDirectorySet;
import org.gradle.api.internal.file.FileCollectionFactory;
import org.gradle.api.internal.file.collections.DirectoryFileTreeFactory;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.plugins.antlr.AntlrSourceVirtualDirectory;
import org.gradle.api.reflect.HasPublicType;
import org.gradle.api.reflect.TypeOf;
import org.gradle.api.tasks.util.PatternSet;
import org.gradle.internal.Factory;
import org.gradle.util.internal.ConfigureUtil;

import static org.gradle.api.reflect.TypeOf.typeOf;

/**
 * The implementation of the {@link org.gradle.api.plugins.antlr.AntlrSourceVirtualDirectory} contract.
 */
public class AntlrSourceVirtualDirectoryImpl extends DefaultSourceDirectorySet implements AntlrSourceVirtualDirectory, HasPublicType {

    public AntlrSourceVirtualDirectoryImpl(String parentDisplayName, ObjectFactory objectFactory, Factory<PatternSet> patternSetFactory, FileCollectionFactory fileCollectionFactory, DirectoryFileTreeFactory directoryFileTreeFactory) {
        super(parentDisplayName + ".antlr", parentDisplayName + " Antlr source", patternSetFactory, fileCollectionFactory, directoryFileTreeFactory, objectFactory);
        getFilter().include("**/*.g");
        getFilter().include("**/*.g4");
    }

    @Override
    public SourceDirectorySet getAntlr() {
        return this;
    }

    @Override
    @SuppressWarnings("rawtypes")
    public AntlrSourceVirtualDirectory antlr(Closure configureClosure) {
        ConfigureUtil.configure(configureClosure, getAntlr());
        return this;
    }

    @Override
    public AntlrSourceVirtualDirectory antlr(Action<? super SourceDirectorySet> configureAction) {
        configureAction.execute(getAntlr());
        return this;
    }

    @Override
    public TypeOf<?> getPublicType() {
        return typeOf(AntlrSourceVirtualDirectory.class);
    }
}
