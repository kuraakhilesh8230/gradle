plugins{
    groovy
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.codehaus.groovy:groovy:2.4.15")
    testImplementation("junit:junit:4.13")
}

// tag::custom-source-locations[]
sourceSets {
    main {
        withExtension(GroovySourceSet::class) {
            groovy {
                setSrcDirs(listOf("src/groovy"))
            }
        }
    }

    test {
        withExtension(GroovySourceSet::class) {
            groovy {
                setSrcDirs(listOf("test/groovy"))
            }
        }
    }
}
// end::custom-source-locations[]
