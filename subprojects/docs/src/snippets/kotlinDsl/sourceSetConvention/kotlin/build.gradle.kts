// tag::source-set-convention[]
plugins {
    groovy
}

sourceSets {
    main {
        withExtension(GroovySourceSet::class) {
            groovy.srcDir("src/core/groovy")
        }
    }
}
// end::source-set-convention[]
